public class CampoSemMina extends Campo{

  @Override
  public boolean isRecursivel() {
    return (qtdMinasEntorno == 0) || (!isAberto);
  }

  @Override
  public void pisar() throws PisouEmMina {
    isAberto = true;

    if(qtdMinasEntorno == 0){
      revelaCamposRecursao();
    }
  }

  @Override
  public String toString() {
    //Pinta o quadrado com a cor que é a quantidade de minas ao redor do campo.
    return super.toString(Escrita.getText(String.format("%"+numCasas+"s", qtdMinasEntorno+" "), CoresTexto.cores.get(qtdMinasEntorno)));
  }
}
