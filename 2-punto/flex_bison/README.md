# 🍺 CERVESQL — Un lenguaje cervecero implementado en Flex y Bison

CERVESQL es un lenguaje inspirado en SQL, pero con terminología cervecera. 
Está implementado usando **Flex** y **Bison**, y permite realizar operaciones típicas de bases de datos: insertar, consultar, actualizar y eliminar, usando comandos cerveceros como **FERMENTAR**, **SERVIR**, **MACERAR** y **DESECHAR**.

---

## 🧱 Requisitos

Antes de compilar, asegúrate de tener instalados:

- [Flex](https://github.com/westes/flex)
- [Bison](https://www.gnu.org/software/bison/)
- [GCC](https://gcc.gnu.org/)

Para instalar en Linux (Debian/Ubuntu):

```bash
sudo apt install flex bison gcc
```

---

## ⚙️ Compilación

Ve a la capete .

- `.\parcial2_lenguajes\2-punto`

Luego compila con:

```bash
make -f makefile
```

Ejecuta el intérprete:

```bash
./cervesql
```

---

## 🍻 Uso básico

Cuando ejecutes `./cervesql`, verás un mensaje de bienvenida:

```
🍺 Bienvenido a CERVESQL — Tu lenguaje cervecero en español 🍻
Ejemplos:
  FERMENTAR EN cervezas LUPULO (1, "IPA", 6.5);
  SERVIR * DE cervezas;
  MACERAR cervezas MALTA grado = 7.0 BARRIL id = 1;
  DESECHAR DE cervezas BARRIL id = 3;
```

A partir de ahí, puedes escribir comandos tipo SQL, pero con vocabulario cervecero.

## existe una carpeta que llamada simulacion_db
En esta carpeta se simula el comportamiento de una base de datos real, se usan POO para simular una tabla con columnas y filas. Y por ejemplo se puede consultar 
la lista de cervezas en la tabla con la respectiva sintaxis de CERVESQL, pero hay funciones que fallan debido 
a que la gramatica tiene problemas con el manejo numerico de los datos, entonces puede mostrar valores extraños en las insersiones(fermentacion) por ejemplo:

**si se quiere probar se debe entrar a la carpeta simulacion_db y compilar el makefile como anterniormente se mencionnó**


---

## 🍺 Comandos disponibles

| Comando | Descripción | Ejemplo |
|----------|--------------|---------|
| **FERMENTAR EN** | Inserta nuevos registros en una tabla. | `FERMENTAR EN cervezas LUPULO (1, "IPA", 6.5);` |
| **SERVIR \*** | Consulta todos los registros de una tabla. | `SERVIR * DE cervezas;` |
| **MACERAR** | Actualiza valores de una tabla, con o sin condición. | `MACERAR cervezas MALTA grado = 7.0 BARRIL id = 1;` |
| **DESECHAR DE** | Elimina registros de una tabla, con o sin condición. | `DESECHAR DE cervezas BARRIL id = 3;` |

---

## 🧪 Ejemplos de uso

### Fermentar varias cervezas
```sql
FERMENTAR EN cervezas LUPULO (1, "IPA", 6.5);
FERMENTAR EN cervezas LUPULO (2, "Stout", 8.0);
FERMENTAR EN cervezas LUPULO (3, "Pilsner", 4.8);
```

📤 **Salida:**
```
🍺 Fermentado en tabla: cervezas
🍺 Fermentado en tabla: cervezas
🍺 Fermentado en tabla: cervezas
```

---

### Servir todas las cervezas
```sql
SERVIR * DE cervezas;
```

📤 **Salida:**
```
🍻 Servido desde tabla: cervezas
```

---

### Macerar (actualizar datos)
```sql
MACERAR cervezas MALTA grado = 7.2 BARRIL id = 2;
```

📤 **Salida:**
```
🧪 Macerada tabla: cervezas
```

---

### Desechar una cerveza
```sql
DESECHAR DE cervezas BARRIL id = 3;
```

📤 **Salida:**
```
💦 Desechada tabla: cervezas
```

---

## ⚡ Ejemplo completo de sesión

```sql
FERMENTAR EN cervezas LUPULO (1, "IPA", 6.5);
FERMENTAR EN cervezas LUPULO (2, "Stout", 8.0);
SERVIR * DE cervezas;
MACERAR cervezas MALTA grado = 7.5 BARRIL id = 2;
DESECHAR DE cervezas BARRIL id = 1;
SERVIR * DE cervezas;
```

📤 **Salida:**
```
🍺 Fermentado en tabla: cervezas
🍺 Fermentado en tabla: cervezas
🍻 Servido desde tabla: cervezas
🧪 Macerada tabla: cervezas
💦 Desechada tabla: cervezas
🍻 Servido desde tabla: cervezas
```

---

## 💬 Comentarios

CERVESQL soporta comentarios de línea usando `//`:

```sql
// Esto es un comentario
FERMENTAR EN cervezas LUPULO (9, "Brown Ale", 5.8); // Otro comentario
```

---

## 🧰 Ejecución desde archivo

También puedes guardar tus comandos en un archivo, por ejemplo `demo.csql`:

```sql
FERMENTAR EN cervezas LUPULO (1, "Lager", 5.0);
SERVIR * DE cervezas;
```

Y luego ejecutarlo:

```bash
./cervesql < demo.csql
```

📤 **Salida:**
```
🍺 Fermentado en tabla: cervezas
🍻 Servido desde tabla: cervezas
```

---

## 🧠 Conceptos clave

| Concepto | Significado |
|-----------|-------------|
| **Tabla** | Representa una entidad, como `cervezas`, `barriles`, `clientes`, etc. |
| **FERMENTAR** | Inserta datos nuevos (similar a `INSERT INTO`). |
| **SERVIR** | Consulta registros (similar a `SELECT`). |
| **MACERAR** | Modifica registros (similar a `UPDATE`). |
| **DESECHAR** | Elimina registros (similar a `DELETE`). |
| **BARRIL** | Palabra clave usada para condiciones (`WHERE`). |
| **MALTA** | Palabra clave usada antes de asignar nuevos valores (`SET`). |

---

## ⚠️ Errores comunes

| Error | Causa | Solución |
|--------|--------|-----------|
| `Error sintáctico: syntax error` | Falta alguna palabra clave (`EN`, `DE`, `BARRIL`, etc.) | Revisa la sintaxis del comando. |
| `Carácter desconocido:` | Usaste un símbolo no reconocido por el lenguaje. | Verifica los caracteres permitidos. |
| Comillas sin cerrar | Un literal de texto `"texto` sin el cierre. | Agrega la comilla final `"`. |

---

## 🧩 Extensiones posibles

Este proyecto puede extenderse fácilmente:
- Guardar las “tablas” en memoria para que `SERVIR` muestre datos reales.
- Agregar soporte para comentarios multilínea.
- Permitir minúsculas y mayúsculas indistintamente.
- Implementar operaciones aritméticas o filtros complejos.

---

## 🧑‍💻 Autor
Diego Casallas/Nicolas lesmes

Desarrollado como proyecto educativo de análisis léxico y sintáctico con **Flex** y **Bison**,  
para demostrar cómo crear lenguajes personalizados con un toque artesanal cervecero 🍺. Para la materia de lenguajes con el profesor Joaquin

---

## 🏁 Licencia

Este proyecto es de uso libre con fines educativos y experimentales.  
¡Diviértete fermentando tu propio lenguaje!
