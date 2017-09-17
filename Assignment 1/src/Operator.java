
import java.util.HashMap;

public abstract class Operator {
    // The Operator class should contain an instance of a HashMap
    // This map will use keys as the tokens we're interested in,
    // and values will be instances of the Operators.

    // Example:
    // Where does this declaration go? What should its access level be?
    // Class or instance variable? Is this the right declaration?
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

    public static boolean check(String token) {
        if (operators.containsKey(token)) 
        {  return true;  }
        else 
        {  return false; }
    }

    protected static Operator get(String token) 
    {
        return (Operator) operators.get(token);
    }

}
