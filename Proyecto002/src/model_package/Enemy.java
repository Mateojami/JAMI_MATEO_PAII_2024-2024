package model_package;

import java.awt.Color;
import java.awt.Graphics;

public class Enemy implements Drawable, Movable{
	
	int[] coord_x = new int [5];
	int[] coord_y = new int [5];
	
	public Enemy(int randomX, int randomY) {
		coord_x[0] = randomX;
		coord_x[1] = randomX+100;
		coord_x[2] = randomX+100;
		coord_x[3] = randomX+50;
		coord_x[4] = randomX;
		
		coord_y[0] = randomY;
		coord_y[1] = randomY;
		coord_y[2] = randomY+50;
		coord_y[3] = randomY+25;
		coord_y[4] = randomY+50;
		
	}
	
	@Override
	public void draw(Graphics graphics) {
		graphics.setColor(Color.GREEN);
		graphics.fillPolygon(coord_x, coord_y, 5 );
	}

	@Override
	public void moveUp(int variable) {
	
		
	}

	@Override
	public void moveDown(int variable) {
		for(int i=0; i<coord_y.length; i++) {
			coord_y[i] = coord_y[i] + variable;
		}
		
	}

	@Override
	public void moveLeft(int variable) {
		
		
	}

	@Override
	public void moveRight(int variable) {
		
		
	}

}