package com.sudarshan.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@NamedQueries({
@NamedQuery(name="Contact.showContacts",
query="SELECT c FROM Contact c WHERE LOWER(c.firstName) LIKE LOWER(:searchTerm) OR LOWER(c.lastName) LIKE LOWER(:searchTerm) ORDER BY c.lastName ASC, c.firstName ASC"
)
})
@Table(name="contacts")
public class Contact {

	public static final int MAX_LENGTH_EMAIL_ADDRESS = 100;
	public static final int MAX_LENGTH_FIRST_NAME = 50;
	public static final int MAX_LENGTH_LAST_NAME = 100;
	public static final int MAX_LENGTH_PHONE_NUMBER = 30;

	@Id
	@SequenceGenerator(name="mySeq",sequenceName="contact_seq")
	@GeneratedValue(generator="mySeq",strategy=GenerationType.SEQUENCE)
	private int id;

	private Address address;

	@Column(name = "email_address", length = MAX_LENGTH_EMAIL_ADDRESS)
	private String emailAddress;

	@Column(name = "first_name", nullable=false, length = MAX_LENGTH_FIRST_NAME)
	private String firstName;

	@Column(name = "last_name", nullable=false, length = MAX_LENGTH_LAST_NAME)
	private String lastName;

	@Column(name = "phone_number", length = MAX_LENGTH_PHONE_NUMBER)
	private String phoneNumber;

	@Version
	private long version;

	public Contact() {

	}

	public int getId() {
		return id;
	}

	public Address getAddress() {
		return address;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public long getVersion() {
		return version;
	}

	public void update(final String firstName, final String lastName, final String emailAddress, final String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
	}

	public void updateAddress(final String streetAddress, final String postCode, final String postOffice, final String state, final String country) {
		if (address == null) {
			address = new Address();
		}

		address.update(streetAddress, postCode, postOffice, state, country);
	}

	public static Builder getBuilder(String firstName, String lastName) {
		return new Builder(firstName, lastName);
	}

	public static class Builder {

		private Contact built;

		public Builder (String firstName, String lastName) {
			built = new Contact();
			built.firstName = firstName;
			built.lastName = lastName;
		}

		public Builder address(String streetAddress, String postCode, String postOffice, String state, String county) {
			Address address = Address.getBuilder(streetAddress, postCode, postOffice)
					.state(state)
					.country(county)
					.build();
			built.address = address;
			return this;
		}

		public Builder emailAddress(String emailAddress) {
			built.emailAddress = emailAddress;
			return this;
		}

		public Builder phoneNumber(String phoneNumber) {
			built.phoneNumber = phoneNumber;
			return this;
		}

		public Contact build() {
			return built;
		}
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
