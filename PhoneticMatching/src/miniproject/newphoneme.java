package miniproject;

import com.sun.speech.freetts.*;
import com.sun.speech.freetts.lexicon.*;
import java.net.URL;
import com.sun.speech.freetts.diphone.*;
import com.sun.speech.freetts.diphone.*;

public class newphoneme {
    
   String find_phoneme(String in) 
   {
       String ans="";
       
       try{
        LetterToSoundImpl obj=new LetterToSoundImpl(new URL("file:///C:\\Users\\Rishabh\\Desktop\\cmulex_lts.bin"),true);
        String[] s=obj.getPhones(in,null);
        int l=s.length;
        for(int i=0;i<l;i++)
           ans+=s[i]+"#";
        }
        catch(Exception e){}
       
       
       return ans;
       
   }
}
