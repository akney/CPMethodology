package ney.connectfourJUnit;

import org.junit.Assert;
import org.junit.Test;

public class TestConnectFourBoard {

	@Test
	public void testTurn() {
		ConnectFourBoard board = new ConnectFourBoard();

		int row = board.turn(0);

		Assert.assertEquals(0, row);
		Assert.assertNotNull(board.getBoard()[row][0]);
		Assert.assertEquals(1, board.getHowFullIsColumn()[0]);
	}

	@Test
	public void testFullBoard() {
		ConnectFourBoard board = new ConnectFourBoard();

		for (int row = 0; row < 6; row++) {
			for (int col = 0; col < 7; col++) {
				board.turn(col);
			}

		}

		Assert.assertTrue(board.fullBoard());

	}

	@Test
	public void testFullBoardEmpty() {
		ConnectFourBoard board = new ConnectFourBoard();

		Assert.assertFalse(board.fullBoard());
	}

	@Test
	public void testFullBoardPartiallyFull() {
		ConnectFourBoard board = new ConnectFourBoard();

		board.turn(4);

		Assert.assertFalse(board.fullBoard());
	}

	@Test
	public void testWinnerVertical() {
		ConnectFourBoard board = new ConnectFourBoard();
		board.turn(3);
		board.turn(1);
		board.turn(3);
		board.turn(1);
		board.turn(3);
		board.turn(1);
		int row = board.turn(3);

		Assert.assertTrue(board.winner(row, 3));

	}

	@Test
	public void testWinnerHorizantal() {
		ConnectFourBoard board = new ConnectFourBoard();
		board.turn(0);
		board.turn(0);
		board.turn(1);
		board.turn(1);
		board.turn(2);
		board.turn(2);
		int row = board.turn(3);

		Assert.assertTrue(board.winner(row, 3));
	}

	@Test
	public void testWinnerDiagnol() {
		ConnectFourBoard board = new ConnectFourBoard();
		board.turn(0);
		board.turn(0);
		board.turn(0);
		board.turn(0);
		board.turn(2);
		board.turn(2);
		board.turn(2);
		board.turn(3);
		board.turn(3);
		board.turn(1);
		board.turn(1);
		int row = board.turn(1);

		Assert.assertTrue(board.winner(row, 1));
	}

	@Test

	public void testNoWinner() {
		ConnectFourBoard board = new ConnectFourBoard();
		board.turn(0);
		board.turn(0);
		board.turn(0);
		board.turn(0);
		board.turn(1);
		board.turn(2);
		int row = board.turn(3);

		Assert.assertFalse(board.winner(row, 3));

	}

}
