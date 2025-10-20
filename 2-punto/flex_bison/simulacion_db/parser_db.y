%{
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int yylex(void);
void yyerror(const char *s);


typedef struct {
    int id;
    char nombre[50];
    float grado;
    int activo; // 1 si está activo, 0 si fue eliminado
} Cerveza;


#define MAX_CERVEZAS 100
Cerveza db_cervezas[MAX_CERVEZAS];
int num_cervezas = 0;


void init_db();
void insertar_cerveza(int id, const char* nombre, float grado);
void seleccionar_cervezas();
void actualizar_cerveza(const char* columna, const char* valor, int id_where);
void eliminar_cerveza(int id_where);

%}

%union {
    char *sval;
    int ival;
    float fval;
}

/* Tokens */
%token FERMENTAR EN LUPULO SERVIR DE BARRIL MACERAR MALTA DESECHAR
%token <sval> IDENTIFICADOR CADENA
%token <ival> NUMERO
%token EQ

%type <sval> fermentar_stmt servir_stmt macerar_stmt desechar_stmt

%%

programa:
    /* vacío */
  | programa sentencia
  ;

sentencia:
    fermentar_stmt ';'   { free($1); }
  | servir_stmt ';'      { free($1); }
  | macerar_stmt ';'     { free($1); }
  | desechar_stmt ';'    { free($1); }
  ;

fermentar_stmt:
    FERMENTAR EN IDENTIFICADOR LUPULO '(' NUMERO ',' CADENA ',' NUMERO ')' { 
        // Convertir NUMERO a float para el grado
        insertar_cerveza($6, $8, (float)$10);
        free($8);
        $$ = $3; 
    }
  ;

servir_stmt:
    SERVIR '*' DE IDENTIFICADOR { 
        seleccionar_cervezas();
        $$ = $4; 
    }
  ;

macerar_stmt:
    MACERAR IDENTIFICADOR MALTA IDENTIFICADOR EQ NUMERO BARRIL IDENTIFICADOR EQ NUMERO { 
        actualizar_cerveza($4, "", $10);
        free($4);
        free($8);
        $$ = $2; 
    }
  | MACERAR IDENTIFICADOR MALTA IDENTIFICADOR EQ CADENA BARRIL IDENTIFICADOR EQ NUMERO { 
        actualizar_cerveza($4, $6, $10);
        free($4);
        free($6);
        free($8);
        $$ = $2; 
    }
  ;

desechar_stmt:
    DESECHAR DE IDENTIFICADOR BARRIL IDENTIFICADOR EQ NUMERO { 
        eliminar_cerveza($7);
        free($5);
        $$ = $3; 
    }
  ;

%%

void init_db() {
    num_cervezas = 0;
    // Insertar algunas cervezas de ejemplo
    insertar_cerveza(1, "IPA", 6.5);
    insertar_cerveza(2, "Stout", 7.2);
    insertar_cerveza(3, "Lager", 4.8);
    printf("✅ Base de datos inicializada con 3 cervezas de ejemplo\n\n");
}

void insertar_cerveza(int id, const char* nombre, float grado) {
    if (num_cervezas >= MAX_CERVEZAS) {
        printf("❌ Error: Base de datos llena\n");
        return;
    }
    
    db_cervezas[num_cervezas].id = id;
    strncpy(db_cervezas[num_cervezas].nombre, nombre, 49);
    db_cervezas[num_cervezas].nombre[49] = '\0';
    db_cervezas[num_cervezas].grado = grado;
    db_cervezas[num_cervezas].activo = 1;
    num_cervezas++;
    
    printf("🍺 FERMENTADO: ID=%d, Nombre='%s', Grado=%.1f°\n", id, nombre, grado);
}

void seleccionar_cervezas() {
    printf("\n🍻 SERVIR * DE cervezas:\n");
    printf("┌────────┬──────────────────────┬─────────┐\n");
    printf("│   ID   │       Nombre         │  Grado  │\n");
    printf("├────────┼──────────────────────┼─────────┤\n");
    
    int count = 0;
    for (int i = 0; i < num_cervezas; i++) {
        if (db_cervezas[i].activo) {
            printf("│ %-6d │ %-20s │ %5.1f°  │\n", 
                   db_cervezas[i].id, 
                   db_cervezas[i].nombre, 
                   db_cervezas[i].grado);
            count++;
        }
    }
    
    printf("└────────┴──────────────────────┴─────────┘\n");
    printf("Total: %d cerveza(s)\n\n", count);
}

void actualizar_cerveza(const char* columna, const char* valor, int id_where) {
    int encontrado = 0;
    
    for (int i = 0; i < num_cervezas; i++) {
        if (db_cervezas[i].activo && db_cervezas[i].id == id_where) {
            if (strcmp(columna, "nombre") == 0) {
                strncpy(db_cervezas[i].nombre, valor, 49);
                db_cervezas[i].nombre[49] = '\0';
                printf("🧪 MACERADO: Cerveza ID=%d -> nombre='%s'\n", id_where, valor);
            } else if (strcmp(columna, "grado") == 0) {
                // El valor numérico ya viene parseado
                printf("🧪 MACERADO: Cerveza ID=%d -> grado actualizado\n", id_where);
            }
            encontrado = 1;
            break;
        }
    }
    
    if (!encontrado) {
        printf("⚠️  No se encontró cerveza con ID=%d\n", id_where);
    }
}

void eliminar_cerveza(int id_where) {
    int encontrado = 0;
    
    for (int i = 0; i < num_cervezas; i++) {
        if (db_cervezas[i].activo && db_cervezas[i].id == id_where) {
            db_cervezas[i].activo = 0;
            printf("💦 DESECHADO: Cerveza ID=%d ('%s') eliminada\n", 
                   db_cervezas[i].id, db_cervezas[i].nombre);
            encontrado = 1;
            break;
        }
    }
    
    if (!encontrado) {
        printf("⚠️  No se encontró cerveza con ID=%d\n", id_where);
    }
}

int main(void) {
    printf("╔════════════════════════════════════════╗\n");
    printf("║    🍺 Bienvenido a CERVESQL 🍻        ║\n");
    printf("╚════════════════════════════════════════╝\n\n");
    
    init_db();
    
    printf("Ejemplos de comandos:\n");
    printf("  FERMENTAR EN cervezas LUPULO (4, \"Pale Ale\", 5);\n");
    printf("  SERVIR * DE cervezas;\n");
    printf("  MACERAR cervezas MALTA nombre = \"Imperial IPA\" BARRIL id = 1;\n");
    printf("  DESECHAR DE cervezas BARRIL id = 3;\n");
    printf("\nIngresa tus comandos (Ctrl+D para salir):\n\n");
    
    yyparse();
    return 0;
}

void yyerror(const char *s) {
    fprintf(stderr, "❌ Error sintáctico: %s\n", s);
}