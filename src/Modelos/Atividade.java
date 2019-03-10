
package Modelos;

import java.sql.Date;

public class Atividade 
{
    
    static int id ;
    static String descricao;
    static java.sql.Date data;    
    static String Horas;
    static int hora1;
    static int minuto;
    static String idCategoria;
    static String situacao;

    public static String getSituacao() {
        return situacao;
    }

    public static void setSituacao(String situacao) {
        Atividade.situacao = situacao;
    }

    public Atividade(String descricao, Date data, String Horas, int hora1,int minuto, String idCategoria) 
    {
        Atividade.descricao = descricao;
        Atividade.data = data;
        Atividade.Horas = Horas;
        Atividade.hora1 = hora1;
        Atividade.minuto = minuto;
        Atividade.idCategoria = idCategoria;
    } 

    public static String getIdCategoria() {
        return idCategoria;
    }

    public static void setIdCategoria(String idCategoria) {
        Atividade.idCategoria = idCategoria;
    }
    
    public Atividade(int id, String descricao, Date data, String Horas, int hora1, int minuto, String situacao) 
    {
        Atividade.id = id;
        Atividade.descricao = descricao;
        Atividade.data = data;
        Atividade.Horas = Horas;
        Atividade.hora1 = hora1;
        Atividade.minuto = minuto;
        Atividade.situacao = situacao;
    } 

    public static String getHoras() {
        return Horas;
    }

    public static void setHoras(String Horas) {
        Atividade.Horas = Horas;
    }

    public static int getHora1() {
        return hora1;
    }

    public static void setHora1(int hora1) {
        Atividade.hora1 = hora1;
    }

    public static int getMinuto() {
        return minuto;
    }

    public static void setMinuto(int minuto) {
        Atividade.minuto = minuto;
    }
    public Atividade( int id, String descricao, Date data, String Horas ) 
    {
        Atividade.id = id;
        Atividade.descricao = descricao;
        Atividade.data = data;
        Atividade.Horas = Horas;
    } 


    public static String getDescricao()
    {
        return descricao;
    }

    public Atividade() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }  

    public static int getId()
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }    

    public static String getHora() 
    {
        return Horas;
    }

    public void setHora(String hora) 
    {
        this.Horas = hora;
    }
    
    public static Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    
    
}
