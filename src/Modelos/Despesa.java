/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.sql.Date;

/**
 *
 * @author Cabessa i5
 */
public class Despesa 
{    
    static int id;
    static String descricao;
    static double valorInicial;
    static double restante;
    static double adiantamento;
    static double total;
    static double pagar;
    static double somaTotal;
    static java.sql.Date vencimento;

    public static Date getVencimento() {
        return vencimento;
    }

    public static void setVencimento(Date vencimento) {
        Despesa.vencimento = vencimento;
    }

    

    public Despesa(int id, String descricao, double valorInicial, double restante, double adiantamento, double total, double pagar, double somaTotal) {
        Despesa.id = id;
        Despesa.descricao = descricao;
        Despesa.valorInicial = valorInicial;
        Despesa.restante = restante;
        Despesa.adiantamento = adiantamento;
        Despesa.total = total;
        Despesa.pagar = pagar;
        Despesa.somaTotal = somaTotal;
    }
        public Despesa (String descricao, double valorInicial, double adiantamento, double restante, Date vencimento) 
    {
        
        Despesa.descricao = descricao;
        Despesa.valorInicial = valorInicial;        
        Despesa.adiantamento = adiantamento;
        Despesa.restante = restante;
        Despesa.vencimento = vencimento;
    }
    public Despesa(int id, String descricao, double valorInicial,  double adiantamento) {
        Despesa.id = id;
        Despesa.descricao = descricao;
        Despesa.valorInicial = valorInicial;
        Despesa.adiantamento = adiantamento;
    }
     public Despesa(Double total) 
     {
        Despesa.total = total;
    }
    
    
    

    public static double getPagar() {
        return pagar;
    }

    public static void setPagar(double pagar)
    {
        Despesa.pagar = pagar;
    }

    public static double getTotal() 
    {
        return total;
    }

    public static void setTotal(double total)
    {
        Despesa.total = total;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        Despesa.id = id;
    }

    public static String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(String descricao)
    {
        Despesa.descricao = descricao;
    }

    public static double getValorInicial()
    {
        return valorInicial;
    }

    public void setValorInicial(double valor)
    {
        Despesa.valorInicial = valor;
    }

    public static double getAdiantamento()
    {
        return adiantamento;
    }

    public void setAdiantamento(double adiantamento)
    {
        Despesa.adiantamento = adiantamento;
    }
    public static double getSomaTotal() 
    {
        return somaTotal;
    }

    public void setSomaTotal(double somaTotal) 
    {
        Despesa.somaTotal = somaTotal;
    }
    public static double getRestante() 
    {
        return restante;
    }

    public void setRestante(double restante) 
    {
        Despesa.restante = restante;
    }
}
