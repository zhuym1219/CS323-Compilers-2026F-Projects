import generated.Calc1.Calc1BaseVisitor;
import generated.Calc1.Calc1Parser;

public class CalcLab5Visitor extends Calc1BaseVisitor<Double> {

    @Override
    public Double visitAren(Calc1Parser.ArenContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public Double visitGoFactor(Calc1Parser.GoFactorContext ctx) {
        if (ctx.factor().INT() != null) {
            return Double.valueOf(ctx.factor().INT().getText());
        }
        return 0.0;
    }

    @Override
    public Double visitAddSub(Calc1Parser.AddSubContext ctx) {
        double value1 = visit(ctx.expr(0));
        double value2 = visit(ctx.expr(1));
        if (ctx.ADD() != null) {
            return value1 + value2;
        } else {
            return value1 - value2;
        }
    }

    @Override
    public Double visitMulDiv(Calc1Parser.MulDivContext ctx) {
        double value1 = visit(ctx.expr(0));
        double value2 = visit(ctx.expr(1));
        if (ctx.MUL() != null) {
            return value1 * value2;
        } else {
            return value1 / value2;
        }
    }
}
