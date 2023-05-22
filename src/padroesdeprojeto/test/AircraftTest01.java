package padroesdeprojeto.test;

import padroesdeprojeto.dominio.Aircraft;

public class AircraftTest01 { //Padrao Singleton
    public static void main(String[] args) {
        bookSeat("1A"); //Perceba que estamos tentando pegar o assento 1A da mesma aeronave, e esta retornando os dois true.
        bookSeat("1A"); //O motivo é que estamos criando dois objetos, sendo que so pode existir um 787-900.
    }

    private static void bookSeat(String seat){
        Aircraft aircraft = new Aircraft("787-900");
        System.out.println(aircraft.bookSeat(seat));
    }
}
