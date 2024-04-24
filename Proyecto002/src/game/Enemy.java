package game;

import java.awt.*;

import interfaces.IShip;

public class Enemy implements IShip {

    private int x, y;
    private int dy;
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
    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x, y, SIZE, SIZE);
    }

    @Override
    public int getY() {
        return y;
    }
}
