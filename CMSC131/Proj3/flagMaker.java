package studentCode;

import java.awt.Color;
import gridTools.MyGrid;

public class FlagMaker
{
  public static void drawFlag(MyGrid grid, int countryCode)
  {
    int width = grid.getWd(), height = grid.getHt(); //Grabs grid measurements
    int widthCount, heightCount, g, j; //Variables that will be painted (g & j only used for Congo in Debug Fix)
    
     if (countryCode == 1) //Italy Flag
     {
       if (height % 3 == 0 && width == height*2) //Mandatory flag parameters
       {
         for (heightCount = 0; heightCount < height; heightCount++) //Repeats all for every row
         {
           for (widthCount = 0; widthCount < width; widthCount++) //Colors whole flag green
           {
             grid.setColor(heightCount, widthCount, Color.GREEN);
           }
           for (widthCount = width / 3; widthCount < width; widthCount++) //Colors whole flag white, except for the first third
           {
             grid.setColor(heightCount, widthCount, Color.WHITE);
           }
           for (widthCount = ((width / 3)*2); widthCount < width; widthCount++) //Colors whole flag red, except for first two thirds
           {
             grid.setColor(heightCount, widthCount, Color.RED);  
           }
         }
       }
       else
       {
         for (heightCount = 0; heightCount < height; heightCount++)
         {
           for (widthCount = 0; widthCount < width; widthCount++)
           {
             grid.setColor(heightCount, widthCount, Color.WHITE); //Colors entire error flag white
             grid.setColor(0, 0, Color.RED); //Colors very first pixel red
             grid.setColor(height-1, 0, Color.BLUE); //Colors bottom left pixel blue
             grid.setColor(0, width-1, Color.YELLOW); //Colors top right pixel yellow
             grid.setColor(height-1, width-1, Color.GREEN); //Colors bottom left pixel green
           }
         }
       }
     }   
     if (countryCode == 2) //Chile Flag
     {
       if (height % 6 == 0 && width == height*2) //Mandatory flag parameters
       {
         for (heightCount = 0; heightCount < height; heightCount++) //Repeats all for every row
         {
           for (widthCount = 0; widthCount < width; widthCount++) //Colors everything red
           {
            grid.setColor(heightCount, widthCount, Color.RED);
           }
           for (widthCount = 0; widthCount < width; widthCount++) //Colors top half blue
           {
             grid.setColor(heightCount/2, widthCount, Color.BLUE);
           }
           for (widthCount = width / 3; widthCount < width; widthCount++) //Colors top half and right two third's white
           {
             grid.setColor(heightCount/2, widthCount, Color.WHITE);
           }
         }
       }
       else
       {
         for (heightCount = 0; heightCount < height; heightCount++)
         {
           for (widthCount = 0; widthCount < width; widthCount++)
           {
             grid.setColor(heightCount, widthCount, Color.WHITE); //Colors entire error flag white
             grid.setColor(0, 0, Color.RED); //Colors very first pixel red
             grid.setColor(height-1, 0, Color.BLUE); //Colors bottom left pixel blue
             grid.setColor(0, width-1, Color.YELLOW); //Colors top right pixel yellow
             grid.setColor(height-1, width-1, Color.GREEN); //Colors bottom left pixel green
           }
         }
       }
     }
     if (countryCode == 3) //Dominican Republic Flag
     {
       if (height % 8 == 0 && width == (height + (height/2))) //Mandatory flag parameters
       {
         for (heightCount = 0; heightCount < height; heightCount++) //Repeats all for very row
         {
           
           for (widthCount = 0; widthCount < width; widthCount++) //Colors left half red
           {
             grid.setColor(heightCount, widthCount/2, Color.RED);
           }
           for (widthCount = width/2; widthCount < width; widthCount++) //Colors right half blue
           {
             grid.setColor(heightCount, widthCount, Color.BLUE);
           }
           for (widthCount = 0; widthCount < width; widthCount++) //Colors top left half blue
           {
             grid.setColor(heightCount/2, widthCount, Color.BLUE);
           }
           for (widthCount = width/2; widthCount < width; widthCount++) //Colors top right half red
           {
             grid.setColor(heightCount/2, widthCount, Color.RED);
           }    
         }
         for (heightCount = 0; heightCount < height; heightCount++) //Allows white paint to go over other colors
         {
           for (widthCount = 0; widthCount < width; widthCount++)
           {
             grid.setColor((heightCount/4)+height/4*3/2, widthCount, Color.WHITE);
           }
           for (widthCount = height/4; widthCount < height/2; widthCount++)
           {
             grid.setColor(heightCount, widthCount+(height/4*3/2), Color.WHITE);
           }
         }
       }
       else
       {
         for (heightCount = 0; heightCount < height; heightCount++)
         {
           for (widthCount = 0; widthCount < width; widthCount++)
           {
             grid.setColor(heightCount, widthCount, Color.WHITE); //Colors entire error flag white
             grid.setColor(0, 0, Color.RED); //Colors very first pixel red
             grid.setColor(height-1, 0, Color.BLUE); //Colors bottom left pixel blue
             grid.setColor(0, width-1, Color.YELLOW); //Colors top right pixel yellow
             grid.setColor(height-1, width-1, Color.GREEN); //Colors bottom left pixel green
           }
         }
       }
     }
     if (countryCode == 4) //Switzerland Flag
     {
       if (height % 5 == 0 && width == height) //Mandatory flag parameters
       {
         for (heightCount = 0; heightCount < height; heightCount++) //Repeats all for every row
         {
           for (widthCount = 0; widthCount < width; widthCount++) //Colors everything red
           {
             grid.setColor(heightCount, widthCount, Color.RED);
           }
         }
         for (heightCount = 0; heightCount < height; heightCount++) //Allows white paint to go over other colors
         {
           for (widthCount = 0; widthCount < width; widthCount++) //Horizontal white band
           {
             grid.setColor((heightCount/5)+height/5*2, widthCount, Color.WHITE);
           }
           for (widthCount = height/5*2; widthCount < height/5*3; widthCount++) //Vertical white band
           {
             grid.setColor(heightCount, widthCount, Color.WHITE);
           }
         }
         for (heightCount = 0; heightCount < height; heightCount++) //Other needed red paint
         {
           for (widthCount = 4*width/5; widthCount < width; widthCount++) //Colors right of white band
           {
             grid.setColor(heightCount, widthCount, Color.RED);
           }
           for (widthCount = 0; widthCount < width/5; widthCount++) //Colors left of white band
           {
             grid.setColor(heightCount, widthCount, Color.RED);
           }
         }
         for (heightCount = 0; heightCount < height/5; heightCount++) //Top band red paint
         {
           for (widthCount = 0; widthCount < width; widthCount++)
           {
             grid.setColor(heightCount, widthCount, Color.RED);
           }
         }
         for (heightCount = 4*height/5; heightCount < height; heightCount++) //Bottom band red paint
         {
           for (widthCount = 0; widthCount < width; widthCount++)
           {
             grid.setColor(heightCount, widthCount, Color.RED);
           }
         }
       }
       else
       {
         for (heightCount = 0; heightCount < height; heightCount++)
         {
           for (widthCount = 0; widthCount < width; widthCount++)
           {
             grid.setColor(heightCount, widthCount, Color.WHITE); //Colors entire error flag white
             grid.setColor(0, 0, Color.RED); //Colors very first pixel red
             grid.setColor(height-1, 0, Color.BLUE); //Colors bottom left pixel blue
             grid.setColor(0, width-1, Color.YELLOW); //Colors top right pixel yellow
             grid.setColor(height-1, width-1, Color.GREEN); //Colors bottom left pixel green
           }
         }
       }
     }
     if (countryCode == 5) //Republic of Congo
     {
       if (height % 2 == 0 && width == (height+(height/2))) //Mandatory flag parameters
       {
         for (heightCount = 0; heightCount < height; heightCount++) //Colors everything yellow
         {
           for (widthCount = 0; widthCount < width; widthCount++)
           {
             grid.setColor(heightCount, widthCount, Color.YELLOW);
           }
         }
         for (g = height, heightCount = 0; heightCount < width; heightCount++)
         {
           for (widthCount = 0; widthCount < g; widthCount++) //Colors that left section green
           {
             grid.setColor(heightCount, widthCount, Color.GREEN);
           } //Subtracts one green from each row ("g" is needed because there must be a height variable specific for the green part of the flag
           g--;
         } //When I just used "height--" it screwed up my next for loop that colored the red portion that also needed to use the flag's height
         for (j = ((height/2)+1), heightCount = height-1; heightCount > 0; heightCount--)
         { //heightCount < and heightCount++, are flipped here unlike the rest of the program to allow the red the do the reverse affect of the green
           for (widthCount = j; widthCount < width; widthCount++)
           {
             grid.setColor(heightCount, widthCount, Color.RED);
           } //"j" serves similar purpose as "g" did
           j++; // Adds a red to each row
         }
       }
       else
       {
         for (heightCount = 0; heightCount < height; heightCount++)
         {
           for (widthCount = 0; widthCount < width; widthCount++)
           {
             grid.setColor(heightCount, widthCount, Color.WHITE); //Colors entire error flag white
             grid.setColor(0, 0, Color.RED); //Colors very first pixel red
             grid.setColor(height-1, 0, Color.BLUE); //Colors bottom left pixel blue
             grid.setColor(0, width-1, Color.YELLOW); //Colors top right pixel yellow
             grid.setColor(height-1, width-1, Color.GREEN); //Colors bottom left pixel green
           }
         }
       }       
     }
     if (countryCode != 1 && countryCode != 2 && countryCode != 3 && countryCode != 4 && countryCode != 5)
     {
       for (heightCount = 0; heightCount < height; heightCount++)
       {
         for (widthCount = 0; widthCount < width; widthCount++)
         {
           grid.setColor(heightCount, widthCount, Color.WHITE); //Colors entire error flag white
           grid.setColor(0, 0, Color.RED); //Colors very first pixel red
           grid.setColor(height-1, 0, Color.BLUE); //Colors bottom left pixel blue
           grid.setColor(0, width-1, Color.YELLOW); //Colors top right pixel yellow
           grid.setColor(height-1, width-1, Color.GREEN); //Colors bottom left pixel green
         }
       }
     }   
  }
}
