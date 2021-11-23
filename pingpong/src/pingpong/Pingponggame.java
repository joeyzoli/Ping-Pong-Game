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
	
	static Gamewindow jatekablak;						//statikus ablak oszt�ly l�trehoz�sa
	static final int milisec = 45;
	
	public static void main(String[] args) 				//main f�ggv�ny
	{
		jatekablak = new Gamewindow();					//Gamewindow p�ld�nyos�t�sa
		Rajzoloszal kirajzolo = new Rajzoloszal();
		Thread szal1 = new Thread(kirajzolo);
		szal1.start();
		/*
		Timer idozito = new Timer();					//Timer oszt�lyb�l egy p�ld�ny l�trehoz�sa
		TimerTask idozitotask = new Ujrarajzolo();		//az id�z�t�b�l l�trehozunk egy p�ld�nyt
		
		Date datum = new Date();						//d�tum oszt�ly visszadja az aktu�lis d�tumot �s id�t
		idozito.schedule(idozitotask, datum, milisec);		//param�terezz�k a met�dust
		*/

	}
	
	static class Ujrarajzolo extends TimerTask			//TimerTask oszt�lyt �r�k�ltetj�k
	{
		public void run()								//mivel absztrakt met�dus a run, nek�nk kell meg�rni
		{
			jatekablak.ujrarajzolo();					//jatekablak ujrarajzol� met�dus megh�v�sa
		}
	}
	
	static class Rajzoloszal implements Runnable
	{
		public void run()
		{
			while(true)
			{
				
				jatekablak.ujrarajzolo();					//jatekablak ujrarajzol� met�dus megh�v�sa
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
