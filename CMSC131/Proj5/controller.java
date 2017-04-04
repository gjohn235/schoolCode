/* IMPORTANT:  THIS CLASS HAS BEEN WRITTEN FOR YOU.  DO NOT MODIFY IT!
 *
 * This driver displays a dialog box for the user to make choices about how
 * they would like to display the Mandelbrot Set.  It then creates the GUI
 * that displays the Mandelbrot Set and allows the user to use the mouse to
 * zoom in and redraw it.
 */
public class Controller  {

  // possible color schemes
  public final static int RED_AND_WHITE_BANDS= 0;
  public final static int CRAZY_COLORS= 1;
  public final static int STUDENT_DEFINED= 2;

  // Value will be one of the constants listed above.  Will be set at
  // runtime by the dialog box.
  public static int colorScheme;

  // After this many iterations through the Mandelbrot recurrence, we assume
  // the point is not in the set.  The value of this variable may be set at
  // runtime via the dialog box.
  public static int LIMIT= 255;

  // If the norm of a term in the Mandelbrot recurrence exceeds the square
  // root of this value, we immediately conclude that the sequence diverges.
  public final static MyDouble DIVERGENCE_BOUNDARY= new MyDouble(4.0);

  public static void main(String[] args) {
    GUI.runGUI();
  }
}
