public enum Colors {
    ROJO("\u001B[31m"),      // ANSI rojo
    VERDE("\u001B[32m"),     // ANSI verde
    AMARILLO("\u001B[33m"),  // ANSI amarillo
    AZUL("\u001B[34m"),      // ANSI azul
    BLANCO("\u001B[37m"),    // ANSI blanco
    NEGRO("\u001B[30m"),     // ANSI negro
    NEUTRO("\u001B[0m");     // sin color (reset)

    private final String codigoColor;

    Colors(String codigoColor) {
        this.codigoColor = codigoColor;
    }

    public String getCodigoColor() {
        return codigoColor;
    }

    public String toString() {
        return codigoColor;
    }
}
