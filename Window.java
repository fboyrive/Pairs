/*
*This class holds the Frame = window that contains everything
 */

package matchingpairs;

import java.awt.BorderLayout;
import java.awt.*;
import javax.swing.JFrame;
import java.awt.Dimension;

public class Window extends JFrame{
        final Dimension sizeWindow = new Dimension(1000,700);
        
    public Window(){ 
        BackgroundPanel main_panel;
        
        
        main_panel = new BackgroundPanel();
        initWin();
       
        //adding the panel
        this.getContentPane().add(main_panel);
        
        //displaying
        //this.pack();
        this.setVisible(true);
    }
    
    private void initWin(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        this.setTitle("Matching Pairs");
        this.setSize(sizeWindow);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
    }
    
}
