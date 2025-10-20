# Gramática CERVESQL 🍺

## Descripción General

CERVESQL es un lenguaje de dominio específico (DSL) inspirado en SQL pero con temática cervecera. Permite realizar operaciones similares a INSERT, SELECT, UPDATE y DELETE usando terminología relacionada con la elaboración de cerveza.

---

## Símbolos Terminales

Los símbolos terminales son los tokens básicos del lenguaje que no se descomponen en otros símbolos:

### Palabras Clave

| Terminal | Descripción |
|----------|-------------|
| `FERMENTAR` | Inicio de inserción de datos |
| `EN` | Especifica la tabla destino |
| `LUPULO` | Indica inicio de valores a insertar |
| `SERVIR` | Inicio de consulta SELECT |
| `DE` | Indica la tabla origen |
| `BARRIL` | Especifica condición WHERE |
| `MACERAR` | Inicio de actualización UPDATE |
| `MALTA` | Separa tabla de columna en UPDATE |
| `DESECHAR` | Inicio de eliminación DELETE |

### Operadores y Delimitadores

| Terminal | Descripción |
|----------|-------------|
| `EQ` (=) | Operador de igualdad |
| `;` | Terminador de sentencia |
| `*` | Selector de todas las columnas |
| `(` | Paréntesis de apertura |
| `)` | Paréntesis de cierre |
| `,` | Separador de valores |

### Valores

| Terminal | Descripción |
|----------|-------------|
| `IDENTIFICADOR` | Nombre de tabla o columna |
| `NUMERO` | Valor numérico |
| `CADENA` | Valor de texto entre comillas |

**Total: 18 símbolos terminales**

---

## Símbolos No Terminales

Los símbolos no terminales son las reglas de producción que definen la estructura del lenguaje:

| No Terminal | Descripción |
|-------------|-------------|
| `programa` | Símbolo inicial, representa el programa completo |
| `sentencia` | Una instrucción completa del lenguaje |
| `fermentar_stmt` | Sentencia de inserción (INSERT) |
| `servir_stmt` | Sentencia de consulta (SELECT) |
| `macerar_stmt` | Sentencia de actualización (UPDATE) |
| `desechar_stmt` | Sentencia de eliminación (DELETE) |
| `opt_barril` | Cláusula WHERE opcional |
| `condicion` | Expresión de comparación |
| `lista_valores` | Secuencia de valores separados por comas |
| `valor` | Un valor individual (número o cadena) |

**Total: 10 símbolos no terminales**

---

## Reglas de Producción

### 1. Programa

```
programa → ε (vacío)
programa → programa sentencia
```

Un programa puede estar vacío o contener una secuencia de sentencias.

### 2. Sentencia

```
sentencia → fermentar_stmt ';'
sentencia → servir_stmt ';'
sentencia → macerar_stmt ';'
sentencia → desechar_stmt ';'
```

Cada sentencia debe terminar con punto y coma.

### 3. Fermentar (INSERT)

```
fermentar_stmt → FERMENTAR EN IDENTIFICADOR LUPULO '(' lista_valores ')'
```

**Ejemplo:**
```sql
FERMENTAR EN cervezas LUPULO (1, "IPA", 6.5);
```

### 4. Servir (SELECT)

```
servir_stmt → SERVIR '*' DE IDENTIFICADOR
```

**Ejemplo:**
```sql
SERVIR * DE cervezas;
```

### 5. Macerar (UPDATE)

```
macerar_stmt → MACERAR IDENTIFICADOR MALTA IDENTIFICADOR EQ valor opt_barril
```

**Ejemplo:**
```sql
MACERAR cervezas MALTA grado = 7.0 BARRIL id = 1;
```

### 6. Desechar (DELETE)

```
desechar_stmt → DESECHAR DE IDENTIFICADOR opt_barril
```

**Ejemplo:**
```sql
DESECHAR DE cervezas BARRIL id = 3;
```

### 7. Cláusula Opcional (WHERE)

```
opt_barril → ε (vacío)
opt_barril → BARRIL condicion
```

### 8. Condición

```
condicion → IDENTIFICADOR EQ valor
```

### 9. Lista de Valores

```
lista_valores → valor
lista_valores → lista_valores ',' valor
```

### 10. Valor

```
valor → NUMERO
valor → CADENA
```

---

## Ejemplos Completos

### Inserción de Datos
```sql
FERMENTAR EN cervezas LUPULO (1, "IPA", 6.5);
```
Equivalente SQL: `INSERT INTO cervezas VALUES (1, "IPA", 6.5);`

### Consulta
```sql
SERVIR * DE cervezas;
```
Equivalente SQL: `SELECT * FROM cervezas;`

### Actualización
```sql
MACERAR cervezas MALTA grado = 7.0 BARRIL id = 1;
```
Equivalente SQL: `UPDATE cervezas SET grado = 7.0 WHERE id = 1;`

### Eliminación
```sql
DESECHAR DE cervezas BARRIL id = 3;
```
Equivalente SQL: `DELETE FROM cervezas WHERE id = 3;`

---

## Características de la Gramática

- **Tipo:** Gramática libre de contexto (CFG)
- **Símbolo inicial:** `programa`
- **Recursividad:** Recursión por la izquierda en `programa` y `lista_valores`
- **Opcionalidad:** La cláusula `opt_barril` puede ser vacía (ε)
- **Delimitadores:** Todas las sentencias terminan en `;`

---

## Notas Técnicas

1. La gramática utiliza recursión por la izquierda para permitir múltiples sentencias
2. Los valores pueden ser números o cadenas de texto
3. La cláusula BARRIL (WHERE) es opcional en UPDATE y DELETE
4. Las listas de valores permiten múltiples elementos separados por comas
5. Cada sentencia debe terminar obligatoriamente con punto y coma

---

*Documentación de CERVESQL - Lenguaje de cerveceros para cerveceros* 🍻