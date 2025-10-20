from collections import defaultdict

def cargar(ruta):
    with open(ruta) as f:
        return f.read().strip()

# tokenizar la entrada
def tokenizar(cadena):
    tokens, i = [], 0
    while i < len(cadena):
        if cadena[i].isspace():  # ignorar espacios
            i += 1
        elif cadena[i] in '()+*$':  # símbolos individuales
            tokens.append(cadena[i])
            i += 1
        elif cadena[i:i+2] == 'id':  # identificador "id"
            tokens.append('id')
            i += 2
        else:
            raise ValueError(f"Carácter inesperado: {cadena[i]!r}")
    tokens.append('$')  # símbolo de fin de cadena
    return tokens

# Gramatica sin recursión izquierda
G = {
    0: ("S'", ['E']),
    1: ('E',  ['T', "E'"]),
    2: ("E'", ['+', 'T', "E'"]),
    3: ("E'", []),               # producción vacía
    4: ('T',  ['F', "T'"]),
    5: ("T'", ['*', 'F', "T'"]),
    6: ("T'", []),
    7: ('F',  ['(', 'E', ')']),
    8: ('F',  ['id']),
}

# Estructuras auxiliares

no_terminales = {izq for _, (izq, _) in G.items()}
producciones_por_nt = defaultdict(list)
for id_prod, (izq, der) in G.items():
    producciones_por_nt[izq].append((id_prod, tuple(der)))

# calcular conjuntos primeros 

def primeros(gramatica):
    PRIM = defaultdict(set)

    for _, (izq, der) in gramatica.items():
        if not der:
            PRIM[izq].add('Vacio')

    cambio = True
    while cambio:
        cambio = False
        for _, (izq, der) in gramatica.items():
            if not der:
                continue
            for simbolo in der:
                if simbolo not in no_terminales:
                    # terminal
                    if simbolo not in PRIM[izq]:
                        PRIM[izq].add(simbolo)
                        cambio = True
                    break
                else:
                    antes = len(PRIM[izq])
                    PRIM[izq] |= (PRIM[simbolo] - {'Vacio'})
                    if len(PRIM[izq]) != antes:
                        cambio = True
                    if 'Vacio' not in PRIM[simbolo]:
                        break
            else:
                if 'Vacio' not in PRIM[izq]:
                    PRIM[izq].add('Vacio')
                    cambio = True
    return PRIM

# calcular conjuntos siguientes

def siguientes(gramatica, PRIM):
    SIG = defaultdict(set)
    SIG["S'"].add('$')  # símbolo inicial contiene fin de cadena

    cambio = True
    while cambio:
        cambio = False
        for _, (izq, der) in gramatica.items():
            for i, simbolo in enumerate(der):
                if simbolo not in no_terminales:
                    continue

                cola = der[i+1:]

                # calcular PRIM(cola) - {Vacio}
                conjunto = set()
                if cola:
                    for t in cola:
                        if t not in no_terminales:
                            conjunto.add(t)
                            break
                        else:
                            conjunto |= (PRIM[t] - {'Vacio'})
                            if 'Vacio' not in PRIM[t]:
                                break
                    todos_epsilon = all((t in no_terminales and 'Vacio' in PRIM[t]) for t in cola)
                else:
                    todos_epsilon = True

                antes = len(SIG[simbolo])
                SIG[simbolo] |= conjunto
                if todos_epsilon:
                    SIG[simbolo] |= SIG[izq]
                if len(SIG[simbolo]) != antes:
                    cambio = True
    return SIG


# Cálculo de primeros y siguientes.

PRIM = primeros(G)
SIG = siguientes(G, PRIM)

# calcular conjunto prediccion por producción

prediccion = {}
for id_prod, (izq, der) in G.items():
    conjunto = set()
    if not der:
        conjunto |= SIG[izq]
    else:
        anulable = True
        for s in der:
            if s not in no_terminales:
                conjunto.add(s)
                anulable = False
                break
            else:
                conjunto |= (PRIM[s] - {'Vacio'})
                if 'Vacio' not in PRIM[s]:
                    anulable = False
                    break
        if anulable:
            conjunto |= SIG[izq]
    prediccion[id_prod] = conjunto

# Construcción del autómata LR(0)


def clausura(items):

    c = set(items)
    while True:
        n = len(c)
        for izq, der, punto in list(c):
            if punto < len(der):
                simbolo = der[punto]
                if simbolo in no_terminales:
                    for _, nueva_der in producciones_por_nt[simbolo]:
                        c.add((simbolo, tuple(nueva_der), 0))
        if len(c) == n:
            break
    return c

def mover(items, simbolo):
    g = {(izq, der, punto+1) for (izq, der, punto) in items if punto < len(der) and der[punto] == simbolo}
    return clausura(g) if g else set()


# Generar estados y transiciones del autómata LR(0)
estados, transicion = [], {}
estado_inicial = frozenset(clausura({("S'", tuple(['E']), 0)}))
estados.append(estado_inicial)
i = 0
while i < len(estados):
    for simbolo in list(no_terminales) + ['+', '*', '(', ')', 'id', '$']:
        sig = mover(estados[i], simbolo)
        if sig:
            f = frozenset(sig)
            if f not in estados:
                estados.append(f)
            transicion[(i, simbolo)] = estados.index(f)
    i += 1


accion, salto = {}, {}
for i, estado in enumerate(estados):
    accion[i], salto[i] = {}, {}

    for simbolo in list(no_terminales) + ['+', '*', '(', ')', 'id', '$']:
        if (i, simbolo) in transicion:
            destino = transicion[(i, simbolo)]
            if simbolo in ('+', '*', '(', ')', 'id', '$'):
                accion[i][simbolo] = ('desplazar', destino)
            else:
                salto[i][simbolo] = destino

    for izq, der, punto in estado:
        if punto == len(der):
            num_prod = next(k for k, (pl, pr) in G.items() if pl == izq and tuple(pr) == der)
            if izq == "S'":
                accion[i]['$'] = ('aceptar',)
            else:
                for simbolo in SIG[izq]:
                    accion[i][simbolo] = ('reducir', num_prod)


print("CONJUNTOS PRIMEROS")
for k in sorted(PRIM):
    print(f"{k:>3} = {{{', '.join(sorted(PRIM[k]))}}}")

print("\nCONJUNTOS SIGUIENTES")
for k in sorted(SIG):
    print(f"{k:>3} = {{{', '.join(sorted(SIG[k]))}}}")

print("\nCONJUNTOS PREDICCIÓN")
for id_prod in sorted(G):
    izq, der = G[id_prod]
    der_str = ' '.join(der) if der else 'Vacio'
    print(f"{id_prod:>2}: {izq} → {der_str:10}   prediccion = {{{', '.join(sorted(prediccion[id_prod]))}}}")


class AnalizadorSLR:
    def analizar(self, cadena):
        buffer = tokenizar(cadena)
        pila = [0]  
        while True:
            estado = pila[-1]
            simbolo = buffer[0]
            if simbolo not in accion[estado]:
                return False
            a = accion[estado][simbolo]

            if a[0] == 'desplazar':
                pila.extend([simbolo, a[1]])
                buffer.pop(0)

            elif a[0] == 'reducir':
                id_prod = a[1]
                izq, der = G[id_prod]
                if der:
                    pila = pila[:-2*len(der)]  
                estado_tope = pila[-1]
                pila.extend([izq, salto[estado_tope][izq]])


            elif a[0] == 'aceptar':
                return True
            else:
                return False

p = AnalizadorSLR()

if __name__ == '__main__':
    for n in range(1, 8):
        try:
            texto = cargar(f'test{n}.txt')
            print(f"test{n}: {'ACEPTADO' if p.analizar(texto) else 'RECHAZADO'}")
        except FileNotFoundError:
            print(f"test{n}: ARCHIVO_NO_ENCONTRADO")
