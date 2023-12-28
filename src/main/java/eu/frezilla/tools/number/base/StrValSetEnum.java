package eu.frezilla.tools.number.base;

public enum StrValSetEnum {
    BINARY(
            StrValEnum.ZERO, 
            StrValEnum.ONE
    ),
    DECIMAL(
            StrValEnum.ZERO, 
            StrValEnum.ONE,
            StrValEnum.TWO,
            StrValEnum.THREE,
            StrValEnum.FOUR,
            StrValEnum.FIVE,
            StrValEnum.SIX,
            StrValEnum.SEVEN,
            StrValEnum.HEIGHT,
            StrValEnum.NINE
    ),
    HEXADECIMAL(
            StrValEnum.ZERO, 
            StrValEnum.ONE,
            StrValEnum.TWO,
            StrValEnum.THREE,
            StrValEnum.FOUR,
            StrValEnum.FIVE,
            StrValEnum.SIX,
            StrValEnum.SEVEN,
            StrValEnum.HEIGHT,
            StrValEnum.NINE,
            StrValEnum.A,
            StrValEnum.B,
            StrValEnum.C,
            StrValEnum.D,
            StrValEnum.E,
            StrValEnum.F
    ),
    OCTAL(
            StrValEnum.ZERO, 
            StrValEnum.ONE,
            StrValEnum.TWO,
            StrValEnum.THREE,
            StrValEnum.FOUR,
            StrValEnum.FIVE,
            StrValEnum.SIX,
            StrValEnum.SEVEN
    );
    
    private final StrValEnum[] array;
    
    private StrValSetEnum(StrValEnum...values) {
        this.array = values;
    }
    
    public StrValSet toStrValSet() {
        StrValSet.Builder builder = StrValSet.getBuilder();
        for (StrValEnum currentStrValEnum : array) {
            builder.add(currentStrValEnum.toStrVal());
        }
        return builder.build();
    }
    
}
