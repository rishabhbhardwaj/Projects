/*
This Class contains the list of all the english lang graphemes(99) and their corresponding phonemes. 
GraphemetoPhoneme (contructor) maintains a 2-D vector which contains number of phonems corresponding o each index.
The index number represent the grapheme which will be derived from corresponding grapheme array.
 */
package miniproject;
import java.util.*;
public class GraphemetoPhoneme {
    
    Vector< Vector<String> > G2P;
     Vector< Vector<String> > phone; //all combinations of a grapheme set (each vector for one set)
   int k=0;
   Vector<String> input_grapheme;
   
   Vector<String> phonemesOFinput;
   //Size of grapheme 99
   String grapheme[]
  ={"augh","eigh","our","igh","ere","eer","ear","are","all","air","tch",
                "bb","cc","ch","ck","dd","dg","ff","gg","gh","gn","gu","kn","ll","le",
                "mm","mb","mn","nn","ng","pp","ph","qu","rr","rh","ss","sc","se","sh",
                "tt","th","wh","wr","ye","zz","ae","ai","al","ar","au","aw","ay","ea",
                "ed","ee","ei","er","eu","ew","ey","ie","ir","oa","oe", 
                "oi","oo","or","ou","ow","oy","ue","ui","ur","uy","iz","b","c","d","f", 
  "g","h","j","k","l","m","n","p","r","s","t","v","w","x","y","z","a","e","i","o","u"};
   
    GraphemetoPhoneme()
    {
        G2P=new Vector<>(104);
        Vector<String> v1;
      //  System.out.println("Size of grapheme:"+ grapheme.length);
        v1=new Vector();
        v1.add("");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("ai");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("or");v1.add("ow");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("igh");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("ear");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("ear");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("ear");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("air");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("al");v1.add("orl");v1.add("or");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("air");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("ch");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("b");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("k");v1.add("ks");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("ch");
        G2P.add(k,v1);
        k++;
         v1=new Vector();
        v1.add("k");
        G2P.add(k,v1);
        k++;
         v1=new Vector();
        v1.add("d");
        G2P.add(k,v1);
        k++;
         v1=new Vector();
        v1.add("j");
        G2P.add(k,v1);
        k++;
         v1=new Vector();
        v1.add("f");
        G2P.add(k,v1);
        k++;
         v1=new Vector();
        v1.add("g");v1.add("j");
        G2P.add(k,v1);
        k++;
         v1=new Vector();
        v1.add("g");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("n");
        G2P.add(k,v1);
        k++;
         v1=new Vector();
        v1.add("g");
        G2P.add(k,v1);
        k++;
         v1=new Vector();
        v1.add("n");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("l");
        G2P.add(k,v1);
        k++;
         v1=new Vector();
        v1.add("l");
        G2P.add(k,v1);
        k++;
        v1.add("m");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("m");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("m");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("n");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("ng");v1.add("nj");
        G2P.add(k,v1);
        k++;
        v1.add("p");
        G2P.add(k,v1);
        k++;
         v1=new Vector();
        v1.add("f");
        G2P.add(k,v1);
        k++;
         v1=new Vector();
        v1.add("kw");v1.add("k");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("r");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("r");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("s");v1.add("sh");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("s");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("s");v1.add("z");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("sh");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("t");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("th");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("w");v1.add("hw");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("r");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("z");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("ai");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("ai");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("al");v1.add("orl");v1.add("or");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("ar");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("or");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("or");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("ai");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("ee");v1.add("e");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("d");v1.add("t");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("ee");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("ee");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("ur");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("yoo");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("yoo");v1.add("oo");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("i");v1.add("ee");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("igh");v1.add("ee");v1.add("i");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("ur");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("oa");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("oa");
        G2P.add(k,v1);
        k++;
        
        v1=new Vector();
        v1.add("oi");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("oo");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("or");v1.add("ur");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("ow");v1.add("oo");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("ow");v1.add("oa");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("oi");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("oo");v1.add("yoo");
        G2P.add(k,v1);
        k++;
        
        v1=new Vector();
        v1.add("");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("ur");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("s");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("b");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("k");v1.add("s");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("d");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("f");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("g");v1.add("j");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("h");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("j");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("k");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("l");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("m");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("n");v1.add("ng");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("p");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("r");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("s");v1.add("z");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("t");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("v");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("w");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("ks");v1.add("gz");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("y");v1.add("i");v1.add("ee");v1.add("igh");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("z");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("a");v1.add("o");v1.add("ar");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("e");v1.add("ee");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("i");v1.add("igh");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("o");v1.add("oa");v1.add("u");
        G2P.add(k,v1);
        k++;
        v1=new Vector();
        v1.add("u");v1.add("oo");
        G2P.add(k,v1);
       // k++;
      // System.out.println("Size of Vector :"+G2P.size());
    }
    /*void GraphemeFromInput(String in)
    {
        int i=0,j=0;
        int l=in.length();
        in=in.toLowerCase();
        String orig=in;
        int temp[]=new int[104];
        input_grapheme=new Vector();
        for(i=0;i<104;i++)
            temp[i]=0;
        int f;
       
        int t;
       for(t=0;t<103;t++)
       {
           in=orig;
           f=0;
        if(in.contains(grapheme[t]))
        {
           input_grapheme.add(grapheme[t]);
           in= in.replace(grapheme[t],"#");
            for(i=t+1;i<103;i++)
            {
            
                if(in.contains(grapheme[i]))
                { input_grapheme.add(grapheme[i]);
              in= in.replace(grapheme[i],"#");
                 
                }     
                        
            }
        }
        input_grapheme.add("@#$");
        //if(f==0)
           // break;
      }
       // System.out.println(in);
       int l2=input_grapheme.size();
      // System.out.println(l2);
       int ar[]=new int[l2];
       int to=0;
       for(i=1;i<l2;i++)
       {
           if(input_grapheme.get(i).equals("@#$") && input_grapheme.get(i-1).equals("@#$"))
           {
               ar[to++]=i-1;
           }
       }
       for(i=0;i<to;i++)
       {
           input_grapheme.remove(ar[i]-i);
       }
          // for(i=0;i<input_grapheme.size();i++)
          //  System.out.println(input_grapheme.get(i));
    }*/
    void func23()
    {
        Vector<String> my1;
        my1=new Vector();
        int c=0;
        int l1=G2P.size();
        for(int i=0;i<l1;i++)
        {
            for(int j=0;j<G2P.get(i).size();j++)
            {
                if(!my1.contains(G2P.get(i).get(j)))
                {
                    my1.add(G2P.get(i).get(j));
                    c++;
                }
            }
        }
        l1=my1.size();
        for(int i=0;i<l1;i++)
        {
            System.out.print("\""+my1.get(i)+"\"," );
        }
        System.out.println("");
        System.out.println(c);
    }
    int findIndex(String s1)
    {
        int i,j;
        for(i=0;i<99;i++)
        {
            if(s1.equals(grapheme[i]))
                return i;
        }
        
        return -1;
    }
    Vector<String> funcComb( Vector< Vector<String> > temp ) //combinations of phonems from all set of graphemes (in temp)
    {
        Vector<String> P;
        int Ptemplen;
        P=new Vector();
        int i=0,j=0,i2,j2,s=temp.size();
        P.add(temp.get(i).get(j));
      //  System.out.println(s);
        for(int k2=1;k2<s;k2++)
        {
            Vector<String> tt=temp.get(k2);
            int ltt=tt.size();
            // System.out.println(ltt);
            Ptemplen=P.size();
            for(int r1=0;r1<Ptemplen;r1++)
            {
                
                for(i2=0;i2<ltt;i2++)
                {
                    P.add(P.get(r1).concat("#"));
                }
           
            }
           for(int r1=0;r1<Ptemplen;r1++)
           {
               P.remove(0);
           }
           
          /*  for(int rr=0;rr<P.size();rr++)
                {
                System.out.println("PP bef "+ P.get(rr));
                } */ 
            Ptemplen=P.size();
            // System.out.println(Ptemplen + " jj "+ ltt);
            // Problem in loop
            int r12=0;
             for(int r1=0;r1<Ptemplen;r1++)
            {
                
                {
                    
                   P.insertElementAt(P.get(r1).concat(tt.get(r12++)),r1);
                   P.removeElementAt(r1+1);
              
                  if(r12==ltt)
                      r12=0;
                }
            }
          /*   for(int rr=0;rr<P.size();rr++)
                {
                System.out.println("PP aft "+ P.get(rr));
                } */ 
            
                
        }
         int l2=temp.get(0).size();
            Ptemplen=P.size();
            Vector<String> P2;
            P2=new Vector();
           /* for(int rr=0;rr<P.size();rr++)
                {
                System.out.println("PP "+ P.get(rr));
                } */
            for(int it=0;it<P.size();it++)
                P2.add(P.get(it));
           
           /* for(int rr=0;rr<P2.size();rr++)
            {
                System.out.println(P2.get(rr));
            }*/
            String rep=temp.get(0).get(0);
            i=1;
            for(i2=1;i2<l2;i2++)
            {
                int p2len=P2.size();
              //  System.out.println(p2len);
                for(j2=0;j2<p2len;j2++)
                {
                   // P2.get(j2).replace(rep,temp.get(0).get(i));
                   P2.insertElementAt(P2.get(j2).replace(rep,temp.get(0).get(i)),j2);
                   P2.removeElementAt(j2+1);
                   
                   
                }
                //P2.removeElementAt(0);
               
                rep=temp.get(0).get(i);
                i++;
                for(int ii2=0;ii2<P2.size();ii2++)
                    P.add(P2.get(ii2));
                
            }   
        return P;
        
    }
    
    
 void findPhonemes(String in)
 {
        GraphemeFromInput2(in);
        int l=input_grapheme.size();
        int i,j;
        int k=-1; //for phone vector ( number of combinations of grapheme)
        //phonemesOFinput=new Vector();
       
        phone=new Vector<>();
        String s1;
        Vector< Vector<String> > temp;
        temp=new Vector<>();
        boolean flag1=true;
        int ctemp=0;
        for(i=0;i<l;i++)
        {
            if(input_grapheme.get(i).equals("@#$") && flag1==true)
            {
              //  k++;
                flag1=false;
                //temp.clear();
            }
            s1=input_grapheme.get(i);
            int s1index=findIndex(s1);
           // System.out.println(s1index);
            if(s1index!=-1)
            {
                temp.add(G2P.get(s1index));
                
            }
            if(input_grapheme.get(i).equals("@#$") && flag1==false)
            {
                // find phonemes combination from temp vector.... & store them at kth position in phone
                // clear temp,k++,flag=true
                if(temp.size()>0)
                {
                    Vector<String> a2=funcComb(temp);
                   // System.out.println("a2 " +a2.size());
                    phone.add(a2);
                }
                //System.out.println("phone bef" +phone.size());
                temp.clear();
                flag1=true;
            }
            
            
        }
        
      l=phone.size();
      //System.out.println("TEMP  "+temp.size());
      for( i=0;i<l;i++)
      {
          int l1=phone.get(i).size();
          for( j=0;j<l1;j++)
          {
              System.out.print(phone.get(i).get(j) + " ");
                      
          }
          System.out.println("    ------");
          
      }
        
    }
 void GraphemeFromInput2(String in)
 {
     int i=0,j=0,fl=0,m,ind=0;
     CharSequence ch;
     input_grapheme = new Vector();
     Vector<String> temp;
     temp=new Vector();
      Vector<Vector<String>> temp2;
     temp2=new Vector();
     int len=in.length();
     String s1="",s2,s3="";
     for(m=0;m<len;)
     {
          s3="";
          fl=0;
         for(i=0;i<4;i++)
        {
        
         s2="";
         if(i+m >=len)
         {
             //fl=0;
             break;
         }
         s2=s2+in.charAt(i+m);
         s3=s3.concat(s2);
         for(j=0;j<99;j++)
         {
              
             if(s3.equals(grapheme[j]))
             {
                 fl=1;
                 s1=s3;
                 
                 ind=i+m;
                 //System.out.println(s1+ "   index  "+ (i+m));
                 break;
             }
         }
        
         
        }
         if(fl==1)
         {
            // System.out.println("hie");
             temp.add(s1);
             m=ind+1;
             s3="";
             s1="";
         }
         else
         {
             m++;
         }
    }
   //System.out.println(temp.size());
     temp2.add(temp);
     String ss="";
     input_grapheme.add("@#$");
     for(i=0;i<temp2.get(0).size();i++)
     {
        // System.out.println(temp2.get(0).get(i));
         ss=ss.concat((temp2.get(0).get(i)));
          input_grapheme.add(temp2.get(0).get(i));
         ss=ss.concat("#");
     }
     //System.out.println(ss);
     
    
     input_grapheme.add("@#$");
     //input_grapheme.add(ss);
    //  System.out.println(input_grapheme);
 }
    
    
}
