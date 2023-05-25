package academy.modificadorestatico.test;

import academy.modificadorestatico.dominio.Carro;

public class CarroTest01 {
    public static void main(String[] args) {
        
        Carro c1 = new Carro("BMW", 267);
        Carro c2 = new Carro("Mercedez", 244);
        Carro c3 = new Carro("Audi", 234);

        Carro.setVelocidadeLimite(260);

        c1.imprime();
        c2.imprime();
        c3.imprime();

    }
}
