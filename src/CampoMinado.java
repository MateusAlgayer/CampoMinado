public class CampoMinado {

    private static void imprimeSeparador(){
        Escrita.comCores("-=".repeat(20)+"-");
    }
    
    public static void main(String[] args) throws Exception {
        System.out.println("Utilizar cores no terminal?(S/N) Obs: Se o jogo estiver apresentando caracteres estranhos desabilite esta opção.");
        CoresTexto.usarCores = Leitor.leBool();
        
        Escrita.setCorTexto(CoresTexto.VERDE);
        
        imprimeSeparador();
        Escrita.comCoresAleatorias("             Campo Minado");
        imprimeSeparador();
        Escrita.comCores("        Feito por Mateus Roberto Algayer");

        System.out.println("\n");
        Escrita.setCorTexto(CoresTexto.AZUL);
        Escrita.comCores("Informe o tamanho do tabuleiro em no formato linhas,colunas. Ex: 10,10");
        Ponto tamanhoTabuleiro = Leitor.leXY();

        Dificuldade nivel = Leitor.leDificuldade();
        Jogo jogo = new Jogo(tamanhoTabuleiro, nivel);

        //A linha abaixo é usada pra debugar o tabuleiro.
        // Campo.imprimeAberto = true;
        Escrita.setCorTexto(CoresTexto.AZUL);
        try {
            while(!jogo.ganhou()){
                System.out.println(jogo);
                Escrita.comCores("Digite a linha,coluna onde deseja pisar, se deseja apenas marcar/desmarcar"+
                                 " uma mina digite linha,coluna,m");
                Ponto p = Leitor.leEntradaTripla();
                if(p.getX() > jogo.getTamanhoX() || p.getY() > jogo.getTamanhoY() || p.getX() < 0 || p.getY() < 0){
                    Escrita.comCores("A linha ou coluna informada está fora dos limites do tabuleiro!", CoresTexto.AMARELO);
                    continue;
                }

                Campo campo = jogo.getTabuleiro().get(p.getX()).get(p.getY());
                if(p.isMarcar()){
                    campo.marcar();
                } else {
                    campo.pisar();
                }
    
                jogo.atualizaCamposAberto();
            }       
            jogo.imprimeMsgVitoria();
        } catch (PisouEmMina e) {
            jogo.imprimeTabuleiroAberto();
            Escrita.comCores(e.getMessage(), CoresTexto.VERMELHO);
        }
    }
}
