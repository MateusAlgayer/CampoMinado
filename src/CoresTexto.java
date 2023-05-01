import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

///Autor: MateusAlgayer
public enum CoresTexto {
  BRANCO("\u001B[37m"),
  VERDE("\u001B[32m"),
  AMARELO("\u001B[33m"),
  AZUL("\u001B[34m"),		
  ROXA("\u001B[35m"),
  CIANO("\u001B[36m"),
  VERMELHO("\u001B[31m"),		
  PRETO("\u001B[30m");	
  
  public static boolean usarCores;
  public static final List<CoresTexto> cores = Collections.unmodifiableList(Arrays.asList(values()));
  private static Random rdm;

  private String corANSI;
  CoresTexto(String corANSI){
    this.corANSI = corANSI;
  }

  public static String Aleatorio(){
    if(rdm == null){
      rdm = new Random();
    }

    return cores.get(rdm.nextInt(cores.size())).toString();
  }

  @Override
  public String toString(){
    return usarCores ? this.corANSI : "";
  }
}