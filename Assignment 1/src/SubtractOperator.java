public class SubtractOperator extends Operator{

    @Override
    public int priority() {
        return 2;
    }

    @Override
    public Operand execute(Operand op1, Operand op2) {
        return new Operand(op1.getValue()-op2.getValue());
    }
}