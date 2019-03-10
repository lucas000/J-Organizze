package Interfaces;

import Modelos.Boletim;
import SQL.BoletimDAO;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class AdicionarDisciplina extends javax.swing.JDialog 
{

    
    public AdicionarDisciplina(java.awt.Frame parent, boolean modal) 
    {
        super(parent, modal);
        initComponents();
    }
    int pontoNota1 = 0;
    int pontoNota2 = 0;
    int pontoNota3 = 0;
    int pontoNota4 = 0;
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNota4 = new javax.swing.JTextField();
        txtNota2 = new javax.swing.JTextField();
        txtNota1 = new javax.swing.JTextField();
        txtDisciplina = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtNota3 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bg.jpg"))); // NOI18N
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adicionar Disciplina");
        setIconImage(new ImageIcon(getClass().getResource("/imagens/icon.png")).getImage());
        setResizable(false);
        getContentPane().setLayout(null);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 68, 740, 10);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        jLabel1.setText("Adicionar uma disciplina");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(220, 20, 330, 40);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("Disciplina:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(160, 100, 90, 30);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText("1° Nota: ");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(180, 140, 70, 30);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setText("2° Nota: ");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(180, 180, 70, 30);

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setText("4° Nota: ");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(180, 260, 70, 30);

        txtNota4.setText("0");
        txtNota4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNota4ActionPerformed(evt);
            }
        });
        txtNota4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNota4KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNota4KeyTyped(evt);
            }
        });
        getContentPane().add(txtNota4);
        txtNota4.setBounds(250, 260, 300, 30);

        txtNota2.setText("0");
        txtNota2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNota2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNota2KeyTyped(evt);
            }
        });
        getContentPane().add(txtNota2);
        txtNota2.setBounds(250, 180, 300, 30);

        txtNota1.setText("0");
        txtNota1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNota1ActionPerformed(evt);
            }
        });
        txtNota1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNota1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNota1KeyTyped(evt);
            }
        });
        getContentPane().add(txtNota1);
        txtNota1.setBounds(250, 140, 300, 30);

        txtDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDisciplinaActionPerformed(evt);
            }
        });
        getContentPane().add(txtDisciplina);
        txtDisciplina.setBounds(250, 100, 300, 30);

        jButton2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/salvar.png"))); // NOI18N
        jButton2.setText("Salvar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(200, 310, 110, 30);

        jButton3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cancelar.png"))); // NOI18N
        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(440, 310, 110, 30);

        jButton4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/limpar.png"))); // NOI18N
        jButton4.setText("Limpar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(320, 310, 110, 30);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setText("3° Nota: ");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(180, 220, 70, 30);

        txtNota3.setText("0");
        txtNota3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNota3ActionPerformed(evt);
            }
        });
        txtNota3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNota3KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNota3KeyTyped(evt);
            }
        });
        getContentPane().add(txtNota3);
        txtNota3.setBounds(250, 220, 300, 30);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/saude.jpg"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(0, 0, 750, 410);

        setSize(new java.awt.Dimension(753, 438));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //Chama o método adicionarDisciplina
        if(txtDisciplina.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Digite a disciplina para poder adicionar um boletim.");
        }
        else if(  txtDisciplina.getText().isEmpty() || 
                    txtNota1.getText().isEmpty() || 
                    txtNota2.getText().isEmpty() ||
                    txtNota3.getText().isEmpty() ||
                    txtNota4.getText().isEmpty() )
        {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
        }
        else if( Double.parseDouble(txtNota1.getText()) < 0 || Double.parseDouble(txtNota1.getText()) > 10 || 
                 Double.parseDouble(txtNota2.getText()) < 0 || Double.parseDouble(txtNota2.getText()) > 10 || 
                 Double.parseDouble(txtNota3.getText()) < 0 || Double.parseDouble(txtNota3.getText()) > 10 || 
                 Double.parseDouble(txtNota4.getText()) < 0 || Double.parseDouble(txtNota4.getText()) > 10 )
        {
            JOptionPane.showMessageDialog(null, "Sua nota deve ser entre 0 e 10");
        }
        
        else
        {
        BoletimDAO boletim = new  BoletimDAO();
        
        double media = (Double.parseDouble(txtNota1.getText()) 
                      + Double.parseDouble(txtNota2.getText()) 
                      + Double.parseDouble(txtNota3.getText()) 
                      + Double.parseDouble(txtNota4.getText())) / 4;
        
        Boletim b = new Boletim (  txtDisciplina.getText(), 
                                   Double.parseDouble(txtNota1.getText()), 
                                   Double.parseDouble(txtNota2.getText()), 
                                   Double.parseDouble(txtNota3.getText()), 
                                   Double.parseDouble(txtNota4.getText()),
                                   media);
        boletim.inserirDisciplina(MeuBoletim.linhaBoletim, b );
        boletim.getDisciplina(MeuBoletim.linhaBoletim);
        dispose();
        dispose();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       //Fecha a JDialog sem fechar o programa
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //Ação do botão limpar , que vai setar os JTextFields com nada
        txtDisciplina.setText("");
        txtNota1.setText("0");
        txtNota2.setText("0");
        txtNota3.setText("0");
        txtNota4.setText("0");
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtNota4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNota4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNota4ActionPerformed

    private void txtNota3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNota3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNota3ActionPerformed

    private void txtDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDisciplinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDisciplinaActionPerformed

    private void txtNota1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNota1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNota1ActionPerformed

    private void txtNota1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNota1KeyTyped
        String caracteres="0987654321.";
        if(!caracteres.contains(evt.getKeyChar()+"")){
        evt.consume();
        }   
    }//GEN-LAST:event_txtNota1KeyTyped

    private void txtNota2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNota2KeyTyped
        String caracteres="0987654321.";
        if(!caracteres.contains(evt.getKeyChar()+"")){
        evt.consume();
        }  
    }//GEN-LAST:event_txtNota2KeyTyped

    private void txtNota3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNota3KeyTyped
        String caracteres="098765432.1";
        if(!caracteres.contains(evt.getKeyChar()+"")){
        evt.consume();
        }  
    }//GEN-LAST:event_txtNota3KeyTyped

    private void txtNota4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNota4KeyTyped
        String caracteres="0987654321.";
        if(!caracteres.contains(evt.getKeyChar()+""))
        {
        evt.consume();
        }  
    }//GEN-LAST:event_txtNota4KeyTyped

    private void txtNota1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNota1KeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_PERIOD) 
    {  
        pontoNota1++;
        if(pontoNota1 > 1)
        {
        JOptionPane.showMessageDialog(null, "Uma nota pode conter dois pontos.");
        pontoNota1 = 0;
        
        String caracteres="098765432.1";
        if(!caracteres.contains(evt.getKeyChar()+""))
        {
        evt.consume();
        }
         
        txtNota1.setText("0");
        }
    }        
    }//GEN-LAST:event_txtNota1KeyPressed

    private void txtNota2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNota2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_PERIOD) 
    {  
        pontoNota2++;
        if(pontoNota2 > 1)
        {
        JOptionPane.showMessageDialog(null, "Uma nota não pode conter dois pontos.");
        pontoNota2 = 0;
        
        String caracteres="098765432.1";
        if(!caracteres.contains(evt.getKeyChar()+""))
        {
        evt.consume();
        }
         
        txtNota2.setText("0");
        }
    }     
    }//GEN-LAST:event_txtNota2KeyPressed

    private void txtNota3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNota3KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_PERIOD) 
    {  
        pontoNota3++;
        if(pontoNota3 > 1)
        {
        JOptionPane.showMessageDialog(null, "Uma nota não pode conter dois pontos.");
        pontoNota3 = 0;
        
        String caracteres="098765432.1";
        if(!caracteres.contains(evt.getKeyChar()+""))
        {
        evt.consume();
        }
         
        txtNota3.setText("0");
        }
    }     
    }//GEN-LAST:event_txtNota3KeyPressed

    private void txtNota4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNota4KeyPressed
     if (evt.getKeyCode() == KeyEvent.VK_PERIOD) 
    {  
        pontoNota4++;
        if(pontoNota4 > 1)
        {
        JOptionPane.showMessageDialog(null, "Uma nota não pode conter dois pontos.");
        pontoNota4 = 0;
        
        String caracteres="098765432.1";
        if(!caracteres.contains(evt.getKeyChar()+""))
        {
        evt.consume();
        }
         
        txtNota4.setText("0");
        }
    }     
    }//GEN-LAST:event_txtNota4KeyPressed
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
            java.util.logging.Logger.getLogger(AdicionarDisciplina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdicionarDisciplina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdicionarDisciplina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdicionarDisciplina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                AdicionarDisciplina dialog = new AdicionarDisciplina(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtDisciplina;
    private javax.swing.JTextField txtNota1;
    private javax.swing.JTextField txtNota2;
    private javax.swing.JTextField txtNota3;
    private javax.swing.JTextField txtNota4;
    // End of variables declaration//GEN-END:variables
}
