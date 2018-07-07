package com.css.view;

import com.css.DBConnect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Home extends javax.swing.JFrame {

    Vector<String> deptName;
    Vector<String> deptDesc;
    Vector<Integer> deptId;
    Vector<Integer> years;
    Vector<Integer> semesters;
    Vector<String> tableHeaders;
    Vector<String> courseCodes;
    Statement statement;

    public Home() {
        initComponents();
        try {
            Connection connection = new DBConnect().getConnection();
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM dept");
            deptId = new Vector<>();
            deptName = new Vector<>();
            deptDesc = new Vector<>();
            while (result.next()) {
                deptId.add(new Integer(result.getInt("dID")));
                deptName.add(result.getString("dName"));
                deptDesc.add(result.getString("dDesc"));
            }
            dept.setModel(new DefaultComboBoxModel(deptName));
            descDept.setText(deptDesc.get(dept.getSelectedIndex()));
            tableHeaders = new Vector<>();
            tableHeaders.add("Code");
            tableHeaders.add("Name");
            tableHeaders.add("Credit Hour");
            tableHeaders.add("Year");
            tableHeaders.add("Semster");
            tableHeaders.add("Description");
            reloadYear();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        dept = new javax.swing.JComboBox();
        year = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        semester = new javax.swing.JComboBox();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        courseTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        courseList = new javax.swing.JList();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lectureNameList = new javax.swing.JList();
        login = new javax.swing.JButton();
        descDept = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(jPanel1.getPreferredSize());
        setResizable(false);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/css/image/logo.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Departement");

        dept.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dept.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        dept.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                deptItemStateChanged(evt);
            }
        });

        year.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        year.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        year.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                yearItemStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Year");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Semester");

        semester.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        semester.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        semester.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                semesterItemStateChanged(evt);
            }
        });

        courseTable.setAutoCreateRowSorter(true);
        courseTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        courseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        courseTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        courseTable.setDoubleBuffered(true);
        courseTable.setFillsViewportHeight(true);
        courseTable.setSurrendersFocusOnKeystroke(true);
        courseTable.setUpdateSelectionOnSort(false);
        courseTable.setVerifyInputWhenFocusTarget(false);
        jScrollPane1.setViewportView(courseTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Course", jPanel2);

        courseList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        courseList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        courseList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                courseListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(courseList);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Select a course to see the avalable lecturers");

        lectureNameList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lectureNameList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(lectureNameList);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Lecture", jPanel3);

        login.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        descDept.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        descDept.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        descDept.setText("jLabel6");
        descDept.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(dept, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(year, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(semester, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descDept, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(100, 100, 100))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dept, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descDept, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(semester, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94)
                        .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        Login log = new Login();
        log.setLocationRelativeTo(null);
        log.setVisible(true);
        dispose();
    }//GEN-LAST:event_loginActionPerformed

    private void deptItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_deptItemStateChanged
        descDept.setText(deptDesc.get(dept.getSelectedIndex()));
        reloadYear();
    }//GEN-LAST:event_deptItemStateChanged

    private void yearItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_yearItemStateChanged
        reloadSemester();
    }//GEN-LAST:event_yearItemStateChanged

    private void semesterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_semesterItemStateChanged
        reloadCourses();
    }//GEN-LAST:event_semesterItemStateChanged

    private void courseListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_courseListValueChanged
        int selectedIndex;
        selectedIndex = courseList.getSelectedIndex();
        if (selectedIndex < 0) {
            return;
        }
        Integer integer = deptId.get(dept.getSelectedIndex());
        int dID = integer.intValue();

        Integer integer2 = years.get(year.getSelectedIndex());
        int year = integer2.intValue();

        Integer integer3 = semesters.get(semester.getSelectedIndex());
        int semester = integer3.intValue();
        Vector<String> lectureName = new Vector<>();
        try {
            ResultSet result = statement.executeQuery(
                    "SELECT * FROM lectureteach,lecture"
                    + " where ltLssn = lSsn"
                    + " AND ltCcode = '" + courseCodes.get(selectedIndex) + "'");
            while (result.next()) {
                lectureName.add(result.getString("lFirstName") + " " + result.getString("lLastName"));
            }
            lectureNameList.setModel(new DefaultComboBoxModel(lectureName));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_courseListValueChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList courseList;
    private javax.swing.JTable courseTable;
    private javax.swing.JComboBox dept;
    private javax.swing.JLabel descDept;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JList lectureNameList;
    private javax.swing.JButton login;
    private javax.swing.JComboBox semester;
    private javax.swing.JComboBox year;
    // End of variables declaration//GEN-END:variables

    private void reloadYear() {
        try {
            Integer integer = deptId.get(dept.getSelectedIndex());
            int dID = integer.intValue();

            ResultSet result = statement.executeQuery(
                    "SELECT distinct dtYear FROM deptteach where dtDeptID = " + dID + " ORDER BY dtYear ASC");
            years = new Vector<>();
            while (result.next()) {
                years.add(new Integer(result.getInt("dtYear")));
            }
            year.setModel(new DefaultComboBoxModel(years));
            reloadSemester();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void reloadSemester() {
        try {
            Integer integer = deptId.get(dept.getSelectedIndex());
            int dID = integer.intValue();

            Integer integer2 = years.get(year.getSelectedIndex());
            int year = integer2.intValue();

            ResultSet result = statement.executeQuery(
                    "SELECT distinct dtSemester FROM deptteach where dtDeptID = " + dID + " AND dtYear = " + year + " ORDER BY dtSemester ASC");
            semesters = new Vector<>();
            while (result.next()) {
                semesters.add(new Integer(result.getInt("dtSemester")));
            }
            semester.setModel(new DefaultComboBoxModel(semesters));
            reloadCourses();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void reloadCourses() {
        try {
            Integer integer = deptId.get(dept.getSelectedIndex());
            int dID = integer.intValue();

            Integer integer2 = years.get(year.getSelectedIndex());
            int year = integer2.intValue();

            Integer integer3 = semesters.get(semester.getSelectedIndex());
            int semester = integer3.intValue();

            courseCodes = new Vector<>();

            ResultSet result = statement.executeQuery(
                    "SELECT * FROM deptteach,course"
                    + " where dtCCode = cCode"
                    + " AND dtDeptID = " + dID
                    + " AND dtYear = " + year
                    + " AND dtSemester = " + semester
                    + " ORDER BY dtCreditHour ASC");

            Vector<Vector<String>> courses = new Vector<>();
            Vector<String> courseName = new Vector<>();
            courseCodes = new Vector<>();
            while (result.next()) {
                Vector<String> row = new Vector<>();
                row.add(result.getString("dtCCode"));
                row.add(result.getString("cName"));
                row.add("" + result.getInt("dtCreditHour"));
                row.add("" + result.getString("dtYear"));
                row.add("" + result.getString("dtSemester"));
                row.add(result.getString("cDesc"));
                courses.add(row);

                // JList
                courseName.add(result.getString("cName"));
                // Course Code
                courseCodes.add(result.getString("dtCCode"));
            }

            courseTable.setModel(new DefaultTableModel(courses, tableHeaders));
            // lecture

            courseList.setModel(new DefaultComboBoxModel(courseName));

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
        }
    }
}
