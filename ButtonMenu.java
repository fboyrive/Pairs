package hku.view;
/*
 * This class is used to personnalize our Buttons
 */

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import java.awt.Dimension;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException; 
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
//import java.awt.FontMetrics;


public class ButtonMenu extends JButton implements MouseListener{
    private String name;
    private Font button_font;
    private InputStream is;
    private Color c = Color.WHITE;
    private int adv = 115;
    private int hgt = 20;
    private int sizeChar = 30;
            
    
    public ButtonMenu(String str){
        super(str);
        
        try{
            is = new FileInputStream("Colored_Crayons.ttf");
            try{
                button_font = Font.createFont(Font.TRUETYPE_FONT, is);
                button_font = button_font.deriveFont(Font.BOLD, sizeChar);
            }catch(Exception ie){
                ie.printStackTrace();
                System.err.println(name + " not loaded.  Using serif font.");
                button_font = new Font("TimesRoman",Font.BOLD,sizeChar);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        addMouseListener(this);
        this.name = str;
        this.setMinimumSize(new Dimension((sizeChar/2 + 2)*name.length()+2,hgt+2));//The space between 2 char = sizeChar/2
        this.setMaximumSize(new Dimension((sizeChar/2 + 2)*name.length()+2,hgt+2));
  }
    
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        g2d.setFont(button_font);
        g2d.setColor(c);
        g2d.drawString(name, 0, 25);
        /*FontMetrics metrics = g.getFontMetrics(button_font);
        hgt = metrics.getHeight();
        adv = metrics.stringWidth(name);*/  
     }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {
        c =Color.ORANGE;
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        c = Color.WHITE;
        repaint();
    }
}
