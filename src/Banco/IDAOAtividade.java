/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import Interfaces.AdicionarDespesa;
import Modelos.Atividade;

/**
 *
 * @author Cabessa
 */
public interface IDAOAtividade 
{
    
    public Atividade getAtividade();//pega o id do usuario String porque vai receber o nunmero da caixa de texto
    public void inserirAtividade( Atividade atividade );// void nao retorna
    public void atualizarAtividade(Atividade atividade, String linhaAtividade);
    public void deletarAtividade( String linhaAtividade );
}
