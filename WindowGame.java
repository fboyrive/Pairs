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
		// option 1: LatinLetters
		// option 2: LatinWords
		SetOfCards game = new SetOfCards(2);
		game.shakeMatrix();
		
		//GUI Window
		MenuFrame menuPanel = new MenuFrame();
		menuPanel.setVisible(true);
		menuPanel.updateMenuPanel();
		new WindowGame(game);
	}
}
