package Ch10Polymorphism;
//********************************************************************
//  EquationGraph.java       Author: Sarah Morris
//
//  Graphs equation of a linear function
//********************************************************************

import javax.swing.*;

public class EquationGraph
{
   //-----------------------------------------------------------------
   //  Creates and presents the program frame.
   //-----------------------------------------------------------------
   public static void main(String[] args)
   {
      JFrame frame = new JFrame("Equation Graph");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new EquationGraphPanel());
      frame.pack();
      frame.setVisible(true);
   }
}