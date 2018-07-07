package com.apple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CasherGUI extends JFrame implements Runnable {

    private int casherId;
    private Connection connection;
    private Statement statement;
    private Vector<String> tableHeader;
    private Vector<String> soldHeader;
    private Vector<OrderDetail> cart;
    private PreparedStatement updateCasher;
    private PreparedStatement selectCasher;
    private PreparedStatement updateCasherPassword;
    private PreparedStatement selectCasherOldPass;

    public CasherGUI(int casherId) {
        try {
            this.casherId = casherId;
            connection = Login.connection;
            statement = connection.createStatement();
            tableHeader = new Vector<>();
            tableHeader.add("Item Name");
            tableHeader.add("Item Quantity");
            tableHeader.add("Item Price");

            soldHeader = new Vector<>();
            soldHeader.add("Item Name");
            soldHeader.add("Order Quantity");
            soldHeader.add("Order Date");

            cart = new Vector();

            selectCasher = connection.prepareStatement("select * from casher where cId = ?");
            updateCasher = connection.prepareStatement("UPDATE casher "
                    + "SET cFirstName = ?,"
                    + "cLastName = ?, "
                    + "cAge = ?, "
                    + "cSex = ?, "
                    + "cPhoneNumber = ?, "
                    + "cEmail = ?"
                    + "WHERE cId = ?");
            selectCasherOldPass = connection.prepareStatement("SELECT * FROM casher where cPassword = ?");
            updateCasherPassword = connection.prepareStatement("update casher "
                    + "set cPassword = ? "
                    + "where cId = ?");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        tab = new javax.swing.JTabbedPane();
        manageCasher = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cartList = new javax.swing.JList();
        jPanel5 = new javax.swing.JPanel();
        orderBtn = new javax.swing.JButton();
        removeBtn = new javax.swing.JButton();
        ClearCartBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listItemTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        searchInput = new javax.swing.JTextField();
        addBtn = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        soldTable = new javax.swing.JTable();
        updateProfile = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        updateFname = new javax.swing.JTextField();
        updateLname = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        updateAge = new javax.swing.JSpinner();
        jLabel20 = new javax.swing.JLabel();
        updateSex = new javax.swing.JComboBox();
        updatePhoneNumber = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        updateEmail = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        changePassword = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        changeNewPassword = new javax.swing.JPasswordField();
        jLabel32 = new javax.swing.JLabel();
        changeConfirmPassword = new javax.swing.JPasswordField();
        jButton6 = new javax.swing.JButton();
        changeOldPassword = new javax.swing.JPasswordField();
        jLabel33 = new javax.swing.JLabel();
        status = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/apple/logo2.png"))); // NOI18N
        logo.setText(" ");

        manageCasher.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                manageCasherComponentShown(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Current Cart", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        cartList.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(cartList);

        orderBtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        orderBtn.setText("Order");
        orderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderBtnActionPerformed(evt);
            }
        });

        removeBtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        removeBtn.setText("Remove");
        removeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeBtnActionPerformed(evt);
            }
        });

        ClearCartBtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ClearCartBtn.setText("Clear Cart");
        ClearCartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearCartBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(orderBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ClearCartBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(removeBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(removeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(ClearCartBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(orderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        listItemTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        listItemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(listItemTable);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Seach item");

        searchInput.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        searchInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchInputKeyReleased(evt);
            }
        });

        addBtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        logout.setText("logout");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logout)
                .addGap(96, 96, 96))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logout)
                .addContainerGap())
        );

        javax.swing.GroupLayout manageCasherLayout = new javax.swing.GroupLayout(manageCasher);
        manageCasher.setLayout(manageCasherLayout);
        manageCasherLayout.setHorizontalGroup(
            manageCasherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageCasherLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );
        manageCasherLayout.setVerticalGroup(
            manageCasherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageCasherLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(manageCasherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 334, Short.MAX_VALUE))
                .addContainerGap())
        );

        tab.addTab("     Sell item   ", manageCasher);

        jPanel4.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel4ComponentShown(evt);
            }
        });

        soldTable.setAutoCreateRowSorter(true);
        soldTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(soldTable);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tab.addTab("Sold item", jPanel4);

        updateProfile.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                updateProfileComponentShown(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Update Profile"));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setText("First Name");

        updateFname.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        updateFname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                updateFnameKeyTyped(evt);
            }
        });

        updateLname.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        updateLname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                updateLnameKeyTyped(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setText("Last Name");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setText("Age");

        updateAge.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        updateAge.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                updateAgeStateChanged(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setText("Sex");

        updateSex.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        updateSex.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));
        updateSex.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                updateSexItemStateChanged(evt);
            }
        });

        updatePhoneNumber.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        updatePhoneNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                updatePhoneNumberKeyTyped(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setText("Phone Number");

        updateEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        updateEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                updateEmailKeyTyped(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel22.setText("Email");

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton5.setText("Update Profile    ");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton5)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(25, 25, 25))
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(jLabel21))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(updateEmail)
                            .addComponent(updateLname)
                            .addComponent(updatePhoneNumber)
                            .addComponent(updateFname, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateAge, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(updateFname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(updateLname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(updatePhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(updateEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(updateSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(updateAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout updateProfileLayout = new javax.swing.GroupLayout(updateProfile);
        updateProfile.setLayout(updateProfileLayout);
        updateProfileLayout.setHorizontalGroup(
            updateProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateProfileLayout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(205, Short.MAX_VALUE))
        );
        updateProfileLayout.setVerticalGroup(
            updateProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateProfileLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(119, Short.MAX_VALUE))
        );

        tab.addTab("Update Profile", updateProfile);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Update Password"));

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel31.setText("Password");

        changeNewPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                changeNewPasswordKeyTyped(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel32.setText("Confirm Password");

        changeConfirmPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                changeConfirmPasswordKeyTyped(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton6.setText("Change Password   ");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        changeOldPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                changeOldPasswordKeyTyped(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel33.setText("Old Password");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32)
                            .addComponent(jLabel31))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addGap(27, 27, 27)))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(changeOldPassword)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(changeConfirmPassword, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(changeNewPassword))
                .addGap(62, 62, 62))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(changeOldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(changeNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(changeConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6)
                .addGap(54, 54, 54))
        );

        javax.swing.GroupLayout changePasswordLayout = new javax.swing.GroupLayout(changePassword);
        changePassword.setLayout(changePasswordLayout);
        changePasswordLayout.setHorizontalGroup(
            changePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(changePasswordLayout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(186, Short.MAX_VALUE))
        );
        changePasswordLayout.setVerticalGroup(
            changePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(changePasswordLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        tab.addTab("Change Password", changePassword);

        status.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        status.setText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(status, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tab, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(logo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tab, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(status)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void manageCasherComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_manageCasherComponentShown
    }//GEN-LAST:event_manageCasherComponentShown

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        try {
            int selectedRow = listItemTable.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(null, "Select item first!!!", "", JOptionPane.WARNING_MESSAGE);
                return;
            }
            String key = searchInput.getText();
            ResultSet result = statement.executeQuery("SELECT * FROM item where "
                    + "itemQuanity is not null AND "
                    + "itemQuanity > 0 AND "
                    + "itemName like '%" + key + "%'");
            Vector<Vector<String>> data = new Vector<>();
            while (result.next()) {
                Vector<String> row = new Vector<>();
                row.add(result.getString("itemId"));
                row.add(result.getString("itemName"));
                row.add(result.getString("itemQuanity"));
                row.add(result.getString("itemPrice"));
                data.add(row);
            }

            Vector<String> selectItem = data.get(selectedRow);

            String numberS = JOptionPane.showInputDialog(this, "How many " + selectItem.get(1) + " do you want?", "", JOptionPane.QUESTION_MESSAGE);

            int num = Integer.parseInt(numberS);

            OrderDetail newOd = new OrderDetail(Integer.parseInt(selectItem.get(0)),
                    selectItem.get(1), num, Double.parseDouble(selectItem.get(3)));

            boolean inserted = false;

            for (OrderDetail od : cart) {
                if (od.equals(newOd)) {
                    od.numberOfItem += newOd.numberOfItem;
                    inserted = true;
                }
            }
            if (!inserted) {
                cart.add(newOd);
            }

            reloadCart();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_addBtnActionPerformed

    private void searchInputKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchInputKeyReleased
        try {
            String key = searchInput.getText();
            String sql = "SELECT * FROM item where "
                    + "itemQuanity is not null AND "
                    + "itemQuanity > 0 AND "
                    + "itemName like '%" + key + "%'";
            ResultSet result = statement.executeQuery(sql);
            Vector<Vector<String>> data = new Vector();
            while (result.next()) {
                Vector<String> row = new Vector();
                row.add(result.getString("itemName"));
                row.add(result.getString("itemQuanity"));
                row.add(result.getString("itemPrice"));
                data.add(row);
            }
            listItemTable.setModel(new DefaultTableModel(data, tableHeader));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_searchInputKeyReleased

    private void removeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeBtnActionPerformed
        try {
            int selectedIndex = cartList.getSelectedIndex();
            if (selectedIndex < 0) {
                JOptionPane.showMessageDialog(null, "Select item first!!!", "", JOptionPane.WARNING_MESSAGE);
                return;
            }
            cart.remove(selectedIndex);
            reloadCart();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_removeBtnActionPerformed

    private void ClearCartBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearCartBtnActionPerformed
        try {
            cart.clear();
            reloadCart();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_ClearCartBtnActionPerformed

    private void orderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderBtnActionPerformed

        try {

            for (OrderDetail item : cart) {
                if (item.isMoreThanItem()) {
                    JOptionPane.showMessageDialog(null, item.itemName + " exceed from the avalable", "", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
            if (cart.size() <= 0) {
                throw new Exception("Cart is empty!!!");
            }
            String sql = "INSERT into `order`(orderCasherId) values (" + casherId + ") ";
            int rows = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (rows < 0) {
                throw new Exception("Error on ordering!!!");
            }
            ResultSet result = statement.getGeneratedKeys();
            result.next();
            int orderId = result.getInt(1);

            sql = "insert into orderDetail values ";

            for (OrderDetail od : cart) {
                sql += od.toSQL(orderId);
            }
            sql = sql.replaceFirst(",", " ");

            rows = statement.executeUpdate(sql);

            for (OrderDetail od : cart) {
                od.order();
            }

            if (rows > 0) {
                JOptionPane.showMessageDialog(this, rows + " items ordered!!!", "", JOptionPane.INFORMATION_MESSAGE);
                searchInput.setText("");
                cart.clear();
                reloadCart();
                searchInputKeyReleased(null);
            } else {
                throw new Exception("Error on ordering!!!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }

    }//GEN-LAST:event_orderBtnActionPerformed

    private void jPanel4ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel4ComponentShown

        try {
            ResultSet result = statement.executeQuery("SELECT *"
                    + " FROM `order` o, orderDetail od,Item i,Casher c"
                    + " WHERE o.orderId = od.orderId AND "
                    + "      od.itemId = i.itemId AND"
                    + "      o.orderCasherId = c.cId "
                    + " ORDER BY o.orderId DESC");
            Vector<Vector<String>> data = new Vector<>();
            while (result.next()) {
                Vector<String> row = new Vector<>();

                row.add(result.getString("itemName"));
                row.add(result.getString("numberOfItem"));
                row.add(result.getTimestamp("orderDate").toGMTString());

                data.add(row);
            }

            soldTable.setModel(new DefaultTableModel(data, soldHeader));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_jPanel4ComponentShown

    private void updateFnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_updateFnameKeyTyped
        status.setText("");
    }//GEN-LAST:event_updateFnameKeyTyped

    private void updateLnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_updateLnameKeyTyped
        status.setText("");
    }//GEN-LAST:event_updateLnameKeyTyped

    private void updateAgeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_updateAgeStateChanged
        status.setText("");
    }//GEN-LAST:event_updateAgeStateChanged

    private void updateSexItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_updateSexItemStateChanged
        status.setText("");
    }//GEN-LAST:event_updateSexItemStateChanged

    private void updatePhoneNumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_updatePhoneNumberKeyTyped
        status.setText("");
    }//GEN-LAST:event_updatePhoneNumberKeyTyped

    private void updateEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_updateEmailKeyTyped
        status.setText("");
    }//GEN-LAST:event_updateEmailKeyTyped

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            updateCasher.setString(1, updateFname.getText());
            updateCasher.setString(2, updateLname.getText());
            updateCasher.setInt(3, ((Integer) updateAge.getValue()).intValue());
            updateCasher.setString(4, (String) updateSex.getSelectedItem());
            updateCasher.setString(5, updatePhoneNumber.getText());
            updateCasher.setString(6, updateEmail.getText());
            updateCasher.setInt(7, casherId);
            int rowCount = updateCasher.executeUpdate();
            if (rowCount <= 0) {
                throw new Exception("Error on update!!!");
            } else {
                status.setText("Successfully update!!!");
                status.setForeground(java.awt.Color.GREEN);
                updateProfileComponentShown(null);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void updateProfileComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_updateProfileComponentShown
        try {
            selectCasher.setInt(1, casherId);
            ResultSet result = selectCasher.executeQuery();
            if (result.next()) {
                updateFname.setText(result.getString("cFirstName"));
                updateLname.setText(result.getString("cLastName"));
                updatePhoneNumber.setText(result.getString("cPhoneNumber"));
                updateEmail.setText(result.getString("cEmail"));
                updateAge.setValue(new Integer(result.getInt("cAge")));
                updateSex.setSelectedItem(result.getString("cSex"));
            } else {
                throw new Exception("Casher data could not be loaded!!!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_updateProfileComponentShown

    private void changeNewPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_changeNewPasswordKeyTyped
        status.setText("");
    }//GEN-LAST:event_changeNewPasswordKeyTyped

    private void changeConfirmPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_changeConfirmPasswordKeyTyped
        status.setText("");
    }//GEN-LAST:event_changeConfirmPasswordKeyTyped

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            String oldPassword = new String(changeOldPassword.getPassword());
            String newPassword = new String(changeNewPassword.getPassword());
            String confirmPassword = new String(changeConfirmPassword.getPassword());
            selectCasherOldPass.setString(1, oldPassword);
            ResultSet result = selectCasherOldPass.executeQuery();
            if (!result.next()) {
                throw new Exception("Old password not valid!!!");
            } else if (!newPassword.equals(confirmPassword)) {
                throw new Exception("Password doesn't match!!!");
            } else {

                updateCasherPassword.setString(1, newPassword);
                updateCasherPassword.setInt(2, casherId);

                int update = updateCasherPassword.executeUpdate();

                if (update <= 0) {
                    throw new Exception("Error on password change!!!");
                } else {
                    status.setText("Password change sucessfully!!!");
                    changeOldPassword.setText("");
                    changeNewPassword.setText("");
                    changeConfirmPassword.setText("");
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void changeOldPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_changeOldPasswordKeyTyped
        status.setText("");
    }//GEN-LAST:event_changeOldPasswordKeyTyped

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
      Login l=new Login();
       l.setVisible(true);
       dispose();  
    }//GEN-LAST:event_logoutActionPerformed

    private void reloadCart() {
        cartList.setModel(new DefaultComboBoxModel(cart));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ClearCartBtn;
    private javax.swing.JButton addBtn;
    private javax.swing.JList cartList;
    private javax.swing.JPasswordField changeConfirmPassword;
    private javax.swing.JPasswordField changeNewPassword;
    private javax.swing.JPasswordField changeOldPassword;
    private javax.swing.JPanel changePassword;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable listItemTable;
    private javax.swing.JLabel logo;
    private javax.swing.JButton logout;
    private javax.swing.JPanel manageCasher;
    private javax.swing.JButton orderBtn;
    private javax.swing.JButton removeBtn;
    private javax.swing.JTextField searchInput;
    private javax.swing.JTable soldTable;
    private javax.swing.JLabel status;
    private javax.swing.JTabbedPane tab;
    private javax.swing.JSpinner updateAge;
    private javax.swing.JTextField updateEmail;
    private javax.swing.JTextField updateFname;
    private javax.swing.JTextField updateLname;
    private javax.swing.JTextField updatePhoneNumber;
    private javax.swing.JPanel updateProfile;
    private javax.swing.JComboBox updateSex;
    // End of variables declaration//GEN-END:variables

    public void run() {
    }
}
