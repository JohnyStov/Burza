package cz.stovosoft.burza.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

import cz.stovosoft.burza.constants.ApplicationConst;

/**
 * This entity is enumeration table of the credit proposal file supported languages.
 * 
 * @author Jan Stovicek
 */
@Entity
@Table(name = "ORDERS")
public class Orders implements Serializable {

	/** Default serial version id. */
	private static final long serialVersionUID = ApplicationConst.APPLICATION_SERIAL_VERSION_UID;

	private Long id;
	private CServiceType service;
	private int passengerCount;
	private Date pickupDate;
	private String name;
	private String surname;
	private String email;
	private Long phoneNumber;
	private String note;
	private Boolean send;
	private Boolean guide;
	private String flightNumber;

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, precision = 15, scale = 0)
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	@JoinColumn(name = "ID_C_SERVICE_TYPE")
	public CServiceType getService() {
		return service;
	}

	public void setService(CServiceType service) {
		this.service = service;
	}

	@Column(name = "PASSENGERS")
	public int getPassengerCount() {
		return passengerCount;
	}

	public void setPassengerCount(int passengerCount) {
		this.passengerCount = passengerCount;
	}

	@Column(name = "PICKUP_DATE")
	@Temporal(TemporalType.DATE)
	public Date getPickupDate() {
		return pickupDate;
	}

	public void setPickupDate(Date pickupDate) {
		this.pickupDate = pickupDate;
	}

	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "SURNAME")
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Column(name = "EMAIL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "PHONENUMBER")
	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "NOTE")
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Type(type="yes_no")
	@Column(name = "SEND")
	public Boolean getSend() {
		return send;
	}

	public void setSend(Boolean send) {
		this.send = send;
	}

	@Type(type="yes_no")
	@Column(name = "GUIDE")
	public Boolean getGuide() {
		return guide;
	}

	public void setGuide(Boolean guide) {
		this.guide = guide;
	}

	@Column(name = "FLIGHT_NUMBER")
	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
}