package com.raj.phonebookApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.raj.phonebookApp.dto.ContactDto;
import com.raj.phonebookApp.service.ContactService;

@Controller
public class ViewContactController {

	private ContactService contactService;

	public ViewContactController(ContactService theContactService) {

		contactService = theContactService;

	}

	@RequestMapping("/addContact")
	public String handelAddContactHyperlink(Model model) {
		model.addAttribute("contact", new ContactDto());
		return "NewContact";
	}

//	@GetMapping("/editContact/{id}")
//	public String editContact(@PathVariable("id") Integer cid,Model model) {
//				
//		ContactDto dto = contactService.getContactById(cid);
//		
//		//attributes.addFlashAttribute("contact1",dto);
//		model.addAttribute("contact", dto);
//		
//		return "/NewContact";
//	}

	@GetMapping("/editContact")
	public String editContact(@RequestParam("cid") Integer cid, Model model) {

		ContactDto dto = contactService.getContactById(cid);

		// attributes.addFlashAttribute("contact1",dto);
		model.addAttribute("contact", dto);

		return "NewContact";
	}

	@GetMapping("/deleteContact")
	public String deleteContact(@RequestParam("cid") Integer cid, RedirectAttributes attributes) {

		String name = contactService.getContactById(cid).getContactName();
		if (contactService.deleteContact(cid))
			attributes.addFlashAttribute("DeleteSuccessfull", name + " Contact Successfully Deleted");
		else
			attributes.addFlashAttribute("DeleteFailed", "Unable To Delete " + name);

		return "redirect:/ViewAllContacts";
	}

}
