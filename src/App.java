public class App {
    
    private static void imprimeSeparador(){
        EscritaComCores.textoColorido("-=".repeat(20)+"-");
    }
    
    public static void main(String[] args) throws Exception {
        EscritaComCores.setCorTexto(CoresTexto.VERDE);
        
        imprimeSeparador();
        EscritaComCores.textoCoresAleatorias("             Campo Minado");
        imprimeSeparador();
        EscritaComCores.textoColorido("        Feito por Mateus Roberto Algayer");

        System.out.println("\n");
        EscritaComCores.setCorTexto(CoresTexto.AZUL);
        EscritaComCores.textoColorido("Informe o tamanho do tabuleiro em no formato linhas,colunas. Ex: 10,10");
        //int[] ordemMatriz = Leitor.leEntradaDupla();
        Ponto escolha = Leitor.leEntradaTripla();

        System.out.println(escolha);
    }
}
