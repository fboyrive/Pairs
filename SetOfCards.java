public class SetOfCards {

    	final static int cardsPerLine = 4;
    	final static int cardsPerRow = 4;
    	private Card[][] card_matrix = new Card[cardsPerLine][cardsPerRow];
        static int[] numberOfTries = new int[3], numberOfSuccess= new int[3], numberOfFailures= new int[3]; //[1]=p1, [2]=p2, just set to 3 values for easy of reading
    	private Card[] tempCard = new Card[2];
    	private boolean clock;
        static int player= 1;
        static boolean twoPlayers= true;
    
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
    
    
    	public boolean win() {
    		return (this.numberOfSuccess[1]==(cardsPerLine*cardsPerRow/2));
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
    			
                        numberOfTries[player]++;
    			
                        if (card_matrix[x][y].getCardString().compareTo(tempCard[0].getCardString())==0) {
    				tempCard[0]=null;
    				numberOfSuccess[player]++;
    			}
    			else {
    				clock=true;
    				tempCard[1]=card_matrix[x][y];
                                numberOfFailures[player]++;
                                if(twoPlayers==true) changePlayer();
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
    
    private void changePlayer() {
        if (player==1)player=2;
        else player=1; 
    }
}
