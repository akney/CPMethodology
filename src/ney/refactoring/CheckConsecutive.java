package ney.refactoring;

//version 2
public class CheckConsecutive {

	// take out menu and leave that for main, give it its own field variables
	private int[][] numGrid;

	public CheckConsecutive(int row, int column) {
		numGrid = new int[row][column];
	}

	public void populateGrid(int[] nums) {
		int index = 0;
		if (index != numGrid.length * numGrid[0].length) {
			System.out.println("Illegal number of number of numbers");
			return;
		}
		for (int i = 0; i < numGrid.length; i++) {
			for (int j = 0; j < numGrid[i].length; j++) {
				numGrid[i][j] = nums[index++];
			}
		}

	}

	/**
	 * This method prints the two dimensional array for the user to see, and for
	 * the programmer to be able to see if they coded correctly
	 */
	public void printMatrix() {
		System.out.println("Here is your matrix.");
		for (int a = 0; a <= numGrid.length + 4; a++) {
			System.out.print("_");
		} // end aesthetic for
		System.out.println();
		for (int i = 0; i < numGrid.length; i++) {
			System.out.print("|");
			for (int j = 0; j < numGrid[0].length; j++) {
				System.out.print(numGrid[i][j] + " ");
			} // end inner for
			System.out.println("|");
		} // end for
		for (int a = 0; a <= numGrid[0].length + 4; a++) {
			System.out.print("_");
		} // end aesthetic for
		System.out.println();
	}

	/**
	 * This method checks if there is four consecutive values in a row
	 */
	private void consecutiveRow() {
		int numChecking = 0; // will be used to hold the numbers in the array
								// for
		// comparing purposes
		int temp = 0;// holds a number for calculating
		int timesFound = 0; // will be used for calculating how many times a
							// number
							// shows up

		for (int i = 0; i < numGrid.length; i++) { // checking for consecutives
													// in the
			// rows
			numChecking = numGrid[i][0];
			timesFound = 1;// restarts it every loop
			for (int j = 1; j < numGrid[0].length; j++) {// start j by 1 because
															// already
				// read 0
				temp = numGrid[i][j];
				if (temp != numChecking) {
					numChecking = temp;
				} else {
					timesFound++;
				}

				if (timesFound == 4) {
					System.out.println(numChecking + " is consecutive 4 times in row " + (i + 1));

				} // end if
			} // end inner for
		} // end for

	}// end method

	/**
	 * This method checks if there is four consecutive values in a column
	 */
	public void consecutiveColumn() {
		int numChecking = 0; // will be used to hold the numbers in the array
								// for
		// comparing purposes
		int temp = 0;// holds a number for calculating
		int timesFound = 0; // will be used for calculating how many times a
							// number
							// shows up

		for (int j = 0; j < numGrid[0].length; j++) { // checking for
														// consecutives in the
			// columns
			numChecking = numGrid[0][j];
			timesFound = 1;
			for (int i = 1; i < numGrid.length; i++) { // start i with 1 since
														// already
				// checked 0
				temp = numGrid[i][j];
				if (temp != numChecking) {
					numChecking = temp;
				} else {
					timesFound++;
				}

				if (timesFound == 4) {
					System.out.println(numChecking + " is consecutive 4 times in column " + (j + 1));
				} // end if
			} // end inner for
		} // end outer for

	}// end method

	/**
	 * This method checks if there is four consecutive values in a diagonol
	 * going down to the right
	 */
	public void consecutiveDiagonolDR() {
		int numChecking = 0; // will be used to hold the numbers in the array
								// for
		// comparing purposes
		int temp = 0;// holds a number for calculating
		int timesFound = 0; // will be used for calculating how many times a
							// number
							// shows up
		for (int i = 0; i < numGrid.length; i++) { // checking diagonally down
													// right
			for (int j = 0; j < numGrid[0].length; j++) {
				numChecking = numGrid[i][j];
				int times = 1;
				boolean counterPlussed;
				timesFound = 1;
				do {
					if (i + times < numGrid.length && j + times < numGrid[0].length) {
						temp = numGrid[i + times][j + times];

						if (temp == numChecking) {
							timesFound++;
							times++;
							counterPlussed = true;
						} // end inner if
						else {
							counterPlussed = false;
						}

						if (timesFound == 4) {
							System.out.println(numChecking
									+ " is consecutive four times going diagonolly up to the left from point "
									+ (i + times) + "," + (j + times));

						} // end inner if
					} // end outer if
					else {
						counterPlussed = false;
					}
				} while (counterPlussed);

			} // end inner for
		} // end outer for

	}// end method

	/**
	 * This method checks if there is four consecutive values diagonolly going
	 * down to the left
	 */
	public void consecutiveDiagonolDL() {
		int numChecking = 0; // will be used to hold the numbers in the array
								// for
		// comparing purposes
		int temp = 0;// holds a number for calculating
		int counter = 0; // will be used for calculating how many times a number
							// shows up

		for (int i = 0; i < numGrid.length; i++) { // checking diagonally down
													// left
			for (int j = 0; j < numGrid[0].length; j++) {
				numChecking = numGrid[i][j];
				int times = 1;
				boolean counterPlussed;
				counter = 1;
				do {
					if (i - times < numGrid.length && i - times > 0 && j - times < numGrid[0].length && j - times > 0) {
						temp = numGrid[i - times][j - times];

						if (temp == numChecking) {
							counter++;
							times++;
							counterPlussed = true;
						} // end inner if
						else {
							counterPlussed = false;
						}

						if (counter == 4) {
							System.out.println(numChecking
									+ " is consecutive four times going diagonolly up to the right from point "
									+ (i - times) + "," + (j - times + 1));

						} // end inner if
					} // end outer if
					else {
						counterPlussed = false;
					}
				} while (counterPlussed == true);

			} // end inner for
		} // end outer for

	}// end method

	/**
	 * combine all consecutives here, trying to save proccesing time using the
	 * if statements
	 */
	public void consecutive() {

		if (numGrid.length > 3) { // if the matrix does not have four columns
									// the
			// program will not bother to check if the rows have
			// four consecutive numbers
			consecutiveRow();

		}
		if (numGrid[0].length > 3) { // if the matrix does not have four rows or
										// more then it
			// certainly doesn't have four consecutive in a column
			consecutiveColumn();

		}
		if (numGrid.length > 3 && numGrid[0].length > 3) { // the matrix needs
															// four in both
			// directions in order for there to be
			// four in a row diagonolly
			consecutiveDiagonolDR();
			consecutiveDiagonolDL();
		}

	}// end method
}
