# calc-rizz-plus
A simple calculator for performing basic mathematical operations for grade 4, 5, and 6. This is the plus version of the "Calc Rizz" Calculator.

### What's New?
This project is essentially the same as a the calc-rizz standard version in its core functionalies. The main changes exist in the user interface, as the plus version takes a more 'mature' look. I have also improved the documentation of how each part of the project works. The final change is the fix to the "divide by zero" calculation which is now handled appropriately instead of crashing the program. 
While this could have been all done on the standard version, I chose to make a new one particulary to preserve the user interfaces of both calculators.

#### PROJECT TITLE: 
Calc Rizz Plus

#### PURPOSE OF PROJECT: 
A simple calculator for performing basic math operations for grade 4, grade 5 and grade 6 

#### VERSION: 
Ver. 1

#### AUTHOR: 
Anyanwu Benedict Chukwuemeka (https://github.com/ACBennny)

------------------------------------------------------------------------------------

## DOCUMENTATION

This calculator is a package named CalcRizz. In this package I have split the design of this calculator into 4 sections, 
all performing a different major function in the calculator's development.
These include:

1. CalcRizzMain
     This is the main class (javafx class) of the Package.
     It is where the scene and stage are instatiated.
     Running this class will start the program containing the calculator.
     
2. CalcRizzControl
     This is the 'controller' class (java class) of the CalcRizz package.
     It essentialy contains all necessary methods required for the functionality of the calculator.
     In this class there exists
    - A method which is automatically called for loading files and initializing variables andmethods.
    - A method to display to the screen, the operations performed by the user on the calculator
    - A method to clear the display of the claculator to allow for more calculations to beperformed
    - A method that will essentially perform all operations defined for this calculator
    - Media players to play sounds when the app starts and when buttons are pressed
     
4. CalcRizzStruct
     This is a FXML document. It is similar to the standard HTML documents used for web development in terms of schema and structure.
     It primarily serves as the 'skeleton' of the calculator. This means it holds the structure by which the calculator is built upon.
     
5. CalcRizzStyle
     This is a cascading stylesheet or populary known as CSS sheet. As the name implies, it's soley made for styling the calculator 
     and giving it the unique design seen once the program has been started.
     
NB: 
1. The CalcRizzStyle and CalcRizzStruct files are located in the 'src' folder.
2. Images used in the creation of this project are not created or in any manner affiliated with me. All credits got to their respective owners
3. This is a blueJ project and thus blueJ is preferred for running this project.

------------------------------------------------------------------------------------

## HOW IT WORKS

Let's take a look into the function process of this calculator.

1. Gets the text in the input of the label
2. Splits the text into parts. An array called components stores these parts.
3. It checks that it is a valid expression. A valid expression is in the following order
   
   -----> " 10 " , " + " , " 1 "  <------

   This above expression consists of three parts.
   A non valid expression causes an error message to be displayed.
4. The 3 parts are defined as follows;
   
   --> part 1 is the first operand and is stored in operand1 (Integer)

   --> part 2 is the operator

   --> part 3 is the second operand and is stored in operand2 (Integer)
   
5. A variable called "result" is used to store calculated varaibles (subject to modification)
6. A variable called "pickedRadBtn" radio group for the grade of maths (ie grade 4 , 5 and 6)
7. The id of the selected radio button is stored in "pickedRadBtnId"
8. I ensure that a radio button is always selected (The "grade 4 math" is selected by default)
9. If a radio button is selected, a switch case ensues based on the operator
10. Each operation and conditions (if applicable) are listed below
    
    #### --> ADDITION
    
    Works normally for all grades.

    #### --> MULTIPLICATION 
    
    Works normally for all grades.
    
    #### --> SUBTRACTION 
    
      Grade 4
      1. Subtraction only works if the first operand is greater than/equals to the second operand.
      i.e. operand1 >= operand2
      2. If above condition is not met, an error message is displayed.

      Grade 5 and 6
      1. Subtraction works normally for both grades.

    #### --> DIVISION
    
      Grade 4
      1. Division works only if there is no remainder in the operation else an error is displayed.
  
      Grade 5
      1. We make use of quotient and remainder.
      2. The quotient and remainder is calculated
      3. The results are displayed in the format: "quotient" , " R " , "remainder" e.g. 4 R 1
  
      Grade 6
      1. The use of decimals is employed but all digits must round up to 4 decimal places.
      2. The operands are converted to double, the operation follows suit.
      3. The result of the division is formated to 4 decimal places using the DecimalFormat class.
      4. The formatted result is then displayed.

------------------------------------------------------------------------------------

## STARTING THE CALCULATOR

To start the calculator,
1. Open the the project (preferrably using blueJ)
2. Right click and run the "CalcRizzMain.java"
3. After a few seconds, the app should open ready to use.


