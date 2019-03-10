/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import Modelos.Atividade;
import Modelos.Usuario;

/**
 *
 * @author Cabessa
 */
public interface IDAOUsuario 
{
    public Usuario getUsuario( String nome, String senha );//pega o id do usuario String porque vai receber o nunmero da caixa de texto
    public void inserirUsuario( Usuario usuario );// void nao retorna
    public void atualizarUsuario( Usuario usuario );
    public void deletarUsuario();    
}
