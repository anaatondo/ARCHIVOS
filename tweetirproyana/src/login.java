import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;


public class login extends JFrame
{
	String consumer,secret,accestoken,accestokensecret;
	Panel este,oeste,meramente,g,l,s,general;
	Image imagen;
	JButton ana;
	public login()
	{
		setTitle("Login");
		setSize(400,400);
		setVisible(true);
		
		try
		{
			imagen=ImageIO.read(new File("imgs/twiter.jpg"));
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		este=new Panel(null);
		oeste=new Panel(null);
		
		meramente=new Panel(imagen);
		oeste.setLayout(new GridLayout(10,1));
		
		g=new Panel(null);
		l=new Panel(null);
		s=new Panel(null);
		
		g.setLayout(new BorderLayout());
		l.setLayout(new BorderLayout());
		s.setLayout(new BorderLayout());
		
		
		ana=new JButton("ANA");
		ana.setIcon( new ImageIcon ("imgs/botonp.png"));
		
	
		// ana maria 
		ana.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{						
				Twitter twitter;
				RequestToken requestToken = null;
				AccessToken accessToken;
		         //Creamos una instancia de Twitter,
				//usemos el TwitterFactory , trabajamos con la version de Twitter4j 2.3.1
				twitter = new TwitterFactory().getInstance();
				
				twitter.setOAuthConsumer("2QgjowWaxzjy95VhKsBw", "pt5EtMDVMixdfln0DILoHVaYXjTp3pI5tHCGO27tc");
				
				try {
					requestToken = twitter.getOAuthRequestToken();
				} catch (TwitterException e) {
					
					e.printStackTrace();
				}
				
				final String url = requestToken.getAuthorizationURL();				
				
				twitter = new TwitterFactory().getInstance();

				twitter.setOAuthConsumer("2QgjowWaxzjy95VhKsBw","pt5EtMDVMixdfln0DILoHVaYXjTp3pI5tHCGO27tc");
				accessToken = new AccessToken("144224933-VmVTmKjuCrdAg4Eo5oHnGEaIiKQcb5ObVAogDhUj","mdI5kTMgm72VRAEfdss7xAa8WpLVYr63doPzD4mEEo");
				twitter.setOAuthAccessToken(accessToken);
				
				
				dispose();
				interfaz ventana= new interfaz(twitter);
		
				
			}
		});
		
		
		
		s.add(ana,BorderLayout.CENTER);
	
		g.add(new JLabel("  "),BorderLayout.SOUTH);
		
		l.add(new JLabel("  "),BorderLayout.SOUTH);
		
		s.add(new JLabel("  "),BorderLayout.SOUTH);
		
		oeste.add(g);
		oeste.add(l);
		oeste.add(s);
		
		
		meramente.setLayout(new BorderLayout());	
		meramente.add(oeste,BorderLayout.EAST);
		meramente.add(este,BorderLayout.WEST);
		
		meramente.setVisible(true);
		
		add(meramente);
		validate();
		repaint();
		
	}
	
	public static void main (String [] args)
	{
		login login=new login();
	}
}

