
package com.apple;

import java.awt.Color;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MgrGUI extends JFrame implements Runnable {

    int mgrId;
    Connection connection;
    Statement statement;
    PreparedStatement insertCasher;
    PreparedStatement insertStoreKeeper;
    PreparedStatement selectCasher;
    PreparedStatement selectStoreKeeper;
    PreparedStatement deleteCasher;
    PreparedStatement deleteStoreKeeper;
    PreparedStatement updateManager;
    PreparedStatement updatePassword;
    PreparedStatement selectPrice;
    PreparedStatement updatePrice;
    PreparedStatement selectManager;
    PreparedStatement selectManagerOldPass;
    PreparedStatement updateManagerPassword;
    PreparedStatement changePrice;

    public MgrGUI(int mgrId) {
        try {
            this.mgrId = mgrId;
            connection = Login.connection;
            statement = connection.createStatement();
            insertCasher = connection.prepareStatement("INSERT INTO casher VALUES ("
                    + "NULL , ?, ?, ?, ?, ?, ?, ?"
                    + ");");
            insertStoreKeeper = connection.prepareStatement("INSERT INTO storekeeper VALUES ("
                    + "NULL , ?, ?, ?, ?, ?, ?, ?"
                    + ");");
            selectCasher = connection.prepareStatement("select * from casher");
            selectStoreKeeper = connection.prepareStatement("select * from storekeeper");
            deleteCasher = connection.prepareStatement("delete from casher where cId = ?");
            deleteStoreKeeper = connection.prepareStatement("delete from storekeeper where skId = ?");
            updateManager = connection.prepareStatement("UPDATE manager "
                    + "SET mFirstName = ?,"
                    + "mLastName = ?, "
                    + "mAge = ?, "
                    + "mSex = ?, "
                    + "mPhoneNumber = ?, "
                    + "mEmail = ?"
                    + "WHERE mId = ?;");
            updatePassword = connection.prepareStatement("UPDATE manager "
                    + "SET mPassword = ? "
                    + "WHERE mId = ? AND "
                    + "mPassword = ?");
            updatePrice = connection.prepareStatement("UPDATE item "
                    + "SET itemPrice = ? "
                    + "WHERE itemId = ?");
            selectManager = connection.prepareStatement("select * from manager where mId = ?");
            selectManagerOldPass = connection.prepareStatement("SELECT * FROM manager where mPassword = ?");
            updateManagerPassword = connection.prepareStatement("update manager "
                    + "set mPassword = ? "
                    + "where mId = ?");
            selectPrice = connection.prepareStatement("select * from item");
            changePrice = connection.prepareStatement("update item "
                    + "set itemPrice = ? "
                    + "where itemId = ?");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gui = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        tab = new javax.swing.JTabbedPane();
        manageCasher = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        casherFname = new javax.swing.JTextField();
        casherLname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        casherAge = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        casherSex = new javax.swing.JComboBox();
        casherPhoneNumber = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        casherEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        casherPassword = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        casherPassword2 = new javax.swing.JPasswordField();
        hireCasher = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        casherList = new javax.swing.JList();
        jButton2 = new javax.swing.JButton();
        manageStoreKeeper = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        storekeeperFname = new javax.swing.JTextField();
        storekeeperLname = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        storekeeperAge = new javax.swing.JSpinner();
        jLabel12 = new javax.swing.JLabel();
        storekeeperSex = new javax.swing.JComboBox();
        storekeeperPhoneNumber = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        storekeeperEmail = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        storekeeperPassword = new javax.swing.JPasswordField();
        jLabel16 = new javax.swing.JLabel();
        storekeeperPassword2 = new javax.swing.JPasswordField();
        jButton4 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        storeKeeperList = new javax.swing.JList();
        jButton3 = new javax.swing.JButton();
        changeItemPrice = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        itemList = new javax.swing.JList();
        changePriceName = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        oldPriceUneditable = new javax.swing.JTextField();
        chageNewPrice = new javax.swing.JTextField();
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
        setResizable(false);

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/apple/logo2.png"))); // NOI18N
        logo.setText(" ");

        tab.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        tab.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tabComponentShown(evt);
            }
        });

        manageCasher.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                manageCasherComponentShown(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Hire Casher"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("First Name");

        casherFname.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        casherLname.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Last Name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Age");

        casherAge.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        casherAge.setModel(new javax.swing.SpinnerNumberModel(20, 0, 99, 1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Sex");

        casherSex.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        casherSex.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));

        casherPhoneNumber.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Phone Number");

        casherEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Email");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Password");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Confirm Password");

        hireCasher.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        hireCasher.setText("Hire Casher");
        hireCasher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hireCasherActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(43, 43, 43))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(hireCasher, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(casherPassword2)
                    .addComponent(casherPassword, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(casherEmail)
                    .addComponent(casherLname)
                    .addComponent(casherPhoneNumber)
                    .addComponent(casherFname))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(casherSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(casherAge, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(casherFname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(casherSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(casherLname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(casherAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(casherPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(casherEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(casherPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(casherPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hireCasher)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Fire Casher"));

        casherList.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        casherList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        casherList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(casherList);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setText("Fire Casher");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout manageCasherLayout = new javax.swing.GroupLayout(manageCasher);
        manageCasher.setLayout(manageCasherLayout);
        manageCasherLayout.setHorizontalGroup(
            manageCasherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageCasherLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        manageCasherLayout.setVerticalGroup(
            manageCasherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageCasherLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(manageCasherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tab.addTab("Manage Casher", manageCasher);

        manageStoreKeeper.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                manageStoreKeeperComponentShown(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Hire Store Keeper"));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("First Name");

        storekeeperFname.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        storekeeperLname.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Last Name");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Age");

        storekeeperAge.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Sex");

        storekeeperSex.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        storekeeperSex.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));

        storekeeperPhoneNumber.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Phone Number");

        storekeeperEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Email");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Password");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("Confirm Password");

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton4.setText("Hire Store Keeper");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(43, 43, 43))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel13)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(storekeeperPassword2)
                    .addComponent(storekeeperPassword, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(storekeeperEmail)
                    .addComponent(storekeeperLname)
                    .addComponent(storekeeperPhoneNumber)
                    .addComponent(storekeeperFname))
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(storekeeperSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(storekeeperAge, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(storekeeperFname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(storekeeperSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(storekeeperLname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(storekeeperAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(storekeeperPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(storekeeperEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(storekeeperPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(storekeeperPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Fire Store Keeper"));

        storeKeeperList.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        storeKeeperList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        storeKeeperList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(storeKeeperList);

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton3.setText("Fire Store Keeper");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout manageStoreKeeperLayout = new javax.swing.GroupLayout(manageStoreKeeper);
        manageStoreKeeper.setLayout(manageStoreKeeperLayout);
        manageStoreKeeperLayout.setHorizontalGroup(
            manageStoreKeeperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageStoreKeeperLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        manageStoreKeeperLayout.setVerticalGroup(
            manageStoreKeeperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageStoreKeeperLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(manageStoreKeeperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tab.addTab("Manage Store Keeper", manageStoreKeeper);

        changeItemPrice.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                changeItemPriceComponentShown(evt);
            }
        });

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Update Item Price"));

        itemList.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        itemList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        itemList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        itemList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                itemListValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(itemList);

        changePriceName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        changePriceName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                changePriceNameKeyReleased(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setText("Search");

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel34.setText("Old Price");

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel35.setText("New Price");

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton7.setText("Change Price");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        oldPriceUneditable.setEditable(false);
        oldPriceUneditable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        chageNewPrice.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(changePriceName, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel34)
                            .addComponent(jLabel35))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(oldPriceUneditable, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chageNewPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(69, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton7)
                        .addGap(84, 84, 84))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(changePriceName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(oldPriceUneditable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(chageNewPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton7)))
                .addContainerGap())
        );

        javax.swing.GroupLayout changeItemPriceLayout = new javax.swing.GroupLayout(changeItemPrice);
        changeItemPrice.setLayout(changeItemPriceLayout);
        changeItemPriceLayout.setHorizontalGroup(
            changeItemPriceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(changeItemPriceLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        changeItemPriceLayout.setVerticalGroup(
            changeItemPriceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(changeItemPriceLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 222, Short.MAX_VALUE)
                .addContainerGap())
        );

        tab.addTab("change Item Price", changeItemPrice);

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
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout updateProfileLayout = new javax.swing.GroupLayout(updateProfile);
        updateProfile.setLayout(updateProfileLayout);
        updateProfileLayout.setHorizontalGroup(
            updateProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateProfileLayout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );
        updateProfileLayout.setVerticalGroup(
            updateProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateProfileLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(9, 9, 9))
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
                .addContainerGap(40, Short.MAX_VALUE)
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
                .addGap(89, 89, 89)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );
        changePasswordLayout.setVerticalGroup(
            changePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(changePasswordLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(9, 9, 9))
        );

        tab.addTab("Change Password", changePassword);

        status.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        status.setForeground(new java.awt.Color(0, 255, 0));
        status.setText(" ");

        javax.swing.GroupLayout guiLayout = new javax.swing.GroupLayout(gui);
        gui.setLayout(guiLayout);
        guiLayout.setHorizontalGroup(
            guiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, guiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(guiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(status, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, guiLayout.createSequentialGroup()
                        .addComponent(tab, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        guiLayout.setVerticalGroup(
            guiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, guiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tab, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(status)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(gui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 428, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 1, Short.MAX_VALUE)
                    .addComponent(gui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 1, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void manageCasherComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_manageCasherComponentShown
        try {
            ResultSet result = selectCasher.executeQuery();
            Vector<String> data = new Vector<>();
            while (result.next()) {
                data.add(result.getString("cFirstName") + " " + result.getString("cLastName"));
            }
            casherList.setModel(new DefaultComboBoxModel(data));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_manageCasherComponentShown

    private void hireCasherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hireCasherActionPerformed
        try {
            if (!casherPassword.getText().equals(casherPassword2.getText())) {
                throw new Exception("Password doesn't match!!!");
            }
            insertCasher.setString(1, casherFname.getText());
            insertCasher.setString(2, casherLname.getText());
            insertCasher.setInt(3, ((Integer) casherAge.getValue()).intValue());
            insertCasher.setString(4, (String) casherSex.getSelectedItem());
            insertCasher.setString(5, casherPhoneNumber.getText());
            insertCasher.setString(6, casherEmail.getText());
            insertCasher.setString(7, new String(casherPassword.getPassword()));
            int updated = insertCasher.executeUpdate();
            if (updated <= 0) {
                new Exception("Uknown Error");
            } else {
                casherFname.setText("");
                casherLname.setText("");
                casherPhoneNumber.setText("");
                casherEmail.setText("");
                casherPassword.setText("");
                casherPassword2.setText("");
            }
            manageCasherComponentShown(null);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_hireCasherActionPerformed

    private void tabComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tabComponentShown
    }//GEN-LAST:event_tabComponentShown

    private void manageStoreKeeperComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_manageStoreKeeperComponentShown
        try {
            ResultSet result = selectStoreKeeper.executeQuery();
            Vector<String> data = new Vector<>();
            while (result.next()) {
                data.add(result.getString("skFirstName") + " " + result.getString("skLastName"));
            }
            storeKeeperList.setModel(new DefaultComboBoxModel(data));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_manageStoreKeeperComponentShown

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            if (!storekeeperPassword.getText().equals(storekeeperPassword2.getText())) {
                throw new Exception("Password doesn't match!!!");
            }
            insertStoreKeeper.setString(1, storekeeperFname.getText());
            insertStoreKeeper.setString(2, storekeeperLname.getText());
            insertStoreKeeper.setInt(3, ((Integer) storekeeperAge.getValue()).intValue());
            insertStoreKeeper.setString(4, (String) storekeeperSex.getSelectedItem());
            insertStoreKeeper.setString(5, storekeeperPhoneNumber.getText());
            insertStoreKeeper.setString(6, storekeeperEmail.getText());
            insertStoreKeeper.setString(7, new String(storekeeperPassword.getPassword()));
            int updated = insertStoreKeeper.executeUpdate();
            if (updated <= 0) {
                new Exception("Uknown Error");
            } else {
                storekeeperFname.setText("");
                storekeeperLname.setText("");
                storekeeperPhoneNumber.setText("");
                storekeeperEmail.setText("");
                storekeeperPassword.setText("");
                storekeeperPassword2.setText("");
            }
            manageStoreKeeperComponentShown(null);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            if (casherList.isSelectionEmpty()) {
                throw new Exception("Select a casher");
            }
            ResultSet result = selectCasher.executeQuery();
            ArrayList<String> data = new ArrayList<>();
            while (result.next()) {
                data.add(result.getString("cID"));
            }
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure to fire " + (String) casherList.getSelectedValue(), "Fire?",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (confirm == JOptionPane.YES_OPTION) {
                deleteCasher.setInt(1, Integer.parseInt(data.get(casherList.getSelectedIndex())));
                deleteCasher.executeUpdate();
                manageCasherComponentShown(null);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            if (storeKeeperList.isSelectionEmpty()) {
                throw new Exception("Select a casher");
            }
            ResultSet result = selectStoreKeeper.executeQuery();
            ArrayList<String> data = new ArrayList<>();
            while (result.next()) {
                data.add(result.getString("skID"));
            }
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure to fire " + (String) storeKeeperList.getSelectedValue(), "Fire?",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (confirm == JOptionPane.YES_OPTION) {
                deleteStoreKeeper.setInt(1, Integer.parseInt(data.get(storeKeeperList.getSelectedIndex())));
                deleteStoreKeeper.executeUpdate();
                manageStoreKeeperComponentShown(null);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            updateManager.setString(1, updateFname.getText());
            updateManager.setString(2, updateLname.getText());
            updateManager.setInt(3, ((Integer) updateAge.getValue()).intValue());
            updateManager.setString(4, (String) updateSex.getSelectedItem());
            updateManager.setString(5, updatePhoneNumber.getText());
            updateManager.setString(6, updateEmail.getText());
            updateManager.setInt(7, mgrId);
            int rowCount = updateManager.executeUpdate();
            if (rowCount <= 0) {
                throw new Exception("Error on update!!!");
            } else {
                status.setText("Successfully update!!!");
                status.setForeground(Color.GREEN);
                updateProfileComponentShown(null);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void updateProfileComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_updateProfileComponentShown
        try {
            selectManager.setInt(1, mgrId);
            ResultSet result = selectManager.executeQuery();
            if (result.next()) {
                updateFname.setText(result.getString("mFirstName"));
                updateLname.setText(result.getString("mLastName"));
                updatePhoneNumber.setText(result.getString("mPhoneNumber"));
                updateEmail.setText(result.getString("mEmail"));
                updateAge.setValue(new Integer(result.getInt("mAge")));
                updateSex.setSelectedItem(result.getString("mSex"));
            } else {
                throw new Exception("Manager data could not be loaded!!!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_updateProfileComponentShown

    private void updateFnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_updateFnameKeyTyped
        status.setText("");
    }//GEN-LAST:event_updateFnameKeyTyped

    private void updateLnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_updateLnameKeyTyped
        status.setText("");
    }//GEN-LAST:event_updateLnameKeyTyped

    private void updatePhoneNumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_updatePhoneNumberKeyTyped
        status.setText("");
    }//GEN-LAST:event_updatePhoneNumberKeyTyped

    private void updateEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_updateEmailKeyTyped
        status.setText("");
    }//GEN-LAST:event_updateEmailKeyTyped

    private void updateSexItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_updateSexItemStateChanged
        status.setText("");
    }//GEN-LAST:event_updateSexItemStateChanged

    private void updateAgeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_updateAgeStateChanged
        status.setText("");
    }//GEN-LAST:event_updateAgeStateChanged

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            String oldPassword = new String(changeOldPassword.getPassword());
            String newPassword = new String(changeNewPassword.getPassword());
            String confirmPassword = new String(changeConfirmPassword.getPassword());
            selectManagerOldPass.setString(1, oldPassword);
            ResultSet result = selectManagerOldPass.executeQuery();
            if (!result.next()) {
                throw new Exception("Old password not valid!!!");
            } else if (!newPassword.equals(confirmPassword)) {
                throw new Exception("Password doesn't match!!!");
            } else {

                updateManagerPassword.setString(1, newPassword);
                updateManagerPassword.setInt(2, mgrId);

                int update = updateManagerPassword.executeUpdate();

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

    private void changeNewPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_changeNewPasswordKeyTyped
        status.setText("");
    }//GEN-LAST:event_changeNewPasswordKeyTyped

    private void changeConfirmPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_changeConfirmPasswordKeyTyped
        status.setText("");
    }//GEN-LAST:event_changeConfirmPasswordKeyTyped

    private void changeItemPriceComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_changeItemPriceComponentShown
        try {
            ResultSet result = selectPrice.executeQuery();
            itemListUpdater(result);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_changeItemPriceComponentShown

    private void changePriceNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_changePriceNameKeyReleased
        try {
            ResultSet result = statement.executeQuery("select * from item where itemQuanity is not null AND itemName LIKE '%" + changePriceName.getText() + "%'");
            itemListUpdater(result);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_changePriceNameKeyReleased

    private void itemListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_itemListValueChanged
        Vector<String> itemArrayList = new Vector<>();
        try {
            if (itemList.getSelectedIndex() >= 0) {
                ResultSet result = statement.executeQuery("select * from item where itemQuanity is not null AND itemName LIKE '%" + changePriceName.getText() + "%'");
                while (result.next()) {
                    itemArrayList.add("" + result.getDouble("itemPrice"));
                }
                String oldPrice = itemArrayList.get(itemList.getSelectedIndex());
                oldPriceUneditable.setText(oldPrice);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_itemListValueChanged

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try {
            int selectedIndex = itemList.getSelectedIndex();
            double newPrice = Double.parseDouble(chageNewPrice.getText());
            ResultSet result = statement.executeQuery("select * from item where itemQuanity is not null AND itemName LIKE '%" + changePriceName.getText() + "%'");
            if (selectedIndex == -1) {
                throw new Exception("Select item first!!!");
            } else if (newPrice <= 0) {
                throw new Exception("Item price must be > 0!!!");
            }
            Vector<String> itemArrayList = new Vector<>();
            while (result.next()) {
                itemArrayList.add("" + result.getDouble("itemId"));
            }

            int itemId = (int) Double.parseDouble(itemArrayList.get(selectedIndex));

            changePrice.setDouble(1, newPrice);
            changePrice.setDouble(2, itemId);
            int update = changePrice.executeUpdate();
            if (update <= 0) {
                throw new Exception("Error on change price!!!");
            } else {
                status.setText("Price Changed!!!");
                chageNewPrice.setText("");
                oldPriceUneditable.setText("");
                changeItemPriceComponentShown(null);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    void itemListUpdater(ResultSet result) throws Exception {
        Vector<String> itemArrayList = new Vector<>();
        while (result.next()) {
            itemArrayList.add(result.getString("itemName") + " [" + result.getString("itemPrice") + "] ");
        }
        itemList.setModel(new DefaultComboBoxModel(itemArrayList));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner casherAge;
    private javax.swing.JTextField casherEmail;
    private javax.swing.JTextField casherFname;
    private javax.swing.JList casherList;
    private javax.swing.JTextField casherLname;
    private javax.swing.JPasswordField casherPassword;
    private javax.swing.JPasswordField casherPassword2;
    private javax.swing.JTextField casherPhoneNumber;
    private javax.swing.JComboBox casherSex;
    private javax.swing.JTextField chageNewPrice;
    private javax.swing.JPasswordField changeConfirmPassword;
    private javax.swing.JPanel changeItemPrice;
    private javax.swing.JPasswordField changeNewPassword;
    private javax.swing.JPasswordField changeOldPassword;
    private javax.swing.JPanel changePassword;
    private javax.swing.JTextField changePriceName;
    private javax.swing.JPanel gui;
    private javax.swing.JButton hireCasher;
    private javax.swing.JList itemList;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel manageCasher;
    private javax.swing.JPanel manageStoreKeeper;
    private javax.swing.JTextField oldPriceUneditable;
    private javax.swing.JLabel status;
    private javax.swing.JList storeKeeperList;
    private javax.swing.JSpinner storekeeperAge;
    private javax.swing.JTextField storekeeperEmail;
    private javax.swing.JTextField storekeeperFname;
    private javax.swing.JTextField storekeeperLname;
    private javax.swing.JPasswordField storekeeperPassword;
    private javax.swing.JPasswordField storekeeperPassword2;
    private javax.swing.JTextField storekeeperPhoneNumber;
    private javax.swing.JComboBox storekeeperSex;
    private javax.swing.JTabbedPane tab;
    private javax.swing.JSpinner updateAge;
    private javax.swing.JTextField updateEmail;
    private javax.swing.JTextField updateFname;
    private javax.swing.JTextField updateLname;
    private javax.swing.JTextField updatePhoneNumber;
    private javax.swing.JPanel updateProfile;
    private javax.swing.JComboBox updateSex;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
    }
}
