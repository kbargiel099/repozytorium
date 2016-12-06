
public class Produkt {
	
	private int id_produktu;
	private String nazwa;
	private double cena;
	private double cenaPromocyjna;
	private double waga;
	
	public Produkt(int id_produktu,String nazwa,double cena,double cenaPromocyjna,double waga)
	{
		this.id_produktu = id_produktu;
		this.nazwa = nazwa;
		this.cena = cena;
		this.cenaPromocyjna = cenaPromocyjna;
		this.waga = waga;
	}
	
	public Produkt()
	{
		
	}
	
	public void ustawId(int id_produktu)
	{
		this.id_produktu = id_produktu;
	}
	
	public int pobierzId()
	{
		return id_produktu;
	}
	
	public void ustawCeneSprzedazy(double cena)
	{
		this.cena = cena;
	}
	
	public double pobierzCeneSprzedazy()
	{
		return cena;
	}
	
	public void ustawCenePromocyjna(double cenaPromocyjna)
	{
		this.cenaPromocyjna = cenaPromocyjna;
	}
	
	public double pobierzCenePromocyjna()
	{
		return cenaPromocyjna;
	}
	
	public void ustawNazwe(String nazwa)
	{
		this.nazwa = nazwa;
	}
	
	public String pobierzNazwe()
	{
		return nazwa;
	}
	
	public String toString()
	{
		return nazwa+" cena: "+cena;
	}
}
