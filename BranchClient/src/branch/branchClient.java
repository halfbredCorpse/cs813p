package branch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class branchClient extends javax.swing.JFrame {
    boolean loggedIn = false;
    ResultSet orders, currentOrder, userInfo, userAddress, orderDetails, bookDetails;
    final String CENTRAL_DB_URL, BRANCH_DB_URL;
    final String LOG_IN_QUERY = "SELECT * FROM employees WHERE emp_id=? AND emp_pin=?",
                 FETCH_ORDER_QUERY = "SELECT * FROM orders",
                 SEARCH_ORDER_QUERY = "SELECT * FROM orders WHERE order_id=?",
                 FETCH_USER_INFO_QUERY = "SELECT * FROM accounts WHERE username=?",
                 FETCH_USER_ADDRESS_QUERY = "SELECT * FROM address WHERE address_id=? AND username=?",
                 FETCH_ORDER_DETAILS_QUERY = "SELECT * FROM details WHERE details_id=? AND order_id=?",
                 FETCH_BOOK_DETAILS_QUERY = "SELECT * FROM books WHERE isbn=?",
                 UPDATE_ORDER_QUERY = "UPDATE details SET processed=? WHERE details_id=? AND order_id=?",
                 COMPLETE_ORDER_QUERY = "UPDATE orders SET order_status=1 WHERE order_id=?",
                 LOCALHOST_URL = "localhost:3306/",
                 PELIPAS_URL = "10.1.14.218:3306/",
                 DB_USERNAME = "root",
                 DB_PASSWORD = "";

    /**
     * Creates new form branchClient
     */
    public branchClient() {
        this.CENTRAL_DB_URL = "jdbc:mysql://" + LOCALHOST_URL + "central";
        this.BRANCH_DB_URL = "jdbc:mysql://" + LOCALHOST_URL + "branch";
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_empId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_empPin = new javax.swing.JTextField();
        btn_logIn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        pnl_orders = new javax.swing.JPanel();
        btn_firstOrder = new javax.swing.JToggleButton();
        btn_previousOrder = new javax.swing.JToggleButton();
        txt_orderID = new javax.swing.JTextField();
        btn_nextOrder = new javax.swing.JButton();
        btn_lastOrder = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_orderItems = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txt_fullName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_fullAddress = new javax.swing.JTextField();
        btn_completeOrder = new javax.swing.JToggleButton();
        btn_updateOrder = new javax.swing.JToggleButton();
        btn_logOut = new javax.swing.JToggleButton();
        jLabel7 = new javax.swing.JLabel();
        txt_searchOrder = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnu_refreshOrders = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel1.setText("Book-O Shack");

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        jLabel2.setText("Employee ID: ");

        txt_empId.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        jLabel3.setText("PIN: ");

        txt_empPin.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N

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

        btn_firstOrder.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        btn_firstOrder.setText("<<");
        btn_firstOrder.setEnabled(false);
        btn_firstOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_firstOrderActionPerformed(evt);
            }
        });

        btn_previousOrder.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        btn_previousOrder.setText("<");
        btn_previousOrder.setEnabled(false);
        btn_previousOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_previousOrderActionPerformed(evt);
            }
        });

        txt_orderID.setEditable(false);
        txt_orderID.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        txt_orderID.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Order ID: "), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Rounded MT Bold", 0, 11))); // NOI18N
        txt_orderID.setEnabled(false);

        btn_nextOrder.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        btn_nextOrder.setText(">");
        btn_nextOrder.setEnabled(false);
        btn_nextOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextOrderActionPerformed(evt);
            }
        });

        btn_lastOrder.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        btn_lastOrder.setText(">>");
        btn_lastOrder.setEnabled(false);
        btn_lastOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lastOrderActionPerformed(evt);
            }
        });

        tbl_orderItems.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        tbl_orderItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ISBN", "Title", "Quantity", "Processed"
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
        tbl_orderItems.setEnabled(false);
        jScrollPane2.setViewportView(tbl_orderItems);

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        jLabel4.setText("Full Name: ");

        txt_fullName.setEditable(false);
        txt_fullName.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        jLabel5.setText("Username:");

        txt_username.setEditable(false);
        txt_username.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        jLabel6.setText("Full Address: ");

        txt_fullAddress.setEditable(false);
        txt_fullAddress.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N

        btn_completeOrder.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        btn_completeOrder.setText("Complete Order");
        btn_completeOrder.setEnabled(false);
        btn_completeOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_completeOrderActionPerformed(evt);
            }
        });

        btn_updateOrder.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        btn_updateOrder.setText("Update Order");
        btn_updateOrder.setEnabled(false);
        btn_updateOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateOrderActionPerformed(evt);
            }
        });

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_lastOrder))
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
                        .addComponent(btn_updateOrder)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_completeOrder)))
                .addContainerGap())
        );
        pnl_ordersLayout.setVerticalGroup(
            pnl_ordersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_ordersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_ordersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_orderID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_nextOrder)
                    .addComponent(btn_lastOrder)
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
                    .addComponent(btn_completeOrder)
                    .addComponent(btn_updateOrder))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_logOut.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        btn_logOut.setText("Log Out");
        btn_logOut.setEnabled(false);
        btn_logOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logOutActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        jLabel7.setText("Search Order: ");

        txt_searchOrder.setEnabled(false);

        btn_search.setText("Search");
        btn_search.setEnabled(false);
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        jMenu1.setText("Orders");
        jMenu1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N

        mnu_refreshOrders.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        mnu_refreshOrders.setText("Refresh Orders");
        mnu_refreshOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_refreshOrdersActionPerformed(evt);
            }
        });
        jMenu1.add(mnu_refreshOrders);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1)
                            .addComponent(pnl_orders, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_empId, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_empPin, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_logIn, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn_logOut, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_searchOrder)
                        .addGap(18, 18, 18)
                        .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_empId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txt_empPin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_logIn)
                    .addComponent(btn_logOut))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_searchOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_search))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_orders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_logInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logInActionPerformed
        try {
            // Check if emp_id exists in "employees" table, "branch" database with matching emp_pin
            // Start of LogInEmployee Web Service   ****        To be removed when implementing web service
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager.getConnection(BRANCH_DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement prepState = connect.prepareCall(LOG_IN_QUERY);
            prepState.setString(1, txt_empId.getText());
            prepState.setString(2, txt_empPin.getText());
            // End of LogInEmployee Web Service     ****
            
            ResultSet result = prepState.executeQuery(); // logIn(txt_empId.getText(), txt_empPin.getText())
            
            // If emp_id exists w/ matching emp_pin, continue
            // Else Popup error message
            if (result.next()) {
                JOptionPane.showMessageDialog(null, "Successful log in! Orders have been fetched.");
                
                // Deactivate Log in
                // Activate Log out
                txt_empId.setEnabled(false);
                txt_empPin.setEnabled(false);
                btn_logIn.setEnabled(false);    
                btn_logOut.setEnabled(true);
                loggedIn = true;
                
                // Fetch branch orders from "orders" table, "branch" database
                // Start of FetchOrders Web Service     ****        To be removed when implementing web service
                Class.forName("com.mysql.jdbc.Driver");
                connect = DriverManager.getConnection(BRANCH_DB_URL, DB_USERNAME, DB_PASSWORD);
                prepState = connect.prepareStatement(FETCH_ORDER_QUERY);
                // End of FetchOrders Web Service       ****
                
                orders = prepState.executeQuery();      // fetchOrders()
                
                // Places the first order on the screen
                orders.first();
                txt_orderID.setText(orders.getString("order_id"));
                
                // Searches for first order from "orders" table, "central" database
                // Start of SearchOrder Web Service     ****        To be removed when implementing web service
                Class.forName("com.mysql.jdbc.Driver");
                connect = DriverManager.getConnection(CENTRAL_DB_URL, DB_USERNAME, DB_PASSWORD);
                prepState = connect.prepareStatement(SEARCH_ORDER_QUERY);
                prepState.setString(1, txt_orderID.getText());
                // End of SearchOrder Web Service       ****
                
                currentOrder = prepState.executeQuery(); // searchOrder(txt_orderID.getText())
                
                // Fetch user information from "accounts" table, "central" database
                // Start of FetchUserInfo Web Service
                Class.forName("com.mysql.jdbc.Driver");
                connect = DriverManager.getConnection(CENTRAL_DB_URL, DB_USERNAME, DB_PASSWORD);
                prepState = connect.prepareStatement(FETCH_USER_INFO_QUERY);
                prepState.setString(1, currentOrder.getString("username"));
                // End of FetchUserInfo Web Service
                
                userInfo = prepState.executeQuery();    // fetchUserInfo(currentOrder.getString("username"))
                txt_fullName.setText(userInfo.getString("last_name") + ", " + userInfo.getString("first_name"));
                txt_username.setText(userInfo.getString("username"));
                
                // Fetch user address information from "address" table, "central" database
                // Start of FetchUserAddress Web Service
                Class.forName("com.mysql.jdbc.Driver");
                connect = DriverManager.getConnection(CENTRAL_DB_URL, DB_USERNAME, DB_PASSWORD);
                prepState = connect.prepareStatement(FETCH_USER_ADDRESS_QUERY);
                prepState.setString(1, userInfo.getString("address_id"));
                prepState.setString(2, userInfo.getString("username"));
                // End of FetchUserAddress Web Service
                
                userAddress = prepState.executeQuery(); // fetchUserAddres(userInfo.getString("address_id"))
                
                // Concatenate all user address information and place into Full Address text field
                txt_fullAddress.setText(userAddress.getString("streed_add") + ", " + userAddress.getString("city") + ", " 
                        + userAddress.getString("province") + ", " + userAddress.getString("zip"));
                
                // List down order details in Order Details table
                // Start of FetchOrderDetails Web Service
                Class.forName("com.mysql.jdbc.Driver");
                connect = DriverManager.getConnection(CENTRAL_DB_URL, DB_USERNAME, DB_PASSWORD);
                prepState = connect.prepareStatement(FETCH_ORDER_DETAILS_QUERY);
                prepState.setString(1, currentOrder.getString("details_id"));
                prepState.setString(2, currentOrder.getString("order_id"));
                // End of FetchOrderDetails Web Service
                
                orderDetails = prepState.executeQuery();    // fetchOrderDetails(userInfo.getString("details_id"))
                orderDetails.first();
                
                DefaultTableModel table = (DefaultTableModel) tbl_orderItems.getModel();
                do {
                    boolean processed;  // True if order item has been processed; Else, false
                    
                    // Fetch book details from "books" table, "central" database
                    // Start of FetchBookDetails Web Service
                    Class.forName("com.mysql.jdbc.Driver");
                    connect = DriverManager.getConnection(CENTRAL_DB_URL, DB_USERNAME, DB_PASSWORD);
                    prepState = connect.prepareStatement(FETCH_BOOK_DETAILS_QUERY);
                    prepState.setString(1, orderDetails.getString("isbn"));
                    // End of FetchBookDetails Web Service
                    
                    orderDetails = prepState.executeQuery(); // fetchBookDetails(orderDetails.getString("isbn"))
                    
                    // Sets Order Items checkbox as unchecked if processed == 0, else checked
                    if (bookDetails.getInt("processed") == 0)
                        processed = false;
                    else
                        processed = true;
                    
                    // Displays order item details as each row in Order Items table
                    Object[] data = {orderDetails.getString("isbn"), bookDetails.getString("title"), orderDetails.getString("quantity"),
                        orderDetails.getString("quantity"), processed};
                    table.addRow(data);
                } while (orderDetails.next());
                
                txt_searchOrder.setEnabled(true);
                btn_search.setEnabled(true);
                btn_firstOrder.setEnabled(true);
                btn_previousOrder.setEnabled(true);
                btn_nextOrder.setEnabled(true);
                btn_lastOrder.setEnabled(true);
                tbl_orderItems.setEnabled(true);
                btn_updateOrder.setEnabled(true);
                btn_completeOrder.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, "Illegal log in! Please input correct credentials.");
                txt_empId.setText("");
                txt_empPin.setText("");
            }

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btn_logInActionPerformed

    private void btn_firstOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_firstOrderActionPerformed
        try {
            // Displays the first order among the list of orders
            orders.first();
            txt_orderID.setText(orders.getString("order_id"));
            
            // Deletes all rows of the Order Items table to make way for different order
            DefaultTableModel table = (DefaultTableModel) tbl_orderItems.getModel();
            int rows = table.getRowCount();
            for (int i = rows-1; i >= 0; i--)
                table.removeRow(i);
            
            // Searches for first order from "orders" table, "central" database
            // Start of SearchOrder Web Service     ****        To be removed when implementing web service
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager.getConnection(CENTRAL_DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement prepState = connect.prepareStatement(SEARCH_ORDER_QUERY);
            prepState.setString(1, txt_orderID.getText());
            // End of SearchOrder Web Service       ****

            currentOrder = prepState.executeQuery(); // searchOrder(txt_orderID.getText())

            // Fetch user information from "accounts" table, "central" database
            // Start of FetchUserInfo Web Service
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(CENTRAL_DB_URL, DB_USERNAME, DB_PASSWORD);
            prepState = connect.prepareStatement(FETCH_USER_INFO_QUERY);
            prepState.setString(1, currentOrder.getString("username"));
            // End of FetchUserInfo Web Service

            userInfo = prepState.executeQuery();    // fetchUserInfo(currentOrder.getString("username"))
            txt_fullName.setText(userInfo.getString("last_name") + ", " + userInfo.getString("first_name"));
            txt_username.setText(userInfo.getString("username"));

            // Fetch user address information from "address" table, "central" database
            // Start of FetchUserAddress Web Service
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(CENTRAL_DB_URL, DB_USERNAME, DB_PASSWORD);
            prepState = connect.prepareStatement(FETCH_USER_ADDRESS_QUERY);
            prepState.setString(1, userInfo.getString("address_id"));
            prepState.setString(2, userInfo.getString("username"));
            // End of FetchUserAddress Web Service

            userAddress = prepState.executeQuery(); // fetchUserAddres(userInfo.getString("address_id"))

            // Concatenate all user address information and place into Full Address text field
            txt_fullAddress.setText(userAddress.getString("streed_add") + ", " + userAddress.getString("city") + ", " 
                    + userAddress.getString("province") + ", " + userAddress.getString("zip"));

            // List down order details in Order Details table
            // Start of FetchOrderDetails Web Service
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(CENTRAL_DB_URL, DB_USERNAME, DB_PASSWORD);
            prepState = connect.prepareStatement(FETCH_ORDER_DETAILS_QUERY);
            prepState.setString(1, currentOrder.getString("details_id"));
            prepState.setString(2, currentOrder.getString("order_id"));
            // End of FetchOrderDetails Web Service

            orderDetails = prepState.executeQuery();    // fetchOrderDetails(userInfo.getString("details_id"))
            orderDetails.first();

            do {
                boolean processed;  // True if order item has been processed; Else, false

                // Fetch book details from "books" table, "central" database
                // Start of FetchBookDetails Web Service
                Class.forName("com.mysql.jdbc.Driver");
                connect = DriverManager.getConnection(CENTRAL_DB_URL, DB_USERNAME, DB_PASSWORD);
                prepState = connect.prepareStatement(FETCH_BOOK_DETAILS_QUERY);
                prepState.setString(1, orderDetails.getString("isbn"));
                // End of FetchBookDetails Web Service

                orderDetails = prepState.executeQuery(); // fetchBookDetails(orderDetails.getString("isbn"))

                // Sets Order Items checkbox as unchecked if processed == 0, else checked
                if (bookDetails.getInt("processed") == 0)
                    processed = false;
                else
                    processed = true;

                // Displays order item details as each row in Order Items table
                Object[] data = {orderDetails.getString("isbn"), bookDetails.getString("title"), orderDetails.getString("quantity"),
                    orderDetails.getString("quantity"), processed};
                table.addRow(data);
            } while (orderDetails.next());
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btn_firstOrderActionPerformed

    private void btn_logOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logOutActionPerformed
        // "Logs out" employee
        loggedIn = false;
        txt_empId.setText("");
        txt_empId.setEnabled(true);
        txt_empPin.setText("");
        txt_empPin.setEnabled(true);
        btn_logIn.setEnabled(true);    
        btn_logOut.setEnabled(false);
        
        txt_searchOrder.setEnabled(true);
        btn_search.setEnabled(true);
        btn_firstOrder.setEnabled(true);
        btn_previousOrder.setEnabled(true);
        btn_nextOrder.setEnabled(true);
        btn_lastOrder.setEnabled(true);
        tbl_orderItems.setEnabled(true);
        btn_updateOrder.setEnabled(true);
        btn_completeOrder.setEnabled(true);
    }//GEN-LAST:event_btn_logOutActionPerformed

    private void mnu_refreshOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_refreshOrdersActionPerformed
        // Verify if logged in 
        // Pop up message if not logged in; else, refresh orders
        if (loggedIn) {
            try {
                // Start of FetchOrders Web Service     ****
                Class.forName("com.mysql.jdbc.Driver");
                Connection connect = DriverManager.getConnection(BRANCH_DB_URL, DB_USERNAME, DB_PASSWORD);
                PreparedStatement prepState = connect.prepareStatement(FETCH_ORDER_QUERY);
                // End of FetchOrders Web Service       ****

                orders = prepState.executeQuery();      // Replace prepState w/ FetchOrders() function call
                orders.first();
                txt_orderID.setText(orders.getString("order_id"));
            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        } else
            JOptionPane.showMessageDialog(null, "Please log in first before refreshing current list of orders!");
    }//GEN-LAST:event_mnu_refreshOrdersActionPerformed

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        try {
            // Searches for typed orderId from "orders" table, "central" database
            // Start of SearchOrder Web Service     ****        To be removed when implementing web service
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager.getConnection(CENTRAL_DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement prepState = connect.prepareStatement(SEARCH_ORDER_QUERY);
            prepState.setString(1, txt_searchOrder.getText());
            // End of SearchOrder Web Service       ****

            currentOrder = prepState.executeQuery(); // searchOrder(txt_orderID.getText())

            if (currentOrder.next()) {
                // Deletes all rows of the Order Items table to make way for different order
                DefaultTableModel table = (DefaultTableModel) tbl_orderItems.getModel();
                int rows = table.getRowCount();
                for (int i = rows-1; i >= 0; i--)
                    table.removeRow(i);
                
                // Fetch user information from "accounts" table, "central" database
                // Start of FetchUserInfo Web Service
                Class.forName("com.mysql.jdbc.Driver");
                connect = DriverManager.getConnection(CENTRAL_DB_URL, DB_USERNAME, DB_PASSWORD);
                prepState = connect.prepareStatement(FETCH_USER_INFO_QUERY);
                prepState.setString(1, currentOrder.getString("username"));
                // End of FetchUserInfo Web Service

                userInfo = prepState.executeQuery();    // fetchUserInfo(currentOrder.getString("username"))
                txt_fullName.setText(userInfo.getString("last_name") + ", " + userInfo.getString("first_name"));
                txt_username.setText(userInfo.getString("username"));

                // Fetch user address information from "address" table, "central" database
                // Start of FetchUserAddress Web Service
                Class.forName("com.mysql.jdbc.Driver");
                connect = DriverManager.getConnection(CENTRAL_DB_URL, DB_USERNAME, DB_PASSWORD);
                prepState = connect.prepareStatement(FETCH_USER_ADDRESS_QUERY);
                prepState.setString(1, userInfo.getString("address_id"));
                prepState.setString(2, userInfo.getString("username"));
                // End of FetchUserAddress Web Service

                userAddress = prepState.executeQuery(); // fetchUserAddres(userInfo.getString("address_id"))

                // Concatenate all user address information and place into Full Address text field
                txt_fullAddress.setText(userAddress.getString("streed_add") + ", " + userAddress.getString("city") + ", " 
                        + userAddress.getString("province") + ", " + userAddress.getString("zip"));

                // List down order details in Order Details table
                // Start of FetchOrderDetails Web Service
                Class.forName("com.mysql.jdbc.Driver");
                connect = DriverManager.getConnection(CENTRAL_DB_URL, DB_USERNAME, DB_PASSWORD);
                prepState = connect.prepareStatement(FETCH_ORDER_DETAILS_QUERY);
                prepState.setString(1, currentOrder.getString("details_id"));
                prepState.setString(2, currentOrder.getString("order_id"));
                // End of FetchOrderDetails Web Service

                orderDetails = prepState.executeQuery();    // fetchOrderDetails(userInfo.getString("details_id"))
                orderDetails.first();

                do {
                    boolean processed;  // True if order item has been processed; Else, false

                    // Fetch book details from "books" table, "central" database
                    // Start of FetchBookDetails Web Service
                    Class.forName("com.mysql.jdbc.Driver");
                    connect = DriverManager.getConnection(CENTRAL_DB_URL, DB_USERNAME, DB_PASSWORD);
                    prepState = connect.prepareStatement(FETCH_BOOK_DETAILS_QUERY);
                    prepState.setString(1, orderDetails.getString("isbn"));
                    // End of FetchBookDetails Web Service

                    orderDetails = prepState.executeQuery(); // fetchBookDetails(orderDetails.getString("isbn"))

                    // Sets Order Items checkbox as unchecked if processed == 0, else checked
                    if (bookDetails.getInt("processed") == 0)
                        processed = false;
                    else
                        processed = true;

                    // Displays order item details as each row in Order Items table
                    Object[] data = {orderDetails.getString("isbn"), bookDetails.getString("title"), orderDetails.getString("quantity"),
                        orderDetails.getString("quantity"), processed};
                    table.addRow(data);
                } while (orderDetails.next());
            } else {
                JOptionPane.showMessageDialog(null, "Order does not exist!");
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btn_searchActionPerformed

    private void btn_previousOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_previousOrderActionPerformed
        try {
            // Verify if current order is already first order
            // If current order is first order, pop up message; Else, continue and display order details
            if (orders.previous()) {
                txt_orderID.setText(orders.getString("order_id"));
            
                // Deletes all rows of the Order Items table to make way for different order
                DefaultTableModel table = (DefaultTableModel) tbl_orderItems.getModel();
                int rows = table.getRowCount();
                for (int i = rows-1; i >= 0; i--)
                    table.removeRow(i);
                
                // Fetch user information from "accounts" table, "central" database
                // Start of FetchUserInfo Web Service
                Class.forName("com.mysql.jdbc.Driver");
                Connection connect = DriverManager.getConnection(CENTRAL_DB_URL, DB_USERNAME, DB_PASSWORD);
                PreparedStatement prepState = connect.prepareStatement(FETCH_USER_INFO_QUERY);
                prepState.setString(1, currentOrder.getString("username"));
                // End of FetchUserInfo Web Service

                userInfo = prepState.executeQuery();    // fetchUserInfo(currentOrder.getString("username"))
                txt_fullName.setText(userInfo.getString("last_name") + ", " + userInfo.getString("first_name"));
                txt_username.setText(userInfo.getString("username"));

                // Fetch user address information from "address" table, "central" database
                // Start of FetchUserAddress Web Service
                Class.forName("com.mysql.jdbc.Driver");
                connect = DriverManager.getConnection(CENTRAL_DB_URL, DB_USERNAME, DB_PASSWORD);
                prepState = connect.prepareStatement(FETCH_USER_ADDRESS_QUERY);
                prepState.setString(1, userInfo.getString("address_id"));
                prepState.setString(2, userInfo.getString("username"));
                // End of FetchUserAddress Web Service

                userAddress = prepState.executeQuery(); // fetchUserAddres(userInfo.getString("address_id"))

                // Concatenate all user address information and place into Full Address text field
                txt_fullAddress.setText(userAddress.getString("streed_add") + ", " + userAddress.getString("city") + ", " 
                        + userAddress.getString("province") + ", " + userAddress.getString("zip"));

                // List down order details in Order Details table
                // Start of FetchOrderDetails Web Service
                Class.forName("com.mysql.jdbc.Driver");
                connect = DriverManager.getConnection(CENTRAL_DB_URL, DB_USERNAME, DB_PASSWORD);
                prepState = connect.prepareStatement(FETCH_ORDER_DETAILS_QUERY);
                prepState.setString(1, currentOrder.getString("details_id"));
                prepState.setString(2, currentOrder.getString("order_id"));
                // End of FetchOrderDetails Web Service

                orderDetails = prepState.executeQuery();    // fetchOrderDetails(userInfo.getString("details_id"))
                orderDetails.first();

                do {
                    boolean processed;  // True if order item has been processed; Else, false

                    // Fetch book details from "books" table, "central" database
                    // Start of FetchBookDetails Web Service
                    Class.forName("com.mysql.jdbc.Driver");
                    connect = DriverManager.getConnection(CENTRAL_DB_URL, DB_USERNAME, DB_PASSWORD);
                    prepState = connect.prepareStatement(FETCH_BOOK_DETAILS_QUERY);
                    prepState.setString(1, orderDetails.getString("isbn"));
                    // End of FetchBookDetails Web Service

                    orderDetails = prepState.executeQuery(); // fetchBookDetails(orderDetails.getString("isbn"))

                    // Sets Order Items checkbox as unchecked if processed == 0, else checked
                    if (bookDetails.getInt("processed") == 0)
                        processed = false;
                    else
                        processed = true;

                    // Displays order item details as each row in Order Items table
                    Object[] data = {orderDetails.getString("isbn"), bookDetails.getString("title"), orderDetails.getString("quantity"),
                        orderDetails.getString("quantity"), processed};
                    table.addRow(data);
                } while (orderDetails.next());
            } else
                JOptionPane.showMessageDialog(null, "This is already the first order!");
            
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btn_previousOrderActionPerformed

    private void btn_nextOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextOrderActionPerformed
        try {
            // Verify if current order is last order
            // If current order is last order, pop up message; Else, continue and display
            if (orders.next()) {
                txt_orderID.setText(orders.getString("order_id"));

                // Deletes all rows of the Order Items table to make way for different order
                DefaultTableModel table = (DefaultTableModel) tbl_orderItems.getModel();
                int rows = table.getRowCount();
                for (int i = rows-1; i >= 0; i--)
                    table.removeRow(i);
                
                // Fetch user information from "accounts" table, "central" database
                // Start of FetchUserInfo Web Service
                Class.forName("com.mysql.jdbc.Driver");
                Connection connect = DriverManager.getConnection(CENTRAL_DB_URL, DB_USERNAME, DB_PASSWORD);
                PreparedStatement prepState = connect.prepareStatement(FETCH_USER_INFO_QUERY);
                prepState.setString(1, currentOrder.getString("username"));
                // End of FetchUserInfo Web Service

                userInfo = prepState.executeQuery();    // fetchUserInfo(currentOrder.getString("username"))
                txt_fullName.setText(userInfo.getString("last_name") + ", " + userInfo.getString("first_name"));
                txt_username.setText(userInfo.getString("username"));

                // Fetch user address information from "address" table, "central" database
                // Start of FetchUserAddress Web Service
                Class.forName("com.mysql.jdbc.Driver");
                connect = DriverManager.getConnection(CENTRAL_DB_URL, DB_USERNAME, DB_PASSWORD);
                prepState = connect.prepareStatement(FETCH_USER_ADDRESS_QUERY);
                prepState.setString(1, userInfo.getString("address_id"));
                prepState.setString(2, userInfo.getString("username"));
                // End of FetchUserAddress Web Service

                userAddress = prepState.executeQuery(); // fetchUserAddres(userInfo.getString("address_id"))

                // Concatenate all user address information and place into Full Address text field
                txt_fullAddress.setText(userAddress.getString("streed_add") + ", " + userAddress.getString("city") + ", " 
                        + userAddress.getString("province") + ", " + userAddress.getString("zip"));

                // List down order details in Order Details table
                // Start of FetchOrderDetails Web Service
                Class.forName("com.mysql.jdbc.Driver");
                connect = DriverManager.getConnection(CENTRAL_DB_URL, DB_USERNAME, DB_PASSWORD);
                prepState = connect.prepareStatement(FETCH_ORDER_DETAILS_QUERY);
                prepState.setString(1, currentOrder.getString("details_id"));
                prepState.setString(2, currentOrder.getString("order_id"));
                // End of FetchOrderDetails Web Service

                orderDetails = prepState.executeQuery();    // fetchOrderDetails(userInfo.getString("details_id"))
                orderDetails.first();

                do {
                    boolean processed;  // True if order item has been processed; Else, false

                    // Fetch book details from "books" table, "central" database
                    // Start of FetchBookDetails Web Service
                    Class.forName("com.mysql.jdbc.Driver");
                    connect = DriverManager.getConnection(CENTRAL_DB_URL, DB_USERNAME, DB_PASSWORD);
                    prepState = connect.prepareStatement(FETCH_BOOK_DETAILS_QUERY);
                    prepState.setString(1, orderDetails.getString("isbn"));
                    // End of FetchBookDetails Web Service

                    orderDetails = prepState.executeQuery(); // fetchBookDetails(orderDetails.getString("isbn"))

                    // Sets Order Items checkbox as unchecked if processed == 0, else checked
                    if (bookDetails.getInt("processed") == 0)
                        processed = false;
                    else
                        processed = true;

                    // Displays order item details as each row in Order Items table
                    Object[] data = {orderDetails.getString("isbn"), bookDetails.getString("title"), orderDetails.getString("quantity"),
                        orderDetails.getString("quantity"), processed};
                    table.addRow(data);
                } while (orderDetails.next());
            } else
                JOptionPane.showMessageDialog(null, "This is already the last order!");
                
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btn_nextOrderActionPerformed

    private void btn_lastOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lastOrderActionPerformed
        try {
            // Displays the last order among list of orders
            orders.last();
            txt_orderID.setText(orders.getString("order_id"));
            
            // Deletes all rows of the Order Items table to make way for different order
            DefaultTableModel table = (DefaultTableModel) tbl_orderItems.getModel();
            int rows = table.getRowCount();
            for (int i = rows-1; i >= 0; i--)
                table.removeRow(i);

            // Fetch user information from "accounts" table, "central" database
            // Start of FetchUserInfo Web Service
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager.getConnection(CENTRAL_DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement prepState = connect.prepareStatement(FETCH_USER_INFO_QUERY);
            prepState.setString(1, currentOrder.getString("username"));
            // End of FetchUserInfo Web Service

            userInfo = prepState.executeQuery();    // fetchUserInfo(currentOrder.getString("username"))
            txt_fullName.setText(userInfo.getString("last_name") + ", " + userInfo.getString("first_name"));
            txt_username.setText(userInfo.getString("username"));

            // Fetch user address information from "address" table, "central" database
            // Start of FetchUserAddress Web Service
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(CENTRAL_DB_URL, DB_USERNAME, DB_PASSWORD);
            prepState = connect.prepareStatement(FETCH_USER_ADDRESS_QUERY);
            prepState.setString(1, userInfo.getString("address_id"));
            prepState.setString(2, userInfo.getString("username"));
            // End of FetchUserAddress Web Service

            userAddress = prepState.executeQuery(); // fetchUserAddres(userInfo.getString("address_id"))

            // Concatenate all user address information and place into Full Address text field
            txt_fullAddress.setText(userAddress.getString("streed_add") + ", " + userAddress.getString("city") + ", " 
                    + userAddress.getString("province") + ", " + userAddress.getString("zip"));

            // List down order details in Order Details table
            // Start of FetchOrderDetails Web Service
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(CENTRAL_DB_URL, DB_USERNAME, DB_PASSWORD);
            prepState = connect.prepareStatement(FETCH_ORDER_DETAILS_QUERY);
            prepState.setString(1, currentOrder.getString("details_id"));
            prepState.setString(2, currentOrder.getString("order_id"));
            // End of FetchOrderDetails Web Service

            orderDetails = prepState.executeQuery();    // fetchOrderDetails(userInfo.getString("details_id"))
            orderDetails.first();

            do {
                boolean processed;  // True if order item has been processed; Else, false

                // Fetch book details from "books" table, "central" database
                // Start of FetchBookDetails Web Service
                Class.forName("com.mysql.jdbc.Driver");
                connect = DriverManager.getConnection(CENTRAL_DB_URL, DB_USERNAME, DB_PASSWORD);
                prepState = connect.prepareStatement(FETCH_BOOK_DETAILS_QUERY);
                prepState.setString(1, orderDetails.getString("isbn"));
                // End of FetchBookDetails Web Service

                orderDetails = prepState.executeQuery(); // fetchBookDetails(orderDetails.getString("isbn"))

                // Sets Order Items checkbox as unchecked if processed == 0, else checked
                if (bookDetails.getInt("processed") == 0)
                    processed = false;
                else
                    processed = true;

                // Displays order item details as each row in Order Items table
                Object[] data = {orderDetails.getString("isbn"), bookDetails.getString("title"), orderDetails.getString("quantity"),
                    orderDetails.getString("quantity"), processed};
                table.addRow(data);
            } while (orderDetails.next());
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btn_lastOrderActionPerformed

    private void btn_updateOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateOrderActionPerformed
        try {
            orderDetails.first();
            int goodChanges = 0;
            
            do {
                DefaultTableModel table = (DefaultTableModel) tbl_orderItems.getModel();
                boolean processed = (boolean) table.getValueAt(orderDetails.getRow() - 1, 4);
                
                // Start of UpdateOrder Web Service     ****
                Class.forName("com.mysql.jdbc.Driver");
                Connection connect = DriverManager.getConnection(CENTRAL_DB_URL, DB_USERNAME, DB_PASSWORD);
                PreparedStatement prepState = connect.prepareStatement(UPDATE_ORDER_QUERY);
                
                if (processed)
                    prepState.setInt(1, 1);
                else
                    prepState.setInt(1, 0);
                
                prepState.setString(2, orderDetails.getString("details_id"));
                prepState.setString(3, orderDetails.getString("order_id"));
                if (prepState.executeUpdate() != 0)
                    goodChanges++;
                // End of UpdateOrder Web Service   ****
            } while (orderDetails.next());
            
            if (goodChanges == orderDetails.getRow())
                JOptionPane.showMessageDialog(null, "All order items have been updated!");
            else if (goodChanges == 0)
                JOptionPane.showMessageDialog(null, "Unsuccessful update of details for order items!");
            else
                JOptionPane.showMessageDialog(null, goodChanges + "out of " + orderDetails.getRow() + " were successfully updated! Please verify changes to"
                    + " avoid errors");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btn_updateOrderActionPerformed

    private void btn_completeOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_completeOrderActionPerformed
        try {
            boolean allProcessed = true;
            DefaultTableModel table = (DefaultTableModel) tbl_orderItems.getModel();
            
            for (int i = 0; i < table.getRowCount(); i++) {
                boolean processed = (boolean) table.getValueAt(i, 4);
                
                if (!processed) {
                    allProcessed = false;
                    break;
                }
            }
            
            
            if (allProcessed) { // Check if all of the order_items have checked Processed attribute
                //Start of CompleteOrder Web Service
                Class.forName("com.mysql.jdbc.Driver");
                Connection connect = DriverManager.getConnection(CENTRAL_DB_URL, DB_USERNAME, DB_PASSWORD);
                PreparedStatement prepState = connect.prepareStatement(COMPLETE_ORDER_QUERY);
                prepState.setString(1, txt_orderID.getText());
                prepState.executeUpdate();
                JOptionPane.showMessageDialog(null, "Order has been completely processed! It is now ready to be shipped.");
                //End of CompleteOrder Web Service
            } else
                JOptionPane.showMessageDialog(null, "Not all order items have been processed! Please make sure all items have been processed.");
        }
        catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btn_completeOrderActionPerformed

    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new branchClient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btn_completeOrder;
    private javax.swing.JToggleButton btn_firstOrder;
    private javax.swing.JButton btn_lastOrder;
    private javax.swing.JButton btn_logIn;
    private javax.swing.JToggleButton btn_logOut;
    private javax.swing.JButton btn_nextOrder;
    private javax.swing.JToggleButton btn_previousOrder;
    private javax.swing.JButton btn_search;
    private javax.swing.JToggleButton btn_updateOrder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JMenuItem mnu_refreshOrders;
    private javax.swing.JPanel pnl_orders;
    private javax.swing.JTable tbl_orderItems;
    private javax.swing.JTextField txt_empId;
    private javax.swing.JTextField txt_empPin;
    private javax.swing.JTextField txt_fullAddress;
    private javax.swing.JTextField txt_fullName;
    private javax.swing.JTextField txt_orderID;
    private javax.swing.JTextField txt_searchOrder;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables

}