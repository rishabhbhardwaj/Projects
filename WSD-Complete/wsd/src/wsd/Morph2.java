/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wsd;

/**
 *
 * @author Rishabh
 */
import edu.stanford.nlp.ling.Word;
import edu.stanford.nlp.process.*;

import edu.stanford.nlp.io.IOUtils;
import edu.stanford.nlp.ling.CoreAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.LemmaAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.Word;
import edu.stanford.nlp.ling.WordLemmaTag;
import edu.stanford.nlp.ling.WordTag;
import edu.stanford.nlp.util.Function;
import java.io.*;
import java.nio.CharBuffer;
public class Morph2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        String args2[]=new String[3];
        args2[0]="bitterest";
        args2[1]="sitting";
        args2[2]="deposit";
        Reader reader1 = new StringReader(args2[0]);
            //System.out.println(args2[i]);
        Morphology morph = new Morphology(reader1);
        String s2=morph.lemma(args2[0],"NN");
        System.out.println("ADJ -> " + s2 );
        
    }
    
}
