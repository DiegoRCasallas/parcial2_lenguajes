// Generated from cervesql.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link cervesqlParser}.
 */
public interface cervesqlListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link cervesqlParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(cervesqlParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link cervesqlParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(cervesqlParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link cervesqlParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterSentencia(cervesqlParser.SentenciaContext ctx);
	/**
	 * Exit a parse tree produced by {@link cervesqlParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitSentencia(cervesqlParser.SentenciaContext ctx);
	/**
	 * Enter a parse tree produced by {@link cervesqlParser#fermentar_stmt}.
	 * @param ctx the parse tree
	 */
	void enterFermentar_stmt(cervesqlParser.Fermentar_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link cervesqlParser#fermentar_stmt}.
	 * @param ctx the parse tree
	 */
	void exitFermentar_stmt(cervesqlParser.Fermentar_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link cervesqlParser#servir_stmt}.
	 * @param ctx the parse tree
	 */
	void enterServir_stmt(cervesqlParser.Servir_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link cervesqlParser#servir_stmt}.
	 * @param ctx the parse tree
	 */
	void exitServir_stmt(cervesqlParser.Servir_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link cervesqlParser#macerar_stmt}.
	 * @param ctx the parse tree
	 */
	void enterMacerar_stmt(cervesqlParser.Macerar_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link cervesqlParser#macerar_stmt}.
	 * @param ctx the parse tree
	 */
	void exitMacerar_stmt(cervesqlParser.Macerar_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link cervesqlParser#desechar_stmt}.
	 * @param ctx the parse tree
	 */
	void enterDesechar_stmt(cervesqlParser.Desechar_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link cervesqlParser#desechar_stmt}.
	 * @param ctx the parse tree
	 */
	void exitDesechar_stmt(cervesqlParser.Desechar_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link cervesqlParser#opt_barril}.
	 * @param ctx the parse tree
	 */
	void enterOpt_barril(cervesqlParser.Opt_barrilContext ctx);
	/**
	 * Exit a parse tree produced by {@link cervesqlParser#opt_barril}.
	 * @param ctx the parse tree
	 */
	void exitOpt_barril(cervesqlParser.Opt_barrilContext ctx);
	/**
	 * Enter a parse tree produced by {@link cervesqlParser#condicion}.
	 * @param ctx the parse tree
	 */
	void enterCondicion(cervesqlParser.CondicionContext ctx);
	/**
	 * Exit a parse tree produced by {@link cervesqlParser#condicion}.
	 * @param ctx the parse tree
	 */
	void exitCondicion(cervesqlParser.CondicionContext ctx);
	/**
	 * Enter a parse tree produced by {@link cervesqlParser#lista_valores}.
	 * @param ctx the parse tree
	 */
	void enterLista_valores(cervesqlParser.Lista_valoresContext ctx);
	/**
	 * Exit a parse tree produced by {@link cervesqlParser#lista_valores}.
	 * @param ctx the parse tree
	 */
	void exitLista_valores(cervesqlParser.Lista_valoresContext ctx);
	/**
	 * Enter a parse tree produced by {@link cervesqlParser#valor}.
	 * @param ctx the parse tree
	 */
	void enterValor(cervesqlParser.ValorContext ctx);
	/**
	 * Exit a parse tree produced by {@link cervesqlParser#valor}.
	 * @param ctx the parse tree
	 */
	void exitValor(cervesqlParser.ValorContext ctx);
}