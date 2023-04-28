import java.util.Scanner;

///Autor: MateusAlgayer
public abstract class Leitor{
  private static Scanner sc;

  public static Ponto leXY(){
    if(sc == null){
      sc = new Scanner(System.in);
    }

    Ponto entrada = new Ponto();
    String txt;
    String[] vetTxt = new String[2];
    while(true){
      try {
        txt = sc.nextLine();

        vetTxt = txt.split(",", 0);

        entrada.setX(Integer.parseInt(vetTxt[0]));
        entrada.setY(Integer.parseInt(vetTxt[1]));
        entrada.setMarcar(false);
        return entrada;
      } catch (Exception e) {
        Escrita.comCores("A entrada deve ser no formato n,m onde n e m devem ser números inteiros!", CoresTexto.VERMELHO);
      }
    }
  }

  public static Ponto leEntradaTripla(){
    if(sc == null){
      sc = new Scanner(System.in);
    }

    String txt;
    String[] vetTxt = new String[3];
    Ponto entrada = new Ponto();
    while(true){
      try {
        txt = sc.nextLine();

        vetTxt = txt.split(",", 0);

        entrada.setX(Integer.parseInt(vetTxt[0]));
        entrada.setY(Integer.parseInt(vetTxt[1]));
        entrada.setMarcar(vetTxt.length == 3 ? vetTxt[2].equals("m") : false);
        return entrada;
      } catch (Exception e) {
        Escrita.comCores("A entrada deve ser no formato x,y,m onde x e y devem ser números inteiros\ne m pode ou não estar presente!", CoresTexto.VERMELHO);
      }
    }
  }
}
