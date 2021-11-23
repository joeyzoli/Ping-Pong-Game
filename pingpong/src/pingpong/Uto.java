package pingpong;
import java.awt.*;

public class Uto 
{
	private Utoparameter adatok = new Utoparameter();						//�j p�ld�ny l�trehoz�sa
	
	Uto(int szeles, int magas, Point pozi, Image utokepe)									//konstruktor
	{
		this.beallito(szeles, magas, pozi);									//beallito f�ggv�ny h�v�sa
		//adatok.szin = szine;
		adatok.utokep = utokepe;
	}
	
	void beallito(int szeles, int magas, Point pozi)						//az �t� oszt�ly param�tereit be�ll�tja
	{
		adatok.szelesseg= szeles;
		adatok.hosszusag= magas;
		adatok.pozicio = pozi;
		
	}
	
	public Utoparameter lekerdezo()											//visszat�r az �t� adataival
	{
		return adatok;
	}
	
	public void rajzolo(Graphics rajzterulet)								//�t� kirajzol� met�dus
	{
		//rajzterulet.setColor(adatok.szin);									//�t� szin�nek be�ll�t�sa
		//rajzterulet.fillRect(adatok.pozicio.x, adatok.pozicio.y, adatok.szelesseg, adatok.hosszusag);		//�t� m�ret�nek kirajzol�sa
		
		rajzterulet.drawImage(adatok.utokep, adatok.pozicio.x, adatok.pozicio.y, adatok.szelesseg, adatok.hosszusag, null);
		
	}
}
