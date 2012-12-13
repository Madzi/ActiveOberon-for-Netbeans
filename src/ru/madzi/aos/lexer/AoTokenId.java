package ru.madzi.aos.lexer;

import org.netbeans.api.lexer.Language;
import org.netbeans.api.lexer.TokenId;

/**
 * @author Dmitry Eliseev
 */
public class AoTokenId implements TokenId {

    private static final Language<AoTokenId> LANGUAGE = new AoLanguageHierarchy().language();

    private AoToken token;

    public static Language<AoTokenId> getLanguage() {
        return LANGUAGE;
    }

    public AoTokenId(AoToken token) {
        assert(token != null);
        this.token = token;
    }

    @Override
    public String name() {
        return token.getName();
    }

    @Override
    public int ordinal() {
        return token.getId();
    }

    @Override
    public String primaryCategory() {
        return token.getCategory().getName();
    }

}
