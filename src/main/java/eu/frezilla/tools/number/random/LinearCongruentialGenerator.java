package eu.frezilla.tools.number.random;

import java.util.Objects;

public class LinearCongruentialGenerator {

    private final LCGParameters parameters;
    private long seed;
    
    public LinearCongruentialGenerator(LCGParameters parameters) {
        this.parameters = Objects.requireNonNull(parameters, "Les paramètres ne sont pas renseignés");
        this.seed = parameters.getInitialSeed();
    }
    
    public long next() {
        seed = (parameters.getMultiplier() * seed + parameters.getIncrement()) % parameters.getModulo();
        return seed;                
    }
    
}
