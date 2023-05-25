package academy.padroesdeprojeto.dominio;

import java.util.HashSet;
import java.util.Set;

public enum AicraftSingletonEnum {
    INSTANCE;
    private final Set<String> availableSeats;

    AicraftSingletonEnum() {
        this.availableSeats = new HashSet<>();
        this.availableSeats.add("1A");
        this.availableSeats.add("1B");
    }

    public boolean bookSeat(String seat){
        return availableSeats.remove(seat);
    }
}
