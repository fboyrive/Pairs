import javax.swing.JFrame;
 
public class WindowGame extends JFrame {
	private PanSetOfCards pan;
	
	public WindowGame (SetOfCards game) {                
	    this.setTitle("Pairs Game");
	    this.setSize(630, 650);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setResizable(false);
	    
	    this.pan = new PanSetOfCards(game);
	    this.setContentPane(pan);
	    this.setVisible(true);
    }
	
	public void refreshWindow() {
		pan.repaint();
	}
}
