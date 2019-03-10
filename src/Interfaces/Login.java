
package Interfaces;

import SQL.UsuarioDAO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Login extends javax.swing.JFrame {

  public Login() {
        initComponents();
    }
 
 public void executarLoguin()
 {
     
        if (txtUsuario.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Entre com um usuário!");
        }
        else if(txtSenha.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Digite sua senha!");
        }
        else
        {        
            UsuarioDAO usuario = new UsuarioDAO();      
            usuario.getUsuario( txtUsuario.getText() , txtSenha.getText() );
            dispose();
        }       
     
 }
    
 

 
 @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUsuario = new javax.swing.JTextField();
        txtFazerLoguin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtSenha = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setIconImage(new ImageIcon(getClass().getResource("/imagens/icon.png")).getImage());
        setResizable(false);
        getContentPane().setLayout(null);

        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(txtUsuario);
        txtUsuario.setBounds(220, 150, 220, 30);

        txtFazerLoguin.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtFazerLoguin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/entrar.png"))); // NOI18N
        txtFazerLoguin.setText("Entrar");
        txtFazerLoguin.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        txtFazerLoguin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFazerLoguinActionPerformed(evt);
            }
        });
        getContentPane().add(txtFazerLoguin);
        txtFazerLoguin.setBounds(350, 230, 85, 30);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Usuário:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(160, 160, 60, 20);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Senha:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(160, 190, 70, 20);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        jLabel3.setText("Faça seu login");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(190, 30, 220, 40);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(-2, 80, 640, 10);

        txtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaActionPerformed(evt);
            }
        });
        txtSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSenhaKeyTyped(evt);
            }
        });
        getContentPane().add(txtSenha);
        txtSenha.setBounds(220, 190, 220, 30);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/login.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(70, 120, 100, 110);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Login.jpg"))); // NOI18N
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 570, 370);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/newAccount.png"))); // NOI18N
        jMenu2.setText("Cadastrar");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu2MousePressed(evt);
            }
        });
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/recuperar.png"))); // NOI18N
        jMenu1.setText("Recuperar senha");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu1MousePressed(evt);
            }
        });
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(576, 419));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtFazerLoguinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFazerLoguinActionPerformed
        executarLoguin();
        
    }//GEN-LAST:event_txtFazerLoguinActionPerformed

    private void txtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaActionPerformed
        executarLoguin();
    }//GEN-LAST:event_txtSenhaActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        JFrame mainFrame = new JFrame();
        RecuperarSenha usuario = new RecuperarSenha(mainFrame, true);
        usuario.setLocationRelativeTo(mainFrame);
        usuario.setVisible(true);
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        JFrame mainFrame = new JFrame();
        RecuperarSenha usuario = new RecuperarSenha(mainFrame, true);
        usuario.setLocationRelativeTo(mainFrame);
        usuario.setVisible(true);   
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        JFrame mainFrame = new JFrame();
        AdicionarUsuario usuario = new AdicionarUsuario(mainFrame, true);
        usuario.setLocationRelativeTo(mainFrame);
        usuario.setVisible(true);
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        JFrame mainFrame = new JFrame();
        AdicionarUsuario usuario = new AdicionarUsuario(mainFrame, true);
        usuario.setLocationRelativeTo(mainFrame);
        usuario.setVisible(true);   
    }//GEN-LAST:event_jMenu2MouseClicked

    private void txtSenhaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSenhaKeyTyped
        
    }//GEN-LAST:event_txtSenhaKeyTyped

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        executarLoguin();
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void jMenu2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MousePressed
        JFrame mainFrame = new JFrame();
        AdicionarUsuario usuario = new AdicionarUsuario(mainFrame, true);
        usuario.setLocationRelativeTo(mainFrame);
        usuario.setVisible(true);
    }//GEN-LAST:event_jMenu2MousePressed

    private void jMenu1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MousePressed
        JFrame mainFrame = new JFrame();
        RecuperarSenha usuario = new RecuperarSenha(mainFrame, true);
        usuario.setLocationRelativeTo(mainFrame);
        usuario.setVisible(true); 
    }//GEN-LAST:event_jMenu1MousePressed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton txtFazerLoguin;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
