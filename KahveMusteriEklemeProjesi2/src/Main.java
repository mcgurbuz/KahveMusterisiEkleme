import Abstracts.BaseCustomerManager;
import Adapters.MernisServiceAdapters;
import Conceretes.NeroCustomerManager;
import Conceretes.StarbucksCustomerManager;
import Entity.Customer;

public class Main {

	public static void main(String[] args) {
		BaseCustomerManager customerManager = new StarbucksCustomerManager(new MernisServiceAdapters());
		try {
			customerManager.save(new Customer(1, "Mustafa Cem ", "GÜRBÜZ", 1996, 14678389152L));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
			
			
			
			
		

	}

}
