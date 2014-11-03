/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphique;

import dao.AdministrateurDAO;
import de.javasoft.plaf.synthetica.SyntheticaBlueLightLookAndFeel;
import entities.Administrateur;
import entities.login_cnte;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import util.MyConnection;

/**
 *
 * @author anwer
 */
public class Authentification extends javax.swing.JFrame {

    /**
     * Creates new form Authentification
     */
    Statement ste;
    MyConnection cnx;
        public static int idCl=0;
    public static String nomCl="";
    public static String prenomCl="";
 public static String adresseCL="";
 public static String emailCL="";
 public static String telCL="";

    public Authentification() throws SQLException {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    public List afficherClient() throws SQLException {
        List<Administrateur> listclient = new ArrayList<Administrateur>();

        String requete = "select * from Administrateur";
        try {
            Statement statement = MyConnection.getInstance()
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
             Administrateur c = new Administrateur();
                c.setLogin(resultat.getString(1));
                c.setPass(resultat.getString(2));

                listclient.add(c);
            }
            return listclient;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des clients " + ex.getMessage());
            return null;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        B1 = new javax.swing.JButton();
        TFLOGIN = new javax.swing.JTextField();
        jLab_icon = new javax.swing.JLabel();
        TFPASS = new javax.swing.JPasswordField();
        jLab_login = new javax.swing.JLabel();
        jLab_mdp = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        B2 = new javax.swing.JButton();
        RB3 = new javax.swing.JRadioButton();
        RB1 = new javax.swing.JRadioButton();
        RB2 = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Type d'utilisateur");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 204));
        setMaximumSize(new java.awt.Dimension(554, 299));
        setMinimumSize(new java.awt.Dimension(554, 299));

        jPanel1.setPreferredSize(new java.awt.Dimension(1360, 768));
        jPanel1.setLayout(null);

        B1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        B1.setText("Connexion");
        B1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        B1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B1MouseClicked(evt);
            }
        });
        B1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B1ActionPerformed(evt);
            }
        });
        jPanel1.add(B1);
        B1.setBounds(340, 225, 110, 30);
        jPanel1.add(TFLOGIN);
        TFLOGIN.setBounds(340, 150, 140, 30);
        jPanel1.add(jLab_icon);
        jLab_icon.setBounds(30, 100, 130, 140);
        jPanel1.add(TFPASS);
        TFPASS.setBounds(340, 190, 140, 30);

        jLab_login.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLab_login.setText("Login");
        jPanel1.add(jLab_login);
        jLab_login.setBounds(210, 160, 90, 20);

        jLab_mdp.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLab_mdp.setText("Mot de passe");
        jPanel1.add(jLab_mdp);
        jLab_mdp.setBounds(210, 200, 90, 20);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setText("Si vous n'avez pas de compte, veuillez s'inscrire");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 270, 270, 20);

        B2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        B2.setText("S'inscrire");
        B2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B2MouseClicked(evt);
            }
        });
        B2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B2ActionPerformed(evt);
            }
        });
        jPanel1.add(B2);
        B2.setBounds(340, 260, 110, 30);

        RB3.setBackground(new java.awt.Color(0, 0, 0));
        RB3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        RB3.setForeground(new java.awt.Color(255, 255, 255));
        RB3.setText("Administrateur");
        RB3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RB3ActionPerformed(evt);
            }
        });
        jPanel1.add(RB3);
        RB3.setBounds(310, 20, 151, 33);

        RB1.setBackground(new java.awt.Color(0, 0, 0));
        RB1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        RB1.setForeground(new java.awt.Color(255, 255, 255));
        RB1.setSelected(true);
        RB1.setText("Gérant");
        RB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RB1ActionPerformed(evt);
            }
        });
        jPanel1.add(RB1);
        RB1.setBounds(310, 60, 150, 33);

        RB2.setBackground(new java.awt.Color(0, 0, 0));
        RB2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        RB2.setForeground(new java.awt.Color(255, 255, 255));
        RB2.setText("Client");
        RB2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RB2ActionPerformed(evt);
            }
        });
        jPanel1.add(RB2);
        RB2.setBounds(310, 100, 150, 33);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(290, 10, 190, 130);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void B1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B1ActionPerformed
        // TODO add your handling code here:
//         if (RB1.isSelected()) {
//            RestaurateurDAO restdao = new RestaurateurDAO();
//            Restaurateur restaurateur = restdao.findRestaurateurByLogin(TFLOGIN.getText());
//            if (restaurateur != null) {
//                if (restaurateur.getPass().equals(TFPASS.getText())) {
//                    JOptionPane.showMessageDialog(null, "Authentification avecc succes! ", "ok", 1);
//                    login_cnte.setPersonnes_connectees(TFLOGIN.getText());
//                    login_cnte.setId_personnes_connectees(restdao.findIdRestaurateurByLogin(TFLOGIN.getText()));// id restorateur
//               
//                    new jGererResto().setVisible(true);
//                    this.dispose();
//                    
//                } else {
//                    JOptionPane.showMessageDialog(null, "Mot de passe incorrect", "Error", 1);
//                }
//            } else {
//                JOptionPane.showMessageDialog(null, "Login incorrect ! ", "Error", 1);
//            }
//        }
//        if (RB2.isSelected()) {
//            ClientDAO clientdao = new ClientDAO();
//            Client client = clientdao.findClientByLogin(TFLOGIN.getText());
//            if (client != null) {
//                if (client.getPass().equals(TFPASS.getText())) {
//                    JOptionPane.showMessageDialog(null, "Authentification avecc succes! ", "ok", 1);
//                    login_cnte.setPersonnes_connectees(TFLOGIN.getText());
//                    
//            Client cl;
//            cl=clientdao.getinfoclient(TFLOGIN.getText());
//            idCl=cl.getId();
//            nomCl=cl.getNom();
//            prenomCl=cl.getPrenom();
//            adresseCL=cl.getAdresse();
//            emailCL=cl.getEmail();
//            telCL=cl.getNumero_tel();
//            
//            System.out.println(prenomCl);
//                    
//                    new gestresto().setVisible(true);
//                     this.dispose();
//                } else {
//                    JOptionPane.showMessageDialog(null, "Mot de passe incorrect", "Error", 1);
//                }
//            } else {
//                JOptionPane.showMessageDialog(null, "Login incorrect ! ", "Error", 1);
//
//            }
//            
//           
//         
//           
//            
//
//        }

        if (RB3.isSelected()) {
            AdministrateurDAO admindao = new AdministrateurDAO();
          Administrateur admin = admindao.findAdministrateurByLogin(TFLOGIN.getText());
            if (admin != null) {
                if (admin.getPass().equals(TFPASS.getText())) {
                    JOptionPane.showMessageDialog(null, "Authentification avecc succes! ", "ok", 1);
                    login_cnte.setPersonnes_connectees(TFLOGIN.getText());

                    new SuperAdmin().setVisible(true);
this.dispose();
                    
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Mot de passe incorrect", "Error", 1);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Login incorrect ! ", "Error", 1);
            }
        }
        
    }//GEN-LAST:event_B1ActionPerformed

    private void B2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B2MouseClicked
    
        Insription ins = new Insription();
        ins.setVisible(true);
        this.setVisible(false);
        pack();
        
        
    }//GEN-LAST:event_B2MouseClicked

    private void B2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B2ActionPerformed
        // TODO add your handling code here:
        Insription f1 = new Insription();
        f1.setVisible(true);
        dispose();
    }//GEN-LAST:event_B2ActionPerformed

    private void B1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B1MouseClicked
        // TODO add your handling code here:
        
        
        SuperAdmin ins = new SuperAdmin();
        ins.setVisible(true);
        this.setVisible(false);
        pack();
        
    }//GEN-LAST:event_B1MouseClicked

    private void RB3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RB3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RB3ActionPerformed

    private void RB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RB1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RB1ActionPerformed

    private void RB2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RB2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RB2ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Authentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Authentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Authentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Authentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(new SyntheticaBlueLightLookAndFeel());
                    try {
                        new Authentification().setVisible(true);
                    } catch (SQLException ex) {
                        Logger.getLogger(Authentification.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (        UnsupportedLookAndFeelException | ParseException ex) {
                    Logger.getLogger(Authentification.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B1;
    private javax.swing.JButton B2;
    private javax.swing.JRadioButton RB1;
    private javax.swing.JRadioButton RB2;
    private javax.swing.JRadioButton RB3;
    private javax.swing.JTextField TFLOGIN;
    private javax.swing.JPasswordField TFPASS;
    private javax.swing.JLabel jLab_icon;
    private javax.swing.JLabel jLab_login;
    private javax.swing.JLabel jLab_mdp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
