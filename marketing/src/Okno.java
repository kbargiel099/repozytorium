import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Okno {

	JFrame okno;
	JButton przycisk1,przycisk2,przycisk3,przycisk4,przycisk5;
	
	Marketing marketing;
	projekt pr; 
	Okno()
	{
		marketing = new Marketing();
		pr = new projekt();
		pr.dodaj(new Produkt(1,"M¹ka",2.99,2.99,1));
		pr.dodaj(new Produkt(2,"P¹czek",1.49,1.49,1));
		pr.dodaj(new Produkt(3,"Mas³o",4.89,4.89,1));
		pr.dodaj(new Produkt(4,"Chleb",1.49,1.49,1));
		pr.dodaj(new Produkt(5,"Pepsi",3.89,3.89,1));
		pr.dodaj(new Produkt(6,"Czekolada",2.49,2.49,1));
		pr.dodaj(new Produkt(7,"Bu³ka",1.49,1.49,1));
		pr.dodaj(new Produkt(8,"Wafle",3.99,3.99,1));
		pr.dodaj(new Produkt(9,"Mleko",2.19,2.19,1));
		pr.dodaj(new Produkt(10,"D¿em",3.59,3.59,1));
		pr.dodaj(new Produkt(11,"Lemoniada",1.89,1.89,1));
		pr.dodaj(new Produkt(12,"Pomarañcze",4.49,4.49,1));
				pr.dodaj(new Produkt(12,"Pomarañcze",4.49,4.49,1));
		
		JFrame okno = new JFrame("Marketing");
		okno.getContentPane().setLayout(null);
		okno.setBounds(50, 50, 400, 300);
		okno.setLocation(300, 200);
		okno.setVisible(true);
		okno.getContentPane();
		przycisk1 = new JButton("Nowa promocja");
		przycisk1.setBounds(230, 150, 122, 25);
		przycisk1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		przycisk1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				marketing.utworzPromocje(pr.pobierzListe());
			}
		});
		okno.add(przycisk1);
		
		przycisk2 = new JButton("Nowa ankieta");
		przycisk2.setBounds(230, 115, 122, 25);
		//przycisk2.setSize(120, 20);
		przycisk2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		przycisk2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				marketing.utworzAnkiete(pr.pobierzListe()); 	
			}
		});
		okno.add(przycisk2);
		
		przycisk3 = new JButton("Zakoñcz promocjê");
		przycisk3.setBounds(230, 220, 122, 25);
		przycisk3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		przycisk3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				marketing.usunPromocje(pr.pobierzListe()); 	
			}
		});
		okno.add(przycisk3);
		
		przycisk4 = new JButton("Usuñ ankietê");
		przycisk4.setBounds(230, 185, 122, 25);
		przycisk4.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		przycisk4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				marketing.usunAnkiete(pr.pobierzListe()); 	
			}
		});
		okno.add(przycisk4);
		
		przycisk5 = new JButton("SprawdŸ magazyn");
		przycisk5.setBounds(20, 220, 122, 25);
		przycisk5.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		przycisk5.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				System.out.println(pr.pobierzListe());
			}
		});
		okno.add(przycisk5);
	}
}
