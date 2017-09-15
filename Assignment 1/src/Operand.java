public class Operand {

  int value;
  
  public Operand( String token ) {
      value=Integer.parseInt(token);
  }

  public Operand( int value ) {
      this.value=value;
  }

  public int getValue() {
      return value;
  }

  public static boolean check( String token ) {
      try{
          Integer.parseInt(token);
      }
      catch(NumberException)
          return false;
      }
  }
}
