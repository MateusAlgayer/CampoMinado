public class EscritaComCores {
  private static final String RESET = "\u001B[0m";
  
  private CoresTexto corTexto = CoresTexto.BRANCO;

  EscritaComCores(CoresTexto corTexto){
    this.corTexto = corTexto;
  }

  /// Equivalente ao System.out.println só que com as cores definidas
  public void nl(String txt){
    System.out.println(corTexto+txt+RESET);
  }

  /// Equivalente ao System.out.printf só que com as cores definidas
  public void nlf(String txt, Object ... args){
    System.out.printf(corTexto+txt+"\n"+RESET, args);
  }

  static void textoCoresAleatorias(String txt){
    String txtCorAleatoria = "";
    for(char c: txt.toCharArray()){
      txtCorAleatoria = txtCorAleatoria.concat(CoresTexto.Aleatorio()+c);
    }
    System.out.println(txtCorAleatoria+RESET);
  }
}
