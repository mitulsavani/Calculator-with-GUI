public class PowerOperator extends Operator{

    @Override
    public int priority() {
        return 4;
    }
    @Override
    public Operand execute(Operand op1, Operand op2) {
        
        int ans=0;
        int x=op1.getValue();
        int y=op2.getValue();
        
        for(int i=1; i<=y; i++)
            ans+= ans*i;
        
        return new Operand((int)ans);
    }
    
    
}

