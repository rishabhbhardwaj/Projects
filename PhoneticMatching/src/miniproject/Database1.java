/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproject;

import java.io.*;

/**
 *
 * @author deepshikha
 */
public class Database1 {
    
 
    String line;
    String title;
    /*Database1()
    {
       
        System.out.println("Connection Success");
    }
    */
     static int k;  
    void ReadFile(String Filename)
    {
        try
        {
          FileInputStream fs= new FileInputStream(Filename);
          DataInputStream in = new DataInputStream(fs);
          BufferedReader br = new BufferedReader(new InputStreamReader(in));
          Database db=new Database();
          db.getConnection();
        //db.ps=db.con.prepareStatement("create table books(id number,name varchar(100), topic varchar(50))");
          //db.ps.executeUpdate();
            title=br.readLine();
          while ((line = br.readLine()) != null)   
            {
                System.out.println(line);
                db.ps=db.con.prepareStatement("insert into books (id,name,topic) values(?,?,?)");
                db.ps.setInt(1, k);
                db.ps.setString(2,title);
                db.ps.setString(3,line);
                db.ps.executeUpdate();
                db.ps.close();
                System.out.println("inserted");
                k++;
            }
            in.close();
        }
        catch (Exception e){}
    }
    
}
