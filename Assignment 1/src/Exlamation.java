public class Exclamation extends Operator{

    @Override
    public int priority() {
        return 5;
    }

    @Override
    public Operand execute(Operand op1, Operand op2) {
        return new Operand(op1.getValue()-op2.getValue());
    }
}