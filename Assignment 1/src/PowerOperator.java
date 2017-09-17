public class PowerOperator extends Operator{

    @Override
    protected int priority() {
        return 4;
    }
    
    @Override
    protected Operand execute(Operand op1, Operand op2) 
    {
        int x=op1.getValue();
        int y=op2.getValue();
        return (new Operand((int)java.lang.Math.pow(x, y)));
    }
}

