/*
 * This function build the background panel and add a PanMenu panel to it
 */

package matchingpairs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.Box;


public class BackgroundPanel extends JPanel{
    final PanMenu menu = new PanMenu();
    
    BackgroundPanel(){
           initBackground();
           this.addMenuPanel();
    }
    
    private void initBackground(){
        this.setLayout(new BorderLayout());
        this.setBackground(Color.cyan);
    }
    
    private PanMenu addMenuPanel(){
        this.add(Box.createRigidArea(new Dimension(200,200)), BorderLayout.NORTH);
        this.add(Box.createRigidArea(new Dimension(400,200)), BorderLayout.WEST);
        this.add(Box.createRigidArea(new Dimension(400,200)), BorderLayout.EAST);
        this.add(Box.createRigidArea(new Dimension(200,200)), BorderLayout.SOUTH);
        this.add(menu, BorderLayout.CENTER);
        return menu;
    }
    
}
