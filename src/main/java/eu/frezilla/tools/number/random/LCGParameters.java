package eu.frezilla.tools.number.random;

import java.util.Objects;
import lombok.Data;

@Data
public final class LCGParameters {
    
    private final long increment;
    private final long initialSeed;
    private final long modulo;
    private final long multiplier;
    
    private LCGParameters(Long increment, Long initialSeed, Long modulo, Long multiplier) {
        this.increment = Objects.requireNonNull(increment, "L'incrément est null");
        this.initialSeed = Objects.requireNonNull(initialSeed, "Le \"seed\" initial est null");
        this.modulo = Objects.requireNonNull(modulo, "Le modulo est null");
        this.multiplier = Objects.requireNonNull(multiplier, "Le multiplicateur est null");
    }
    
    public static Builder createBuilder(long modulo) {
        return new Builder(modulo);
    }
    
    public static class Builder {
        
        private Long increment;
        private final long modulo;
        private Long multiplier;
        private Long seed;
        
        private Builder(long modulo) {
            if (modulo > 0) {
                this.modulo = modulo;
            } else {
                throw new IllegalArgumentException("Le modulo doit être strictement supérieur à 0");
            }
        }
        
        public LCGParameters build() {
            return new LCGParameters(increment, seed, modulo, multiplier);
        }
        
        public Builder setIncrement(long increment) {
            if (increment >= 0 && increment < modulo) {
                this.increment = increment;
            } else {
                throw new IllegalArgumentException("L'incrément doit être supérieur ou égal à 0 et strictement inférieur au modulo");
            }
            return this;            
        }
        
        public Builder setMultiplier(long multiplier) {
            if (multiplier > 0 && multiplier < modulo) {
                this.multiplier = multiplier;
            } else {
                throw new IllegalArgumentException("Le multiplicateur doit être strictement supérieur à 0 et strictement inférieur au modulo");
            }
            return this;
        }
        
        public Builder setSeed(long seed) {
            if (seed >= 0 && seed < modulo) {
                this.seed = seed;
            } else {
                throw new IllegalArgumentException("La valeur initiale doit être supérieure ou égale à 0 est strictement inférieure au modulo");
            }
            return this;
        }
        
    }
    
}
