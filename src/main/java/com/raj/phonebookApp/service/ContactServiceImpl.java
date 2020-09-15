package com.raj.phonebookApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.raj.phonebookApp.dto.ContactDto;
import com.raj.phonebookApp.persistanceLayer.ContactDtlsEntity;
import com.raj.phonebookApp.persistanceLayer.ContactDtlsRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDtlsRepository contactDtlsRepo;

	/*
	 * This method is used to save Contact Details to database
	 */

	@Override
	public boolean saveContact(ContactDto dto) {
		
		ContactDtlsEntity entity = new ContactDtlsEntity();
		BeanUtils.copyProperties(dto, entity);
		contactDtlsRepo.save(entity);
		ContactDtlsEntity savedEntity = contactDtlsRepo.save(entity);

		return savedEntity.getContactId() != null;
	}

	@Override
	public List<ContactDto> getAllContacts() {

		List<ContactDtlsEntity> entities = contactDtlsRepo.findAll();

		List<ContactDto> dtos = new ArrayList<>();

		for (ContactDtlsEntity entity : entities) {
			ContactDto tempDto = new ContactDto();
			BeanUtils.copyProperties(entity, tempDto);
			dtos.add(tempDto);
		}
		return dtos;
	}

	@Override
	public ContactDto getContactById(Integer id) {

		//ContactDtlsEntity entity = contactDtlsRepo.getOne(id);
		
		Optional<ContactDtlsEntity> optional = contactDtlsRepo.findById(id);
		ContactDtlsEntity entity = null;
		if(optional.isPresent())
		{
			entity = optional.get();
		}
		ContactDto dto = new ContactDto();
		
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	@Override
	public boolean updateContact(ContactDto dto) {

		ContactDtlsEntity entity = new ContactDtlsEntity();
		BeanUtils.copyProperties(dto, entity);

		//System.out.println("DTO in update is " + dto);

		contactDtlsRepo.save(entity);
		return true;
	}

	@Override
	public boolean deleteContact(Integer id) {

		contactDtlsRepo.deleteById(id);

		return contactDtlsRepo.getOne(id) != null;
	}

}
