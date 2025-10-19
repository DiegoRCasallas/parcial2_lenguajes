cervesql: scaner.l parser.y
	bison -d parser.y
	flex scaner.l
	gcc -o cervesql lex.yy.c parser.tab.c -lfl		
