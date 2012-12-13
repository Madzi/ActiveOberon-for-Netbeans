package ru.madzi.aos.lexer;

import java.util.TreeSet;
import org.netbeans.spi.lexer.LexerInput;

/**
 * @author Dmitry Eliseev
 */
public class AoCharStream {

    public static final char EOF = (char) -1;

    private TreeSet<Integer> newLines = new TreeSet<Integer>();

    private int index = 0;

    private int line = 1;

    private int charPositionInLine = 0;

    private LexerInput input;

    public AoCharStream(LexerInput input) {
        this.input = input;
        newLines.add(Integer.valueOf(0));
    }

    public int getLine() {
        return line;
    }

    public AoCharStream setLine(int line) {
        this.line = line;
        return this;
    }

    public int getCharPositionInLine() {
        return charPositionInLine;
    }

    public AoCharStream setCharPositionInLine(int charPositionInLine) {
        this.charPositionInLine = charPositionInLine;
        return this;
    }

    public int index() {
        return index;
    }

    public char read() {
        int result = input.read();
        index++;
        charPositionInLine++;
        if (result == '\n') {
            line++;
            charPositionInLine = 0;
            newLines.add(Integer.valueOf(index));
        }
        return (result != LexerInput.EOF) ? (char) result : EOF;
    }

    public void undoChar(int count) {
        int newIdx = index - count;
        while (newLines.last() > newIdx) {
            newLines.remove(newLines.last());
        }
        index = newIdx;
        line = newLines.size();
        charPositionInLine = index - newLines.last();
        input.backup(count);
    }

}
