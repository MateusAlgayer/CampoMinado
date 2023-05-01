import java.util.Scanner;

///Autor: MateusAlgayer
public abstract class Leitor{
  private static Scanner sc;

  public static boolean leBool(){
    if(sc == null){
      sc = new Scanner(System.in);
    }

    String txt;
    while(true){
      try {
        txt = sc.nextLine();
        txt = txt.toUpperCase();
        if(txt.equals("S") || txt.equals("N")){
          return txt == "S";
        }
      } catch (Exception e) {
        System.out.println("Responda apenas com S ou N");
      }
    }
  }

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

  public static Dificuldade leDificuldade() {
    if(sc == null){
      sc = new Scanner(System.in);
    }

    while(true){
      try {
        Escrita.comCores("Escolha a dificuldade do jogo:");
        for (int i = 0; i < Dificuldade.niveis.size(); i++) {
          Escrita.comCores(i+" - "+Dificuldade.niveis.get(i)+": percentual de bombas = "+Math.round(Dificuldade.niveis.get(i).getPercentual()*100)+"%");
        }
        String txt = sc.nextLine();
        int idx = Integer.parseInt(txt);

        if(idx < 0 || idx > Dificuldade.niveis.size()){
          throw new Exception("Entrada inválida!!");
        }

        return Dificuldade.niveis.get(idx);
      } catch (Exception e) {
        Escrita.comCores("A entrada deve ser um número entre 0 e "+(Dificuldade.niveis.size()-1), CoresTexto.VERMELHO);
      }
    }
  }
}
