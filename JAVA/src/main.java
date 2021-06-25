
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
			
			JFrame jf = new JFrame();  
			jf.setTitle("Final Odev"); 
			jf.setSize(400,400); 	   
			jf.setLocation(100,100);   
			jf.getContentPane().setLayout(new FlowLayout()); 
			

			String arr1[]= {"Bir secim yapiniz", "Armstrong", "Mukemmel Sayi", "Polindromik"}; 
			String arr2[]= {"Bir secim yapiniz","1","2","3"};
			
			
			

			JButton button1 = new JButton("Hesapla"); 
			JTextField  text1 = new JTextField(10);
			JLabel sayiGirLabel = new JLabel("Sayi gir");
			JLabel label1 = new JLabel("0");
			JComboBox cb1 = new JComboBox(arr1);
			JComboBox cb2 = new JComboBox(arr2);
			JLabel boslukLabel = new JLabel("-----------------------------------------------");
			JLabel sonucLabel = new JLabel("sonuc");
			JTextField text2 = new JTextField(30);
			
			
			text2.setEditable(false);
			label1.setVisible(false); 
			

			jf.getContentPane().add(sayiGirLabel);
			jf.getContentPane().add(text1);		
			jf.getContentPane().add(cb1);
			jf.getContentPane().add(cb2);	
			jf.getContentPane().add(label1);
			jf.getContentPane().add(boslukLabel);
			jf.getContentPane().add(sonucLabel);
			jf.getContentPane().add(text2);
			jf.getContentPane().add(button1);	
			
			

			button1.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e) {
							String yazi = ""; 
							
							if (cb1.getSelectedIndex()==1)
							{							 
								int sayi = Integer.parseInt(text1.getText()); 				
								if (Armstrong(sayi)==true) {
									 yazi = "BU SAYI ARMSTRONG SAYISIDIR";
								}
								else
								{
									 yazi = "BU SAYI ARMSTYRONG SAYI DEGILDIR";
								}
								text2.setText(yazi + " " +(Integer.parseInt(text1.getText())+(cb2.getSelectedIndex()))); 
				
							}
							else if(cb1.getSelectedIndex()==2)
							{	
							int sayi = Integer.parseInt(text1.getText());							
							if (MukemmelSayi(sayi)==true) {
								 yazi = "BU SAYI MUKEMMEL SAYISIDIR";
							}
							else
							{
								 yazi = "BU SAYI MUKEMMEL SAYI DEGILDIR";
							}
							text2.setText(yazi + " " +(Integer.parseInt(text1.getText())+(cb2.getSelectedIndex())));
				
								
	
							}
							else if(cb1.getSelectedIndex()==3)
							{
								int sayi = Integer.parseInt(text1.getText());							
								if (Polidromik(sayi)==true) {
									 yazi = "BU SAYI POLIDROMIK SAYISIDIR";
								}
								else
								{
									 yazi = "BU SAYI POLIDROMIK SAYI DEGILDIR";
								}
								text2.setText(yazi + " " +(Integer.parseInt(text1.getText())+(cb2.getSelectedIndex())));
							
							}
							else 
							{
								label1.setText("Bir seyler eksik veya yanlis");
							}
						}
						
					});
			
			 
			jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jf.setResizable(false);
			jf.setVisible(true); 
								
			
		}

		public static boolean Armstrong(int sayi)
		{	
			boolean arms = false;
			int birler = sayi %10; 
			int onlar = ((sayi%100)-birler)/10; 
			int yuzler = ((sayi%1000)-onlar)/100;
			
			
			int yeniSayi = (int) Math.pow(birler, 3)+(int) Math.pow(onlar, 3)+(int) Math.pow(yuzler, 3);
			
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
		

		public static boolean MukemmelSayi(int sayi)
		{	int toplam =0;
			boolean sonuc = false;

		for (int i=1; i<sayi; i++)
		{	
		
			if(sayi%i==0)
			{
				toplam = toplam+i;
			}
		}	 
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
		
		
		
		public static boolean Polidromik(int sayi)
		{
			boolean sonuc = false;
			if (sayi <0)
			{
				sonuc = false;
			}
		
			int reversedInteger=0;
			int lastDigit = 0;
			int temp=sayi;
			
			while(temp !=0)
			{
				lastDigit=temp%10;
				reversedInteger= reversedInteger*10+lastDigit;
				temp=temp/10;
			}
		
			if (sayi== reversedInteger)
			{
				sonuc=true;
			}
			
			return sonuc;
		}
			
}
