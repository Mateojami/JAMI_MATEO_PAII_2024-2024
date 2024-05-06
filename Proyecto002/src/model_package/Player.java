package model_package;

import java.awt.Color;
import java.awt.Graphics;

public class Player implements Drawable, Movable{
	
	int[] coord_x = {400, 450, 350};
	int[] coord_y = {500, 550, 550}; 

	@Override
	public void draw(Graphics graphics) {
		graphics.setColor(Color.WHITE);
		graphics.fillPolygon(coord_x, coord_y, 3);
		
	}

	@Override
	public void moveUp(int variable) {
		
		
	}

	@Override
	public void moveDown(int variable) {
		
		
	}

	@Override
	public void moveLeft(int variable) {
		
		for(int i=0; i<coord_x.length; i++) {
			coord_x[i] = coord_x[i] - variable;
		}
		
	}

	@Override
	public void moveRight(int variable) {
		
		for(int i=0; i<coord_x.length; i++) {
			coord_x[i] = coord_x[i] + variable;
		}
		
	}

}