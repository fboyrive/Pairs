public class SetOfCards {

    	final static int cardsPerLine = 4;
    	final static int cardsPerRow = 4;
    	private Card[][] card_matrix = new Card[cardsPerLine][cardsPerRow];
    	private int numberOfTries;
    	private int numberOfSuccess;
    	private Card[] tempCard = new Card[2];
    	private boolean clock;
    
    	SetOfCards (int option) {
    		// option == 1 => SetOfLatinLetters
    		// option == 2 => SetOfLatinWords
    		// ...

	    	for (int i=0 ; i<cardsPerRow ; i++) {   
		    	for(int j=0 ; j<cardsPerLine ; j=j+2) {
		    		if (option == 1) {
		    			card_matrix[i][j]= new LatinLetter();
		    			card_matrix[i][j+1]= new LatinLetter (card_matrix[i][j].getCardString());
		    		}
		    		else if (option==2) {
		    			card_matrix[i][j]= new LatinWord();
		    			card_matrix[i][j+1]= new LatinWord (card_matrix[i][j].getCardString());
		    		}
		    	}
	    	}
	    	this.numberOfTries = 0;
	    	this.numberOfSuccess = 0;
	    	this.clock=false;
    	}
    
    	public void shakeMatrix () {
    	/*
    	 *  Let t be a n length table to shake
		 *	for i from n-1 to 2 included, do:
		 *	j = take a random number between 0 and i included
		 *	exchange t[i] and t[j]
		 *	end for
    	 */
	    	int rand;
	    	Card temp;
	    	for(int i= cardsPerLine*cardsPerRow -1 ; i>=2 ; i--) {
	    		rand = (int) (Math.random() * (i+1));
	    		temp = card_matrix[(int) i/cardsPerLine][i%cardsPerLine];
	    		card_matrix[(int) i/cardsPerLine][i%cardsPerLine]=card_matrix[(int) rand/cardsPerLine][rand%cardsPerLine];
	    		card_matrix[(int) rand/cardsPerLine][rand%cardsPerLine] = temp;
	    	}
    	}
    
    	public String[][] getMatrix() {
	    	String[][] matrix = new String [cardsPerLine][cardsPerRow];
	    	for (int i=0 ; i<cardsPerRow ; i++) {   
		    	for(int j=0 ; j<cardsPerLine ; j++) {
		    		if (card_matrix[i][j].isHidden())
		    			matrix[i][j]="null";
		    		else
		    			matrix[i][j]=card_matrix[i][j].getCardString();
		    	}
	    	}
	    	return matrix;
    	}
    
    	public int getNumberOfTries() {
    		return this.numberOfTries;
    	}
    
    	public boolean win() {
    		return (this.numberOfSuccess==(cardsPerLine*cardsPerRow/2));
    	}
      
    	public boolean click1 (int x, int y) {
    		if (x<0 || x>= cardsPerLine || y<0 || y>=cardsPerRow)
    			return false;
    		else if (!card_matrix[x][y].isHidden())
    			return false;
    		else {
    			card_matrix[x][y].discover();
    			tempCard[0] = card_matrix[x][y];
    			return true;
    		}
    	}
    	
    	public boolean click2 (int x, int y) {
    		if (x<0 || x>= cardsPerLine || y<0 || y>=cardsPerRow)
    			return false;
    		else if (!card_matrix[x][y].isHidden())
    			return false;
    		else {
				card_matrix[x][y].discover();
    			numberOfTries++;
    			if (card_matrix[x][y].getCardString().compareTo(tempCard[0].getCardString())==0) {
    				tempCard[0]=null;
    				this.numberOfSuccess++;
    			}
    			else {
    				clock=true;
    				tempCard[1]=card_matrix[x][y];
    			}
    			return true;
    		}
    	}
    	
    	public boolean getClock() {
    		return clock;
    	}
    	
    	public void endClock() {
    		clock=false;
    		tempCard[0].hide();
    		tempCard[1].hide();
    		tempCard[0]=null;
    		tempCard[1]=null;
    	}
    
    	public String toString() {
	    	String print="";
	    	for (int i=0 ; i<cardsPerRow ; i++) {   
		    	for(int j=0 ; j<cardsPerLine ; j++) {
		    		if (card_matrix[i][j].isHidden())
		    		print= print + "Card ("+i + ","+ j+ "): "+ card_matrix[i][j].getCardString()+" (hidden)\n";
		    		else
			    	print= print + "Card ("+i + ","+ j+ "): "+ card_matrix[i][j].getCardString()+" (visible)\n";
		    	}
	    	}
	    	return print;
    	}
}
