
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.ScrollPane;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.management.Query;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import twitter4j.DirectMessage;
import twitter4j.PagableResponseList;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;


public class interfaz extends JFrame
{	
	private static final long serialVersionUID = 1L;
	Panel panel ;	
	Panel inicio ;
	Panel amigos;
	twieter x;
	TextField pentext;
	JButton twitear;
	Image fondo,imagen;
	Twitter twitter;
	
	public interfaz( final Twitter twitter)
	{
		this.twitter=twitter;
		try
		{
			fondo=ImageIO.read(new File("imgs/fondo.jpg"));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		
		twitear = new JButton("Tweet");
		twitear.setIcon( new ImageIcon ("imgs/twit.png"));
		twitear.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				try {
						twitter.updateStatus(pentext.getText());			
		             }
				catch (TwitterException e) 
				{
					
					e.printStackTrace();
				}
				BorderLayout layout = (BorderLayout) panel.getLayout(); 
				panel.remove(layout.getLayoutComponent(BorderLayout.CENTER));
				
				
				
				
				actualizar();
				validate();
				repaint();
			}
		});
		JLabel pensar=new JLabel("              Que estas Pensando?: ");
		pensar.setFont(new Font("Arial",Font.BOLD,18));
		panel =new Panel(fondo);

		
	
		panel.setLayout(new BorderLayout());
		
		
		actualizar();
		
				
				
		Panel pensando = new Panel(null);
		pensando.setLayout(new BorderLayout());
		pensando.add(pensar,BorderLayout.NORTH);
		pensando.add(new JLabel("                      "),BorderLayout.WEST);
		pensando.add(twitear,BorderLayout.EAST);
		 pentext= new TextField();
		pensando.add(pentext,BorderLayout.CENTER);
		panel.add(pensando,BorderLayout.NORTH);
		
	   ;
		
		Toolkit kit  = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int height=screenSize.height; //ALTURA
		int width=screenSize.width; //ANCHO
		
		setLocation((width-900)/2,(height-600)/2);
		setSize(900,600);
		setTitle("Twitt ");
		setVisible(true);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(panel);		
		
		
	}

	
	public void actualizar()
	{
		inicio= new Panel(null);
		inicio.setLayout(new GridLayout(10,1));
		try {
				
				
				ResponseList<twitter4j.Status> miTimeLine;
				miTimeLine=twitter.getHomeTimeline();
				int cont=0;
				for (twitter4j.Status estatus : miTimeLine)
				{
					cont++;
					if(cont<10)
					{
						x =new twieter(estatus);
						inicio.add(x.diseñar());
					}
				}
			panel.add(inicio, BorderLayout.CENTER);
			
		
	       }
		 catch (TwitterException e)
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
	}

	
	public void Amigos()
	{   
		amigos= new Panel(null);
		amigos.setLayout(new GridLayout(10,1));
		try {
			//	twitter.updateStatus(":P ");
				
				
				ResponseList<Status> resultado;
				resultado=twitter.getFavorites();
				
				int cont=0;
				for (Status estatus : resultado)
				{
					cont++;
					if(cont<10)
					{
						x =new twieter(estatus);
						amigos.add(x.diseñar());
					}
					
				}
			panel.add(amigos, BorderLayout.CENTER);
			
		
	       }
		 catch (TwitterException e)
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
		
	}

	
	
}


