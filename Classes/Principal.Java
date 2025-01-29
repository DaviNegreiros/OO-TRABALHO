//main codar pra funcionar



import java.util.Scanner;
class Principal {
    public static void main(String[] args) {

        
    int sair = 0;

    while(sair != 1){
    
    //Para entrada textual, preciso do Scanner
    Scanner sc= new Scanner(System.in); //ouve a entrada padrao do sistema (teclado)
    String msg = "Informe qual tipo de figura geométrica desejada: \n" +
                "1 - Quadrado \n" +
                "2 - Retangulo \n" +
                "... \n" +
                "0 - Sair";
    System.out.println(msg);
    int opcao = sc.nextInt();

    switch (opcao) {
    case 1: //Quadrado
        String msgQuad1 = "Informe o valor do lado:";
        System.out.println(msgQuad1);
        int lado = sc.nextInt();

        int area = lado * lado;
        int perimetro = lado * 4;

        String msgQuad2 = "A área do quadrado é " + area + ".\nE o perímetro do quadrado é " + perimetro + ".";
        System.out.println(msgQuad2);
        break;
    case 2: //Retangulo
        String msgRet1 = "Informe o valor da base do retângulo:";
        System.out.println(msgRet1);
        int base = sc.nextInt();

        String msgRet2 = "Informe o valor da altura do retângulo:";
        System.out.println(msgRet2);
        int altura = sc.nextInt();

        int areaRet = base * altura;
        int perimetroRet = base * 2 + altura * 2;

        String msgRet3 = "A área do quadrado é " + areaRet + ".\nE o perímetro do retangulo é " + perimetroRet + ".";
        System.out.println(msgRet3);
        break;
    case 0:
        sair = 1;
    default:
        break;
    }
}//while
}
}
