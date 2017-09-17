public class Operand {

  int value;
  
    public Operand( String token ) {
        value=Integer.parseInt(token);
    }

    public Operand( int ParameterizedValue ) {
       value=ParameterizedValue;
    }

    public int getValue() {
        return value;
    }

    public static boolean check( String token ) {
        try{
            Integer.parseInt(token);
            return true;
        }
        catch(NumberFormatException e)
        {
            return false;
        }
    }
}
