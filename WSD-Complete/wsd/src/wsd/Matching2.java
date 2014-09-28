/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wsd;

/**
 *
 * @author Rishabh
 */
import edu.smu.tspell.wordnet.AdjectiveSynset;
import edu.smu.tspell.wordnet.AdverbSynset;
import edu.smu.tspell.wordnet.NounSynset;
import edu.smu.tspell.wordnet.Synset;
import edu.smu.tspell.wordnet.SynsetType;
import edu.smu.tspell.wordnet.VerbSynset;
import edu.smu.tspell.wordnet.WordNetDatabase;
import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import edu.stanford.nlp.trees.Tree;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import jcolibri.extensions.textual.wordnet.*;

public class Matching2 {

    /**
     * @param args the command line arguments
     */
    public static WordNetDatabase database;
    public static ArrayList<myString> TreeArray=new ArrayList<myString>();
    public static ArrayList<String> tempo=new ArrayList<String>();
    public static ArrayList<ArrayList<myString>> targetArray=new ArrayList<ArrayList<myString>>();
    public static ArrayList<myString> restArray=new ArrayList<myString>();
   
    public static ArrayList<Double> senseScore=new ArrayList<Double>();
    public static String TreeRoot;
    public static int depth_limit=3;
    public static String Rootword,pos_target;
    public static String grammar = "edu/stanford/nlp/models/lexparser/englishPCFG.ser.gz";
    public static String[] options = { "-maxLength", "80", "-retainTmpSubcategories" };
    public static LexicalizedParser lp = LexicalizedParser.loadModel(grammar, options);
    public static ArrayList<ArrayList<String>> work=new ArrayList<ArrayList<String>>();
    public static ArrayList<String> tarLines;
    public static ArrayList<ArrayList<Double>> instanceSense=new ArrayList<ArrayList<Double>>();
    //For getting meaning and usage example of target word
    public static ArrayList<String> answer_sense = new ArrayList<String>(); //For printing the final sense of each instance
    
    
    public static boolean check(ArrayList<myString> m1,ArrayList<myString> m2)
    {
        /*System.out.println("\n\n");
        System.out.println("Printing m1");
        for(myString ss: m1)
            System.out.print(" "+ss);
        System.out.println("");
        System.out.println("Printing m2");
        for(myString ss: m2)
            System.out.print(" "+ss);
        System.out.println("");*/
        if(m1.size()!=m2.size())
            return false;
        else
        {
            boolean ok=true;
            for(int i=0;i<m1.size();i++)
            {
                if(!m1.get(i).word.equals(m2.get(i).word))
                {
                    ok=false;
                    break;
                }
            }
            /*if(ok==true)
            System.out.println("Returning True");
            
            */ 
            return ok;
        }
    }
    public static int computeSimilar(ArrayList<ArrayList<myString>> a1,ArrayList<ArrayList<myString>> a2 )
    {
        
       // System.out.println("In compute "+a1.size()+"  "+a2.size());
        for(int i=0;i<a1.size();i++)
        {
            for(int j=0;j<a2.size();j++)
            {
                if(check((a1.get(i)),a2.get(j))==true)
                {
                    //System.out.println("abcd\n");
                    return i;
                }
            }
        }
        return -1;
    }
   // public static int count=0;
    public static void makeTree(ArrayList<myString> all,int depth)
    {
       // System.out.println("Call of makeTree in Matching2");
        //System.out.println("\ndepth = " + depth +" count "+count++);
        if(depth<=0)
            return;
       ArrayList<ArrayList<ArrayList<myString>>> my3d=new ArrayList<ArrayList<ArrayList<myString>>>();//for storing wordforms2 of each element of all
       ArrayList<ArrayList<myString>> temp; 
       for(int i=0;i<all.size();i++)
       {
          // System.out.print(" "+all.get(i).word);
          // System.out.println("");
           temp=getglosstargetforMakeTree(all.get(i));
           my3d.add(temp);
       }
      /*  System.out.println("\n\n");
      for(int i=0;i<my3d.size();i++)
      {
          System.out.println("My3d "+ i);
          for(int j=0;j<my3d.get(i).size();j++)
          {
              for(int k=0;k<my3d.get(i).get(j).size();k++)
              {
                  System.out.print(my3d.get(i).get(j).get(k).word+ " ");
              }
              System.out.println("");
          }
      }
      */ 
                                  //ArrayList<myString> now=my3d.get(j1).get(flag);
                                for(myString n1:all)
                                {
                                   // System.out.println("hello I am here");
                                    Synset[] synsets ;
                                    synsets = database.getSynsets(n1.word);
                                    ArrayList<myString> forDef=new ArrayList<myString>();
                                    forDef=makeglosswords(synsets[0].getDefinition());
                                    ArrayList<myString> temp2=new ArrayList<myString>();
                                    String[] maketemp;
                                    
                                    String mytemp="";
                                    maketemp=synsets[0].getUsageExamples();
                                    for(String ss:maketemp)
                                        mytemp+=ss+" ";
                                    mytemp=mytemp.replaceAll("\"","");
                                    if(mytemp.length()>0)
                                    temp2=makeglosswords(mytemp);
                                    TreeArray.add(n1);
                                }
         
       if(my3d.size()>1){
         //  System.out.println(my3d.size());
            for(int j1=0;j1<my3d.size()-1;j1++)
            {
                   for(int j2=j1+1;j2<my3d.size();j2++)
                    {
                     //   System.out.println("2d loop in makeTree ");
                      //  System.out.println(my3d.get(j1).size()+" "+my3d.get(j2).size());
                            int flag=computeSimilar(my3d.get(j1),my3d.get(j2));
                            //System.out.println("flag = " + flag + " first index = " + j1 + "second index "+j2);
                            if(flag!=-1)
                            {
                                ArrayList<myString> now=my3d.get(j1).get(flag);
                                   /* for(myString ss:forDef)
                                    {
                                        TreeArray.add(ss);
                                    }
                                    for(myString ss:temp2)
                                    {
                                        TreeArray.add(ss);
                                    }*/
                                
                                makeTree(now,depth-1);
                                return ;
                            }
                    }
            }
       }
       else {
           for(int j1=0;j1<my3d.get(0).size();j1++)
           {
                                    
                                  /*  for(myString ss:forDef)
                                    {
                                        TreeArray.add(ss);
                                    }
                                    for(myString ss:temp2)
                                    {
                                        TreeArray.add(ss);
                                    }
                                  }*/
           makeTree(my3d.get(0).get(j1),depth-1);
       }
        
        
        
    }
 }
    public static ArrayList<myString>  makeglosswords(String gloss)//gloss se usefull words lena (eg verb,noun) an,a,the hatana
    {
        ArrayList<myString> glosswords=new ArrayList<myString>();
        Tree parse = lp.apply(gloss);
        String s=parse.taggedYield().toString();
        s=s.replace("[",", ");
        String[] tempp=s.split(", ");
        for(String s1:tempp)
         {
             if(s1.isEmpty())
                 continue;
            String[] temp2=s1.split("/");
            if(!temp2[1].equals("TO") && !temp2[1].equals("RB") && !temp2[1].equals("UH") && !temp2[0].equals(";") && !temp2[0].equals(",") && !temp2[1].equals("CC") && !temp2[1].equals(".]") && !temp2[1].equals("IN") &&!temp2[1].equals("DT") && !temp2[1].equals("PRP") && !temp2[1].equals("VBD") && !temp2[1].equals("MD") &&  !temp2[1].equals("VBP"))
            {
                if(!glosswords.contains(temp2[0]))
                {
                    //Morphing here
                    
                    glosswords.add(new myString(temp2[0],temp2[1]));
                }
            }
         }
        return glosswords;
    }
     public static ArrayList<ArrayList<myString>>  getglosstargetforMakeTree(myString word)
     {
            ArrayList<ArrayList<myString>> wordforms2 = new ArrayList<ArrayList<myString>>();
            ArrayList<myString> gloss = new ArrayList<myString>();
           //gloss.clear();
           word.pos=word.pos.replaceAll("]","");
          // System.out.println("word " +word.word+"  -> pos "+word.pos);
           ArrayList<ArrayList<String>> wordforms = new ArrayList<ArrayList<String>>();
           
            //System.setProperty("wordnet.database.dir", "C:\\WordNet-2.1\\dict\\");
   //         WordNetDatabase database = WordNetDatabase.getFileInstance();
            
           // Synset[] synsets = database.getSynsets(word.word);
            //System.out.println("In getglosstarget synsets.length = " + synsets.length);
           // System.out.println("In getglosstarget word.pos="+word.pos+" "+word.pos.length());
            
            //if (synsets.length > 0)
	
            if(word.pos.equals("NN") || word.pos.equals("NNS") || word.pos.equals("NNP")
                     || word.pos.equals("NNPS") ){
            try{
                NounSynset nounSynset; 
                NounSynset[] hyponyms = null ; 
                Synset[] synsets = database.getSynsets(word.word,SynsetType.NOUN);
               // System.out.println("In getglosstarget synsets.length "+ synsets.length);
                
               for (int i = 0; i < synsets.length; i++)
               { 
                       
                        nounSynset = (NounSynset)(synsets[i]);
                        ArrayList<String> gloss2=new ArrayList<String>();
                        hyponyms = nounSynset.getHypernyms();
                       // System.out.println("In getglosstarget hyponyms.length "+ hyponyms.length);
                        for(int j=0;j<hyponyms.length;j++)
                        gloss2.add(hyponyms[j].toString());
                        wordforms.add(i, gloss2);
                        
                        gloss.add(new myString(nounSynset.toString(),word.pos));
               }
            }catch(Exception e){}
            }
            else if(word.pos.equals("VBZ") || word.pos.equals("VBP") || word.pos.equals("VBN")
                    || word.pos.equals("VBG") || word.pos.equals("VBD") || word.pos.equals("VB"))
            {
                //System.out.println("In verbset in getglosstarget");
                try{
                VerbSynset verbSynset; 
                VerbSynset[] hyponyms = null ; 
               Synset[] synsets = database.getSynsets(word.word,SynsetType.VERB);
                for (int i = 0; i < synsets.length; i++)
               { 
                  // System.out.println("Rishabh 1 ");
                        verbSynset =(VerbSynset) (synsets[i]);
                    //    System.out.println("Rishabh 2 ");
                        ArrayList<String> gloss2=new ArrayList<String>();
                        
                        hyponyms = verbSynset.getHypernyms();
                      //  System.out.println("hyponyms.length = " + hyponyms.length);
                        for(int j=0;j<hyponyms.length;j++)
                        gloss2.add(hyponyms[j].toString());
                        wordforms.add(i, gloss2);
                        gloss.add(new myString(verbSynset.toString(),word.pos));
               }
            }catch(Exception e){}
            }
            else if(word.pos.equals("JJ") || word.pos.equals("JJR") || word.pos.equals("JJS") || word.pos.equals("JJ]"))
                 
            {
              //  System.out.println("In JJ in getglosstarget");
                try{
                AdjectiveSynset adjSynset; 
                AdjectiveSynset[] hyponyms = null ; 
                Synset[] synsets = database.getSynsets(word.word,SynsetType.ADJECTIVE);
                    //System.out.println("In getglosstarget (JJ) synsets.length = " +synsets.length);
                for (int i = 0; i < synsets.length; i++)
               { 
                        adjSynset = (AdjectiveSynset)(synsets[i]);
                        ArrayList<String> gloss2=new ArrayList<String>();
                        hyponyms = adjSynset.getRelated();
                        for(int j=0;j<hyponyms.length;j++)
                        gloss2.add(hyponyms[j].toString());
                        wordforms.add(i, gloss2);
                        
                        gloss.add(new myString(adjSynset.toString(),word.pos));
               }
            }catch(Exception e){}
            }
            else if(word.pos.equals("RB") || word.pos.equals("RBR") || word.pos.equals("RBS") || word.pos.equals("WRB"))
            {
                try{
                AdverbSynset advSynset; 
                NounSynset[] hyponyms = null ; 
                Synset[] synsets = database.getSynsets(word.word,SynsetType.ADVERB);
               for (int i = 0; i < synsets.length; i++)
               { 
                        advSynset = (AdverbSynset)(synsets[i]);
                        ArrayList<String> gloss2=new ArrayList<String>();
                        hyponyms = advSynset.getUsages();
                        for(int j=0;j<hyponyms.length;j++)
                        gloss2.add(hyponyms[j].toString());
                        wordforms.add(i, gloss2);
                        gloss.add(new myString(advSynset.toString(),word.pos));
               }
            }catch(Exception e){}
            }
            else
            {
                try{
                NounSynset nounSynset; 
                NounSynset[] hyponyms = null ; 
                Synset[] synsets = database.getSynsets(word.word,SynsetType.NOUN);
               
                for (int i = 0; i < synsets.length; i++)
               { 
                        nounSynset = (NounSynset)(synsets[i]);
                        ArrayList<String> gloss2=new ArrayList<String>();
                        hyponyms = nounSynset.getUsages();
                        for(int j=0;j<hyponyms.length;j++)
                        gloss2.add(hyponyms[j].toString());
                        wordforms.add(i, gloss2);
                        gloss.add(new myString(nounSynset.toString(),word.pos));
               }
                }catch(Exception e){}
            }
          //  System.out.println("NOT MATCH");
                /*for(int i=0;i<wordforms.size();i++)
                    {
                            for(int j=0;j<wordforms.get(i).size();j++)
                            {
                                System.out.println(wordforms.get(i).get(j));
                            }
                    }*/
                
                      //System.out.println("gloss = ");
                      //System.out.println(wordforms.size());
                      for(int i=0;i<wordforms.size();i++)
                      {
                            ArrayList<myString> finalgloss2 = new ArrayList<myString>(); 
                            for(int j=0;j<wordforms.get(i).size();j++)
                            {
                                String s=wordforms.get(i).get(j);
                                String[] temp=s.split(" - ");
                                /*finalgloss2=makeglosswords(temp[1]);
                                for(String s2:finalgloss2)
                                {
                                    if(!finalgloss2.contains(s2))
                                    finalgloss2.add(s2);
                                }*/
                                int l1=temp[0].length();
                                String s2;
                                s2="";
                                boolean flag=false;
                                for(int j1=0;j1<l1;j1++)
                                {
                                    if(temp[0].charAt(j1)=='[')
                                    flag=true;
                                    else if(temp[0].charAt(j1)==']')
                                    {
                                        if(!finalgloss2.contains(s2))
                                        finalgloss2.add(new myString(s2,word.pos));
                                        break;
                                    }
                                    else if(flag==true)
                                    {
                                        if(temp[0].charAt(j1)==',')
                                        {
                                            if(!finalgloss2.contains(s2))
                                            finalgloss2.add(new myString(s2,word.pos));
                                            s2="";
                                        }
                                        else
                                        s2+=temp[0].charAt(j1);
                                    }
                                }
                              /*  for(String s3:finalgloss2)
                                {
                                    System.out.println(s3);
                                }*/
                          }
                   wordforms2.add(i, finalgloss2);
                      }
             /*System.out.println("Priting wordforms for = " +word.word);     
               for(int i=0;i<wordforms2.size();i++)
               {
                   
                   for(int j=0;j<wordforms2.get(i).size();j++)
                   {
                       System.out.print(wordforms2.get(i).get(j).word+" ");
                   }
                    System.out.println("");
               }*/
            
     
    
            return wordforms2;
     }
   
    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.setProperty("wordnet.database.dir", "C:\\WordNet\\2.1\\dict\\");
         database = WordNetDatabase.getFileInstance();
        //WordNetBridge.init();
       // getglosstarget("technique");
        String target="bank";
        int d=3;
        ArrayList<myString> res=new ArrayList<myString>();
        res.add(new myString("financial institution","NN"));
        res.add(new myString("financial organization","NN"));
        res.add(new myString("financial organisation","NN"));
        makeTree(res,d);
        for(myString n2:TreeArray)
        {
            System.out.println("n2 = " + n2.word);
        }
       
                
}
}

