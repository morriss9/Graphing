package Ch10Polymorphism;
//********************************************************************
//  Equation.java       Author: Sarah Morris
//
//  Graphs equation of a linear function
//********************************************************************

public class Equation
{
   private int m, a, b;

   //------------------------------------------------------------------
   //   Sets up the default coeficients of this equation:
   //   m*(x+a) +b
   //------------------------------------------------------------------
   public Equation()
   {
      m = 0;
      a = 0;
      b = 0;
   }

   //------------------------------------------------------------------
   //   Sets up the coeficients of this equation as specified.
   //------------------------------------------------------------------
   public Equation (int mValue, int horizontal, int vertical)
   {
      m = mValue;
      a = horizontal;
      b = vertical;
   }

   //------------------------------------------------------------------
   //   Computes the current value of this equation.
   //------------------------------------------------------------------
   public double computeValue(double x)
   {
      return m*(x + a) + b;
   }

// Returns a string representation of this equation.
 //------------------------------------------------------------------
 public String toString()
 {
    StringBuffer equation = new StringBuffer();

    if (m==0 && a==0 && b==0)
       equation.append("0");
    else
    {
       if(m!=0 && a==0 && b==0)
       {
           equation.append(m+"x");
       }
       else if(m!=0 && a!=0 && b==0)
       {
          if (a>0)
        	  equation.append(m+"(x + "+a+")");
          else
        	  equation.append(m+"(x - "+Math.abs(a)+")");
       }
       else if(m!=0 && a!=0 && b!=0)
       {
    	   if (a<0 && b<0)
         	  equation.append(m+"(x - "+Math.abs(a)+") - "+Math.abs(b));
           else if (a>0 && b>0)
         	  equation.append(m+"(x + "+a+") + "+b);
           else if (a<0 && b<0)
         	  equation.append(m+"(x - "+Math.abs(a)+") - "+b);
           else if (a>0 && b<0)
        	   equation.append(m+"(x + "+a+") - "+Math.abs(b));
           else if (a<0 && b>0)
        	   equation.append(m+"(x - "+Math.abs(a)+") + "+b);
       }
    }

    return equation.toString();
 }
}