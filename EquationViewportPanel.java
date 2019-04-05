package Ch10Polymorphism;
//********************************************************************
//  EquationViewportPanel.java       Author: Sarah Morris
//
//  Graphs equation of a linear function
//********************************************************************

import java.awt.*;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class EquationViewportPanel extends JPanel
{
   private final int X_MIN = -10, Y_MIN = -10, X_MAX = 10, Y_MAX = 10;
   private final int REAL_WORLD_WIDTH = X_MAX - X_MIN;
   private final int REAL_WORLD_HEIGHT = Y_MAX - Y_MIN;
   private final double TICK_LENGTH = 0.2;

   private Equation equation;

   //-----------------------------------------------------------------
   //  Constructor: Sets up this panel.
   //-----------------------------------------------------------------
   public EquationViewportPanel()
   {
      equation = new Equation();
      setBorder(new LineBorder(Color.black, 4));
      setPreferredSize(new Dimension(500, 500));
   }

   //-----------------------------------------------------------------
   //  Sets the equation.
   //-----------------------------------------------------------------
   void setEquation(Equation newEquation)
   {
      equation = newEquation;
   }

   //-----------------------------------------------------------------
   //  Converts world X coordinate to screen X coordinate.
   //-----------------------------------------------------------------
   private int convertX(double x)
   {
      double offset = x - X_MIN;
      double result = offset * getSize().width / REAL_WORLD_WIDTH;
      return (int) Math.round(result);
   }

   //-----------------------------------------------------------------
   //  Converts world Y coordinate to screen Y coordinate.
   //-----------------------------------------------------------------
   private int convertY(double y)
   {
      double offset = Y_MAX - y;
      double result = offset * getSize().height / REAL_WORLD_HEIGHT;
      return (int) Math.round(result);
   }

   //-----------------------------------------------------------------
   //  Draws a line in world coordinates on the screen.
   //-----------------------------------------------------------------
   private void drawScreenLine(Graphics page, double xMin, double yMin,
      double xMax, double yMax)
   {
      page.drawLine(convertX(xMin), convertY(yMin), convertX(xMax), convertY(yMax));
   }

   //-----------------------------------------------------------------
   //  Draws a point in world coordinates on the screen.
   //-----------------------------------------------------------------
   private void drawScreenPoint(Graphics page, double x, double y)
   {
      page.drawLine(convertX(x), convertY(y), convertX(x), convertY(y));
   }

   //-----------------------------------------------------------------
   //  Draws the graph axes and equation.
   //-----------------------------------------------------------------
   public void paintComponent(Graphics page)
   {
      page.setColor(Color.white);
      page.fillRect(0,0,getSize().width, getSize().height);
      // draw the x and y axis
      page.setColor(Color.pink);
      drawScreenLine(page, X_MIN, 0, X_MAX, 0);
      drawScreenLine(page, 0, Y_MIN, 0, Y_MAX);

      // draw tick marks
      for (int x=X_MIN; x<X_MAX; x++)
         drawScreenLine(page, x, -TICK_LENGTH, x, TICK_LENGTH);
      for (int y=Y_MIN; y<Y_MAX; y++)
         drawScreenLine(page, -TICK_LENGTH, y, TICK_LENGTH, y);

      // draw the graph of the equation
      page.setColor(Color.black);
      double x = X_MIN;
      double y;
      double stepSize = (double)(X_MAX - X_MIN) / getSize().width;
      int screenX = getSize().width;
      for (int i = 0; i <= screenX; i++)
      {
         y = equation.computeValue(x);
         drawScreenPoint(page, x, y);
         x += stepSize;
      }
      
   }
}

