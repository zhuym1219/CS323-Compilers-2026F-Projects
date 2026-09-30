import generated.Calc1.Calc1Lexer;
import generated.Calc1.Calc1Parser;
import org.antlr.v4.runtime.*;


public class Main {
    public static void main(String[] args) {
        // 从字符串获取字符流。若要从文件读取，可使用 CharStreams.fromFileName("文件路径")
        // 把要解析的字符串喂给 ANTLR
        CharStream input = CharStreams.fromString("2 + 3 * (5 - 4) / 2\n 3-4/2\n20 /4 -3\n((1+2)*3-5)/2 ");
        // 词法分析器
        Calc1Lexer lexer = new Calc1Lexer(input);
        // Token 流
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // 语法分析器
        Calc1Parser parser = new Calc1Parser(tokens);
        // 定义Visitor根节点 root context
        Calc1Parser.RootContext context = parser.root();
        CalcLab5Visitor visitor = new CalcLab5Visitor();
        for (Calc1Parser.ExprContext expr : context.expr()) {
            System.out.printf("%s = %s\n", expr.getText(), visitor.visit(expr));
        }
    }
}