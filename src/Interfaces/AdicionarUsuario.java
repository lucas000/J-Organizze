package Interfaces;

import Modelos.Usuario;
import SQL.UsuarioDAO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class AdicionarUsuario extends javax.swing.JDialog {


    public AdicionarUsuario(java.awt.Frame parent, boolean modal)
    {
        super(parent, modal);
        initComponents();
    }

  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jButtonFazerrLoguin = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        txtUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        txtCpf = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        txtConfirmacao = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Criar usuário");
        setIconImage(new ImageIcon(getClass().getResource("/imagens/icon.png")).getImage());
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Crie seu usuário");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(200, 30, 240, 35);

        jButtonFazerrLoguin.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonFazerrLoguin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/adicionar.png"))); // NOI18N
        jButtonFazerrLoguin.setText("Criar");
        jButtonFazerrLoguin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFazerrLoguinActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonFazerrLoguin);
        jButtonFazerrLoguin.setBounds(330, 300, 90, 30);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 100, 600, 20);

        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });
        getContentPane().add(txtUsuario);
        txtUsuario.setBounds(220, 120, 200, 30);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Usuário:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(160, 120, 60, 30);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Senha:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(170, 220, 50, 30);

        txtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaActionPerformed(evt);
            }
        });
        getContentPane().add(txtSenha);
        txtSenha.setBounds(220, 220, 200, 30);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("CPF: ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(180, 170, 40, 30);

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCpfKeyTyped(evt);
            }
        });
        getContentPane().add(txtCpf);
        txtCpf.setBounds(220, 170, 200, 30);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/newAccountGrante.png"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(60, 10, 90, 90);

        txtConfirmacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConfirmacaoActionPerformed(evt);
            }
        });
        getContentPane().add(txtConfirmacao);
        txtConfirmacao.setBounds(220, 260, 200, 30);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Confirmação:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(130, 260, 90, 30);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bggreynovo.jpg"))); // NOI18N
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 620, 400);

        setSize(new java.awt.Dimension(624, 425));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFazerrLoguinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFazerrLoguinActionPerformed
        if(txtUsuario.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Digite um nome de usuário!");
        }
        else if(txtCpf.getText().isEmpty() || txtCpf.getText().equals("   .   .   -  "))
        {
           JOptionPane.showMessageDialog(null, "Digite um CPF!");

        }
        else if(txtSenha.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Digite uma senha!");

        }
        else if(txtSenha.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Digite uma senha!");

        }
        else if(txtConfirmacao.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Digite a confirmação de senha!");

        }  
        else if(!txtConfirmacao.getText().equals(txtSenha.getText()))
        {
            JOptionPane.showMessageDialog(null, "Senhas não coincidem!");

        }
        else
        {
        UsuarioDAO usuario = new  UsuarioDAO();
        Usuario u = new Usuario (txtUsuario.getText(),txtCpf.getText(),txtSenha.getText());
        usuario.inserirUsuario( u );
        dispose();    
        }     
  
       
    }//GEN-LAST:event_jButtonFazerrLoguinActionPerformed

    private void txtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSenhaActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtCpfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCpfKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCpfKeyTyped

    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
        String caracteres="0987654321abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_-";
        if(!caracteres.contains(evt.getKeyChar()+""))
        {
        evt.consume();
        }
    }//GEN-LAST:event_txtUsuarioKeyTyped

    private void txtConfirmacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConfirmacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConfirmacaoActionPerformed

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
            java.util.logging.Logger.getLogger(AdicionarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdicionarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdicionarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdicionarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AdicionarUsuario dialog = new AdicionarUsuario(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonFazerrLoguin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPasswordField txtConfirmacao;
    public static javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
