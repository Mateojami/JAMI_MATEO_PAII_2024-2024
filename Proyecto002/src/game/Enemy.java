// Enemy.java
package game;

import java.awt.*;
import interfaces.IShip;

public class Enemy implements IShip {
    private int x, y;
    private int dy;
    private boolean alive = true; 
    private static final int SIZE = 40;

    public Enemy(int x, int y, int speed) {
        this.x = x;
        this.y = y;
        this.dy = speed;
    }

    @Override
    public void update() {
        y += dy;
    }

    @Override
    public void drawable(Graphics g) {
        if (alive) {
            g.setColor(Color.GREEN);
            g.fillRect(x, y, SIZE, SIZE);
        }
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void die() {
        alive = false;
    }

    @Override
    public void shootable() {
        // Los enemigos no disparan
    }

    public boolean isHit(int projectileX, int projectileY) {
        return projectileX >= x && projectileX <= x + SIZE && projectileY >= y && projectileY <= y + SIZE;
    }

    public boolean isAlive() {
        return alive;
    }
}
