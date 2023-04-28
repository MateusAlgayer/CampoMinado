import java.util.ArrayList;

public class App {
    
    private static void imprimeSeparador(){
        Escrita.comCores("-=".repeat(20)+"-");
    }
    
    public static void main(String[] args) throws Exception {
        Escrita.setCorTexto(CoresTexto.VERDE);
        
        imprimeSeparador();
        Escrita.comCoresAleatorias("             Campo Minado");
        imprimeSeparador();
        Escrita.comCores("        Feito por Mateus Roberto Algayer");

        System.out.println("\n");
        Escrita.setCorTexto(CoresTexto.AZUL);
        Escrita.comCores("Informe o tamanho do tabuleiro em no formato linhas,colunas. Ex: 10,10");
        //int[] ordemMatriz = Leitor.leEntradaDupla();
        //Ponto escolha = Leitor.leEntradaTripla();
 
        var lista = new ArrayList<AcoesCampo>();
        for (int i = 0; i < 10; i++) {
            lista.add(new CampoComMina());
        }
        
        for (int i = 0; i < 10; i++) {
            System.out.println(i+" "+lista);
        }
    }
}
