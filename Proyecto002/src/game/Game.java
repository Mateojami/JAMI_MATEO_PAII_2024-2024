package game;

import javax.swing.*;

public class Game extends JFrame {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final int ENEMY_SPEED = 2; 

    private GamePanel gamePanel;

    public Game() {
        setTitle("GAME");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        String username = JOptionPane.showInputDialog(this, "Ingrese su nick:");
        if (username == null || username.isEmpty()) {
            username = "Usuario"; 
        }

        gamePanel = new GamePanel(ENEMY_SPEED); 
        gamePanel.getPlayer().setUsername(username);
        add(gamePanel);

        setVisible(true);
    }

    public void start() {
        gamePanel.start();
    }

}