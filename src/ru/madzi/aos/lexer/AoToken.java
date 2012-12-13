package ru.madzi.aos.lexer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dmitry Eliseev
 */
public enum AoToken {

    WHITESPACE("WHITESPACE", AoCategory.WHITESPACE, 0),
    TIMES("*", AoCategory.OPERATOR, 1),
    SLASH("/", AoCategory.OPERATOR, 2),
    DIV("DIV", AoCategory.OPERATOR, 3),
    MOD("MOD", AoCategory.OPERATOR, 4),
    AND("&", AoCategory.OPERATOR, 5),
    PLUS("+", AoCategory.OPERATOR, 6),
    MINUS("-", AoCategory.OPERATOR, 7),
    OR("OR", AoCategory.OPERATOR, 8),
    EQL("=", AoCategory.OPERATOR, 9),
    NEQ("#", AoCategory.OPERATOR, 10),
    LSS("<", AoCategory.OPERATOR, 11),
    LEQ("<=", AoCategory.OPERATOR, 12),
    GTR(">", AoCategory.OPERATOR, 13),
    GEQ(">=", AoCategory.OPERATOR, 14),
    IN("IN", AoCategory.OPERATOR, 15),
    IS("IS", AoCategory.KEYWORD, 16),
    ARROW("^", AoCategory.OPERATOR, 17),
    PERIOD(".", AoCategory.SEPARATOR, 18),
    COMMA(",", AoCategory.SEPARATOR, 19),
    COLON(":", AoCategory.SEPARATOR, 20),
    UPTO("..", AoCategory.OPERATOR, 21),
    RPAREN(")", AoCategory.SEPARATOR, 22),
    RBRAK("]", AoCategory.SEPARATOR, 23),
    RBRACE("}", AoCategory.SEPARATOR, 24),
    OF("OF", AoCategory.KEYWORD, 25),
    THEN("THEN", AoCategory.KEYWORD, 26),
    DO("DO", AoCategory.KEYWORD, 27),
    TO("TO", AoCategory.KEYWORD, 28),
    BY("BY", AoCategory.KEYWORD, 29),
    LPAREN("(", AoCategory.SEPARATOR, 30),
    LBRAK("[", AoCategory.SEPARATOR, 31),
    LBRACE("{", AoCategory.SEPARATOR, 32),
    NOT("~", AoCategory.OPERATOR, 33),
    BECOMES(":=", AoCategory.OPERATOR, 34),
    NUMBER("NUMBER", AoCategory.NUMBER, 35),
    NIL("NIL", AoCategory.POINTER, 36),
    TRUE("TRUE", AoCategory.TYPE, 37),
    FALSE("FALSE", AoCategory.TYPE, 38),
    STRING("STRING", AoCategory.STRING, 39),
    IDENTIFIER("IDENTIFIER", AoCategory.IDENTIFIER, 40),
    SEMICOLON(";", AoCategory.SEPARATOR, 41),
    BAR("|", AoCategory.SEPARATOR, 42),
    END("END", AoCategory.KEYWORD, 43),
    ELSE("ELSE", AoCategory.KEYWORD, 44),
    ELSIF("ELSIF", AoCategory.KEYWORD, 45),
    UNTIL("UNTIL", AoCategory.KEYWORD, 46),
    IF("IF", AoCategory.KEYWORD, 47),
    CASE("CASE", AoCategory.KEYWORD, 48),
    WHILE("WHILE", AoCategory.KEYWORD, 49),
    REPEAT("REPEAT", AoCategory.KEYWORD, 50),
    FOR("FOR", AoCategory.KEYWORD, 51),
    LOOP("LOOP", AoCategory.KEYWORD, 52),
    WITH("WITH", AoCategory.KEYWORD, 53),
    EXIT("EXIT", AoCategory.KEYWORD, 54),
    RETURN("RETURN", AoCategory.KEYWORD, 55),
    ARRAY("ARRAY", AoCategory.KEYWORD, 56),
    OBJECT("OBJECT", AoCategory.KEYWORD, 57),
    RECORD("RECORD", AoCategory.KEYWORD, 58),
    POINTER("POINTER", AoCategory.KEYWORD, 59),
    BEGIN("BEGIN", AoCategory.KEYWORD, 60),
    CONST("CONST", AoCategory.KEYWORD, 61),
    TYPE("TYPE", AoCategory.KEYWORD, 62),
    VAR("VAR", AoCategory.KEYWORD, 63),
    PROCEDURE("PROCEDURE", AoCategory.KEYWORD, 64),
    IMPORT("IMPORT", AoCategory.KEYWORD, 65),
    MODULE("MODULE", AoCategory.KEYWORD, 66),
    CODE("CODE", AoCategory.KEYWORD, 67),
    COMMENT("COMMENT", AoCategory.COMMENT, 68),
    WARNING("WARNING", AoCategory.WARNING, 69),
    ERROR("ERROR", AoCategory.ERROR, 70),
    BOOLEAN("BOOLEAN", AoCategory.TYPE, 71),
    CHAR("CHAR", AoCategory.TYPE, 72),
    SHORTINT("SHORTINT", AoCategory.TYPE, 73),
    INTEGER("INTEGER", AoCategory.TYPE, 74),
    LONGINT("LONGINT", AoCategory.TYPE, 75),
    SET("SET", AoCategory.TYPE, 76),
    SYSTEM("SYSTEM", AoCategory.SYSTEM, 80),
    AWAIT("AWAIT", AoCategory.KEYWORD, 81),
    DEFINITION("DEFINITION", AoCategory.KEYWORD, 82),
    FINALLY("FINALLY", AoCategory.KEYWORD, 83),
    IMPLEMENTS("IMPLEMENTS", AoCategory.KEYWORD, 84),
    OPERATOR("OPERATOR", AoCategory.KEYWORD, 85),
    REFINES("REFINES", AoCategory.KEYWORD, 86),
    QMARK("?", AoCategory.OPERATOR, 87),
    ENEQ(".#", AoCategory.OPERATOR, 88),
    EEQL(".=", AoCategory.OPERATOR, 89),
    ELSS(".<", AoCategory.OPERATOR, 90),
    ELEQ(".<=", AoCategory.OPERATOR, 91),
    EGTR(".>", AoCategory.OPERATOR, 92),
    EGEQ(".>=", AoCategory.OPERATOR, 93),
    DTIMES("+*", AoCategory.OPERATOR, 94),
    ELEMENTPRODUCT(".*", AoCategory.OPERATOR, 95),
    SCALARPRODUCT("**", AoCategory.OPERATOR, 96),
    ELEMENTQUOTIENT("./", AoCategory.OPERATOR, 97),
    BACKSLASH("\\", AoCategory.OPERATOR, 98),
    TRANSPOSE("`", AoCategory.OPERATOR, 99),
    EOF("EOF", AoCategory.WHITESPACE, 100),
    SELF("SELF", AoCategory.POINTER, 101),
    CHAR8("CHAR8", AoCategory.TYPE, 102),
    CHAR16("CHAR16", AoCategory.TYPE, 103),
    CHAR32("CHAR32", AoCategory.TYPE, 104),
    HUGEINT("HUGEINT", AoCategory.TYPE, 105),
    REAL("REAL", AoCategory.TYPE, 110),
    LONGREAL("LONGREAL", AoCategory.TYPE, 111),
    ANY("ANY", AoCategory.POINTER, 114),
    ABS("ABS", AoCategory.SYSTEM, 115),
    ASH("ASH", AoCategory.SYSTEM, 116),
    CAP("CAP", AoCategory.SYSTEM, 117),
    CHR("CHR", AoCategory.SYSTEM, 118),
    ENTIER("ENTIER", AoCategory.SYSTEM, 119),
    LEN("LEN", AoCategory.SYSTEM, 120),
    LONG("LONG", AoCategory.SYSTEM, 121),
    MAX("MAX", AoCategory.SYSTEM, 122),
    MIN("MIN", AoCategory.SYSTEM, 123),
    ODD("ODD", AoCategory.SYSTEM, 124),
    ORD("ORD", AoCategory.SYSTEM, 125),
    SHORT("SHORT", AoCategory.SYSTEM, 126),
    SIZE("SIZE", AoCategory.SYSTEM, 127),
    ASSERT("ASSERT", AoCategory.SYSTEM, 128),
    COPY("COPY", AoCategory.SYSTEM, 129),
    INC("INC", AoCategory.SYSTEM, 130),
    DEC("DEC", AoCategory.SYSTEM, 131),
    EXCL("EXCL", AoCategory.SYSTEM, 132),
    HALT("HALT", AoCategory.SYSTEM, 133),
    INCL("INCL", AoCategory.SYSTEM, 134),
    NEW("NEW", AoCategory.SYSTEM, 135);

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
