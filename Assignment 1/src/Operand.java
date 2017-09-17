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
