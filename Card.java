public abstract class Card {
    	protected String cardString;
    	protected boolean hidden;
    	
    
    	public boolean isHidden () {
        	return hidden;
    	}
    
    	public void hide () {
    		this.hidden = true;   
    	}
	
    	public void discover () {
    		this.hidden = false;   
    	}

    	public String getCardString () {
    		return this.cardString;
    	}

    	public String toString() {
        	return ("Card "+cardString+", hidden: "+ this.hidden);
    	}
}
