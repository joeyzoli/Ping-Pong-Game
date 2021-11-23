package pingpong;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

//import javax.swing.JFrame;

/**
 * @author Joey
 *
 */
public class Pingponggame 
{

	/**
	 * @param args
	 */
	
	static Gamewindow jatekablak;						//statikus ablak osztály létrehozása
	static final int milisec = 45;
	
	public static void main(String[] args) 				//main függvény
	{
		jatekablak = new Gamewindow();					//Gamewindow példányosítása
		Rajzoloszal kirajzolo = new Rajzoloszal();
		Thread szal1 = new Thread(kirajzolo);
		szal1.start();
		/*
		Timer idozito = new Timer();					//Timer osztályból egy példány létrehozása
		TimerTask idozitotask = new Ujrarajzolo();		//az idõzítõbõl létrehozunk egy példányt
		
		Date datum = new Date();						//dátum osztály visszadja az aktuális dátumot és idõt
		idozito.schedule(idozitotask, datum, milisec);		//paraméterezzük a metódust
		*/

	}
	
	static class Ujrarajzolo extends TimerTask			//TimerTask osztályt örököltetjük
	{
		public void run()								//mivel absztrakt metódus a run, nekünk kell megírni
		{
			jatekablak.ujrarajzolo();					//jatekablak ujrarajzoló metódus meghívása
		}
	}
	
	static class Rajzoloszal implements Runnable
	{
		public void run()
		{
			while(true)
			{
				
				jatekablak.ujrarajzolo();					//jatekablak ujrarajzoló metódus meghívása
				try
				{
					Thread.sleep(milisec);
				}
				catch(Exception e)
				{
					
				}
				
			}
		}
	}

}
