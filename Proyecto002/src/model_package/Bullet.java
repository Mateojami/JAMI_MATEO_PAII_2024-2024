package model_package;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet implements Drawable, Movable {
    private int x;
    private int y;
    private final int SPEED = 8;

    public Bullet(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.fillOval(x, y, 10, 10);
    }

    @Override
    public void moveUp(int variable) {
        y -= SPEED;
    }
    
    @Override
    public void moveDown(int variable) {
        
    }

    @Override
    public void moveLeft(int variable) {
        
    }

    @Override
    public void moveRight(int variable) {
        
    }

    public int getY() {
        return y;
    }

    public boolean isVisible() {
        return y >= 0; 
    }
}
