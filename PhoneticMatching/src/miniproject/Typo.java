/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproject;

import java.util.Vector;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Administrator
 */
public class Typo {
    
    int i,j,k,len;
    String s1,s2,s3,s4;
    TypographicTable obj1=new TypographicTable();
    DLdistance obj2=new DLdistance();
    float typo_theta=0.0f;
    float dl_theta=0.6f;
    int ty=0,mx;
    int num=1;
    public Vector<String> typo_name;
    public Vector<String> typo_topic;
    void typo_calc(String in)
    {
        typo_name=new Vector();
        typo_topic=new Vector();
        try
        {
        len=in.length();
        Database db=new Database();
        db.getConnection();
        
        //String sql1="select count(*) from test_time";
        for(i=0;i<len-1;i++)
        {
            s1=in.substring(i,i+2);  //(beginindex,endindex-1) is the range so i+2
          
            s2="select name,topic from books where topic like '%"+s1+"%'";
           // System.out.println(s2);
            db.r=db.stmt.executeQuery(s2);
            while(db.r.next())
            {
                int kk=db.r.getString(2).length();
                
                if(kk>len)
                    mx=kk;
                else
                    mx=len;
                if((obj1.findTypoDist(in,db.r.getString(2))< typo_theta) || (((float)obj2.damlev(db.r.getString(2), in))/(float)mx <dl_theta ))
                {
                    if(!typo_topic.contains(db.r.getString(2)))
                    {typo_name.add(db.r.getString(1));
                    typo_topic.add(db.r.getString(2));
                    //System.out.print(num++ +"-> "+ db.r.getString(1));
                //System.out.println("  "+db.r.getString(2));
                ty++;}}
            }
           // System.out.println("------------- NEXT BI-GRAM --------------");
        }
        }
        catch(Exception e){}
       // System.out.println(ty);
    }

    
}