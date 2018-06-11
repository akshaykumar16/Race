/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thatikonda_finalproject;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ThatiKonda
 */
public class ThatiKonda_FinalProject extends JFrame {

    /**
     * @param args the command line arguments
     */
    Drawing Drawclass;
    JPanel PanBtn;
    Button Gobt;
    JLabel showMessagelb;
    JPanel PanLabel;
    ThatiKonda_Move move;

    int TurtlePt = 0;
    int RabbitPt = 0;

    public static void main(String[] args) {
        // TODO code application logic here
        ThatiKonda_FinalProject Testing = new ThatiKonda_FinalProject();
        Testing.show();
    }

    public ThatiKonda_FinalProject() {
        this.setSize(520, 300);
        Drawclass = new Drawing();
        PanBtn = new JPanel();
        Gobt = new Button("Go");
        showMessagelb = new JLabel();
        PanLabel = new JPanel();

        setTitle("Racing ChampionShip");

        Container contentPane = getContentPane();
        getContentPane().setLayout(new BorderLayout());

        contentPane.add(BorderLayout.NORTH, PanLabel);
        contentPane.add(BorderLayout.CENTER, Drawclass);
        contentPane.add(BorderLayout.SOUTH, PanBtn);

        PanLabel.add(showMessagelb);
        PanBtn.add(Gobt);

        contentPane.setBackground(Color.ORANGE);
        PanBtn.setBackground(Color.ORANGE);
        PanLabel.setBackground(Color.ORANGE);

        Gobt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ThatiKonda_Thread Thati1 = new ThatiKonda_Thread(1, move);
                Thati1.start();

                ThatiKonda_Thread Thati2 = new ThatiKonda_Thread(2, move);
                Thati2.start();
            }
        });

        move = new ThatiKonda_Move(this);
    }

    void Walk(int x, int i) {

        if (i == 1) {
            TurtlePt = x;

        } else if (i == 2) {
            RabbitPt = x;

        }
        Drawclass.repaint();

    }

    private class Drawing extends Canvas {

        public Drawing() {
        }

        public void paint(Graphics gObj) {
            gObj.drawLine(0, 100, 500, 100);
            gObj.drawLine(0, 120, 500, 120);
            gObj.drawLine(0, 10, 520,10);
            gObj.drawLine(0, 12, 520, 12);

            gObj.drawLine(0, 160, 500, 160);
            gObj.drawLine(0, 180, 500, 180);

            for (int x = 0; x <= 500; x = x + 10) {
                gObj.drawLine(x, 100, x, 120);
                gObj.drawLine(x, 160, x, 180);
            }
            gObj.drawString("T", TurtlePt +1, 115);
             gObj.drawString("R", RabbitPt +1, 175);
                          
            ImageIcon I1 = new ImageIcon(getClass().getResource("Turtle.jpg"));
            ImageIcon I2 = new ImageIcon(getClass().getResource("Rabbit.jpg"));
            ImageIcon I3 = new ImageIcon(getClass().getResource("Winner.gif"));
            
            if(TurtlePt>=500)
            {
            I1.paintIcon(this, gObj, 250, 40);
            I3.paintIcon(this, gObj, 50, 30);
            gObj.drawString("Winner Tortoise",200, 145);
            }
            else if (RabbitPt>=500)
            {
            I2.paintIcon(this, gObj, 250, 40);
            I3.paintIcon(this, gObj, 50, 30);
            gObj.drawString("Winner Rabbit",200, 145);
            }
        }
    }
}
