/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idee;
import static idee.token.*;
import java.awt.Color;
/**
 *
 * @author veroalonso
 */
public class Lexer {

    /**
     * @param args the command line arguments
     */
    
     /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\5\1\10\1\0\2\5\22\0\1\5\1\35\3\0\1\40"+
    "\2\0\1\40\1\40\1\7\1\36\1\40\1\37\1\4\1\6\12\2"+
    "\1\41\1\40\1\34\1\33\1\34\2\0\32\1\4\0\1\3\1\0"+
    "\1\12\1\31\1\30\1\25\1\20\1\15\1\1\1\17\1\13\2\1"+
    "\1\21\1\11\1\14\1\26\1\23\1\1\1\24\1\22\1\16\1\27"+
    "\1\1\1\32\3\1\1\40\1\0\1\40\uff82\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\2\5\14\2\1\6"+
    "\1\1\2\5\1\1\3\7\1\10\1\0\2\2\1\11"+
    "\6\2\1\12\5\2\1\6\1\7\1\13\2\0\1\2"+
    "\1\14\2\2\1\15\5\2\1\16\3\2\1\0\1\10"+
    "\1\17\1\2\1\20\1\21\1\2\1\22\2\2\1\23"+
    "\2\2\1\24\1\25\1\2\1\26\1\2\1\27\1\30"+
    "\1\2\1\31";

  private static int [] zzUnpackAction() {
    int [] result = new int[85];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\42\0\104\0\146\0\210\0\252\0\42\0\314"+
    "\0\356\0\u0110\0\u0132\0\u0154\0\u0176\0\u0198\0\u01ba\0\u01dc"+
    "\0\u01fe\0\u0220\0\u0242\0\u0264\0\u0264\0\u0286\0\u02a8\0\u02ca"+
    "\0\u02ec\0\u030e\0\u0330\0\u0352\0\u0374\0\u0396\0\u03b8\0\104"+
    "\0\u03da\0\u03fc\0\u041e\0\u0440\0\u0462\0\u0484\0\104\0\u04a6"+
    "\0\u04c8\0\u04ea\0\u050c\0\u052e\0\42\0\u0550\0\u0572\0\u0594"+
    "\0\u05b6\0\u05d8\0\104\0\u05fa\0\u061c\0\104\0\u063e\0\u0660"+
    "\0\u0682\0\u06a4\0\u06c6\0\104\0\u06e8\0\u070a\0\u072c\0\u074e"+
    "\0\42\0\104\0\u0770\0\104\0\104\0\u0792\0\104\0\u07b4"+
    "\0\u07d6\0\104\0\u07f8\0\u081a\0\104\0\104\0\u083c\0\104"+
    "\0\u085e\0\104\0\104\0\u0880\0\104";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[85];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\3\1\2\1\5\1\6\1\7"+
    "\1\5\1\10\1\3\1\11\1\3\1\12\1\13\1\3"+
    "\1\14\2\3\1\15\1\16\1\17\1\3\1\20\1\21"+
    "\1\22\1\23\2\24\1\25\1\26\1\27\1\7\1\30"+
    "\43\0\3\3\5\0\22\3\10\0\1\31\1\4\1\32"+
    "\1\33\4\0\22\31\14\0\1\5\2\0\1\5\37\0"+
    "\1\34\1\35\33\0\3\3\5\0\1\3\1\36\20\3"+
    "\10\0\3\3\5\0\3\3\1\37\1\40\15\3\10\0"+
    "\3\3\5\0\10\3\1\41\11\3\10\0\3\3\5\0"+
    "\6\3\1\42\13\3\10\0\3\3\5\0\3\3\1\43"+
    "\4\3\1\44\11\3\10\0\3\3\5\0\13\3\1\45"+
    "\6\3\10\0\3\3\5\0\7\3\1\46\12\3\10\0"+
    "\3\3\5\0\15\3\1\47\4\3\10\0\3\3\5\0"+
    "\3\3\1\50\16\3\10\0\3\3\5\0\2\3\1\51"+
    "\12\3\1\52\4\3\10\0\3\3\5\0\15\3\1\53"+
    "\4\3\10\0\3\3\5\0\6\3\1\54\13\3\42\0"+
    "\1\55\44\0\1\7\42\0\1\7\35\0\1\7\7\0"+
    "\1\31\1\0\1\31\5\0\22\31\10\0\1\31\1\0"+
    "\1\32\1\56\4\0\22\31\11\0\1\57\2\56\35\0"+
    "\10\34\1\0\31\34\7\60\1\61\32\60\1\0\3\3"+
    "\5\0\2\3\1\62\17\3\10\0\3\3\5\0\5\3"+
    "\1\63\14\3\10\0\3\3\5\0\15\3\1\64\4\3"+
    "\10\0\3\3\5\0\7\3\1\65\12\3\10\0\3\3"+
    "\5\0\14\3\1\66\5\3\10\0\3\3\5\0\11\3"+
    "\1\67\10\3\10\0\3\3\5\0\2\3\1\70\17\3"+
    "\10\0\3\3\5\0\1\3\1\71\10\3\1\72\7\3"+
    "\10\0\3\3\5\0\5\3\1\73\14\3\10\0\3\3"+
    "\5\0\3\3\1\74\16\3\10\0\3\3\5\0\16\3"+
    "\1\75\3\3\10\0\3\3\5\0\15\3\1\76\4\3"+
    "\10\0\3\3\5\0\2\3\1\77\17\3\12\0\2\56"+
    "\37\0\1\57\37\0\7\60\1\100\32\60\6\0\1\101"+
    "\1\61\33\0\3\3\5\0\3\3\1\102\16\3\10\0"+
    "\3\3\5\0\1\3\1\103\20\3\10\0\3\3\5\0"+
    "\3\3\1\104\16\3\10\0\3\3\5\0\7\3\1\105"+
    "\12\3\10\0\3\3\5\0\3\3\1\106\16\3\10\0"+
    "\3\3\5\0\10\3\1\107\11\3\10\0\3\3\5\0"+
    "\7\3\1\110\12\3\10\0\3\3\5\0\2\3\1\111"+
    "\17\3\10\0\3\3\5\0\5\3\1\112\14\3\10\0"+
    "\3\3\5\0\10\3\1\113\11\3\10\0\3\3\5\0"+
    "\10\3\1\114\11\3\7\0\6\60\1\101\1\100\32\60"+
    "\1\0\3\3\5\0\5\3\1\115\14\3\10\0\3\3"+
    "\5\0\5\3\1\116\14\3\10\0\3\3\5\0\1\3"+
    "\1\117\20\3\10\0\3\3\5\0\10\3\1\120\11\3"+
    "\10\0\3\3\5\0\7\3\1\121\12\3\10\0\3\3"+
    "\5\0\7\3\1\122\12\3\10\0\3\3\5\0\5\3"+
    "\1\123\14\3\10\0\3\3\5\0\1\3\1\124\20\3"+
    "\10\0\3\3\5\0\3\3\1\125\16\3\7\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[2210];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\4\1\1\11\25\1\1\0\17\1\1\11"+
    "\2\1\2\0\16\1\1\0\1\11\24\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[85];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
    public String lexeme;
    public int pos,lng,line;
    public String error;
    


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Lexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  Lexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 114) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public token yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 20: 
          { pos=yychar; lng=yylength(); lexeme=yytext(); return Float;
          }
        case 26: break;
        case 10: 
          { pos=yychar; lng=yylength(); lexeme=yytext(); return Do;
          }
        case 27: break;
        case 2: 
          { pos=yychar; lng=yylength(); lexeme=yytext(); return Identificador;
          }
        case 28: break;
        case 15: 
          { pos=yychar; lng=yylength(); lexeme=yytext(); return Main;
          }
        case 29: break;
        case 21: 
          { pos=yychar; lng=yylength(); lexeme=yytext(); return Print;
          }
        case 30: break;
        case 25: 
          { pos=yychar; lng=yylength(); lexeme=yytext(); return Boolean;
          }
        case 31: break;
        case 16: 
          { pos=yychar; lng=yylength(); lexeme=yytext(); return Then;
          }
        case 32: break;
        case 6: 
          { pos=yychar; lng=yylength(); lexeme=yytext(); return Relacional;
          }
        case 33: break;
        case 17: 
          { pos=yychar; lng=yylength(); lexeme=yytext(); return Else;
          }
        case 34: break;
        case 13: 
          { pos=yychar; lng=yylength(); lexeme=yytext(); return End;
          }
        case 35: break;
        case 1: 
          { pos=yychar; lng=yylength(); error=yytext(); return ERROR ;
          }
        case 36: break;
        case 11: 
          { pos=yychar; lng=yylength(); lexeme=yytext(); return Flotante;
          }
        case 37: break;
        case 12: 
          { pos=yychar; lng=yylength(); lexeme=yytext(); return Int;
          }
        case 38: break;
        case 22: 
          { pos=yychar; lng=yylength(); lexeme=yytext(); return Until;
          }
        case 39: break;
        case 24: 
          { pos=yychar; lng=yylength(); lexeme=yytext(); return Repeat;
          }
        case 40: break;
        case 9: 
          { pos=yychar; lng=yylength(); lexeme=yytext(); return If;
          }
        case 41: break;
        case 23: 
          { pos=yychar; lng=yylength(); lexeme=yytext(); return While;
          }
        case 42: break;
        case 18: 
          { pos=yychar; lng=yylength(); lexeme=yytext(); return Real;
          }
        case 43: break;
        case 14: 
          { pos=yychar; lng=yylength(); lexeme=yytext(); return Cin;
          }
        case 44: break;
        case 19: 
          { pos=yychar; lng=yylength(); lexeme=yytext(); return Cout;
          }
        case 45: break;
        case 4: 
          { /*Ignore*/
          }
        case 46: break;
        case 7: 
          { pos=yychar; lng=yylength(); error=yytext(); return ERROR;
          }
        case 47: break;
        case 8: 
          { pos=yychar; lng=yylength(); return Comentarios;
          }
        case 48: break;
        case 3: 
          { pos=yychar; lng=yylength(); lexeme=yytext(); line=yyline; return Entero;
          }
        case 49: break;
        case 5: 
          { pos=yychar; lng=yylength(); lexeme=yytext(); return Especial;
          }
        case 50: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            return null;
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }



 /*   public static void main(String[] args) {
        // TODO code application logic here
    }
   */
}
