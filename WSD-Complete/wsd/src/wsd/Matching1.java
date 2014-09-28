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
import edu.stanford.nlp.process.Morphology;
import edu.stanford.nlp.trees.Tree;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.*;
import jcolibri.extensions.textual.wordnet.*;

public class Matching1 {

    /**
     * @param args the command line arguments
     */
    public static WordNetDatabase database;
    
    public static ArrayList<String> tempo=new ArrayList<String>();
    public static ArrayList<ArrayList<myString>> targetArray=new ArrayList<ArrayList<myString>>();
    public static ArrayList<myString> restArray=new ArrayList<myString>();
    public static ArrayList<ArrayList<String>> wordforms2 = new ArrayList<ArrayList<String>>();
    public static ArrayList<Double> senseScore=new ArrayList<Double>();
    public static String TreeRoot;
      public static ArrayList<myString> TreeArray=new ArrayList<myString>();
    public static int depth_limit=2;
    public static String Rootword,pos_target;
    public static String grammar = "edu/stanford/nlp/models/lexparser/englishPCFG.ser.gz";
    public static String[] options = { "-maxLength", "80", "-retainTmpSubcategories" };
    public static LexicalizedParser lp = LexicalizedParser.loadModel(grammar, options);
    public static ArrayList<ArrayList<String>> work=new ArrayList<ArrayList<String>>();
    public static ArrayList<String> tarLines=new ArrayList<String>();
    public static ArrayList<ArrayList<Double>> instanceSense=new ArrayList<ArrayList<Double>>();
    public static ArrayList<String> gloss = new ArrayList<String>(); //For getting meaning and usage example of target word
    public static ArrayList<String> answer_sense = new ArrayList<String>(); //For printing the final sense of each instance
   public static String root;
    
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
        if(depth<0)
            return;
       ArrayList<ArrayList<ArrayList<myString>>> my3d=new ArrayList<ArrayList<ArrayList<myString>>>();//for storing wordforms2 of each element of all
       ArrayList<ArrayList<myString>> temp; 
       for(int i=0;i<all.size();i++)
       {
          // System.out.print(" "+all.get(i).word);
          // System.out.println("");
           //int dist= WordNetBridge.hypernymDistance(TreeRoot, WordNetBridge.POS.NOUN,all.get(i).word, WordNetBridge.POS.NOUN);
           //if(depth>depth_limit-1 || dist<3)
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
       
                                 //Adding all(input) to treeArray
                                 
                                for(myString n1:all)
                                {
                                   // System.out.println("hello I am here");
                                    Synset[] synsets ;
                                    synsets = database.getSynsets(n1.word);
                                    ArrayList<myString> forDef=new ArrayList<myString>();
                                    n1.depth=depth;
                                    TreeArray.add(n1);
                                    if(synsets.length>0){
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
                                    
                                    for(myString ss:forDef)
                                    {
                                        ss.depth=depth;
                                        TreeArray.add(ss);
                                    }
                                    for(myString ss:temp2)
                                    {
                                        ss.depth=depth;
                                        TreeArray.add(ss);
                                    }
                                    }
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
                               
                                makeTree(now,depth-1);
                                return ;
                            }
                    }
            }
       }
       else {
           if(my3d.size()>0){
           for(int j1=0;j1<my3d.get(0).size();j1++)
           {
                                   
                                
            makeTree(my3d.get(0).get(j1),depth-1);
           }
           
       }
      }
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
            // System.out.println("temp2 = " + temp2.length +" "+temp2[0]);
            if(temp2.length==2){
            if(temp2[0].equals(root) ||
                 !temp2[1].equals("TO") && !temp2[1].equals("RB") && !temp2[1].equals("UH") && !temp2[0].equals(";") && !temp2[0].equals(",") && !temp2[1].equals("CC") && !temp2[1].equals(".]") && !temp2[1].equals("IN") &&!temp2[1].equals("DT") && !temp2[1].equals("PRP") && !temp2[1].equals("VBD") && !temp2[1].equals("MD") &&  !temp2[1].equals("VBP"))
            {
                if(!glosswords.contains(temp2[0]))
                {
                    //Morphing here
                    
                    glosswords.add(new myString(temp2[0],temp2[1]));
                }
            }
            }
         }
        return glosswords;
    }
    public static ArrayList<String>  getglossnormal(myString word)// ek normal words k gloss and senses gloss2 array me lena
    {      
        WordNetDatabase database = WordNetDatabase.getFileInstance();
        Synset[] synsets = database.getSynsets(word.word);
        String[] wordForms;
        ArrayList<String> gloss;
        gloss = new ArrayList<String>();
        if (synsets.length > 0)
	{
            if(word.pos.equals("NN") || word.pos.equals("NNS") || word.pos.equals("NNP")
                     || word.pos.equals("NNPS") ){
            try{
                NounSynset nounSynset; 
                NounSynset[] hyponyms = null ; 
               for (int i = 0; i < synsets.length; i++)
               { 
                        nounSynset = (NounSynset)(synsets[i]);
                        hyponyms = nounSynset.getHypernyms();
                        for(int j=0;j<hyponyms.length;j++)
                        gloss.add(hyponyms[j].toString());
               }
            }catch(Exception e){}
            }
            else if(word.pos.equals("VBZ") || word.pos.equals("VBP") || word.pos.equals("VBN")
                    || word.pos.equals("VBG") || word.pos.equals("VBD") || word.pos.equals("VB"))
            {
                try{
                VerbSynset verbSynset; 
                VerbSynset[] hyponyms = null ; 
               for (int i = 0; i < synsets.length; i++)
               { 
                        verbSynset = (VerbSynset)(synsets[i]);
                        hyponyms = verbSynset.getHypernyms();
                        for(int j=0;j<hyponyms.length;j++)
                        gloss.add(hyponyms[j].toString());
               }
            }catch(Exception e){}
            }
            else if(word.pos.equals("JJ") || word.pos.equals("JJR") || word.pos.equals("JJS"))
            {
                try{
                AdjectiveSynset adjSynset; 
                AdjectiveSynset[] hyponyms = null ; 
               for (int i = 0; i < synsets.length; i++)
               { 
                        adjSynset = (AdjectiveSynset)(synsets[i]);
                        hyponyms = adjSynset.getRelated();
                        for(int j=0;j<hyponyms.length;j++)
                        gloss.add(hyponyms[j].toString());
               }
            }catch(Exception e){}
            }
            else if(word.pos.equals("RB") || word.pos.equals("RBR") || word.pos.equals("RBS") || word.pos.equals("WRB"))
            {
                try{
                AdverbSynset advSynset; 
                NounSynset[] hyponyms = null ; 
               for (int i = 0; i < synsets.length; i++)
               { 
                        advSynset = (AdverbSynset)(synsets[i]);
                        hyponyms = advSynset.getUsages();
                        for(int j=0;j<hyponyms.length;j++)
                        gloss.add(hyponyms[j].toString());
               }
            }catch(Exception e){}
            }
        }
            
      
        
        ArrayList<String> gloss1=new ArrayList<String>();
        ArrayList<String> gloss2=new ArrayList<String>();
        for(String s1:gloss)
        {
            String[] temp=s1.split(" - ");
            int l1=temp[0].length();
            int i;
            String s2;
            s2="";
            boolean flag=false;
            for(i=0;i<l1;i++)
            {
                if(temp[0].charAt(i)=='[')
                flag=true;
                else if(temp[0].charAt(i)==']')
                {
                    if(!gloss2.contains(s2))
                    gloss2.add(s2);
                    break;
                }
                else if(flag==true)
                {
                    if(temp[0].charAt(i)==',')
                    {
                        if(!gloss2.contains(s2))
                        gloss2.add(s2);
                        s2="";
                    }
                    else
                    s2+=temp[0].charAt(i);
                }
             }
           }
        return gloss2;
  }
     public static void  getglosstarget(myString word)
     {
           wordforms2.clear();
           int flag_chck=0;
           gloss.clear();
          // System.out.println("In gloss target word.pos = " + word.pos);
           if(word.pos.contains("]"))
           word.pos=word.pos.replaceAll("]","");
           ArrayList<ArrayList<String>> wordforms = new ArrayList<ArrayList<String>>();
           
            //System.setProperty("wordnet.database.dir", "C:\\WordNet-2.1\\dict\\");
            WordNetDatabase database = WordNetDatabase.getFileInstance();
            
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
            //   System.out.println("In getglosstarget NOUN synsets.length "+ synsets.length);
                if(synsets.length<=0)
                    flag_chck=1;
               for (int i = 0; i < synsets.length; i++)
               { 
                       
                        nounSynset = (NounSynset)(synsets[i]);
                        ArrayList<String> gloss2=new ArrayList<String>();
                        hyponyms = nounSynset.getHypernyms();
               //         System.out.println("In getglosstarget hyponyms.length "+ hyponyms.length);
                        for(int j=0;j<hyponyms.length;j++)
                        gloss2.add(hyponyms[j].toString());
                        wordforms.add(i, gloss2);
                        String temp="";
                        for(String ss:nounSynset.getUsageExamples())
                            temp+=" "+ss;
                        gloss.add(nounSynset.toString()+" "+temp);
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
               if(synsets.length<=0)
                    flag_chck=1;
             //  System.out.println("In getglosstarget VERB synsets.length "+ synsets.length);
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
                        String temp="";
                        for(String ss:verbSynset.getUsageExamples())
                            temp+=" "+ss;
                        gloss.add(verbSynset.toString()+" "+temp);
               }
            }catch(Exception e){}
            }
            else if(word.pos.equals("JJ") || word.pos.equals("JJR") || word.pos.equals("JJS") || word.pos.equals("JJ]"))
                 
            {
               // System.out.println("In JJ in getglosstarget");
                try{
                AdjectiveSynset adjSynset; 
                AdjectiveSynset[] hyponyms = null ; 
               
                 Synset[] synsets = database.getSynsets(word.word, SynsetType.ADJECTIVE_SATELLITE);
                if(synsets.length<=0)
                    flag_chck=1; 
                //System.out.println("Rishabh In getglosstarget (JJ) synsets.length = " +synsets.length);
                for (int i = 0; i < synsets.length; i++)
               { 
                   //System.out.println("deepshikha ");
                        adjSynset = (AdjectiveSynset)(synsets[i]);
                        
                       // System.out.println("rishabh 1");
                        ArrayList<String> gloss2=new ArrayList<String>();
                        
                        hyponyms =adjSynset.getRelated();
                        for(int j=0;j<hyponyms.length;j++)
                        gloss2.add(hyponyms[j].toString());
                       // System.out.println("rishabh 2");
                        wordforms.add(i, gloss2);
                        String temp="";
                        for(String ss:adjSynset.getUsageExamples())
                            temp+=" "+ss;
                        gloss.add(adjSynset.toString()+" "+temp);
                  // System.out.println("deepshikha 2");
               }
              // System.out.println("wordforms.size()  = " + wordforms.size()+" "+gloss.size() );
            }catch(Exception e){}
                try{
                AdjectiveSynset adjSynset; 
                AdjectiveSynset[] hyponyms = null ; 
               
                 Synset[] synsets = database.getSynsets(word.word, SynsetType.ADJECTIVE);
                if(synsets.length<=0)
                    flag_chck=1; 
                //System.out.println("Rishabh In getglosstarget (JJ) synsets.length = " +synsets.length);
                for (int i = 0; i < synsets.length; i++)
               { 
                  // System.out.println("deepshikha ");
                        adjSynset = (AdjectiveSynset)(synsets[i]);
                        
                    //    System.out.println("d1");
                        ArrayList<String> gloss2=new ArrayList<String>();
                        
                        hyponyms =adjSynset.getRelated();
                        for(int j=0;j<hyponyms.length;j++)
                        gloss2.add(hyponyms[j].toString());
                     //   System.out.println("d2");
                        wordforms.add(i, gloss2);
                        String temp="";
                        for(String ss:adjSynset.getUsageExamples())
                            temp+=" "+ss;
                        gloss.add(adjSynset.toString()+" "+temp);
                  // System.out.println("deepshikha 2");
               }
               //System.out.println("wordforms.size()  = " + wordforms.size()+" "+gloss.size() );
            }catch(Exception e){}
            }
            else if(word.pos.equals("RB") || word.pos.equals("RBR") || word.pos.equals("RBS") || word.pos.equals("WRB"))
            {
                try{
                    
                AdverbSynset advSynset; 
                NounSynset[] hyponyms = null ; 
                Synset[] synsets = database.getSynsets(word.word,SynsetType.ADVERB);
               if(synsets.length<=0)
                    flag_chck=1;
               // System.out.println("In getglosstarget ADV synsets.length "+ synsets.length);
                for (int i = 0; i < synsets.length; i++)
               { 
                        advSynset = (AdverbSynset)(synsets[i]);
                        ArrayList<String> gloss2=new ArrayList<String>();
                        hyponyms = advSynset.getUsages();
                        for(int j=0;j<hyponyms.length;j++)
                        gloss2.add(hyponyms[j].toString());
                        wordforms.add(i, gloss2);String temp="";
                        for(String ss:advSynset.getUsageExamples())
                            temp+=" "+ss;
                        gloss.add(advSynset.toString()+" "+temp);
               }
            }catch(Exception e){}
            }
            else 
            {
               // System.out.println("NOT MATCH");
                try{
                NounSynset nounSynset; 
                NounSynset[] hyponyms = null ; 
                Synset[] synsets = database.getSynsets(word.word,SynsetType.NOUN);
             if(synsets.length<=0)
                    flag_chck=1;
                  // System.out.println("In getglosstarget EXTRA NOUN synsets.length "+ synsets.length);
                
               for (int i = 0; i < synsets.length; i++)
               { 
                       
                        nounSynset = (NounSynset)(synsets[i]);
                        ArrayList<String> gloss2=new ArrayList<String>();
                        hyponyms = nounSynset.getHypernyms();
               //         System.out.println("In getglosstarget hyponyms.length "+ hyponyms.length);
                        for(int j=0;j<hyponyms.length;j++)
                        gloss2.add(hyponyms[j].toString());
                        wordforms.add(i, gloss2);
                        String temp="";
                        for(String ss:nounSynset.getUsageExamples())
                            temp+=" "+ss;
                        gloss.add(nounSynset.toString()+" "+temp);
               }
            }catch(Exception e){}
            }
            if(flag_chck==1)
            {
                //System.out.println("In flag chck");
                try{
                NounSynset nounSynset; 
                NounSynset[] hyponyms = null ; 
                Synset[] synsets = database.getSynsets(word.word,SynsetType.NOUN);
                  //  if(synsets.length<=0)
                 // System.out.println("In getglosstarget EXTRA N "+ synsets.length);
                
               for (int i = 0; i < synsets.length; i++)
               { 
                       
                        nounSynset = (NounSynset)(synsets[i]);
                        ArrayList<String> gloss2=new ArrayList<String>();
                        hyponyms = nounSynset.getHypernyms();
                        for(int j=0;j<hyponyms.length;j++)
                        gloss2.add(hyponyms[j].toString());
                        wordforms.add(i, gloss2);
                        String temp="";
                        for(String ss:nounSynset.getUsageExamples())
                            temp+=" "+ss;
                        gloss.add(nounSynset.toString()+" "+temp);
               }
            }catch(Exception e){}
                try{
                VerbSynset nounSynset; 
                VerbSynset[] hyponyms = null ; 
                Synset[] synsets = database.getSynsets(word.word,SynsetType.VERB);
                
                //    if(synsets.length<=0)
                //  System.out.println("In getglosstarget EXTRA "+ synsets.length);
                
               for (int i = 0; i < synsets.length; i++)
               { 
                       
                        nounSynset = (VerbSynset)(synsets[i]);
                        ArrayList<String> gloss2=new ArrayList<String>();
                        hyponyms = nounSynset.getHypernyms();
                        for(int j=0;j<hyponyms.length;j++)
                        gloss2.add(hyponyms[j].toString());
                        wordforms.add(i, gloss2);
                        String temp="";
                        for(String ss:nounSynset.getUsageExamples())
                            temp+=" "+ss;
                        gloss.add(nounSynset.toString()+" "+temp);
               }
            }catch(Exception e){}
            }
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
                            ArrayList<String> finalgloss2 = new ArrayList<String>(); 
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
                                        finalgloss2.add(s2);
                                        break;
                                    }
                                    else if(flag==true)
                                    {
                                        if(temp[0].charAt(j1)==',')
                                        {
                                            if(!finalgloss2.contains(s2))
                                            finalgloss2.add(s2);
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
            /* System.out.println("priting wordforms 2");
               for(int i=0;i<wordforms2.size();i++)
               {
                   
                   for(int j=0;j<wordforms2.get(i).size();j++)
                   {
                       System.out.print(wordforms2.get(i).get(j)+" ");
                   }
                    System.out.println("");
               }
               */ 
             
      }
    
    //        return wordforms2;

   
    public static boolean isPresent(String word)
    {
        ArrayList<String> chk=new ArrayList<String>();
        chk.add("unit");chk.add("objects");chk.add("things");chk.add("other");chk.add("such");
        chk.add("that");chk.add("which");chk.add("entity");chk.add("object");chk.add("there");
        chk.add("entities");chk.add("used");chk.add("thing");chk.add("been");chk.add("taken");
        chk.add("their");chk.add("number");chk.add("your");
        if(chk.contains(word))
            return true;
        else
            return false;
    }
    public static void MakeSearchArray(String target,int k)
    {
        
       
        Rootword=target;
     //   System.out.println("" +Rootword);
        String l;
        for(int i=0;i<work.size();i++)
        {
            //Get Result for ith instance of target word
            // MakeTarget Array for this instance
            String curLine=tarLines.get(i);
            ArrayList<myString> tempfortar=new ArrayList<myString>();
            tempfortar=makeglosswords(curLine);
            for(myString mm:tempfortar)
            {
                if(mm.word.equals(target))
                {
                    pos_target=mm.pos;
                    
                }
               // System.out.println(mm.word);
            }
            targetArray.clear();
            //System.out.println(" In makesearch array target = " + target);
            maketargetArray(target,pos_target);
            TreeArray.clear();
            tempo.clear();
            for(int j=0;j<work.get(i).size();j++)
            {
               // System.out.println("Line going in "+ work.get(i).get(j));
               
                ArrayList<myString> my1=makeglosswords(work.get(i).get(j));
               /*System.out.println("temp Input to Aord \n");
            for(int ii=0;ii<my1.size();ii++)
            {
                System.out.println(my1.get(ii));
            }*/
           // System.out.println("\n\n");
               
                for(int p=0;p<my1.size();p++)
                {
                    Rootword=my1.get(p).word;
                    if(!my1.get(p).word.equals(target) && my1.get(p).word.length()>2) 
                    {
            //            System.out.println("my1.get(p) = " + my1.get(p).word);
                        ArrayList<myString> s1=new ArrayList<myString>();
                        s1.add(my1.get(p));
                        makeTree(s1,depth_limit-2);
                        s1.clear();
                    }
                     
                  /*  System.out.println("\nPriting part of Rest Array when building TreeArray for -> "+ Rootword);
                    for(myString ss:TreeArray)
                        System.out.println("ss = " + ss.word);
                   */ 
                }
            }
            //TreeArray for ith instance is made now
           /* System.out.println("tree Array");
            for(int iii=0;iii<TreeArray.size();iii++)
            {
                 System.out.println("iii = " + TreeArray.get(iii).word);
            }
            System.out.println("\n\n");*/
       //     System.out.println("SIZE "+TreeArray.size());
            restArray=(ArrayList<myString>) TreeArray.clone();
            TreeArray.clear();
            tempo.clear();
            double si=0.0;
            ArrayList<String> tmplis=new ArrayList<String>();
            ArrayList<myString> restArrayWithoutDup=new ArrayList<myString>();
           
            for(int r1=0;r1<restArray.size();r1++)
            {
                //if(!tmplis.contains(restArray.get(r1).word))
                
                 {
                    tmplis.add(restArray.get(r1).word);
                    restArrayWithoutDup.add(restArray.get(r1));
                }
                
            }
            
           /* System.out.println("Printing RestArray");
            for(int ri=0;ri<restArrayWithoutDup.size();ri++)
            {
                System.out.println(restArrayWithoutDup.get(ri).word);
            }
            */
            /*
            * 
            * RestArray Working Fine
            */
           ArrayList<ArrayList<myString>> targetArrayWithoutDup=new  ArrayList<ArrayList<myString>>();
           for(int r1=0;r1<targetArray.size();r1++)
           {
               ArrayList<String> tmplist=new ArrayList<String>();
               ArrayList<myString> tmplist2=new ArrayList<myString>();
               for(int r2=0;r2<targetArray.get(r1).size();r2++)
               {
                   if(!tmplist.contains(targetArray.get(r1).get(r2).word))
                   {
                       tmplist.add(targetArray.get(r1).get(r2).word);
                       tmplist2.add(targetArray.get(r1).get(r2));
                   }
               }
               targetArrayWithoutDup.add(tmplist2);
           }
           /* System.out.println("\n\n Printing targetArrayWithoutDup\n");
            for(int r1=0;r1<targetArrayWithoutDup.size();r1++)
            {
                System.out.println("\nPrinting target array for sense\n");
                for(int r2=0;r2<targetArrayWithoutDup.get(r1).size();r2++)
                {
                    System.out.println(targetArrayWithoutDup.get(r1).get(r2).word);
                }
            }
         */
      
           // System.out.println("----------- Priting Matching words ------------------");
           senseScore.clear();
            for(int i2=0;i2<targetArrayWithoutDup.size();i2++)
            {
                //At i2th sense
                //System.out.println("For sense "+ i2 );   
                si=0.0;
                int cnt=0;
                for(int j2=0;j2<targetArrayWithoutDup.get(i2).size();j2++)
                {
                    for(int k2=0;k2<restArrayWithoutDup.size();k2++)
                    {
                        String sa=restArrayWithoutDup.get(k2).word;
                        if(!sa.equals("-LRB-") && !sa.equals("-RRB-") && sa.length()>3 &&
                            isPresent(sa)==false &&
                            sa.equals(targetArrayWithoutDup.get(i2).get(j2).word))
                        {
                            int d1=depth_limit-restArrayWithoutDup.get(k2).depth;
                            int d2=depth_limit-targetArrayWithoutDup.get(i2).get(j2).depth;
                         //  System.out.println(sa +" "+targetArrayWithoutDup.get(i2).get(j2).word);
                            si=si+weight(restArrayWithoutDup.get(k2).depth,targetArrayWithoutDup.get(i2).get(j2).depth);
                           // si=si+(1.0/(double)(1+Math.abs(d1-d2)))*(1.0/(double)1+Math.min(d1,d2));
                            cnt++;
                        }
                    }
                }
                //System.out.print(si+"  ");
                senseScore.add(i2,(double)si);
               // System.out.println("");
            }
            double max_val=0.0;
            int max_ind=0;
            for(int mi=0;mi<senseScore.size();mi++)
            {
                if(senseScore.get(mi)>max_val)
                {
                    max_ind=mi;
                    max_val=senseScore.get(mi);
                }
            }
          // System.out.println("max_ind = " + max_ind+" size of gloss "+gloss.size());
            answer_sense.add(gloss.get(max_ind));
            TreeArray.clear();
            tempo.clear();
            instanceSense.add(i,senseScore);
        }
    }
    
   
    public static double weight(int depth1,int depth2)
    {
       // System.out.println("depths" + " "+depth1+ " "+depth2);
        
        if(depth1>5 || depth2>5)
            return 0.0;
        double ans=0.0;
        double ar[][]={
                        {1.0,0.9,0.8,0.7,0.6,0.5},
                        {0.9,0.8,0.7,0.6,0.5,0.4},
                        {0.8,0.7,0.6,0.5,0.4,0.3},
                        {0.7,0.6,0.5,0.4,0.3,0.2},
                        {0.6,0.5,0.4,0.3,0.2,0.1},
                        {0.5,0.4,0.3,0.2,0.1,0.05},
                       };
        ans=ar[depth1][depth2];        
        return ans;
    }
    public static void maketargetArray(String target,String cur_pos)
    {
        //System.out.println("In maketargetArray() with = " + target +" "+cur_pos);
        
        getglosstarget(new myString(target,cur_pos));
        Rootword=target;
       /* System.out.println("Printing WordForms in maketargetarray()");
        for(int i=0;i<wordforms2.size();i++)
        {
            for(int j=0;j<wordforms2.get(i).size();j++)
            {
                System.out.println(wordforms2.get(i).get(j));
            }
        }*/
       // System.out.println("In make Target Array wordforms2.size() = " + wordforms2.size());
        for(int i=0;i<wordforms2.size();i++)
        {
           TreeArray.clear();
            tempo.clear();
            ArrayList<myString> s1=new ArrayList<myString>();
            for(int j=0;j<wordforms2.get(i).size();j++)
            {
                Rootword=wordforms2.get(i).get(j);
                
               // System.out.println("rootWord in maketargetarray() = " + Rootword);
               
                
                s1.add(new myString(wordforms2.get(i).get(j),cur_pos));
                
                //makeTree(wordforms2.get(i).get(j),0);
            }
            makeTree(s1,depth_limit);
            /*System.out.println("Tree in maketaregetword");
            for(myString s2:TreeArray)
               {
                   System.out.println(s2.word);
               }
            System.out.println("");
            */
          
           // System.out.println("Priting glosswords in maketargetarray");
            ArrayList<myString> list=new ArrayList<myString>();
            list=(ArrayList<myString>) TreeArray.clone();
             ArrayList<myString> tem=makeglosswords(gloss.get(i));
            for(myString ss:tem)
            {
             //  System.out.println("ss = " + ss.word);
               if(ss.word.contains(","))
               {
                   String ar[]=ss.word.split(",");
                   for(String ss2:ar)
                   {
                       ss2=ss2.replace("]","");
                     //  System.out.println("  ss2 "+ss2);
                       list.add(new myString(ss2,ss.pos));
                   }
                   
               }
               else
                list.add(ss);
            }
          //  System.out.println("");
            targetArray.add(list);
        }
        /*System.out.println("Target Array in makeTargetArray()");
        for(int r1=0;r1<targetArray.size();r1++)
            {
                for(int r2=0;r2<targetArray.get(r1).size();r2++)
                {
                    System.out.println(targetArray.get(r1).get(r2));
                }
            }
            */ 
        wordforms2.clear();
        //System.out.println("\n");
        /*for(int i=0;i<targetArray.size();i++)
        {
         
            for(int j=0;j<targetArray.get(i).size();j++)
            {
                System.out.println(targetArray.get(i).get(j).word);
            }
            System.out.println("");
            //targetArray.add(i,TreeArray);
        }*/
        
       
    }
    public ArrayList<String> getSense(String target,String filename)
    {
        System.setProperty("wordnet.database.dir", "C:\\WordNet\\2.1\\dict\\");
         database = WordNetDatabase.getFileInstance();
        TreeArray.clear();
        targetArray.clear();
        gloss.clear();
        work.clear();
        senseScore.clear();
        wordforms2.clear();
        tempo.clear();
       
        tarLines.clear();
        restArray.clear();
        instanceSense.clear();
        answer_sense.clear();
        root=target;
        TreeRoot=target;
        int k=2;
        try {
        Init ob1=new Init(target,filename);
        ob1.getParagraphs();
        ob1.getLines();
        work=ob1.getWork(target,k);
         tarLines=ob1.getTargetLines();
       /* for(int ii=0;ii<tarLines.size();ii++)
           System.out.println("tarLine = " + tarLines.get(ii));*/
        }catch(Exception e){}
      //  maketargetArray(target);
        
        MakeSearchArray(target,k);
        
        for(int i=0;i<work.size();i++)
            work.get(i).clear();
        tarLines.clear();
        
        
        return answer_sense;
    }
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        //WordNetBridge.init();
       // getglosstarget("technique");
        /*String target="sale";
        root=target;
        TreeRoot=target;
        int k=2;
        try {
        Init ob1=new Init(target,"C:\\Users\\Rishabh\\Desktop\\t2.txt");
        ob1.getParagraphs();
        ob1.getLines();
        work=ob1.getWork(target,k);
         tarLines=ob1.getTargetLines();
       // for(int ii=0;ii<tarLines.size();ii++)
         //   System.out.println("tarLine = " + tarLines.get(ii));
        }catch(Exception e){}
      //  maketargetArray(target);
        
        MakeSearchArray(target,k);
       */
         Matching1 ob1=new Matching1();
         String tar="booked";
         String file="C:\\Users\\Rishabh\\Desktop\\t1.txt";
       ArrayList<String> ansss=ob1.getSense(tar,file);
       for(String sss:ansss)
       {
       
           System.out.println(sss);
       }
       
        
        
       
       // System.out.println(targetArray.size());
        
         
       // int dist= WordNetBridge.hypernymDistance("debt", WordNetBridge.POS.NOUN,"interest", WordNetBridge.POS.NOUN);
       // System.out.println("dist = " + dist);
        /*TreeRoot="court game";
        Rootword="serves";
               makeTree(Rootword,0);
               System.out.println("hello");
               for(myString s1:TreeArray)
               {
                   System.out.println("s1 = " + s1.word);
               }*/
               
      /*  ArrayList<String> my1=makeglosswords("Lines can be outdented to signify the start of new paragraphs");
        for(int i=0;i<my1.size();i++)
        {
            System.out.println(my1.get(i));
        }*/
       /* for(int i=0;i<restArray.size();i++)
        {
            System.out.println(restArray.get(i).word);
        }
        System.out.println("\n\n");
        System.out.println(senseScore.size());
        */
        /*for(int i=0;i<instanceSense.size();i++)
        {
            System.out.println("for Instance "+ i);
            for(int j=0;j<instanceSense.get(i).size();j++)
            {
                System.out.print(instanceSense.get(i).get(j)+" ");
            }
            System.out.println("");
        }
        System.out.println("");
        //for(int i=0;i<gloss.size();i++)
        //System.out.println("chck "+gloss.get(i));
        for(String ans:answer_sense)
            System.out.println("ans = " + ans);
        System.out.println("");
        */
        }
}

