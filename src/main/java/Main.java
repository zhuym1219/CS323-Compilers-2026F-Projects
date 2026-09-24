import generated.Calc1.Calc1;
import org.antlr.v4.runtime.*;

import java.io.IOException;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        // 从字符串获取字符流。若要从文件读取，可使用 CharStreams.fromFileName("文件路径")
        CharStream charStream = null;
        try {
            charStream = CharStreams.fromFileName("./testcases/lab3/lab3_String.txt");
            Calc1 lexer = new Calc1(charStream);

            // 基于词法分析器实例，创建 Token 流
            CommonTokenStream tokens = new CommonTokenStream(lexer);

            // 调用 fill() 方法，让词法分析器开始工作，填充 Token 流
            tokens.fill();
            Vocabulary vocabulary = lexer.getVocabulary();

            // 打印 Token 流信息
            int count = 0;
            for (Token token : tokens.getTokens()) {
                if (token.getChannel() == 0) {
                    System.out.printf("Line:%d:%d %s %s\n",
                            token.getLine(),
                            token.getCharPositionInLine(),
                            vocabulary.getSymbolicName(token.getType()),
                            token.getText());
                } else if (token.getChannel() == 1) {
                    count++;
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}