	/**
 * 
 */
package pingpong;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.image.BufferStrategy;

/**
 * @author Joey
 *
 */
public class Gamewindow extends JFrame implements KeyListener, MouseMotionListener							//JFrame oszt�ly �r�k�ltet�se
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Labda laszti;
	//Labda laszti2;
	Uto utobal;
	Uto utojobb;
	
	Insets keretek = this.getInsets();
	
	static int szamlalo1 = 0;
	static int szamlalo2 = 0;
	static String eredmeny1 = "0";
	static String eredmeny2 = "0";
	static final int labdapoziciox = 200;
	static final int labdapozicioy = 250;
	static final int labdasugar = 10;
	static final int vektorx = 10;
	static final int vektory = 12;
	//static final Color hatterszin = Color.BLACK;
	static final Color jobbuto_szine = Color.RED;
	static final Color baluto_szine = Color.GREEN;
	static final int utojobbszelesseg = 12;
	static final int utojobbhosszusag = 100;
	static final int utobalszelesseg = 12;
	static final int utobalhosszusag = 100;
	static final Image labda = Toolkit.getDefaultToolkit().getImage(".\\src\\pingpong\\ball.png");
	static final Image hatterkep = Toolkit.getDefaultToolkit().getImage(".\\src\\pingpong\\fapalya.jpg");
	static final Image utokep = Toolkit.getDefaultToolkit().getImage(".\\src\\pingpong\\acel.jpg");
	
	Gamewindow()												//konstruktor 
	{
		super();												//�soszt�ly konstruktora megh�v�sa
		this.setTitle("Ping Pong Game");						//ablak sz�veg�nyek megad�sa
		//this.getContentPane().setBackground(hatterszin);		//ablak h�tt�rszin�nek be�ll�t�sa feket�re
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//kil�p�s gomb
		laszti = new Labda(labdapoziciox, labdapozicioy, labdasugar, labda);
		//laszti2 = new Labda(200, 300, 10);
		laszti.vektorbeallit(vektorx, vektory);
		//laszti2.vektorbeallit(15, 5);
		this.setSize(600, 400);	
		utobal = new Uto(utobalszelesseg, utobalhosszusag, new Point(keretek.left + 70, (this.getHeight() - keretek.bottom) / 2 - (utobalhosszusag/2)), utokep); 
		utojobb = new Uto(utojobbszelesseg, utojobbhosszusag, new Point(this.getWidth() - 70 , (this.getHeight() - keretek.bottom) / 2 - (utojobbszelesseg/2)), utokep); 
		
		/*
		
		//.drawString("Sz�veg", pos_x. poz_y);
		//.setFont(betutipus);
		*/
		//this.getGlassPane().addKeyListener(this);
		addKeyListener(this);
		addMouseMotionListener(this);
		//this.setSize(600, 400);									//m�ret be�ll�t�sa
		this.setVisible(true);									//ablak l�that�v� t�tele
		
	}
	
	
	
	public void ujrarajzolo()									//�jrarajzol� met�dus
	{
		
		this.labdamozgatas();									//labda pozici�j�nak n�vel�se 1-el
		//this.labdamozgatas2();
		this.repaint();											//labda �jrarajzol�sa
	}
	
	@Override										//@Override a fell�l�r�s jele
	public void paint(Graphics g)					//fell�l�rjuk a kirajzol� met�dust
	{
		
		//g.drawImage(hatterkep, 0, 0, 800, 600, null);
		
		BufferStrategy bs = this.getBufferStrategy();	//Bufferstrat�gia lek�rdez�se
		
		if (bs == null)									//Ha m�g nincs Bufferstrat�gia l�trehozva, akkor
		{
			this.createBufferStrategy(3);				// l�trehozunk egy 3 bufferest az ablakhoz
		}
    	
    	if (bs != null)
    	{
    		Graphics bg = bs.getDrawGraphics();			// Lek�rdezz�k, hogy melyik bufferbe lehet rajzolni
    		//bg.setColor(hatterszin);					// Be�ll�tjuka rajzol�s sz�n�t a h�tt�rsz�nre
    		
    		bg.fillRect(0, 0, this.getSize().width,this.getSize().height);		// �s azzal "t�r�lj�k az eg�sz rajzfelletet
    		bg.drawImage(hatterkep, 0, 0, 800, 600, null);
    		laszti.rajzolo(bg);	
    		utobal.rajzolo(bg);
    		utojobb.rajzolo(bg);
    		
    		bg.setFont(new Font("Betu", Font.BOLD, 16));		//"Seqoe UI", Font.PLAIN, 16
    		
    		bg.drawString("Eredm�ny", 280, 50);
    		bg.drawString(eredmeny1, 200, 70);
    		bg.drawString(eredmeny2, 400, 70);
    		
    		
    		
        	bg.dispose();								// Dobjuk a Graphics objektumot
        	
        	bs.show();									// Be�ll�tjuk a Buffert a megjelen�t�sre
    	}
	}
	
	
	@Override
	public void	keyPressed(KeyEvent e)									//billenty�zet figyel� Listener
	{
		Point poziciojobb = utojobb.lekerdezo().pozicio;				//jobb �t� pozici�j�nak lek�rdez�se
		
		Insets keret = this.getInsets();								//ablak sz�leinek lek�rdez�se
		
		if(e.getKeyCode() == KeyEvent.VK_UP)							//ha a felfele ny�l lett lenyomva
		{
			if(keret.top < poziciojobb.y )								//ha a keret teteje kisebb mint a pozici� y �rt�ke
			{
				poziciojobb.y -= 25; 									//y �rt�k�t cs�kkentj�k 10-el
				utojobb.beallito(utojobb.lekerdezo().szelesseg, utojobb.lekerdezo().hosszusag, poziciojobb);			//�jra be�ll�tjuk az �t� hely�t
			}
		}
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN)							//lefele gomb megnyom�sakot aktiv�l�dik
		{
			if((this.getHeight() - keret.bottom) > (poziciojobb.y + utojobb.lekerdezo().hosszusag))			//ha a keret alja nagyobb mint az y �s az �t� hossza
			{
				poziciojobb.y += 25;									//y �rt�k�t n�velj�k 10-el
				utojobb.beallito(utojobb.lekerdezo().szelesseg, utojobb.lekerdezo().hosszusag, poziciojobb);		//�t� pozici�j�t �jra �ll�tjuk
			}
		}
		
	}
	
	@Override
	public void keyReleased(KeyEvent e)
	{

		Point poziciojobb = utojobb.lekerdezo().pozicio;				//jobb �t� pozici�j�nak lek�rdez�se
		
		Insets keret = this.getInsets();								//ablak sz�leinek lek�rdez�se
		
		if(e.getKeyCode() == KeyEvent.VK_UP)							//ha a felfele ny�l lett lenyomva
		{
			if(keret.top < poziciojobb.y )								//ha a keret teteje kisebb mint a pozici� y �rt�ke
			{
				poziciojobb.y -= 25; 									//y �rt�k�t cs�kkentj�k 10-el
				utojobb.beallito(utojobb.lekerdezo().szelesseg, utojobb.lekerdezo().hosszusag, poziciojobb);			//�jra be�ll�tjuk az �t� hely�t
			}
		}
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN)							//lefele gomb megnyom�sakot aktiv�l�dik
		{
			if((this.getHeight() - keret.bottom) > (poziciojobb.y + utojobb.lekerdezo().hosszusag))			//ha a keret alja nagyobb mint az y �s az �t� hossza
			{
				poziciojobb.y += 25;									//y �rt�k�t n�velj�k 10-el
				utojobb.beallito(utojobb.lekerdezo().szelesseg, utojobb.lekerdezo().hosszusag, poziciojobb);		//�t� pozici�j�t �jra �ll�tjuk
			}
		}
	}
	
	@Override
	public void	keyTyped(KeyEvent e)
	{

		Point poziciojobb = utojobb.lekerdezo().pozicio;				//jobb �t� pozici�j�nak lek�rdez�se
		
		Insets keret = this.getInsets();								//ablak sz�leinek lek�rdez�se
		
		if(e.getKeyCode() == KeyEvent.VK_UP)							//ha a felfele ny�l lett lenyomva
		{
			if(keret.top < poziciojobb.y )								//ha a keret teteje kisebb mint a pozici� y �rt�ke
			{
				poziciojobb.y -= 45; 									//y �rt�k�t cs�kkentj�k 10-el
				utojobb.beallito(utojobb.lekerdezo().szelesseg, utojobb.lekerdezo().hosszusag, poziciojobb);			//�jra be�ll�tjuk az �t� hely�t
			}
		}
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN)							//lefele gomb megnyom�sakot aktiv�l�dik
		{
			if((this.getHeight() - keret.bottom) > (poziciojobb.y + utojobb.lekerdezo().hosszusag))			//ha a keret alja nagyobb mint az y �s az �t� hossza
			{
				poziciojobb.y += 45;									//y �rt�k�t n�velj�k 10-el
				utojobb.beallito(utojobb.lekerdezo().szelesseg, utojobb.lekerdezo().hosszusag, poziciojobb);		//�t� pozici�j�t �jra �ll�tjuk
			}
		}
	}
	
	public void mouseMoved(MouseEvent e)
	{
		Point poziciobal = utobal.lekerdezo().pozicio;
		Insets keret = this.getInsets();
		
		if(e.getY() < keret.top)
		{
			poziciobal.y = keret.top; 
		}
		else if((e.getY() + utobal.lekerdezo().hosszusag) >= this.getHeight() - keret.bottom)
		{
			poziciobal.y = (this.getHeight() -keret.bottom - utobal.lekerdezo().hosszusag); 
		}
		else
		{
			poziciobal.y = e.getY();
		}
		
		utobal.beallito(utobal.lekerdezo().szelesseg, utobal.lekerdezo().hosszusag, poziciobal);
		//e.getX()
	}
	
	@Override
	public void mouseDragged(MouseEvent e) 
	{
		
	}
	
	
	public void labdamozgatas()
	{
		
		Insets keretek = this.getInsets();
		Point poz = laszti.poziciovisszaad();
		Point vektor = laszti.vektorlekerdez();
		int sugar = laszti.sugarvisszaad();
		Point pozijobb = utojobb.lekerdezo().pozicio;
		Point pozibal = utobal.lekerdezo().pozicio;
		
		/* �t�k fel�let�r�l t�rt�n� pattan�sokat kezel�se */
		
		if((poz.x + sugar*2 >= pozijobb.x) && (poz.x + sugar < (pozijobb.x + utojobb.lekerdezo().szelesseg)) && ( (poz.y + sugar >= pozijobb.y) && (poz.y + sugar <= pozijobb.y + utojobb.lekerdezo().hosszusag)))					//jobb �t�r�l val� pattan�s balra
		{
			laszti.vektorbeallit(vektor.x*(-1), vektor.y);						//�j vektor �rt�k be�ll�t�sa
		}
		
		if(((poz.x + sugar*2 <= (pozijobb.x + utojobb.lekerdezo().szelesseg)) && poz.x + sugar > pozijobb.x) && ( (poz.y + sugar*2 >= pozijobb.y) && (poz.y + sugar*2 <= pozijobb.y + utojobb.lekerdezo().hosszusag)))					//jobb �t�r�l val� pattan�s jobbra
		{
			laszti.vektorbeallit(vektor.x*(-1), vektor.y);						//�j vektor �rt�k be�ll�t�sa
		}
		
		if((poz.x + sugar <= (pozibal.x + (utobal.lekerdezo().szelesseg*2)) && poz.x + sugar >= pozibal.x) && ((poz.y + sugar >= pozibal.y) && (poz.y + sugar <= (pozibal.y + utobal.lekerdezo().hosszusag))))   //bal �t�r�l val� pattan�s jobbra
		{
			laszti.vektorbeallit(vektor.x*(-1), vektor.y);						//�j vektor �rt�k be�ll�t�sa
		}
		
		if((poz.x + sugar*2 >= pozibal.x && (poz.x + sugar < pozibal.x + utobal.lekerdezo().szelesseg)) && ((poz.y + sugar*2 >= pozibal.y) && (poz.y + sugar*2 <= (pozibal.y + utobal.lekerdezo().hosszusag))))   //bal �t�r�l val� pattan�s balra
		{
			laszti.vektorbeallit(vektor.x*(-1), vektor.y);						//�j vektor �rt�k be�ll�t�sa
		}
		
		
		/* az ablak sz�leir�l val� pattan�s kezel�se */
		
		if(poz.x + sugar*2> (this.getWidth() - keretek.right))        		//jobb oldalr�l pattan�s
		{
			laszti.poziciobeallit(((this.getWidth() - keretek.right) - sugar*2), poz.y);
			laszti.vektorbeallit(vektor.x*(-1), vektor.y);						//�j vektor �rt�k be�ll�t�sa
			szamlalo1 += 1;
			eredmeny1 = Integer.toString(szamlalo1);
		}
		
		if((poz.x - sugar) < keretek.left)									//bal oldalr�l pattan�s
		{
			laszti.poziciobeallit(keretek.left + (sugar*2), poz.y);
			laszti.vektorbeallit(vektor.x*(-1), vektor.y);						//�j vektor �rt�k be�ll�t�sa
			szamlalo2 += 1;
			eredmeny2 = Integer.toString(szamlalo2);
		}
		
		
		if((poz.y + sugar*2) > (this.getHeight() - keretek.bottom))				//allulr�l pattan�s
		{
			laszti.poziciobeallit(poz.x, (this.getHeight() - keretek.bottom - sugar*2));
			laszti.vektorbeallit(vektor.x, vektor.y*(-1));						//�j vektor �rt�k be�ll�t�sa
		}
		
		if((poz.y - sugar*2) < keretek.top)										//ablak tetej�r�l val� pattan�s
		{
			laszti.poziciobeallit(poz.x, keretek.top - sugar*2);
			laszti.vektorbeallit(vektor.x, vektor.y*(-1));						//�j vektor �rt�k be�ll�t�sa
		}
	
		laszti.poziciobeallit(poz.x + vektor.x, poz.y + vektor.y);				//laszti pozici�j�nak �jra�ll�t�sa
		
		
	}
	
		
	
	
}
