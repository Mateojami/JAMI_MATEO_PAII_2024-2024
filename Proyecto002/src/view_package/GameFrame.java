package view_package;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controlador_package.Container;

public class GameFrame extends JFrame implements KeyListener {
    
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Container container;

    public GameFrame(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        
        container = new Container();
        contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                container.draw(g);
            }
        };
        contentPane.setBackground(Color.black);
        setContentPane(contentPane);
        addKeyListener(this);
        
        setFocusable(true);
        requestFocus();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        container.keyPressed(e);
        repaint(); 
    }

    @Override
    public void keyReleased(KeyEvent e) {
        container.keyReleased(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {
       
    }
}
