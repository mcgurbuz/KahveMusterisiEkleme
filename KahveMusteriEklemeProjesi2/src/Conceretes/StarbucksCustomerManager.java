package Conceretes;

import Abstracts.BaseCustomerManager;
import Abstracts.ICustomerCheckService;
import Entity.Customer;

public class StarbucksCustomerManager extends BaseCustomerManager {
	//Starbucks müşterileri de veritabanına kaydetme işini yapacak. Bu kaydetme işi ICUSTOMERSERVİCE altında
	//Save metodu ile yapılacak.
	//AMA şöyle bir şey var Starbucks kaydetmesi için mernis doğrulaması istiyor. 
	
	//DolaylÄ± yoldan interface'de ki save'i miras aldÄ±. Yani interface'i de referans olarak kullanabilecek. DolaylÄ± yoldan miras
		//aldÄ± diyoruz cunku BaseCustomer manager'da ICustomerService'i implemente ediyordu.
		
		//StrabucksManager'ın kimlik dogrulamaya ihtiyacı var ben bu kimlik dogurlama isini save metodunun altında yapabilirim
		//Ama gelecekte baska bir musterimde kimlik dogrulama sistemi istediginde benim burada ki save metodunun altında yazdığım
		//kimlik dogrulama metodunu kimlik dogrulama isteyen baska musterinin CustomerManager class'ının icinde yapmam lazım. Bu durumda
		//kod tekrarına dusecegim ve kimlik dogrulama fonksiyonu degistirildiginde tum musterilerde teker teker kodlarımızı degistirmek
		//zorunda kalacagim. Bu problemden kacinmak icin ICustomerCheckService adinda bir interface olusturdum.  Olusturdugum interface'i
		//bu class'imda implemente edip , interface'imde bulunan govdesiz metodu burada doldurabilirim. Bu 1. kullanÄ±m ama daha gÃ¼zel 
		//yöntem var bu yöntemin adı da dependency injection. 
		//bICustomerCheckService tipinde bu class'ın  altınnda bir ozellik olusturdum. Bu ozelligin constructorda atamasi yapildi. Yani Mainde ben 
		//StarbuckCustomerManager'ı newledigimde ICustomerCheckService objesi vermek zorundayÄ±m. save metodunun altÄ±nda verdigim ICustomerCheckService
		//objesi sayesinde checkIfRealPerson'a yani kimlik dogrulama metoduna ulasip kimlik dogrulama islemini gerceklestrimis oluyorum.
		
		//ÇOK ÖNEMLİ 
		//2. yontem olan dependency injection 1. yonteme gore cok daha iyi. Dependency injection'la kast edilen bagımlılık enjeksiyonu
		//yani biz StarbucksCustomerManager'ı Main'De newlerken muhakkak ICustomerCheckService tipinde bir nesneye ihtiyacımız var
		//Bu nesnelerimiz de ICustomerCheckService'i implemente eden kimlik dogrulama fonksiyonu checkIfRealPerson metodunu içerisinde
		//bulunduran kimlik dogrulama amacıyla olusturudugumuz classlar. Biz burada ICustomerCheckService objesine bagımlıyız. Ama 
		//bu bagimlilik iyi birsey cunku senaryo geregi starbucks'ın müsterilerini veri tabanına kaydederken mutlaka kimlik dogrulama
		//sisteminden dogrulama yapması gerektigini biliyoruz. Dependency injection ile beraber starbucks musterileri veri tabanina kaydedilmeden
		//once bu kimlik dogrulama islemini zorunlu kıldık. Eger 1. yontem kullanılırsa eger StarbucksCustomerManager ICustomerCheckService'i
		//implemente etseydi ve checkIfRealPerson burada metod olarak bulunsaydı sayet ben Mainde StarbucksCustomerManager'i manager newlerken
		//benden ICustomerCheckService tipinde bir nesne istenmeyecekti. Bu durumda kimlik dogrulama islemi yapmadan starbucks musterilerinin 
		//sisteme kaydedilmesine yol asabilirdi. Mainde StarbucksCustomerManager newleyip save metodunu calistirirsak ve checkIfRealPerson metodunu oncesinde
		//bir sart olarak save metodundan once uyarlamazsak starbucks musterileri kimlik dogrulama sistemine gecmeden kaydedilir. Dependency injection ile
		//hem senaryoda gerceklesmesi %100 gereken bir isteri gerceklestirmiyor olduk hemde Mainde save isleminden once  musteri kimlik dogrulamasi icin 
		//yazilmasi gereken sarti kodlamaktan kurtulduk.
	
	private ICustomerCheckService customerCheckService;

	public StarbucksCustomerManager(ICustomerCheckService customerCheckService) {
		super();
		this.customerCheckService = customerCheckService;
	}

    public void save(Customer customer)throws Exception {
		
		 if(customerCheckService.checkIfPerson(customer)) {
			 //Mernisten doğrulama olursa kaydedecek. Aksi taktirde hata fırlatacak...
			 super.save(customer);
			 
		 }else {
			 
			 throw new Exception("Geçersiz kisi dogrulanmamistir.Dogum tarihini kontrol ediniz...");
		 }
		
		
	}
	
	
	

}
