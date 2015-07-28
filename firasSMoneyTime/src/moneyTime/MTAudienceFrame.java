package moneyTime;
import java.awt.*;
import javax.swing.JPanel;

public class MTAudienceFrame extends JPanel {
  private double[] values;

  private String[] names;

  private String title;

  public MTAudienceFrame(double[] v, String[] n, String t) 
  {
	// names is assigned with "a","b","c" and "d" 
    names = n;
    // values is assigned with four random doubles which are between 0 and 14
    values = v;
    // titles is assigned with "Audience "
    title = t;
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    double minValue = 0;
    double maxValue = 0;
    
    for (int i = 0; i < values.length; i++) 
    {
    //minValue can not be less then 0 because of random(15)
      if (minValue > values[i])
        minValue = values[i];
      //maxValue can not be more then 15 of random(15)
      if (maxValue < values[i])
        maxValue = values[i];
    }
    System.out.println("minValue =" +minValue);
    System.out.println("maxValue =" +maxValue);
    // Dimension is the Dimension of the frame, the bigger the frame the bigger the Dimension.
    Dimension frameDimension = getSize();
    System.out.println(frameDimension);
    // width of the frame 
    int frameWidth = frameDimension.width;
    System.out.println("frameWidth = " + frameWidth);
    // height of the frame
    int frameHeight = frameDimension.height;
    System.out.println("frameHeight = "+frameHeight);
    //width of the frame divided by the number of integers in the values array which is 4
    int barWidth = frameWidth / values.length;
    System.out.println("barWidth = "+barWidth);

    Font titleFont = new Font("SansSerif", Font.BOLD, 20);
    //titleFontMetrics contains the three angles of the font descent,height and ascent
    FontMetrics titleFontMetrics = g.getFontMetrics(titleFont);
    System.out.println("titleFontMetrics = "+titleFontMetrics);
    Font labelFont = new Font("SansSerif", Font.PLAIN, 10);
    FontMetrics labelFontMetrics = g.getFontMetrics(labelFont);
    //labelFontMetrics contains the three angles of the font descent,height and ascent
    System.out.println("labelFontMetrics ="+labelFontMetrics);

    //titleWidth is the width of the title font
    int titleWidth = titleFontMetrics.stringWidth(title);
    System.out.println("titleWidth = "+titleWidth);
    /*y is equal the ascent of the title font because that will allow the title to not be
      Covered by the bars*/
    int y = titleFontMetrics.getAscent();
    System.out.println("y =" +y);
    /*x is equal to the frame's width minus the title's width divided by two because 
     this will allow the title to be written in the middle of the frame*/
    int x = (frameWidth - titleWidth) / 2;
    System.out.println("x =" +x);
    //"g.setFont(titleFont);" sets the font of the title which is "audience"
    g.setFont(titleFont);
    /*"g.drawString(title, x, y);" sets the title position in the frame
     x deals with the x axis and y deals with the y axis*/
    g.drawString(title, x, y);
    
    
    // top is equal to the height of the font 
    int top = titleFontMetrics.getHeight();
    System.out.println("top =" +top);
    // bottom is equal to the height of the label
    int bottom = labelFontMetrics.getHeight();
    System.out.println("bottom =" +bottom);
    double scale = (frameHeight - top - bottom) / (maxValue - minValue);
    System.out.println("scale =" +scale);
    /*y is equal to the  frameHeight minus labelFontMetrics.getDescent() because
     that will allow the labels to printed in the bottom of the frame*/	
    y = frameHeight - labelFontMetrics.getDescent();
    g.setFont(labelFont);


    for (int i = 0; i < values.length; i++) 
    {
      int valueX = i * barWidth + 1;
      int valueY = top;
      int height = (int) (values[i] * scale);
      valueY += (int) ((maxValue - values[i]) * scale);
      g.setColor(Color.red);
      g.fillRect(valueX, valueY, barWidth - 2, height);
      g.setColor(Color.black);
      g.drawRect(valueX, valueY, barWidth - 2, height);
      
      int labelWidth = labelFontMetrics.stringWidth(names[i]);
      /*x is equal to i * barWidth + (barWidth - labelWidth) / 2 because 
      that will allow the labels to be printed in the middle of each bar*/
      x = i * barWidth + (barWidth - labelWidth) / 2;
      g.drawString(names[i], x, y);
    }
    
    
  }

}
