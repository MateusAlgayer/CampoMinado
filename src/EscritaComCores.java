///Autor: MateusAlgayer
public abstract class EscritaComCores {
  private static final String RESET = "\u001B[0m";
  private static CoresTexto corTexto = CoresTexto.BRANCO;

  public static void setCorTexto(final CoresTexto cor){
    corTexto = cor;
  }

  public static void textoColorido(final String txt){
    textoColorido(txt, corTexto);
  }

  public static void textoColorido(final String txt, final CoresTexto cor){
    System.out.println(cor+txt+RESET);
  }
  
  public static void textoColoridof(final String txt, Object ... args){
    System.out.printf(corTexto+txt+RESET, args);
  }
  
  public static String getTextoColorido(final String txt){
    return corTexto+txt+RESET;
  }

  static void textoCoresAleatorias(String txt){
    String txtCorAleatoria = "";
    for(char c: txt.toCharArray()){
      txtCorAleatoria = txtCorAleatoria.concat(CoresTexto.Aleatorio()+c);
    }
    System.out.println(txtCorAleatoria+RESET);
  }
}
