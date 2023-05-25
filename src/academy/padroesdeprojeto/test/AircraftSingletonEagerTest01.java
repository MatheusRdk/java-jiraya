package academy.padroesdeprojeto.test;

import academy.padroesdeprojeto.dominio.AircraftSingletonEager;

public class AircraftSingletonEagerTest01 { //Padrao Singleton Eager
    public static void main(String[] args) {
        bookSeat("1A");
        bookSeat("1A"); //Agora vai dar false, pq nao importa onde trabalhe com AircraftSingletonEager sempre sera com o mesmo objeto, mesmo espaço em memória.
    }

    private static void bookSeat(String seat){
        AircraftSingletonEager aircraftSingletonEager = AircraftSingletonEager.getINSTANCE(); //Vc nao pode mais dar new, o construtor dele é privado.
        System.out.println(aircraftSingletonEager.bookSeat(seat));
    }
}
