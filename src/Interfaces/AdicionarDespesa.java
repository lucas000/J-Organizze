package Interfaces;


import Modelos.Despesa;
import SQL.DespesaDAO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class AdicionarDespesa extends javax.swing.JDialog 
{   

    public AdicionarDespesa(java.awt.Frame parent, boolean modal) 
    {
        super(parent, modal);
        initComponents(); 
    }
       
        
        //Método responsável por adicionar uma nova finança
        public void adicionarDespesa()
        {
       
        if (txtDescricao.getText().isEmpty())
        {
            //Mensagem de alerta caso algum campo esteja vazio
            JOptionPane.showMessageDialog(this, "Por favor, preecnha todos os campos!");
        }
        else if(txtValorInicial.getText().isEmpty())
        {
           JOptionPane.showMessageDialog(this, "Dê um valor para sua despesa!");
        }
        else if(txtAdiantamento.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Dê um adiantamento para sua despesa!");
        }
        else if(Double.parseDouble(txtAdiantamento.getText()) > Double.parseDouble(txtValorInicial.getText()))
        {
            JOptionPane.showMessageDialog(this, "Seu adiantamento não pode ser maior que o valor inicial!");
        }
        else if(txtVencimento.getDate() == null)
        {
        JOptionPane.showMessageDialog(this, "Data de vencimento inválida!");

        }
        else
            {
                DespesaDAO despesa = new DespesaDAO();
                
                double restante = Double.parseDouble(txtValorInicial.getText()) - Double.parseDouble(txtAdiantamento.getText());
                java.sql.Date vencimento = new java.sql.Date(txtVencimento.getDate().getTime());
                
                Despesa u = new Despesa(txtDescricao.getText(), Double.parseDouble(txtValorInicial.getText()), Double.parseDouble(txtAdiantamento.getText()), restante, vencimento);
                despesa.inserirDespesa(u);
                despesa.getDespesa();
                
                dispose();
                
            }
        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtDescricao = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtAdiantamento = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        txtValorInicial = new javax.swing.JTextField();
        txtVencimento = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nova despesa");
        setAlwaysOnTop(true);
        setIconImage(new ImageIcon(getClass().getResource("/imagens/icon.png")).getImage());
        setResizable(false);
        getContentPane().setLayout(null);
        getContentPane().add(txtDescricao);
        txtDescricao.setBounds(150, 60, 170, 30);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 22)); // NOI18N
        jLabel1.setText("Adicionar uma despesa");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(100, 0, 240, 40);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Descrição:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(90, 60, 60, 30);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Valor:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(115, 100, 40, 30);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Vencimento:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(80, 190, 70, 30);

        txtAdiantamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAdiantamentoKeyTyped(evt);
            }
        });
        getContentPane().add(txtAdiantamento);
        txtAdiantamento.setBounds(150, 140, 170, 30);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/salvar.png"))); // NOI18N
        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(30, 250, 100, 30);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cancelar.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(270, 250, 110, 30);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/limpar.png"))); // NOI18N
        jButton3.setText("Limpar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(150, 250, 100, 30);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 40, 410, 10);

        txtValorInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorInicialKeyTyped(evt);
            }
        });
        getContentPane().add(txtValorInicial);
        txtValorInicial.setBounds(150, 100, 170, 30);
        getContentPane().add(txtVencimento);
        txtVencimento.setBounds(150, 190, 170, 30);

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Adiantamento:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(70, 140, 80, 30);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bg.jpg"))); // NOI18N
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 420, 320);

        setSize(new java.awt.Dimension(422, 346));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Chama o método adicionarFinanca        
        adicionarDespesa();                  
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //Fecha a JDialog sem fechar o programa         
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //Ação do botão limpar , que vai setar os JTextFields com nada
        txtDescricao.setText("");
        txtValorInicial.setText("0");
        txtAdiantamento.setText("0");
        txtVencimento.setDate(null);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtValorInicialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorInicialKeyTyped
        //Permite que nos JtextFields seja digitado apenas os caracteres dado dentro da variável "caracteres"    
        String caracteres="0987654321";
        if(!caracteres.contains(evt.getKeyChar()+"")){
        evt.consume();
        }    
    }//GEN-LAST:event_txtValorInicialKeyTyped

    private void txtAdiantamentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAdiantamentoKeyTyped
        //Permite que nos JtextFields seja digitado apenas os caracteres dado dentro da variável "caracteres"    
        String caracteres="0987654321";
        if(!caracteres.contains(evt.getKeyChar()+""))
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtAdiantamentoKeyTyped

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AdicionarDespesa dialog = new AdicionarDespesa(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtAdiantamento;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtValorInicial;
    private com.toedter.calendar.JDateChooser txtVencimento;
    // End of variables declaration//GEN-END:variables
}
