package com.contact.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.contact.entity.Contact;

@Service
public class ContactServiceImpl implements ContactService {
	// fake list of contacts
	List<Contact> list=List.of(
			new Contact(1L,"vikram@gmail.com","Vikram",111L),
			new Contact(2L,"vikram@gmail.com","Mayank",111L),
			new Contact(3L,"vikram@gmail.com","Abhi",333L)
	);

	@Override
	public List<Contact> getContactsOfUser(Long userId) {
		return list.stream().filter(contact -> contact.getUserId().equals(userId)).collect(Collectors.toList());
	}

}
