package branch;

public class branchClient extends javax.swing.JFrame {

    /**
     * Creates new form branchClient
     */
    public branchClient() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        btn_logIn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        pnl_orders = new javax.swing.JPanel();
        btn_firstOrder = new javax.swing.JToggleButton();
        btn_previousOrder = new javax.swing.JToggleButton();
        txt_orderID = new javax.swing.JTextField();
        btn_nextOrder = new javax.swing.JButton();
        btn_LatestOrder = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_orderItems = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txt_fullName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_fullAddress = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnu_Connect = new javax.swing.JMenu();
        mnu_BranchDB = new javax.swing.JMenuItem();
        mnu_CentralDB = new javax.swing.JMenuItem();
        mnu_logOut = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel1.setText("Book-O Shack");

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        jLabel2.setText("Employee ID: ");

        jTextField1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        jLabel3.setText("PIN: ");

        jTextField2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N

        btn_logIn.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        btn_logIn.setText("Log In");
        btn_logIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logInActionPerformed(evt);
            }
        });

        pnl_orders.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Orders", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Rounded MT Bold", 0, 11))); // NOI18N
        pnl_orders.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        pnl_orders.setName("Orders"); // NOI18N

        btn_firstOrder.setText("<<");
        btn_firstOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_firstOrderActionPerformed(evt);
            }
        });

        btn_previousOrder.setText("<");

        txt_orderID.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Order ID: ")));

        btn_nextOrder.setText(">");

        btn_LatestOrder.setText(">>");

        tbl_orderItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ISBN", "Title", "Quantity", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbl_orderItems);

        jLabel4.setText("Full Name: ");

        txt_fullName.setEditable(false);

        jLabel5.setText("Username:");

        txt_username.setEditable(false);

        jLabel6.setText("Full Address: ");

        txt_fullAddress.setEditable(false);

        jToggleButton1.setText("Complete Order");

        jToggleButton2.setText("Update Order");

        javax.swing.GroupLayout pnl_ordersLayout = new javax.swing.GroupLayout(pnl_orders);
        pnl_orders.setLayout(pnl_ordersLayout);
        pnl_ordersLayout.setHorizontalGroup(
            pnl_ordersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_ordersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_ordersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(pnl_ordersLayout.createSequentialGroup()
                        .addComponent(btn_firstOrder)
                        .addGap(20, 20, 20)
                        .addComponent(btn_previousOrder)
                        .addGap(18, 18, 18)
                        .addComponent(txt_orderID, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_nextOrder)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(btn_LatestOrder))
                    .addGroup(pnl_ordersLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_fullName, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_username))
                    .addGroup(pnl_ordersLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_fullAddress))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_ordersLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jToggleButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton1)))
                .addContainerGap())
        );
        pnl_ordersLayout.setVerticalGroup(
            pnl_ordersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_ordersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_ordersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_orderID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_nextOrder)
                    .addComponent(btn_LatestOrder)
                    .addComponent(btn_previousOrder)
                    .addComponent(btn_firstOrder))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_ordersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_fullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_ordersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_fullAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_ordersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton1)
                    .addComponent(jToggleButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mnu_Connect.setText("Settings");
        mnu_Connect.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N

        mnu_BranchDB.setText("Connect to Branch Database");
        mnu_BranchDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_BranchDBActionPerformed(evt);
            }
        });
        mnu_Connect.add(mnu_BranchDB);

        mnu_CentralDB.setText("Connect to Central Database");
        mnu_CentralDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_CentralDBActionPerformed(evt);
            }
        });
        mnu_Connect.add(mnu_CentralDB);

        mnu_logOut.setText("Log out");
        mnu_logOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_logOutActionPerformed(evt);
            }
        });
        mnu_Connect.add(mnu_logOut);

        jMenuBar1.add(mnu_Connect);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jSeparator1)
                        .addComponent(pnl_orders, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_logIn, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_logIn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_orders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_logInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logInActionPerformed
        logInEmployee(jTextField1.getText(), jTextField2.getText());
    }//GEN-LAST:event_btn_logInActionPerformed

    private void btn_firstOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_firstOrderActionPerformed
        
    }//GEN-LAST:event_btn_firstOrderActionPerformed

    private void mnu_BranchDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_BranchDBActionPerformed
        
    }//GEN-LAST:event_mnu_BranchDBActionPerformed

    private void mnu_CentralDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_CentralDBActionPerformed
        
    }//GEN-LAST:event_mnu_CentralDBActionPerformed

    private void mnu_logOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_logOutActionPerformed
        
    }//GEN-LAST:event_mnu_logOutActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(branchClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(branchClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(branchClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(branchClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new branchClient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_LatestOrder;
    private javax.swing.JToggleButton btn_firstOrder;
    private javax.swing.JButton btn_logIn;
    private javax.swing.JButton btn_nextOrder;
    private javax.swing.JToggleButton btn_previousOrder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JMenuItem mnu_BranchDB;
    private javax.swing.JMenuItem mnu_CentralDB;
    private javax.swing.JMenu mnu_Connect;
    private javax.swing.JMenuItem mnu_logOut;
    private javax.swing.JPanel pnl_orders;
    private javax.swing.JTable tbl_orderItems;
    private javax.swing.JTextField txt_fullAddress;
    private javax.swing.JTextField txt_fullName;
    private javax.swing.JTextField txt_orderID;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables

    private static boolean logInEmployee(java.lang.String empId, java.lang.String empPin) {
        com.orders.OrdersWS_Service service = new com.orders.OrdersWS_Service();
        com.orders.OrdersWS port = service.getOrdersWSPort();
        return port.logInEmployee(empId, empPin);
    }
}