
package Modelos;


public class Boletim 
{
    static int id;
    static String disciplina;
    static double nota1;
    static double nota2;
    static double nota3;
    static double nota4;
    static double mediaFinal;
    static String ano;
    static String instituicao;
    static int anosemestre;
    static String semestre;

    public static int getAnosemestre() {
        return anosemestre;
    }

    public static void setAnosemestre(int anosemestre) {
        Boletim.anosemestre = anosemestre;
    }

    public static String getSemestre() {
        return semestre;
    }

    public static void setSemestre(String semestre) {
        Boletim.semestre = semestre;
    }

   
    public Boletim(String instituicao, String ano, int anosemestre, String semestre)
    {
        Boletim.instituicao = instituicao;
        Boletim.ano = ano;
        Boletim.anosemestre = anosemestre;
        Boletim.semestre = semestre;
    }
    public Boletim(int id,String instituicao, String ano,int anosemestre, String semestre)
    {
        Boletim.id = id;
        Boletim.instituicao = instituicao;
        Boletim.ano = ano;
        Boletim.anosemestre = anosemestre;
        Boletim.semestre = semestre;
        
    }
    
    public Boletim(int id, String disciplina, double nota1, double nota2, double nota3, double nota4) 
    {
        Boletim.disciplina = disciplina;
        Boletim.nota1 = nota1;
        Boletim.nota2 = nota2;
        Boletim.nota3 = nota3;
        Boletim.nota4 = nota4;
    }

    public Boletim(String disciplina, double nota1, double nota2, double nota3, double nota4, double mediaFinal) {
        Boletim.disciplina = disciplina;
        Boletim.nota1 = nota1;
        Boletim.nota2 = nota2;
        Boletim.nota3 = nota3;
        Boletim.nota4 = nota4;
        Boletim.mediaFinal = mediaFinal;
    }
    
     public static String getAno() {
        return ano;
    }

    public static void setAno(String ano) {
        Boletim.ano = ano;
    }

    public static String getInstituicao() {
        return instituicao;
    }

    public static void setInstituicao(String instituicao) {
        Boletim.instituicao = instituicao;
    }
    
    public static String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        Boletim.disciplina = disciplina;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        Boletim.id = id;
    }

    public static double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        Boletim.nota1 = nota1;
    }

    public static double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        Boletim.nota2 = nota2;
    }

    public static double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        Boletim.nota3 = nota3;
    }

    public static double getNota4() {
        return nota4;
    }

    public void setNota4(double nota4) {
        Boletim.nota4 = nota4;
    }

    public double getMediaFinal() {
        return mediaFinal;
    }

    public void setMediaFinal(double mediaFinal) {
        Boletim.mediaFinal = mediaFinal;
    }
}
