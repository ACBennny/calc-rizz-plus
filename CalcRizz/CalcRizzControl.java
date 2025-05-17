package CalcRizz;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Label;
import java.io.File;
import java.text.DecimalFormat;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**********************************************************************************************************************************************************
 * Calc Rizz Calculator
 * 
 * A simple calculator designed for Grade 4, 5 and 6 math.
 * This calculator will perform basic operations like addition, subtraction, multiplication and division of numbers
 * 
 * 
 * 
 * ---------------> The Controller class for the CalcRizz Calculator <-----------------------
 * 
 * 
 * 
 * As the name suggests, the functionality of the calculator is controlled in this class.
 * Several variables and methods ave been declared to enable the calculator function properly
 * 
 * The calculator will need to perform addition, subtraction, multiplication and division all defined by pre-stated instructions in the questions document
 * In this class there exists
 * 1. A method which is automatically called for loading files and initializing variables and methods.
 * 2. A method to display to the screen, the operations performed by the user on the calculator
 * 3. A method to clear the display of the claculator to allow for more calculations to be performed
 * 4. A method that will essentially perform all operations defined for this calculator
 * 5. Media players to play sounds when the app starts and when buttons are pressed
 * 
 * 
 * More details of each given method are stated below, before the declaration of each method
 * 
 * 
 *
 * @author (Anyanwu Bendict Chukwuemeka)
 * @version (version One[1])
 * 
 *********************************************************************************************************************************************************/
public class CalcRizzControl
{
    // Variables - These are necessary variables instantiated and used in the calculator
    // The '@FXML' is placed above to show it is from an fxml file and it can handle an action listener
    
    // Display Input
    // This variable represents a line on the calculator display for displaying the inputs made by the user
    @FXML
    private Label display_input;
    
    // Display Output
    // This variable represents the second line on the calculator for displaying the output of completed operations
    @FXML
    private Label display_output;
    
    // Display Warn
    // This is the third line of the calculator screen used to display an error message should one occur
    @FXML
    private Label display_warn;
    
    // Toggle group
    // This is the Togglegroup for the three grade math radio buttons. It connects all three together
    @FXML
    private ToggleGroup gradeTypeRadio;
    
    
    // These are instatiated variables of the MediaPlayer class used for Playing sounds on the calculator
    
    // This mediaplayer plays a welcoming sound once the application starts
    @FXML
    private MediaPlayer introSoundPlayer;
    
    // This plays a sound when any but the 'equal to' button is clicked
    @FXML
    private MediaPlayer btnSoundPlayer;
    
    // This plays a sound when the 'equal to' button is clicked
    @FXML
    private MediaPlayer equalToSoundPlayer;

    
    
    /******************************************************************************************
     * Method Name: initialize
     * Purpose: For initializion/loading of variables, files etcetera
     * How it Works: 
     *          1. Automatically called function
     *          2. Initialiases variables and methods
     *          3. Loads files like images, sound files and videos etcetera
     *******************************************************************************************/
    @FXML
    private void initialize()
    {
        // We load the file and initialize the media players
        
        
        // Initializing media player for button press/click
        
        // String containing the file location
        String btnSoundFile = "CalcRizz/src/btnClickSound.mp3";
        // Converting the string to an actual file path to get access to the file
        Media btnSoundMedia = new Media(new File(btnSoundFile).toURI().toString());
        // Declaring the media player
        btnSoundPlayer = new MediaPlayer(btnSoundMedia);
        
        
        
        // This is for playing a sound when the equal to, "=" is pressed
        
        // String containing the file location
        String equalToSoundFile = "CalcRizz/src/equalToClickSound.mp3";
        // Converting the string to an actual file path to get access to the file
        Media equalToSoundMedia = new Media(new File(equalToSoundFile).toURI().toString());
        // Declaring the media player
        equalToSoundPlayer = new MediaPlayer(equalToSoundMedia);
        
        
        // This is for playing a sound when the application starts
        // String containing the file location
        String introSoundFile = "CalcRizz/src/calcRizzIntro.mp3";
        // Converting the string to an actual file path to get access to the file
        Media introSoundMedia = new Media(new File(introSoundFile).toURI().toString());
        // Declaring the media player
        introSoundPlayer = new MediaPlayer(introSoundMedia);
        
        
        // As this is an automatically called function on start of the application, we play the sound here. The sound says "Welcome Traveler"
        introSoundPlayer.play();
    }
    
    
    
    /**************************************************************************************************************
     * Method Name: displayUserInput
     * Purpose: Displays user input to display of the calculator
     * How It Works: 
     *          1. An ActionListener
     *          2. Listens to a specific set of buttons determined by the class Name
     *          3. Prints the inner text of each button on the display_input line if it is an operand(number)
     *          4. Prints with the creation of space between operands if it is an operator("+" , "÷" , "-" , "x")
     *          5. Plays sound for each button press
     *************************************************************************************************************/
    @FXML
    private void displayUserInput(ActionEvent event)
    {
        // Checks and stops playing the button sound
        btnSoundPlayer.stop();
        
        // Starts Playing a sound each time a button is pressed
        btnSoundPlayer.play();
        
        // Gets the button that was clicked
        Button operandBtn = (Button) event.getSource();
        
        // Locates specific button by checking class name
        if(operandBtn.getStyleClass().contains("operand_btn"))
        {
            // Get the text of the clicked button
            String operandBtnText = operandBtn.getText();
            
            // Get the current text of the display label
            String curDisplayText = display_input.getText();
            
            // Check if the button text is a operand(number)
            if (Character.isDigit(operandBtnText.charAt(0)))
            {
                // It appends text without space
                display_input.setText(curDisplayText + operandBtnText);
            } 
            else
            {
                // If an operator, appends text with space between the operators
                display_input.setText(curDisplayText + " " + operandBtnText + " ");
            }
        }
    }
    
    
    
    /***************************************************************************************************
     * Method Name: clearDisplay
     * Purpose: Clears the display of the calculator
     * How It Works: 
     *          1. Checks if there is any text in any of the three lines that make up the display 
     *             (i.e the display input, display output, and display warn)
     *          2. If there is a text it clears it by setting the text content of the Labels to empty
     *          3. Also plays sound when the Clear key, "CE" is pressed
     ***************************************************************************************************/
    @FXML
    private void clearDisplay() 
    {
        // Checks and stops playing the button sound
        btnSoundPlayer.stop();
        
        // Starts Playing a sound each time the Clear, "CE" is pressed
        btnSoundPlayer.play();
        
        // Clear text in display_input
        if(display_input.getText().length() > 0)
        {
            display_input.setText("");
        }
        
        // Clear text in display_output
        if(display_output.getText().length() > 0)
        {
            display_output.setText("");
        }
        
        // Clear text in display_warn
        if(display_warn.getText().length() > 0)
        {
            display_warn.setText("");
        }
    }
    
    
    
    /************************************************************************************************************
     * Method Name: numberOperations
     * Purpose: Takes the user input, performs an operation, and displays the result on the calculator display
     * How it Works:
     *          1. Gets the text in the input of the label
     *          2. Splits the text into parts. An array called components stores this parts
     *          3. It checks that it is a valid expression. A valid expression is in the following order
     *             -----> " 10 " , " + " , " 1 "  <------
     *             This above expression consists of three parts.
     *             A non valid expression causes an error message to be displayed.
     *          4. The 3 parts are defined as follows;
     *              -> part 1 is the first operand and is stored in operand1 (Integer)
     *              -> part 2 is the operator
     *              -> part 3 is the second operand and is stored in operand2 (Integer)
     *          5. A variable called "result" is used to store calculated varaibles (subject to modification)
     *          6. A variable called "pickedRadBtn" radio group for the grade of maths (ie grade 4 , 5 and 6)
     *          7. The id of the selected radio button is stored in "pickedRadBtnId"
     *          8. I ensure that a radio button is always selected (The "grade 4 math" is selected by default)
     *          9. If a radio button is selected, a switch case ensues based on the operator
     *          10. Each operation and conditions (if applicable)
     *          
     *          --> Addition Operation <--
     *           Works normally for all grades
     *          
     *          --> MultipiLication Operation <--
     *           Works normally for all grades
     *           
     *          --> Subtraction Operation <--
     *          Grade 4
     *          1. Subtraction only works if the first operand is greater than/equals to the second operand
     *             i.e. operand1 >= operand2
     *          2. If above condition is not met, an error message is displayed
     *          
     *          Grade 5 and 6
     *          1. Subtraction works normally
     *          
     *          --> Division <--
     *          Grade 4
     *          1. Division works only if there is no remainder in the operation else an error is displayed
     *          
     *          Grade 5
     *          1. We make use of quotient and remainder.
     *          2. The quotient and remainder is calculated
     *          3. The results are displayed in the format: "quotient" , " R " , "remainder"
     *          
     *          Grade 6
     *          1. The use of decimals is employed but all digits must round up to 4 decimal places
     *          2. The operands are converted to double, the operation follows suit
     *          3. The result of the division is formated to 4 decimal places using the DecimalFormat class
     *          4. The formatted result is then displayed
     ***********************************************************************************************************/
    @FXML
    private void numberOperations()
    {
        // Checks and stops playing the button sound
        equalToSoundPlayer.stop();
        
        // Starts Playing a sound each time the Equal to, "=" is pressed
        equalToSoundPlayer.play();
        
        // Get the text from the display_input Label
        String expression = display_input.getText();
        
        // Split the expression to get the operands and the operator
        String[] components = expression.split("\\s+");
        
        // Check if it is a valid expression
        // Valid expression contains an operator and two operands
        if(components.length == 3)
        {
            // Operand 1
            int operand1 = Integer.parseInt(components[0]);
            
            // Operand 2
            int operand2 = Integer.parseInt(components[2]);
            
            // Variable to hold the result of the operation
            int result = 0;
            
            // Get the radio button group for the grades (i.e. grade 4, 5 and 6)
            RadioButton pickedRadBtn = (RadioButton) gradeTypeRadio.getSelectedToggle();
            
            // Get the id of the radio buttons in the group
            String pickedRadBtnId = pickedRadBtn.getId();
            
            // Check if a radio button in the group is selected
            if(pickedRadBtn != null)
            {
                // Perform the operation based on the operator
                switch (components[1])
                {
                    // Addition Operator
                    case "+":
                        // Calculate the operation as it works for all grades
                        result = operand1 + operand2;
                        
                        // Display the result in the display_output Label
                        display_output.setText(String.valueOf(result));
                        break;
                    
                    // Multiplication Operator
                    case "×":
                        // Calculate the operation as it works for all grades
                        result = operand1 * operand2;
                        
                        // Display the result in the display_output Label
                        display_output.setText(String.valueOf(result));
                        
                        break;
                    
                    // Subtraction Operator
                    case "-":
                        // Grade 4 only works if operand is greater than/equal to operand2
                        if(pickedRadBtnId.equals("grade4Rad"))
                        {
                            // Check if operand1 is greater than/equal to than operand2
                            if(operand1 >= operand2)
                            {
                                // Subtraction operation
                                result = operand1 - operand2;
                                
                                // Display the result
                                display_output.setText(String.valueOf(result));
                            }
                            else
                            {
                                // Displays error message
                                display_warn.setText(String.valueOf("ERROR"));
                                
                                // Clear Ouput line
                                display_output.setText(String.valueOf(""));
                                
                                return;
                            }
                        }
                        // Grade 5 and 6 subtracts normally
                        else
                        {
                            // Subtraction operation
                            result = operand1 - operand2;
                            
                            // Display the result in the display_output Label
                            display_output.setText(String.valueOf(result));
                            
                            // Clear the error message
                            display_warn.setText(String.valueOf(""));
                        }
                        
                        break;
                    
                    // Division Operator
                    case "÷":
                        // First Check that the division operation is valid (i.e. operand2 != 0)
                        if((operand2 != 0))
                        {
                            // Check which grade radio button is selected
                            // For grade 4, can only work without remainder
                            if(pickedRadBtnId.equals("grade4Rad"))
                            {
                                // Check if number divides without remainder
                                if(operand1 % operand2 == 0)
                                {
                                    // Calculate division
                                    result = operand1 / operand2;
                                    
                                    // Display the result
                                    display_output.setText(String.valueOf(result));
                                }
                                else
                                {
                                    // Display error message
                                    display_warn.setText(String.valueOf("ERROR"));
                                    
                                    // Remove any value in output line
                                    display_output.setText(String.valueOf(""));
                                    
                                    return;
                                }
                            }
                            // For grade 5, use quotient and remainder
                            else if(pickedRadBtnId.equals("grade5Rad"))
                            {
                                // Calculate Quotient
                                int quotient = (int) (operand1 / operand2);
                                
                                // Calculate Remainder
                                int remainder = (int) (operand1 % operand2);
                                
                                // Store Result
                                String g5Result = quotient + " R " + remainder;
                                
                                // Display result
                                display_output.setText(String.valueOf(g5Result));
                                
                                // Remove error message
                                display_warn.setText(String.valueOf(""));
                                
                                return;
                            }
                            // For grade 6, display result to 4 decimal places
                            else
                            {                            
                                // Converting operands to double
                                double op1 = (double) operand1;
                                double op2 = (double) operand2;
                                
                                // Calculating division
                                double g6Operation = op1 / op2;
                                
                                // Rounding to 4 decimal places
                                DecimalFormat g6Cond = new DecimalFormat("0.0000");
                                String g6Conv = g6Cond.format(g6Operation);
                                
                                // Display Result
                                display_output.setText(String.valueOf(g6Conv));
                                
                                //Remove error
                                display_warn.setText(String.valueOf(""));
                            }
                        }
                        else
                        {
                            // Display error
                            display_warn.setText(String.valueOf("ERROR :/"));
                            
                            // Remove any value in output line
                            display_output.setText(String.valueOf(""));
                        }
                        break;
                        
                    default:
                        // If none of the operators appear this error message appears
                        display_warn.setText(String.valueOf("ERROR :/"));
                        
                        // Remove any value in output line
                        display_output.setText(String.valueOf(""));
                        
                        break;
                }
            }
            // If the none of the radio buttons are picked
            // this error message appears
            else
            {
                display_warn.setText(String.valueOf("ERROR :/"));
                
                // Remove any value in output line
                display_output.setText(String.valueOf(""));
            }
        }
        // If operator is invalid this error message appears
        else
        {
            display_warn.setText(String.valueOf("ERROR :/"));
            
            // Remove any value in output line
            display_output.setText(String.valueOf(""));
        }
    }
}
