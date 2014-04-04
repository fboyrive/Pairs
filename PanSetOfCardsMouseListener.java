import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;


public class PanSetOfCardsMouseListener implements MouseListener {
	private SetOfCards game;
	private boolean waitForClick1;
	private PanSetOfCards pan;
	private Timer t;
	
	PanSetOfCardsMouseListener (final SetOfCards game, final PanSetOfCards pan) {
		this.waitForClick1 = true;
	    this.game = game;
	    this.pan = pan;
	    
	    // Preparation for the 2 secondes timer
	    t = new Timer(Constants.wrongTryWaitingTime, new ActionListener() {
	          public void actionPerformed(ActionEvent e) {
	        	  game.endClock();
	        	  pan.repaint();
	        	  t.stop();
	          }
	       });
	}	
	
	public void mouseClicked(MouseEvent m)
    {
		int x = m.getX()/Constants.cardSize;
		int y = m.getY()/Constants.cardSize;
		int modx = m.getX()%Constants.cardSize;
		int mody = m.getY()%Constants.cardSize;
				
		if (x >= 0 && y >= 0 && x < Constants.cardsPerColumn && y < Constants.cardsPerRow && modx < Constants.cardImageSize && mody < Constants.cardImageSize) {				
	        if (!t.isRunning() && waitForClick1 && (game.click1(x, y))) {
	        	waitForClick1 = false;
	        	pan.repaint();
	        }
	        else if (!waitForClick1 && game.click2(x, y)) { // waitForClick2
	        	waitForClick1 = true;
	        	pan.repaint();
	        	if (game.getClock())
	        		this.t.start();
	        	else if (game.win())
	        		JOptionPane.showMessageDialog(null, "You won!","Congratulations",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("Win.png"));
	        }
		}
    }
 
    public void mouseEntered(MouseEvent arg0) {}
    public void mouseExited(MouseEvent arg0) {}
    public void mousePressed(MouseEvent arg0) {}
    public void mouseReleased(MouseEvent arg0) {}
}
