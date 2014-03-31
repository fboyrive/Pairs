import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PanSetOfCards extends JPanel {
	protected Font font;
	protected SetOfCards game;
	
	public PanSetOfCards(SetOfCards game) {
		super();
		super.setBackground(Color.GRAY);
		this.font = new Font("Courier", Font.BOLD, 40);
		this.game = game;
	}
	
	public void paintComponent(Graphics g){
		String[][] matrix = game.getMatrix();
		
		// For the grey background
		super.paintComponent(g);
		g.setFont(this.font);
		g.setColor(Color.red);
		
		try {
			Image imgHidden = ImageIO.read(new File("cardHidden.jpg"));
			Image imgDiscover = ImageIO.read(new File("cardDiscover.jpg"));
			
			for (int i=0 ; i<matrix.length ; i++) {
				for (int j=0 ; j<matrix[i].length; j++) {
					if (matrix[i][j].compareTo("null") == 0)
						g.drawImage(imgHidden, i*160, j*160, this);
					else {
						g.drawImage(imgDiscover, i*160, j*160, this);
						g.drawString(matrix[i][j], i*160+72 - matrix[i][j].length()*12, j*160+85);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
