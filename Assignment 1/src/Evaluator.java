import java.util.*;

public class Evaluator {
  private Stack<Operand> operandStack;
  private Stack<Operator> operatorStack;
  
  private StringTokenizer tokenizer;
  private static final String DELIMITERS = "+-*^/( ";

  public Evaluator() {
    operandStack = new Stack<>();
    operatorStack = new Stack<>();
  }
  

  
  public void PerformPranthesisOperation()
  {
      while (operatorStack.peek().priority()!=1)
      {
        Operator lastOperator = operatorStack.pop();
        Operand op2 = operandStack.pop();
        Operand op1 = operandStack.pop();
        operandStack.push( lastOperator.execute( op1, op2 ));
      }
      operatorStack.pop();    
   }
  public int eval( String expression ) {
    String token;
    
    this.tokenizer = new StringTokenizer( expression, DELIMITERS, true );

    while ( this.tokenizer.hasMoreTokens() ) 
    {   
      if ( !( token = this.tokenizer.nextToken() ).equals( " " )) 
      {
        if (Operand.check( token )) 
        {
            operandStack.push(new Operand( token ));
        } 
        else 
        {
            if(token == ")")
            {
              PerformPranthesisOperation();
            }
            
            if (!Operator.check( token )) 
            {
                System.out.println( "*****invalid token******" );
                System.exit( 1 );
            }

          Operator newOperator = Operator.get(token);
          
          if(!operatorStack.isEmpty())
          {
                while((!operatorStack.isEmpty())&&(operatorStack.peek().priority()) >= (newOperator.priority())) 
                {
                      Operator oldOpr = operatorStack.pop();
                      Operand op2 = operandStack.pop();
                      Operand op1 = operandStack.pop();
                      operandStack.push( oldOpr.execute( op1, op2 ));
                }
          }
          operatorStack.push(newOperator); 
        }
      }//end of space
    }//end of tokens in an expression
  
    
    while((operatorStack.size() != 0))
    {
        Operator LastOperator = operatorStack.pop();
        Operand op2 = operandStack.pop();
        Operand op1 = operandStack.pop();
        operandStack.push( LastOperator.execute( op1, op2 ));
    }
    
    return (operandStack.peek().getValue());
  }
}
