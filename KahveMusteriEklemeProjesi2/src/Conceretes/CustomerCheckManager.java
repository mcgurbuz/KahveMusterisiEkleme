package Conceretes;

import Abstracts.ICustomerCheckService;
import Entity.Customer;

public class CustomerCheckManager  implements ICustomerCheckService{
	//Bu class ICustomerCheckService'i implemente ediyor. Simdi bu class sayesinde StarbucksCustomerManager'dan bagimsiz bir sekilde
	//bir dogrulama metodu olusturdum. Kimlik dogrulama sisteminden hata gelmezse eger default olarak true yolluyor metodumuz.

	@Override
	public boolean checkIfPerson(Customer customer) {
		//Burada mernis'e ait kodlarÄ± koyabilir ve calÄ±stÄ±rabilirdik fakat bu durumda da bu metodun altÄ±nda 
		//bir newleme islemi gerceklestirecektik. Bu islem yuzunden checkIfRealPerson metodum mernis kimlik dogrulama sistemine
		//tamamen bagÄ±mlÄ± olacaktÄ± ve bu bizim istemedigimiz birsey. Bundan dolayÄ± mernis'i kendi sistemime entegre ederken 
		//adapters diye bir paket olusturuyorum ve adapters'Ä±n altÄ±ndan mernis'i sistemime entegre ediyorum. Dış bir sistemi sisteme
		//dahil ederken bu yÃ¶ntem kullanÄ±lÄ±r yani adapters denilen design patterns kullanÄ±lÄ±r. BurasÄ± bizim kendi servisimiz. Bize ait kodlar
		//burada olmalÄ± . DÄ±ÅŸarÄ±dan sisteme entegre edeceÄŸim servisler adapters'Ä±n altÄ±nda olmalÄ±. BurasÄ± boÅŸ gÃ¶zÃ¼kÃ¼yor ama burada kendi servimizle
		//alakalÄ± olan checkIfRealPerson metodu var. Burada kendi servisimizle ilgili kodlarÄ±n oldugunu dusunebiliriz.
		return true;
	}

}
