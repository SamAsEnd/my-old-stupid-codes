/*
 * By:- Dejen Agaziu
 *        Ermiyas Birhanu
 *        Hassen Aliye
 *        Bahir Dar University Institute of Technology
 *        Department of Information Technology
 *        Distributed System group project
 */
package atm;

import java.net.*;
import java.io.*;
public class Login extends javax.swing.JFrame implements Runnable {

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    public Login() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Login Page");
        setVisible(true);
        try{
        socket = new Socket("localhost",6000);
        in = new DataInputStream(socket.getInputStream());
        out=new DataOutputStream(socket.getOutputStream());
        Thread t = new Thread(this);
        t.start();
        }catch(Exception e){}  
    }
public void run()
{
     while(true)
     {
       try{
         String msg = in.readUTF();
         if(msg.equalsIgnoreCase("succefull"))
         {
             this.setVisible(false);
             new Client().setVisible(true);
         }
         else
              lb2.setText(msg);
       }catch(Exception e){}  
     }
}    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb1 = new javax.swing.JLabel();
        pincode = new javax.swing.JTextField();
        login = new javax.swing.JButton();
        lb2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lb1.setFont(new java.awt.Font("Times New Roman", 1, 18));
        lb1.setText("Enter pin code");

        login.setFont(new java.awt.Font("Times New Roman", 3, 18));
        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Monotype Corsiva", 3, 48));
        jLabel1.setForeground(new java.awt.Color(0, 153, 255));
        jLabel1.setText("IBEX");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 36));
        jLabel2.setForeground(new java.awt.Color(0, 153, 51));
        jLabel2.setText("ATM MACHINE");

        jLabel3.setIcon(new javax.swing.ImageIcon("K:\\ATMSample\\ATM\\src\\atm\\atm-checkcard-atm.jpg")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lb2, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(jLabel1))
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(lb1)
                        .addGap(10, 10, 10)
                        .addComponent(pincode, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel1)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel2))
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, 0, 0, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addComponent(lb2)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lb1))
                    .addComponent(pincode, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
       String msg = pincode.getText();
       try{
       out.writeUTF(msg+",login");
       }catch(Exception e){}
    }//GEN-LAST:event_loginActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
                new Login();
         
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JButton login;
    private javax.swing.JTextField pincode;
    // End of variables declaration//GEN-END:variables
}
