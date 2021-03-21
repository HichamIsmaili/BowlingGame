package com.ismaili.bowlingTest;

import com.ismaili.bowling.Jeu;

import junit.framework.TestCase;

public class BowlingJeuTest extends TestCase {
	private Jeu jeu;

	protected void setUp() throws Exception {
		jeu = new Jeu();
	}

	private void rollMany(int n, int pins) {
		for (int i = 0; i < n; i++)
			jeu.roll(pins);
	}

	public void testGutterJeu() throws Exception {
		rollMany(20, 0);
		assertEquals(0, jeu.score());
	}

	public void testAllOnes() throws Exception {
		rollMany(20, 1);
		assertEquals(20, jeu.score());
	}

	public void testOneSpare() throws Exception {
		jeu.roll(5);
		jeu.roll(5);
		jeu.roll(3);
		rollMany(17, 0);
		assertEquals(16, jeu.score());
	}

	private void rollSpare() {
		jeu.roll(5);
		jeu.roll(5);
	}

	public void testOneStrike() throws Exception {
		jeu.roll(10);//strike
		jeu.roll(3);
		jeu.roll(4);
		rollMany(16, 0);
		assertEquals(24, jeu.score());
	}

	public void testPerfectGame() throws Exception {
		rollMany(12, 10);
		assertEquals(300, jeu.score());
	}

}
