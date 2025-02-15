package classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Exame{
    String tipo, resultado;
    LocalDate dataPrescricao, dataRealizacao;
    float valor;


    //Métodos
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Exame{\n" +
                "tipo = " + tipo + '\n' +
                " resultado = " + resultado + '\n' +
                " dataPrescricao = " + dataPrescricao.format(formatter) + "\n" +
                " dataRealizacao = " + dataRealizacao.format(formatter) + "\n" +
                " valor = " + valor +
                '}';
    }


    public Exame (String t, String r, LocalDate dP, LocalDate dR,float v){
        tipo = t;
        resultado = r;
        dataPrescricao = dP;
        dataRealizacao = dR;
        valor = v;
    }

    //Read aa
    public String getTipo(){
        return tipo;
    }
    public String getResultado(){
        return resultado;
    }
    public LocalDate getDataPrescricao(){
        return dataPrescricao;
    }
    public LocalDate getRealizacao(){
        return dataRealizacao;
    }
    public float getValor(){
        return valor;
    }

    //Update
    void setTipo(String a){
        tipo = a;
    }
    void setResultado(String a){
        resultado = a;
    }
    void setDataPrescricao(LocalDate a){
        dataPrescricao = a;
    }
    void setDataRealizacao(LocalDate a){
        dataRealizacao = a;
    }
    void setValor(float a){
        valor = a; 
    }




}