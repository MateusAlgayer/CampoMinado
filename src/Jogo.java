import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Jogo {
  private ArrayList<ArrayList<Campo>> tabuleiro;
  private boolean ganhou = false;
  private Date tempoInicial;
  private Date tempoFinal;

  private final int tamanhoX;
  private final int tamanhoY;
  private final Dificuldade dif;
  private final int qtdCamposMina;
  private final int qtdCamposTotal;
  private final int qtdCamposSemMina;
  private final int numCasas;

  Jogo(Ponto p, Dificuldade dif){
    tamanhoX = p.getX();
    tamanhoY = p.getY();
    this.dif = dif;
    
    Escrita.setCorTexto(CoresTexto.ROXA);
    Escrita.comCoresf("Criando tabuleiro %sX%s na dificuldade %s...\n", tamanhoX, tamanhoY, dif);

    int casasX = Integer.toString(tamanhoX).length();
    int casasY = Integer.toString(tamanhoY).length();

    numCasas = casasX > casasY ? casasX+1 : casasY+1;
    Campo.numCasas = numCasas;
    
    //Inicializa o tabuleiro
    tabuleiro = new ArrayList<>();
    for (int i = 0; i < tamanhoX; i++) {
      tabuleiro.add(new ArrayList<Campo>()); 
    }
    
    qtdCamposTotal = tamanhoX*tamanhoY;
    qtdCamposMina = Math.round(qtdCamposTotal*dif.getPercentual());
    qtdCamposSemMina = qtdCamposTotal-qtdCamposMina;

    criaCamposTabuleiro();
    atualizaCampos();
    Escrita.comCores("Tabuleiro criado! número de minas no tabuleiro = "+qtdCamposMina);
    
    tempoInicial = Date.from(Instant.now());
  }

  public void atualizaCamposAberto(){
    int contaAbertos = 0;
    for (int x = 0; x < tamanhoX; x++) {
      for (int y = 0; y < tamanhoY; y++){
        if(!tabuleiro.get(x).get(y).isAberto()){
          continue;
        }
        contaAbertos++;
      }
    }

    if(contaAbertos == qtdCamposSemMina){
      ganhou = true;
      tempoFinal = Date.from(Instant.now());
    }
  }

  public void imprimeMsgVitoria(){
    imprimeTabuleiroAberto();
    Escrita.setCorTexto(CoresTexto.VERDE);
    Escrita.comCores("-======= Você ganhou =======-");
    long diff = tempoFinal.getTime()-tempoInicial.getTime();
    Escrita.comCores("Tempo de jogo: "+(diff/(60 * 60 * 1000))+" horas, "+(diff/(60 * 1000) % 60)+" minutos e "+(diff/1000 % 60)+" segundos");
  }

  public void imprimeTabuleiroAberto() {
    Campo.imprimeAberto = true;
    System.out.println(toString());
  }

  private void atualizaCampos() {
    for (int x = 0; x < tamanhoX; x++) {
      for (int y = 0; y < tamanhoY; y++){
        Campo campo = tabuleiro.get(x).get(y);

        //Campo acima
        addVizinho(campo, x-1, y);
        //Campo abaixo
        addVizinho(campo, x+1, y);
        //Campo à esquerda
        addVizinho(campo, x, y-1);
        //Campo à direita
        addVizinho(campo, x, y+1);
        //Campo na esquerda em cima
        addVizinho(campo, x-1, y-1);
        //Campo na esquerda em baixo
        addVizinho(campo, x+1, y-1);
        //Campo na direita em cima
        addVizinho(campo, x-1, y+1);
        //Campo na direita em baixo
        addVizinho(campo, x+1, y+1);
      }
    }
  }

  private void addVizinho(Campo campo, int x, int y) {
    if(x >= tamanhoX || y >= tamanhoY){
      return;
    }

    if(x < 0 || y < 0){
      return;
    }

    campo.setVizinho(tabuleiro.get(x).get(y));
  }

  private void criaCamposTabuleiro() {
    var campos = new ArrayList<Campo>(qtdCamposTotal);
    
    for (int i = 0; i < qtdCamposMina; i++) {
      campos.add(new CampoComMina());
    }

    for (int i = 0; i < qtdCamposSemMina; i++) {
      campos.add(new CampoSemMina());
    } 

    //Da shuffle nos campos para aleatorizar as minas
    Collections.shuffle(campos);
    Collections.shuffle(campos);

    int idx = 0;
    //Adicionando os campos no tabuleiro.
    for (int x = 0; x < tamanhoX; x++) {
      for (int y = 0; y < tamanhoY; y++){
        tabuleiro.get(x).add(y, campos.get(idx));
        idx++;
      }
    }
  }

  public int getTamanhoX() {
    return tamanhoX;
  }

  public int getTamanhoY() {
    return tamanhoY;
  }

  public Dificuldade getDif() {
    return dif;
  }

  public boolean ganhou() {
    return ganhou;
  }

  public void setGanhou(boolean ganhou) {
    this.ganhou = ganhou;
  }

  public ArrayList<ArrayList<Campo>> getTabuleiro() {
    return tabuleiro;
  }

  @Override
  public String toString() {
    String tabuleiroStr = criaCabecalhoColunas();
    
    for (int x = 0; x < tamanhoX; x++) {
      tabuleiroStr += Escrita.getText(String.format("\n%"+numCasas+"s", x+" "), CoresTexto.CIANO);
      for (int y = 0; y < tamanhoY; y++){
        tabuleiroStr += tabuleiro.get(x).get(y);
      }
    }
    return tabuleiroStr;
  }

  private String criaCabecalhoColunas() {
    String str = String.format("%"+numCasas+"s", " ");
    for (int i = 0; i < tamanhoY; i++) {
      str += Escrita.getText(String.format("%"+numCasas+"s", i+" "), CoresTexto.CIANO);
    }
    return str;
  }
}
