/*
 * This function build the background panel and add a PanMenu panel to it
 */

package hku.view;

import hku.game.*;

import javax.swing.BoxLayout;
import javax.swing.Box;
import java.awt.Dimension;

import javax.swing.JPanel;

public class PanPlay extends JPanel {
	private static final long serialVersionUID = -3221806149850490822L;
	
    private WinMain main_panel;
    public MenuPanel pan;
    
    public PanPlay(WinMain main_panel){
           super();
           this.main_panel = main_panel;
           initPlayPanel();
    }
    
    
    private void initPlayPanel(){   
        this.setPreferredSize(main_panel.getSizeWin());
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        
        SetOfCards game = new SetOfCards(Constants.typeOfCardsOption, Constants.twoPlayer);
        game.shakeMatrix();
        this.addMenuPan(game);
        this.addPlayGame(game);
        
    }
    
    private void addMenuPan(SetOfCards game){
        this.pan = new MenuPanel(game, this);
        Dimension dimension = new Dimension(316,680);
        this.pan.setMaximumSize(dimension);
        this.pan.setMinimumSize(dimension);
        this.pan.setPreferredSize(dimension);
        pan.updateMenuPanel();
        this.add(pan);
    }
    
    private void addPlayGame(SetOfCards game){
        PanSetOfCards playPanel = new PanSetOfCards(game, this);
        Dimension dimension2 = new Dimension(Constants.cardsPerColumn*Constants.cardSize-Constants.margin,Constants.cardsPerRow*Constants.cardSize-Constants.margin);
        playPanel.setPreferredSize(dimension2);
        playPanel.setMaximumSize(dimension2);
        playPanel.setMinimumSize(dimension2);
        
        JPanel panelPlayPanel = new JPanel ();
        Dimension dimension = new Dimension(684,680);
        panelPlayPanel.setMaximumSize(dimension);
        panelPlayPanel.setMinimumSize(dimension);
        panelPlayPanel.setPreferredSize(dimension);
        panelPlayPanel.setBackground(Constants.gameBackgroundColor);
        panelPlayPanel.setLayout(new BoxLayout(panelPlayPanel, BoxLayout.Y_AXIS));
        
        panelPlayPanel.add(Box.createVerticalGlue());
        panelPlayPanel.add(playPanel); 
        panelPlayPanel.add(Box.createVerticalGlue());
       
        this.add(panelPlayPanel);
    } 
    
    public void backToMenu () {
    	main_panel.menu();
    }
    
}
