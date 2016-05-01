package es.esit.ull.PAI;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelControles extends JPanel {
  private JButton lanzar;
  private JButton Pausar;
  private JButton Borrar;
  private final String LANZAR = "Lanzar";
  private final String PAUSAR = "Pausar";
  private final String BORRAR = "Borrar";
  
  public PanelControles() {
    iniciarComponentes();
    establecerEstilo();
  }

  private void establecerEstilo() {
    setBorder(BorderFactory.createTitledBorder("Acciones"));
    setBackground(Color.WHITE);
  }

  private void iniciarComponentes() {
    setLanzar(new JButton(getLANZAR()));
    setPausar(new JButton(getPAUSAR()));
    setBorrar(new JButton(getBORRAR()));
    
    setLayout(new GridLayout(1, 3));
    add(getLanzar());
    add(getPausar());
    add(getBorrar());
  }
  
  /**
   * Getter & Setter
   */
  public JButton getLanzar() {
    return lanzar;
  }

  public void setLanzar(JButton lanzar) {
    this.lanzar = lanzar;
  }

  public JButton getPausar() {
    return Pausar;
  }

  public void setPausar(JButton pausar) {
    Pausar = pausar;
  }

  public JButton getBorrar() {
    return Borrar;
  }

  public void setBorrar(JButton borrar) {
    Borrar = borrar;
  }

  public String getLANZAR() {
    return LANZAR;
  }

  public String getPAUSAR() {
    return PAUSAR;
  }

  public String getBORRAR() {
    return BORRAR;
  }
  
}
