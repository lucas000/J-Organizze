package Interfaces;
import Modelos.Usuario;
import SQL.AtividadeDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;


public class MinhasAtividades extends javax.swing.JDialog{
   public static String linhaAtividade = "0";
   public static int linha_selecionada = 0;
   public static String linhaDescricao;
   public static String linhaData;
   public static String linhaHora;
   AtividadeDAO atividade = new AtividadeDAO();
   int contFiltro = 0;
   
    public MinhasAtividades(java.awt.Frame parent, boolean modal) 
    {
        super(parent, modal);
        initComponents();
        labelFiltro.setVisible(false);
        txtDescricao.setVisible(false);
        cbCategoria.setVisible(false);
        buttonProcurar.setVisible(false);
        separador1.setVisible(false);
        separador2.setVisible(false);
        this.populaComboBox();
        
        btnExcluir.addMouseListener(new MouseAdapter() {  
    public void mouseClicked(MouseEvent me) 
    {  
        //Verificando se o botão direito do mouse foi clicado  
        if ((me.getModifiers() & MouseEvent.BUTTON3_MASK) != 0) 
        {  
            JPopupMenu menu = new JPopupMenu();  
            JMenuItem item = new JMenuItem("Excluir todas as atividades");  
            menu.add(item);  
              
            item.addActionListener(new ActionListener()
            {  
                public void actionPerformed(ActionEvent ae) 
                {  
                    AtividadeDAO atividade = new AtividadeDAO();
                    int resposta = JOptionPane.showConfirmDialog(null, "Deseja excluir todas as suas atividades?"); 
                    if(resposta == 0)
                    {
                        atividade.deletarTodasAtividades();
                        atividade.getAtividade();
                        
                    }else if(resposta == 1)
                    {
                        JOptionPane.showMessageDialog(null, "Todas as suas atividades foram mantidas");
                        
                    }else if(resposta == 2)
                    {
                        
                    }
                }  
            });  
  
            menu.show(btnExcluir, me.getX(), me.getY());  
        }  
    }  
});  
    } 
    public static void populaComboBox()
    {
        String sql = "SELECT idcategoria,categoria FROM categoria where categoria_usuario =" + Usuario.getId();
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
      
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Titulo1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAtividades = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtDescricao = new javax.swing.JTextField();
        labelFiltro = new javax.swing.JLabel();
        cbCategoria = new javax.swing.JComboBox();
        buttonProcurar = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        separador2 = new javax.swing.JSeparator();
        separador1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Minhas Atividades");
        setIconImage(new ImageIcon(getClass().getResource("/imagens/icon.png")).getImage());
        setResizable(false);
        getContentPane().setLayout(null);

        Titulo1.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        Titulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titulo1.setText("Minhas Atividades");
        getContentPane().add(Titulo1);
        Titulo1.setBounds(320, 20, 300, 50);

        jTableAtividades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableAtividades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAtividadesMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableAtividadesMousePressed(evt);
            }
        });
        jTableAtividades.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableAtividadesKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTableAtividades);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(90, 130, 710, 360);

        jButton1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/adicionar.png"))); // NOI18N
        jButton1.setText("Adicionar atividade");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(130, 500, 180, 40);

        btnExcluir.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cancelar.png"))); // NOI18N
        btnExcluir.setText("Excluir atividade");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir);
        btnExcluir.setBounds(590, 500, 170, 40);

        jButton3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/editar.png"))); // NOI18N
        jButton3.setText("Alterar atividade");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(370, 500, 180, 40);

        txtDescricao.setToolTipText("Descrição..");
        getContentPane().add(txtDescricao);
        txtDescricao.setBounds(110, 90, 200, 30);

        labelFiltro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        labelFiltro.setText("Filtrar por");
        getContentPane().add(labelFiltro);
        labelFiltro.setBounds(80, 60, 80, 20);

        cbCategoria.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos" }));
        cbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCategoriaActionPerformed(evt);
            }
        });
        getContentPane().add(cbCategoria);
        cbCategoria.setBounds(310, 90, 110, 30);

        buttonProcurar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        buttonProcurar.setText("Buscar");
        buttonProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonProcurarActionPerformed(evt);
            }
        });
        getContentPane().add(buttonProcurar);
        buttonProcurar.setBounds(440, 90, 80, 30);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/filtro.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(750, 90, 50, 40);
        getContentPane().add(separador2);
        separador2.setBounds(150, 70, 290, 20);

        separador1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(separador1);
        separador1.setBounds(90, 80, 50, 40);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/fazer.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(830, 0, 80, 90);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Minhas14.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 920, 560);

        setSize(new java.awt.Dimension(923, 590));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        AtividadeDAO atividade = new AtividadeDAO();      
        atividade.deletarAtividade(linhaAtividade);     
        linhaAtividade = "0"; 
        atividade.getAtividade();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void jTableAtividadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAtividadesMouseClicked
                linha_selecionada = jTableAtividades.getSelectedRow();
                 linhaAtividade = (String.valueOf(jTableAtividades.getValueAt(linha_selecionada, 0)));
                 linhaDescricao = (String.valueOf(jTableAtividades.getValueAt(linha_selecionada, 1)));
                 linhaData = (String.valueOf(jTableAtividades.getValueAt(linha_selecionada, 2)));
                 linhaHora= (String.valueOf(jTableAtividades.getValueAt(linha_selecionada, 3)));
                 
                 
    }//GEN-LAST:event_jTableAtividadesMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFrame mainFrame = new JFrame();        
        AdicionarAtividade atividades = new AdicionarAtividade(mainFrame, true);
        atividades.setLocationRelativeTo(mainFrame);
        atividades.setVisible(true); 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if ("0".equals(linhaAtividade))
        {
            JOptionPane.showMessageDialog(null, "Ecolha uma atividade para editar!");
        }
        else
        {        
        JFrame mainFrame = new JFrame();
        AlterarAtividade atividades = new AlterarAtividade(mainFrame, true);
        atividades.setLocationRelativeTo(mainFrame);
        atividades.setVisible(true);    
                
        
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCategoriaActionPerformed

    private void buttonProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonProcurarActionPerformed
        if(txtDescricao.getText().isEmpty() && cbCategoria.getSelectedItem().equals("Todos"))
        {
            
            atividade.getAtividade();
        }else if(txtDescricao.getText().isEmpty() && !cbCategoria.getSelectedItem().equals("Todos"))
        {
            atividade.getAtividadeCategoria();
        }
        else if (!txtDescricao.getText().isEmpty() && cbCategoria.getSelectedItem().equals("Todos"))
        {
            atividade.getAtividadeDescricao();
        }else if(!txtDescricao.getText().isEmpty() && !cbCategoria.getSelectedItem().equals("Todos"))
        {
                atividade.getAtividadeIguais();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Bug no filtro");
        }
    }//GEN-LAST:event_buttonProcurarActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        contFiltro++;
        if(contFiltro < 2)
        {
            labelFiltro.setVisible(true);
            txtDescricao.setVisible(true);
            cbCategoria.setVisible(true);
            buttonProcurar.setVisible(true);
            separador1.setVisible(true);
            separador2.setVisible(true);
            
        }
        else
        {
            labelFiltro.setVisible(false);
            txtDescricao.setVisible(false);
            cbCategoria.setVisible(false);
            buttonProcurar.setVisible(false);
            separador1.setVisible(false);
            separador2.setVisible(false);
            contFiltro = 0;
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTableAtividadesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableAtividadesKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) 
        {
        AtividadeDAO atividade = new AtividadeDAO();      
        atividade.deletarAtividade(linhaAtividade);     
        linhaAtividade = "0"; 
        atividade.getAtividade();  
        }
    }//GEN-LAST:event_jTableAtividadesKeyPressed

    private void jTableAtividadesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAtividadesMousePressed
        linha_selecionada = jTableAtividades.getSelectedRow();
                 linhaAtividade = (String.valueOf(jTableAtividades.getValueAt(linha_selecionada, 0)));
                 linhaDescricao = (String.valueOf(jTableAtividades.getValueAt(linha_selecionada, 1)));
                 linhaData = (String.valueOf(jTableAtividades.getValueAt(linha_selecionada, 2)));
                 linhaHora= (String.valueOf(jTableAtividades.getValueAt(linha_selecionada, 3)));
    }//GEN-LAST:event_jTableAtividadesMousePressed

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
            java.util.logging.Logger.getLogger(MinhasAtividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MinhasAtividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MinhasAtividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MinhasAtividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MinhasAtividades dialog = new MinhasAtividades(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel Titulo1;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton buttonProcurar;
    public static javax.swing.JComboBox cbCategoria;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTableAtividades;
    private javax.swing.JLabel labelFiltro;
    private javax.swing.JSeparator separador1;
    private javax.swing.JSeparator separador2;
    public static javax.swing.JTextField txtDescricao;
    // End of variables declaration//GEN-END:variables
}
