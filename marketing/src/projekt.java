import java.util.List;
import java.util.ArrayList;

public class projekt {

	public static void main(String[] args) {
		
		Okno okno = new Okno();
	}
	
		private List<Produkt> db;
		
		public projekt()
		{
			db = new ArrayList<Produkt>();
		}
		
		public void dodaj(Produkt produkt)
		{
			db.add(produkt);
		}
		
		public String wypiszProdukty()
		{
			return db.toString();
		}
		
		
		public List<Produkt> pobierzListe()
		{
			return db;
		}
		
}
