package ru.madzi.aos.lexer;

import org.netbeans.api.lexer.Token;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerInput;
import org.netbeans.spi.lexer.LexerRestartInfo;

/**
 * @author deliseev
 */
class AoLexer implements Lexer<AoTokenId> {

    public static final char EOF = (char) -1;

    private LexerRestartInfo<AoTokenId> info;

    public AoLexer(LexerRestartInfo<AoTokenId> info) {
        this.info = info;
    }

    @Override
    public Token<AoTokenId> nextToken() {
        return info.tokenFactory().createToken(AoLanguageHierarchy.getToken(getToken().getId()));
    }

    @Override
    public Object state() {
        return null;
    }

    @Override
    public void release() {
    }

    private char getChar() {
        int sym = info.input().read();
        return sym == LexerInput.EOF ? EOF : (char) sym;
    }

    private void undoChar() {
        info.input().backup(1);
    }

    private AoToken getToken() {
        char ch = getChar();
        if (ch == EOF) {
            return AoToken.EOF;
        } else if (Character.isWhitespace(ch)) {
            return AoToken.WHITESPACE;
        } else if (Character.isDigit(ch)) {
            return AoToken.NUMBER;
        } else if (Character.isJavaIdentifierStart(ch)) {
            undoChar();
            return identifier();
        } else {
            switch (ch) {
                case '.' :
                    return AoToken.DOT;
                case ';' :
                    return AoToken.SEMICOLON;
                case ':' :
                    ch = getChar();
                    if (ch == '=') {
                        return AoToken.BECOME;
                    } else {
                        undoChar();
                        return AoToken.COLON;
                    }
                default: return AoToken.ERROR;
            }
        }
    }

    private AoToken identifier() {
        char ch = getChar();
        StringBuilder testWord = new StringBuilder();
        while (ch != EOF && Character.isJavaIdentifierPart(ch)) {
            testWord.append(ch);
            ch = getChar();
        }
        if (ch == EOF) {
            undoChar();
        }
        String test = testWord.toString();
        for (AoToken token : AoToken.getTokens(AoCategory.KEYWORD)) {
            if (test.equals(token.getName())) {
                return token;
            }
        }
        return AoToken.IDENTIFIER;
    }

}
