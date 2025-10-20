// Generated from cervesql.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class cervesqlLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, FERMENTAR=6, EN=7, LUPULO=8, SERVIR=9, 
		DE=10, BARRIL=11, MACERAR=12, MALTA=13, DESECHAR=14, EQ=15, L_NUM=16, 
		L_IDENT=17, L_CADENA=18, WS=19, COMENTARIO=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "FERMENTAR", "EN", "LUPULO", 
			"SERVIR", "DE", "BARRIL", "MACERAR", "MALTA", "DESECHAR", "EQ", "L_NUM", 
			"L_IDENT", "L_CADENA", "WS", "COMENTARIO"
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


	public cervesqlLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "cervesql.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0014\u00a2\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000f\u0004\u000fs\b\u000f\u000b\u000f\f\u000ft\u0001\u000f\u0001\u000f"+
		"\u0004\u000fy\b\u000f\u000b\u000f\f\u000fz\u0003\u000f}\b\u000f\u0001"+
		"\u0010\u0001\u0010\u0005\u0010\u0081\b\u0010\n\u0010\f\u0010\u0084\t\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u008a\b\u0011"+
		"\n\u0011\f\u0011\u008d\t\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0004"+
		"\u0012\u0092\b\u0012\u000b\u0012\f\u0012\u0093\u0001\u0012\u0001\u0012"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u009c\b\u0013"+
		"\n\u0013\f\u0013\u009f\t\u0013\u0001\u0013\u0001\u0013\u0000\u0000\u0014"+
		"\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r"+
		"\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e"+
		"\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014\u0001\u0000\u0006"+
		"\u0001\u000009\u000f\u0000AZ__az\u00c1\u00c1\u00c9\u00c9\u00cd\u00cd\u00d1"+
		"\u00d1\u00d3\u00d3\u00da\u00da\u00e1\u00e1\u00e9\u00e9\u00ed\u00ed\u00f1"+
		"\u00f1\u00f3\u00f3\u00fa\u00fa\u0010\u000009AZ__az\u00c1\u00c1\u00c9\u00c9"+
		"\u00cd\u00cd\u00d1\u00d1\u00d3\u00d3\u00da\u00da\u00e1\u00e1\u00e9\u00e9"+
		"\u00ed\u00ed\u00f1\u00f1\u00f3\u00f3\u00fa\u00fa\u0002\u0000\"\"\\\\\u0003"+
		"\u0000\t\n\r\r  \u0002\u0000\n\n\r\r\u00a9\u0000\u0001\u0001\u0000\u0000"+
		"\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000"+
		"\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000"+
		"\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000"+
		"\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000"+
		"\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000"+
		"\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000"+
		"\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000"+
		"\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001"+
		"\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000"+
		"\u0000\u0000\u0001)\u0001\u0000\u0000\u0000\u0003+\u0001\u0000\u0000\u0000"+
		"\u0005-\u0001\u0000\u0000\u0000\u0007/\u0001\u0000\u0000\u0000\t1\u0001"+
		"\u0000\u0000\u0000\u000b3\u0001\u0000\u0000\u0000\r=\u0001\u0000\u0000"+
		"\u0000\u000f@\u0001\u0000\u0000\u0000\u0011G\u0001\u0000\u0000\u0000\u0013"+
		"N\u0001\u0000\u0000\u0000\u0015Q\u0001\u0000\u0000\u0000\u0017X\u0001"+
		"\u0000\u0000\u0000\u0019`\u0001\u0000\u0000\u0000\u001bf\u0001\u0000\u0000"+
		"\u0000\u001do\u0001\u0000\u0000\u0000\u001fr\u0001\u0000\u0000\u0000!"+
		"~\u0001\u0000\u0000\u0000#\u0085\u0001\u0000\u0000\u0000%\u0091\u0001"+
		"\u0000\u0000\u0000\'\u0097\u0001\u0000\u0000\u0000)*\u0005;\u0000\u0000"+
		"*\u0002\u0001\u0000\u0000\u0000+,\u0005(\u0000\u0000,\u0004\u0001\u0000"+
		"\u0000\u0000-.\u0005)\u0000\u0000.\u0006\u0001\u0000\u0000\u0000/0\u0005"+
		"*\u0000\u00000\b\u0001\u0000\u0000\u000012\u0005,\u0000\u00002\n\u0001"+
		"\u0000\u0000\u000034\u0005F\u0000\u000045\u0005E\u0000\u000056\u0005R"+
		"\u0000\u000067\u0005M\u0000\u000078\u0005E\u0000\u000089\u0005N\u0000"+
		"\u00009:\u0005T\u0000\u0000:;\u0005A\u0000\u0000;<\u0005R\u0000\u0000"+
		"<\f\u0001\u0000\u0000\u0000=>\u0005E\u0000\u0000>?\u0005N\u0000\u0000"+
		"?\u000e\u0001\u0000\u0000\u0000@A\u0005L\u0000\u0000AB\u0005U\u0000\u0000"+
		"BC\u0005P\u0000\u0000CD\u0005U\u0000\u0000DE\u0005L\u0000\u0000EF\u0005"+
		"O\u0000\u0000F\u0010\u0001\u0000\u0000\u0000GH\u0005S\u0000\u0000HI\u0005"+
		"E\u0000\u0000IJ\u0005R\u0000\u0000JK\u0005V\u0000\u0000KL\u0005I\u0000"+
		"\u0000LM\u0005R\u0000\u0000M\u0012\u0001\u0000\u0000\u0000NO\u0005D\u0000"+
		"\u0000OP\u0005E\u0000\u0000P\u0014\u0001\u0000\u0000\u0000QR\u0005B\u0000"+
		"\u0000RS\u0005A\u0000\u0000ST\u0005R\u0000\u0000TU\u0005R\u0000\u0000"+
		"UV\u0005I\u0000\u0000VW\u0005L\u0000\u0000W\u0016\u0001\u0000\u0000\u0000"+
		"XY\u0005M\u0000\u0000YZ\u0005A\u0000\u0000Z[\u0005C\u0000\u0000[\\\u0005"+
		"E\u0000\u0000\\]\u0005R\u0000\u0000]^\u0005A\u0000\u0000^_\u0005R\u0000"+
		"\u0000_\u0018\u0001\u0000\u0000\u0000`a\u0005M\u0000\u0000ab\u0005A\u0000"+
		"\u0000bc\u0005L\u0000\u0000cd\u0005T\u0000\u0000de\u0005A\u0000\u0000"+
		"e\u001a\u0001\u0000\u0000\u0000fg\u0005D\u0000\u0000gh\u0005E\u0000\u0000"+
		"hi\u0005S\u0000\u0000ij\u0005E\u0000\u0000jk\u0005C\u0000\u0000kl\u0005"+
		"H\u0000\u0000lm\u0005A\u0000\u0000mn\u0005R\u0000\u0000n\u001c\u0001\u0000"+
		"\u0000\u0000op\u0005=\u0000\u0000p\u001e\u0001\u0000\u0000\u0000qs\u0007"+
		"\u0000\u0000\u0000rq\u0001\u0000\u0000\u0000st\u0001\u0000\u0000\u0000"+
		"tr\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000u|\u0001\u0000\u0000"+
		"\u0000vx\u0005.\u0000\u0000wy\u0007\u0000\u0000\u0000xw\u0001\u0000\u0000"+
		"\u0000yz\u0001\u0000\u0000\u0000zx\u0001\u0000\u0000\u0000z{\u0001\u0000"+
		"\u0000\u0000{}\u0001\u0000\u0000\u0000|v\u0001\u0000\u0000\u0000|}\u0001"+
		"\u0000\u0000\u0000} \u0001\u0000\u0000\u0000~\u0082\u0007\u0001\u0000"+
		"\u0000\u007f\u0081\u0007\u0002\u0000\u0000\u0080\u007f\u0001\u0000\u0000"+
		"\u0000\u0081\u0084\u0001\u0000\u0000\u0000\u0082\u0080\u0001\u0000\u0000"+
		"\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083\"\u0001\u0000\u0000\u0000"+
		"\u0084\u0082\u0001\u0000\u0000\u0000\u0085\u008b\u0005\"\u0000\u0000\u0086"+
		"\u008a\b\u0003\u0000\u0000\u0087\u0088\u0005\\\u0000\u0000\u0088\u008a"+
		"\t\u0000\u0000\u0000\u0089\u0086\u0001\u0000\u0000\u0000\u0089\u0087\u0001"+
		"\u0000\u0000\u0000\u008a\u008d\u0001\u0000\u0000\u0000\u008b\u0089\u0001"+
		"\u0000\u0000\u0000\u008b\u008c\u0001\u0000\u0000\u0000\u008c\u008e\u0001"+
		"\u0000\u0000\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008e\u008f\u0005"+
		"\"\u0000\u0000\u008f$\u0001\u0000\u0000\u0000\u0090\u0092\u0007\u0004"+
		"\u0000\u0000\u0091\u0090\u0001\u0000\u0000\u0000\u0092\u0093\u0001\u0000"+
		"\u0000\u0000\u0093\u0091\u0001\u0000\u0000\u0000\u0093\u0094\u0001\u0000"+
		"\u0000\u0000\u0094\u0095\u0001\u0000\u0000\u0000\u0095\u0096\u0006\u0012"+
		"\u0000\u0000\u0096&\u0001\u0000\u0000\u0000\u0097\u0098\u0005/\u0000\u0000"+
		"\u0098\u0099\u0005/\u0000\u0000\u0099\u009d\u0001\u0000\u0000\u0000\u009a"+
		"\u009c\b\u0005\u0000\u0000\u009b\u009a\u0001\u0000\u0000\u0000\u009c\u009f"+
		"\u0001\u0000\u0000\u0000\u009d\u009b\u0001\u0000\u0000\u0000\u009d\u009e"+
		"\u0001\u0000\u0000\u0000\u009e\u00a0\u0001\u0000\u0000\u0000\u009f\u009d"+
		"\u0001\u0000\u0000\u0000\u00a0\u00a1\u0006\u0013\u0000\u0000\u00a1(\u0001"+
		"\u0000\u0000\u0000\t\u0000tz|\u0082\u0089\u008b\u0093\u009d\u0001\u0006"+
		"\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}