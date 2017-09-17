public class EvaluatorTester {
  public static void main(String[] args) {
    Evaluator evaluator = new Evaluator();
    String test[]={"6^3*5-2^9/3-1*1^2/1"};
    for ( String arg : test ) {
      System.out.format( "%s = %d\n", arg, evaluator.eval( arg ) );
      // System.out.println( arg + " = " + evaluator.eval( arg ) );
    }
  }
}
