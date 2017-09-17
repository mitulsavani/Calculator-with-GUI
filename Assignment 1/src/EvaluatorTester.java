public class EvaluatorTester {
  public static void main(String[] args) {
    Evaluator evaluator = new Evaluator();
    String[]test ={"( ((5+5)*(5+5)) +(2+2)*(5*2) )"};
   
    
    for ( String arg : test ) {
      System.out.format( "%s = %d\n", arg, evaluator.eval( arg ) );
      // System.out.println( arg + " = " + evaluator.eval( arg ) );
    }
  }
}
