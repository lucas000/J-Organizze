/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import Modelos.Despesa;

/**
 *
 * @author Cabessa
 */
public interface IDAODespesa 
{
    public Despesa getDespesa();//pega o id do usuario String porque vai receber o nunmero da caixa de texto
    public void inserirDespesa( Despesa despesa );// void nao retorna
    public void atualizarDespesa( String linhaDespesa );
    public void deletarDespesa( String linhaDespesa );   
}
