package Interfaces;

import static Banco.DAO.conexao;
import static Banco.DAO.instrucao;
import static Banco.DAO.resultado;
import Modelos.Atividade;
import Modelos.Usuario;
import SQL.AtividadeDAO;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class AdicionarAtividade extends javax.swing.JDialog 
{

    
    public AdicionarAtividade(java.awt.Frame parent, boolean modal) 
    {
        super(parent, modal);
        initComponents();
        this.populaComboBox();
        
    }
    
    String idCategoria;
    String idCategoriaExcluir;
    
    public static void populaComboBox()
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
    
    //Método responsável por adicionar uma nova atividade
    public void adicionarAtividade()
    {
        if(txtDescricao.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Dê uma descrição para sua atividade!");
        }
        else if(txtData.getDate() == null)
        {
                        JOptionPane.showMessageDialog(null, "Defina uma data para sua atividade!");

        }
        else if(Integer.parseInt(String.valueOf(hora.getValue())) < 0 || Integer.parseInt(String.valueOf(hora.getValue())) > 23)
        {
            JOptionPane.showMessageDialog(null, "Hora inválida!");
        }
        else if(Integer.parseInt(String.valueOf(minuto.getValue())) < 0 || Integer.parseInt(String.valueOf(minuto.getValue())) > 59)
        {
            JOptionPane.showMessageDialog(null, "Minuto inválido!");
        }
        else
        {
        AtividadeDAO atividade = new  AtividadeDAO();
        
        String horas =   String.valueOf(hora.getValue());
        String minutos = String.valueOf(minuto.getValue());
        String Horas = horas + ":" + minutos;
        
        
        java.sql.Date dataSql = new java.sql.Date(txtData.getDate().getTime());
        
        Atividade a = new Atividade ( txtDescricao.getText(), dataSql, Horas, Integer.parseInt(horas), Integer.parseInt(minutos), String.valueOf(cbCategoria.getSelectedItem()));
        atividade.inserirAtividade( a );
        atividade.getAtividade();
        dispose();
        
        
        } 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtDescricao = new javax.swing.JTextField();
        txtData = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        minuto = new javax.swing.JSpinner();
        hora = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        cbCategoria = new javax.swing.JComboBox();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adicionar Atividade");
        setIconImage(new ImageIcon(getClass().getResource("/imagens/icon.png")).getImage());
        setResizable(false);
        getContentPane().setLayout(null);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 40, 400, 10);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("Adicionar uma atividade");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(110, 0, 200, 40);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Descrição:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 60, 59, 30);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Data:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(70, 100, 30, 30);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Minutos:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(160, 140, 50, 30);

        jButton1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/salvar.png"))); // NOI18N
        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(40, 260, 100, 30);

        jButton2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cancelar.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(260, 260, 110, 30);

        jButton3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/limpar.png"))); // NOI18N
        jButton3.setText("Limpar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(150, 260, 100, 30);
        getContentPane().add(txtDescricao);
        txtDescricao.setBounds(100, 60, 250, 30);
        getContentPane().add(txtData);
        txtData.setBounds(100, 100, 250, 30);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Horas:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(60, 140, 40, 30);
        getContentPane().add(minuto);
        minuto.setBounds(210, 140, 50, 30);
        getContentPane().add(hora);
        hora.setBounds(100, 140, 50, 30);

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Categoria:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(40, 190, 60, 30);

        cbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCategoriaActionPerformed(evt);
            }
        });
        getContentPane().add(cbCategoria);
        cbCategoria.setBounds(100, 190, 100, 30);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/adicionar.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(210, 190, 40, 30);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cancelar.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(260, 190, 40, 30);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bg.jpg"))); // NOI18N
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 410, 330);

        setSize(new java.awt.Dimension(417, 355));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Chama o método adicionarAtividade
        adicionarAtividade();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       //Fecha a JDialog sem fechar o programa
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //Ação do botão limpar , que vai setar os JTextFields com nada
        txtDescricao.setText("");
        txtData.setDate(null);
        hora.setValue(00);
        minuto.setValue(00);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCategoriaActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    JFrame mainFrame = new JFrame();
        AdicionarCategoria cat = new AdicionarCategoria(mainFrame, true);
        cat.setLocationRelativeTo(mainFrame);
        cat.setVisible(true);
    
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try
        {
            //String sql = "select idcategoria from categoria where categoria = " + Atividade.getIdCategoria();
            instrucao = conexao.prepareStatement("select idcategoria from categoria where categoria = '" + cbCategoria.getSelectedItem()+ "'");
            resultado = instrucao.executeQuery();

            if(resultado.next())
            {
                idCategoriaExcluir = resultado.getString("idcategoria");
            }

            instrucao = conexao.prepareStatement("DELETE FROM categoria where idcategoria = " +  idCategoriaExcluir);
            instrucao.execute();
            JOptionPane.showMessageDialog(null, "Categoria excluida!");
            cbCategoria.removeAllItems();
            populaComboBox();

        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Há atividades dependentes desta categoria!");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(AdicionarAtividade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdicionarAtividade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdicionarAtividade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdicionarAtividade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AdicionarAtividade dialog = new AdicionarAtividade(new javax.swing.JFrame(), true);
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
    public static javax.swing.JComboBox cbCategoria;
    private javax.swing.JSpinner hora;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner minuto;
    private com.toedter.calendar.JDateChooser txtData;
    private javax.swing.JTextField txtDescricao;
    // End of variables declaration//GEN-END:variables
}
