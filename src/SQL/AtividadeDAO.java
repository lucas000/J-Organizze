package SQL;

import Banco.DAO;
import Banco.IDAOAtividade;
import static Interfaces.AdicionarAtividade.cbCategoria;
import Interfaces.AlterarAtividade;
import Interfaces.MinhasAtividades;
import Modelos.Atividade;
import Modelos.ModeloTabela;
import Modelos.Usuario;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;


public class AtividadeDAO extends DAO implements IDAOAtividade //herda de DAO e implementa as interface de IDAOUsuario
{
    private Atividade atividade;
    String idCategoria;
    
    public AtividadeDAO()//construtor
    {
        super();
    }
    //objeto e uma instancia da classe e serve pra executar as acoes da classe
    //classe e uma representaçao de algo do mundo real
    @Override
    public Atividade getAtividade()
    {
        
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[] {"ID","Descriçao","Data","Hora","Categoria","Situação"}  ;     
        
        try 
        {
        instrucao = conexao.prepareStatement( "SELECT idatividade, descricao, data ,horario,categoria,situacao from atividade inner join categoria on atividade_categoria = idcategoria where atividade_usuario = " +  Usuario.getId());
        resultado = instrucao.executeQuery();
        resultado.first();
        
            do 
            {
                dados.add(new Object[]
                {   resultado.getInt("idatividade"),
                    resultado.getString("descricao"),
                    resultado.getString("data"),
                    resultado.getString("horario"),
                    resultado.getString("categoria"),
                    resultado.getString("situacao")
                }
                );
                                       
            } 
            while (resultado.next());
            
        } catch (SQLException ex) 
        {
            
        }
        
        JTableHeader cabecalho = MinhasAtividades.jTableAtividades.getTableHeader();  
        cabecalho.setFont(new Font("Arial", Font.BOLD, 16));
        ModeloTabela modelo = new ModeloTabela(dados,Colunas);
        
        MinhasAtividades.jTableAtividades.setModel(modelo);
        MinhasAtividades.jTableAtividades.getColumnModel().getColumn( 0 ).setMaxWidth( 0 );  
        MinhasAtividades.jTableAtividades.getColumnModel().getColumn( 0 ).setMinWidth( 0 );  
        MinhasAtividades.jTableAtividades.getTableHeader().getColumnModel().getColumn( 0 ).setMaxWidth( 0 );  
        MinhasAtividades.jTableAtividades.getTableHeader().getColumnModel().getColumn( 0 ).setMinWidth( 0 );
        MinhasAtividades.jTableAtividades.getColumnModel().getColumn(1).setPreferredWidth(332);
        
        MinhasAtividades.jTableAtividades.getTableHeader().setReorderingAllowed(false);   
        MinhasAtividades.jTableAtividades.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        
        MinhasAtividades.jTableAtividades.setRowHeight(20);  
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer(); 
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        
        return null;
    }
    public Atividade getAtividadeCategoria()
    {
        
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[] {"ID","Descriçao","Data","Hora","Categoria","Situação"}  ;     
        
        try {
        instrucao = conexao.prepareStatement( "SELECT idatividade, descricao, data ,horario,categoria,situacao from atividade inner join categoria on atividade_categoria = idcategoria where atividade_usuario = " +  Usuario.getId() + " and categoria = '"+MinhasAtividades.cbCategoria.getSelectedItem()+"'");
        resultado = instrucao.executeQuery();
        resultado.first();
        
            do 
            {
                dados.add(new Object[]
                {   resultado.getInt("idatividade"),
                    resultado.getString("descricao"),
                    resultado.getString("data"),
                    resultado.getString("horario"),
                    resultado.getString("categoria"),
                    resultado.getString("situacao")
                }
                );
                                       
            } 
            while (resultado.next());
            
        } catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Nenhum resultado encontrado");
        }
        
        JTableHeader cabecalho = MinhasAtividades.jTableAtividades.getTableHeader();  
        cabecalho.setFont(new Font("Arial", Font.BOLD, 16));
        ModeloTabela modelo = new ModeloTabela(dados,Colunas);
        
        MinhasAtividades.jTableAtividades.setModel(modelo);
        MinhasAtividades.jTableAtividades.getColumnModel().getColumn( 0 ).setMaxWidth( 0 );  
        MinhasAtividades.jTableAtividades.getColumnModel().getColumn( 0 ).setMinWidth( 0 );  
        MinhasAtividades.jTableAtividades.getTableHeader().getColumnModel().getColumn( 0 ).setMaxWidth( 0 );  
        MinhasAtividades.jTableAtividades.getTableHeader().getColumnModel().getColumn( 0 ).setMinWidth( 0 );
        MinhasAtividades.jTableAtividades.getColumnModel().getColumn(1).setPreferredWidth(332);
        
        MinhasAtividades.jTableAtividades.getTableHeader().setReorderingAllowed(false);   
        MinhasAtividades.jTableAtividades.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        
        MinhasAtividades.jTableAtividades.setRowHeight(20);  
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer(); 
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        
        return null;
    }
    public Atividade getAtividadeDescricao()
    {
        
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[] {"ID","Descriçao","Data","Hora","Categoria","Situação"}  ;     
        
        try {
        instrucao = conexao.prepareStatement( "SELECT idatividade, descricao, data ,horario,categoria,situacao from atividade inner join categoria on atividade_categoria = idcategoria where atividade_usuario = " +  Usuario.getId() + " and descricao like "+ "'%"+ MinhasAtividades.txtDescricao.getText()+"%'");
        resultado = instrucao.executeQuery();
        resultado.first();
        
            do 
            {
                dados.add(new Object[]
                {   resultado.getInt("idatividade"),
                    resultado.getString("descricao"),
                    resultado.getString("data"),
                    resultado.getString("horario"),
                    resultado.getString("categoria"),
                    resultado.getString("situacao")
                }
                );
                                       
            } 
            while (resultado.next());
            
        } catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Nenhum resultado encontrado");
        }
        
        JTableHeader cabecalho = MinhasAtividades.jTableAtividades.getTableHeader();  
        cabecalho.setFont(new Font("Arial", Font.BOLD, 16));
        ModeloTabela modelo = new ModeloTabela(dados,Colunas);
        
        MinhasAtividades.jTableAtividades.setModel(modelo);
        MinhasAtividades.jTableAtividades.getColumnModel().getColumn( 0 ).setMaxWidth( 0 );  
        MinhasAtividades.jTableAtividades.getColumnModel().getColumn( 0 ).setMinWidth( 0 );  
        MinhasAtividades.jTableAtividades.getTableHeader().getColumnModel().getColumn( 0 ).setMaxWidth( 0 );  
        MinhasAtividades.jTableAtividades.getTableHeader().getColumnModel().getColumn( 0 ).setMinWidth( 0 );
        MinhasAtividades.jTableAtividades.getColumnModel().getColumn(1).setPreferredWidth(332);
        
        MinhasAtividades.jTableAtividades.getTableHeader().setReorderingAllowed(false);   
        MinhasAtividades.jTableAtividades.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        
        MinhasAtividades.jTableAtividades.setRowHeight(20);  
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer(); 
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        
        return null;
    }
    public Atividade getAtividadeIguais()
    {
        
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[] {"ID","Descriçao","Data","Hora","Categoria","Situação"}  ;     
        
        try {
        instrucao = conexao.prepareStatement( "SELECT idatividade, descricao, data ,horario,categoria,situacao from atividade inner join categoria on atividade_categoria = idcategoria where atividade_usuario = " +  Usuario.getId() + " and categoria = '"+ MinhasAtividades.cbCategoria.getSelectedItem() +"' and descricao like "+ "'%"+ MinhasAtividades.txtDescricao.getText()+"%'");
        resultado = instrucao.executeQuery();
        resultado.first();
        
            do 
            {
                dados.add(new Object[]
                {   resultado.getInt("idatividade"),
                    resultado.getString("descricao"),
                    resultado.getString("data"),
                    resultado.getString("horario"),
                    resultado.getString("categoria"),
                    resultado.getString("situacao")
                }
                );
                                       
            } 
            while (resultado.next());
            
        } catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Nenhum resultado encontrado");
        }
        
        JTableHeader cabecalho = MinhasAtividades.jTableAtividades.getTableHeader();  
        cabecalho.setFont(new Font("Arial", Font.BOLD, 16));
        ModeloTabela modelo = new ModeloTabela(dados,Colunas);
        
        MinhasAtividades.jTableAtividades.setModel(modelo);
        MinhasAtividades.jTableAtividades.getColumnModel().getColumn( 0 ).setMaxWidth( 0 );  
        MinhasAtividades.jTableAtividades.getColumnModel().getColumn( 0 ).setMinWidth( 0 );  
        MinhasAtividades.jTableAtividades.getTableHeader().getColumnModel().getColumn( 0 ).setMaxWidth( 0 );  
        MinhasAtividades.jTableAtividades.getTableHeader().getColumnModel().getColumn( 0 ).setMinWidth( 0 );
        MinhasAtividades.jTableAtividades.getColumnModel().getColumn(1).setPreferredWidth(332);
        
        MinhasAtividades.jTableAtividades.getTableHeader().setReorderingAllowed(false);   
        MinhasAtividades.jTableAtividades.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        
        MinhasAtividades.jTableAtividades.setRowHeight(20);  
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer(); 
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        
        return null;
    }
    

    @Override
    public void inserirAtividade(Atividade atividade)
    {   
        try 
        {
            //String sql = "select idcategoria from categoria where categoria = " + Atividade.getIdCategoria();
            instrucao = conexao.prepareStatement("select idcategoria from categoria where categoria = '" +  Atividade.getIdCategoria() + "'");
            resultado = instrucao.executeQuery();            
            while(resultado.next())
            {                
            idCategoria = resultado.getString("idcategoria");            
            }          

        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
        
       try
       {
            instrucao = conexao.prepareStatement("INSERT INTO atividade (descricao,data,horario,cbhora,cbminuto,atividade_usuario,atividade_categoria) VALUES(?,?,?,?,?,?,?)");//isso so funciona pra varchar
            instrucao.setNString(1, Atividade.getDescricao() );
            instrucao.setDate   (2, Atividade.getData() );
            instrucao.setNString(3, Atividade.getHora() );
            instrucao.setInt(4, Atividade.getHora1());
            instrucao.setInt(5, Atividade.getMinuto() );
            instrucao.setInt(6, Usuario.getId());
            instrucao.setString(7, idCategoria );
            instrucao.execute();
            
            JOptionPane.showMessageDialog(null, "Atividade '"+ Atividade.getDescricao() + "' registrada!");
        }
        catch( SQLException e )
        {
             JOptionPane.showMessageDialog(null, "Selecione uma categoria para relacionar esta atividade!");

        }
    }

    @Override
    public void atualizarAtividade(Atividade atividade , String linhaAtividade)
    {   
        try 
        {
            //String sql = "select idcategoria from categoria where categoria = " + Atividade.getIdCategoria();
            instrucao = conexao.prepareStatement("select idcategoria from categoria where categoria = '" +  Atividade.getIdCategoria() + "'");
            resultado = instrucao.executeQuery();            
            while(resultado.next())
            {                
            idCategoria = resultado.getString("idcategoria");            
            }          

        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
        if(AlterarAtividade.txtDescricao.getText().isEmpty() || AlterarAtividade.txtData.getDate() == null)
        {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos");
        }
        else if(Integer.parseInt(String.valueOf(AlterarAtividade.cbHora.getValue())) < 0 || Integer.parseInt(String.valueOf(AlterarAtividade.cbHora.getValue())) > 23)
        {
            JOptionPane.showMessageDialog(null, "Hora inválida!");
        }
        else if(Integer.parseInt(String.valueOf(AlterarAtividade.cbMinuto.getValue())) < 0 || Integer.parseInt(String.valueOf(AlterarAtividade.cbMinuto.getValue())) > 59)
        {
            JOptionPane.showMessageDialog(null, "Minuto inválido!");
        }
        else
        {
        try
        {
            String situacao = "";
           instrucao = conexao.prepareStatement("UPDATE atividade set descricao = ?, data = ?,horario = ?, cbhora = ?,cbminuto = ?, situacao = ?, atividade_categoria = ? where idatividade = " + linhaAtividade);//isso so funciona pra varchar
            
            if(AlterarAtividade.boxRealizada.isSelected())
            {
                situacao = "REALIZADA";
            }else
            {
               situacao = "PENDENTE";
            }
            
            instrucao.setNString(1, Atividade.getDescricao() );
            instrucao.setDate   (2, Atividade.getData() );
            instrucao.setNString(3, Atividade.getHora());
            instrucao.setInt    (4, Atividade.getHora1());
            instrucao.setInt    (5, Atividade.getMinuto());
            instrucao.setString (6, situacao);
            instrucao.setString (7, idCategoria);
            instrucao.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atividade atualizada com sucesso!");      
           
        
        }
        
        catch( SQLException e )
        {
            System.err.println( e );
        }
        }
    }
    public Atividade getRecuperar(String id)
    {
        try 
        {
            instrucao = conexao.prepareStatement( "SELECT * FROM atividade WHERE idatividade = " + id );
            resultado = instrucao.executeQuery();
            
            if( resultado.next() )//next retorna um boolean 1 se achou um usuarios 0 se nao achou 
            {
                atividade = new Atividade(resultado.getInt( "idatividade" ), 
                                       resultado.getString( "descricao" ),
                                       resultado.getDate  ( "data" ), 
                                       resultado.getString( "horario" ),
                                       resultado.getInt   ( "cbhora" ),
                                       resultado.getInt( "cbminuto" ),
                                       resultado.getString("situacao")
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
        
        return atividade;
    }

    
    @Override
    public void deletarAtividade(String linhaAtividade)
    {
        if(linhaAtividade.equals("0"))
        {
            JOptionPane.showMessageDialog(null, "Ecolha uma atividade para excluir!");
        }
        else
        {
            try
        {
            instrucao = conexao.prepareStatement( "DELETE FROM atividade WHERE idatividade = " + linhaAtividade );
            instrucao.execute();
            JOptionPane.showMessageDialog(null, "Atividade deletada com sucesso!");
            
        }
        catch( SQLException e )
        {
            System.err.println( e );
        }
        }
        
    }
    
       
    public void recuperar(Integer linhaAtividade)
    
        {    
            Connection connection = null;
        if(linhaAtividade.equals("0"))
        {
            JOptionPane.showMessageDialog(null, "Selecione uma linha para excluir");
        }
        else
        {
        
             String sql = "UPDATE atividade set descricao = ?, data = ?, horario = ? where idatividade = " + linhaAtividade;
        try {

           PreparedStatement stmt = connection.prepareStatement(sql);
           stmt.setString(1, Atividade.getDescricao());
           stmt.setDate(2, Atividade.getData());
           stmt.setString(3, Atividade.getHora());
          
           stmt.execute();
           stmt.close();

        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
            
        }
        }
        
    public void deletarTodasAtividades()
        {
        
        try
        {
            instrucao = conexao.prepareStatement( "DELETE FROM atividade where atividade_usuario = " + Usuario.getId());
            instrucao.execute();
            JOptionPane.showMessageDialog(null, "Todas suas atividades foram excluidas!");
            
        }
        catch( SQLException e )
        {
            System.err.println( e );
        }
        }
        
    }
        
    

