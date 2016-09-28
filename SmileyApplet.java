//Welp...
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Color;

import javax.swing.JApplet;
import javax.swing.JPanel;

public class SmileyApplet extends JApplet 
{
	  public void init() 
	  {
	    add(new Smiley());
	  }
	  
	  public class Smiley extends JPanel 
	  {
		  public void paintComponent(Graphics drawing)
		  {
			  super.paintComponent(drawing);
			  Graphics2D drawing1 = (Graphics2D) drawing; 
		      drawing.setColor(Color.BLUE);
		      drawing.fillOval(70, 70, 500, 500); //Siste to tall forteller at det er en sirkel, cause like.
		      drawing.setColor(Color.GREEN);
		      drawing.fillOval(160, 160, 80, 80); //V-øye
		      drawing.fillOval(400, 160, 50, 50); //H-øye
		      drawing.setColor(Color.RED);
		      drawing1.setStroke(new BasicStroke(3));
		      drawing1.drawArc(110, 300, 200, 200, 200, -180); //Sexy Lips
		      drawing.setColor(Color.BLACK);
		      drawing.fillOval(180, 200, 20, 20); //iris V-øye
		      drawing.fillOval(420, 185, 20, 20); //iris H-øye
		  }
	}
}
