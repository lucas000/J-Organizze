/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import Banco.DAO;
import Banco.IDAODespesa;
import Interfaces.AdicionarDespesa;
import Interfaces.AlterarDespesa;
import static Interfaces.AlterarDespesa.txtAdiantamento;
import Interfaces.MinhasDespesas;
import Modelos.Despesa;
import Modelos.ModeloTabela;
import Modelos.Usuario;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Cabessa i5
 */
public class DespesaDAO extends DAO implements IDAODespesa 
{
    private Despesa despesa;
     
    public DespesaDAO() 
    {
        super();
    }

    @Override
    public Despesa getDespesa() 
    {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"ID","Descriçao","Valor","Adiantamento","Restante","Vecimento"};
        try {
            instrucao = conexao.prepareStatement("SELECT iddespesa,descricao,valorinicial,adiantamento,restante,vencimento FROM despesa where despesa_usuario = " + Usuario.getId() +" order by iddespesa");
            resultado = instrucao.executeQuery();
            resultado.first();
            
            do 
            {
                dados.add(new Object[]
                {resultado.getInt("iddespesa"),
                resultado.getString("descricao"),
                resultado.getDouble("valorinicial"),
                resultado.getDouble("adiantamento"),
                resultado.getDouble("restante"),
                resultado.getDate("vencimento")});

            } 
            while(resultado.next());                    
        } 
        catch (SQLException ex)
        {
            
        }

        JTableHeader cabecalho = MinhasDespesas.jTableDespesas.getTableHeader();  
        cabecalho.setFont(new Font("Arial", Font.BOLD, 16));
        ModeloTabela modelo = new ModeloTabela(dados,Colunas);
        
        MinhasDespesas.jTableDespesas.setModel(modelo);
        MinhasDespesas.jTableDespesas.getColumnModel().getColumn( 0 ).setMaxWidth( 0 );  
        MinhasDespesas.jTableDespesas.getColumnModel().getColumn( 0 ).setMinWidth( 0 );  
        MinhasDespesas.jTableDespesas.getTableHeader().getColumnModel().getColumn( 0 ).setMaxWidth( 0 );  
        MinhasDespesas.jTableDespesas.getTableHeader().getColumnModel().getColumn( 0 ).setMinWidth( 0 );
        MinhasDespesas.jTableDespesas.getColumnModel().getColumn(1).setPreferredWidth(202);
        MinhasDespesas.jTableDespesas.getColumnModel().getColumn(3).setPreferredWidth(95);
        
        MinhasDespesas.jTableDespesas.getTableHeader().setReorderingAllowed(false);   
        MinhasDespesas.jTableDespesas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        
        MinhasDespesas.jTableDespesas.setRowHeight(20);  
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();        
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        
        return null;
    }

    @Override
    public void inserirDespesa(Despesa despesa) 
    {      
        
    
        try
        {
            instrucao = conexao.prepareStatement("INSERT INTO despesa (descricao,valorinicial,adiantamento,restante,vencimento,despesa_usuario) VALUES(?,?,?,?,?,?)");//isso so funciona pra varchar
            instrucao.setNString(  1, Despesa.getDescricao());
            instrucao.setDouble (  2, Despesa.getValorInicial());
            instrucao.setDouble (  3, Despesa.getAdiantamento());
            instrucao.setDouble (  4, Despesa.getRestante());    
            instrucao.setDate   (  5,Despesa.getVencimento());
            instrucao.setInt    (  6, Usuario.getId());
            instrucao.executeUpdate();  
            
            
            AdicionarDespesa despesaMMM = new AdicionarDespesa(null, true);
            JOptionPane.showMessageDialog( despesaMMM , "Despesa '"+ Despesa.getDescricao()+ "' inserida com sucesso!");
            
        }
        catch( SQLException e )
        {
            System.err.println( e );
        }
       
                    ;
    }

     @Override
    public void atualizarDespesa(String linhaDespesa) 
    {  
        
        try
        {
            instrucao = conexao.prepareStatement("UPDATE despesa set descricao = ?, valorinicial = ?, adiantamento = ?, restante = ? where iddespesa = " + linhaDespesa);//isso so funciona pra varchar
            
            double restante = Double.parseDouble(AlterarDespesa.txtvalorInicial.getText()) - Double.parseDouble(txtAdiantamento.getText());
            
            instrucao.setNString(1, AlterarDespesa.txtDescricao.getText());
            instrucao.setDouble(2, Double.parseDouble(AlterarDespesa.txtvalorInicial.getText()));
            instrucao.setDouble(3, Double.parseDouble(AlterarDespesa.txtAdiantamento.getText()) );
            instrucao.setDouble(4, restante);
            instrucao.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Despesa "+ Despesa.getDescricao() + " atualizada com sucesso!");
        }
        catch( SQLException e )
        {
            JOptionPane.showMessageDialog(null, "Erro , tente colocar informações válidas!");
        }
    }
    
    @Override
    public void deletarDespesa(String linhaDespesa) 
    {
        if (linhaDespesa == "0")
        {
            JOptionPane.showMessageDialog(null,"Selecione uma linha para excluir");
        }
        else
        {
            try
            {
                instrucao = conexao.prepareStatement( "DELETE FROM despesa WHERE iddespesa = " + linhaDespesa );
                instrucao.execute();
                JOptionPane.showMessageDialog(null, "Despesa deletada com sucesso!");
            }
            catch( SQLException e )
            {
                System.err.println( e );
            }
        }
    } 
    public void deletarDespesaPaga(String linhaDespesa) 
    {
        if (linhaDespesa == "0")
        {
            JOptionPane.showMessageDialog(null,"Selecione uma linha para excluir");
        }
        else
        {
            try
            {
                instrucao = conexao.prepareStatement( "DELETE FROM despesa WHERE iddespesa = " + linhaDespesa );
                instrucao.execute();
            }
            catch( SQLException e )
            {
                System.err.println( e );
            }
        }
    } 
    public void pagarDespesa(String linhaDespesa)
    {

        String sql = ("update despesa set restante = ? where iddespesa = " + linhaDespesa);
        try {

           instrucao = conexao.prepareStatement(sql);
           instrucao.setDouble(1, Despesa.getTotal());
           
          
           instrucao.execute();
           instrucao.close();
           
           JOptionPane.showMessageDialog(null, "Despesa paga com sucesso!");

        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
    public Despesa getRecuperar(String id)
    {
        try 
        {
            instrucao = conexao.prepareStatement( "SELECT * FROM despesa WHERE iddespesa = " + id );
            resultado = instrucao.executeQuery();
            
            if( resultado.next() )//next retorna um boolean 1 se achou um usuarios 0 se nao achou 
            {
                despesa = new Despesa(resultado.getInt( "iddespesa" ), 
                                      resultado.getString( "descricao" ),
                                      resultado.getInt( "valorinicial" ), 
                                      resultado.getInt( "adiantamento" ) 
                                     );// entre aspas e o nome das colunas no banco
                                        
                                        
            }
            else
            {
                System.out.println("Não Foi Encontrado Nenhum Usuário!");
            }
        }
        catch( SQLException sql) 
        {
            System.err.println( sql );
            
        }
        
        return despesa;
    }
} 


   

