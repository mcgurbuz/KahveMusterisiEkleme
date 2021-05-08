package Abstracts;

import Entity.Customer;

public abstract class BaseCustomerManager implements ICustomerService{
	//CustomerManager sınıfları olan StarbucksCustomerManager ve NeroCustomerManager BaseCustomerManagerı
	//extend edecek.Base olan BaseCustomerManager ICustomerService ı implemente ederek. Interfacesi 
	//Referans olarak kullanabilecek bu yaptığımız hareketle. Yani ICustomerServisdeki Save metodunu
	//Starbucks ve Neroda kullanabilecek. Biz veritabanına kaydetme işini ikisi içinde 100 de 100 yapacağız
	//Eğer bu hareket yapılmasaydı ve NeroCustomerManager
	//StarbuckCustomerManager direkt olarak ICustomerService'i implemente etseydi her 2 classında içinde
	//Ben ICustomerService'De bulunan save metodunu implemente edip tekrar tekrar yazmak zorunda kalacaktım.
	//ÇOK ÖNEMLİ 
	//Senaryo gereği NeroCustomerManager ve StarbucksCustomerManager classları veri tabanını
	//kaydetme işlemlerini aynı tabloya aynı şekilde yapacak.
	//Yaptığı işten dolayı  base bir abstract class'a ihtiyaç duyuldu. 
	//Eğer NeroCustomerManager ve StarbucksCustomerManager classları veriyi farklı şekillerde 
	// Farklı tablolara kaydetseydi bu class'a gerek kalmayacaktı. 
	//NeroCustomerManager ve StarbucksCustomerManager classların ICustomerService'i direkt olarak implemente
	//etmesinde bir sakınca ortaya çıkmayacaktı.
		
		//C#'ta bu base'deki metodu bu class'ı extend eden metodlarda override edebilmek icin void'in soluna virtual anahtar kelimesi geliyor diÄŸer tÃ¼rlÃ¼
		//bu metodu bu class'Ä± extend eden metodlarda override edemeyiz ama Java'Da boyle bir parametreye ihtiyac yok override islemi icin.
		//Bu metodu StarbucksCustomerManager içerisinde override etmem lazım Çünkü StarbucksCustomerManager veri tabanına müşteri kaydederken müşteri bilgilerini
		//mernis ile dogrulamak istiyor. Bu dogrulama islemini save metodunu StarbucksCustomerManager icerisinde override ederek gerceklestirecegim.
		//Neroda boyle bir ihtiyac yok. Dolayısıyla NeroCustomerManager bu class'ı oldugu gibi kullanacaımız icin NeroCustomerManager buradaki save metodunu override 
		//etmeyecek.
	
	@Override
	public void save (Customer customer) throws Exception{
		
		
		System.out.println("Veri tabanına eklendi :" + " " + customer.getFirsName());
	}
	
}
