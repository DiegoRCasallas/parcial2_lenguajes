# Analizador Sintáctico Ascendente

Este proyecto implementa un analizador sintáctico ascendente SLR(1) en Python, diseñado para reconocer expresiones aritméticas basadas en una gramática.
El código incluye las etapas de un analizador: cálculo de conjuntos primeros, siguientes, construcción del autómata LR(0) y generación de la tabla SLR(1) para el análisis sintáctico.


## Descripción General

El analizador evalúa expresiones del tipo:
```
id + id * ( id + id )
```

Según la siguiente gramática original:
```
E → E + T | T
T → T * F | F
F → ( E ) | id
```

Esta gramática tiene recursividad por la izquierda, por lo que se transforma a una versión sin recursión izquierda:
```
E → T E’
E’ → + T E’ | ε
T → F T’
T’ → * F T’ | ε
F → ( E ) | id
```



##  Estructura del Código

### Carga y Tokenización

Funciones:
- **`load(path)`**: lee el contenido de un archivo con una expresión a analizar.
- **`tok(s)`**: convierte la cadena en una lista de **tokens**, agregando el símbolo final `$`.

Ejemplo:
```
id + id * id  →  ['id', '+', 'id', '*', 'id', '$']
```
⃣###Definición de la Gramática
La gramática se define como un diccionario G, donde cada producción tiene un índice numérico:

```
G = {
    0: ("S'", ['E']),
    1: ('E',  ['T', 'E\'']),
    2: ('E\'', ['+', 'T', 'E\'']),
    3: ('E\'', []),
    4: ('T',  ['F', 'T\'']),
    5: ('T\'', ['*', 'F', 'T\'']),
    6: ('T\'', []),
    7: ('F',  ['(', 'E', ')']),
    8: ('F',  ['id'])
}
```

###Cálculo de Conjuntos primeros y siguientes
primero(G): obtiene los símbolos terminales que pueden aparecer al inicio de las producciones.

siguiente(G, primero): obtiene los símbolos que pueden aparecer inmediatamente después de un no terminal.

Estos conjuntos son esenciales para definir los movimientos de reducción en la tabla SLR(1).

Ejemplo de salida:

```
Primeros
E  = { (, id }
T  = { (, id }
E' = { +, ε }
T' = { *, ε }
F  = { (, id }
```
```
Siguientes
E  = { ), $ }
T  = { +, ), $ }
E' = { ), $ }
T' = { +, ), $ }
F  = { +, *, ), $ }
```
        
###Construcción del Autómata LR(0)
Se generan los estados del autómata mediante los conjuntos de ítems LR(0):

cerradura(items): calcula la cerradura de un conjunto de ítems.

ir_a(items, símbolo): determina la transición al consumir un símbolo.

Estos estados y transiciones se usan para construir la tabla de análisis SLR(1).

###Creación de la Tabla SLR(1)
Se crean dos estructuras principales:

accion → define las operaciones shift, reduce, accept o error según el símbolo actual.

ir_a_tabla → define las transiciones para los símbolos no terminales.

La tabla combina información del autómata LR(0) y los conjuntos FOLLOW.

###Clase AnalizadorSLR
Implementa el algoritmo de análisis sintáctico ascendente basado en pila.

Funcionamiento general:

Se inicia con la pila en estado 0 y la cadena de entrada con $.

Se consulta la acción a realizar según el estado y el símbolo actual.

Dependiendo del resultado:

shift → se apila el símbolo y el nuevo estado.

reduce → se desapilan símbolos y se aplica la producción correspondiente.

accept → la cadena pertenece al lenguaje.

error → la cadena no pertenece a la gramática.
