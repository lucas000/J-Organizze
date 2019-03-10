package Interfaces;

import Modelos.Despesa;
import SQL.DespesaDAO;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class MinhasDespesas extends javax.swing.JDialog 
{
    static String linhaDespesa = "0";
    public MinhasDespesas(java.awt.Frame parent, boolean modal) 
    {
        super(parent, modal);
        initComponents();
        this.populaSomaTotal();
        
    }
    
    public void populaSomaTotal()
    {
        String sql = "SELECT SUM(valorinicial) FROM despesa";
        try 
        {
            Banco.DAO.instrucao = Banco.DAO.conexao.prepareStatement(sql);
            Banco.DAO.resultado = Banco.DAO.instrucao.executeQuery();
            
            Banco.DAO.resultado.first();
            txtSomaTotal.setText(String.valueOf(Banco.DAO.resultado.getDouble(1)));                        
            
            
        } catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e);
         }
        
        
    }

    
        
        /*DespesaDAO dao = new DespesaDAO();
        try {
            txtSomaTotal.setText(dao.getMaiorDistanciaPercorrida()+"");
        } catch (SQLException ex) {
            Logger.getLogger(MinhasDespesas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        */  
    public void deletaFinanca()
    {
        if (linhaDespesa.equals("0"))
        {
            JOptionPane.showMessageDialog(null,"Ecolha uma despesa para excluir");
        }
        else 
        {
        DespesaDAO despesa = new DespesaDAO();      
        despesa.deletarDespesa(linhaDespesa);
        linhaDespesa = "0"; 
        despesa.getDespesa();
        }
        txtRestante.setText("0");
        txtPagar.setText("0");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDespesas = new javax.swing.JTable();
        txtRestante = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        txtPagar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        txtSomaTotal = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Minhas Despesas");
        setIconImage(new ImageIcon(getClass().getResource("/imagens/icon.png")).getImage());
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        jLabel1.setText("Minhas Despesas");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(380, 10, 300, 60);

        jButton3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/adicionar.png"))); // NOI18N
        jButton3.setText("Adicionar gasto");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(60, 460, 150, 40);

        jButton4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cancelar.png"))); // NOI18N
        jButton4.setText("Apagar Gasto");
        jButton4.setToolTipText("Clique com o botão direito para deletar todos os seus gastos");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(430, 460, 140, 40);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/calculadora.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(780, 120, 70, 80);

        jTableDespesas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableDespesas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDespesasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTableDespesasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTableDespesasMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableDespesasMousePressed(evt);
            }
        });
        jTableDespesas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableDespesasKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTableDespesasKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTableDespesas);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(50, 120, 720, 330);

        txtRestante.setEditable(false);
        txtRestante.setText("0");
        txtRestante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRestanteActionPerformed(evt);
            }
        });
        getContentPane().add(txtRestante);
        txtRestante.setBounds(1010, 190, 90, 30);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Restante a pagar:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(890, 190, 120, 30);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(860, 120, 20, 330);

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Deseja pagar um gasto ?");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(870, 120, 280, 20);

        txtPagar.setText("0");
        txtPagar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPagarKeyTyped(evt);
            }
        });
        getContentPane().add(txtPagar);
        txtPagar.setBounds(1010, 230, 90, 30);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Valor a pagar:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(910, 230, 100, 30);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pagar.png"))); // NOI18N
        jButton6.setText("Pagar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(1010, 270, 90, 30);

        txtSomaTotal.setEditable(false);
        txtSomaTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSomaTotalActionPerformed(evt);
            }
        });
        getContentPane().add(txtSomaTotal);
        txtSomaTotal.setBounds(650, 470, 120, 30);

        jButton7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/editar.png"))); // NOI18N
        jButton7.setText("Editar gasto");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(250, 460, 150, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Fiinanca.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(1080, 0, 80, 90);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("TOTAL:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(590, 470, 50, 30);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/minhas4.jpg"))); // NOI18N
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
        });
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 1170, 560);

        setSize(new java.awt.Dimension(1175, 573));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        JFrame mainFrame = new JFrame();        
        AdicionarDespesa adicionar = new AdicionarDespesa(mainFrame, true);
        adicionar.setLocationRelativeTo(mainFrame);
        adicionar.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try
        {  
            Runtime.getRuntime().exec("calc.exe"); 
        }  
        catch (IOException exc) {  
           exc.printStackTrace();  
        } 
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
            deletaFinanca();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTableDespesasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDespesasMouseClicked
        int linha_selecionada = jTableDespesas.getSelectedRow();
        
        linhaDespesa = (String.valueOf(jTableDespesas.getValueAt(linha_selecionada, 0)));
        txtRestante.setText(String.valueOf(jTableDespesas.getValueAt(linha_selecionada, 4)));
       if(txtRestante.getText().equals("0.0"))
       {
           txtPagar.setText("Pago!");
           txtPagar.setEditable(false);
       }else
       {
           txtPagar.setEditable(true);
           txtPagar.setText("0");
       }
        
    }//GEN-LAST:event_jTableDespesasMouseClicked

    private void txtRestanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRestanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRestanteActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       if(linhaDespesa.equals("0"))
       {
           JOptionPane.showMessageDialog(null, "Seleceione a despesa que deseja pagar!");
       }
       else if(txtPagar.getText().equals("Pago!"))
       {
           JOptionPane.showMessageDialog(null, "Sua despesa já foi paga, não é possivel altera-la!");
       }
       else if( Double.parseDouble(txtPagar.getText()) >= Double.parseDouble(txtRestante.getText()))
       {
       DespesaDAO despesa = new DespesaDAO();
       Double total = Double.parseDouble(txtRestante.getText()) - Double.parseDouble(txtPagar.getText());
       
        if(total <= 0 )
        {
            int resposta = JOptionPane.showConfirmDialog(null, "Sua despesa será quitada, deseja exluí-la?");
             if (resposta == 0)
             {
                 despesa.pagarDespesa(linhaDespesa); 
                 despesa.deletarDespesaPaga(linhaDespesa);
                 despesa.getDespesa();
                 
             }else if (resposta == 1)
             {
                  total = 0.0;
                  
                  Despesa d = new Despesa(total);
                  despesa.pagarDespesa(linhaDespesa);
                  despesa.getDespesa();
                  
             }                       
            
        } 
       }
       
       else 
       {
       DespesaDAO despesa = new DespesaDAO();
       Double total = Double.parseDouble(txtRestante.getText()) - Double.parseDouble(txtPagar.getText());
        
       Despesa d = new Despesa(total);
       despesa.pagarDespesa(linhaDespesa);
       despesa.getDespesa();
       }
       
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if ("0".equals(linhaDespesa))
        {
            JOptionPane.showMessageDialog(null, "Ecolha uma despesa para editar!");
        }
        else if(txtPagar.getText().equals("Pago!"))
       {
           JOptionPane.showMessageDialog(null, "Sua despesa já foi paga, não é possivel altera-la!");
       }
        else
        {        
        JFrame mainFrame = new JFrame();
        AlterarDespesa despesa = new AlterarDespesa(mainFrame, true);
        despesa.setLocationRelativeTo(mainFrame);
        despesa.setVisible(true);         
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTableDespesasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDespesasMouseEntered
        populaSomaTotal();
    }//GEN-LAST:event_jTableDespesasMouseEntered

    private void jTableDespesasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDespesasMouseExited
        populaSomaTotal();
    }//GEN-LAST:event_jTableDespesasMouseExited

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        // TODO add your handling code here:
        populaSomaTotal();
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        // TODO add your handling code here:
         populaSomaTotal();
    }//GEN-LAST:event_jLabel3MouseExited

    private void txtPagarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPagarKeyTyped
        String caracteres="0987654321.";
        if(!caracteres.contains(evt.getKeyChar()+""))
        {
        evt.consume();
        }  
    }//GEN-LAST:event_txtPagarKeyTyped

    private void jTableDespesasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableDespesasKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableDespesasKeyTyped

    private void txtSomaTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSomaTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSomaTotalActionPerformed

    private void jTableDespesasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableDespesasKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) 
        {
        DespesaDAO despesa = new DespesaDAO();      
        despesa.deletarDespesa(linhaDespesa);     
        linhaDespesa = "0"; 
        despesa.getDespesa();  
        }
    }//GEN-LAST:event_jTableDespesasKeyPressed

    private void jTableDespesasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDespesasMousePressed
        int linha_selecionada = jTableDespesas.getSelectedRow();
        
        linhaDespesa = (String.valueOf(jTableDespesas.getValueAt(linha_selecionada, 0)));
        txtRestante.setText(String.valueOf(jTableDespesas.getValueAt(linha_selecionada, 4)));
       if(txtRestante.getText().equals("0.0"))
       {
           txtPagar.setText("Pago!");
           txtPagar.setEditable(false);
       }else
       {
           txtPagar.setEditable(true);
           txtPagar.setText("0");
       }
    }//GEN-LAST:event_jTableDespesasMousePressed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MinhasDespesas dialog = new MinhasDespesas(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JTable jTableDespesas;
    private javax.swing.JTextField txtPagar;
    private javax.swing.JTextField txtRestante;
    private javax.swing.JTextField txtSomaTotal;
    // End of variables declaration//GEN-END:variables
}
