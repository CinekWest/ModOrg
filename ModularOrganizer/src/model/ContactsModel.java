//Author: Damian Piela
package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;

/**
 * Model for the Contacts module.
 * 
 * @author Damian Piela
 *
 */
public class ContactsModel {
	
	private ContactsData data;
	
	/**
	 * Constructor for the ContactsModel class.
	 */
	public ContactsModel(){
		data = new ContactsData();
		
		//loading serialized file
		try{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:/ModularOrganizer/Contacts/contacts.pd"));
			data = (ContactsData)in.readObject();
			in.close();
		}catch(Exception e){}
	}//end of constructor
	
	
	/**
	 * Checks on the specified location on the hard drive and saves serializable ContactsData object.
	 */
	public void saveContacts(){
		File location = new File("C:/ModularOrganizer/Contacts");
		
		if(location.exists()){
			try{
				Files.delete(location.toPath());
			}catch(Exception e){}
			
			location.mkdirs();
		}else{
			location.mkdirs();
		}
		
		try{
			ContactsData pd = data;
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("C:/ModularOrganizer/Contacts/contacts.pd"));
			out.writeObject(pd);
			out.close();
		}catch(Exception e){}		
	}//end of saveContacts

	//getters and setters
	public ContactsData getData() {
		return data;
	}


	public void setData(ContactsData data) {
		this.data = data;
	}
}//end of class
