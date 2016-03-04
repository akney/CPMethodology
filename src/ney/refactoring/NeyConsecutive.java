package ney.refactoring;

import java.util.InputMismatchException;
import java.util.Scanner;

//this program checks a matrix to see if a number appears four times consecutively 
public class NeyConsecutive {
	public static void main(String[] args) {
		int choice;

		try {
			do {
				choice = menu();
				switch (choice) {
				case 1:
					String row = "row";
					String column = "column";
					int rows = getNumber(row); // will hold the amount of rows
												// in the 2 dimens. array
					int columns = getNumber(column); // will hold the amount of
														// columns in the 2
														// dimens. array
					int[][] grid = new int[rows][columns];
					boolean isConsecutive = false;

					getNumbers(grid, rows, columns);
					printMatrix(grid, rows, columns);
					isConsecutive = consecutive(grid, rows, columns);
					if (isConsecutive == false) {
						System.out.println("There are no consecutive values, four times in succession.");
					}
					break;
				case 2:
					System.out.println("Goodbye!");
					System.exit(0);
				}// end switch
			} while (choice != 2);
		} // end try
		catch (InputMismatchException ex) {
			System.out.println("Sorry you were not careful to put in the right data type. Ending program.");
			System.exit(0);
		} // end catch
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}// end main

	/**
	 * This method creates a menu and gets the user's choice
	 * 
	 * @return user's choice
	 * @throws InputMismatchException
	 */
	public static int menu() throws InputMismatchException {
		Scanner keyboard = new Scanner(System.in);
		int choice;
		do {
			System.out.println("\nEnter the number of what you would like to do:");
			System.out.println("1. Make and test a new matrix\n2. Exit");
			choice = keyboard.nextInt();
		} while (choice < 1 || choice > 2);

		return choice;
	}// end menu method

	/**
	 * This method interacts with the user to get the number of the rows and
	 * columns
	 * 
	 * @param grid
	 *            gets the name of either row or column
	 * @return as a number returns the number of rows/columns
	 * @throws InputMismatchException
	 */
	public static int getNumber(String grid) throws InputMismatchException {
		Scanner keyboard = new Scanner(System.in);
		int number;// to hold input
		System.out.println("Enter the number of " + grid + " in your matrix (from 1 to 9): ");
		number = keyboard.nextInt();
		while (number < 1 || number > 9) {
			System.out.println("Invalid number.");
			System.out.println("Enter the number of rows in your matrix (from 1 to 9): ");
			number = keyboard.nextInt();
		} // end while
		keyboard.close();

		return number;
	}// end setUpArray

	/**
	 * This method figures out the numbers that should go into the two
	 * dimensional array, it takes input in, in rows and then splits the rows
	 * 
	 * @param array
	 *            the two dimensional array getting values
	 * @param rows
	 *            in the two dimensional array
	 * @param columns
	 *            in the two dimensional array
	 * @throws InputMismatchException
	 */
	public static void getNumbers(int[][] array, int rows, int columns) throws InputMismatchException {
		Scanner keyboard = new Scanner(System.in); // for input
		String input; // the user will enter in a row of numbers at a time
		String[] inputArray; // will hold the numbers until they are parsed

		for (int i = 0; i < rows; i++) {
			do {
				System.out.print(
						"Enter the numbers in the " + (i + 1) + " row of your matrix, seperate each with a comma: ");
				input = keyboard.nextLine();
				inputArray = input.split(",");
				if (inputArray.length > columns) { // input validation
					System.out.print("You entered too many numbers.\n Please Re-");
				} // end if
				else if (inputArray.length < columns) {
					System.out.print("You entered too little numbers.\n Please Re-");
				} // end else if
			} while (inputArray.length != columns);

			for (int j = 0; j < inputArray.length; j++) {
				array[i][j] = Integer.parseInt(inputArray[j]);
			} // end inner for

		} // end for

	}// end method

	/**
	 * This method prints the two dimensional array for the user to see, and for
	 * the programmer to be able to see if they coded correctly
	 * 
	 * @param array
	 * @param rows
	 * @param columns
	 */
	public static void printMatrix(int[][] array, int rows, int columns) {
		System.out.println("Here is your matrix.");
		for (int a = 0; a <= array[0].length + 4; a++) {
			System.out.print("_");
		} // end aesthetic for
		System.out.println();
		for (int i = 0; i < rows; i++) {
			System.out.print("|");
			for (int j = 0; j < columns; j++) {
				System.out.print(array[i][j] + " ");
			} // end inner for
			System.out.println("|");
		} // end for
		for (int a = 0; a <= array[0].length + 4; a++) {
			System.out.print("_");
		} // end aesthetic for
		System.out.println();
	}

	/**
	 * This method checks if there is four consecutive values in a row
	 * 
	 * @param array
	 * @param rows
	 * @param columns
	 * @return true if found consecutive values, false if it did not
	 * @throws Exception
	 */
	public static boolean consecutiveRow(int[][] array, int rows, int columns) throws Exception {
		int holder = 0; // will be used to hold the numbers in the array for
						// comparing purposes
		int temp = 0;// holds a number for calculating
		int counter = 0; // will be used for calculating how many times a number
							// shows up
		boolean four = false;

		for (int i = 0; i < rows; i++) { // checking for consecutives in the
											// rows
			holder = array[i][0];
			counter = 1;// restarts it every loop
			for (int j = 1; j < columns; j++) {// start j by 1 because already
												// read 0
				temp = array[i][j];
				if (temp != holder) {
					holder = temp;
				} else {
					counter++;
				}

				if (counter == 4) {
					System.out.println(holder + " is consecutive 4 times in row " + (i + 1));
					four = true;
					return four;
				} // end if
			} // end inner for
		} // end for
		return four;
	}// end method

	/**
	 * This method checks if there is four consecutive values in a column
	 * 
	 * @param array
	 * @param rows
	 * @param columns
	 * @return
	 * @throws Exception
	 */
	public static boolean consecutiveColumn(int[][] array, int rows, int columns) throws Exception {
		int holder = 0; // will be used to hold the numbers in the array for
						// comparing purposes
		int temp = 0;// holds a number for calculating
		int counter = 0; // will be used for calculating how many times a number
							// shows up
		boolean four = false;

		for (int j = 0; j < columns; j++) { // checking for consecutives in the
											// columns
			holder = array[0][j];
			counter = 1;
			for (int i = 1; i < rows; i++) { // start i with 1 since already
												// checked 0
				temp = array[i][j];
				if (temp != holder) {
					holder = temp;
				} else {
					counter++;
				}

				if (counter == 4) {
					System.out.println(holder + " is consecutive 4 times in column " + (j + 1));
					four = true;
					return four;
				} // end if
			} // end inner for
		} // end outer for
		return four;
	}// end method

	/**
	 * This method checks if there is four consecutive values in a diagonol
	 * going down to the right
	 * 
	 * @param array
	 * @param rows
	 * @param columns
	 * @return
	 * @throws Exception
	 */
	public static boolean consecutiveDiagonolDR(int[][] array, int rows, int columns) throws Exception {
		int holder = 0; // will be used to hold the numbers in the array for
						// comparing purposes
		int temp = 0;// holds a number for calculating
		int counter = 0; // will be used for calculating how many times a number
							// shows up
		boolean four = true;
		for (int i = 0; i < rows; i++) { // checking diagonally down right
			for (int j = 0; j < columns; j++) {
				holder = array[i][j];
				int times = 1;
				boolean counterPlussed;
				counter = 1;
				do {
					if (i + times < rows && j + times < columns) {
						temp = array[i + times][j + times];

						if (temp == holder) {
							counter++;
							times++;
							counterPlussed = true;
						} // end inner if
						else {
							counterPlussed = false;
						}

						if (counter == 4) {
							System.out.println(
									holder + " is consecutive four times going diagonolly up to the left from point "
											+ (i + times) + "," + (j + times));
							return four;
						} // end inner if
					} // end outer if
					else {
						counterPlussed = false;
					}
				} while (counterPlussed == true);

			} // end inner for
		} // end outer for
		four = false;
		return four;
	}// end method

	/**
	 * This method checks if there is four consecutive values diagonolly going
	 * down to the left
	 * 
	 * @param array
	 * @param rows
	 * @param columns
	 * @return
	 */
	public static boolean consecutiveDiagonolDL(int[][] array, int rows, int columns) throws Exception {
		int holder = 0; // will be used to hold the numbers in the array for
						// comparing purposes
		int temp = 0;// holds a number for calculating
		int counter = 0; // will be used for calculating how many times a number
							// shows up
		boolean four = true;
		for (int i = 0; i < rows; i++) { // checking diagonally down left
			for (int j = 0; j < columns; j++) {
				holder = array[i][j];
				int times = 1;
				boolean counterPlussed;
				counter = 1;
				do {
					if (i - times < rows && i - times > 0 && j - times < columns && j - times > 0) {
						temp = array[i - times][j - times];

						if (temp == holder) {
							counter++;
							times++;
							counterPlussed = true;
						} // end inner if
						else {
							counterPlussed = false;
						}

						if (counter == 4) {
							System.out.println(
									holder + " is consecutive four times going diagonolly up to the right from point "
											+ (i - times) + "," + (j - times + 1));
							return four;
						} // end inner if
					} // end outer if
					else {
						counterPlussed = false;
					}
				} while (counterPlussed == true);

			} // end inner for
		} // end outer for

		four = false;
		return four;
	}// end method

	/**
	 * combine all consecutives here, trying to save proccesing time using the
	 * if statements
	 * 
	 * @throws Throwable
	 */
	public static boolean consecutive(int[][] grid, int rows, int columns) throws Exception {
		boolean isConsecutive = false;
		if (columns > 3) { // if the matrix does not have four columns the
							// program will not bother to check if the rows have
							// four consecutive numbers
			isConsecutive = consecutiveRow(grid, rows, columns);
			if (isConsecutive == true) {
				return isConsecutive;
			}
		}
		if (rows > 3) { // if the matrix does not have four rows or more then it
						// certainly doesn't have four consecutive in a column
			isConsecutive = consecutiveColumn(grid, rows, columns);
			if (isConsecutive == true) {
				return isConsecutive;
			}
		}
		if (rows > 3 && columns > 3) { // the matrix needs four in both
										// directions in order for there to be
										// four in a row diagonolly
			isConsecutive = consecutiveDiagonolDR(grid, rows, columns);
			if (isConsecutive == true) {
				return isConsecutive;
			} else {
				isConsecutive = consecutiveDiagonolDL(grid, rows, columns);
			}
		}

		return isConsecutive;

	}// end method
}// end class
