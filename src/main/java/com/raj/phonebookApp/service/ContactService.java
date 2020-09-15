package com.raj.phonebookApp.service;

import java.util.List;

import com.raj.phonebookApp.dto.ContactDto;

public interface ContactService {
	
	public boolean saveContact(ContactDto dto);
	public List<ContactDto> getAllContacts();
	public ContactDto getContactById(Integer id);
	public boolean updateContact(ContactDto dto);
	public boolean deleteContact(Integer id);

}
