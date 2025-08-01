import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

public class main{
    public static void main(String[] args) {
        JFrame frame = new JFrame("DVD");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        MyPanel panel = new MyPanel();
        frame.add(panel);
        ActionListener action = new ActionListener() {
            int xspeed = 2, yspeed = 2;
            @Override
            public void actionPerformed(ActionEvent e) {
                Color colorBack = new Color((int)(Math.random()*255), (int)(Math.random()*255),(int)(Math.random()*255));
                Color textColor = new Color((int)(Math.random()*255), (int)(Math.random()*255),(int)(Math.random()*255));
                panel.x += xspeed;
                panel.y += yspeed;
                if(panel.x<=0 || panel.x >= 900){
                    xspeed = -xspeed;
                    
                    panel.setBackground(colorBack);
                    panel.setTextColor(textColor);
                }
                if (panel.y<=10 || panel.y>= 750){
                    yspeed = -yspeed;
                    panel.setBackground(colorBack);
                    panel.setTextColor(textColor);
                }
                panel.repaint();
            }
        };

        Timer timer = new Timer(3, action);
        timer.start();
        frame.setVisible(true);
    }

}



public class MyPanel extends JPanel{
    private BufferedImage image;
    private Color textColor;
    int x = 350, y = 20;
    MyPanel(){
        try {
            setBackground(Color.CYAN);
            image = ImageIO.read(new File("333.png"));
        } catch (Exception e) {
            System.out.println("gg");
        }
    }

    public void setTextColor(Color textColor){
        this.textColor = textColor;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Arial", Font.BOLD,50));
        g.setColor(textColor);
        g.drawString("DVD", x, y);
    
    }
}


