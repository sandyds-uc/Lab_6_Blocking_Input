import java.util.Random;
import java.util.Scanner;

public class Lab_6_Blocking_Input
{
    public static void main(String[] args)
    {

        // Declare & Initialize Variables
        double temp = 0.0;
        double fTemp = 0.0;
        double gallonsOfGas = 0.0;
        double fEfficiency = 0.0;
        double priceOfGasPerGallon = 0.0;
        double distance = 0.0;
        double costPer100Miles = 0.0;
        double height = 0.0;
        double width = 0.0;
        double perimeter = 0.0;
        double area = 0.0;
        double diagonal = 0.0;
        boolean done = false;
        int guess = 0;
        int val = 0;
        String trash = "";
        Scanner in = new Scanner(System.in);
        Random rnd = new Random();

        // Task #1: CtoFConverter
        System.out.println("Let's convert Celsius temperatures to Fahrenheit."); // Summary statement
        do // Validation checker will run until a double is entered & done becomes true
        {
            System.out.print("Enter a temperature in Celsius: "); // Prompt for input
            if(in.hasNextDouble()) // Check if input is a double
            {
                temp = in.nextDouble(); // If input is a double count it as the Celsius value
                in.nextLine(); // Clear newline from the buffer
                fTemp = temp * ((double) 9/5) + 32; // Process: Convert Celsius to Fahrenheit & store in fTemp
                System.out.printf(temp + " in Celsius is %5.2f in Fahrenheit", fTemp); // Output
                done = true; // End do loop by making done true
            }
            else { // If input is not a double
                trash = in.nextLine(); // Save invalid input type in trash
                System.out.println("Illegal input - you must enter a double value as a Celsius temperature not : " + trash + "."); // Throw trash back at User
                System.out.println("Try again.\n"); // Tell user to try again
            }
        }while(!done); // End do while loop

        // Task #2: FuelCosts
        System.out.println("\n\nLet's see how far you can travel with the amount of gas currently in your tank and calculate how much it would cost you to travel 100 miles."); // Summary statement
        done = false; // Needs to be false otherwise the loop will terminate after one pass
        do // Validation checker will run until done is true or if an invalid data type is entered
        {
            System.out.print("Enter the number of gallons of gas in the tank: "); // Prompt for input
            if(in.hasNextDouble()) // Check if input is a number for gallons in tank
            {
                gallonsOfGas = in.nextDouble(); // Input number of gallons in tank
                in.nextLine(); // Clear newline from buffer
                System.out.print("Enter the the fuel efficiency in miles per gallon: "); // Next prompt for input
                if(in.hasNextDouble()) // Check if next input is a number for fuel efficiency
                {
                    fEfficiency = in.nextDouble(); // Input fuel efficiency in miles per gallon
                    in.nextLine(); // Clear newline from buffer
                    System.out.print("Enter the price of gas per gallon: "); // Final prompt for price of gas per gallon
                    if(in.hasNextDouble()) // Check if final input for price of gas per gallon is a number
                    {
                        priceOfGasPerGallon = in.nextDouble(); // Input price of gas per gallon
                        in.nextLine(); // Clear newline from the buffer
                        distance = gallonsOfGas * fEfficiency; // Process distance can travel with current gallons of gas in tank
                        costPer100Miles = (100 / fEfficiency) * priceOfGasPerGallon; // Process cost of going 100 miles
                        done = true; // End do loop by making done true
                    }
                    else
                    {
                        trash = in.nextLine(); // Save illegal input in trash
                        System.out.println("Illegal Entry: " + trash + ". Start all over."); // Throw trash back at user & make them start over
                    }
                }
                else
                {
                    trash = in.nextLine(); // Save illegal input in trash
                    System.out.println("Illegal Entry: " + trash + ". Start all over."); // Throw trash back at user & make them start over
                }
            }
            else
            {
                trash = in.nextLine(); // Save illegal input in trash
                System.out.println("Illegal Entry: " + trash + ". Start all over."); // Throw trash back at user & make them start over
            }
        }while(!done); // End do while loop

        System.out.printf("With " + gallonsOfGas + " gallons of gas the car can travel %5.2f miles.", distance); // Output current possible distance
        System.out.printf("\nWith your inputs, the cost to travel 100 miles is: $%-6.2f\n", costPer100Miles); // Output cost for 100 miles

        // Task #3: RectangleInfo
        System.out.println("\nLet's calculate the area, perimeter, and diagonal of a rectangle."); // Summary statement
        done = false; // Needs to be false otherwise the loop will terminate after one pass
        do
        {
            System.out.print("Enter the height of the rectangle: "); // Prompt for input height of rectangle
            if(in.hasNextDouble()) // Validation check to see if user input a number for height of rectangle
            {
                height = in.nextDouble(); // Input height
                in.nextLine(); // Clear newline from the buffer
                System.out.print("Enter the width of the rectangle: "); // Prompt for input width of rectangle
                if(in.hasNextDouble()) // Validation check to see if user input a number for width of rectangle
                {
                    width = in.nextDouble(); // Input width
                    in.nextLine(); // Clear newline from the buffer
                    done = true; // End the do while loop
                }
                else
                {
                    trash = in.nextLine(); // Save illegal input in trash
                    System.out.println("Illegal Entry: " + trash + ". You will need to restart.\n"); // Throw trash back at user & make them restart
                }
            } else
            {
                trash = in.nextLine(); // Save illegal input in trash
                System.out.println("Illegal Entry: " + trash + ". You will need to restart.\n"); // Throw trash back at user & make them restart
            }
        }while(!done); // End do while loop

        area = height * width; // Process the area
        perimeter = height + height + width + width; // Process the perimeter
        diagonal = Math.sqrt((height * height) + (width * width)); // Process the Diagonal

        System.out.printf("The area of the rectangle is: %-8.2f\n", area); // Output the area
        System.out.printf("The perimeter of the rectangle is: %-8.2f\n", perimeter); // Output the perimeter
        System.out.printf("The diagonal of the rectangle is: %-8.2f", diagonal); // Output the Diagonal

        // Task #4: HighOrLow
        System.out.println("\n\nLet's see if you can guess a number between 1 and 10."); // Summary statement
        done = false; // Needs to be false otherwise the loop will terminate after one pass
        do
        {
            val = rnd.nextInt(10) + 1; // Generate random number between 1 & 10
            System.out.print("Guess a whole number between 1 and 10: "); // Prompt to guess a number between 1 & 10
            if(in.hasNextInt()) // Validation check to ensure user entered an integer
            {
                guess = in.nextInt(); // Input guess
                in.nextLine(); // Clear newline from the buffer
                done = true; // End do while loop
                if(guess == val) // If guess was correct
                {
                    System.out.println("Amazing! The number was: " + val); // Output correct guess
                    System.out.println("Congratulations! You win!"); // Let the user know that they won
                }
                else if(guess > val && guess <= 10) // If guess was too high but in the valid range
                {
                    System.out.println(guess + " was too high. The number was: " + val); // Output too high
                }
                else if (guess < val && guess >= 1) // If guess was too low but in the vaid range
                {
                    System.out.println(guess + " was too low. The number was: " + val); // Output too low
                }
                else // If guess was an out of range integer
                {
                    System.out.println(guess + " is not a valid number between 1 and 10 so you lose."); // Let user know that they guessed an invalid integer
                }
            }
            else // If user guessed an invalid type
            {
                trash = in.nextLine(); // Save invalid input type to trash
                System.out.println("Illegal Entry: " + trash); // Throw trash input back at user
                System.out.println("Try again."); // Force user to try again
            }
        }while(!done); // End do while loop
    }
}