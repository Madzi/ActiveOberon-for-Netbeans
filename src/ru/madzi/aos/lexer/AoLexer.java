package ru.madzi.aos.lexer;

/**
 * @author Dmitry Eliseev
 */
class AoLexer {

    private AoCharStream stream;

    private long intVal;

    private double realVal;

    private String strVal;

    public AoLexer(AoCharStream stream) {
        this.stream = stream;
    }

    private char getChar() {
        return stream.read();
    }

    private void undoChar() {
        stream.undoChar(1);
    }

    public AoToken getToken() {
        char ch = getChar();
        if (ch == stream.EOF) {
            return AoToken.EOF;
        } else if (Character.isWhitespace(ch)) {
            return AoToken.WHITESPACE;
        } else if (Character.isDigit(ch)) {
            undoChar();
            return number();
        } else if (Character.isJavaIdentifierStart(ch)) {
            undoChar();
            return identifier();
        } else {
            switch (ch) {
                case '\'':
                case '"':
                    return string(ch);

                case '#':
                    return AoToken.NEQ;

                case '&':
                    return AoToken.AND;

                case '(':
                    ch = getChar();
                    if (ch == '*') {
                        return comment();
                    }
                    undoChar();
                    return AoToken.LPAREN;

                case ')':
                    return AoToken.RPAREN;

                case '*':
                    return AoToken.TIMES;

                case '+':
                    return AoToken.PLUS;

                case ',':
                    return AoToken.COMMA;

                case '-':
                    return AoToken.MINUS;

                case '.':
                    ch = getChar();
                    if (ch == '.') {
                        return AoToken.UPTO;
                    } else if (ch == '*') {
                        return AoToken.ELEMENTPRODUCT;
                    } else if (ch == '/') {
                        return AoToken.ELEMENTQUOTIENT;
                    } else if (ch == '=') {
                        return AoToken.EEQL;
                    } else if (ch == '#') {
                        return AoToken.ENEQ;
                    } else if (ch == '>') {
                        ch = getChar();
                        if (ch == '=') {
                            return AoToken.EGEQ;
                        }
                        undoChar();
                        return AoToken.EGTR;
                    } else if (ch == '<') {
                        ch = getChar();
                        if (ch == '=') {
                            return AoToken.ELEQ;
                        }
                        undoChar();
                        return AoToken.ELSS;
                    }
                    undoChar();
                    return AoToken.LPAREN;

                case '/':
                    return AoToken.SLASH;

                case ':':
                    ch = getChar();
                    if (ch == '=') {
                        return AoToken.BECOMES;
                    }
                    undoChar();
                    return AoToken.COLON;

                case ';':
                    return AoToken.SEMICOLON;

                case '<':
                    ch = getChar();
                    if (ch == '=') {
                        return AoToken.LEQ;
                    }
                    undoChar();
                    return AoToken.LSS;

                case '=':
                    return AoToken.EQL;

                case '>':
                    ch = getChar();
                    if (ch == '=') {
                        return AoToken.GEQ;
                    }
                    undoChar();
                    return AoToken.GTR;

                case '[':
                    return AoToken.LBRAK;

                case ']':
                    return AoToken.RBRAK;

                case '^':
                    return AoToken.ARROW;

                case '{':
                    return AoToken.LBRACE;

                case '|':
                    return AoToken.BAR;

                case '}':
                    return AoToken.RBRACE;

                case '~':
                    return AoToken.NOT;

                case '`':
                    return AoToken.TRANSPOSE;

                case '?':
                    return AoToken.QMARK;

                case '\\':
                    return AoToken.BACKSLASH;

                default: return AoToken.ERROR;
            }
        }
    }

    private static double ten(int e) {
        double x = 1;
        double p = 10;
        while (e > 0) {
            if (e % 2 == 1) { // ODD(e)
                x *= p;
            }
            e = e / 2;
            if (e > 0) {
                p *= p;
            }
        }
        return x;
    }

    private int ord(char ch, boolean hex) {
        switch (ch) {
            case '0':
                return 0;

            case '1':
                return 1;

            case '2':
                return 2;

            case '3':
                return 3;

            case '4':
                return 4;

            case '5':
                return 5;

            case '6':
                return 6;

            case '7':
                return 7;

            case '8':
                return 8;

            case '9':
                return 9;

            case 'A':
                return hex ? 10 : -1;

            case 'B':
                return hex ? 11 : -1;

            case 'C':
                return hex ? 12 : -1;

            case 'D':
                return hex ? 13 : -1;

            case 'E':
                return hex ? 14 : -1;

            case 'F':
                return hex ? 15 : -1;
        }
        return -1;
    }

    private int parseInt(String str, char end) {
        return 0;
        //TODO: Write parse int;
    }

    private AoToken number() {
        boolean wasdot = false;
        boolean real = false;
        char prev = stream.EOF;
        char ch = getChar();
        StringBuilder sb = new StringBuilder();
        while (ch != stream.EOF && isNumberChar(ch)) {
            if (ch == 'H') {
                intVal = parseInt(sb.toString(), ch);
                return real ? AoToken.ERROR : AoToken.NUMBER;
            } else if (ch == 'X') {
                intVal = parseInt(sb.toString(), ch);
                return real ? AoToken.ERROR : AoToken.NUMBER;
            } else if (ch == '.') {
                if (ch == prev) { // 123..321
                    undoChar();
                    undoChar();
                    intVal = parseInt(sb.toString(), 'D');
                    return real ? AoToken.ERROR : AoToken.NUMBER;
                } else if (wasdot) {
                    return AoToken.ERROR;
                } else {
                    wasdot = true;
                }
            } else if (ch == '-') {
                if (prev != stream.EOF && prev != 'E') {
                    undoChar();
                    return AoToken.NUMBER;
                }
            } else if (ch == '+') {
                if (prev != stream.EOF && prev != 'E') {
                    undoChar();
                    return AoToken.NUMBER;
                }
            }
            prev = ch;
            sb.append(ch);
            ch = getChar();
        }
        undoChar();
        return AoToken.NUMBER;
    }

    private AoToken identifier() {
        char ch = getChar();
        StringBuilder sb = new StringBuilder();
        while (ch != stream.EOF && Character.isJavaIdentifierPart(ch)) {
            sb.append(ch);
            ch = getChar();
        }
        undoChar();
        strVal = sb.toString();
        for (AoToken token : AoToken.values()) {
            if (strVal.equals(token.getName())) {
                return token;
            }
        }
        return AoToken.IDENTIFIER;
    }

    private AoToken string(char end) {
        char ch = getChar();
        StringBuilder str = new StringBuilder();
        while (ch != stream.EOF && ch != end) {
            str.append(ch);
            ch = getChar();
        }
        strVal = str.toString();
        if (ch == stream.EOF) {
            undoChar();
            return AoToken.ERROR;
        }
        return AoToken.STRING;
    }

    private AoToken comment() {
        int level = 1;
        CommentState state = CommentState.STAR;
        char ch = getChar();
        while (ch != stream.EOF && level > 0) {
            if (ch == '(') {
                state = CommentState.LPAREN;
            } else if (ch == '*') {
                if (state == CommentState.LPAREN) {
                    level++;
                }
                state = CommentState.STAR;
            } else if (ch == ')') {
                if (state == CommentState.STAR) {
                    level--;
                }
                state = CommentState.RPAREN;
            } else {
                state = CommentState.TEXT;
            }
            ch = getChar();
        }
        if (ch == stream.EOF) {
            undoChar();
            return AoToken.ERROR;
        }
        return AoToken.COMMENT;
    }

    private static boolean isNumberChar(char ch) {
        switch (ch) {
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
            case 'H':
            case 'X':
            case '.':
            case '-':
            case '+':
                return true;
        }
        return false;
    }

    private enum CommentState {
        TEXT,
        LPAREN,
        STAR,
        RPAREN
    }

}
