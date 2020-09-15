package com.raj.phonebookApp.persistanceLayer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="contact_dtls")
public class ContactDtlsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="contact_id")
	private Integer contactId;
	@Column(name="contact_name")
	private String contactName;
	@Column(name="contact_email")
	private String contactEmail;
	@Column(name="contact_num")
	private String contactNum;
	
	

	


}
