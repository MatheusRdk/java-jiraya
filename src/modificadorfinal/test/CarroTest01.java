package modificadorfinal.test;

import modificadorfinal.dominio.Carro;
//import modificadorfinal.dominio.Comprador;

public class CarroTest01 {
    public static void main(String[] args) {
        Carro carro = new Carro();
        System.out.println(carro + " " + Carro.VELOCIDADE_LIMITE);
        //Comprador comprador1 = new Comprador();
        //carro.COMPRADOR = comprador1;   Isso nao e possivel, pois o carro tem o comprador FINAL, que e constante, nao pode ser alterado a referencia do comprador.
        System.out.println(carro.COMPRADOR);
        carro.COMPRADOR.setNome("Matheuzzz"); //Assim consigo mudar o nome (atributo) do comprador, mas que continua sendo a mesma referencia pra um objeto comprador.
        System.out.println(carro.COMPRADOR);
        carro.imprime();
    }
}
