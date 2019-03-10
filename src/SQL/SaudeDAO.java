package SQL;

import Banco.DAO;
import Banco.IDAOSaude;
import Interfaces.MinhaSaude;
import Modelos.ModeloTabela;
import Modelos.Saude;
import Modelos.Usuario;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;


public class SaudeDAO extends DAO implements IDAOSaude
{
    
    public SaudeDAO(){
        super();
    }

    public void adicionarSaude(Saude saude){

        String sql = "INSERT INTO saude (altura,peso,imc,situacao,saude_usuario) VALUES(?,?,?,?,?)";
        
        try 
        {
           PreparedStatement stmt = conexao.prepareStatement(sql);
           stmt.setDouble(1, saude.getAltura());
           stmt.setDouble(2, saude.getPeso());
           stmt.setDouble(3, saude.getImc());
           stmt.setString(4, saude.getSituacao());
           stmt.setDouble(5, Usuario.getId() );
           stmt.execute();

           stmt.close();
           JOptionPane.showMessageDialog(null, "Registro inserido com sucesso. \nVocê poderá ver o seus registros na tabela de históricos!");

        } catch (SQLException u) 
        {
           JOptionPane.showMessageDialog(null, "Erro, verifique se os dados foram digitados corretamente");
        }
    }

    @Override
    public Saude getSaude()
    {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[] {"ID","Altura","Peso","IMC","Situação"};
     
        
        try {
            instrucao = conexao.prepareStatement("SELECT idsaude,altura,peso,imc,situacao FROM saude where saude_usuario = " + Usuario.getId() + " order by idsaude");
            resultado = instrucao.executeQuery();
            resultado.first();
            do {
                dados.add(new Object[]{
                    resultado.getInt("idsaude"),
                    resultado.getDouble("altura"),
                    resultado.getDouble("peso"),
                    resultado.getDouble("imc"),
                    resultado.getString("situacao")});
            } while (resultado.next());
            
        } catch (SQLException ex) {
            
        }
        JTableHeader cabecalho = MinhaSaude.jTableSaude.getTableHeader();  
        cabecalho.setFont(new Font("Arial", Font.BOLD, 16));
        ModeloTabela modelo = new ModeloTabela(dados,Colunas);
        
        MinhaSaude.jTableSaude.setModel(modelo);
        MinhaSaude.jTableSaude.getColumnModel().getColumn( 0 ).setMaxWidth( 0 );  
        MinhaSaude.jTableSaude.getColumnModel().getColumn( 0 ).setMinWidth( 0 );  
        MinhaSaude.jTableSaude.getTableHeader().getColumnModel().getColumn( 0 ).setMaxWidth( 0 );  
        MinhaSaude.jTableSaude.getTableHeader().getColumnModel().getColumn( 0 ).setMinWidth( 0 );
        MinhaSaude.jTableSaude.getColumnModel().getColumn(1).setPreferredWidth(50);
        MinhaSaude.jTableSaude.getColumnModel().getColumn(4).setPreferredWidth(200);
        
        MinhaSaude.jTableSaude.getTableHeader().setReorderingAllowed(false);   
        MinhaSaude.jTableSaude.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        
        MinhaSaude.jTableSaude.setRowHeight(20);  
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer(); 
        centralizado.setHorizontalAlignment(SwingConstants.CENTER); 
        
        return null;
        
    }

    public void deletarSaude(String linhaSaude)
    {
        if ("0".equals(linhaSaude))
        {
            JOptionPane.showMessageDialog(null,"Selecione uma linha para excluir");
        }
        else
        {
            try
            {
                instrucao = conexao.prepareStatement( "DELETE FROM saude WHERE idsaude = " + linhaSaude );
                instrucao.execute();
                JOptionPane.showMessageDialog(null, "Registro de Saude deletado com sucesso!");
                linhaSaude = "0";
            }
            catch (SQLException u)
            {   
                JOptionPane.showMessageDialog(null, "Erro, verifique se os dados foram digitados corretamente");

            }
        }
    }
}
