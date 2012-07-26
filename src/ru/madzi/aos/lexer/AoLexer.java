package ru.madzi.aos.lexer;

import org.netbeans.api.lexer.Token;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerInput;
import org.netbeans.spi.lexer.LexerRestartInfo;

/**
 * @author deliseev
 */
class AoLexer implements Lexer<AoTokenId> {

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
        return (char) info.input().read();
    }

    private void undoChar() {
        info.input().backup(1);
    }

    private AoToken getToken() {
        char ch = getChar();
        if (ch == LexerInput.EOF) {
            return AoToken.EOF;
        } else if (Character.isWhitespace(ch)) {
            return AoToken.WHITESPACE;
        } else if (Character.isDigit(ch)) {
            return AoToken.NUMBER;
        } else if (Character.isJavaIdentifierStart(ch)) {
            return AoToken.STRING;
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

}
