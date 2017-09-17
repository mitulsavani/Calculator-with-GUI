public class PowerOperator extends Operator{

    @Override
    public int priority() {
        return 4;
    }
    @Override
    public Operand execute(Operand op1, Operand op2) 
    {
        
        System.out.println("Ans: ");
        int ans=1;
        int x=op1.getValue();
        int y=op2.getValue();
        
        for(int i=1; i<=y; i++)
        {    ans+= x*i;
             
        }
        return (new Operand(ans));
    }
    
    
}

