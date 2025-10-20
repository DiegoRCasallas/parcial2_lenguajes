// Generated from cervesql.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class cervesqlParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, FERMENTAR=6, EN=7, LUPULO=8, SERVIR=9, 
		DE=10, BARRIL=11, MACERAR=12, MALTA=13, DESECHAR=14, EQ=15, L_NUM=16, 
		L_IDENT=17, L_CADENA=18, WS=19, COMENTARIO=20;
	public static final int
		RULE_programa = 0, RULE_sentencia = 1, RULE_fermentar_stmt = 2, RULE_servir_stmt = 3, 
		RULE_macerar_stmt = 4, RULE_desechar_stmt = 5, RULE_opt_barril = 6, RULE_condicion = 7, 
		RULE_lista_valores = 8, RULE_valor = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "sentencia", "fermentar_stmt", "servir_stmt", "macerar_stmt", 
			"desechar_stmt", "opt_barril", "condicion", "lista_valores", "valor"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'('", "')'", "'*'", "','", "'FERMENTAR'", "'EN'", "'LUPULO'", 
			"'SERVIR'", "'DE'", "'BARRIL'", "'MACERAR'", "'MALTA'", "'DESECHAR'", 
			"'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "FERMENTAR", "EN", "LUPULO", "SERVIR", 
			"DE", "BARRIL", "MACERAR", "MALTA", "DESECHAR", "EQ", "L_NUM", "L_IDENT", 
			"L_CADENA", "WS", "COMENTARIO"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "cervesql.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public cervesqlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramaContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(cervesqlParser.EOF, 0); }
		public List<SentenciaContext> sentencia() {
			return getRuleContexts(SentenciaContext.class);
		}
		public SentenciaContext sentencia(int i) {
			return getRuleContext(SentenciaContext.class,i);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cervesqlListener ) ((cervesqlListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cervesqlListener ) ((cervesqlListener)listener).exitPrograma(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 21056L) != 0)) {
				{
				{
				setState(20);
				sentencia();
				setState(21);
				match(T__0);
				}
				}
				setState(27);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(28);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SentenciaContext extends ParserRuleContext {
		public Fermentar_stmtContext fermentar_stmt;
		public Servir_stmtContext servir_stmt;
		public Macerar_stmtContext macerar_stmt;
		public Desechar_stmtContext desechar_stmt;
		public Fermentar_stmtContext fermentar_stmt() {
			return getRuleContext(Fermentar_stmtContext.class,0);
		}
		public Servir_stmtContext servir_stmt() {
			return getRuleContext(Servir_stmtContext.class,0);
		}
		public Macerar_stmtContext macerar_stmt() {
			return getRuleContext(Macerar_stmtContext.class,0);
		}
		public Desechar_stmtContext desechar_stmt() {
			return getRuleContext(Desechar_stmtContext.class,0);
		}
		public SentenciaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencia; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cervesqlListener ) ((cervesqlListener)listener).enterSentencia(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cervesqlListener ) ((cervesqlListener)listener).exitSentencia(this);
		}
	}

	public final SentenciaContext sentencia() throws RecognitionException {
		SentenciaContext _localctx = new SentenciaContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_sentencia);
		try {
			setState(42);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FERMENTAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(30);
				((SentenciaContext)_localctx).fermentar_stmt = fermentar_stmt();
				System.out.println("🍺 Fermentado en tabla: " + ((SentenciaContext)_localctx).fermentar_stmt.tabla);
				}
				break;
			case SERVIR:
				enterOuterAlt(_localctx, 2);
				{
				setState(33);
				((SentenciaContext)_localctx).servir_stmt = servir_stmt();
				System.out.println("🍻 Servido desde tabla: " + ((SentenciaContext)_localctx).servir_stmt.tabla);
				}
				break;
			case MACERAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(36);
				((SentenciaContext)_localctx).macerar_stmt = macerar_stmt();
				System.out.println("🧪 Macerada tabla: " + ((SentenciaContext)_localctx).macerar_stmt.tabla);
				}
				break;
			case DESECHAR:
				enterOuterAlt(_localctx, 4);
				{
				setState(39);
				((SentenciaContext)_localctx).desechar_stmt = desechar_stmt();
				System.out.println("💦 Desechada tabla: " + ((SentenciaContext)_localctx).desechar_stmt.tabla);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Fermentar_stmtContext extends ParserRuleContext {
		public String tabla;
		public Token id;
		public TerminalNode FERMENTAR() { return getToken(cervesqlParser.FERMENTAR, 0); }
		public TerminalNode EN() { return getToken(cervesqlParser.EN, 0); }
		public TerminalNode LUPULO() { return getToken(cervesqlParser.LUPULO, 0); }
		public Lista_valoresContext lista_valores() {
			return getRuleContext(Lista_valoresContext.class,0);
		}
		public TerminalNode L_IDENT() { return getToken(cervesqlParser.L_IDENT, 0); }
		public Fermentar_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fermentar_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cervesqlListener ) ((cervesqlListener)listener).enterFermentar_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cervesqlListener ) ((cervesqlListener)listener).exitFermentar_stmt(this);
		}
	}

	public final Fermentar_stmtContext fermentar_stmt() throws RecognitionException {
		Fermentar_stmtContext _localctx = new Fermentar_stmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_fermentar_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(FERMENTAR);
			setState(45);
			match(EN);
			setState(46);
			((Fermentar_stmtContext)_localctx).id = match(L_IDENT);
			setState(47);
			match(LUPULO);
			setState(48);
			match(T__1);
			setState(49);
			lista_valores();
			setState(50);
			match(T__2);
			 ((Fermentar_stmtContext)_localctx).tabla =  (((Fermentar_stmtContext)_localctx).id!=null?((Fermentar_stmtContext)_localctx).id.getText():null); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Servir_stmtContext extends ParserRuleContext {
		public String tabla;
		public Token id;
		public TerminalNode SERVIR() { return getToken(cervesqlParser.SERVIR, 0); }
		public TerminalNode DE() { return getToken(cervesqlParser.DE, 0); }
		public TerminalNode L_IDENT() { return getToken(cervesqlParser.L_IDENT, 0); }
		public Servir_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_servir_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cervesqlListener ) ((cervesqlListener)listener).enterServir_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cervesqlListener ) ((cervesqlListener)listener).exitServir_stmt(this);
		}
	}

	public final Servir_stmtContext servir_stmt() throws RecognitionException {
		Servir_stmtContext _localctx = new Servir_stmtContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_servir_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(SERVIR);
			setState(54);
			match(T__3);
			setState(55);
			match(DE);
			setState(56);
			((Servir_stmtContext)_localctx).id = match(L_IDENT);
			 ((Servir_stmtContext)_localctx).tabla =  (((Servir_stmtContext)_localctx).id!=null?((Servir_stmtContext)_localctx).id.getText():null); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Macerar_stmtContext extends ParserRuleContext {
		public String tabla;
		public Token id1;
		public Token id2;
		public TerminalNode MACERAR() { return getToken(cervesqlParser.MACERAR, 0); }
		public TerminalNode MALTA() { return getToken(cervesqlParser.MALTA, 0); }
		public TerminalNode EQ() { return getToken(cervesqlParser.EQ, 0); }
		public ValorContext valor() {
			return getRuleContext(ValorContext.class,0);
		}
		public Opt_barrilContext opt_barril() {
			return getRuleContext(Opt_barrilContext.class,0);
		}
		public List<TerminalNode> L_IDENT() { return getTokens(cervesqlParser.L_IDENT); }
		public TerminalNode L_IDENT(int i) {
			return getToken(cervesqlParser.L_IDENT, i);
		}
		public Macerar_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_macerar_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cervesqlListener ) ((cervesqlListener)listener).enterMacerar_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cervesqlListener ) ((cervesqlListener)listener).exitMacerar_stmt(this);
		}
	}

	public final Macerar_stmtContext macerar_stmt() throws RecognitionException {
		Macerar_stmtContext _localctx = new Macerar_stmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_macerar_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(MACERAR);
			setState(60);
			((Macerar_stmtContext)_localctx).id1 = match(L_IDENT);
			setState(61);
			match(MALTA);
			setState(62);
			((Macerar_stmtContext)_localctx).id2 = match(L_IDENT);
			setState(63);
			match(EQ);
			setState(64);
			valor();
			setState(65);
			opt_barril();
			 ((Macerar_stmtContext)_localctx).tabla =  (((Macerar_stmtContext)_localctx).id1!=null?((Macerar_stmtContext)_localctx).id1.getText():null); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Desechar_stmtContext extends ParserRuleContext {
		public String tabla;
		public Token id;
		public TerminalNode DESECHAR() { return getToken(cervesqlParser.DESECHAR, 0); }
		public TerminalNode DE() { return getToken(cervesqlParser.DE, 0); }
		public Opt_barrilContext opt_barril() {
			return getRuleContext(Opt_barrilContext.class,0);
		}
		public TerminalNode L_IDENT() { return getToken(cervesqlParser.L_IDENT, 0); }
		public Desechar_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_desechar_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cervesqlListener ) ((cervesqlListener)listener).enterDesechar_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cervesqlListener ) ((cervesqlListener)listener).exitDesechar_stmt(this);
		}
	}

	public final Desechar_stmtContext desechar_stmt() throws RecognitionException {
		Desechar_stmtContext _localctx = new Desechar_stmtContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_desechar_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(DESECHAR);
			setState(69);
			match(DE);
			setState(70);
			((Desechar_stmtContext)_localctx).id = match(L_IDENT);
			setState(71);
			opt_barril();
			 ((Desechar_stmtContext)_localctx).tabla =  (((Desechar_stmtContext)_localctx).id!=null?((Desechar_stmtContext)_localctx).id.getText():null); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Opt_barrilContext extends ParserRuleContext {
		public TerminalNode BARRIL() { return getToken(cervesqlParser.BARRIL, 0); }
		public CondicionContext condicion() {
			return getRuleContext(CondicionContext.class,0);
		}
		public Opt_barrilContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opt_barril; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cervesqlListener ) ((cervesqlListener)listener).enterOpt_barril(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cervesqlListener ) ((cervesqlListener)listener).exitOpt_barril(this);
		}
	}

	public final Opt_barrilContext opt_barril() throws RecognitionException {
		Opt_barrilContext _localctx = new Opt_barrilContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_opt_barril);
		try {
			setState(77);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case BARRIL:
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				match(BARRIL);
				setState(76);
				condicion();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CondicionContext extends ParserRuleContext {
		public TerminalNode L_IDENT() { return getToken(cervesqlParser.L_IDENT, 0); }
		public TerminalNode EQ() { return getToken(cervesqlParser.EQ, 0); }
		public ValorContext valor() {
			return getRuleContext(ValorContext.class,0);
		}
		public CondicionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condicion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cervesqlListener ) ((cervesqlListener)listener).enterCondicion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cervesqlListener ) ((cervesqlListener)listener).exitCondicion(this);
		}
	}

	public final CondicionContext condicion() throws RecognitionException {
		CondicionContext _localctx = new CondicionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_condicion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(L_IDENT);
			setState(80);
			match(EQ);
			setState(81);
			valor();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Lista_valoresContext extends ParserRuleContext {
		public List<ValorContext> valor() {
			return getRuleContexts(ValorContext.class);
		}
		public ValorContext valor(int i) {
			return getRuleContext(ValorContext.class,i);
		}
		public Lista_valoresContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lista_valores; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cervesqlListener ) ((cervesqlListener)listener).enterLista_valores(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cervesqlListener ) ((cervesqlListener)listener).exitLista_valores(this);
		}
	}

	public final Lista_valoresContext lista_valores() throws RecognitionException {
		Lista_valoresContext _localctx = new Lista_valoresContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_lista_valores);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			valor();
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(84);
				match(T__4);
				setState(85);
				valor();
				}
				}
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValorContext extends ParserRuleContext {
		public TerminalNode L_NUM() { return getToken(cervesqlParser.L_NUM, 0); }
		public TerminalNode L_CADENA() { return getToken(cervesqlParser.L_CADENA, 0); }
		public ValorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cervesqlListener ) ((cervesqlListener)listener).enterValor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cervesqlListener ) ((cervesqlListener)listener).exitValor(this);
		}
	}

	public final ValorContext valor() throws RecognitionException {
		ValorContext _localctx = new ValorContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_valor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			_la = _input.LA(1);
			if ( !(_la==L_NUM || _la==L_CADENA) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0014^\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000"+
		"\u0018\b\u0000\n\u0000\f\u0000\u001b\t\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u0001+\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006N\b"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b"+
		"\u0001\b\u0005\bW\b\b\n\b\f\bZ\t\b\u0001\t\u0001\t\u0001\t\u0000\u0000"+
		"\n\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0000\u0001\u0002\u0000"+
		"\u0010\u0010\u0012\u0012Y\u0000\u0019\u0001\u0000\u0000\u0000\u0002*\u0001"+
		"\u0000\u0000\u0000\u0004,\u0001\u0000\u0000\u0000\u00065\u0001\u0000\u0000"+
		"\u0000\b;\u0001\u0000\u0000\u0000\nD\u0001\u0000\u0000\u0000\fM\u0001"+
		"\u0000\u0000\u0000\u000eO\u0001\u0000\u0000\u0000\u0010S\u0001\u0000\u0000"+
		"\u0000\u0012[\u0001\u0000\u0000\u0000\u0014\u0015\u0003\u0002\u0001\u0000"+
		"\u0015\u0016\u0005\u0001\u0000\u0000\u0016\u0018\u0001\u0000\u0000\u0000"+
		"\u0017\u0014\u0001\u0000\u0000\u0000\u0018\u001b\u0001\u0000\u0000\u0000"+
		"\u0019\u0017\u0001\u0000\u0000\u0000\u0019\u001a\u0001\u0000\u0000\u0000"+
		"\u001a\u001c\u0001\u0000\u0000\u0000\u001b\u0019\u0001\u0000\u0000\u0000"+
		"\u001c\u001d\u0005\u0000\u0000\u0001\u001d\u0001\u0001\u0000\u0000\u0000"+
		"\u001e\u001f\u0003\u0004\u0002\u0000\u001f \u0006\u0001\uffff\uffff\u0000"+
		" +\u0001\u0000\u0000\u0000!\"\u0003\u0006\u0003\u0000\"#\u0006\u0001\uffff"+
		"\uffff\u0000#+\u0001\u0000\u0000\u0000$%\u0003\b\u0004\u0000%&\u0006\u0001"+
		"\uffff\uffff\u0000&+\u0001\u0000\u0000\u0000\'(\u0003\n\u0005\u0000()"+
		"\u0006\u0001\uffff\uffff\u0000)+\u0001\u0000\u0000\u0000*\u001e\u0001"+
		"\u0000\u0000\u0000*!\u0001\u0000\u0000\u0000*$\u0001\u0000\u0000\u0000"+
		"*\'\u0001\u0000\u0000\u0000+\u0003\u0001\u0000\u0000\u0000,-\u0005\u0006"+
		"\u0000\u0000-.\u0005\u0007\u0000\u0000./\u0005\u0011\u0000\u0000/0\u0005"+
		"\b\u0000\u000001\u0005\u0002\u0000\u000012\u0003\u0010\b\u000023\u0005"+
		"\u0003\u0000\u000034\u0006\u0002\uffff\uffff\u00004\u0005\u0001\u0000"+
		"\u0000\u000056\u0005\t\u0000\u000067\u0005\u0004\u0000\u000078\u0005\n"+
		"\u0000\u000089\u0005\u0011\u0000\u00009:\u0006\u0003\uffff\uffff\u0000"+
		":\u0007\u0001\u0000\u0000\u0000;<\u0005\f\u0000\u0000<=\u0005\u0011\u0000"+
		"\u0000=>\u0005\r\u0000\u0000>?\u0005\u0011\u0000\u0000?@\u0005\u000f\u0000"+
		"\u0000@A\u0003\u0012\t\u0000AB\u0003\f\u0006\u0000BC\u0006\u0004\uffff"+
		"\uffff\u0000C\t\u0001\u0000\u0000\u0000DE\u0005\u000e\u0000\u0000EF\u0005"+
		"\n\u0000\u0000FG\u0005\u0011\u0000\u0000GH\u0003\f\u0006\u0000HI\u0006"+
		"\u0005\uffff\uffff\u0000I\u000b\u0001\u0000\u0000\u0000JN\u0001\u0000"+
		"\u0000\u0000KL\u0005\u000b\u0000\u0000LN\u0003\u000e\u0007\u0000MJ\u0001"+
		"\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000N\r\u0001\u0000\u0000\u0000"+
		"OP\u0005\u0011\u0000\u0000PQ\u0005\u000f\u0000\u0000QR\u0003\u0012\t\u0000"+
		"R\u000f\u0001\u0000\u0000\u0000SX\u0003\u0012\t\u0000TU\u0005\u0005\u0000"+
		"\u0000UW\u0003\u0012\t\u0000VT\u0001\u0000\u0000\u0000WZ\u0001\u0000\u0000"+
		"\u0000XV\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000Y\u0011\u0001"+
		"\u0000\u0000\u0000ZX\u0001\u0000\u0000\u0000[\\\u0007\u0000\u0000\u0000"+
		"\\\u0013\u0001\u0000\u0000\u0000\u0004\u0019*MX";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}