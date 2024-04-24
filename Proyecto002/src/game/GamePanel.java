package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GamePanel extends JPanel implements KeyListener {

    private Player player;
    private List<Enemy> enemies;
    private int enemySpeed;

    public GamePanel(int enemySpeed) {
        this.enemySpeed = enemySpeed;
        setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT));

        player = new Player(Game.WIDTH / 2 - 25, Game.HEIGHT - Game.HEIGHT / 3);
        enemies = new ArrayList<>();

        addKeyListener(this); // Agregar el KeyListener a este panel
        setFocusable(true);
        requestFocus();
    }

    public void start() {
        new Thread(() -> {
            while (true) {
                update();
                repaint();

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void update() {
        player.update();

        Iterator<Enemy> iterator = enemies.iterator();
        while (iterator.hasNext()) {
            Enemy enemy = iterator.next();
            enemy.update();
            if (enemy.getY() > Game.HEIGHT) {
                iterator.remove();
                if (player.getY() < Game.HEIGHT * 2 / 3) {
                    gameOver();
                    return;
                }
            } else if (enemy.getY() > Game.HEIGHT * 2 / 3) {
                // Si un enemigo cruza la línea, se activa el Game Over
                gameOver();
                return;
            }
        }

        if (Math.random() < 0.01) {
            enemies.add(new Enemy((int) (Math.random() * Game.WIDTH), 0, enemySpeed));
        }
    }

    private void gameOver() {
        JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT * 2 / 3);

        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, Game.HEIGHT * 2 / 3, Game.WIDTH, Game.HEIGHT / 3);

        player.draw(g);

        for (Enemy enemy : enemies) {
            enemy.draw(g);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // No se utiliza
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            player.updateVelocity(-5); // Mover hacia la izquierda
        }

        if (key == KeyEvent.VK_RIGHT) {
            player.updateVelocity(5); // Mover hacia la derecha
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
            player.updateVelocity(0); // Detener el movimiento cuando se suelta la tecla
        }
    }
}
