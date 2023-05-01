import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Dificuldade {
  TESTE(0.0f, false),
  TUTORIAL(0.05f, false),
  SUPERFACIL(0.05f, true),
  FACIL(0.1f, true),
  MEDIO(0.2f, true),
  DIFICIL(0.3f, true),
  IMPOSSIVEL(0.5f, true);

  public static final List<Dificuldade> niveis = Collections.unmodifiableList(Arrays.stream(values()).filter(dif -> {return dif.exibir;}).toList());

  private final float percentual;
  private final boolean exibir;
  Dificuldade(final float percentual, final boolean exibir){
    this.percentual = percentual;
    this.exibir = exibir;
  }

  public float getPercentual(){
    return percentual;
  } 
}
