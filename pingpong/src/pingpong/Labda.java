package pingpong;
import java.awt.*;

public class Labda 
{
	private int poziciox;
	private int pozicioy;
	private Point vektor;
	private int sugar;
	//static final Color labdaszine = Color.YELLOW;
	Image labda;
	
	Labda(int poziciox, int pozicioy, int sugar, Image labdak)						//labda l�trehoz�sa, ami 3 v�ltoz�t v�r
	{
		poziciobeallit(poziciox, pozicioy);								//pozici� be�ll�t� met�dus
		this.sugar = sugar;
		vektor = new Point(0, 0);
		labda = labdak;
	}
	
	public void poziciobeallit(int pozicioxbeall, int pozicioybeall)	//pozici� be�ll�t� met�dus
	{
		poziciox = pozicioxbeall;										//kapott �rt�ket �tadja a pozx-nek
		pozicioy = pozicioybeall;										//kapott �rt�ket �tadja a pozy-nek
		
	}
	
	public Point poziciovisszaad()										//visszaadja a labda aktu�lis pozici�j�t a labd�nak
	{
		return(new Point(poziciox, pozicioy));							//visszt�r�si �rt�k
		
	}
	
	public void rajzolo(Graphics rajzterulet)							//labda rajzol� met�dus
	{
		//rajzterulet.setColor(labdaszine);								//labda szin�t be�ll�tja s�rg�nak
		//rajzterulet.fillOval(poziciox-sugar, pozicioy - sugar , (sugar*2) , (sugar*2) );		//labda rajzol�sa a megadott param�terekkel
		
		rajzterulet.drawImage(labda, poziciox, pozicioy, sugar*2, sugar*2, null);
		
	}
	
	public void vektorbeallit(int x, int y)								//be�ll�tja a labda vektor�t
	{
		vektor.x = x;
		vektor.y = y;
	}
	
	public Point vektorlekerdez()										//visszaadja a labda vektor�nak �rt�keit
	{
		return vektor; 
	}
	
	public int sugarvisszaad()											//visszaadja a sugarat
	{
		return sugar;
	}

	
}
