%{
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int yylex(void);
void yyerror(const char *s);
%}

/* Declarar uniones para permitir punteros */
%union {
    char *sval;
}

%token FERMENTAR EN LUPULO SERVIR DE BARRIL MACERAR MALTA DESECHAR
%token <sval> IDENTIFICADOR NUMERO CADENA
%token EQ

%type <sval> fermentar_stmt servir_stmt macerar_stmt desechar_stmt

%%

programa:

  | programa sentencia
  ;

sentencia:
    fermentar_stmt ';'   { printf("🍺 Fermentado en tabla: %s\n", $1); free($1); }
  | servir_stmt ';'      { printf("🍻 Servido desde tabla: %s\n", $1); free($1); }
  | macerar_stmt ';'     { printf("🧪 Macerada tabla: %s\n", $1); free($1); }
  | desechar_stmt ';'    { printf("💦 Desechada tabla: %s\n", $1); free($1); }
  ;

fermentar_stmt:
    FERMENTAR EN IDENTIFICADOR LUPULO '(' lista_valores ')' { $$ = $3; }
  ;

servir_stmt:
    SERVIR '*' DE IDENTIFICADOR { $$ = $4; }
  ;

macerar_stmt:
    MACERAR IDENTIFICADOR MALTA IDENTIFICADOR EQ valor opt_barril { $$ = $2; }
  ;

desechar_stmt:
    DESECHAR DE IDENTIFICADOR opt_barril { $$ = $3; }
  ;

opt_barril:
  
  | BARRIL condicion
  ;

condicion:
    IDENTIFICADOR EQ valor
  ;

lista_valores:
    valor
  | lista_valores ',' valor
  ;

valor:
    NUMERO
  | CADENA
  ;

%%

int main(void) {
    printf("🍺 Bienvenido a CERVESQL 🍻\n");
    printf("Ejemplos:\n");
    printf("  FERMENTAR EN cervezas LUPULO (1, \"IPA\", 6.5);\n");
    printf("  SERVIR * DE cervezas;\n");
    printf("  MACERAR cervezas MALTA grado = 7.0 BARRIL id = 1;\n");
    printf("  DESECHAR DE cervezas BARRIL id = 3;\n\n");
    yyparse();
    return 0;
}

void yyerror(const char *s) {
    fprintf(stderr, "Error sintáctico: %s\n", s);
}
