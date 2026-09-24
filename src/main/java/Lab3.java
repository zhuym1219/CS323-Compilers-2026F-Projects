import generated.Calc1.Calc1;
import org.antlr.v4.runtime.*;

import java.util.List;

public class Lab3 {
    public static void main(String[] args) {
        CharStream charStream = CharStreams.fromString("//comment\n//ccc\n1 + 2");
        Calc1 lexer = new Calc1(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer, Calc1.WHITESPACE);
        tokens.fill();
        Vocabulary vocabulary = lexer.getVocabulary();

// 示例：获取索引为1的Token右边的所有WHITESPACE通道的Token
        List<Token> wsTokens = tokens.getHiddenTokensToRight(2, Calc1.WHITESPACE);

        for (Token token : wsTokens) {
            System.out.printf("Line:%d:%d %s %s\n",
                    token.getLine(),
                    token.getCharPositionInLine(),
                    vocabulary.getSymbolicName(token.getType()),
                    token.getText());
        }

        List<Token> commentTokens = tokens.getHiddenTokensToLeft(2, Calc1.COMMENTS);
        for (Token token : commentTokens) {
            System.out.printf("Line:%d:%d %s %s\n",
                    token.getLine(),
                    token.getCharPositionInLine(),
                    vocabulary.getSymbolicName(token.getType()),
                    token.getText());
        }
    }
}
