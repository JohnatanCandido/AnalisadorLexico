public class Maquina {

    private static AreaInstrucoes AI;
    private static AreaLiterais AL;

    public static void inicializaAreaIntrucoes() {
        AI = new AreaInstrucoes();
        Hipotetica.InicializaAI(AI);
    }

    public static void inicializaAreaLiterais() {
        AL = new AreaLiterais();
        Hipotetica.InicializaAL(AL);
    }

    public static void incluiAreaInstrucao(String instr, String o1, String o2) {
        int i = Util.getComandos().indexOf(instr);
        int arg1 = o1.equals("-") ? -1 : Integer.parseInt(o1);
        int arg2 = o2.equals("-") ? -1 : Integer.parseInt(o2);

        if (instr.equals("DSVS") || instr.equals("DSVT") || instr.equals("DSVF") || instr.equals("CALL"))
            arg2--;
        if (!Hipotetica.IncluirAI(AI, i, arg1, arg2)) {
            throw new StackOverflowError("Estouro na área de instruções!");
        }
    }

    public static void incluiAreaLiterais(String lit) {
        if (!Hipotetica.IncluirAL(AL, lit)) {
            throw new StackOverflowError("Estouro na área de literais!");
        }
    }

    public static String retornaPonteiroLiteral() {
        return String.valueOf(AL.LIT - 1);
    }

    public static void interpreta() {
        Hipotetica.Interpreta(AI, AL);
    }

}
