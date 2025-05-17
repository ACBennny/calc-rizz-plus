package CalcRizz;

import java.io.FileInputStream;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*******************************************************************************************************************************************************
 * Calc Rizz Calculator
 * 
 * A simple calculator designed for Grade 4, 5 and 6 math.
 * This calculator will perform basic operations like addition, subtraction, multiplication and division of numbers
 * 
 * 
 * 
 * ----------------------> This Class is the main Class of this Project <------------------------------
 * 
 * 
 * About:
 * 
 * In the production of this calculator, a different approach was used. 
 * I understand that this calulator can be developed within the bounds of this javafx class but
 * As I am more familiar with the interface, structure and approach to web development, 
 * I made use of this approach to develop my calculator.
 * 
 * This calculator is a package named CalcRizz. In this package I have split the design of this calculator into 4 sections, 
 * all performing a different major function in the calculator's development.
 * These include:
 * 
 * 1. CalcRizzMain(the class that you're reading this note from)
 *      This is the main class (javafx class) of the Package.
 *      It is where the scene and stage are instatiated.
 *      Running this class will start the program containing the calculator.
 *      
 * 2. CalcRizzControl
 *      This is the 'controller' class (java class) of the CalcRizz package.
 *      It essentialy contains all necessary methods required for the functionality of the calculator
 *      
 * 3. CalcRizzStruct
 *      This is a FXML document. It is similar to the standard HTML documents used for web development in terms of schema and structure.
 *      It primarily serves as the 'skeleton' of the calculator. This means it holds the structure by which the calculator is built upon
 *      
 * 4. CalcRizzStyle
 *      This is a cascading stylesheet or populary known as CSS sheet. As the name implies, it's soley made for styling the calculator 
 *      and giving it the unique design seen once the program has been started.
 *      
 * NB: 
 * 1. The CalcRizzStyle and CalcRizzStruct files are located in the 'src' folder.
 * 2. Images used in the creation of this project are not created or in any manner affiliated with me. All credits got to their respective owners
 * 3. This is a blueJ project
 * 
 *
 *
 *
 * @author (Anyanwu Bendict Chukwuemeka)
 * @version (version One[1])
 * 
 ******************************************************************************************************************************************************/
public class CalcRizzMain extends Application
{
    // Instance data
    
    // This are the links to the FXML file (Calculator structure) , CSS Sheet (Calculator's styling)
    // and the application's Icon
    // They have all been set to final as both will never change throughout the entire duration of the program
    
    private final String FXML_STRUCT = "src/calcRizzStruct.fxml";
    private final String CSS_STYLE = "src/calcRizzStyle.css";
    private final String CALC_ICON = "images/calcRizzIcon.jpg";

    /*********************************************************************************
     * Method Name: start
     * Purpose: 1. Instantiates the application
     *          2. Throws Exception for all files loaded in this project in case of load errors
     *          3. Instantiates and creates the scene and stage of this project
     ********************************************************************************/
    @Override
    public void start(Stage stage) throws Exception
    {
        // FXML File
        // The Parent class is used to locate and load the FXML document
        Parent root = FXMLLoader.load(getClass().getResource(FXML_STRUCT));

        
        // Scene
        // Creating the scene for the calculator
        Scene myScene = new Scene(root);
        
        
        // StyleSheet
        // We need to load the stylesheet for the calculator
        myScene.getStylesheets().add(getClass().getResource(CSS_STYLE).toExternalForm());
        
        
        // Application Title
        // This is the data that will appear in the title bar located at the top of the window
        stage.setTitle("Calc Rizz Calculator");
        
        
        // Application Icon
        // This the visual logo that uniquely identifies this application. It is a image file of type jpg
        stage.getIcons().add(new Image(CalcRizzMain.class.getResourceAsStream("images/calcRizzIcon.jpg")));
        
        
        // Application Window Size
        // Rather than constructing a fixed window, I have attempted a better method that should make this application dynamic
        // This should allow for proper resizing to fit devices of both higher/lower resolutions and screen sizes (tablets at best)
        // Below I have controlled the windows resizing
        
        // Minimum Window Size - This is done to prevent window overlap with the calculator itself
        // Users may increase/decrease the window size but cannot go below this preset size of 650px in height and  450px in width
        stage.setMinHeight(650.0);
        stage.setMinWidth(450.0);
        
        // Starting Window Size - When the application first runs, the window is set to fit the complete size of the current device which it is run from
        stage.setMaximized(true);
        
        // Selecting the scene - Sets the scene for the stage
        stage.setScene(myScene);

        // Shows the Stage - It shows the currently selected stage
        stage.show();
    }
}
