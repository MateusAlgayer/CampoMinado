///Autor: MateusAlgayer
public enum CoresFundo {
  PRETO("\u001B[40m"),
  VERMELHO("\u001B[41m"),
  VERDE("\u001B[42m"),
  AMARELO("\u001B[43m"),
  AZUL("\u001B[44m"),
  ROXA("\u001B[45m"),
  CIANO("\u001B[46m");
  
  private String corANSI;
  CoresFundo(String corANSI){
    this.corANSI = corANSI;
  }

  @Override
  public String toString(){
    return this.corANSI;
  }
}
