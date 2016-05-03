package es.esit.ull.PAI;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.org.apache.bcel.internal.generic.GETSTATIC;

public class PanelControles extends JPanel {
  private JButton lanzar;
  private JButton Pausar;
  private JButton Borrar;
  private final String LANZAR = "Lanzar";
  private final String PAUSAR = "Pausar";
  private final String BORRAR = "Borrar";
  private TiroParabolicoGrafico tiroParabolicoGrafico;
  private PanelDatosIniciales panelDatosIniciales;
  private Interfaz interfaz;
  
  public PanelControles(TiroParabolicoGrafico tiroParabolicoGrafico, PanelDatosIniciales panelDatosIniciales, Interfaz interfaz) {
    this.tiroParabolicoGrafico = tiroParabolicoGrafico;
    this.panelDatosIniciales = panelDatosIniciales;
    this.interfaz = interfaz;
    iniciarComponentes();
    establecerEstilo();
    iniciarOyentes();
  }

  private void iniciarOyentes() {
    getLanzar().addActionListener(new LanzarListener());
    getPausar().addActionListener(new PausarListener());
    
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
  class LanzarListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
     getInterfaz().getTimer().start();
     tiroParabolicoGrafico.tiroNuevo(getPanelDatosIniciales().getVelocidad(), getPanelDatosIniciales().getAngulo(), getPanelDatosIniciales().getAltura());
    } 
  }
  class PausarListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) { 
      if (getInterfaz().isPausado()) {
        getInterfaz().getTimer().start();
        getInterfaz().setPausado(false);
      } else { 
          getInterfaz().getTimer().stop();
          getInterfaz().setPausado(true);
      }
    } 
  }
  /**
   * Getter & Setter
   */
  
  public JButton getLanzar() {
    return lanzar;
  }

  public Interfaz getInterfaz() {
    return interfaz;
  }

  public void setInterfaz(Interfaz interfaz) {
    this.interfaz = interfaz;
  }

  public TiroParabolicoGrafico getTiroParabolicoGrafico() {
    return tiroParabolicoGrafico;
  }

  public void setTiroParabolicoGrafico(TiroParabolicoGrafico tiroParabolicoGrafico) {
    this.tiroParabolicoGrafico = tiroParabolicoGrafico;
  }

  public PanelDatosIniciales getPanelDatosIniciales() {
    return panelDatosIniciales;
  }

  public void setPanelDatosIniciales(PanelDatosIniciales panelDatosIniciales) {
    this.panelDatosIniciales = panelDatosIniciales;
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
