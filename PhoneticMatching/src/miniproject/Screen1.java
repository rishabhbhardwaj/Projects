/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Screen1.java
 *
 * Created on Nov 4, 2012, 10:12:38 PM
 */
package miniproject;

import java.util.Vector;

/**
 *
 * @author deepshikha
 */
public class Screen1 extends javax.swing.JFrame {

    Vector<String> phone_name;
    Vector<String> phone_topic;
    
    double phoneme_theta=0.0690f;
    public Screen1(String in) {
         phone_name=new Vector();
         phone_topic=new Vector();
        
         initComponents();
       this.setTitle("Displaying Results for "+in);
       //Speech bol= new Speech();
       //bol.speak(in);
        try
        {
        double dist_phone[]=new double[100];
        int szdist=0;
            newphoneme obj=new newphoneme();
        PhonemeTable obj2=new PhonemeTable();
        String s1,s2,s3,s4;
        s1=obj.find_phoneme(in);
        
        Vector<String> output;
        output=new Vector();
        int i,j,k,l,p=0;
        
        Database db=new Database();
       // Database db2=new Database();
        int num=1;
        db.getConnection();
        //db2.getConnection();
        try {
            Vector<String> temp;
            temp=new Vector();
        //for(i=0;i<sz;i++)
       // {
           // for(j=0;j<obj.phone.get(i).size();j++)
            //{
                 //System.out.println("phone  "+s1);
                 
                 temp=get_parts_phonemes(s1);
                for(int k2=0;k2<temp.size();k2++)
                     System.out.println(temp.get(k2));
                 
                 System.out.println("---------------------------  " +temp.size());
                 for(int k2=0;k2<temp.size();k2++)
                 {
                     
                     System.out.println("K   "+k2);
                     System.out.println("KKKKK   "+temp.get(k2));
                     s2="select word,phoneme from word_phonemes where phoneme like '%"+temp.get(k2) +"%'";
                     
                 db.r=db.stmt.executeQuery(s2);
                 while(db.r.next())
                 {
                     System.out.println("rrrrrrrrrrrrrrrrrrishabh2");
                     //System.out.println(s1+"   "+db.r.getString(2));
                      System.out.println("Phoneme String-> "+ db.r.getString(2) +" Phone Word "+db.r.getString(1));
                     if((double)(obj2.find_dist_phonemes(s1,db.r.getString(2)))<phoneme_theta)
                     {
                         if(!(output.contains(db.r.getString(1))))
                         {output.add(db.r.getString(1));
                        // s3="select name from books where LOWER(topic)='"+db.r.getString(1)+"'";
                        // db2.r=db2.stmt.executeQuery(s3);
                        // while(db2.r.next())
                        // {
                          //   phone_name.add(db2.r.getString(1));
                            // phone_topic.add(db.r.getString(1));
                             dist_phone[szdist++]=(double)(obj2.find_dist_phonemes(s1,db.r.getString(2)));
                        // System.out.println(num++ +"-> "+db2.r.getString(1)+"    "+db.r.getString(1));
                        // }
                        /// db2.r.close();
                         }
                         
                     }
                     //db.r.close();
                     
                 }
                 System.out.println("SSSSSSSSSSSSSS   "+temp.size() +"    "+ k2);
               }
                System.out.println("rrrishabh333333333333333");
       }
       catch(Exception e){
       System.out.println(e.getMessage());
       }
        System.out.println("hieeeeeeee");
      Typo ob1=new Typo();
      ob1.typo_calc(in);
      int phone_size,typo_size,out_size;
      out_size=output.size();
     // phone_size=phone_name.size();
      typo_size=ob1.typo_name.size();
      String phone_arr[][]=new String[out_size][3];
      String typo_arr[][]=new String[typo_size][2];
      for(int i2=0;i2<out_size;i2++) {
               
                phone_arr[i2][0]=""+(i2+1);
                phone_arr[i2][1]=output.get(i2);
               phone_arr[i2][2]=""+dist_phone[i2];
            }
      for(int i2=0;i2<typo_size;i2++) {
                
                typo_arr[i2][0]=""+(i2+1);
               typo_arr[i2][1]=ob1.typo_topic.get(i2);
               
            }
      for(int i3=0;i3<out_size;i3++)
      {
          for(int i4=i3+1;i4<out_size;i4++)
          {
              if(dist_phone[i4]<dist_phone[i3])
              {
                  double td;
                  String ts;
                  td=dist_phone[i3];
                  dist_phone[i3]=dist_phone[i4];
                  dist_phone[i4]=td;
               /*   ts=phone_arr[i3][0];
                  phone_arr[i3][0]=phone_arr[i4][0];
                  phone_arr[i4][0]=ts;*/
                  ts=phone_arr[i3][1];
                  phone_arr[i3][1]=phone_arr[i4][1];
                  phone_arr[i4][1]=ts;
                  ts=phone_arr[i3][2];
                  phone_arr[i3][2]=phone_arr[i4][2];
                  phone_arr[i4][2]=ts;
                  
              }
          }
      }
      jTable1.setModel(new javax.swing.table.DefaultTableModel(typo_arr,
            new String [] {
                "Serial Number", "Topic"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false,
            };

                @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

                @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
         //for phonetic table
        
        jTable2.setModel(new javax.swing.table.DefaultTableModel(phone_arr,
            new String [] {
                "S.No.", "Topic","Distance"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class , java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false,false
            };

                @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

                @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);
            
        }
        catch(Exception e){}
    }
 Vector<String> get_parts_phonemes(String in)
    {
        Vector<String> ph1;
        ph1=new Vector();
        int i=0;
        int l1=in.length();
        String s1="";
        while(i<l1)
        {
         if(in.charAt(i)=='#')
         {
             s1=s1+"#";
             ph1.add(s1);
             s1="";
         }
         s1=s1+in.charAt(i);
         i++;
     }
     s1=s1+"#";
     ph1.add(s1);
     l1=ph1.size();
   /*  for(i=0;i<l1;i++)
     {
     
     
         System.out.println(ph1.get(i));
     }*/
     return ph1;
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(245, 165, 785, 465));
        setMinimumSize(new java.awt.Dimension(800, 400));
        getContentPane().setLayout(null);

        jPanel1.setPreferredSize(new java.awt.Dimension(883, 600));
        jPanel1.setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setAlignmentX(2.0F);
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 30, 570, 90);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(20, 180, 570, 90);

        jButton1.setText("Go Back");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(260, 280, 110, 23);

        jLabel1.setText("Typographic Correction Results");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 10, 220, 14);

        jLabel2.setText("Phonetic Correction Results");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 160, 160, 14);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 640, 310);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        Screen ob1=new Screen();
        ob1.setVisible(true);
}//GEN-LAST:event_jButton1MouseClicked

    /**
     * @param args the command line arguments
     */
   /* public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Screen1().setVisible(true);
            }
        });
    }*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
