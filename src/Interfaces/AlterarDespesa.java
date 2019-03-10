 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import static Interfaces.MinhasDespesas.linhaDespesa;
import Modelos.Despesa;
import SQL.DespesaDAO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


/**
 *
 * @author Lucas
 */
public class AlterarDespesa extends javax.swing.JDialog 
{

    /**
     * Creates new form AlterarDespesa
     */
    public AlterarDespesa(java.awt.Frame parent, boolean modal) 
    {
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

        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtAdiantamento = new javax.swing.JTextField();
        txtvalorInicial = new javax.swing.JTextField();
        txtDescricao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alterar Despesa");
        setFocusTraversalPolicyProvider(true);
        setIconImage(new ImageIcon(getClass().getResource("/imagens/icon.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/salvar.png"))); // NOI18N
        jButton2.setText("Salvar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(227, 229, 104, 30);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cancelar.png"))); // NOI18N
        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(341, 229, 104, 30);

        txtAdiantamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdiantamentoActionPerformed(evt);
            }
        });
        getContentPane().add(txtAdiantamento);
        txtAdiantamento.setBounds(225, 181, 220, 30);
        getContentPane().add(txtvalorInicial);
        txtvalorInicial.setBounds(225, 145, 220, 30);
        getContentPane().add(txtDescricao);
        txtDescricao.setBounds(225, 107, 220, 30);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Descrição: ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(151, 109, 75, 30);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Valor Inicial: ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(140, 145, 90, 30);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Adiantamento: ");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(130, 180, 100, 30);

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Alterar Despesa");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(229, 19, 220, 35);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 65, 604, 10);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/saude.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 620, 330);

        setSize(new java.awt.Dimension(621, 359));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtAdiantamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdiantamentoActionPerformed
        
    }//GEN-LAST:event_txtAdiantamentoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(txtDescricao.getText().isEmpty() || txtvalorInicial.getText().isEmpty())
        {
           JOptionPane.showMessageDialog(null, "Os campos não podem estar vazios !");
        }else
        {
        DespesaDAO despesa = new DespesaDAO();
        despesa.atualizarDespesa(linhaDespesa);
        despesa.getDespesa();
        dispose();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        DespesaDAO despesa = new DespesaDAO();
        despesa.getRecuperar( MinhasDespesas.linhaDespesa );
        txtDescricao.setText(Despesa.getDescricao());
        txtvalorInicial.setText(String.valueOf(Despesa.getValorInicial()));
        txtAdiantamento.setText(String.valueOf(Despesa.getAdiantamento()));
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(AlterarDespesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlterarDespesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlterarDespesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlterarDespesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AlterarDespesa dialog = new AlterarDespesa(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JTextField txtAdiantamento;
    public static javax.swing.JTextField txtDescricao;
    public static javax.swing.JTextField txtvalorInicial;
    // End of variables declaration//GEN-END:variables
}