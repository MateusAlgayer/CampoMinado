public class App {
    public static void main(String[] args) throws Exception {
        EscritaComCores eccVerde = new EscritaComCores(CoresTexto.ROXA);

        eccVerde.nl("-=".repeat(20)+"-");
        EscritaComCores.textoCoresAleatorias("             Campo Minado");
        eccVerde.nl("-=".repeat(20)+"-");
    }
}
