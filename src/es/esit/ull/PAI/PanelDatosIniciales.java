package es.esit.ull.PAI;

import java.awt.Adjustable;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ComponentListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

public class PanelDatosIniciales extends JPanel {
  private final String VELOCIDAD = "Velocidad Inicial";
  private final String ANGULO = "Ángulo inicial";
  private final String ALTURA = "Altura inicial";
  private final String MS = " (m/s):  ";
  private final String GRAD = " (grados):  ";
  private final String MTS = " (mts):        ";
  private JScrollBar scrollVelocidad;
  private JScrollBar scrollAngulo;
  private JScrollBar scrollAltura;
  private final int MINIMO;
  private final int MAXIMO;
  private int velocidad;
  private int angulo;
  private int altura;
  private JLabel labelVelocidad;
  private JLabel labelAngulo;
  private JLabel labelAltura;
  
  public PanelDatosIniciales() {
    MINIMO = 1;
    MAXIMO = 310;
    velocidad = 0;
    angulo = 0;
    altura = 0;
    iniciarComponentes();
    repaint();
    establecerEstilo();
    iniciarOyentes();
  }

  private void establecerEstilo() {
    setBorder(BorderFactory.createTitledBorder("Datos Iniciales"));
    setBackground(Color.WHITE);
  }

  private void iniciarOyentes() {
    ListenerVelocidad oyenteVelocidad = new ListenerVelocidad();
    ListenerAngulo oyenteAngulo = new ListenerAngulo();
    ListenerAltura oyenteAltura = new ListenerAltura();
    
    getScrollVelocidad().addAdjustmentListener(oyenteVelocidad);
    getScrollAngulo().addAdjustmentListener(oyenteAngulo);
    getScrollAltura().addAdjustmentListener(oyenteAltura);
  }

  private void iniciarComponentes() {
    setScrollVelocidad(new JScrollBar(JScrollBar.HORIZONTAL));
    setScrollAngulo(new JScrollBar(JScrollBar.HORIZONTAL));
    setScrollAltura(new JScrollBar(JScrollBar.HORIZONTAL));
    
    getScrollVelocidad().setMinimum(getMINIMO());
    getScrollAngulo().setMinimum(0);
    getScrollAltura().setMinimum(0);
    
    getScrollVelocidad().setMaximum(getMAXIMO());
    getScrollAngulo().setMaximum(100);
    getScrollAltura().setMaximum(getMAXIMO());
    
    setLabelVelocidad(new JLabel(getVELOCIDAD() + getMS() + getVelocidad()));
    setLabelAngulo(new JLabel(getANGULO() + getGRAD() + getAngulo()));
    setLabelAltura(new JLabel(getALTURA() + getMTS() + getAltura()));
    
    setLayout(new GridLayout(3, 2));
    add(getLabelVelocidad());
    add(getScrollVelocidad());
    add(getLabelAngulo());
    add(getScrollAngulo());
    add(getLabelAltura());
    add(getScrollAltura());
  }

  class ListenerVelocidad implements AdjustmentListener {

    @Override
    public void adjustmentValueChanged(AdjustmentEvent e) {
      Adjustable adj = e.getAdjustable();
      if (e.getValueIsAdjusting()) {
        return;
      }
      setVelocidad(e.getValue());
      getLabelVelocidad().setText(getVELOCIDAD() + getMS() + getVelocidad());
      repaint();
    }
    
  }
  
  class ListenerAngulo implements AdjustmentListener {

    @Override
    public void adjustmentValueChanged(AdjustmentEvent e) {
      Adjustable adj = e.getAdjustable();
      if (e.getValueIsAdjusting()) {
        return;
      }
      setAngulo(e.getValue());
      getLabelAngulo().setText(getANGULO() + getGRAD() + getAngulo());
      repaint();
    }
    
  }
  
  class ListenerAltura implements AdjustmentListener {

    @Override
    public void adjustmentValueChanged(AdjustmentEvent e) {
      Adjustable adj = e.getAdjustable();
      if (e.getValueIsAdjusting()) {
        return;
      }
      setAltura(e.getValue());
      getLabelAltura().setText(getALTURA() + getMTS() + getAltura());
      repaint();
    }
    
  }
  /**
   * Getter & Setter
   */
  
  public JScrollBar getScrollVelocidad() {
    return scrollVelocidad;
  }

  public JLabel getLabelVelocidad() {
    return labelVelocidad;
  }

  public void setLabelVelocidad(JLabel labelVelocidad) {
    this.labelVelocidad = labelVelocidad;
  }

  public JLabel getLabelAngulo() {
    return labelAngulo;
  }

  public void setLabelAngulo(JLabel labelAngulo) {
    this.labelAngulo = labelAngulo;
  }

  public JLabel getLabelAltura() {
    return labelAltura;
  }

  public void setLabelAltura(JLabel labelAltura) {
    this.labelAltura = labelAltura;
  }

  public int getVelocidad() {
    return velocidad;
  }

  public void setVelocidad(int velocidad) {
    this.velocidad = velocidad;
  }

  public int getAngulo() {
    return angulo;
  }

  public void setAngulo(int angulo) {
    this.angulo = angulo;
  }

  public int getAltura() {
    return altura;
  }

  public void setAltura(int altura) {
    this.altura = altura;
  }

  public int getMINIMO() {
    return MINIMO;
  }

  public int getMAXIMO() {
    return MAXIMO;
  }

  public void setScrollVelocidad(JScrollBar scrollVelocidad) {
    this.scrollVelocidad = scrollVelocidad;
  }

  public JScrollBar getScrollAngulo() {
    return scrollAngulo;
  }

  public void setScrollAngulo(JScrollBar scrollAngulo) {
    this.scrollAngulo = scrollAngulo;
  }

  public JScrollBar getScrollAltura() {
    return scrollAltura;
  }

  public void setScrollAltura(JScrollBar scrollAltura) {
    this.scrollAltura = scrollAltura;
  }

  public String getVELOCIDAD() {
    return VELOCIDAD;
  }

  public String getANGULO() {
    return ANGULO;
  }

  public String getALTURA() {
    return ALTURA;
  }

  public String getMS() {
    return MS;
  }

  public String getGRAD() {
    return GRAD;
  }

  public String getMTS() {
    return MTS;
  }
  
}
