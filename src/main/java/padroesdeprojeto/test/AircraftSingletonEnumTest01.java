package padroesdeprojeto.test;

import padroesdeprojeto.dominio.AicraftSingletonEnum;

public class AircraftSingletonEnumTest01 { //Singleton with enum. Com enum nao é mais possivel modificar o acesso igual na class. No eager e no lazy tinha aquele problema.
    public static void main(String[] args) { //Perceba que agora depois de usar o enum, nao tem mais aquele problema.
        bookSeat("1A");
        bookSeat("1A");
    }

    private static void bookSeat(String seat){
        System.out.println(AicraftSingletonEnum.INSTANCE.hashCode());
        AicraftSingletonEnum instance = AicraftSingletonEnum.INSTANCE;
        System.out.println(instance.bookSeat(seat));
    }
}
