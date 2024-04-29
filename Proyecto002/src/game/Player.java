package game;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.Timer;

import interfaces.IShip;

public class Player implements IShip {

    private int x, y;
    private List<Enemy> enemies;
    private int dx;
    private static final int SPEED = 5;
    private static final int LEFT_BOUNDARY = 0;
    private static final int RIGHT_BOUNDARY = Game.WIDTH - 50;
    private static final int PROJECTILE_SPEED = 8;
    private List<Ellipse2D.Double> projectiles;
    private Timer timer;
    private String username; 
    private int life; 

    public Player(int x, int y, List<Enemy> enemies, String username) {
        this.x = x;
        this.y = y;
        this.enemies = enemies;
        this.username = username;
        projectiles = new ArrayList<>();
        life = 10; //Vida del jugador

        timer = new Timer(500, e -> shootable());
        timer.start();
    }

    @Override
    public void update() {
        x += dx;

        if (x < LEFT_BOUNDARY) {
            x = LEFT_BOUNDARY;
        } else if (x > RIGHT_BOUNDARY) {
            x = RIGHT_BOUNDARY;
        }

        Iterator<Ellipse2D.Double> iterator = projectiles.iterator();
        while (iterator.hasNext()) {
            Ellipse2D.Double projectile = iterator.next();
            projectile.y -= PROJECTILE_SPEED;
            if (projectile.y < 0) {
                iterator.remove(); 
            } else {
                Iterator<Enemy> enemyIterator = enemies.iterator();
                while (enemyIterator.hasNext()) {
                    Enemy enemy = enemyIterator.next();
                    if (enemy.isHit(x + 25, (int) projectile.getY() - 50)) {
                        enemy.die();
                        iterator.remove(); 
                    }
                }
            }
        }
    }


    @Override
    public void drawable(Graphics g) {
        g.setColor(Color.WHITE);
        int[] xPoints = {x, x + 25, x + 50};
        int[] yPoints = {y + 50, y, y + 50};
        int nPoints = 3;
        g.fillPolygon(xPoints, yPoints, nPoints);

        g.setColor(Color.WHITE);
        for (Ellipse2D.Double projectile : projectiles) {
            int px = (int) Math.round(projectile.getX());
            int py = (int) Math.round(projectile.getY());
            int width = (int) Math.round(projectile.getWidth());
            int height = (int) Math.round(projectile.getHeight());
            g.fillOval(px, py, width, height);
        }
    }

    public void updateVelocity(int dx) {
        this.dx = dx;
    }

    @Override
    public void shootable() {
        Ellipse2D.Double projectile = new Ellipse2D.Double(x + 22, y - 10, 6, 6);
        projectiles.add(projectile);
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void die() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getLife() {
        return life;
    }

    public void decreaseLife() {
        life--; 
        
    }
}