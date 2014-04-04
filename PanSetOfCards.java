import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PanSetOfCards extends JPanel {
	private static final long serialVersionUID = 1664468741870916353L;
	
	protected Font font;
	protected SetOfCards game;
	
	public PanSetOfCards(SetOfCards game) {
		super();
		super.setBackground(Constants.gameBackgroundColor);
		this.font = new Font(Constants.fontGame, Font.BOLD, Constants.cardsFontSize);
		this.game = game;
		
		// Creating the mouse listener
		addMouseListener(new PanSetOfCardsMouseListener(game, this));
        this.requestFocus();
	}
	
	public void paintComponent(Graphics g){
		String[][] matrix = game.getMatrix();
		
		// For the grey background
		super.paintComponent(g);
		g.setFont(this.font);
		g.setColor(Constants.cardsFontColor);
		
		try {
			Image imgHidden = ImageIO.read(new File("cardHidden.jpg"));
			Image imgDiscover = ImageIO.read(new File("cardDiscover.jpg"));
			
			for (int i=0 ; i<matrix.length ; i++) {
				for (int j=0 ; j<matrix[i].length; j++) {
					if (matrix[i][j].compareTo("null") == 0)
						g.drawImage(imgHidden, i*Constants.cardSize, j*Constants.cardSize, Constants.cardImageSize, Constants.cardImageSize, this);
					else {
						g.drawImage(imgDiscover, i*Constants.cardSize, j*Constants.cardSize, Constants.cardImageSize, Constants.cardImageSize, this);
						int textPositionX = i*Constants.cardSize + Constants.cardSize/2 - (int) ((matrix[i][j].length()+1)*Constants.cardsFontSize/3.3);
						int textPositionY = j*Constants.cardSize + Constants.cardSize/2 + Constants.cardsFontSize/6;
						g.drawString(matrix[i][j],  textPositionX , textPositionY);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
