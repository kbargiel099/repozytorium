import java.util.List;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Ankieta {
	
	private int id_ankiety;
	private int id_produktu;
	private List<String> pytania; 

	public Ankieta(int id_ankiety, int id_produktu)
	{
		pytania = new ArrayList<String>();
		this.id_ankiety = id_ankiety;
		this.id_produktu = id_produktu;
	}
	
	public void dodajPytanie(String txt)
	{
		pytania.add(txt);
	}
	
	public void usunPytanie(int numer)
	{
		pytania.remove(numer);
	}
	
	void ustawIdAnkiety(int id)
	{
		id_ankiety = id;
	}
	
	int pobierzIdAnkiety()
	{
		return id_ankiety;
	}
	
	void ustawIdProduktu(int id)
	{
		id_produktu = id;
	}
	
	int pobierzIdProduktu()
	{
		return id_produktu;
	}
	
	public String toString()
	{
		return id_ankiety+","+id_produktu+","+pytania.toString();
	}
}
