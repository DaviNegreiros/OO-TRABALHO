public class Paciente {
    //nome cpf data hist
    String nome, cpf;

    Date nasc; //falta hist


    //Metódos 
    //Create
    Paciente(n, c, d){ //falta h
        nome = n;
        cpf = c;
        nasc = d;
    }

    //Read
    String getNome(){
        String nometxt = nome;
        return nometxt;

    }
    String getCpf(){

        String cpftxt = cpf;
        return cpftxt;

    }
    Date getNasc(){
        Date nasctxt = nasc;
        return nasctxt;
    }
    //getHist()


    //Write
    void setNome(a){
        nome = a;
    }
    void setCpf(a){
        cpf = a;
    }
    void setNasc(a){
        nasc = a;
    }
    //setHist()

    //Delete()

    //NovaConsulta()




    
}






