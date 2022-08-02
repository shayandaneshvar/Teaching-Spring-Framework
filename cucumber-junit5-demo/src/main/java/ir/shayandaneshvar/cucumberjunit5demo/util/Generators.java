package ir.shayandaneshvar.cucumberjunit5demo.util;

import java.util.UUID;

public final class Generators {

    private Generators() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static UUID generateUUID(){
        return UUID.randomUUID();
    }


}
