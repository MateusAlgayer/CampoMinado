public class CampoComMina extends Campo {
  private final static String CAMPOMINADO = "* ";

  @Override
  public boolean isRecursivel() {
    return false;
  }

  @Override
  public void pisar() throws PisouEmMina{
    throw new PisouEmMina();
  }

  @Override
  public void setAberto(final boolean isAberto){
    //Não faz nada, não deve abrir campos com mina.
  }

  @Override
  public String toString() {
      return super.toString(Escrita.getText(String.format("%"+numCasas+"s", CAMPOMINADO), CoresTexto.VERMELHO));
  }
}
