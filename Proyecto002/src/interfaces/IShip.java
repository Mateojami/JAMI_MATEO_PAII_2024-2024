package interfaces;

import java.awt.*;

public interface IShip {
	void update();
    void drawable(Graphics g);
    int getY();
    void shootable();
    void die();
}
