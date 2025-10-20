# 🍻 CerveSQL — Ejecución de la gramática ANTLR

Este proyecto define la gramática **CerveSQL** en el archivo `cervesql.g4`.  
El objetivo es analizar archivos con extensión `.cer`, como `test.cer`, utilizando **ANTLR 4**.

---

## 🧩 Requisitos previos

Antes de comenzar, asegúrate de tener instalado:

- **Java JDK 8 o superior**  
- **ANTLR 4**  
- (Opcional) **Python 3**, si deseas generar el parser en otro lenguaje

Puedes verificar tu instalación de Java:

```bash
java -version
```

Y si no tienes ANTLR, descárgalo:

```bash
curl -O https://www.antlr.org/download/antlr-4.13.1-complete.jar
```

Configura el **classpath** (en Linux/macOS):

```bash
export CLASSPATH=".:antlr-4.13.1-complete.jar:$CLASSPATH"
alias antlr4='java -jar antlr-4.13.1-complete.jar'
alias grun='java org.antlr.v4.gui.TestRig'
```

*(En Windows, define las variables de entorno equivalentes.)*

---

## 🚀 PASO 1: Generar el parser

Ejecuta el siguiente comando para generar los archivos del parser y lexer a partir de la gramática `cervesql.g4`:

```bash
antlr4 cervesql.g4
```

Esto generará archivos como:

- `cervesqlLexer.java`  
- `cervesqlParser.java`  
- `cervesqlBaseListener.java`  
- `cervesqlListener.java`

---

## ⚙️ PASO 2: Compilar los archivos generados

Compila todos los archivos `.java` que generó ANTLR:

```bash
javac *.java
```

Esto producirá los archivos `.class` necesarios para ejecutar el parser.

---

## 🧪 PASO 3: Ejecutar el parser sobre el archivo `test.cer`

Usa el comando `grun` (TestRig) para analizar el archivo `test.cer`.  
Debes reemplazar **`program`** por el nombre de tu **regla inicial** definida en `cervesql.g4`.

### Para mostrar el árbol en consola:
```bash
grun cervesql program test.cer
```

### Para ver el árbol en una interfaz gráfica:
```bash
grun cervesql program -gui test.cer
```

---

## 📁 PASO 4: Estructura recomendada del proyecto

```
cervesql/
├── cervesql.g4
├── test.cer
├── README.md
├── antlr-4.13.1-complete.jar
└── (archivos generados por ANTLR)
```

---

## 🧉 PASO 5: Ejemplo completo

### 📄 test.cer
```sql
SELECT nombre, tipo FROM cervezas WHERE pais = "México";
```

### 💻 Ejecución
```bash
antlr4 cervesql.g4
javac *.java
grun cervesql consulta -gui test.cer
```

*(Sustituye `consulta` por tu regla inicial.)*

---

## 🧾 Notas finales

- Si prefieres generar el parser para **Python**, ejecuta:
  ```bash
  antlr4 -Dlanguage=Python3 cervesql.g4
  ```
  Luego puedes crear un script en Python para leer `test.cer`.

- Asegúrate de que el archivo `test.cer` esté en el mismo directorio que la gramática.
