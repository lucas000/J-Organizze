/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import static Interfaces.MinhasAtividades.linhaAtividade;
import Modelos.Atividade;
import Modelos.Usuario;
import SQL.AtividadeDAO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class AlterarAtividade extends javax.swing.JDialog {

    
    public AlterarAtividade(java.awt.Frame parent, boolean modal) 
    {
        super(parent, modal);
        initComponents();
        populaComboBox();
    }
    
    public void populaComboBox()
    {
        String sql = "SELECT idcategoria,categoria FROM categoria where categoria_usuario = " + Usuario.getId();
        try 
        {
            Banco.DAO.instrucao = Banco.DAO.conexao.prepareStatement(sql);
            Banco.DAO.resultado = Banco.DAO.instrucao.executeQuery();
            
            while (Banco.DAO.resultado.next())
            {
                cbCategoria.addItem(Banco.DAO.resultado.getString("categoria"));                        
            }
            
        } catch (Exception e) 
        {
            System.err.print(e);
         }
        
        
    }
    public void AlterarAtividade()
    {
        if(txtDescricao.getText().isEmpty() || txtData.getDate() == null)
        {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos");
        }
        else if(Integer.parseInt(String.valueOf(cbHora.getValue())) < 0 || Integer.parseInt(String.valueOf(cbHora.getValue())) > 23)
        {
            JOptionPane.showMessageDialog(null, "Hora inválida!");
        }
        else if(Integer.parseInt(String.valueOf(cbMinuto.getValue())) < 0 || Integer.parseInt(String.valueOf(cbMinuto.getValue())) > 59)
        {
            JOptionPane.showMessageDialog(null, "Minuto inválido!");
        }
        else
        {
        AtividadeDAO atividade = new  AtividadeDAO();
        
        String horas =   String.valueOf(cbHora.getValue());
        String minutos = String.valueOf(cbMinuto.getValue());
        String Horas = horas + ":" + minutos;
        
        
        java.sql.Date dataSql = new java.sql.Date(txtData.getDate().getTime());
        
        Atividade a = new Atividade ( txtDescricao.getText(), dataSql, Horas, Integer.parseInt(horas), Integer.parseInt(minutos), String.valueOf(cbCategoria.getSelectedItem()));
        atividade.atualizarAtividade( a , linhaAtividade );
        atividade.getAtividade();
        dispose();
        
        
        } 
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
        jLabel2 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        txtData = new com.toedter.calendar.JDateChooser();
        cbHora = new javax.swing.JSpinner();
        cbMinuto = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        cbCategoria = new javax.swing.JComboBox();
        boxRealizada = new javax.swing.JCheckBox();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alterar Atividade");
        setIconImage(new ImageIcon(getClass().getResource("/imagens/icon.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        jLabel1.setText("Alterar atividade");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(233, 26, 227, 40);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Descrição:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(175, 103, 59, 30);

        txtDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescricaoActionPerformed(evt);
            }
        });
        getContentPane().add(txtDescricao);
        txtDescricao.setBounds(238, 103, 220, 30);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Data:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(205, 143, 29, 30);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Hora:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(204, 184, 30, 30);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/salvar.png"))); // NOI18N
        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(252, 270, 90, 30);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cancelar.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(352, 270, 103, 30);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 77, 648, 8);
        getContentPane().add(txtData);
        txtData.setBounds(238, 139, 220, 33);
        getContentPane().add(cbHora);
        cbHora.setBounds(238, 184, 50, 32);
        getContentPane().add(cbMinuto);
        cbMinuto.setBounds(308, 184, 50, 32);

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Categoria:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(180, 230, 57, 26);

        cbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCategoriaActionPerformed(evt);
            }
        });
        getContentPane().add(cbCategoria);
        cbCategoria.setBounds(240, 230, 120, 30);

        boxRealizada.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        boxRealizada.setText("Atividade realizada");
        getContentPane().add(boxRealizada);
        boxRealizada.setBounds(390, 200, 180, 40);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(380, 180, 10, 80);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/saude.jpg"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, -6, 660, 360);

        setBounds(0, 0, 664, 383);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        AlterarAtividade();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //Fecha a JDialog sem fechar o programa
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
             
        AtividadeDAO atividade = new AtividadeDAO();      
        atividade.getRecuperar( linhaAtividade );
        
        String situacao = Atividade.getSituacao();
        
        txtDescricao.setText(Atividade.getDescricao());
        txtData.setDate(Atividade.getData());
        cbHora.setValue(Atividade.getHora1());
        cbMinuto.setValue(Atividade.getMinuto());
        if(situacao.equals("PENDENTE"))
        {
         boxRealizada.setSelected(false);
        }
        else{
            boxRealizada.setSelected(true);
        }
        
    }//GEN-LAST:event_formWindowOpened

    private void txtDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescricaoActionPerformed

    private void cbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCategoriaActionPerformed

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
            java.util.logging.Logger.getLogger(AlterarAtividade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlterarAtividade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlterarAtividade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlterarAtividade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AlterarAtividade dialog = new AlterarAtividade(new javax.swing.JFrame(), true);
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
    public static javax.swing.JCheckBox boxRealizada;
    private javax.swing.JComboBox cbCategoria;
    public static javax.swing.JSpinner cbHora;
    public static javax.swing.JSpinner cbMinuto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    public static com.toedter.calendar.JDateChooser txtData;
    public static javax.swing.JTextField txtDescricao;
    // End of variables declaration//GEN-END:variables
}
