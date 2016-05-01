package es.esit.ull.PAI;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class PanelOpciones extends JPanel {
  private JCheckBox mostrarVelocidades;
  private JCheckBox mostrarRastro;
  private JCheckBox mostrarVector;
  private final String VEL = "Mostrar velocidades";
  private final String RASTRO = "Mostrar rastro";
  private final String VECTOR = "Mostrar vector";
  
  public PanelOpciones() {
    iniciarComponentes();
    establecerEstilo();
  }

  private void establecerEstilo() {
    setBorder(BorderFactory.createTitledBorder("Opciones gráficas"));
    setBackground(Color.WHITE);
  }

  private void iniciarComponentes() {
    setMostrarVelocidades(new JCheckBox(getVEL()));
    setMostrarRastro(new JCheckBox(getRASTRO()));
    setMostrarVector(new JCheckBox(getVECTOR()));
    
    setLayout(new GridLayout(3, 1));
    add(getMostrarVelocidades());
    add(getMostrarRastro());
    add(getMostrarVector());
  }
  
  /**
   * Getter & Setter
   */
  
  public JCheckBox getMostrarVelocidades() {
    return mostrarVelocidades;
  }

  public String getVEL() {
    return VEL;
  }

  public String getRASTRO() {
    return RASTRO;
  }

  public String getVECTOR() {
    return VECTOR;
  }

  public void setMostrarVelocidades(JCheckBox mostrarVelocidades) {
    this.mostrarVelocidades = mostrarVelocidades;
  }

  public JCheckBox getMostrarRastro() {
    return mostrarRastro;
  }

  public void setMostrarRastro(JCheckBox mostrarRastro) {
    this.mostrarRastro = mostrarRastro;
  }

  public JCheckBox getMostrarVector() {
    return mostrarVector;
  }

  public void setMostrarVector(JCheckBox mostrarVector) {
    this.mostrarVector = mostrarVector;
  }
  
}
