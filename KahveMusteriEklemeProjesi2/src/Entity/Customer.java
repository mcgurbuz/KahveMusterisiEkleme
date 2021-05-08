package Entity;

import Abstracts.IEntity;

public class Customer implements IEntity{
	//Bu class benim müşterilerime ait özellikleri tutuyor. Başka paketler altından buna erişebiliyorum.
	
	int id;
	String firsName;
	String lastName;
	int dateOfBirth;
	long nationalityid;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirsName() {
		return firsName;
	}

	public void setFirsName(String firsName) {
		this.firsName = firsName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(int dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public long getNationalityid() {
		return nationalityid;
	}

	public void setNationalityid(long nationalityid) {
		this.nationalityid = nationalityid;
	}

	public Customer(int id, String firsName, String lastName, int dateOfBirth, long nationalityid) {
		super();
		this.id = id;
		this.firsName = firsName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.nationalityid = nationalityid;
	}
	
	

}
