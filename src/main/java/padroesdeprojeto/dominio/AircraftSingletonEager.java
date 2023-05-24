package padroesdeprojeto.dominio;

import java.util.HashSet;
import java.util.Set;

public final class AircraftSingletonEager { //Quem vai criar o objeto é o instance, que sempre tem esse numero no name.
    //Eager Initialization
    private static final AircraftSingletonEager INSTANCE = new AircraftSingletonEager("787-900");
    private final Set<String> availableSeats = new HashSet<>();
    private final String name;

    public static AircraftSingletonEager getINSTANCE(){
        return INSTANCE;
    }

    {
        availableSeats.add("1A");
        availableSeats.add("1B");
    }

    private AircraftSingletonEager(String name) {
        this.name = name;
    }

    public boolean bookSeat(String seat){

        return availableSeats.remove(seat);
    }
}
