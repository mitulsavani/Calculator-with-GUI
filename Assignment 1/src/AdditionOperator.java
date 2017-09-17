public class AdditionOperator extends Operator{

    @Override
    protected int priority() {
        return 2;
    }

    @Override
    protected Operand execute(Operand op1, Operand op2) {
        return new Operand(op1.getValue()+ op2.getValue());
    }
}
