import javax.swing.JFrame;

public class WindowGame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public WindowGame (SetOfCards game) {                
	    this.setTitle("Pairs Game");
	    this.setSize(Constants.windowHeight, Constants.windowWidth);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setResizable(false);
	    	    
	    PanSetOfCards pan = new PanSetOfCards(game);
	    this.setContentPane(pan);
	    this.setVisible(true);
    }
	
	public static void main(String[] args) {
		// First parameter 1: Playing LatinLetters
		// First parameter 2: Playing LatinWords
		// Second Parameter : true for two players, false for one
		
		SetOfCards game = new SetOfCards(2, false);
		game.shakeMatrix();
		
		//GUI Window
		MenuFrame menuPanel = new MenuFrame();
		menuPanel.setVisible(true);
		MenuFrame.updateMenuPanel();
		new WindowGame(game);
	}
}
