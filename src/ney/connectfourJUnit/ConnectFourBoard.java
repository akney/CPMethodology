package ney.connectfourJUnit;

public class ConnectFourBoard {
	private char[][] board;
	private int[] howFullIsColumn; // use it to determine next available space
									// in a column
	private char playerA = 'a';
	private char playerB = 'b';
	private char currentPlayer;

	public ConnectFourBoard() {
		board = new char[6][7];
		howFullIsColumn = new int[7];
		currentPlayer = playerB;
	}

	/**
	 * Simulates a players turn
	 * 
	 * @param col
	 *            - the player selects which column it wants to put the piece
	 *            into
	 * @param player
	 *            - char either r or b to show who is playing the turn
	 * @return an int of the row so the gui knows where it is
	 */
	public int turn(int col) {
		if (!fullColumn(col)) {
			currentPlayer = currentPlayer == playerA ? playerB : playerA;
			int row = howFullIsColumn[col];
			board[row][col] = currentPlayer;
			howFullIsColumn[col]++;

			return row;
		} else {
			return -1;
		}

	}

	/**
	 * Checks whether a column is full or not
	 * 
	 * @param col
	 * @return boolean - true if full, false if not full
	 */
	private boolean fullColumn(int col) {
		return howFullIsColumn[col] == 6;
	}

	/**
	 * Checks if the whole board is full
	 * 
	 * @return boolean - true if full, false if not full
	 */
	public boolean fullBoard() {
		for (int i = 0; i < howFullIsColumn.length; i++) {
			if (howFullIsColumn[i] < 6) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Determines if there is a winner
	 * 
	 * @return true if there is a winner
	 */
	public boolean winner(int row, int col) {
		int counter = 0;
		// checking in row
		for (int j = 0; j < 7; j++) {
			if (board[row][j] == currentPlayer) {
				counter++;
			} else {
				counter = 0;
			}

			if (counter == 4) {
				return true;
			}
		}

		counter = 0; // resetting the counter
		// checks in column
		if (howFullIsColumn[col] > 3) {
			for (int i = 0; i < 6; i++) {
				if (board[i][col] == currentPlayer) {
					counter++;
				} else {
					counter = 0;
				}
				if (counter == 4) {
					return true;

				}
			}
		}

		counter = 0;
		// diagnol down to the right
		int i = row, j = col;
		while (i > 0 && j > 0) {
			i--;
			j--;
		}

		while (i < 6 && j < 7) {
			if (board[i][j] == currentPlayer) {
				counter++;
			} else {
				counter = 0;

			}

			if (counter == 4) {
				return true;
			}

			i++;
			j++;
		}

		// check diagnol to the left -note both diagnols will be flipped in
		for (i = 3; i < board.length; i++) {
			for (j = 0; j < board[0].length - 3; j++) {
				if (board[i][j] == currentPlayer && board[i][j] == board[i - 1][j + 1]
						&& board[i - 1][j + 1] == board[i - 2][j + 2] && board[i - 2][j + 2] == board[i - 3][j + 3]) {
					return true;
				}
			}
		}

		return false;
	}

	public char[][] getBoard() {
		return board;
	}

	public int[] getHowFullIsColumn() {
		return howFullIsColumn;
	}

}
