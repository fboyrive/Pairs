import javax.swing.JFrame;
 
public class WindowGame extends JFrame {
	private PanSetOfCards pan;
	
	public WindowGame (SetOfCards game) {                
	    this.setTitle("Pairs Game");
	    this.setSize(630, 650);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setResizable(false);
	    
	    this.setVisible(true);
	    this.pan = new PanSetOfCards(game);
	    this.setContentPane(pan);
    }
	
	public void refreshWindow() {
		pan.repaint();
	}
}
