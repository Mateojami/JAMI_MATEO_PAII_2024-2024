package paq;

/**
 * Autor: Mateo Jami
 * Titulo: Inversion de control
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Main extends JFrame {
    private JPanel drawingPanel;
    private boolean dibujarTriangulo = false;
    private boolean dibujarCuadrado = false;
    private boolean dibujarCirculo = false;

    public Main() {
        setTitle("Figuras");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (dibujarTriangulo) {
                    dibujarTriangulo(g);
                } else if (dibujarCuadrado) {
                    dibujarCuadrado(g);
                } else if (dibujarCirculo) {
                    dibujarCirculo(g);
                }
            }
        };

        JButton triangleButton = new JButton("Dibujar triangulo");
        triangleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dibujarTriangulo = true;
                dibujarCuadrado = false;
                dibujarCirculo = false;
                drawingPanel.repaint();
            }
        });

        JButton squareButton = new JButton("Dibujar cuadrado");
        squareButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dibujarTriangulo = false;
                dibujarCuadrado = true;
                dibujarCirculo = false;
                drawingPanel.repaint();
            }
        });

        JButton circleButton = new JButton("Dibujar circulo");
        circleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dibujarTriangulo = false;
                dibujarCuadrado = false;
                dibujarCirculo = true;
                drawingPanel.repaint();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.add(Box.createVerticalGlue()); 
        buttonPanel.add(triangleButton);
        buttonPanel.add(Box.createVerticalStrut(10)); 
        buttonPanel.add(squareButton);
        buttonPanel.add(Box.createVerticalStrut(10)); 
        buttonPanel.add(circleButton);
        buttonPanel.add(Box.createVerticalGlue()); 

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(drawingPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.WEST);
    }

    private void dibujarTriangulo(Graphics g) {
    	int[] xPoints = {200, 300, 250};
        int[] yPoints = {220, 220, 120};
        int nPoints = 3;
        g.setColor(Color.RED);
        g.fillPolygon(xPoints, yPoints, nPoints);
    }

    private void dibujarCuadrado(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(200, 120, 100, 100);
    }

    private void dibujarCirculo(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillOval(200, 120, 100, 100);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Main frame = new Main();
                frame.setVisible(true);
            }
        });
    }
}

