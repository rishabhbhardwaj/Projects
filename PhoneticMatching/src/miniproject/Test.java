/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproject;

/**
 *
 * @author Rishabh
 */
import com.sun.speech.freetts.*;
import com.sun.speech.freetts.lexicon.*;
import java.net.URL;
import com.sun.speech.freetts.diphone.*;
import com.sun.speech.freetts.diphone.*;
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
        LetterToSoundImpl obj=new LetterToSoundImpl(new URL("file:///C:\\Users\\Rishabh\\Desktop\\cmulex_lts.bin"),true);
        String[] s=obj.getPhones("que",null);
        int l=s.length;
        for(int i=0;i<l;i++)
           System.out.print(s[i]+ " ");
        }
        catch(Exception e){}
        
    }
}
