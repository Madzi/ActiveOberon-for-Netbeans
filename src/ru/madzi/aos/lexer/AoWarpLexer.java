package ru.madzi.aos.lexer;

import org.netbeans.api.lexer.Token;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;

/**
 * @author Dmitry Eliseev
 */
public class AoWarpLexer implements Lexer<AoTokenId> {

    private LexerRestartInfo<AoTokenId> info;

    private AoLexer lexer;

    public AoWarpLexer(LexerRestartInfo<AoTokenId> info) {
        this.info = info;
        lexer = new AoLexer(new AoCharStream(info.input()));
    }

    public Token<AoTokenId> nextToken() {
        AoToken token = lexer.getToken();
        if (token != AoToken.EOF) {
            AoTokenId tokenId = AoLanguageHierarchy.getToken(token.getId());
            return info.tokenFactory().createToken(tokenId);
        }
        return null;
    }

    @Override
    public Object state() {
        return null;
    }

    @Override
    public void release() {
    }

}
