package cz.stovosoft.burza.dto;

import java.io.Serializable;
import java.util.Date;

import cz.stovosoft.burza.constants.ApplicationConst;
import cz.stovosoft.burza.entity.Orders;

/**
 * This entity is enumeration table of the credit proposal file supported languages.
 * 
 * @author Jan Stovicek
 */
public class OrdersDTO implements Serializable {

	/** Default serial version id. */
	private static final long serialVersionUID = ApplicationConst.APPLICATION_SERIAL_VERSION_UID;

	private Long id;
	private CServiceTypeDTO service;
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

	public OrdersDTO(Long id, CServiceTypeDTO service, int passengerCount, Date pickupDate, String name, String surname, String email, Long phoneNumber,
			String note, Boolean send) {
		this.id = id;
		this.service = service;
		this.passengerCount = passengerCount;
		this.pickupDate = pickupDate;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.note = note;
		this.setSend(send);
	}

	public Orders toEntity() {
		Orders result = new Orders();
		result.setEmail(getEmail());
		result.setId(getId());
		result.setName(getName());
		result.setNote(getNote());
		result.setPassengerCount(getPassengerCount());
		result.setPhoneNumber(getPhoneNumber());
		result.setPickupDate(getPickupDate());
		result.setService(getService().toEntity());
		result.setSurname(getSurname());
		result.setSend(getSend());
		return result;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CServiceTypeDTO getService() {
		return service;
	}

	public void setService(CServiceTypeDTO service) {
		this.service = service;
	}

	public int getPassengerCount() {
		return passengerCount;
	}

	public void setPassengerCount(int passengerCount) {
		this.passengerCount = passengerCount;
	}

	public Date getPickupDate() {
		return pickupDate;
	}

	public void setPickupDate(Date pickupDate) {
		this.pickupDate = pickupDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Boolean getSend() {
		return send;
	}

	public void setSend(Boolean send) {
		this.send = send;
	}

	public Boolean getGuide() {
		return guide;
	}

	public void setGuide(Boolean guide) {
		this.guide = guide;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

}