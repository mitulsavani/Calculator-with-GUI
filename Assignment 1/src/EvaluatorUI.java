import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EvaluatorUI extends JFrame implements ActionListener 
{
  private TextField txField = new TextField();
  private Panel buttonPanel = new Panel();

  // total of 20 buttons on the calculator,
  // numbered from left to right, top to bottom
  // bText[] array contains the text for corresponding buttons
  private static final String[] bText = 
  {
    "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3",
    "*", "0", "^", "=", "/", "(", ")", "C", "CE"
  };
  private Button[] buttons = new Button[ bText.length ];

  public static void main(String argv[]) 
  {
    EvaluatorUI calc = new EvaluatorUI();
  }

  public EvaluatorUI() 
  {
    setLayout( new BorderLayout() );

    add( txField, BorderLayout.NORTH );
    txField.setEditable( false );

    add( buttonPanel, BorderLayout.CENTER );
    buttonPanel.setLayout( new GridLayout( 5, 4 ));

    //create 20 buttons with corresponding text in bText[] array
    for ( int i = 0; i < 20; i++ ) {
      buttons[ i ] = new Button( bText[ i ]);
    }

    //add buttons to button panel
    for (int i=0; i<20; i++) {
      buttonPanel.add( buttons[ i ]);
    }

    //set up buttons to listen for mouse input
    for ( int i = 0; i < 20; i++ ) {
      buttons[ i ].addActionListener( this );
    }

    setTitle( "Calculator" );
    setSize( 400, 400 );
    setLocationByPlatform( true  );
    setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
    setVisible( true );
  }

    public void actionPerformed( ActionEvent arg0 ) 
    {
        //this statement will get which command did user pressed
        String command = arg0.getActionCommand();
    
        switch(command)
        {
            case "1":
            txField.setText(txField.getText()+command);                         //This will add text to display after appending the command
            break;

            case "2":
            txField.setText(txField.getText()+command);
            break;

            case "3":
            txField.setText(txField.getText()+command);
            break;

            case "4":
            txField.setText(txField.getText()+command);
            break;

            case "5":
            txField.setText(txField.getText()+command);
            break;

            case "6":
            txField.setText(txField.getText()+command);
             break;

            case "7":
            txField.setText(txField.getText()+command);
            break;

            case "8":
            txField.setText(txField.getText()+command);
            break;

            case "9":
            txField.setText(txField.getText()+command);
            break;

            case "0":
            txField.setText(txField.getText()+command);
            break;

            case "(":
            txField.setText(txField.getText()+command);
            break;

            case ")":
            txField.setText(txField.getText()+command);
            break;

            case "+":
            txField.setText(txField.getText()+command);
            break;

            case "-":
            txField.setText(txField.getText()+command);
            break;

            case "*":
            txField.setText(txField.getText()+command);
            break;

            case "/":
            txField.setText(txField.getText()+command);
            break;

            case "^":
            txField.setText(txField.getText()+command);
            break;

            case "C":
            txField.setText("");
            break;

            case "CE":
            txField.setText("");
            break;

            case "=":
            
            // If user presses '=' with enter expression then appropiate message will be consoled
            if(txField.getText().equals(""))
                txField.setText("No Expression Found");    
            else
            {
                Evaluator Object = new Evaluator();
                int result= Object.eval(txField.getText());
                txField.setText(Integer.toString(result));
            }
            break;

            default:
            txField.setText("Invalid Input");     
        }
    }
}