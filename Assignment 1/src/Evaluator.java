import java.util.*;

  public class Evaluator 
  {
  
  //Stacks to store operands and operators    
  private final Stack<Operand> operandStack;
  private final Stack<Operator> operatorStack;
  
  private StringTokenizer tokenizer;
  private static final String DELIMITERS = "+-*^/() ";

  public Evaluator() 
  {
    operandStack = new Stack<>();
    operatorStack = new Stack<>();
  }
  
  //This function will perform operation on operands that are inside the parentheses
    private void PerformParenthesesOperation()
    {
        //This loop will run until the top value of the operator stack '(' is found
        while((operatorStack.peek().priority()!=1))
        {
          Operator lastOperator = operatorStack.pop();
          Operand op2 = operandStack.pop();
          Operand op1 = operandStack.pop();

          //Once we are done with the ececution, we did not want to loose the answer so we must push the answer back in operand stack
          operandStack.push( lastOperator.execute( op1, op2 ));
        }    
        //So we have a peek value of operator stack i.e. '(', so now its time to remove that operator.
        operatorStack.pop();
    }
  
  //Eval function takes a string; does computation and return the answer back to main
    public int eval( String expression ) 
    {
        String token;
    
        this.tokenizer = new StringTokenizer( expression, DELIMITERS, true );

        //this loops is useful to reach till the end of the expression 
        while ( this.tokenizer.hasMoreTokens() ) 
        {   
            if ( !( token = this.tokenizer.nextToken() ).equals( " " )) 
            {
                //It checks whether the token is Operand?
                if (Operand.check( token )) 
                {
                    operandStack.push(new Operand( token ));
                } 
                else //This loop will run if the token is Operator
                { 
                    if(!Operator.check( token )) 
                    {
                      System.out.println( "*****invalid token******" );
                      System.exit( 1 );
                    }
                    
                    //This is when when we need to execute the expression enclosed in Parentheses
                    else if(")".equals(token))
                    {
                      PerformParenthesesOperation();
                    }
                    else if("(".equals(token))                                  //Since we dont want open parentheses to be checked with other operators so we need to push it in stack
                    {   
                        operatorStack.push(new PranOpen());  
                    }           
                    else
                    {
                        Operator newOperator = Operator.get(token);

                        if(!operatorStack.isEmpty())
                        {
                            while((operandStack.size()>=2) && (!operatorStack.isEmpty())  &&  (operatorStack.peek().priority() >= (newOperator.priority()))) 
                            {
                                Operator oldOpr = operatorStack.pop();
                                Operand op2 = operandStack.pop();
                                Operand op1 = operandStack.pop();
                                operandStack.push(oldOpr.execute( op1, op2 ));
                            }
                        }
                        operatorStack.push(newOperator); 
                    }
                }//end of operator loop
            }
        }//end of checking more token loop
        
        
        //This loop will excecute operation on whatever things are left in our stacks
        while(!operatorStack.isEmpty())
        {
            Operator LastOperator = operatorStack.pop();
            Operand operator1 = operandStack.pop();
            Operand operator2 = operandStack.pop();
            operandStack.push(LastOperator.execute(operator2,operator1));
        }
        
        //Lastly we are poping the answer and sending it to caller class/function
        return (operandStack.pop().getValue());
    }
}
