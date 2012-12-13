package ru.madzi.aos.lexer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.netbeans.spi.lexer.LanguageHierarchy;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;

/**
 * @author Dmitry Eliseev
 */
public class AoLanguageHierarchy extends LanguageHierarchy<AoTokenId> {

    private static final Map<Integer, AoTokenId> idToToken = new HashMap<Integer, AoTokenId>();

    private static void init() {
        for (AoToken token : AoToken.values()) {
            idToToken.put(token.getId(), new AoTokenId(token));
        }
    }

    public static AoTokenId getToken(int id) {
        if (idToToken.isEmpty()) {
            init();
        }
        return idToToken.get(id);
    }

    @Override
    protected Collection<AoTokenId> createTokenIds() {
        if (idToToken.isEmpty()) {
            init();
        }
        return idToToken.values();
    }

    @Override
    protected Lexer<AoTokenId> createLexer(LexerRestartInfo<AoTokenId> info) {
        return new AoWarpLexer(info);
    }

    @Override
    protected String mimeType() {
        return "text/x-active-oberon";
    }

}
