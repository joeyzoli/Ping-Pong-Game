package pingpong;
import java.awt.*;

public class Uto 
{
	private Utoparameter adatok = new Utoparameter();						//új példány létrehozása
	
	Uto(int szeles, int magas, Point pozi, Image utokepe)									//konstruktor
	{
		this.beallito(szeles, magas, pozi);									//beallito függvény hívása
		//adatok.szin = szine;
		adatok.utokep = utokepe;
	}
	
	void beallito(int szeles, int magas, Point pozi)						//az ütõ osztály paramétereit beállítja
	{
		adatok.szelesseg= szeles;
		adatok.hosszusag= magas;
		adatok.pozicio = pozi;
		
	}
	
	public Utoparameter lekerdezo()											//visszatér az üté adataival
	{
		return adatok;
	}
	
	public void rajzolo(Graphics rajzterulet)								//ütõ kirajzoló metódus
	{
		//rajzterulet.setColor(adatok.szin);									//ütõ szinének beállítása
		//rajzterulet.fillRect(adatok.pozicio.x, adatok.pozicio.y, adatok.szelesseg, adatok.hosszusag);		//ütõ méretének kirajzolása
		
		rajzterulet.drawImage(adatok.utokep, adatok.pozicio.x, adatok.pozicio.y, adatok.szelesseg, adatok.hosszusag, null);
		
	}
}
