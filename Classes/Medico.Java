public class Paciente {
    //nome cpf data hist
    String nome, cpf, CRM, espec;

    Date nasc; //falta hist


    //Metódos 
    //Create
    Paciente(n, c, d, cc, e){ //falta h
        nome = n;
        cpf = c;
        nasc = d;
        //hist = h
        crm = cc;
        espec = e;
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
    String getEspec(){
        Date espectxt = espec;
        return espectxt;
    }
    String getCrm(){
        Date crmtxt = crm;
        return crmtxt;
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
    void setEspec(a){
        espec = a;
    }
    void setCrm(a){
        crm = a;
    }
    //setHist()





}



    







