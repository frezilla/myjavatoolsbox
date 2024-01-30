package eu.frezilla.tools.number.base;

public final class Binary {

    private Binary() {
        throw new IllegalStateException("Classe utilitaire");
    }

    public static String format(byte b) {
        return String.format(
                "%8s",
                Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
    }

    public static String format(byte[] byteArray) {
        StringBuilder value = new StringBuilder();

        for (byte b : byteArray) {
            value.append(format(b)).append(" ");
        }
        value.h
        return value.toString().trim();
    }
}
