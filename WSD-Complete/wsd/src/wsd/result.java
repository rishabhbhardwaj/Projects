/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wsd;

import java.util.ArrayList;

/**
 *
 * @author Rishabh
 */
public class result extends javax.swing.JFrame {

    /**
     * Creates new form result
     */
  
    public result(String tar,String f) {
        initComponents();
        this.setLocation(410, 80);
       // jLabel2.setVisible(true);
        jTextField1.setText(tar);
        //jTextField1.disable();
        ouputText.setText("");
        this.setoutput(tar,f);
        
      //  jTextField1.setVisible(true);
    }
    public void setoutput(String a,String b)
    {
        Matching1 ob1=new Matching1();
        ArrayList<String> answers=new ArrayList<String>();
        answers=ob1.getSense(a,b);
        String s="";
        for(int i=0;i<answers.size();i++)
        {
            s+=answers.get(i);
            s+="\n";
        }
        if(s.isEmpty())
        {
            ouputText.setText("Target word does not exist.\nPlease go back and enter the target word.");
            //ouputText.disable();
        }
        else
        {
            ouputText.setText(s);
            //ouputText.disable();
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ouputText = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(420, 650));
        getContentPane().setLayout(null);

        jLabel1.setText("WORD SENSE DISAMBIGUATION");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(100, 30, 230, 20);

        jLabel2.setText("Entered Target Word :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 70, 120, 14);

        jTextField1.setEditable(false);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(150, 60, 110, 30);

        jLabel4.setText("Output :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 120, 50, 14);

        ouputText.setEditable(false);
        ouputText.setColumns(20);
        ouputText.setRows(5);
        jScrollPane2.setViewportView(ouputText);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(0, 140, 400, 140);

        jButton1.setText("Go Back");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(50, 350, 90, 30);

        jButton2.setText("Exit");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(240, 350, 80, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
       // startscreen obj=new startscreen();
       // obj.setVisible(true);
        this.setVisible(false);
        startscreen ob2=new startscreen();
        ob2.setVisible(true);
        
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        System.exit(0);
    }//GEN-LAST:event_jButton2MouseClicked

    /**
     * @param args the command line arguments
     */
    /*public static void main(String args[]) {
               java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new result().setVisible(true);
            }
        });
    }*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextArea ouputText;
    // End of variables declaration//GEN-END:variables
}
