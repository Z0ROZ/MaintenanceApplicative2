
package trivia;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class GameTest {
    @Test
    public void caracterizationTest() {
        // runs 10.000 "random" games to see the output of old and new code mathces
        for (int seed = 1; seed < 10_000; seed++) {
            testSeed(seed, false);
        }
    }

    private void testSeed(int seed, boolean printExpected) {
        String expectedOutput = extractOutput(new Random(seed), new GameOld());
        if (printExpected) {
            System.out.println(expectedOutput);
        }
        String actualOutput = extractOutput(new Random(seed), new Game());
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    @Disabled("enable back and set a particular seed to see the output")
    public void oneSeed() {
        testSeed(1, true);
    }

    private String extractOutput(Random rand, IGame aGame) {
        PrintStream old = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (PrintStream inmemory = new PrintStream(baos)) {
            // WARNING: System.out.println() doesn't work in this try {} as the sysout is captured and recorded in memory.
            System.setOut(inmemory);

            aGame.add("Chet");
            aGame.add("Pat");
            aGame.add("Sue");

            boolean notAWinner = false;
            do {
                aGame.roll(rand.nextInt(5) + 1);

                if (rand.nextInt(9) == 7) {
                    notAWinner = aGame.handleIncorrectAnswer();
                } else {
                    notAWinner = aGame.handleCorrectAnswer();
                }

            } while (notAWinner);
        } finally {
            System.setOut(old);
        }

        return new String(baos.toByteArray());
    }


	private Game game;
	private Player player;

	@BeforeEach
	public void setup() {
		game = new Game();
		game.add("Player 1");
		player = game.getCurrentPlayer();
	}

	@Test
	public void testAddPlayer() {
		assertTrue(game.add("Player 2"));
		assertEquals(2, game.getPlayers(), "Il devrait y avoir 2 joueurs dans le jeu");
	}

	@Test
	public void testMovePlayer() {
		game.roll(4);
		assertEquals(5, player.getPosition(), "La position du joueur devrait être 5 après avoir roulé 4");
	}

	@Test
	public void testCorrectAnswer() {
		game.roll(3);
		game.handleCorrectAnswer();
		assertEquals(1, player.getPurses(), "Le joueur devrait avoir 1 purse après une bonne réponse");
	}

	@Test
	public void testIncorrectAnswer() {
		game.roll(3);
		game.handleIncorrectAnswer();
		assertTrue(player.getPenaltyBox(), "Le joueur devrait être en prison après une mauvaise réponse");
	}


	@Test
	public void testHandleJailWithOddRoll() {
		player.enterJail();
		int roll = 3;
		game.handleJail(player, roll);
		assertFalse(player.getPenaltyBox(), "Le joueur devrait sortir de la prison après un lancer impair");
	}


	@Test
	public void testHandleJailWithEvenRoll() {
		player.enterJail();
		int roll = 2;
		game.handleJail(player, roll);
		assertTrue(player.getPenaltyBox(), "Le joueur devrait rester en prison après un lancer pair");
	}

	@Test
	public void testNextPlayer() {
		game.add("Player 2");
		game.nextPlayer();
		Player currentPlayer = game.getCurrentPlayer();
		assertEquals("Player 2", currentPlayer.getName(), "Le joueur actuel devrait être Player 2");
	}


	@Test
	public void testGameEnd() {
		for (int i = 0; i < 6; i++) {
			game.handleCorrectAnswer();
		}
		assertEquals(6, player.getPurses(), "Le joueur devrait avoir 6 purses à la fin");
		assertFalse(game.handleCorrectAnswer(), "Le jeu devrait se terminer lorsque le joueur atteint 6 purses");
	}

	@Test
	public void testMaxPlayers() {
		for (int i = 0; i < 7; i++) {
			game.add("Player " + i);
		}

		assertEquals(6, game.getPlayers(), "La partie doit avoir 6 joueurs");
	}
}

