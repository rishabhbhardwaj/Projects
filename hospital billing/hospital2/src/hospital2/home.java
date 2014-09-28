package hospital2;

public class home extends javax.swing.JFrame {
    
public home() {
        super("Patient Billing Software");
        initComponents();
    }

 @SuppressWarnings("Unchecked")

 public void changeVisibility() 
    {
        addUser.setVisible(false);
        editOrganisation.setVisible(false);
    }
    public void setLabel9(String s) 
    {
        jLabel9.setText(s);
    }
    /*public void setname(String s) 
    {
        name.setText(s);
    }
    public void setaddress(String s) 
    {
        address.setText(s);
    }
    public void setcode(String s) 
    {
       code.setText(s);
    }*/
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        changePassword = new javax.swing.JFrame();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jPasswordField3 = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        confirm = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        changePasswd = new javax.swing.JLabel();
        editOrganisation = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        addUser = new javax.swing.JLabel();
        labelOut = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        modify = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        buttonReg = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        buttonUpdateDues = new javax.swing.JButton();
        buttonPayDues = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        buttonTransfer = new javax.swing.JButton();
        buttonWard = new javax.swing.JButton();
        buttonDischarge = new javax.swing.JButton();

        changePassword.setAlwaysOnTop(true);
        changePassword.setBounds(new java.awt.Rectangle(0, 0, 450, 350));

        jLabel4.setText("Old Password");

        jLabel5.setText("New Password");

        jLabel6.setText("Confirm Password");

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel7.setText("Change Password");

        confirm.setText("Confirm ");
        confirm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmMouseClicked(evt);
            }
        });

        cancel.setText("Cancel");
        cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout changePasswordLayout = new javax.swing.GroupLayout(changePassword.getContentPane());
        changePassword.getContentPane().setLayout(changePasswordLayout);
        changePasswordLayout.setHorizontalGroup(
            changePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 685, Short.MAX_VALUE)
            .addGroup(changePasswordLayout.createSequentialGroup()
                .addGroup(changePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(changePasswordLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(changePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(13, 13, 13)
                        .addGroup(changePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPasswordField3)
                            .addComponent(jPasswordField2)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)))
                    .addGroup(changePasswordLayout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(changePasswordLayout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(confirm)
                        .addGap(47, 47, 47)
                        .addComponent(cancel)))
                .addContainerGap(302, Short.MAX_VALUE))
        );
        changePasswordLayout.setVerticalGroup(
            changePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(changePasswordLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel7)
                .addGap(36, 36, 36)
                .addGroup(changePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(changePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(changePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jPasswordField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(changePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirm)
                    .addComponent(cancel))
                .addContainerGap(188, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(245, 165, 785, 465));

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        changePasswd.setFont(new java.awt.Font("Tahoma", 1, 11));
        changePasswd.setText("Change Password");
        changePasswd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changePasswdMouseClicked(evt);
            }
        });
        changePasswd.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                changePasswdMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                changePasswdMouseMoved(evt);
            }
        });

        editOrganisation.setFont(new java.awt.Font("Tahoma", 1, 11));
        editOrganisation.setText("Edit Organization Details");
        editOrganisation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editOrganisationMouseClicked(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital2/home2.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");

        jLabel9.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14));
        jLabel9.setForeground(new java.awt.Color(0, 102, 102));
        jLabel9.setText("Operator Logged in");

        addUser.setFont(new java.awt.Font("Tahoma", 1, 11));
        addUser.setText("Add User");
        addUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addUserMouseClicked(evt);
            }
        });

        labelOut.setFont(new java.awt.Font("Tahoma", 1, 11));
        labelOut.setText("Sign Out");
        labelOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelOutMouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)), "Patient Information"));

        jButton2.setText("Patient Ward Info");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton1.setText("Patient General Info");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        modify.setText("Modify Patient Info");
        modify.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modifyMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(modify, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(modify)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)), "New Patient"));

        buttonReg.setText("Register & Admit Patient");
        buttonReg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonRegMouseClicked(evt);
            }
        });
        buttonReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(buttonReg, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonReg)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(153, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)), "Billing Information"));

        buttonUpdateDues.setText("Update Dues");
        buttonUpdateDues.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonUpdateDuesMouseClicked(evt);
            }
        });
        buttonUpdateDues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateDuesActionPerformed(evt);
            }
        });

        buttonPayDues.setText("Pay Dues");
        buttonPayDues.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonPayDuesMouseClicked(evt);
            }
        });
        buttonPayDues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPayDuesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonUpdateDues, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonPayDues, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(147, 147, 147))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonUpdateDues)
                    .addComponent(buttonPayDues))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(153, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)), "Operator's Functions"));

        buttonTransfer.setText("Transfer Patient");
        buttonTransfer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonTransferMouseClicked(evt);
            }
        });

        buttonWard.setText("Ward Availability");
        buttonWard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonWardMouseClicked(evt);
            }
        });
        buttonWard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonWardActionPerformed(evt);
            }
        });

        buttonDischarge.setText("Discharge Patient");
        buttonDischarge.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonDischargeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(buttonTransfer, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonDischarge))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(buttonWard)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonWard)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonTransfer)
                    .addComponent(buttonDischarge))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addUser)
                    .addComponent(editOrganisation)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelOut)
                            .addComponent(changePasswd, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(170, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editOrganisation))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(changePasswd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelOut)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jLabel3)))
                .addContainerGap(37, Short.MAX_VALUE))
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
        setBounds((screenSize.width-866)/2, (screenSize.height-638)/2, 866, 638);
    }// </editor-fold>//GEN-END:initComponents

    private void changePasswdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changePasswdMouseClicked
        //        changePasswd chg  = new changePasswd();
        //        chg.setVisible(true);
        super.setEnabled(false);
        changePasswd c=new changePasswd(this,jLabel9.getText());
        c.setVisible(true);
        //this.setEnabled(false);
        // TODO add your handling code here:
}//GEN-LAST:event_changePasswdMouseClicked

    private void changePasswdMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changePasswdMouseDragged
        // TODO add your handling code here:
}//GEN-LAST:event_changePasswdMouseDragged

    private void changePasswdMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changePasswdMouseMoved
        
        // TODO add your handling code here:
}//GEN-LAST:event_changePasswdMouseMoved

    private void editOrganisationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editOrganisationMouseClicked
        editDetails e=new editDetails(this);
        super.setEnabled(false);
        e.setVisible(true);
        // TODO add your handling code here:
}//GEN-LAST:event_editOrganisationMouseClicked

    private void buttonRegMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonRegMouseClicked
        super.setVisible(false);
        registerPatient r = new registerPatient(this);
        r.setVisible(true);
        // TODO add your handling code here:
}//GEN-LAST:event_buttonRegMouseClicked

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed

}//GEN-LAST:event_jPasswordField1ActionPerformed

    private void confirmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmMouseClicked

}//GEN-LAST:event_confirmMouseClicked

    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseClicked

        changePassword.setVisible(false);
        // TODO add your handling code here:
}//GEN-LAST:event_cancelMouseClicked

    private void buttonTransferMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonTransferMouseClicked
        super.setVisible(false);
        patientTransfer r = new patientTransfer(this);
        r.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_buttonTransferMouseClicked

    private void buttonPayDuesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonPayDuesMouseClicked
        super.setVisible(false);
        payDues r = new payDues(this);
        r.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_buttonPayDuesMouseClicked

    private void buttonUpdateDuesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonUpdateDuesMouseClicked
        super.setVisible(false);
        updateDues r = new updateDues(this);
        r.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_buttonUpdateDuesMouseClicked

    private void buttonDischargeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonDischargeMouseClicked
        super.setVisible(false);
        
        dischargePatient r = new dischargePatient(this);
        r.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonDischargeMouseClicked

    private void addUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addUserMouseClicked
        // TODO add your handling code here:
        addUser a=new addUser(this);
        super.setEnabled(false);
        a.setVisible(true);
    }//GEN-LAST:event_addUserMouseClicked

    private void buttonWardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonWardMouseClicked
        // TODO add your handling code here:
        wardAvailable w=new wardAvailable(this);
        w.setVisible(true);
        super.setVisible(false);
    }//GEN-LAST:event_buttonWardMouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        patInfo p=new patInfo(this);
        p.setVisible(true);
        super.setVisible(false);
        
    }//GEN-LAST:event_jButton2MouseClicked

    private void labelOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelOutMouseClicked
        super.setVisible(false);
        login l=new login();
        l.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_labelOutMouseClicked

    private void buttonRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonRegActionPerformed

    private void buttonWardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonWardActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonWardActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        patGenInfo p1=new patGenInfo(this);
        p1.setVisible(true);
        super.setVisible(false);
       
    }//GEN-LAST:event_jButton1MouseClicked

    private void modifyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modifyMouseClicked
        // TODO add your handling code here:
        modifyDetails m=new modifyDetails();
        super.setVisible(false);
        m.setVisible(true);
    }//GEN-LAST:event_modifyMouseClicked

private void buttonUpdateDuesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateDuesActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_buttonUpdateDuesActionPerformed

private void buttonPayDuesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPayDuesActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_buttonPayDuesActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addUser;
    private javax.swing.JButton buttonDischarge;
    private javax.swing.JButton buttonPayDues;
    private javax.swing.JButton buttonReg;
    private javax.swing.JButton buttonTransfer;
    private javax.swing.JButton buttonUpdateDues;
    private javax.swing.JButton buttonWard;
    private javax.swing.JButton cancel;
    private javax.swing.JLabel changePasswd;
    private javax.swing.JFrame changePassword;
    private javax.swing.JButton confirm;
    private javax.swing.JLabel editOrganisation;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JPasswordField jPasswordField3;
    private javax.swing.JLabel labelOut;
    private javax.swing.JButton modify;
    // End of variables declaration//GEN-END:variables

}
