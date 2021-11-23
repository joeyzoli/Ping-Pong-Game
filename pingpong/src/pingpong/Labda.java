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
	
	Labda(int poziciox, int pozicioy, int sugar, Image labdak)						//labda létrehozása, ami 3 változót vár
	{
		poziciobeallit(poziciox, pozicioy);								//pozició beállító metódus
		this.sugar = sugar;
		vektor = new Point(0, 0);
		labda = labdak;
	}
	
	public void poziciobeallit(int pozicioxbeall, int pozicioybeall)	//pozició beállító metódus
	{
		poziciox = pozicioxbeall;										//kapott értéket átadja a pozx-nek
		pozicioy = pozicioybeall;										//kapott értéket átadja a pozy-nek
		
	}
	
	public Point poziciovisszaad()										//visszaadja a labda aktuális pozicióját a labdának
	{
		return(new Point(poziciox, pozicioy));							//vissztérési érték
		
	}
	
	public void rajzolo(Graphics rajzterulet)							//labda rajzoló metódus
	{
		//rajzterulet.setColor(labdaszine);								//labda szinét beállítja sárgának
		//rajzterulet.fillOval(poziciox-sugar, pozicioy - sugar , (sugar*2) , (sugar*2) );		//labda rajzolása a megadott paraméterekkel
		
		rajzterulet.drawImage(labda, poziciox, pozicioy, sugar*2, sugar*2, null);
		
	}
	
	public void vektorbeallit(int x, int y)								//beállítja a labda vektorát
	{
		vektor.x = x;
		vektor.y = y;
	}
	
	public Point vektorlekerdez()										//visszaadja a labda vektorának értékeit
	{
		return vektor; 
	}
	
	public int sugarvisszaad()											//visszaadja a sugarat
	{
		return sugar;
	}

	
}
