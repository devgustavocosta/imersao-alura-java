public enum EnumCor {

    // cores normais
    RESET("\u001B[0m"),
    PRETO("\033[0;30m"),
    VERMELHO("\033[0;31m"),
    VERDE("\033[0;32m"),
    AMARELO("\033[0;33m"),
    AZUL("\033[0;34m"),
    MAGENTA("\033[0;35m"),
    CIANO("\033[0;36m"),
    BRANCO("\033[0;37m");

    private final String codigo;

    EnumCor(String codigo){
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return codigo;
    }
}
