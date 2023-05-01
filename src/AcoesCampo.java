public interface AcoesCampo {
  public final static String CAMPOFECHADO = "\u25A0 ";
  public final static String CAMPOMARCADO = "# ";

  public void pisar() throws PisouEmMina;
  public void marcar();
  public boolean isRecursivel();
  public void revelaCamposRecursao();
}
