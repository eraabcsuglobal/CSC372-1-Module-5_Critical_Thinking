import java.util.Scanner;

public class ComputeProductOfNumbers {
	
	// NEW
	// get the last digit of an integer by returning the modulus of 10
	public static int getLastDigit(int intToModulo) {
		int modulatedInt = 0;
		modulatedInt = intToModulo % 10;
		return modulatedInt;
	}
	
	// NEW
	// move the decimal of a value to the next digit by dividing it by 10
	public static int moveDecimalPoint(int numberToMove){
		int nextDigit = 0;
		nextDigit = numberToMove / 10;
		return nextDigit;
	}
	
		
	public static int computeProgram(int numValue, int originalValue, int runCnt) {
		int totalValue = 1;
		int nextValue;
		
		// when runCnt decrements to 0, return the first parameter in computeProgram() method
		if (runCnt == 0) {
			return numValue;
		}
		else {
			// NEW
			// use modulus of 10 to extract the last digit of the current value returned by originalValue
			nextValue = getLastDigit(originalValue);
			// divide the current value returned by originalValue by 10 to set up the next digit that will be multiplied in the next run of the recursion
			originalValue = moveDecimalPoint(originalValue);
			// multiply the total value to the next value, and then enter that total as a parameter for the next run of the recursion
			totalValue = nextValue * computeProgram(totalValue, originalValue, runCnt - 1);
		}
		return totalValue;
	}
	

	
	public static void main(String[] args) {
		// get value from user
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter a 5-digit number.");
		
		int inputtedNumber;
		// initialize run count to the amount of numbers desired from the user
		int runCnt = 5;
		
		// NEW
		// check if the value entered is a valid integer and is exactly 5 numbers
		if (scanner.hasNextInt())
		{
			// set the input to an integer
			inputtedNumber = scanner.nextInt();
			String stringOfNumber = String.valueOf(inputtedNumber);
		
			if (stringOfNumber.length() != runCnt) {
				System.out.println("Please enter a 5-digit number.\n");
			}
			else {
				System.out.println(computeProgram(inputtedNumber, inputtedNumber, runCnt));
			}
		}
		else {
			System.out.println("Entry must be a 5-digit number.\n");
			
		}
		scanner.close();
	}
	
}