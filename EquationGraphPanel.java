package Ch10Polymorphism;
//********************************************************************
//  EquationGraphPanel.java       Author: Sarah Morris
//
//  Graphs equation of a linear function
//********************************************************************

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.LineBorder;

public class EquationGraphPanel extends JPanel
{
   private JSlider mSlider;
   private JSlider aSlider;
   private JSlider bSlider;
   private EquationViewportPanel display;
   private JLabel equationLabel;

   private final String EQUATION_SUBSTRING = "Graph of equation y = ";

   private final int MIN_VALUE = -5;
   private final int MAX_VALUE = 5;
   private final int INIT_VALUE = 0;
   private final int TICK_SPACING = 5;
   private final int MINOR_TICK_SPACING = 1;

   //-----------------------------------------------------------------
   //  Sets up the panel.
   //-----------------------------------------------------------------
   public EquationGraphPanel()
   {
      setLayout(new BorderLayout());

      add(getSliderPanel(), BorderLayout.WEST);

      display = new EquationViewportPanel();
      add(display, BorderLayout.CENTER);

      equationLabel = new JLabel(EQUATION_SUBSTRING + 0);
      equationLabel.setHorizontalAlignment(SwingConstants.CENTER);
      equationLabel.setFont(new Font("Dialog", Font.BOLD, 16));
      add(equationLabel, BorderLayout.NORTH);
   }

   //-----------------------------------------------------------------
   //  Creates the sliders and slider panel.
   //-------------------------------------------------------------
   private JPanel getSliderPanel()
   {
      SliderMouseListener changed = new SliderMouseListener();

      mSlider = new JSlider(JSlider.HORIZONTAL, MIN_VALUE, MAX_VALUE, INIT_VALUE);
      mSlider.setPaintTicks(true);
      mSlider.setPaintLabels(true);
      mSlider.setMajorTickSpacing(TICK_SPACING);
      mSlider.setMinorTickSpacing(MINOR_TICK_SPACING);
      mSlider.setSnapToTicks(true);
      mSlider.addMouseListener(changed);

      aSlider = new JSlider(JSlider.VERTICAL, MIN_VALUE, MAX_VALUE, INIT_VALUE);
      aSlider.setPaintTicks(true);
      aSlider.setPaintLabels(true);
      aSlider.setMajorTickSpacing(TICK_SPACING);
      aSlider.setMinorTickSpacing(MINOR_TICK_SPACING);
      aSlider.setSnapToTicks(true);
      aSlider.addMouseListener(changed);

      bSlider = new JSlider(JSlider.HORIZONTAL, MIN_VALUE, MAX_VALUE, INIT_VALUE);
      bSlider.setPaintTicks(true);
      bSlider.setPaintLabels(true);
      bSlider.setMajorTickSpacing(TICK_SPACING);
      bSlider.setMinorTickSpacing(MINOR_TICK_SPACING);
      bSlider.setSnapToTicks(true);
      bSlider.addMouseListener(changed);


      JPanel mPanel = new JPanel();
      mPanel.setLayout(new BoxLayout(mPanel, BoxLayout.X_AXIS));
      mPanel.setBorder(new LineBorder(Color.black));
      mPanel.add(new JLabel("value of slope"));
      mPanel.add(mSlider);

      JPanel aPanel = new JPanel();
      aPanel.setLayout(new BoxLayout(aPanel, BoxLayout.Y_AXIS));
      aPanel.setBorder(new LineBorder(Color.black));
      aPanel.add(new JLabel("value of vertical shift"));
      aPanel.add(aSlider);

      JPanel bPanel = new JPanel();
      bPanel.setLayout(new BoxLayout(bPanel, BoxLayout.Y_AXIS));
      bPanel.setBorder(new LineBorder(Color.black));
      bPanel.add(new JLabel("value of horizontal shift"));
      bPanel.add(bSlider);

      JPanel sliderPanel = new JPanel();
      sliderPanel.setLayout(new BoxLayout(sliderPanel, BoxLayout.Y_AXIS));
      JLabel title = new JLabel("m(x+a)+b");
      title.setFont(new Font("Dialog", Font.BOLD, 16));
      title.setHorizontalAlignment(SwingConstants.CENTER);
      sliderPanel.add(title);
      sliderPanel.add(new JLabel("Select values for coefficient:"));
      sliderPanel.add(Box.createVerticalGlue());
      sliderPanel.add(mPanel);
      sliderPanel.add(Box.createVerticalGlue());
      sliderPanel.add(aPanel);
      sliderPanel.add(Box.createVerticalGlue());
      sliderPanel.add(bPanel);

      return sliderPanel;
   }

   //-----------------------------------------------------------------
   //  Update and equation label.
   //-------------------------------------------------------------
   private void updateEquationLabel (Equation equation)
   {
      equationLabel.setText (EQUATION_SUBSTRING + equation.toString());
   }

   //********************************************************************
   //  Represents the mouse listener class for the sliders.
   //********************************************************************
   private class SliderMouseListener extends MouseAdapter
   {
      //-----------------------------------------------------------------
      //  Redraws the graph.
      //-----------------------------------------------------------------
      public void mouseReleased(MouseEvent event)
      {
         Equation equation = new Equation(mSlider.getValue(),
			aSlider.getValue(), bSlider.getValue());
         display.setEquation(equation);
         updateEquationLabel(equation);
         repaint();
      }
   }
}