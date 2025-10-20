cervesql: scaner.l parser_db.y
	bison -d parser_db.y
	flex scaner.l
	gcc -o simulacion lex.yy.c parser_db.tab.c -lfl		
