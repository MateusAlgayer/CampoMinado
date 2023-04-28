import java.util.LinkedList;
import java.util.List;

public abstract class Campo implements AcoesCampo {
  protected final static String CAMPOFECHADO = " \u25FC ";
  protected final List<Campo> vizinhos;
  protected boolean isAberto = false;

  public Campo() {
    this.vizinhos = new LinkedList<Campo>();
  }
  
  public List<Campo> getVizinhos() {
    return vizinhos;
  }

  public void setVizinho(final Campo campo){
    if(this.vizinhos.contains(campo)){
      return;
    }

    this.vizinhos.add(campo);
  }

  public boolean isAberto() {
    return isAberto;
  }

  public void setAberto(boolean isAberto) {
    this.isAberto = isAberto;
  }
}
