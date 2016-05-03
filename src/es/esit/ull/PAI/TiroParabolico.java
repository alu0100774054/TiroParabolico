package es.esit.ull.PAI;

public class TiroParabolico {
  private int velocidadInicial;
  private double grados;
  private final double GRAVEDAD = 9.8;
  private int alturaInicial;
  private double formulaX;
  private double formulaY;                // Altura máxima.
  private double formulaVX;
  private double formulaVY;
  private double tiempo;
  private double alturaMaxima;
  private double tiempoEnCaer;
  private double alcanceMaximo;
  
  public TiroParabolico() {
    this.velocidadInicial = 0;
    this.grados = 0.0;
    this.alturaInicial = 0;
  }
  
  public TiroParabolico(int velocidadInicial, double grados, int alturaInicial) {
    this.velocidadInicial = velocidadInicial;
    this.grados = grados;
    this.alturaInicial = alturaInicial;
    Resolver();
  }
  
  public void Resolver() {
    convertirEnRadianes();
    calcularTiempo();
    alturaMaxima();
    tiempoEnCaer();
    alcanceMaximo();
  }
  private void alcanceMaximo() {
    // Dado tiempo en caer => calculaX()
    setAlcanceMaximo(calcularX());
    System.out.println("Alcance máximo: " + getAlcanceMaximo());
  }

  private void tiempoEnCaer() {
    // Y = 0
    setTiempoEnCaer(calcularSinTiempoY());
    System.out.println("Tiempo que tarda en caer: " + getTiempoEnCaer());
  }

  private double calcularSinTiempoY() {
    double a = getGRAVEDAD() / 2;
    double b = getVelocidadInicial() * Math.sin(getGrados());
    double c = getAlturaInicial();
    double raiz1 = (- (b) + Math.sqrt((b * b) - (4 * a * c))) / (2 * a);
    double raiz2 = (- (b) - Math.sqrt((b * b) - (4 * a * c))) / (2 * a);
    if (raiz1 == 0) {
      return Math.abs(raiz2);
    } else if (raiz2 == 0) {
      return Math.abs(raiz1);
    } else
      return 0;
  }
  
  public int calcularTrayectoriaX(double tiempo) {
    //System.out.print("t = " + tiempo + " --> (" + calcularX(tiempo) + ", ");
    return calcularX(tiempo);
  }
  
  private int calcularX(double tiempo) {  
    return (int) (getVelocidadInicial() * Math.cos(getGrados()) * tiempo);
  }

  public int calcularTrayectoriaY(double tiempo) {
    //System.out.println(calcularY(tiempo) + ")");
    return calcularY(tiempo);
  }
  
  private int calcularY(double tiempo) {
    return (int) ((getAlturaInicial() + getVelocidadInicial() * Math.sin(getGrados()) * tiempo) - ((getGRAVEDAD() / 2) * tiempo * tiempo));
  }
  
  private void calcularTiempo() {
    setTiempo((getVelocidadInicial() * Math.sin(getGrados())) / (getGRAVEDAD()));
    System.out.println("Tiempo: " + getTiempo());
  }

  private void alturaMaxima() {
    // Vy = 0
    setAlturaMaxima(calcularY());
    System.out.println("Altura máxima: " + getAlturaMaxima());
  }

  private double calcularVY() {
    // Vy = Vo * sin(grados) - gt
    return getVelocidadInicial() * Math.sin(getGrados()) - getGRAVEDAD() * getTiempo();
  }

  private double calcularVX() {
    // Vx = V0 * cos(grados)
    return getVelocidadInicial() * Math.cos(getGrados());
  }

  private double calcularY() {
    // Y = alturaInicial + velInicial * Sen(grados)t - 1/2 * g * t^2
    return getAlturaInicial() + getVelocidadInicial() * Math.sin(getGrados()) * getTiempo() - (getGRAVEDAD() / 2) * getTiempo() * getTiempo();
  }

  private double calcularX() {
    // X = V0 * Cos(grados) * t
    return getVelocidadInicial() * Math.cos(getGrados()) *getTiempoEnCaer();
  }

  private void convertirEnRadianes() {
    setGrados((getGrados() * Math.PI / 180)); 
  }

  /**
   * Getter & Setter
   */
  
  public int getVelocidadInicial() {
    return velocidadInicial;
  }

  public double getAlcanceMaximo() {
    return alcanceMaximo;
  }

  public void setAlcanceMaximo(double alcanceMaximo) {
    this.alcanceMaximo = alcanceMaximo;
  }

  public double getAlturaMaxima() {
    return alturaMaxima;
  }

  public void setAlturaMaxima(double alturaMaxima) {
    this.alturaMaxima = alturaMaxima;
  }

  public double getTiempoEnCaer() {
    return tiempoEnCaer;
  }

  public void setTiempoEnCaer(double alcanceMaximo) {
    this.tiempoEnCaer = alcanceMaximo;
  }

  public double getFormulaVX() {
    return formulaVX;
  }

  public void setFormulaVX(double formulaVX) {
    this.formulaVX = formulaVX;
  }

  public double getFormulaVY() {
    return formulaVY;
  }

  public void setFormulaVY(double formulaVY) {
    this.formulaVY = formulaVY;
  }

  public int getAlturaInicial() {
    return alturaInicial;
  }

  public void setAlturaInicial(int alturaInicial) {
    this.alturaInicial = alturaInicial;
  }

  public double getFormulaY() {
    return formulaY;
  }

  public void setFormulaY(double formulaY) {
    this.formulaY = formulaY;
  }

  public double getTiempo() {
    return tiempo;
  }

  public void setTiempo(double tiempo) {
    this.tiempo = tiempo;
  }

  public double getFormulaX() {
    return formulaX;
  }

  public void setFormulaX(double formulaX) {
    this.formulaX = formulaX;
  }

  public void setVelocidadInicial(int velocidadInicial) {
    this.velocidadInicial = velocidadInicial;
  }

  public double getGrados() {
    return grados;
  }

  public void setGrados(double d) {
    this.grados = d;
  }

  public double getGRAVEDAD() {
    return GRAVEDAD;
  }
  
}
