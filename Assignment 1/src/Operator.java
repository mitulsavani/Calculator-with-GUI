
import java.util.HashMap;

public abstract class Operator {
    
    //HashMap
    static HashMap<String, Operator> operators = new HashMap();

    static 
    {
        operators.put("(", new PranOpen());
        operators.put(")", new PranClose());
        operators.put("+", new AdditionOperator());
        operators.put("-", new SubtractOperator());
        operators.put("*", new MultiplyOperator());
        operators.put("/", new DivisionOperator());
        operators.put("^", new PowerOperator());
    }

    protected abstract int priority();

    protected abstract Operand execute(Operand op1, Operand op2);

    //This function checks whether the token is operator i.e (any key within HashMap)
    public static boolean check(String token) {
        return operators.containsKey(token);
    }
    //This function return the instance of the class
    protected static Operator get(String token) 
    {
        return (Operator) operators.get(token);
    }
}
