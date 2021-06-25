
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class main {

		public static  void main (String[] argv)
		{
			
			JFrame jf = new JFrame();  //GORSEL ARAYUZ OLUSTURMAK ICIN JFRAME KUTUPHANESINDEN BIR NESNE OLUSTURUYORUZ
			jf.setTitle("Final Odev"); //OLUSTURULAN PENCERENIN TITLE'I BELIRLENIYOR.
			jf.setSize(400,400); 	   //OLUSTURULAN PENCERENIN GENISLIK VE YUKSEKLIGI BELIRLENIYOR
			jf.setLocation(100,100);   //PENCERENIN EKRANDA BASLATILACAGI YERIN KOORDINATLARI BELIRLENIYOR
			jf.getContentPane().setLayout(new FlowLayout()); //OLUSTURULAN PENCEREDE ELEMENTLERI GOSTERMEK VE DUZENLEMEK ICIN LAYOUT TANIMLANIYOR
			
			
			
			//COMBOBOXLAR PARAMETRE OLARAK DIZI ALIR, BU NEDENLE PROJEDE ISTENEN COMBOBOX ELEMENTLERINI TUTACAK DIZILERI OLUSTURUYORUZ
			String arr1[]= {"Bir secim yapiniz", "Armstrong", "Mukemmel Sayi", "Polindromik"}; 
			String arr2[]= {"Bir secim yapiniz","1","2","3"};
			
			
			
			// PENCEREDE KULLANILAN DIGER ELEMENTLER TANIMLANIYOR 
			JButton button1 = new JButton("Hesapla"); 
			JTextField  text1 = new JTextField(10);
			JLabel sayiGirLabel = new JLabel("Sayi gir");
			JLabel label1 = new JLabel("0");
			JComboBox cb1 = new JComboBox(arr1);
			JComboBox cb2 = new JComboBox(arr2);
			JLabel boslukLabel = new JLabel("-----------------------------------------------");
			JLabel sonucLabel = new JLabel("sonuc");
			JTextField text2 = new JTextField(30);
			
			
			text2.setEditable(false); //TEXT2' ELEMENTINDE SONUC YAZILACAGI ICIN DISARIDAN MUDEHALE EDILMESINI ENGELLEDIK.
			label1.setVisible(false); //PROJENIN YAPILMASI SIRASINDA BAZI SONUCLARI TEST ETMEK ICIN OLUSTURULAN DEGISKEN PROJENIN SON HALINDE GOZUKMNEMESI ICIN INSIVIBLE OLARAK AYARLANDI.
			
			
			// YUKARIDA OLUSTURDUGUMUZ BUTTON, LABEL GIBI ELEMENTLERI EKRANDA GOZUKMESI ICIN ASAGIDAKI GIBI SIRASIYLA TANIMLIYORUZ.
			jf.getContentPane().add(sayiGirLabel);
			jf.getContentPane().add(text1);		
			jf.getContentPane().add(cb1);
			jf.getContentPane().add(cb2);	
			jf.getContentPane().add(label1);
			jf.getContentPane().add(boslukLabel);
			jf.getContentPane().add(sonucLabel);
			jf.getContentPane().add(text2);
			jf.getContentPane().add(button1);	
			
			
			//BUTTON'A BASILDIGINDA CALISTIRACAGI FONKSIYONNU TANIMLANMASI.
			button1.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e) {
							String yazi = ""; //TEXTFIELD2'DE YAZACAK METIN ICIN OLUSTURULAN BOS STRING.
							
							if (cb1.getSelectedIndex()==1)//COMBOBOX1'DE SECILEN SECENEGE GORE SAYININ UZEINDE FARKLI ISLEMLER YAPILMAKTADIR.
							{							  //BU IF KONTROLUNDE ARMSTRONG SAYISI OLUP OLMADGINI KONTROL EDIYORUZ.
								int sayi = Integer.parseInt(text1.getText()); //TEXT1'DEN ALINAN DEGER INTEGER'A DONUSTURULUYOR KI TIP FARKINDAN DOLAYI HATA OLMASIN	.				
								if (Armstrong(sayi)==true) {
									 yazi = "BU SAYI ARMSTRONG SAYISIDIR";
								}
								else
								{
									 yazi = "BU SAYI ARMSTYRONG SAYI DEGILDIR";
								}
								text2.setText(yazi + " " +(Integer.parseInt(text1.getText())+(cb2.getSelectedIndex()))); //TEXT2'YE SONUC YAZDIRILIYOR.
				
							}
							else if(cb1.getSelectedIndex()==2)//BU IF KONTROLUNDE MUKEMMEL SAYI KONTROLU YAPILIYOR.
							{	
							int sayi = Integer.parseInt(text1.getText());							
							if (MukemmelSayi(sayi)==true) {
								 yazi = "BU SAYI MUKEMMEL SAYISIDIR";
							}
							else
							{
								 yazi = "BU SAYI MUKEMMEL SAYI DEGILDIR";
							}
							text2.setText(yazi + " " +(Integer.parseInt(text1.getText())+(cb2.getSelectedIndex())));//TEXT2'YE SONUC YAZDIRILIYOR.
				
								
	
							}
							else if(cb1.getSelectedIndex()==3)//BU IF KONTROLUNDE POLIDROMIK SAYI KONTROLU YAPILIYOR.
							{
								int sayi = Integer.parseInt(text1.getText());							
								if (Polidromik(sayi)==true) {
									 yazi = "BU SAYI POLIDROMIK SAYISIDIR";
								}
								else
								{
									 yazi = "BU SAYI POLIDROMIK SAYI DEGILDIR";
								}
								text2.setText(yazi + " " +(Integer.parseInt(text1.getText())+(cb2.getSelectedIndex())));//TEXT2'YE SONUC YAZDIRILIYOR.
							
							}
							else //HERHANGI BIR SEY SECILMEDIGINDE KULLANICIYA VERILEN GERI BILDIRIM.
							{
								label1.setText("Bir seyler eksik veya yanlis");
							}
						}
						
					});
			
			 
			jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//PENCERENIN KAPANMA YONTEMININ BELIRLENMESI.
			jf.setResizable(false);//PENCERENIN BOYUTUNUN ELLE DEGISTIRILMESINI ENGELLEMEK ICIN YAZILAN KOD.
			jf.setVisible(true); //OLUSTURULAN PENCERENIN GORUNEBILIR OLMASI ICIN YAZILAN KOD. BU KISIM YAZILMAZSA OLUSTURULAN PENCERE EKRANDA GOZUKMEZ.
								
			
		}
		// SAYININ ARMSTRONG SAYISI OLUP OLMADIGINI KONTROL EDEN BOOLEAN FONKSIYON.
		public static boolean Armstrong(int sayi)
		{	
			boolean arms = false;
			int birler = sayi %10; //GIRILEN SAYININ BIRLER BASAMAGININ BULUNMASI.
			int onlar = ((sayi%100)-birler)/10; //GIRILEN SAYININ ONLAR BASAMAGININ BULUNMASI.
			int yuzler = ((sayi%1000)-onlar)/100;//GIRILEN SAYININ YUZLER BASAMAGININ BULUNMASI.
			
			//BULUNAN BIRLER, ONLAR VE YUZLER BASAMAKLARINDAKI SAYILARIN KUPLERININ ALINMASI VE TOPLANMASI.
			int yeniSayi = (int) Math.pow(birler, 3)+(int) Math.pow(onlar, 3)+(int) Math.pow(yuzler, 3);
			//RAKAMLARIN KUPLERININ TOPLMAMININ GIRILEN SAYI ILE ESIT OLUP OLMADIGININ KONTROL EDILMESI.
			if (yeniSayi == sayi)
			{
				arms = true;
			}
			else
			{
				arms = false;
			}
			
			return arms;
		}
		
		//GIRILEN SAYININ MUKEMMEL SAYI OLUP OLMADIGINI KONTROL EDEN FONKSIYON.
		public static boolean MukemmelSayi(int sayi)
		{	int toplam =0;
			boolean sonuc = false;
		//1'DEN BASLAYIP BELIRLENEN SAYIYA KADAR 1 ARTTIRILAN DONGU.
		for (int i=1; i<sayi; i++)
		{	
			//EGER GIRILEN SAYI 'I' DEGERINE TAM BOLUNUYORSA TOPLAM DEGERINE EKLENIR, BOLUNMUYORSA DONGU DEVAM EDER.
			if(sayi%i==0)
			{
				toplam = toplam+i;
			}
		}	// GIRILAN SAYI ILE BU SAYIYA TAM BOLUNEN DEGERLERIN TOPLAMLARI BIRBIRINE ESITSE SONUC DEGERI TRUE OLARAK ATANIR.
			if(sayi==toplam)
			{
				sonuc=true;
			}
			else
			{
				sonuc = false;
			}
			
			return sonuc;
		}
		
		
		//SAYININ POLIDROMIK OLUP OLMADIGINI KONTROL EDEN FONKSIYON
		public static boolean Polidromik(int sayi)
		{
			boolean sonuc = false;
			if (sayi <0)
			{
				sonuc = false;
			}
			//FONKSIYON ICINDE KULLANILACAK LOCAL DEGISKENLER
			int reversedInteger=0;
			int lastDigit = 0;
			int temp=sayi;
			
			while(temp !=0)
			{
				lastDigit=temp%10;
				reversedInteger= reversedInteger*10+lastDigit;
				temp=temp/10;
			}
			// GIRILEN SAYI VE O SAYININ TERS CEVRILMIS HALI BIRBINIRNE ESITSE BOOLEAN SONUC DEGERI TRUE OLARAK ATANIYOR.
			if (sayi== reversedInteger)
			{
				sonuc=true;
			}
			
			return sonuc;
		}
			
}
