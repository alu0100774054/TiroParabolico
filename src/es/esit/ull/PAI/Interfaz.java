package es.esit.ull.PAI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class Interfaz extends JFrame {
  private PanelControles panelControles;
  private PanelDatosIniciales panelDatosIniciales;
  private PanelOpciones panelOpciones;
  private TiroParabolicoGrafico tiroParabolicoGrafico;
  private JPanel panelControl;
  private JPanel panelBotones;
  private JPanel panelContenedor;                         // Contiene todas las herramientas.
  
  public Interfaz() {
   panelControl = new JPanel();
   panelBotones = new JPanel();
   panelContenedor = new JPanel();
   iniciarInterfaz();
   iniciarComponentes();
   establecerEstilo();
  }

  private void establecerEstilo() {
    getPanelControl().setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Panel de control", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
    getPanelControl().setBackground(Color.WHITE);
  }

  private void iniciarComponentes() {
    setPanelControles(new PanelControles());
    setPanelDatosIniciales(new PanelDatosIniciales());
    setTiroParabolicoGrafico(new TiroParabolicoGrafico());
    setPanelOpciones(new PanelOpciones());
    
    getPanelBotones().setLayout(new GridLayout(1, 1));
    getPanelBotones().add(getPanelControles());
    
    getPanelControl().setLayout(new GridLayout(1, 2));  
    getPanelControl().add(getPanelDatosIniciales());
    getPanelControl().add(getPanelOpciones());
    
    add(getTiroParabolicoGrafico(), BorderLayout.CENTER);
    getPanelContenedor().setLayout(new BorderLayout());
    getPanelContenedor().add(getPanelControl(), BorderLayout.CENTER);
    getPanelContenedor().add(getPanelBotones(), BorderLayout.PAGE_END);
    add(getPanelContenedor(), BorderLayout.PAGE_END);
  }

  private void iniciarInterfaz() {
    setLayout(new BorderLayout());
    setSize(new Dimension(800, 800));
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("Tiro Parabólico");
  }

  /**
   * Getter & Setters
   */
  
  public PanelControles getPanelControles() {
    return panelControles;
  }

  public JPanel getPanelContenedor() {
    return panelContenedor;
  }

  public void setPanelContenedor(JPanel panelContenedor) {
    this.panelContenedor = panelContenedor;
  }

  public JPanel getPanelBotones() {
    return panelBotones;
  }

  public void setPanelBotones(JPanel panelBotones) {
    this.panelBotones = panelBotones;
  }

  public PanelOpciones getPanelOpciones() {
    return panelOpciones;
  }

  public void setPanelOpciones(PanelOpciones panelOpciones) {
    this.panelOpciones = panelOpciones;
  }

  public TiroParabolicoGrafico getTiroParabolicoGrafico() {
    return tiroParabolicoGrafico;
  }

  public void setTiroParabolicoGrafico(TiroParabolicoGrafico tiroParabolicoGrafico) {
    this.tiroParabolicoGrafico = tiroParabolicoGrafico;
  }

  public JPanel getPanelControl() {
    return panelControl;
  }

  public void setPanelControl(JPanel panelControl) {
    this.panelControl = panelControl;
  }

  public PanelDatosIniciales getPanelDatosIniciales() {
    return panelDatosIniciales;
  }

  public void setPanelDatosIniciales(PanelDatosIniciales panelDatosIniciales) {
    this.panelDatosIniciales = panelDatosIniciales;
  }

  public void setPanelControles(PanelControles panelControles) {
    this.panelControles = panelControles;
  }
  
}
