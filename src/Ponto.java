///Autor: MateusAlgayer
public class Ponto {
  private int x;
  private int y;
  private boolean marcar;

  public Ponto() {
  }

  public Ponto(int x, int y, boolean marcar) {
    this.x = x;
    this.y = y;
    this.marcar = marcar;
  }

  @Override
  public String toString() {
    return "Ponto [x=" + x + ", y=" + y + ", marcar=" + marcar + "]";
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public boolean isMarcar() {
    return marcar;
  }

  public void setMarcar(boolean marcar) {
    this.marcar = marcar;
  }
}
