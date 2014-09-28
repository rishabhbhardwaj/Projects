/*
 All the phonemes(leaves of the tree) are stored in an array phone.
 The Constructor maintains a 2-D vector which stores the path (node number) from the root to the phoneme represented by the index
 number and cooresponding index in the phone array.
 * Functions:
 * 1.int findpos(string)
     returns the index of the given phoneme from phone.
 * 2.int union_func(int,int)
     returns the number of all distinct nodes in the path of the two phonemes index given as parameters.Hashtable is maintained.
 * 3.int intersect_func(int,int)
     returns the number of comman nodes of the two phonemes index given as parameters.Hashtable is maintained. 
 * 4.int find_dist(string,string)
     returns the distance measure between two phonemes using jacard coefficient.
 */
package miniproject;

import java.util.*;
public class PhonemeTable {
    
     String phone[]={
                   "ai","or","ow","igh","ear","air","al","orl","ch","b","k","ks","d","j","f","g","n",
                   "l","m","ng","nj","p","kw","r","s","sh","z","t","th","w","hw","ar","ee","e","ur",
                   "yoo","oo","i","oa","oi","h","v","gz","y","a","o","u",
                    "hh","dh","zh","iy1","ey","ae","iy","ih","ey1","ih1","eh","eh1","ae1","ah1","aw","ah","ao","er1","ay1","ax","ow1","aa1","ay","er","ao1","aa","aw1",
                    "oy","oy1","uh","uh1","uw","uw1"};
    
     Vector<Vector<Integer>> ar;
      PhonemeTable()
     {
     
       ar = new  Vector<>(81);
       Vector<Integer> v1;
       int k=0;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(9));v1.add(new Integer(17));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(9));v1.add(new Integer(17));
       ar.add(k, v1);k++;
      v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(9));v1.add(new Integer(16));v1.add(new Integer(17));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(9));v1.add(new Integer(16));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(9));v1.add(new Integer(16));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(9));v1.add(new Integer(16));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(9));v1.add(new Integer(15));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(9));v1.add(new Integer(17));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(2));v1.add(new Integer(7));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(2));v1.add(new Integer(6));v1.add(new Integer(13));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(2));v1.add(new Integer(6));v1.add(new Integer(14));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(2));v1.add(new Integer(6));v1.add(new Integer(14));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(2));v1.add(new Integer(6));v1.add(new Integer(13));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(2));v1.add(new Integer(7));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(2));v1.add(new Integer(5));v1.add(new Integer(11));v1.add(new Integer(12));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(2));v1.add(new Integer(6));v1.add(new Integer(13));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(8));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(10));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(8));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(8));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(8));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(2));v1.add(new Integer(6));v1.add(new Integer(14));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(2));v1.add(new Integer(5));v1.add(new Integer(6));v1.add(new Integer(12));v1.add(new Integer(14));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(10));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(2));v1.add(new Integer(5));v1.add(new Integer(11));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(2));v1.add(new Integer(5));v1.add(new Integer(12));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(2));v1.add(new Integer(5));v1.add(new Integer(11));v1.add(new Integer(12));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(2));v1.add(new Integer(6));v1.add(new Integer(14));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(2));v1.add(new Integer(5));v1.add(new Integer(11));v1.add(new Integer(12));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(10));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(2));v1.add(new Integer(5));v1.add(new Integer(12));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(9));v1.add(new Integer(16));v1.add(new Integer(17));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(9));v1.add(new Integer(15));v1.add(new Integer(16));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(9));v1.add(new Integer(18));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(9));v1.add(new Integer(16));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(9));v1.add(new Integer(17));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(9));v1.add(new Integer(17));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(9));v1.add(new Integer(18));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(9));v1.add(new Integer(17));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(9));v1.add(new Integer(15));v1.add(new Integer(16));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(2));v1.add(new Integer(5));v1.add(new Integer(12));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(2));v1.add(new Integer(5));v1.add(new Integer(11));v1.add(new Integer(12));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(2));v1.add(new Integer(6));v1.add(new Integer(14));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(9));v1.add(new Integer(15));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(9));v1.add(new Integer(18));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(9));v1.add(new Integer(18));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(9));v1.add(new Integer(18));
       ar.add(k, v1);k++;
      System.out.println("prev " +k);
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(2));v1.add(new Integer(19));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(2));v1.add(new Integer(5));v1.add(new Integer(11));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(2));v1.add(new Integer(5));v1.add(new Integer(12));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(9));v1.add(new Integer(15));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(9));v1.add(new Integer(15));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(9));v1.add(new Integer(15));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(9));v1.add(new Integer(15));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(9));v1.add(new Integer(15));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(9));v1.add(new Integer(15));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(9));v1.add(new Integer(15));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(9));v1.add(new Integer(15));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(9));v1.add(new Integer(15));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(9));v1.add(new Integer(15));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(9));v1.add(new Integer(16));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(9));v1.add(new Integer(16));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(9));v1.add(new Integer(16));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(9));v1.add(new Integer(16));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(9));v1.add(new Integer(16));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(9));v1.add(new Integer(16));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(9));v1.add(new Integer(16));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(9));v1.add(new Integer(16));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(9));v1.add(new Integer(16));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(9));v1.add(new Integer(16));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(9));v1.add(new Integer(16));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(9));v1.add(new Integer(16));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(9));v1.add(new Integer(16));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(9));v1.add(new Integer(16));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(9));v1.add(new Integer(17));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(9));v1.add(new Integer(17));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(9));v1.add(new Integer(17));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(9));v1.add(new Integer(17));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(9));v1.add(new Integer(17));
       ar.add(k, v1);k++;
       v1 = new Vector<>();
       v1.add(new Integer(1));v1.add(new Integer(4));v1.add(new Integer(9));v1.add(new Integer(17));
       ar.add(k, v1);k++;
       System.out.println(k);
     } 
     
 int findpos(String s)
 {
    int i;
    for(i=0;i<47;i++)
    {
        if(phone[i].equals(s))
        {
            return i;
        }
    }
        return 0;
 }
 
 int union_func(int pos1,int pos2)
{
    int i;
    int[] a;
        a = new int[19];
        for(i=0;i<19;i++) {
        a[i]=0;
    }
    //int l1=ar[pos1].size();
    int l1= ar.get(pos1).size();
    int l2=ar.get(pos2).size();
    for(i=0;i<l1;i++)
    {
        //a[ar[pos1][i]]=1;
        a[ar.get(pos1).get(i).intValue()]=1;
    }
    for(i=0;i<l2;i++)
    {
        a[ar.get(pos2).get(i).intValue()]=1;
    }
    int c=0;
    for(i=0;i<19;i++)
    {
        if(a[i]==1) {
            c++;
        }
    }
    return c;
}
 int intersect_func(int pos1,int pos2)
{
    int i;
    int[] a;
    a=new int[19];
    for(i=0;i<19;i++) {
        a[i]=0;
    }
    int l1= ar.get(pos1).size();
    int l2;
        l2 = ar.get(pos2).size();
    for(i=0;i<l1;i++)
    {
        a[ar.get(pos1).get(i).intValue()]=1;
    }
    int c=0;
    for(i=0;i<l2;i++)
    {
       if(a[ar.get(pos2).get(i).intValue()]==1) {
            c++;
        }
    }
    return c;
}
 double find_dist(String s1,String s2)
{
    int uni=union_func(findpos(s1),findpos(s2));
    int intersec=intersect_func(findpos(s1),findpos(s2));
    double ratio=(double)intersec/(double)(uni);
    if(ratio==1.0)
    {
        if(!s1.equals(s2))
        {
            ratio=0.930;
        }
    }
    double dis=1.0-ratio;
    return dis;
}
 double find_dist_phonemes(String p1,String p2)
 {
     double ans=0.0f,atemp=0.0f,btemp=0.0f;
     Vector<String> ph1,ph2;
     ph1=new Vector();
     ph2=new Vector();
     int l1=p1.length(),l2=p2.length();
     int i=0,j=0;
     String s1="",s2="";
     while(i<l1)
     {
         if(p1.charAt(i)=='#')
         {
             ph1.add(s1);
             s1="";
         }
         if(p1.charAt(i)!='#')
         s1=s1+p1.charAt(i);
         i++;
     }
     ph1.add(s1);
     s1="";
     i=0;
     while(i<l2)
     {
         if(p2.charAt(i)=='#')
         {
             ph2.add(s1);
             s1="";
         }
         if(p2.charAt(i)!='#')
         s1=s1+p2.charAt(i);
         i++;
     }
     ph2.add(s1);
     int sz1=ph1.size();
     int sz2=ph2.size();
     int diff=Math.abs(sz1-sz2);
     if(sz1-sz2>4 || sz2-sz1 >4)
         return 1.00;
     
     int co=0;
     System.out.println("phonemes of ph2: ");
     for(int tr=0;tr<ph2.size();tr++)
         System.out.print(ph2.get(tr)+"  ");
     System.out.print("\n");
     if(sz1<sz2)
     {
        int k=0;
         double temp=0.0f;
        for(i=0;i<sz1;i++)
        {
            
            if(ph1.get(i).equals("") || ph2.get(k).equals(""))
                continue;
            atemp=(double)find_dist(ph1.get(i),ph2.get(k));
            if(i<sz1-1)
            btemp=(double)find_dist(ph1.get(i+1),ph2.get(k));
            else
                btemp=9.99f;
            if(atemp<=btemp)
            {
                if(atemp==0.0)
                    co++;
                temp+=atemp;
                System.out.println(ph1.get(i)+ " "+ph2.get(k) +" " + atemp + " " + btemp);
            }
            else
            {
                if(btemp==0.0)
                    co++;
                System.out.println(ph1.get(i+1)+" "+ph2.get(k)+" " + atemp + " " + btemp);
                temp+=btemp;
                i++;
            }
            k++;
        }
        System.out.println("Final Dist"+ ((double)temp/(double)(sz1+co) + ((double)diff/(double)(sz2-diff))*0.07)); 
        return ((double)temp/(double)(sz1+co) + ((double)diff/(double)(sz2-diff))*0.07);// + (double)diff/(double)(sz2+sz1));
     }
     else
     {
         int k=0;
        double temp=0.0f;
        for(i=0;i<sz2;i++)
        {
            if(ph1.get(i).equals("") || ph2.get(k).equals(""))
                continue;
            atemp=(double)find_dist(ph1.get(i),ph2.get(k));
            if(i<sz2-1)
            btemp=(double)find_dist(ph1.get(i+1),ph2.get(k));
            else
                btemp=9.99f;
            if(atemp<=btemp)
            {
                if(atemp==0.0)
                    co++;
                System.out.println(ph1.get(i)+ " "+ph2.get(k) +" " + atemp + " " +btemp);
                temp+=atemp;
            }
            else
            {
                if(btemp==0.0)
                    co++;
                System.out.println("btemp<atemp "+ph1.get(i+1)+ " "+ph2.get(k) +" " + atemp + " "+ btemp);
                temp+=btemp;
                i++;
            }
            k++;
        }
        System.out.println("Final Dist"+ ((double)temp/(double)(sz2+co) + ((double)diff/(double)(sz1-diff))*0.07));
        return ((double)temp/(double)(sz2+co) + ((double)diff/(double)(sz1-diff))*0.07);// + (double)diff/(double)(sz1+sz2));
     }
     
  
 }
    
}
