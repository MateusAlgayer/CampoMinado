import java.util.LinkedList;
import java.util.List;
public abstract class Campo implements AcoesCampo {
  public static boolean imprimeAberto = false;
  public static int numCasas = 1;

  protected final List<Campo> vizinhos;

  protected boolean isAberto = false;
  protected boolean isMarcado = false;
  
  protected int qtdMinasEntorno = 0;
  protected Ponto posicao;

  public Campo() {
    this.vizinhos = new LinkedList<Campo>();
  }

  @Override
  public void marcar(){
    isMarcado = !isMarcado;
  }

  @Override
  public void revelaCamposRecursao(){
    for(Campo vizinho : getVizinhos()){
      if(vizinho.isAberto()){
        continue;
      }
      
      if(vizinho.isMarcado()){
        continue;
      }

      vizinho.setAberto(true);
      if(vizinho.isRecursivel()){
        vizinho.revelaCamposRecursao();
      }
    }
  }
  
  public List<Campo> getVizinhos() {
    return vizinhos;
  }

  public void setVizinho(final Campo campo){
    if(this.vizinhos.contains(campo)){
      return;
    }

    if(campo instanceof CampoComMina){
      qtdMinasEntorno++;
    }
    this.vizinhos.add(campo);
  }

  public boolean isAberto() {
    return isAberto;
  }

  public boolean isMarcado() {
    return isMarcado;
  }

  public void setAberto(final boolean isAberto) {
    //Não abre campos marcados.
    if(isMarcado){
      return;
    }
    this.isAberto = isAberto;
  }

  public Ponto getPosicao() {
    return posicao;
  }

  public void setPosicao(Ponto posicao) {
    this.posicao = posicao;
  }

  public String toString(final String str) {
    if(imprimeAberto || isAberto){
      return str;
    } else if(isMarcado){
      return Escrita.getText(String.format("%"+numCasas+"s", CAMPOMARCADO), CoresTexto.AMARELO);
    } else {
      return String.format("%"+numCasas+"s", CAMPOFECHADO);
    }
  }
}
