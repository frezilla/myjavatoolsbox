package eu.frezilla.tools.number.base;

public enum NRSetEnum {
    BINARY(
            NREnum.ZERO, 
            NREnum.ONE
    ),
    DECIMAL(
            NREnum.ZERO, 
            NREnum.ONE,
            NREnum.TWO,
            NREnum.THREE,
            NREnum.FOUR,
            NREnum.FIVE,
            NREnum.SIX,
            NREnum.SEVEN,
            NREnum.EIGHT,
            NREnum.NINE
    ),
    HEXADECIMAL(
            NREnum.ZERO, 
            NREnum.ONE,
            NREnum.TWO,
            NREnum.THREE,
            NREnum.FOUR,
            NREnum.FIVE,
            NREnum.SIX,
            NREnum.SEVEN,
            NREnum.EIGHT,
            NREnum.NINE,
            NREnum.A,
            NREnum.B,
            NREnum.C,
            NREnum.D,
            NREnum.E,
            NREnum.F
    ),
    OCTAL(
            NREnum.ZERO, 
            NREnum.ONE,
            NREnum.TWO,
            NREnum.THREE,
            NREnum.FOUR,
            NREnum.FIVE,
            NREnum.SIX,
            NREnum.SEVEN
    );
    
    private final NREnum[] array;
    
    private NRSetEnum(NREnum...values) {
        this.array = values;
    }
    
    public NRSet toNRSet() {
        NRSet.Builder builder = NRSet.getBuilder();
        for (NREnum currentStrValEnum : array) {
            builder.add(currentStrValEnum.toNumericRepresentation());
        }
        return builder.build();
    }
    
}
