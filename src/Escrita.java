///Autor: MateusAlgayer
public abstract class Escrita {
  private static final String RESET = "\u001B[0m";
  private static CoresTexto corTexto = CoresTexto.BRANCO;

  public static void setCorTexto(final CoresTexto cor){
    corTexto = cor;
  }

  public static void normal(final Object txt){
    System.out.println(txt);
  }

  public static void comCores(final Object txt){
    comCores(txt, corTexto);
  }

  public static void comCores(final Object txt, final CoresTexto cor){
    System.out.println(getText(txt, cor));
  }
  
  public static void comCoresf(final Object txt, Object ... args){
    System.out.printf(getText(txt), args);
  }
  
  public static String getText(final Object txt){
    return getText(txt, corTexto);
  }

  public static String getText(final Object txt, final CoresTexto cor){
    return cor+""+txt+""+RESET;
  }

  public static void comCoresAleatorias(String txt){
    String txtCorAleatoria = "";
    for(char c: txt.toCharArray()){
      txtCorAleatoria = txtCorAleatoria.concat(CoresTexto.Aleatorio()+c);
    }
    System.out.println(txtCorAleatoria+RESET);
  }
}
