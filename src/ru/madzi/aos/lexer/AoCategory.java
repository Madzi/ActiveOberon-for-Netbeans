package ru.madzi.aos.lexer;

/**
 *
 * @author Dmitry Eliseev
 */
public enum AoCategory {

    ERROR("error"),
    WHITESPACE("whitespace"),
    SEPARATOR("separator"),
    OPERATOR("operator"),
    STRING("string"),
    NUMBER("number"),
    DIRECTIVE("directive"),
    IDENTIFIER("identifier"),
    KEYWORD("keyword");

    private String name;

    AoCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
