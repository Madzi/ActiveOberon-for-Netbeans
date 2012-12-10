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
    IDENTIFIER("IDENTIFIER", AoCategory.IDENTIFIER, 4),
    NUMBER("NUMBER", AoCategory.NUMBER, 5),
    COMMENT("COMMENT", AoCategory.COMMENT, 6),
    ARRAY("ARRAY", AoCategory.KEYWORD, 7),
    AWAIT("AWAIT", AoCategory.KEYWORD, 8),
    BEGIN("BEGIN", AoCategory.KEYWORD, 9),
    BY("BY", AoCategory.KEYWORD, 10),
    CONST("CONST", AoCategory.KEYWORD, 11),
    CASE("CASE", AoCategory.KEYWORD, 12),
    CODE("CODE", AoCategory.KEYWORD, 13),
    DO("DO", AoCategory.KEYWORD, 14),
    DIV("DIV", AoCategory.KEYWORD, 15),
    DEFINITION("DEFINITION", AoCategory.KEYWORD, 16),
    END("END", AoCategory.KEYWORD, 17),
    ELSE("ELSE", AoCategory.KEYWORD, 18),
    ELSIF("ELSIF", AoCategory.KEYWORD, 19),
    EXIT("EXIT", AoCategory.KEYWORD, 20),
    FALSE("FALSE", AoCategory.KEYWORD, 21),
    FOR("FOR", AoCategory.KEYWORD, 22),
    FINALLY("FINALLY", AoCategory.KEYWORD, 23),
    IF("IF", AoCategory.KEYWORD, 24),
    IN("IN", AoCategory.KEYWORD, 25),
    IS("IS", AoCategory.KEYWORD, 26),
    IMPORT("IMPORT", AoCategory.KEYWORD, 27),
    IMPLEMENTS("IMPLEMENTS", AoCategory.KEYWORD, 28),
    LOOP("LOOP", AoCategory.KEYWORD, 29),
    MOD("MOD", AoCategory.KEYWORD, 30),
    MODULE("MODULE", AoCategory.KEYWORD, 31),
    NIL("NIL", AoCategory.KEYWORD, 32),
    OBJECT("OBJECT", AoCategory.KEYWORD, 33),
    OR("OR", AoCategory.KEYWORD, 34),
    OF("OF", AoCategory.KEYWORD, 35),
    OPERATOR("OPERATOR", AoCategory.KEYWORD, 36),
    POINTER("POINTER", AoCategory.KEYWORD, 37),
    PROCEDURE("PROCEDURE", AoCategory.KEYWORD, 38),
    RECORD("RECORD", AoCategory.KEYWORD, 39),
    REPEAT("REPEAT", AoCategory.KEYWORD, 40),
    RETURN("RETURN", AoCategory.KEYWORD, 41),
    REFINES("REFINES", AoCategory.KEYWORD, 42),
    THEN("THEN", AoCategory.KEYWORD, 43),
    TRUE("TRUE", AoCategory.KEYWORD, 44),
    TO("TO", AoCategory.KEYWORD, 45),
    UNTIL("UNTIL", AoCategory.KEYWORD, 46),
    VAR("VAR", AoCategory.KEYWORD, 47),
    WHILE("WHILE", AoCategory.KEYWORD, 48),
    WITH("WITH", AoCategory.KEYWORD, 49),
    LBRACE("LBRACE", AoCategory.SEPARATOR, 50),
    RBRACE("RBRACE", AoCategory.SEPARATOR, 51),
    BAR("BAR", AoCategory.SEPARATOR, 56),
    /*
     * () [] {} |
     * " ' , . .. : ;
     * & ~ ^ ?
     * # .# = .= < .< <= .<= > .> >= .>=
     * + +* - * .* ** / ./ \ `
     */
    SYSTEM("SYSTEM", AoCategory.KEYWORD, 100),
    SELF("SELF", AoCategory.KEYWORD, 101),
    CHAR("CHAR", AoCategory.KEYWORD, 102),
    CHAR8("CHAR8", AoCategory.KEYWORD, 103),
    CHAR16("CHAR16", AoCategory.KEYWORD, 104),
    CHAR32("CHAR32", AoCategory.KEYWORD, 105),
    SHORTINT("SHORTINT", AoCategory.KEYWORD, 106),
    INTEGER("INTEGER", AoCategory.KEYWORD, 107),
    LONGINT("LONGINT", AoCategory.KEYWORD, 108),
    HUGEINT("HUGEINT", AoCategory.KEYWORD, 109),
    REAL("REAL", AoCategory.KEYWORD, 110),
    LONGREAL("LONGREAL", AoCategory.KEYWORD, 111),
    BOOLEAN("BOOLEAN", AoCategory.KEYWORD, 112),
    SET("SET", AoCategory.KEYWORD, 113),
    ANY("ANY", AoCategory.KEYWORD, 114),
    ABS("ABS", AoCategory.KEYWORD, 115),
    ASH("ASH", AoCategory.KEYWORD, 116),
    CAP("CAP", AoCategory.KEYWORD, 117),
    CHR("CHR", AoCategory.KEYWORD, 118),
    ENTIER("ENTIER", AoCategory.KEYWORD, 119),
    LEN("LEN", AoCategory.KEYWORD, 120),
    LONG("LONG", AoCategory.KEYWORD, 121),
    MAX("MAX", AoCategory.KEYWORD, 122),
    MIN("MIN", AoCategory.KEYWORD, 123),
    ODD("ODD", AoCategory.KEYWORD, 124),
    ORD("ORD", AoCategory.KEYWORD, 125),
    SHORT("SHORT", AoCategory.KEYWORD, 126),
    SIZE("SIZE", AoCategory.KEYWORD, 127),
    ASSERT("ASSERT", AoCategory.KEYWORD, 128),
    COPY("COPY", AoCategory.KEYWORD, 129),
    INC("INC", AoCategory.KEYWORD, 130),
    DEC("DEC", AoCategory.KEYWORD, 131),
    EXCL("EXCL", AoCategory.KEYWORD, 132),
    HALT("HALT", AoCategory.KEYWORD, 133),
    INCL("INCL", AoCategory.KEYWORD, 134),
    NEW("NEW", AoCategory.KEYWORD, 135);

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
