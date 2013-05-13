import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.JPanel;


public class Panel extends JPanel
{
	private static final long serialVersionUID = 1L;
	Image image;
	
	public Panel(Image imagen)
	{
		this.image=imagen;
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		if (this.image!=null)
		{
			g2. drawImage(image, 0,0,getWidth(), getHeight(), null);
		}
	}

	
}
