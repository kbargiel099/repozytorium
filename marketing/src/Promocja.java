import java.util.Comparator;
import javax.swing.*;

public class Promocja {

	private int id_promocji;
	private Produkt produkt;
	private String od_kiedy;
	private String do_kiedy;
	private double stara_cena;
	private double nowa_cena;
	
	Promocja(int id_promocji,Produkt produkt)
	{
		this.id_promocji = id_promocji;
		this.produkt = produkt;
		ustalCene();
		ustalDate();
		this.stara_cena = produkt.pobierzCeneSprzedazy();
	}
	
	Promocja(int id_promocji,Produkt produkt,String od_kiedy,String do_kiedy,double nowa_cena)
	{
		this.id_promocji = id_promocji;
		this.produkt = produkt;
		this.od_kiedy = new String(od_kiedy);
		this.do_kiedy = new String(do_kiedy);
		this.stara_cena = produkt.pobierzCeneSprzedazy();
		this.nowa_cena = nowa_cena;
	}
	
	private void ustalCene()
	{
		String txt1 = JOptionPane.showInputDialog("Podaj cen�");
		nowa_cena = Double.parseDouble(txt1);
	}
	
	private void ustalDate()
	{
		String txt1 = JOptionPane.showInputDialog("Podaj dat� rozpocz�cia");
		od_kiedy = new String(txt1);
		String txt2 = JOptionPane.showInputDialog("Podaj dat� zako�czenia");
		do_kiedy = new String(txt2);
	}
	
	public int pobierzIdPromocji()
	{
		return id_promocji;
	}
	
	public int pobierzIdProduktu()
	{
		return produkt.pobierzId();
	}
	
	public double pobierzNowaCene()
	{
		return nowa_cena;
	}
	
	public double pobierzStaraCene()
	{
		return stara_cena;
	}
	
	public String toString()
	{
		return id_promocji+" "+produkt.pobierzNazwe()+" data: "+od_kiedy+"/"+do_kiedy+"       (Id produktu:"+produkt.pobierzId()+")";
	}
	
}
