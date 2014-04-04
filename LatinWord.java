import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class LatinWord extends Card {
        static int lineCount=0;
        static String [] word_list= new String[Constants.MaxLinesFile];

        LatinWord () {	        
	        // First initialisation
        	if (lineCount == 0) {
		        String filename = "Dictionary.txt";
		        File file = new File(filename);
		        Scanner scan;
		        
		        try {
		            scan = new Scanner(file);
		            do {
			            word_list[lineCount]= scan.nextLine();
			            lineCount++;
		            } while (scan.hasNextLine() && lineCount < Constants.MaxLinesFile);
		            scan.close();
		            
		        } catch (FileNotFoundException ex) {
		        	System.out.println(ex.getMessage()); 
		        }
        	}
	        
	        int randomNumber = (int) (Math.random() * lineCount);
	        
	        while (word_list[randomNumber].equals("this word has been used"))
	        	randomNumber = (int) (Math.random() * lineCount);
	        
	        super.cardString = word_list[randomNumber];
	        word_list[randomNumber]="this word has been used";
	        super.hidden=true;
        }

		LatinWord (String cardString) {
			super.cardString = cardString;
			super.hidden = true;
		}
}
