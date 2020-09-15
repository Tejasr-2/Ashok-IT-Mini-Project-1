package com.raj.phonebookApp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.raj.phonebookApp.dto.ContactDto;
import com.raj.phonebookApp.service.ContactService;

@Controller
public class ContactInfoController {

	private ContactService contactService;

	public ContactInfoController(ContactService theContactService) {

		contactService = theContactService;

	}

	@GetMapping(value = "/NewContact")

	public String newContactForm(Model model) {
		model.addAttribute("contact", new ContactDto());
		return "NewContact";

	}

	@PostMapping("/saveContact")
	public String handleSubmitBtn(@ModelAttribute("contact") ContactDto dto, RedirectAttributes attributes) {

		boolean isSaved = contactService.saveContact(dto);

		if (isSaved) {
			if (dto.getContactId() != null) {
				attributes.addFlashAttribute("contactSaved", "Contact Updated Succefully");
			} else {
				attributes.addFlashAttribute("contactSaved", "Contact Saved Succefully");
			}

		} else
			attributes.addFlashAttribute("contactSaveFail", "Could not save Contact");

		return "redirect:/NewContact";
	}

//
//	@GetMapping("/contactAdded")
//	public String contactAdded(Model model) {
//
//		model.addAttribute("contact", new ContactDto());
//
//		return "NewContact";
//	}

	@GetMapping("/ViewAllContacts")
	public String handleViewContactHyperLink(Model model) {

		List<ContactDto> dtos = contactService.getAllContacts();

		model.addAttribute("allcontacts", dtos);

		return "ViewAllContacts";
	}

}
