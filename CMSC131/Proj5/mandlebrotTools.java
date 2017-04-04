import java.awt.Color;

public class MandelbrotTools {

  public static boolean isBig(ComplexNumber c)
  {
    MyDouble realSquared = c.getReal().multiply(c.getReal());
    MyDouble imagSquared = c.getImag().multiply(c.getImag());
    MyDouble summed = realSquared.add(imagSquared);
    if(summed.compareTo(Controller.DIVERGENCE_BOUNDARY) == 1)
    {
      return true;
    }
    else //Square each and compare to the Divergence Boundary
    {
      return false;
    }
  }
  public static int divergence(ComplexNumber c)
  {
    ComplexNumber g = c; //Need independent non changing variable in for loop
    int j;
    for(j = 0; isBig(g) == false; j++)
    {
      g = g.multiply(g).add(c);
      if (j == Controller.LIMIT) 
      {
        return -1;
      }
    }
    return j;
  }
  /* This method selects a non-black color for a point which DIVERGED when
   * tested with the Mandelbrot recurrence, based on how many terms in the
   * sequence were computed before the terms got "too big".
   *
   * The parameter represents the index of the term in the sequence which was
   * first to be "too big".  This value could be anything from 0 to
   * Controller.LIMIT.  The return value is the Color to be used
   * to color in the point.
   *
   * STUDENTS: IF you want to have some fun, write code for the else-if
   * clause below which says "modify this block to create your own color
   * scheme".  When someone runs the program and selects "Student Color
   * Scheme", the code you have written below will determine the colors.
   */
  public static Color getColor(int divergence) {
    Color returnValue;
    int value, redAmount, greenAmount, blueAmount;

    if (Controller.colorScheme == Controller.RED_AND_WHITE_BANDS)

      returnValue= (divergence % 2 == 0) ? Color.WHITE : Color.RED;

    else

      if (Controller.colorScheme == Controller.CRAZY_COLORS) {
        value= divergence * 2;
        redAmount= (value % 5) * (255 / 5);
        greenAmount= (value % 7) * (255 / 7);
        blueAmount= (value % 9) * (255 / 9);
        returnValue= new Color(redAmount, greenAmount, blueAmount);
      }

      else

        if (Controller.colorScheme == Controller.STUDENT_DEFINED) {

          /***************************************************************
           * Modify this block to create your own color scheme!          *
           ***************************************************************/
          returnValue= Color.WHITE;  // take out and return something useful

        } else throw new RuntimeException("Unknown color scheme selected!");

    return returnValue;
  }
}
