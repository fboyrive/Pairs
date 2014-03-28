/*
 * This class is the panel that holds the button of the menu
 */
package matchingpairs;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.Box;


public class PanMenu extends JPanel{
    
    public PanMenu(){ 
        initMenu();
    }
    
    private void initMenu(){
        
        this.setPreferredSize(new Dimension(300, 300));
        this.setBackground(new Color(100, 56, 64));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(Box.createRigidArea(new Dimension(100,30)));
        addAButton("Play");
        this.add(Box.createRigidArea(new Dimension(10,0)));
        addAButton("Options");
        this.add(Box.createRigidArea(new Dimension(10,0)));
        addAButton("Help");
        this.add(Box.createRigidArea(new Dimension(10,0)));
        addAButton("Credits");
        this.add(Box.createRigidArea(new Dimension(0,30)));
    }
    
    private void addAButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(300, 100));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setAlignmentY(Component.CENTER_ALIGNMENT);
        this.add(button);
    }
    
}
