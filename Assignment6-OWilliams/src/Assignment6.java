
import java.util.Scanner;

/**
 * This program builds an array of integers based on user input,
 * with specific requirements and constraints such as array length,
 * element values, and error checking.
 */
public class Assignment6 {

    /**
     * Main method to run the program.
     */
    public static void main(String[] args) {
        printWelcomeMessage();

        String arraySizePromptText = "How many elements would you like the array to have?\nEnter an integer from zero (0) to 20 (0-20, inclusive)";
        int arraySize = runSafeNonNegIntegerPrompt(arraySizePromptText, 20);

        System.out.println("\n **** The array will have " + arraySize + " elements. ****\n");

        if (arraySize > 0) {
            runArrayBuilder(arraySize);
        }

        System.out.println("\n\t===== SAFE ARRAY ASSIGN ENDED - GOODBYE! =====\n");
    }

    /**
     * Prints the welcome message to the terminal.
     */
    private static void printWelcomeMessage() {
        System.out.println("=================================================");
        System.out.println("**** INPUT ERROR-PROOF INT[] ARRAY BUILDER ****");
        System.out.println("Let's build an int[] array (safely).");
        System.out.println("=================================================");
    }

    /**
     * Safely gathers a non-negative integer from the user.
     * @param userPromptText The prompt text for the user input.
     * @param upperBound     The upper bound for the input value.
     * @return The validated integer input from the user.
     */
    private static int runSafeNonNegIntegerPrompt(String userPromptText, int upperBound) {
        boolean valid;
        String inputString;
        Scanner kbScanner = new Scanner(System.in);

        do {
            System.out.println(userPromptText);
            System.out.print(">> ");
            inputString = kbScanner.nextLine();
            valid = nonNegIntSafePromptHelper(inputString, upperBound);
            if (!valid) {
                System.out.println("ERROR: You entered an invalid input!");
            }
        } while (!valid);

        return Integer.parseInt(inputString);
    }

    /**
     * Helper method to validate if a string represents a non-negative integer within a specified range.
     * @param inputString The input string to be validated.
     * @param upperBound  The upper bound for the input value.
     * @return True if the input string is a valid non-negative integer within the range, false otherwise.
     */
    private static boolean nonNegIntSafePromptHelper(String inputString, int upperBound) {
        if (inputString.isEmpty()) {
            return false;
        }

        for (char c : inputString.toCharArray()) {
            if (c < '0' || c > '9') {
                return false;
            }
        }

        int testInt = Integer.parseInt(inputString);
        return testInt >= 0 && testInt <= upperBound;
    }

    /**
     * Builds the array based on user input.
     *
     * @param arrayLength The length of the array to be built.
     */
    private static void runArrayBuilder(int arrayLength) {
        int[] newIntArray = new int[arrayLength];

        System.out.println("=================================================");
        System.out.println("Let's start filling the array with values from zero to 50 (0-50, inclusive)...");
        System.out.println("=================================================");

        for (int i = 0; i < arrayLength; i++) {
            String elementPromptText = "Enter an integer between zero and 50 (0-50, inclusive) to fill element at index " + i;
            newIntArray[i] = runSafeNonNegIntegerPrompt(elementPromptText, 50);
            System.out.println("Element " + i + " set to " + newIntArray[i]);
            printArrayElements(newIntArray);
            System.out.println();
        }

        System.out.println("=================================================");
        System.out.println("Here is a visual display of the array values you entered:");
        visualizeArrayContent(newIntArray);
        System.out.println("\n===============================================\n");
    }

    /**
     * Prints the elements of the array.
     * @param arrayToBePrinted The array to be printed.
     */
    private static void printArrayElements(int[] arrayToBePrinted) {
        System.out.print("Current Array Values: ");
        for (int value : arrayToBePrinted) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    /**
     * Visualizes the content of the array using asterisks.
     * @param arrayToBeDisplayed The array to be displayed.
     */
    private static void visualizeArrayContent(int[] arrayToBeDisplayed) {
        for (int i = 0; i < arrayToBeDisplayed.length; i++) {
            System.out.print("Value at index " + i + " (" + arrayToBeDisplayed[i] + ")\t-> ");
            for (int j = 0; j < arrayToBeDisplayed[i]; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }
}
