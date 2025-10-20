import time
import tracemalloc
import matplotlib.pyplot as plt
import numpy as np
from copy import deepcopy

def uso_memoria(target):
    # Mide el pico de uso de memoria en MB durante la ejecución de target.
    if isinstance(target, tuple) and len(target) >= 1:
        func = target[0]
        args = target[1] if len(target) >= 2 else ()
        kwargs = target[2] if len(target) >= 3 else {}
    elif callable(target):
        func = target
        args = ()
        kwargs = {}
    else:
        raise TypeError("target debe ser (func, args) o callable")

    tracemalloc.stop()
    tracemalloc.clear_traces()
    tracemalloc.start()
    try:
        func(*args, **kwargs)
    finally:
        _, pico = tracemalloc.get_traced_memory()
        tracemalloc.stop()
    pico_mb = pico / (1024 * 1024)
    return [pico_mb]

class ParserCYK:
    def __init__(self, gramatica):
        self.gramatica_original = deepcopy(gramatica)
        self.gramatica_cnf = self.convertir_a_fnc(self.gramatica_original)

    def convertir_a_fnc(self, gramatica):
        # Convierte la gramática a Forma Normal de Chomsky (CNF).
        cnf = deepcopy(gramatica)
        contador_aux = 0
        reemplazos = {}  
        for cabeza, cuerpos in list(cnf.items()):
            nuevos_cuerpos = []
            for cuerpo in cuerpos:
                if len(cuerpo) >= 2:
                    nuevo_cuerpo = []
                    for simbolo in cuerpo:
                        if simbolo.islower() or (not simbolo.isalpha()) or simbolo in ['id', '+', '*', '(', ')']:
                            if simbolo not in reemplazos:
                                aux = f"T_{contador_aux}"
                                contador_aux += 1
                                reemplazos[simbolo] = aux
                                cnf.setdefault(aux, []).append([simbolo])
                            nuevo_cuerpo.append(reemplazos[simbolo])
                        else:
                            nuevo_cuerpo.append(simbolo)
                    nuevos_cuerpos.append(nuevo_cuerpo)
                else:
                    nuevos_cuerpos.append(cuerpo)
            cnf[cabeza] = nuevos_cuerpos
        cambios = True
        while cambios:
            cambios = False
            for cabeza, cuerpos in list(cnf.items()):
                nuevos = []
                for cuerpo in cuerpos:
                    if len(cuerpo) > 2:
                        cambios = True
                        prev = cuerpo[0]
                        resto = cuerpo[1:]
                        while len(resto) > 1:
                            aux = f"X_{contador_aux}"
                            contador_aux += 1
                            cnf.setdefault(aux, []).append([resto[0], resto[1]] if len(resto) >= 2 else [resto[0]])
                            prev = prev
                            resto = [aux] + resto[2:]
                        symbols = cuerpo[:]
                        Primeros = symbols[0]
                        chain = []
                        while len(symbols) > 2:
                            a = symbols.pop(0)
                            b = symbols.pop(0)
                            aux = f"X_{contador_aux}"
                            contador_aux += 1
                            cnf.setdefault(aux, []).append([a, b])
                            chain.append(aux)
                            symbols.insert(0, aux)
                        nuevos.append(symbols)
                    else:
                        nuevos.append(cuerpo)
                cnf[cabeza] = nuevos
        return cnf

    def analizar(self, entrada_tokens):
        # Implementa el algoritmo CYK.
        inicio = time.time()
        n = len(entrada_tokens)
        tabla = [[set() for _ in range(n)] for _ in range(n)] if n > 0 else []

        prod_unit = {}    
        prod_bin = []     

        for cabeza, cuerpos in self.gramatica_cnf.items():
            for cuerpo in cuerpos:
                if len(cuerpo) == 1:
                    term = cuerpo[0]
                    prod_unit.setdefault(term, set()).add(cabeza)
                elif len(cuerpo) == 2:
                    B, C = cuerpo
                    prod_bin.append((cabeza, B, C))
                else:
                    pass

        for i in range(n):
            token = entrada_tokens[i]
            if token in prod_unit:
                for A in prod_unit[token]:
                    tabla[i][i].add(A)
        for longitud in range(2, n + 1):
            for i in range(0, n - longitud + 1):
                j = i + longitud - 1
                for k in range(i, j):
                    # combinar tablas [i][k] y [k+1][j]
                    for (A, B, C) in prod_bin:
                        if B in tabla[i][k] and C in tabla[k+1][j]:
                            tabla[i][j].add(A)

        fin = time.time()
        tiempo = fin - inicio
        exito = (n > 0 and 'S' in tabla[0][n-1]) if n > 0 else False
        return exito, tiempo, tabla

class ParserPredictivo:
    # Clase para parser predictivo LL(1)
    def __init__(self, gramatica):
        self.gramatica = deepcopy(gramatica)
        self.no_terminales = list(self.gramatica.keys())
        self.terminales = self._obtener_terminales()
        self.Primeros = self.calcular_Primeros()
        self.Siguientes = self.calcular_Siguientes()
        self.tabla = self.construir_tabla_predictiva()

    def _obtener_terminales(self):
        # Obtiene el conjunto de terminales de la gramática.
        term = set()
        nts = set(self.gramatica.keys())
        for cuerpos in self.gramatica.values():
            for cuerpo in cuerpos:
                for s in cuerpo:
                    if s not in nts:
                        term.add(s)
        return sorted(term)

    def calcular_Primeros(self):
        # Cálculo iterativo de conjuntos Primeros.
        Primeros = {nt: set() for nt in self.no_terminales}
        cambiado = True
        while cambiado:
            cambiado = False
            for A in self.no_terminales:
                for cuerpo in self.gramatica[A]:
                    # cuerpo es lista de símbolos
                    if len(cuerpo) == 1 and (cuerpo[0] not in self.no_terminales):
                        if cuerpo[0] not in Primeros[A]:
                            Primeros[A].add(cuerpo[0])
                            cambiado = True
                    else:
                        añade_epsilon = True
                        for X in cuerpo:
                            if X in self.no_terminales:
                                antes = len(Primeros[A])
                                Primeros[A].update(x for x in Primeros[X] if x != 'ε')
                                if len(Primeros[A]) != antes:
                                    cambiado = True
                                if 'ε' in Primeros[X]:
                                    añade_epsilon = True
                                else:
                                    añade_epsilon = False
                                    break
                            else:
                                if X not in Primeros[A]:
                                    Primeros[A].add(X)
                                    cambiado = True
                                añade_epsilon = False
                                break
                        if añade_epsilon:
                            if 'ε' not in Primeros[A]:
                                Primeros[A].add('ε')
                                cambiado = True
        return Primeros

    def calcular_Siguientes(self):
        # Cálculo iterativo de conjuntos Siguientes.
        Siguientes = {nt: set() for nt in self.no_terminales}
        if 'S' in Siguientes:
            Siguientes['S'].add('$')
        cambiado = True
        while cambiado:
            cambiado = False
            for A in self.no_terminales:
                for cuerpo in self.gramatica[A]:
                    for i, B in enumerate(cuerpo):
                        if B in self.no_terminales:
                            beta = cuerpo[i+1:]
                            if beta:
                                Primeros_beta = set()
                                añade_epsilon = True
                                for X in beta:
                                    if X in self.no_terminales:
                                        Primeros_beta.update(x for x in self.Primeros[X] if x != 'ε')
                                        if 'ε' in self.Primeros[X]:
                                            añade_epsilon = True
                                        else:
                                            añade_epsilon = False
                                            break
                                    else:
                                        Primeros_beta.add(X)
                                        añade_epsilon = False
                                        break
                                antes = len(Siguientes[B])
                                Siguientes[B].update(Primeros_beta)
                                if len(Siguientes[B]) != antes:
                                    cambiado = True
                                if añade_epsilon:
                                    # Primeros(beta) contiene ε => Siguientes(A) -> Siguientes(B)
                                    antes = len(Siguientes[B])
                                    Siguientes[B].update(Siguientes[A])
                                    if len(Siguientes[B]) != antes:
                                        cambiado = True
                            else:
                                antes = len(Siguientes[B])
                                Siguientes[B].update(Siguientes[A])
                                if len(Siguientes[B]) != antes:
                                    cambiado = True
        return Siguientes

    def construir_tabla_predictiva(self):
      # Construye la tabla predictiva LL(1).
        tabla = {nt: {} for nt in self.no_terminales}
        for A in self.no_terminales:
            for cuerpo in self.gramatica[A]:
                Primeros_cuerpo = set()
                añade_epsilon = True
                for X in cuerpo:
                    if X in self.no_terminales:
                        Primeros_cuerpo.update(x for x in self.Primeros[X] if x != 'ε')
                        if 'ε' in self.Primeros[X]:
                            añade_epsilon = True
                        else:
                            añade_epsilon = False
                            break
                    else:
                        Primeros_cuerpo.add(X)
                        añade_epsilon = False
                        break
                for a in Primeros_cuerpo:
                    tabla[A][a] = cuerpo
                if añade_epsilon or 'ε' in Primeros_cuerpo:
                    for b in self.Siguientes[A]:
                        tabla[A][b] = cuerpo
        return tabla

    def parsear(self, entrada_tokens):
        # Implementa el análisis predictivo LL(1).
        inicio = time.time()
        pila = ['$','S']
        tokens = entrada_tokens + ['$']
        ip = 0

        while pila:
            top = pila.pop()
            current = tokens[ip]
            if top == '$' and current == '$':
                fin = time.time()
                return True, fin - inicio
            if top == current:
                ip += 1
                continue
            if top in self.no_terminales:
                if current in self.tabla[top]:
                    produccion = self.tabla[top][current]
                    if not (len(produccion) == 1 and produccion[0] == 'ε'):
                        for sym in reversed(produccion):
                            pila.append(sym)
                    continue
                else:
                    fin = time.time()
                    return False, fin - inicio
            else:
                fin = time.time()
                return False, fin - inicio
        fin = time.time()
        return False, fin - inicio


# Comparador de Rendimiento
class ComparadorRendimiento:
    # Clase que orquesta la comparación: crea parsers, genera casos, mide tiempo y memoria,
    # grafica resultados y muestra una tabla comparativa.

    def __init__(self):
        # Gramática simple para expresiones aritméticas
        self.gramatica_predictiva = {
            'S': [['E']],
            'E': [['T', "E'"]],
            "E'": [['+', 'T', "E'"], ['ε']],
            'T': [['F', "T'"]],
            "T'": [['*', 'F', "T'"], ['ε']],
            'F': [['(', 'E', ')'], ['id']]
        }
        # Para CYK podemos usar la misma gramática y convertirla a CNF dentro del ParserCYK.
        self.parser_cyk = ParserCYK(self.gramatica_predictiva)
        self.parser_predictivo = ParserPredictivo(self.gramatica_predictiva)

    def generar_casos_prueba(self):
        return {
            'simple': 'id + id',
            'medio': 'id * id + id',
            'complejo': '( id + id ) * id',
            'muy_complejo': 'id * id + id * ( id + id )',
            'extremo': '( ( id + id ) * ( id + id ) ) + ( id * id )'
        }

    def medir_rendimiento(self):
        casos = self.generar_casos_prueba()
        resultados = {
            'cyk_tiempos': [],
            'predictivo_tiempos': [],
            'cyk_memoria': [],
            'predictivo_memoria': [],
            'input_lengths': []
        }

        for nombre, entrada in casos.items():
            print(f"\nProbando: {nombre}\nInput: {entrada}")
            tokens = entrada.split()

            # Medir CYK: tiempo (retornado por método) y memoria (medimos pasando la llamada)
            cyk_exito, cyk_tiempo, _ = self.parser_cyk.analizar(tokens)
            cyk_mem = max(uso_memoria((self.parser_cyk.analizar, (tokens,))))

            # Medir Predictivo
            pred_exito, pred_tiempo = self.parser_predictivo.parsear(tokens)
            pred_mem = max(uso_memoria((self.parser_predictivo.parsear, (tokens,))))

            print(f"CYK: {cyk_tiempo:.6f}s, {cyk_mem:.2f}MB, Éxito: {cyk_exito}")
            print(f"Predictivo: {pred_tiempo:.6f}s, {pred_mem:.2f}MB, Éxito: {pred_exito}")

            resultados['cyk_tiempos'].append(cyk_tiempo)
            resultados['predictivo_tiempos'].append(pred_tiempo)
            resultados['cyk_memoria'].append(cyk_mem)
            resultados['predictivo_memoria'].append(pred_mem)
            resultados['input_lengths'].append(len(tokens))

        return resultados

    def graficar_comparacion(self, resultados):
        """
        Genera 4 gráficos:
        - tiempos empíricos
        - uso de memoria empírico
        - ratio tiempos CYK/Predictivo
        - complejidad teórica normalizada
        """
        fig, ((ax1, ax2), (ax3, ax4)) = plt.subplots(2, 2, figsize=(14, 10))
        x = range(len(resultados['input_lengths']))
        # Tiempos
        ax1.plot(x, resultados['cyk_tiempos'], label='CYK O(n³)', marker='o')
        ax1.plot(x, resultados['predictivo_tiempos'], label='Predictivo O(n)', marker='s')
        ax1.set_title('Tiempo de Ejecución')
        ax1.set_xlabel('Caso (creciente complejidad)')
        ax1.set_ylabel('Tiempo (s)')
        ax1.legend()
        ax1.grid(True)
        # Memoria
        ax2.plot(x, resultados['cyk_memoria'], marker='o', label='CYK')
        ax2.plot(x, resultados['predictivo_memoria'], marker='s', label='Predictivo')
        ax2.set_title('Uso de Memoria (pico)')
        ax2.set_xlabel('Caso')
        ax2.set_ylabel('Memoria (MB)')
        ax2.legend()
        ax2.grid(True)
        # Ratio
        ratios = []
        for c, p in zip(resultados['cyk_tiempos'], resultados['predictivo_tiempos']):
            ratios.append(c / p if p > 0 else float('inf'))
        ax3.bar(x, ratios, alpha=0.8)
        ax3.set_title('Ratio (CYK / Predictivo) en Tiempo')
        ax3.set_xlabel('Caso')
        ax3.set_ylabel('Ratio')
        ax3.grid(True)
        # Complejidad teórica
        n_vals = np.array([10, 20, 50, 100, 200])
        cyk_teor = (n_vals ** 3) * 1e-7
        pred_teor = n_vals * 1e-7
        ax4.plot(n_vals, cyk_teor, '--', label='CYK O(n³)')
        ax4.plot(n_vals, pred_teor, '--', label='Predictivo O(n)')
        ax4.set_title('Complejidad Teórica (normalizada)')
        ax4.set_xlabel('n (longitud input)')
        ax4.set_ylabel('Tiempo relativo (normalizado)')
        ax4.legend()
        ax4.grid(True)

        plt.tight_layout()
        plt.savefig('comparacion_parsers.png', dpi=300, bbox_inches='tight')
        plt.show()

    def generar_tabla_comparativa(self, resultados):
        print("\n")
        print("TABLA COMPARATIVA")
        print("\n")
        encabezado = f"{'Caso':<20}{'CYK Tiempo(s)':<18}{'Predictivo Tiempo(s)':<22}{'Ratio':<10}{'CYK Mem(MB)':<14}"
        print(encabezado)
        print("-"*80)
        casos = list(self.generar_casos_prueba().keys())
        for i, caso in enumerate(casos):
            ct = resultados['cyk_tiempos'][i]
            pt = resultados['predictivo_tiempos'][i]
            ratio = ct / pt if pt > 0 else float('inf')
            cm = resultados['cyk_memoria'][i]
            print(f"{caso:<20}{ct:<18.6f}{pt:<22.6f}{ratio:<10.2f}{cm:<14.2f}")


if __name__ == "__main__":
    comparador = ComparadorRendimiento()

    # Medir rendimiento
    resultados = comparador.medir_rendimiento()

    # Generar gráficas
    comparador.graficar_comparacion(resultados)

    # Mostrar tabla comparativa
    comparador.generar_tabla_comparativa(resultados)

    # Conclusiones simples
    avg_cyk = np.mean(resultados['cyk_tiempos'])
    avg_pred = np.mean(resultados['predictivo_tiempos'])

