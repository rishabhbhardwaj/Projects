/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wsd;

import edu.smu.tspell.wordnet.NounSynset;
import edu.smu.tspell.wordnet.Synset;
import edu.smu.tspell.wordnet.SynsetType;
import edu.smu.tspell.wordnet.VerbSynset;
import edu.smu.tspell.wordnet.WordNetDatabase;

/**
 *
 * @author Rishabh
 */
public class TestJAWS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.setProperty("wordnet.database.dir", "C:\\WordNet\\2.1\\dict\\");
                char s[] = {'w','a','t','c','h'};
                 //System.out.println(s.toString());
                 String[] wordForms;
                 Synset[] synsets ;
                if (s.length > 0)
		{
			//  Concatenate the command-line arguments
			//StringBuffer buffer = new StringBuffer();
			/*for (int i = 0; i < s.length; i++)
			{
				buffer.append(s[i]);
                        }*/
			String wordForm = "bank";
                        System.out.println(wordForm);
			//  Get the synsets containing the wrod form
			WordNetDatabase database = WordNetDatabase.getFileInstance();
			synsets = database.getSynsets(wordForm);
			//  Display the word forms and definitions for synsets retrieved
			if (synsets.length > 0)
			{
				System.out.println("The following synsets contain '" +
						wordForm + "' or a possible base form " +
						"of that text:");
				for (int i = 0; i < synsets.length; i++)
				{
					wordForms = synsets[i].getWordForms();
					for (int j = 0; j < wordForms.length; j++)
					{
						System.out.print((j > 0 ? ", " : "") +
								wordForms[j]);   
					}
					System.out.println(": " + synsets[i].getDefinition()+"\n");
				}
			
                /*VerbSynset nounSynset; 
                VerbSynset[] hyponyms; 

               
                    try{
                       System.out.println("\nheyyyyyyyyyyy  \n"+synsets.length+"\n");
                    for (int i = 0; i < synsets.length; i++) { 
                        System.out.println("\n"+i+"\n");
                      
                       nounSynset = (VerbSynset)(synsets[i]); 
                       System.out.println("NOUN  "+nounSynset);
                       System.out.println("\n"+i+"\n");
                                hyponyms = nounSynset.getTroponyms(); 
                        System.out.println(nounSynset.getWordForms()[0]);
                        for(int k=0;k<hyponyms.length;k++)
                        {
                            System.out.println(" Hyponyms of index  "+i+" are "+hyponyms[k]);
                        }
                        
                         
                    }
                    }
                    catch(Exception e){}*/
}
        }
        }
}