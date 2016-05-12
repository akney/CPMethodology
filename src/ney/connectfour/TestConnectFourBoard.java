package ney.connectfour;

import org.junit.Assert;
import org.junit.Test;

public class TestConnectFourBoard {

	@Test
	public void testTurn() {
		ConnectFourBoard board = new ConnectFourBoard();
		char piece = 'a';
		int row = board.turn(0, piece);

		Assert.assertEquals(0, row);
		Assert.assertEquals('a', board.getBoard()[row][0]);
		Assert.assertEquals(1, board.getHowFullIsColumn()[0]);
	}

	@Test
	public void testFullBoard() {
		ConnectFourBoard board = new ConnectFourBoard();
		char piece = 'a';
		for (int row = 0; row < 6; row++) {
			for (int col = 0; col < 7; col++) {
				board.turn(col, piece);
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
		char piece = 'a';
		board.turn(4, piece);

		Assert.assertFalse(board.fullBoard());
	}

	@Test
	public void testWinnerVertical() {
		ConnectFourBoard board = new ConnectFourBoard();
		board.turn(3, 'a');
		board.turn(3, 'a');
		board.turn(3, 'a');
		int row = board.turn(3, 'a');

		Assert.assertTrue(board.winner('a', row, 3));

	}

	@Test
	public void testWinnerHorizantal() {
		ConnectFourBoard board = new ConnectFourBoard();
		board.turn(0, 'a');
		board.turn(1, 'a');
		board.turn(2, 'a');
		int row = board.turn(3, 'a');

		Assert.assertTrue(board.winner('a', row, 3));
	}

	@Test
	public void testWinnerDiagnol() {
		ConnectFourBoard board = new ConnectFourBoard();
		board.turn(0, 'b');
		board.turn(0, 'a');
		board.turn(0, 'b');
		board.turn(0, 'a');
		board.turn(1, 'a');
		board.turn(1, 'b');
		board.turn(1, 'a');
		board.turn(2, 'b');
		board.turn(2, 'a');
		int row = board.turn(3, 'a');

		Assert.assertTrue(board.winner('a', row, 3));

	}

	public void testNoWinner() {
		ConnectFourBoard board = new ConnectFourBoard();
		board.turn(0, 'b');
		board.turn(0, 'a');
		board.turn(0, 'b');
		board.turn(0, 'a');
		board.turn(1, 'b');
		int r = board.turn(2, 'b');
		int row = board.turn(3, 'a');

		Assert.assertFalse(board.winner('a', row, 3));
		Assert.assertFalse(board.winner('b', r, 2));
	}

}
