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
    COMMENT("COMMENT", AoCategory.COMMENT, 5),
    SEMICOLON("SEMICOLON", AoCategory.SEPARATOR, 6),
    PLUS("PLUS", AoCategory.OPERATOR, 7),
    MINUS("MINUS", AoCategory.OPERATOR, 8),
    BECOME("BECOME", AoCategory.OPERATOR, 9),
    DOT("DOT", AoCategory.SEPARATOR, 10),
    IDENTIFIER("IDENTIFIER", AoCategory.IDENTIFIER, 11),
    BY("BY", AoCategory.KEYWORD, 12),
    DO("DO", AoCategory.KEYWORD, 13),
    IF("IF", AoCategory.KEYWORD, 14),
    IN("IN", AoCategory.KEYWORD, 15),
    TO("TO", AoCategory.KEYWORD, 16),
    END("END", AoCategory.KEYWORD, 17),
    FOR("FOR", AoCategory.KEYWORD, 18),
    VAR("VAR", AoCategory.KEYWORD, 19),
    CASE("CASE", AoCategory.KEYWORD, 20),
    CODE("CODE", AoCategory.KEYWORD, 21),
    ELSE("ELSE", AoCategory.KEYWORD, 22),
    EXIT("EXIT", AoCategory.KEYWORD, 23),
    LOOP("LOOP", AoCategory.KEYWORD, 24),
    THEN("THEN", AoCategory.KEYWORD, 25),
    TYPE("TYPE", AoCategory.KEYWORD, 26),
    WITH("WITH", AoCategory.KEYWORD, 27),
    ARRAY("ARRAY", AoCategory.KEYWORD, 28),
    AWAIT("AWAIT", AoCategory.KEYWORD, 29),
    BEGIN("BEGIN", AoCategory.KEYWORD, 30),
    CONST("CONST", AoCategory.KEYWORD, 31),
    ELSIF("ELSIF", AoCategory.KEYWORD, 32),
    WHILE("WHILE", AoCategory.KEYWORD, 33),
    UNTIL("UNTIL", AoCategory.KEYWORD, 34),
    IMPORT("IMPORT", AoCategory.KEYWORD, 35),
    MODULE("MODULE", AoCategory.KEYWORD, 36),
    OBJECT("OBJECT", AoCategory.KEYWORD, 37),
    RECORD("RECORD", AoCategory.KEYWORD, 38),
    REPEAT("REPEAT", AoCategory.KEYWORD, 39),
    RETURN("RETURN", AoCategory.KEYWORD, 40),
    FINALLY("FINALLY", AoCategory.KEYWORD, 41),
    POINTER("POINTER", AoCategory.KEYWORD, 42),
    OPERATOR("OPERATOR", AoCategory.KEYWORD, 43),
    PROCEDURE("PROCEDURE", AoCategory.KEYWORD, 44),
    COLON("COLON", AoCategory.SEPARATOR, 45);

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
