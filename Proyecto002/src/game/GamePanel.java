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
    private int score; 
    private int life; 

    public GamePanel(int enemySpeed) {
        this.enemySpeed = enemySpeed;
        setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT));

        enemies = new ArrayList<>();
        player = new Player(Game.WIDTH / 2 - 25, Game.HEIGHT - Game.HEIGHT / 3, enemies, ""); 

        score = 0; 
        life = 10; 

        addKeyListener(this); 
        setFocusable(true);
        requestFocus();
    }

    public void start() {
        new Thread(() -> {
            while (life >= 0) { 
                update();
                repaint();

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            gameOver(); 
        }).start();
    }



    private void update() {
        player.update();
        Iterator<Enemy> iterator = enemies.iterator();
        while (iterator.hasNext()) {
            Enemy enemy = iterator.next();
            enemy.update();
            if (!enemy.isAlive()) {
                iterator.remove();
                score++; 
            } else if (enemy.getY() > Game.HEIGHT * 2 / 3) {
                
                player.decreaseLife();
                iterator.remove();
            }
        }

        if (Math.random() < 0.01) {
            enemies.add(new Enemy((int) (Math.random() * Game.WIDTH), 0, enemySpeed));
        }

        if (player.getLife() <= 0) {
            gameOver();
        }
    }


    private void gameOver() {
        JOptionPane.showMessageDialog(this, "Game Over\nScore: " + score, "Game Over", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Fondo1
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT * 2 / 3);

        // Fondo2
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, Game.HEIGHT * 2 / 3, Game.WIDTH, Game.HEIGHT / 3);

        // Jugador
        player.drawable(g);

        // Enemigos
        for (Enemy enemy : enemies) {
            enemy.drawable(g);
        }

        // Life
        g.setColor(Color.WHITE);
        g.drawString("Life:", 20, 50);

        // Barra vida
        g.setColor(Color.RED);
        int barWidth = (int) (((double) player.getLife() / 10) * (Game.WIDTH - 100)); 
        g.fillRect(60, 40, barWidth, 10); 
        
        // Nombre usuario
        g.setColor(Color.WHITE);
        g.drawString("Player: " + player.getUsername(), 20, 20);

        // Score
        g.setColor(Color.WHITE);
        g.drawString("Score: " + score, Game.WIDTH - 100, 20);
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            player.updateVelocity(-5); 
        }

        if (key == KeyEvent.VK_RIGHT) {
            player.updateVelocity(5); 
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
            player.updateVelocity(0); 
        }
    }

    public int getScore() {
        return score;
    }

    public Player getPlayer() {
        return player;
    }
}
