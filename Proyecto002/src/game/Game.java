package game;

import javax.swing.*;

public class Game extends JFrame {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final int ENEMY_SPEED = 2; // Velocidad del enemigo

    private GamePanel gamePanel;

    public Game() {
        setTitle("GAME");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        gamePanel = new GamePanel(ENEMY_SPEED); // Pasar la velocidad del enemigo al crear GamePanel
        add(gamePanel);

        setVisible(true);
    }

    public void start() {
        gamePanel.start();
    }
}
