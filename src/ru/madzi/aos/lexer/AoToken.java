package ru.madzi.aos.lexer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author deliseev
 */
public enum AoToken {

    EOF("EOF", AoCategory.WHITESPACE, 0),
    ERROR("ERROR", AoCategory.ERROR, 1),
    WHITESPACE("WHITESPACE", AoCategory.WHITESPACE, 2),
    STRING("STRING", AoCategory.STRING, 3),
    NUMBER("NUMBER", AoCategory.NUMBER, 4),
    COLON("COLON", AoCategory.SEPARATOR, 5),
    SEMICOLON("SEMICOLON", AoCategory.SEPARATOR, 6),
    PLUS("PLUS", AoCategory.OPERATOR, 7),
    MINUS("MINUS", AoCategory.OPERATOR, 8),
    BECOME("BECOME", AoCategory.OPERATOR, 9),
    DOT("DOT", AoCategory.SEPARATOR, 10),
    MODULE("MODULE", AoCategory.KEYWORD, 11),
    IDENTIFIER("IDENTIFIER", AoCategory.IDENTIFIER, 12);

    private int id;
    private String name;
    private AoCategory category;

    AoToken(String name, AoCategory category, int id) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public AoCategory getCategory() {
        return category;
    }

    public static List<AoToken> getTokens(AoCategory category) {
        List<AoToken> tokens = new ArrayList<AoToken>();
        for (AoToken token : AoToken.values()) {
            if (token.category == category) {
                tokens.add(token);
            }
        }
        return tokens;
    }

}
