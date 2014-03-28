import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LatinWord extends Card {
        static int i=0, z=0, MAX_WORDS=100, wordsUsed=0;
        static String [] word_list= new String[MAX_WORDS];
        static int [] used_indexes= new int[MAX_WORDS];
	
        LatinWord () {
        int lineCount=0,randomNumber;
        String filename = "Dictionary.txt";
        File file = new File(filename);
        Scanner scan;
        
        try {
            scan = new Scanner(file);
            do{
            word_list[i]= scan.nextLine();
            i++;
            lineCount++;
            }while (scan.hasNextLine());
            scan.close(); 
            
           } catch (FileNotFoundException ex) {
            Logger.getLogger(LatinWord.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        randomNumber = (int) (Math.random() * lineCount);
        while (word_list[randomNumber].equals("this word has been used"))
        {
            randomNumber = (int) (Math.random() * lineCount);
        }
        
        super.cardString = word_list[randomNumber];
        word_list[randomNumber]="this word has been used";
        super.hidden=true;
        }
	
	LatinWord (String cardString) {
		super.cardString = cardString;
		super.hidden = true;
	}
   
}
