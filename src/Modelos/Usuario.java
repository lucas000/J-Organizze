/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Cabessa i5
 */
public class Usuario 
{
    static private int id;
    static private String nome;
    static private String senha;
    static private String Cpf;
    static private String confirmacao;

    public Usuario(int id) 
    {
        Usuario.id = id;
    }
   
    
    public Usuario(String nome, String Cpf)
    {
        Usuario.nome = nome;
        Usuario.Cpf = Cpf;
    }
    
    public Usuario(String nome, String Cpf, String senha)
    {
        Usuario.nome = nome;
        Usuario.Cpf = Cpf;
        Usuario.senha = senha;
    }
    public Usuario(String nome, String confirmacao, String Cpf, String senha)
    {
        Usuario.nome = nome;
        Usuario.confirmacao = confirmacao;
        Usuario.Cpf = Cpf;
        Usuario.senha = senha;
    }
    
    public static String getCpf() {
        return Cpf;
    }

    public void setCpf(String Cpf) {
        Usuario.Cpf = Cpf;
    }

    public static String getConfirmacao() {
        return confirmacao;
    }

    public static void setConfirmacao(String confirmacao) {
        Usuario.confirmacao = confirmacao;
    }   
    
    public static int getId()
    {
        return id;
    }
    public static void setId( int id )
    {
        Usuario.id = id;
    }
    public static String getNome()
    {
        return nome;
    }
    public void setNome( String nome )
    {
        Usuario.nome = nome;
    }
    public static String getSenha()
    {
        return senha;
    }
    public void setSenha ( String senha )
    {
        Usuario.senha = senha;
    }
}
