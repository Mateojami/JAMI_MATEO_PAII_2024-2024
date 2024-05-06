package controlador_package;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model_package.Enemy;
import model_package.Player;

public class Container {
    
    final int SCREEN_WIDTH = 700;
    final int SCREEN_HEIGHT = 200;
    
    Player player = new Player();
    List <Enemy> enemies = new ArrayList<>();
    Random random = new Random();
    
    public Container() {
        enemies.add(new Enemy(random.nextInt(SCREEN_WIDTH), random.nextInt(SCREEN_HEIGHT)));
        enemies.add(new Enemy(random.nextInt(SCREEN_WIDTH), random.nextInt(SCREEN_HEIGHT)));
        enemies.add(new Enemy(random.nextInt(SCREEN_WIDTH), random.nextInt(SCREEN_HEIGHT)));
        enemies.add(new Enemy(random.nextInt(SCREEN_WIDTH), random.nextInt(SCREEN_HEIGHT)));
        enemies.add(new Enemy(random.nextInt(SCREEN_WIDTH), random.nextInt(SCREEN_HEIGHT)));
    }
    
    public void draw(Graphics graphics) {
        player.draw(graphics);
        for(Enemy enemy : enemies) {
            enemy.draw(graphics);
        }
    }
    
    public void update() {
        
    }
    
    public void keyPressed(KeyEvent e) {
        
        int keyCode = e.getKeyCode();
        switch(keyCode) {
            case KeyEvent.VK_LEFT:
                player.moveLeft(5);
                break;
            case KeyEvent.VK_RIGHT:
                player.moveRight(5);
                break;
            
        }
    }
    
    public void keyReleased(KeyEvent e) {
        
    }
}
