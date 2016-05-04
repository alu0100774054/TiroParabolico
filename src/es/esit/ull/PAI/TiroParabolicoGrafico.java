package es.esit.ull.PAI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class TiroParabolicoGrafico extends JPanel {
  private TiroParabolico tiroParabolico;
  private boolean isIniciado;
  private boolean isRastro;
  private boolean isVector;
  private int Margen = 50;
  private final int TAM_LIN_EJE = 5;
  private int numLineasDelEje;
  private double tiempo = 0.0;
  private ArrayList<Integer> puntosX;
  private ArrayList<Integer> puntosY;
  
  public TiroParabolicoGrafico() {
    puntosX = new ArrayList<Integer>();
    puntosY = new ArrayList<Integer>();
    setNumLineasDelEje(10);
    isIniciado = false;
    isVector = false;
    isRastro = false;
    establecerEstilo();

  }

  public TiroParabolicoGrafico(int velocidadInicial, double grados, int alturaInicial) {
    tiroParabolico = new TiroParabolico(velocidadInicial, grados, alturaInicial);
    isIniciado = false;
    establecerEstilo();

  }
  public void tiroNuevo(int velocidadInicial, double grados, int alturaInicial) {
    setTiroParabolico(new TiroParabolico(velocidadInicial, grados, alturaInicial));
    setIniciado(true);
    setTiempo(0.0);
    setPuntosX(new ArrayList<Integer>());
    setPuntosY(new ArrayList<Integer>());
    repaint();
  }
  private void establecerEstilo() {
    setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    
    if (!isIniciado) {
      dibujarFondo(g);
      dibujarCoordenadas(g);
      dibujarCanion(g);
    } else {
      if (!isRastro()) {
        dibujarFondo(g);
        dibujarCanion(g);
        dibujarRastro(g);
        dibujarCoordenadas(g); 
        //dibujarTiro(g);
        dibujarValores(g);
      } else {
        dibujarFondo(g);
        dibujarCoordenadas(g); 
        dibujarTiro(g);
        dibujarCanion(g);
        dibujarValores(g);
      }
    }
  }
  private void dibujarFondo(Graphics g) {
    
    ImageIcon cielo = new ImageIcon("cielo.png");
    g.drawImage(cielo.getImage(), 0, 0, this);
    ImageIcon suelo = new ImageIcon("suelo.png");
    g.drawImage(suelo.getImage(), 0, this.getHeight() - 185 , this);
    ImageIcon nube = new ImageIcon("nube.png");
    g.drawImage(nube.getImage(), this.getWidth() / 4, 0, this);
    ImageIcon sol = new ImageIcon("sol.png");
    g.drawImage(sol.getImage(), 0, 0, this); 
  }

  private void dibujarValores(Graphics g) {
    int siguiente = this.getHeight() / 4;
    // Alcance
    g.drawString(String.valueOf("Xmáx = " + getTiroParabolico().getAlcanceMaximo()) + " mts.", this.getWidth() / 2, siguiente);
    siguiente += getMargen();
    // Altura
    g.drawString(String.valueOf("Hmáx = " + getTiroParabolico().getAlturaMaxima()) + " mts.", this.getWidth() / 2, siguiente);
    siguiente += getMargen();
    // Tiempo
    g.drawString(String.valueOf("Ttotal = " + getTiroParabolico().getTiempoEnCaer()) + " seg.", this.getWidth() / 2, siguiente);
    siguiente += getMargen();
  }

  private void dibujarCanion(Graphics g) {
    ImageIcon img = new ImageIcon("canion.png");
    g.drawImage(img.getImage(), getMargen() / 2 + getMargen() / 8, this.getHeight() - getMargen() - getMargen() / 2, this);
  }

  private void dibujarRastro(Graphics g) {
    ImageIcon bala = new ImageIcon("bala.png");
    dibujarCoordenadasDeTiro(g);
    int origenX = getMargen();
    int origenY = this.getHeight() - getMargen();
    int incrementoAlcance = ((int) getTiroParabolico().getAlcanceMaximo()) / getNumLineasDelEje();
    int incrementoAltura = ((int) getTiroParabolico().getAlturaMaxima()) / getNumLineasDelEje();
    float pX = (float) incrementoAlcance / ((this.getWidth() - getMargen() - getMargen()) / getNumLineasDelEje());
    float pY = (float) incrementoAltura / ((this.getHeight() - getMargen() - getMargen()) / getNumLineasDelEje());
    if (getTiempo() < getTiroParabolico().getTiempoEnCaer()) {
      int x = getTiroParabolico().calcularTrayectoriaX(getTiempo());
      int y = getTiroParabolico().calcularTrayectoriaY(getTiempo());
      float punX = (float) x / pX;
      float punY = (float) y / pY;
      int puntoX = (int) punX;
      int puntoY = (int) punY;
      getPuntosX().add(puntoX);
      getPuntosY().add(puntoY);
      g.drawImage(bala.getImage(), origenX + getPuntosX().get(getPuntosX().size() - 1), origenY - getPuntosY().get(getPuntosY().size() - 1), this);
      //g.fillOval(origenX + getPuntosX().get(getPuntosX().size() - 1), origenY - getPuntosY().get(getPuntosY().size() - 1), 5, 5);
      setTiempo(getTiempo() + 0.1);
    } else {
      g.drawImage(bala.getImage(), origenX + getPuntosX().get(getPuntosX().size() - 1), origenY - getPuntosY().get(getPuntosY().size() - 1), this);
      //g.fillOval(origenX + getPuntosX().get(getPuntosX().size() - 1), origenY - getPuntosY().get(getPuntosY().size() - 1), 5, 5);
    }
  }

  private void dibujarTiro(Graphics g) {
    ImageIcon bala = new ImageIcon("bala.png");
    dibujarCoordenadasDeTiro(g);
    int origenX = getMargen();
    int origenY = this.getHeight() - getMargen();
    int incrementoAlcance = ((int) getTiroParabolico().getAlcanceMaximo()) / getNumLineasDelEje();
    int incrementoAltura = ((int) getTiroParabolico().getAlturaMaxima()) / getNumLineasDelEje();
    float pX = (float) incrementoAlcance / ((this.getWidth() - getMargen() - getMargen()) / getNumLineasDelEje());
    float pY = (float) incrementoAltura / ((this.getHeight() - getMargen() - getMargen()) / getNumLineasDelEje());
    if (getTiempo() < getTiroParabolico().getTiempoEnCaer()) {
      int x = getTiroParabolico().calcularTrayectoriaX(getTiempo());
      int y = getTiroParabolico().calcularTrayectoriaY(getTiempo());
      float punX = (float) x / pX;
      float punY = (float) y / pY;
      int puntoX = (int) punX;
      int puntoY = (int) punY;
      getPuntosX().add(puntoX);
      getPuntosY().add(puntoY);
      for (int i = 0; i < getPuntosX().size(); i++) {
        if (getPuntosY().size() > 1) {
          if (i > 0) {
            if (getPuntosY().get(i) < getPuntosY().get(i - 1)) {
              g.drawImage(bala.getImage(), origenX + getPuntosX().get(i), origenY - getPuntosY().get(i), this);
              //g.fillOval(origenX + getPuntosX().get(i), origenY - getPuntosY().get(i), 5, 5);
            }
          }
        }
        g.drawImage(bala.getImage(), origenX + getPuntosX().get(i), origenY - getPuntosY().get(i), this);
        //g.fillOval(origenX + getPuntosX().get(i), origenY - getPuntosY().get(i), 5, 5);
      }
      setTiempo(getTiempo() + 0.1);
    } else {
      for (int i = 0; i < getPuntosX().size(); i++) {
        if (getPuntosY().size() > 1) {
          if (i > 0) {
            if (getPuntosY().get(i) < getPuntosY().get(i - 1)) {
              g.drawImage(bala.getImage(), origenX + getPuntosX().get(i), origenY - getPuntosY().get(i), this);
              //g.fillOval(origenX + getPuntosX().get(i), origenY - getPuntosY().get(i), 5, 5);
            }
          }
        }
        g.drawImage(bala.getImage(), origenX + getPuntosX().get(i), origenY - getPuntosY().get(i), this);
        //g.fillOval(origenX + getPuntosX().get(i), origenY - getPuntosY().get(i), 5, 5);
      }
    }
  }

  private void dibujarCoordenadasDeTiro(Graphics g) {
    g.setColor(Color.WHITE);
    int incrementoX = ((this.getWidth() - getMargen()) - getMargen()) / getNumLineasDelEje();
    int incrementoY = ((this.getHeight() - getMargen()) - getMargen()) / getNumLineasDelEje();
    int incrementoAlcance = ((int) getTiroParabolico().getAlcanceMaximo()) / getNumLineasDelEje();
    
    int valorX = 0;
    int incrementoAltura = ((int) getTiroParabolico().getAlturaMaxima()) / getNumLineasDelEje();
    if (incrementoAltura == 0) {
      
    }
    int valorY = (int) getTiroParabolico().getAlturaMaxima();
    System.out.println(incrementoAltura);
    // Eje Y
    g.drawLine(getMargen(), getMargen(), getMargen(), this.getHeight() - getMargen());
    // Eje X
    g.drawLine(getMargen(), this.getHeight() - getMargen(), this.getWidth() - getMargen(), this.getHeight() - getMargen());

    // valores
    int lineaY = getMargen();
    int lineaX = getMargen();
    for (int i = 0; i < getNumLineasDelEje(); i++) {
      g.drawLine(getMargen(), lineaY, getMargen() + getTAM_LIN_EJE(), lineaY);
      g.drawString(String.valueOf(valorY), getMargen() / 4, lineaY + getTAM_LIN_EJE());
      lineaY += incrementoY;
      valorY -= incrementoAltura;
    }
    for (int i = 0; i <= getNumLineasDelEje(); i++) {
      g.drawLine(lineaX, this.getHeight() - getMargen(), lineaX, this.getHeight() - getMargen() - getTAM_LIN_EJE());
      g.drawString(String.valueOf(valorX), lineaX - (getMargen() / 2), this.getHeight() - getMargen() / 2);
      lineaX += incrementoX;
      valorX += incrementoAlcance; 
    }   
    g.setColor(Color.BLACK);
  }

  private void dibujarCoordenadas(Graphics g) {
    g.setColor(Color.WHITE);
    int incrementoX = ((this.getWidth() - getMargen()) - getMargen()) / getNumLineasDelEje();
    int incrementoY = ((this.getHeight() - getMargen()) - getMargen()) / getNumLineasDelEje();

    // Eje Y
    g.drawLine(getMargen(), getMargen(), getMargen(), this.getHeight() - getMargen());
    // Eje X
    g.drawLine(getMargen(), this.getHeight() - getMargen(), this.getWidth() - getMargen(), this.getHeight() - getMargen());

    // valores
    int lineaY = getMargen();
    int lineaX = getMargen();
    for (int i = 0; i < getNumLineasDelEje(); i++) {
      g.drawLine(getMargen(), lineaY, getMargen() + getTAM_LIN_EJE(), lineaY);
      lineaY += incrementoY;
    }
    for (int i = 0; i <= getNumLineasDelEje(); i++) {
      g.drawLine(lineaX, this.getHeight() - getMargen(), lineaX, this.getHeight() - getMargen() - getTAM_LIN_EJE());
      lineaX += incrementoX;
    }
    g.setColor(Color.BLACK);
  }

  /**
   * Geter & Setter
   */

  public boolean isIniciado() {
    return isIniciado;
  }

  public boolean isRastro() {
    return isRastro;
  }

  public void setRastro(boolean isRastro) {
    this.isRastro = isRastro;
  }

  public ArrayList<Integer> getPuntosX() {
    return puntosX;
  }

  public void setPuntosX(ArrayList<Integer> puntosX) {
    this.puntosX = puntosX;
  }

  public ArrayList<Integer> getPuntosY() {
    return puntosY;
  }

  public void setPuntosY(ArrayList<Integer> puntosY) {
    this.puntosY = puntosY;
  }

  public double getTiempo() {
    return tiempo;
  }

  public void setTiempo(double tiempo) {
    this.tiempo = tiempo;
  }

  public TiroParabolico getTiroParabolico() {
    return tiroParabolico;
  }

  public void setTiroParabolico(TiroParabolico tiroParabolico) {
    this.tiroParabolico = tiroParabolico;
  }

  public int getMargen() {
    return Margen;
  }

  public void setMargen(int margen) {
    Margen = margen;
  }

  public int getNumLineasDelEje() {
    return numLineasDelEje;
  }

  public void setNumLineasDelEje(int numLineasDelEje) {
    this.numLineasDelEje = numLineasDelEje;
  }

  public int getTAM_LIN_EJE() {
    return TAM_LIN_EJE;
  }

  public void setIniciado(boolean isIniciado) {
    this.isIniciado = isIniciado;
  }


}
