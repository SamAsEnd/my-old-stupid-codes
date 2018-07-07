package gameframework;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 * Actual game.
 *
 * @author www.gametutorial.net
 */
public class Game {

    int x, y;

    public Game() {
        Framework.gameState = Framework.GameState.GAME_CONTENT_LOADING;

        Thread threadForInitGame = new Thread() {
            @Override
            public void run() {
                // Sets variables and objects for the game.
                Initialize();
                // Load game files (images, sounds, ...)
                LoadContent();

                Framework.gameState = Framework.GameState.PLAYING;
            }
        };
        threadForInitGame.start();
    }

    /**
     * Set variables and objects for the game.
     */
    private void Initialize() {
    }

    /**
     * Load game files - images, sounds, ...
     */
    private void LoadContent() {
    }

    /**
     * Restart game - reset some variables.
     */
    public void RestartGame() {
    }

    /**
     * Update game logic.
     *
     * @param gameTime gameTime of the game.
     * @param mousePosition current mouse position.
     */
    public void UpdateGame(long gameTime, Point mousePosition) {
        if (x == 768) {
            x = 0;
            y = 0;
        }
        x++;
        y++;
    }

    /**
     * Draw the game to the screen.
     *
     * @param g2d Graphics2D
     * @param mousePosition current mouse position.
     */
    public void Draw(Graphics2D g2d, Point mousePosition) {
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, 1024, 768);
        g2d.setColor(Color.RED);
        g2d.drawString("Sam As End " + System.nanoTime(), x, y);
        System.out.println(System.nanoTime());
    }
}
