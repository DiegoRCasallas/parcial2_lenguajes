# Comparación de Algoritmos de Parsing: CYK vs Predictivo LL(1)

# Comparación de Algoritmos de Parsing: CYK vs Predictivo LL(1)
## ver en colab la ejecucion:

https://colab.research.google.com/drive/1lTcz_hkpAX4ICw0XDnLe3l9v1YglzYJi?usp=sharing

## Descripción General

La implementación del los algoritmos compara el rendimiento de análisis sintáctico (parsing) de los compiladores:

- El algoritmo CYK (Cocke-Younger-Kasami), que trabaja con gramáticas en Forma Normal de Chomsky (CNF) y realiza un análisis ascendente.
- El parser predictivo LL(1), que realiza un análisis descendente mediante una tabla de predicción y una pila de análisis.

El objetivo principal del proyecto es medir y comparar el rendimiento en tiempo y memoria de ambos métodos frente a diferentes niveles de complejidad de entrada, además de visualizar gráficamente las diferencias.

## Estructura del Código

El programa está estructurado en tres clases principales y una función auxiliar para medir el uso de memoria.

### 1. Función uso_memoria(funcion_objetivo)

- Simula el comportamiento del módulo memory_profiler.memory_usage utilizando tracemalloc para obtener el uso máximo de memoria (en MB) durante la ejecución de una función determinada.
- Permite medir la cantidad de memoria utilizada por cada parser durante el análisis de una cadena de entrada.

### 2. Clase AnalizadorCYK

Implementa el algoritmo CYK, que evalúa si una cadena puede ser generada por una gramática libre de contexto en Forma Normal de Chomsky (CNF).

#### Características:

- Convierte una gramática dada a CNF.
- Construye una tabla triangular donde cada celda almacena los posibles símbolos no terminales que pueden derivar una subcadena del input.
- Determina si la cadena pertenece al lenguaje de la gramática verificando si el símbolo inicial está presente en la celda superior derecha de la tabla.

#### Complejidad:
El algoritmo CYK tiene una complejidad temporal de O(n³), donde n es la longitud de la cadena de entrada.

### 3. Clase AnalizadorPredictivo

Implementa un parser descendente LL(1), que utiliza una tabla de predicción construida a partir de los conjuntos First y Follow.

#### Características:
- Elimina recursión por izquierda.
- Calcula los conjuntos First y Follow de cada no terminal.
- Construye la tabla de análisis predictivo.
- Utiliza una pila de símbolos y un puntero de entrada para simular el proceso de análisis descendente.

#### Complejidad:
El parser predictivo tiene una complejidad temporal de O(n), lo que lo hace mucho más eficiente en tiempo que el algoritmo CYK, aunque requiere que la gramática sea LL(1).

### 4. Clase ComparadorDeRendimiento

Realiza la comparación práctica entre ambos parsers mediante distintos casos de prueba y genera los resultados.

Funciones principales:

obtener_gramatica_prueba():
Define una gramática sencilla para expresiones aritméticas.

generar_casos_prueba():
Crea varias cadenas de entrada con diferentes niveles de complejidad (simple, media, compleja, muy compleja y extremadamente compleja).

medir_rendimiento():
Ejecuta ambos analizadores sobre cada caso de prueba y mide:

Tiempo de ejecución

Uso máximo de memoria

graficar_comparacion(resultados):
Genera gráficos comparativos utilizando matplotlib para:

- Tiempo de ejecución
- Uso de memoria
- Ratio de rendimiento CYK/Predictivo
- Complejidad teórica O(n³) vs O(n)


generar_tabla_comparativa(resultados):
Muestra en consola una tabla con resultados detallados de tiempo, memoria y ratios de comparación.


TABLA COMPARATIVA de resultados 


Caso                CYK Tiempo(s)     Predictivo Tiempo(s)  Ratio     CYK Mem(MB)   
--------------------------------------------------------------------------------
simple              0.000039          0.000015              2.58      0.00          
medio               0.000047          0.000011              4.38      0.01          
complejo            0.000057          0.000016              3.60      0.01          
muy_complejo        0.000170          0.000019              8.89      0.03          
extremo             0.000935          0.000055              16.97     0.08   

