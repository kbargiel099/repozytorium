import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class Marketing implements Comparator<Promocja>{

	private List<Promocja> promocje;
	private List<Ankieta> ankiety;
	private List<Ulotka> ulotki;
	
	public Marketing()
	{
		 promocje = new ArrayList<Promocja>();
		 ankiety = new ArrayList<Ankieta>();
		 ulotki = new ArrayList<Ulotka>();
	}
	
	public void utworzAnkiete(int id_ankiety, int id_produktu)
	{
		ankiety.add(new Ankieta(id_ankiety,id_produktu));
	}
	
	public void utworzPromocje(int id_promocji,Produkt produkt,String od_kiedy,String do_kiedy,double nowa_cena,List<Produkt> magazynProdukty)
	{
		Promocja promocja = new Promocja(id_promocji,produkt,od_kiedy,do_kiedy,nowa_cena);
		promocje.add(promocja);
		aktualizujCene(promocja.pobierzIdProduktu(),promocja.pobierzNowaCene(),magazynProdukty);
	}
	
	public void utworzAnkiete(List<Produkt> magazynProdukty)
	{
		Produkt produkt = new Produkt();
		String txt;
		int tmp = 1;
		produkt = wybierzProdukt(magazynProdukty);
		Ankieta ankieta = new Ankieta(ankiety.size()+1, produkt.pobierzId());
		boolean czyKolejnePytanie = true, czyWpisanePytanie = true;
		while(czyKolejnePytanie == true)
		{
			txt = JOptionPane.showInputDialog("Wpisz pytanie");
			if(txt == null)
			{
				czyWpisanePytanie = false;
				JOptionPane.showMessageDialog(null,"Ankieta nie zosta�a utworzona");
			}
			else
				ankieta.dodajPytanie(txt);
			if(czyWpisanePytanie == true)
				tmp = JOptionPane.showConfirmDialog(null,"Czy chcesz doda� nast�pne pytanie", " ", JOptionPane.YES_NO_OPTION);
			if(tmp == 1)
				czyKolejnePytanie = false;
			if(czyKolejnePytanie == false && czyWpisanePytanie == true)
			{
				ankiety.add(ankieta);
				JOptionPane.showMessageDialog(null,"Ankieta zosta�a utworzona pomy�lnie");
			}
		}
	}
	
	public void utworzUlotke()
	{
		ulotki.add(new Ulotka());
	}
	
	public void utworzPromocje(List<Produkt> magazynProdukty)
	{
		Produkt produkt;
		produkt = wybierzProdukt(magazynProdukty);
		if(produkt == null)
			JOptionPane.showMessageDialog(null,"Nie mo�na utworzy� promocji");
	    if((sprawdzPromocje(produkt) == true) && (produkt != null))
	    {
	    	int i;
	    	if(promocje.size() == 0)
	    	{
	    		i = 1;
	    	}else
	    	{	
	    		i = promocje.size();
	    		while(i == promocje.get(promocje.size()-1).pobierzIdPromocji())
	    			i++;
	    	}
	    	Promocja promocja = new Promocja(i,produkt);
	    	//sortowa� po ka�dym dodaniu nowej promocji po id_promocji
			promocje.add(promocja);
			Collections.sort(promocje, this);
			int indeks = wyszukaj(magazynProdukty, promocja.pobierzIdProduktu());
			aktualizujCene(indeks,promocja.pobierzNowaCene(),magazynProdukty);
			JOptionPane.showMessageDialog(null,"Promocja zosta�a utworzona pomy�lnie");
	    }
	    else
	    {
	    	if(produkt != null)
	    		JOptionPane.showMessageDialog(null,"Promocja na wybrany produkt ju� istnieje");	
	    }
	}
	
	public void usunAnkiete(List<Produkt> magazynProdukty)
	{
		Ankieta ankieta;
		ankieta = wybierzAnkiete(magazynProdukty);
		ankiety.remove(ankieta);
	}
	
	public void usunPromocje(Promocja promocja,List<Produkt> magazynProdukty)
	{
		if(promocje.contains(promocja))
		{
			promocje.remove(promocja);
			aktualizujCene(promocja.pobierzIdProduktu(),promocja.pobierzStaraCene(),magazynProdukty);
		}
	}
	
	public void usunPromocje(List<Produkt> magazynProdukty)
	{
		boolean czyZnalezionoProdukt = true;
		int indeksProdukt = -1;
		Promocja promocja;
		promocja = wybierzPromocje();
		int indeksPromocja = promocje.indexOf(promocja);
		try
		{
			indeksProdukt = wyszukaj(magazynProdukty, promocja.pobierzIdProduktu());
		}
		catch(NullPointerException npe)
		{
			czyZnalezionoProdukt = false;
		}
		if(czyZnalezionoProdukt == true)
		{
			aktualizujCene(indeksProdukt,promocja.pobierzStaraCene(),magazynProdukty);
			promocje.remove(indeksPromocja);
			JOptionPane.showMessageDialog(null,"Promocja zosta�a zako�czona");
		}
	}
	
	public String wypiszPromocje()
	{
		return promocje.toString();
	}
	
	public String wypiszAnkiety()
	{
		return ankiety.toString();
	}
	
	private boolean sprawdzPromocje(Produkt produkt)
	{
		int i = 0;
		while(i < promocje.size())
		{
			if(promocje.get(i).pobierzIdProduktu() == produkt.pobierzId())
			{
				return false;
			}
			i++;
		}
		return true;
	}
	
	private int wyszukaj(List<Produkt> produkty, int id_produktu)
	{
		int tmp = 0;
		int i = 0;
		int test = 0;
		while (i < produkty.size())
		{
			if (produkty.get(i).pobierzId() == id_produktu)
			{
				tmp = i;
				System.out.println("Znaleziono element");
				test = 1;
			}
			i++;
		}	
		
		if(test == 0)
		{
			System.out.println("Nie ma elementu");
			return -1;
		}
		
		return tmp;
	}
	
	private Promocja wybierzPromocje()
	{
		if(promocje.size() == 0)
		{
			JOptionPane.showMessageDialog(null,"Lista istniej�cych promocji jest pusta");
			return null;
		}
		Promocja[] tab = new Promocja[promocje.size()];
		int i = 0;
		while(i < promocje.size())
		{
			tab[i] = promocje.get(i);
			i++;
		}
		Promocja promocja = (Promocja)JOptionPane.showInputDialog(null,"Wybierz promocj�", "",JOptionPane.PLAIN_MESSAGE,null,tab,tab[0]);
		return promocja;
	}
	
	public Produkt wybierzProdukt(List<Produkt> magazynProdukty)
	{
		if(magazynProdukty.size() == 0)
		{
			JOptionPane.showMessageDialog(null,"Lista produkt�w jest pusta");
			return null;
		}
		String[] tab = new String[magazynProdukty.size()];
		int i = 0, indeks = 0;
		while(i < magazynProdukty.size())
		{
			tab[i] = magazynProdukty.get(i).pobierzNazwe();
			i++;
		}
		String txt = (String)JOptionPane.showInputDialog(null,"Wybierz produkt", "",JOptionPane.PLAIN_MESSAGE,null,tab,tab[0]);
		for(i = 0; i < magazynProdukty.size(); i++)
		{
			if(txt == magazynProdukty.get(i).pobierzNazwe())
				indeks = i;
		}
		return magazynProdukty.get(indeks);
	}
	
	public Ankieta wybierzAnkiete(List<Produkt> magazynProdukty)
	{
		if(ankiety.size() == 0)
		{
			JOptionPane.showMessageDialog(null,"Lista ankiet jest pusta");
			return null;
		}
		String[] tab = new String[ankiety.size()];
		int i = 0;
		while(i < ankiety.size())
		{
			int indeksProdukt = wyszukaj(magazynProdukty,ankiety.get(i).pobierzIdProduktu());
			tab[i] = "Id ankiety: "+ankiety.get(i).pobierzIdAnkiety()+"    (Produkt: "+magazynProdukty.get(indeksProdukt).pobierzNazwe()+")";
			i++;
		}
		String txt = (String)JOptionPane.showInputDialog(null,"Wybierz ankiet�", "",JOptionPane.PLAIN_MESSAGE,null,tab,tab[0]);
		String indeks = new String("");
		i = 12;
		while(txt.charAt(i) != ' ')
		{
			indeks = new String(indeks+txt.charAt(i));
			i++;
		}
		i = Integer.parseInt(indeks) - 1;
		return ankiety.get(i);
	}

	//Aktualizujemy cenePromocyjna produktu
	private void aktualizujCene(int indeks, double cena,List<Produkt> magazynProdukty)
	{
		magazynProdukty.get(indeks).ustawCenePromocyjna(cena);
		JOptionPane.showMessageDialog(null,"Cena produktu zosta�a zaktualizowana");
	}
	
	public List<Promocja> pobierzListePromocji()
	{
		return promocje;
	}
	
	public List<Ankieta> pobierzListeAnkiet()
	{
		return ankiety;
	}
	
    public int compare(Promocja o1, Promocja o2)
    {
        int c1 = o1.pobierzIdPromocji() - o2.pobierzIdPromocji();
        if(c1 > 0)
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }
	
}
