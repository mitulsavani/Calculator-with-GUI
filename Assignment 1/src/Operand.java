public class Operand {

  int value;
  
    protected Operand( String token ) 
    {
        value=Integer.parseInt(token);
    }

    protected Operand( int ParameterizedValue ) 
    {
       value=ParameterizedValue;
    }
    
    protected int getValue() 
    {
        return value;
    }

    //This functions check whether the token from evaluator funtion is under or inclusive 0-9
    public static boolean check( String token ) 
    {
        try
        {
            Integer.parseInt(token);
            return true;
        }
        catch(NumberFormatException e)
        {
            return false;
        }
    }
}
