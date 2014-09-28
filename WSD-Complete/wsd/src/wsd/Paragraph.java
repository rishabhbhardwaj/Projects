/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wsd;

/**
 *
 * @author Rishabh
 */
import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import edu.stanford.nlp.trees.Tree;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
public class Paragraph {

    /**
     * @param args the command line arguments
     */
    public static int sentences_num=0;
    public static ArrayList<ArrayList<myString>> myList = new ArrayList<ArrayList<myString>>();
    // myList[i][j] i is for sentence number in the input text and j is for 'jth' word of 'ith' sentence.
    public static String delims = "[+\\-*/\\^ .]+"; // for generating words from sentence.
    public static String grammar ="edu/stanford/nlp/models/lexparser/englishPCFG.ser.gz";
    public static String[] options = { "-maxLength", "80", "-retainTmpSubcategories" };
    public static LexicalizedParser lp = LexicalizedParser.loadModel(grammar, options);
    
    public static void main(String[] args) {
        // TODO code application logic here
        String paragraph =
                "Line boundary analysis? It determines. Where a text " +
                "string can be broken when line-wrapping. The " +
                "mechanism correctly handles punctuation and " +
                "hyphenated words. Actual line breaking needs to " +
                "also consider the available line width and is " +
                "handled by higher-level software. ";
           generate_sentence(paragraph);
        
        System.out.println("Number of sentences: " + sentences_num);
        for(int i=0;i<myList.size();i++)
        {
            for(int j=0;j<myList.get(i).size();j++)
                System.out.print(myList.get(i).get(j).word+" "+myList.get(i).get(j).pos+ " ");
           System.out.println("\n");
        }
        
    }
    public static void generate_sentence(String para)
    {
        BreakIterator iterator =BreakIterator.getSentenceInstance(Locale.US);

        
        sentences_num = gen_sentence_words(iterator, para);
    }
    public static int gen_sentence_words(BreakIterator bi, String source) {
        int counter = 0;
        String s1="";
        bi.setText(source);
       
        int lastIndex = bi.first();
        while (lastIndex != BreakIterator.DONE) {
            int firstIndex = lastIndex;
            lastIndex = bi.next();
            
            if (lastIndex != BreakIterator.DONE) {
                String sentence = source.substring(firstIndex, lastIndex);
                //String temp_words[]=sentence.split(delims);
                ArrayList<myString> words = new ArrayList<myString>();
                ArrayList<String> tagging=new ArrayList<String>();
                Tree parse = lp.apply(sentence);
                s1=parse.taggedYield().toString();
                s1=s1.replace("[",", ");
                String temp_words2[]=s1.split(", ");
                for(int i=0;i<temp_words2.length;i++)
                {
                    if(temp_words2[i].isEmpty() || (temp_words2[i].charAt(0)>=0 && temp_words2[i].charAt(0)<=64) 
                            || (temp_words2[i].charAt(0)>=91 && temp_words2[i].charAt(0)<=96) ||  temp_words2[i].charAt(0)>=123)
                        continue;
                    String temp2[]=temp_words2[i].split("/");
                    words.add(new myString(temp2[0],temp2[1]));
                }
                myList.add(words);
               // words=myList.get(counter);
                /*System.out.println("\nOn Sentence "+counter);
                for(int i=0;i<words.size();i++)
                {
                    System.out.print(words.get(i)+ " , ");
                }*/
                counter++;
            }
        }
        return counter;
    }

}
