package academy.padroesdeprojeto.dominio;

import java.util.HashSet;
import java.util.Set;

public final class AircraftSingletonLazy {
    //Lazy Initialization
    private static AircraftSingletonLazy INSTANCE;
    private final Set<String> availableSeats = new HashSet<>();
    private final String name;

    public static AircraftSingletonLazy getINSTANCE(){ //No lazy vc inicia aqui a INSTANCE. Vc precisa fazer um double lock.
        if (INSTANCE == null){
            synchronized (AircraftSingletonLazy.class){
                if (INSTANCE == null){
                    INSTANCE = new AircraftSingletonLazy("787-900");
                }
            }
        }
        return INSTANCE;
    }

    {
        availableSeats.add("1A");
        availableSeats.add("1B");
    }

    private AircraftSingletonLazy(String name) {
        this.name = name;
    }

    public boolean bookSeat(String seat){

        return availableSeats.remove(seat);
    }
}
