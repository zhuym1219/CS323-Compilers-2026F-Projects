import generated.Calc1.Calc1BaseListener;
import generated.Calc1.Calc1Parser;

public class CalcLab5Listener extends Calc1BaseListener {
    private static double result = 0;

    @Override
    public void enterFactor(Calc1Parser.FactorContext ctx) {
        if (ctx.getText().equals("+")) {
            result += Double.parseDouble(ctx.getText());
        } else {
            throw new RuntimeException("Not a number");
        }
    }

    @Override
    public void enterMulDiv(Calc1Parser.MulDivContext ctx) {
        if(ctx.getText().equals("*")) {

        }
        super.enterMulDiv(ctx);
    }

    @Override
    public void enterAddSub(Calc1Parser.AddSubContext ctx) {
        super.enterAddSub(ctx);
    }

    @Override
    public void enterAren(Calc1Parser.ArenContext ctx) {
        super.enterAren(ctx);
    }

    public static double getResult() {
        return result;
    }
}
