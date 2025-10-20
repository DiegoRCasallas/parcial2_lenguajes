grammar cervesql;

programa
    : (sentencia ';')* EOF
    ;

sentencia
    : fermentar_stmt      {System.out.println("🍺 Fermentado en tabla: " + $fermentar_stmt.tabla);}
    | servir_stmt         {System.out.println("🍻 Servido desde tabla: " + $servir_stmt.tabla);}
    | macerar_stmt        {System.out.println("🧪 Macerada tabla: " + $macerar_stmt.tabla);}
    | desechar_stmt       {System.out.println("💦 Desechada tabla: " + $desechar_stmt.tabla);}
    ;

fermentar_stmt returns [String tabla]
    : FERMENTAR EN id=L_IDENT LUPULO '(' lista_valores ')' { $tabla = $id.text; }
    ;

servir_stmt returns [String tabla]
    : SERVIR '*' DE id=L_IDENT { $tabla = $id.text; }
    ;

macerar_stmt returns [String tabla]
    : MACERAR id1=L_IDENT MALTA id2=L_IDENT EQ valor opt_barril { $tabla = $id1.text; }
    ;

desechar_stmt returns [String tabla]
    : DESECHAR DE id=L_IDENT opt_barril { $tabla = $id.text; }
    ;

opt_barril
    : /* vacío */
    | BARRIL condicion
    ;

condicion
    : L_IDENT EQ valor
    ;

lista_valores
    : valor (',' valor)*
    ;

valor
    : L_NUM
    | L_CADENA
    ;


// ----------------------
// LÉXICO
// ----------------------

FERMENTAR  : 'FERMENTAR';
EN         : 'EN';
LUPULO     : 'LUPULO';
SERVIR     : 'SERVIR';
DE         : 'DE';
BARRIL     : 'BARRIL';
MACERAR    : 'MACERAR';
MALTA      : 'MALTA';
DESECHAR   : 'DESECHAR';
EQ         : '=';

L_NUM      : [0-9]+ ('.' [0-9]+)?;
L_IDENT    : [A-Za-z_áéíóúÁÉÍÓÚñÑ][A-Za-z0-9_áéíóúÁÉÍÓÚñÑ]*;
L_CADENA   : '"' (~["\\] | '\\' .)* '"';

WS         : [ \t\r\n]+ -> skip;
COMENTARIO : '//' ~[\r\n]* -> skip;
