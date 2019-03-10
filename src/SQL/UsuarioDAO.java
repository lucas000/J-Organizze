
package SQL;

import Modelos.Usuario;
import Banco.DAO;
import static Banco.DAO.conexao;
import static Banco.DAO.instrucao;
import static Banco.DAO.resultado;
import Banco.IDAOUsuario;
import Interfaces.Login;
import Interfaces.Main;
import Interfaces.RecuperarSenha;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Cabessa i5
 */
public class UsuarioDAO extends DAO implements IDAOUsuario //herda de DAO e implementa as interface de IDAOUsuario
{
    private Usuario usuario;
    
    public UsuarioDAO()//construtor
    {
        super();
    }
    //objeto e uma instancia da classe e serve pra executar as acoes da classe
    //classe e uma representaçao de algo do mundo real
    @Override
    public Usuario getUsuario(String usuario, String senha)
    {
            //instrucao = conexao.prepareStatement( "SELECT * FROM usuario WHERE nome = '" + usuario + "' and senha = '" + senha + "'" );
        try 
        {
            instrucao = conexao.prepareStatement( "SELECT * FROM usuario WHERE nome = '" + usuario + "' and senha = '" + senha + "'" );
            resultado = instrucao.executeQuery();
            
            if( resultado.next() )//next retorna um boolean 1 se achou um usuarios 0 se nao achou 
            {            
                
             Usuario.setId(resultado.getInt( "idusuario" ));   
             
             Main main = new Main();
             main.setExtendedState(Main.MAXIMIZED_BOTH);
             main.setVisible(true);                                                    
                                        
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Usuário ou senha incorreto, tente novamente!");
                Login df = new Login();
                df.setVisible(true);
            }
        }
        catch( SQLException sql) 
        {
            System.err.println( sql );
            
        }
            
        return null;
    }
    
    public void recuperarSenha()
    {
       //instrucao = conexao.prepareStatement( "SELECT * FROM usuario WHERE nome = '" + usuario + "' and senha = '" + senha + "'" );
        
        try 
        {
            instrucao = conexao.prepareStatement( "SELECT * FROM usuario WHERE nome = '" + RecuperarSenha.txtUsuario.getText() + "' and cpf = '" + RecuperarSenha.txtCpf.getText() + "'");
            resultado = instrucao.executeQuery();
            
            if( resultado.next() )//next retorna um boolean 1 se achou um usuarios 0 se nao achou 
            {
                try{
                
                    instrucao = conexao.prepareStatement("UPDATE usuario set nome = ?, cpf = ?, senha = ? where nome = '" + RecuperarSenha.txtUsuario.getText() + "' and cpf = '" + RecuperarSenha.txtCpf.getText() + "'");
                    instrucao.setNString(1, Usuario.getNome() );
                    instrucao.setNString(2, Usuario.getCpf() );
                    instrucao.setNString(3, Usuario.getSenha() );
                    instrucao.executeUpdate();
            
                    JOptionPane.showMessageDialog(null, "Sua senha foi recuperada!");
                    RecuperarSenha.txtUsuario.setText("");
                    RecuperarSenha.txtCpf.setText("");
                    RecuperarSenha.txtNovaSenha.setText("");
                    RecuperarSenha.txtConfirmacao.setText("");
                }catch( SQLException arroz)
                {
                    JOptionPane.showMessageDialog(null, arroz);
                }
                
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Não foi encontrado nenhuma conta com esse Usuário e CPF");
            }
        }
        catch( SQLException sql) 
        {
            System.err.println(sql);
        }
    }

     public Usuario getRecuperar()
    {
        try 
        {
            instrucao = conexao.prepareStatement( "SELECT * FROM usuario WHERE idusuario = " + Usuario.getId() );
            resultado = instrucao.executeQuery();
            
            if( resultado.next() )//next retorna um boolean 1 se achou um usuarios 0 se nao achou 
            {
                usuario = new Usuario(resultado.getString( "nome" ),
                                      resultado.getString( "cpf" ), 
                                      resultado.getString( "senha" ) 
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
        
        return usuario;
    }
    @Override
    public void inserirUsuario(Usuario usuario)
    {
        try
        {
            instrucao = conexao.prepareStatement("INSERT INTO usuario(nome,senha,cpf) VALUES(?,?,?)");//isso so funciona pra varchar
            instrucao.setNString( 1, Usuario.getNome() );
            instrucao.setNString( 2, Usuario.getSenha() );
            instrucao.setNString( 3, Usuario.getCpf() );
            instrucao.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Usuário '"+ Usuario.getNome() +"' inserido com sucesso!");
        }
        catch( SQLException e )
        {
            JOptionPane.showMessageDialog(null, "Usuario com o mesmo nome ou CPF já existente!");
        }
    }

    @Override
    public void atualizarUsuario(Usuario usuario)
    {
        try
        {
            instrucao = conexao.prepareStatement("UPDATE usuario set nome = ?, cpf = ?, senha = ? where idusuario =" + Usuario.getId());
            instrucao.setNString(1, Usuario.getNome() );
            instrucao.setNString(2, Usuario.getCpf() );
            instrucao.setNString(3, Usuario.getSenha() );

            instrucao.execute();
            JOptionPane.showMessageDialog(null, "Seu usuário foi alterado!");
       }
        catch( SQLException e )
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void deletarUsuario()
    {
        try
        {
            instrucao = conexao.prepareStatement( "DELETE FROM usuario WHERE idusuario = " + Usuario.getId() );
            instrucao.execute();
            JOptionPane.showMessageDialog(null, "Seu usuário foi deletado!");
        }
        catch( SQLException e )
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}

