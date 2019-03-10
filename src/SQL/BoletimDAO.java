/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import Banco.DAO;
import Banco.IDAOBoletim;
import Interfaces.AlterarBoletim;
import Interfaces.AlterarDisciplina;
import Interfaces.MeuBoletim;
import Modelos.Boletim;
import Modelos.ModeloTabela;
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

/**
 *
 * @author Cabessa i5
 */
public class BoletimDAO extends DAO implements IDAOBoletim 
{
    private Boletim boletim;
    public BoletimDAO() {
        super();
    }

    @Override
    public Boletim getBoletim() 
    {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"ID","Instituição","Ano"};

        try {
            instrucao = conexao.prepareStatement("SELECT idboletim,instituicao,ano"
                    + " FROM boletim where boletim_usuario = " + Usuario.getId() + " order by ano desc");
            resultado = instrucao.executeQuery();
            resultado.first();
            do {
                dados.add(new Object[]{resultado.getInt("idboletim"), resultado.getString("instituicao"),
                    resultado.getString("ano")});
            } while (resultado.next());
        } 
        catch (SQLException ex) 
        {

        }

        JTableHeader cabecalho = MeuBoletim.jTableBoletim.getTableHeader();  
        cabecalho.setFont(new Font("Arial", Font.BOLD, 16));
        ModeloTabela modelo = new ModeloTabela(dados,Colunas);
        
        MeuBoletim.jTableBoletim.setModel(modelo);
        MeuBoletim.jTableBoletim.getColumnModel().getColumn( 0 ).setMaxWidth( 0 );  
        MeuBoletim.jTableBoletim.getColumnModel().getColumn( 0 ).setMinWidth( 0 );  
        MeuBoletim.jTableBoletim.getTableHeader().getColumnModel().getColumn( 0 ).setMaxWidth( 0 );  
        MeuBoletim.jTableBoletim.getTableHeader().getColumnModel().getColumn( 0 ).setMinWidth( 0 );
        MeuBoletim.jTableBoletim.getColumnModel().getColumn(1).setPreferredWidth(252);
        
        MeuBoletim.jTableBoletim.getTableHeader().setReorderingAllowed(false);   
        MeuBoletim.jTableBoletim.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        
        MeuBoletim.jTableBoletim.setRowHeight(20);  
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer(); 
        centralizado.setHorizontalAlignment(SwingConstants.CENTER); 
        
        return null;
    }
    public Boletim getDisciplina(String linhaBoletim) 
    {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"ID","Disciplina", "Nota 1", "Nota 2", "Nota 3", "Nota 4", "Média Final"};

        try {
            instrucao = conexao.prepareStatement("SELECT iddisciplina,disciplina,nota1,nota2,nota3,nota4,media FROM disciplina where disciplina_boletim = " + linhaBoletim + " order by iddisciplina");
            resultado = instrucao.executeQuery();
            resultado.first();
            do {
                dados.add(new Object[]{resultado.getInt("iddisciplina"), 
                    resultado.getString("disciplina"),
                    resultado.getDouble("nota1"), 
                    resultado.getDouble("nota2"), 
                    resultado.getDouble("nota3"),
                    resultado.getDouble("nota4"),
                    resultado.getDouble("media")});
            } while (resultado.next());
        } 
        catch (SQLException ex) 
        {
            
        }

        JTableHeader cabecalho = MeuBoletim.jTableNotas.getTableHeader();  
        cabecalho.setFont(new Font("Arial", Font.BOLD, 16));
        ModeloTabela modelo = new ModeloTabela(dados,Colunas);
        
        MeuBoletim.jTableNotas.setModel(modelo);
        MeuBoletim.jTableNotas.getColumnModel().getColumn( 0 ).setMaxWidth( 0 );  
        MeuBoletim.jTableNotas.getColumnModel().getColumn( 0 ).setMinWidth( 0 );  
        MeuBoletim.jTableNotas.getTableHeader().getColumnModel().getColumn( 0 ).setMaxWidth( 0 );  
        MeuBoletim.jTableNotas.getTableHeader().getColumnModel().getColumn( 0 ).setMinWidth( 0 );
        MeuBoletim.jTableNotas.getColumnModel().getColumn(1).setPreferredWidth(252);
        MeuBoletim.jTableNotas.getColumnModel().getColumn(6).setPreferredWidth(120);
        
        MeuBoletim.jTableNotas.getTableHeader().setReorderingAllowed(false);   
        MeuBoletim.jTableNotas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        
        MeuBoletim.jTableNotas.setRowHeight(20);  
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer(); 
        centralizado.setHorizontalAlignment(SwingConstants.CENTER); 
        
        return null;
    }
    public void deletarBoletim(String linhaBoletim)
    {
        try 
        {
            instrucao = conexao.prepareStatement("DELETE FROM boletim WHERE idboletim = " + linhaBoletim);
            instrucao.execute();
            
            JOptionPane.showMessageDialog(null, "Boletim deletado com sucesso!");

        }
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, "Há disciplinas dependente deste boletim !");
        }
    }
    public void deletarDisciplina(String linhaNota)
    {
        try 
        {
            instrucao = conexao.prepareStatement("DELETE FROM disciplina WHERE iddisciplina = " + linhaNota);
            instrucao.execute();
            
            JOptionPane.showMessageDialog(null, "Disciplina deletada com sucesso!");

        }
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void inserirDisciplina(String linhaSelecionada , Boletim boletim)
    {
        String sql = "INSERT INTO disciplina (disciplina,nota1,nota2,nota3,nota4,media,disciplina_boletim) VALUES(?,?,?,?,?,?,?)";
        try 
        {

            PreparedStatement stmt = conexao.prepareStatement(sql);
            
                stmt.setString(1, Boletim.getDisciplina());
                stmt.setDouble(2, Boletim.getNota1());
                stmt.setDouble(3, Boletim.getNota2());
                stmt.setDouble(4, Boletim.getNota3());
                stmt.setDouble(5, Boletim.getNota4());
                stmt.setDouble(6, boletim.getMediaFinal());
                stmt.setString(7, linhaSelecionada);
                
                
                stmt.execute();
            
           JOptionPane.showMessageDialog(null,"Disciplina inserida com sucesso!");

        }
        catch( NumberFormatException | SQLException r )
        {
            JOptionPane.showMessageDialog(null, "Selecione um boletim para inserir esta disciplina" );
            
        }
        
    }
    public void inserirBoletim(Boletim boletim)
    {
        String sql = "INSERT INTO boletim (instituicao, ano, anosemestre , semestre ,boletim_usuario) VALUES (?,?,?,?,?)";
        try 
        {

            PreparedStatement stmt = conexao.prepareStatement(sql);
            
                stmt.setString(1, Boletim.getInstituicao());
                stmt.setString(2, Boletim.getAno());
                stmt.setInt(3, Boletim.getAnosemestre());
                stmt.setString(4, Boletim.getSemestre());
                stmt.setInt(5, Usuario.getId());
                stmt.execute();
            
           JOptionPane.showMessageDialog(null,"Boletim inserido com sucesso!");

        }
        catch( NumberFormatException | SQLException r )
        {
          JOptionPane.showMessageDialog(null, "Erro, verifique se os dados foram digitados corretamente");
        }
        
    }
    public Boletim getRecuperarBoletim(String id)
    {
        try 
        {
            instrucao = conexao.prepareStatement( "SELECT * FROM boletim WHERE idboletim = " + id );
            resultado = instrucao.executeQuery();
            
            if( resultado.next() )//next retorna um boolean 1 se achou um usuarios 0 se nao achou 
            {
                boletim = new Boletim(resultado.getInt( "idboletim" ), 
                                      resultado.getString( "instituicao" ),
                                      resultado.getString("ano"),
                                      resultado.getInt("anosemestre"),
                                      resultado.getString("semestre")
                                     );// entre aspas e o nome das colunas no banco
                                        
            }
        }
        catch( SQLException sql)
        {
          JOptionPane.showMessageDialog(null, "Erro, verifique se os dados foram digitados corretamente");

        }
        
        return boletim;
    }
    public Boletim getRecuperarDisciplina(String id)
    {
        try 
        {
            instrucao = conexao.prepareStatement( "SELECT * FROM disciplina WHERE iddisciplina = " + id );
            resultado = instrucao.executeQuery();
            
            if( resultado.next() )//next retorna um boolean 1 se achou um usuarios 0 se nao achou 
            {
                boletim = new Boletim(resultado.getInt   ( "iddisciplina" ), 
                                      resultado.getString( "disciplina" ),
                                      resultado.getDouble( "nota1" ), 
                                      resultado.getDouble( "nota2" ),
                                      resultado.getDouble( "nota3" ),
                                      resultado.getDouble( "nota4" )
                                     );// entre aspas e o nome das colunas no banco
                                        
            }
        }
        catch( SQLException sql)
        {
            JOptionPane.showMessageDialog(null, sql);
            
        }
        
        return boletim;
    }
    public void atualizarBoletim(String linhaBoletim)
    {   
        
        try
        {
            String ano = AlterarBoletim.txtAno.getValue()+"" + "/"+ AlterarBoletim.cbSemestre.getSelectedItem()+"";
            
            instrucao = conexao.prepareStatement("UPDATE boletim set instituicao = ?, ano = ? where idboletim = " + linhaBoletim);//isso so funciona pra varchar
            instrucao.setNString(1, AlterarBoletim.txtInstituicao.getText() );
            instrucao.setNString(2, ano );
            
            instrucao.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Boletim atualizado com sucesso!");
        }
        catch( SQLException e )
        {
         JOptionPane.showMessageDialog(null, "Erro, verifique se os dados foram digitados corretamente");

        }
    }
    public void atualizarDisciplina(String linhaBoletim)
    {   
        
        try
        {
            instrucao = conexao.prepareStatement("UPDATE disciplina set disciplina = ?, nota1 = ?, nota2 = ?, nota3 = ? , nota4 = ?, media = ? where iddisciplina = " + linhaBoletim);//isso so funciona pra varchar
            
            double media = (Double.parseDouble(AlterarDisciplina.txtNota1.getText()) 
                      + Double.parseDouble(AlterarDisciplina.txtNota2.getText()) 
                      + Double.parseDouble(AlterarDisciplina.txtNota3.getText()) 
                      + Double.parseDouble(AlterarDisciplina.txtNota4.getText())) / 4;
            
            instrucao.setNString(1, AlterarDisciplina.txtDisciplina.getText() );
            instrucao.setDouble (2, Double.parseDouble(AlterarDisciplina.txtNota1.getText()) );
            instrucao.setDouble (3, Double.parseDouble(AlterarDisciplina.txtNota2.getText()) );
            instrucao.setDouble (4, Double.parseDouble(AlterarDisciplina.txtNota3.getText()) );
            instrucao.setDouble (5, Double.parseDouble(AlterarDisciplina.txtNota4.getText()) );
            instrucao.setDouble (6, media);
            instrucao.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Disciplina atualizada com sucesso!");
        }
        catch( SQLException e )
        {
          JOptionPane.showMessageDialog(null, "Erro, verifique se os dados foram digitados corretamente");

        }
    }
}
