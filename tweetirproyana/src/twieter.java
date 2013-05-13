import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;

import twitter4j.DirectMessage;
import twitter4j.Status;
import twitter4j.User;


public class twieter
{
	Status stat;
	
	
	public twieter(Status stats)
	{
		stat=stats;
	}
	
	

	public Panel diseñar()
	{
		
		URL direccion=stat.getUser().getProfileImageURL();
		JLabel usuario,texto;
		Image perfill=null,marco=null,sombra=null;
		
		try
		{
			marco=ImageIO.read(new File("imgs/perfil.png"));
			sombra=ImageIO.read(new File("imgs/sombra.png"));
			perfill=ImageIO.read(direccion);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		texto=new JLabel("   "+stat.getText());
		usuario=new JLabel("   "+stat.getUser().getName()+":");
		usuario.setFont(new Font("Arial",Font.BOLD,14));
		usuario.setForeground(Color.white);
		texto.setForeground(Color.lightGray);
		Panel ventwit = new Panel(null);
	
		
		Panel perfil = new Panel(marco);
		Panel foto =new Panel(perfill);	
		Panel contenido= new Panel(sombra);
		contenido.setLayout(new GridLayout(2,1));
	
		
		
		contenido.add(usuario);
		contenido.add(texto);
		
		ventwit.setLayout(new BorderLayout()); // INFORMACION DE MENSAGES
		ventwit.add(perfil,BorderLayout.WEST);
		ventwit.add(contenido,BorderLayout.CENTER);
		
		
		
		return  ventwit;
	}
}
