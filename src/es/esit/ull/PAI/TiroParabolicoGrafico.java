package es.esit.ull.PAI;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class TiroParabolicoGrafico extends JPanel {

  public TiroParabolicoGrafico() {
    establecerEstilo();
  }

  private void establecerEstilo() {
    setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
  }
}
