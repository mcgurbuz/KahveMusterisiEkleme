package Adapters;

import java.rmi.RemoteException;

import Abstracts.ICustomerCheckService;
import Entity.Customer;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapters implements ICustomerCheckService{

	@Override
	public boolean checkIfPerson(Customer customer) {
		//Mernis kimlik dogrulama sistemi dısarıdan alınacağı için Adapter altında newleme yapabiliriz.
		KPSPublicSoapProxy client = new KPSPublicSoapProxy();
		try {
			return client.TCKimlikNoDogrula(customer.getNationalityid(), customer.getFirsName(), customer.getLastName(), customer.getDateOfBirth());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}

}
