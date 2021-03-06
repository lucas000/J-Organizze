package Interfaces;

import Modelos.Boletim;
import SQL.BoletimDAO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Cabessa
 */
public class AdicionarBoletim extends javax.swing.JDialog {

    /**
     * Creates new form AdicionarBoletim
     */
    public AdicionarBoletim(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtInstituicao = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cbBimestre = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adicionar boletim");
        setIconImage(new ImageIcon(getClass().getResource("/imagens/icon.png")).getImage());
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        jLabel1.setText("Adicionar um boletim");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(130, 20, 330, 40);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 68, 740, 10);

        txtInstituicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInstituicaoActionPerformed(evt);
            }
        });
        getContentPane().add(txtInstituicao);
        txtInstituicao.setBounds(220, 100, 190, 30);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText("Bimestre");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(130, 180, 90, 30);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("Instituicao:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(130, 100, 90, 30);

        jButton2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/salvar.png"))); // NOI18N
        jButton2.setText("Salvar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(190, 230, 110, 30);

        jButton3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cancelar.png"))); // NOI18N
        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(300, 230, 110, 30);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setText("Ano:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(170, 140, 50, 30);

        cbBimestre.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1º Bimestre", "2º Bimestre", "3º Bimestre", "4º Bimestre" }));
        getContentPane().add(cbBimestre);
        cbBimestre.setBounds(220, 180, 120, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bggreynovo.jpg"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 550, 300);

        setBounds(0, 0, 559, 331);
    }// </editor-fold>//GEN-END:initComponents

    private void txtInstituicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInstituicaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInstituicaoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //Chama o método adicionarDisciplina
        
        if(txtInstituicao.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Digite uma instituição para adicionar.");
        }
        else
        {
            BoletimDAO boletim = new  BoletimDAO();

            String ano = txtAno.getValue()+"" + "/"+ cbBimestre.getSelectedItem()+"";

            Boletim b = new Boletim ( txtInstituicao.getText(), ano , txtAno.getValue() , String.valueOf(cbBimestre.getSelectedItem()) );
            boletim.inserirBoletim( b );
            boletim.getBoletim();
            dispose();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //Fecha a JDialog sem fechar o programa
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(AdicionarBoletim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdicionarBoletim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdicionarBoletim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdicionarBoletim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AdicionarBoletim dialog = new AdicionarBoletim(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox cbBimestre;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtInstituicao;
    // End of variables declaration//GEN-END:variables
}
