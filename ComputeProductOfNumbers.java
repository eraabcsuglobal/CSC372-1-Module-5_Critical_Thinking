import java.util.Scanner;

public class ComputeProductOfNumbers {
		
	public static int computeProgram(int numValue, int originalValue, int runCnt) {
		int totalValue = 1;
		int nextValue;
		
		// when runCnt decrements to 0, return the first parameter in computeProgram() method
		if (runCnt == 0) {
			return numValue;
		}
		else {
			// get the value to multiply by getting the last digit of the number inputted by the user by using modulus
			nextValue = originalValue % 10;
			// divide the original value by 10 to set up the next digit for the next run of the recursion
			originalValue = originalValue / 10;
			// set the total value to the next value multiplied by the last total value
			totalValue = nextValue * computeProgram(totalValue, originalValue, runCnt - 1);
		}
		return totalValue;
	}
	
	public static void main(String[] args) {
		// get value from user
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter 5 numbers.");
		
		int inputtedNumber;
		// initialize run count to the amount of numbers desired from the user
		int runCnt = 5;
		
		// set the input to an integer
		inputtedNumber = scanner.nextInt();
		String stringOfNumber = String.valueOf(inputtedNumber);
		
		// check the entered value is exactly 5 numbers
		if (stringOfNumber.length() != runCnt) {
			System.out.println("Please enter exactly 5 numbers.\n");
		}
		else {
			System.out.println(computeProgram(inputtedNumber, inputtedNumber, runCnt));
		}
		scanner.close();
	}
	
}