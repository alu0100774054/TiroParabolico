package es.esit.ull.PAI;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
  private TiroParabolicoGrafico tiroParabolicoGrafico;
  
  public PanelOpciones(TiroParabolicoGrafico tiroParabolicoGrafico) {
    this.tiroParabolicoGrafico = tiroParabolicoGrafico;
    iniciarComponentes();
    establecerEstilo();
    iniciarOyentes();
  }

  private void iniciarOyentes() {
    getMostrarRastro().addActionListener(new RastroListener());
    
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
  
  class RastroListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      if (getMostrarRastro().isSelected()) {
        getTiroParabolicoGrafico().setRastro(true);
      } else {
        getTiroParabolicoGrafico().setRastro(false);
      }
      
    } 
  }
  /**
   * Getter & Setter
   */
  
  public JCheckBox getMostrarVelocidades() {
    return mostrarVelocidades;
  }

  public TiroParabolicoGrafico getTiroParabolicoGrafico() {
    return tiroParabolicoGrafico;
  }

  public void setTiroParabolicoGrafico(TiroParabolicoGrafico tiroParabolicoGrafico) {
    this.tiroParabolicoGrafico = tiroParabolicoGrafico;
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
