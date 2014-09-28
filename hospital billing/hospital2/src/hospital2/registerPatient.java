package hospital2;

//import java.util.Date;
import hospital2.Database;
import hospital2.admitPatient;
import hospital2.home;
import java.awt.event.ActionEvent;
import java.util.*;
import java.text.*;
public class registerPatient extends javax.swing.JFrame {
    String regno;
    String name;
    String gender;
    String bgrp;
    String address;
    String contact,sage;
    java.sql.Date dat;
    String time;
    home q;
    String transdate;
    int regseq,age,days;
int f=1;
    /** Creates new form registerPatient */
    public registerPatient(home h) {
        super("Register Patient");
        initComponents();
        fail.setVisible(false);
        q=h;
        buttonGroup1.add(radioMale);
        buttonGroup1.add(radioFemale);
        //dat=(java.sql.Date) new Date();
        Database db=new Database();
        db.getConnection();
        try{
         db.r=db.stmt.executeQuery("select regseq.NEXTVAL from dual");
        if(db.r.next())
        {
            regseq=db.r.getInt(1);
        }
        //System.out.println("CASE SEQ"+caseseq);
        jLabel2.setText(Integer.toString(regseq));
        }
        catch(Exception e){}
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogSucesss = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        labelSucess = new javax.swing.JLabel();
        buttonOk = new javax.swing.JButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        labelName = new javax.swing.JLabel();
        labelGender = new javax.swing.JLabel();
        labelBlood = new javax.swing.JLabel();
        textName = new javax.swing.JTextField();
        radioMale = new javax.swing.JRadioButton();
        radioFemale = new javax.swing.JRadioButton();
        comboBlood = new javax.swing.JComboBox();
        buttonClear = new javax.swing.JButton();
        buttonSubmit = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();
        labelReg = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelAddress = new javax.swing.JLabel();
        labelContact1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAddress = new javax.swing.JTextArea();
        textContact1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        fail = new javax.swing.JLabel();

        dialogSucesss.setAlwaysOnTop(true);
        dialogSucesss.setBounds(new java.awt.Rectangle(471, 284, 337, 231));

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));

        labelSucess.setFont(new java.awt.Font("Tahoma", 1, 14));
        labelSucess.setText("Patient Registered Sucessfully");

        buttonOk.setText("OK");
        buttonOk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonOkMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(buttonOk, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addComponent(labelSucess, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addComponent(labelSucess)
                .addGap(47, 47, 47)
                .addComponent(buttonOk)
                .addGap(59, 59, 59))
        );

        javax.swing.GroupLayout dialogSucesssLayout = new javax.swing.GroupLayout(dialogSucesss.getContentPane());
        dialogSucesss.getContentPane().setLayout(dialogSucesssLayout);
        dialogSucesssLayout.setHorizontalGroup(
            dialogSucesssLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dialogSucesssLayout.setVerticalGroup(
            dialogSucesssLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setText("Registration");

        labelName.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelName.setText("Name");

        labelGender.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelGender.setText("Gender");

        labelBlood.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelBlood.setText("Blood Group");

        radioMale.setBackground(new java.awt.Color(204, 204, 255));
        radioMale.setText("Male");
        radioMale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioMaleActionPerformed(evt);
            }
        });

        radioFemale.setBackground(new java.awt.Color(204, 204, 255));
        radioFemale.setText("Female");
        radioFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioFemaleActionPerformed(evt);
            }
        });

        comboBlood.setBackground(new java.awt.Color(240, 240, 240));
        comboBlood.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" }));
        comboBlood.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBloodItemStateChanged(evt);
            }
        });
        comboBlood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBloodActionPerformed(evt);
            }
        });

        buttonClear.setText("Clear");
        buttonClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonClearMouseClicked(evt);
            }
        });

        buttonSubmit.setText("Submit");
        buttonSubmit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonSubmitMouseClicked(evt);
            }
        });

        buttonCancel.setText("Cancel");
        buttonCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonCancelMouseClicked(evt);
            }
        });
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        labelReg.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelReg.setText("Reg. No");

        jLabel2.setText("          ");

        labelAddress.setFont(new java.awt.Font("Tahoma", 1, 11));
        labelAddress.setText("Address");

        labelContact1.setFont(new java.awt.Font("Tahoma", 1, 11));
        labelContact1.setText("Contact No.");

        textAddress.setColumns(20);
        textAddress.setRows(5);
        jScrollPane1.setViewportView(textAddress);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital2/patinfo3.jpg"))); // NOI18N
        jLabel3.setText("      ");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel4.setText("Age");

        fail.setText("jLabel5");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(93, 93, 93)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)
                                .addComponent(labelBlood)
                                .addComponent(labelGender)
                                .addComponent(labelName)
                                .addComponent(labelContact1))
                            .addGap(52, 52, 52)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(textContact1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                                        .addComponent(comboBlood, javax.swing.GroupLayout.Alignment.LEADING, 0, 163, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(radioMale, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(49, 49, 49)
                                            .addComponent(radioFemale))
                                        .addComponent(textName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
                                    .addGap(74, 74, 74))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(107, 107, 107)
                            .addComponent(buttonClear, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(99, 99, 99)
                            .addComponent(buttonSubmit)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(fail, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelReg)
                        .addGap(66, 66, 66)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(177, 177, 177))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonCancel)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(346, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(282, 282, 282))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelReg)
                            .addComponent(labelName)
                            .addComponent(textName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jLabel2)))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelGender)
                            .addComponent(radioMale)
                            .addComponent(radioFemale))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboBlood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelBlood))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelAddress))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelContact1)
                            .addComponent(textContact1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fail))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonClear, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-816)/2, (screenSize.height-638)/2, 816, 638);
    }// </editor-fold>//GEN-END:initComponents

    private void comboBloodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBloodActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_comboBloodActionPerformed

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_buttonCancelActionPerformed
    private void jTextField1ActionPerformed(java.awt.event.MouseEvent evt)
    {
    }
    private void buttonCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCancelMouseClicked
        //home h = new home();
        this.setVisible(false);
        q.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonCancelMouseClicked

    private void buttonClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonClearMouseClicked
        textAddress.setText("");
        textContact1.setText("");
        textName.setText("");
        comboBlood.setSelectedIndex(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonClearMouseClicked

    private void buttonOkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonOkMouseClicked
        //home h = new home();
        this.setVisible(false);
        dialogSucesss.setVisible(false);
        admitPatient h=new admitPatient(this);
        h.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonOkMouseClicked

    
    private void buttonSubmitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSubmitMouseClicked
        f=1;
        
        name=textName.getText();
        address=textAddress.getText();
        sage=jTextField1.getText();
        contact=textContact1.getText();
      
            //f=0;
        if(name.isEmpty()==true || address.isEmpty()==true || sage.isEmpty()==true || contact.isEmpty()==true || gender.equals("no") || bgrp.equals("Select"))
        f=0;
        if(contact.isEmpty()==false)
        {if( contact.charAt(0) <48 || contact.charAt(0) >57)
            f=0;}
        if(sage.isEmpty()==false)
        {if(sage.charAt(0) <48 || sage.charAt(0) >57)
            f=0;}
        
        try {
            if(f==1)
            {
               
        Database d=new Database();
        d.getConnection();
        d.ps=d.con.prepareStatement("insert into patient values(?,?,?,?,?,?,?,?)");
        d.ps.setInt(1,regseq);
        d.ps.setString(2,name);
        d.ps.setString(3,gender);
        d.ps.setString(4,bgrp);
        d.ps.setInt(5,Integer.parseInt(sage));
        d.ps.setString(6,address); 
        d.ps.setInt(7,Integer.parseInt(contact));
        d.ps.setString(8,"Admitted");
       // d.ps.setString(8, time);
        d.ps.executeUpdate();
       d.ps.close();
      d.ps=d.con.prepareStatement("insert into patinfo (regno,name) values(?,?)");
      d.ps.setInt(1,regseq);
      d.ps.setString(2,name);
      d.ps.executeUpdate();
      d.ps.close();
      System.out.println("into patinfo");
         dialogSucesss.setVisible(true);
            }
        }
        catch(Exception e){}
        if(f==0)
        {
               fail.setText("Incorrect Data Entries.");
            fail.setFont(new java.awt.Font("Sylfaen", 1, 14));
            fail.setForeground(new java.awt.Color(204, 0, 0));
            fail.setVisible(true);
        }
        // TODO add your handling code here
    }//GEN-LAST:event_buttonSubmitMouseClicked

    private void radioMaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioMaleActionPerformed
        // TODO add your handling code here:
        if(evt.getActionCommand().isEmpty()==false)
        gender=evt.getActionCommand();
        else
            gender="no";
        System.out.println(gender);
    }//GEN-LAST:event_radioMaleActionPerformed

    private void radioFemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioFemaleActionPerformed
        // TODO add your handling code here:
        if(evt.getActionCommand().isEmpty()==false)
        gender=evt.getActionCommand();
        else
            gender="no";
    }//GEN-LAST:event_radioFemaleActionPerformed

    private void comboBloodItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBloodItemStateChanged
        // TODO add your handling code here:
        bgrp=(String)evt.getItem();
    }//GEN-LAST:event_comboBloodItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonClear;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton buttonOk;
    private javax.swing.JButton buttonSubmit;
    private javax.swing.JComboBox comboBlood;
    private javax.swing.JDialog dialogSucesss;
    private javax.swing.JLabel fail;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel labelAddress;
    private javax.swing.JLabel labelBlood;
    private javax.swing.JLabel labelContact1;
    private javax.swing.JLabel labelGender;
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelReg;
    private javax.swing.JLabel labelSucess;
    private javax.swing.JRadioButton radioFemale;
    private javax.swing.JRadioButton radioMale;
    private javax.swing.JTextArea textAddress;
    private javax.swing.JTextField textContact1;
    private javax.swing.JTextField textName;
    // End of variables declaration//GEN-END:variables

}
