%{
#include "parser.tab.h"
#include <string.h>
#include <stdlib.h>
%}

DIGITO     [0-9]+(\.[0-9]+)?
ID         [A-Za-z_áéíóúÁÉÍÓÚñÑ][A-Za-z0-9_áéíóúÁÉÍÓÚñÑ]*
CADENA_VAL \"([^"\\]|\\.)*\"

%%

"FERMENTAR"   { return FERMENTAR; }
"EN"          { return EN; }
"LUPULO"      { return LUPULO; }
"SERVIR"      { return SERVIR; }
"DE"          { return DE; }
"BARRIL"      { return BARRIL; }
"MACERAR"     { return MACERAR; }
"MALTA"       { return MALTA; }
"DESECHAR"    { return DESECHAR; }

"="           { return EQ; }
"*"           { return '*'; }
","           { return ','; }
";"           { return ';'; }
"("           { return '('; }
")"           { return ')'; }


{ID}          { yylval.sval = strdup(yytext); return IDENTIFICADOR; }
{DIGITO}      { yylval.sval = strdup(yytext); return NUMERO; }
{CADENA_VAL}  { yylval.sval = strdup(yytext); return CADENA; }

[ \t\r\n]+    ; /* Ignorar espacios */
"//".*        ; /* Ignorar comentarios */
.             { printf("Carácter desconocido: %s\n", yytext); }

%%

int yywrap(void) { return 1; }
