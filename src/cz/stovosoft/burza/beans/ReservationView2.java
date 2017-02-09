package cz.stovosoft.burza.beans;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.commons.mail.EmailException;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cz.stovosoft.burza.constants.ApplicationConst;
import cz.stovosoft.burza.dto.CServiceTypeDTO;
import cz.stovosoft.burza.dto.OrdersDTO;
import cz.stovosoft.burza.entity.CLanguage;
import cz.stovosoft.burza.services.ICodeTableService;

@ManagedBean
@SessionScoped
@Component
public class ReservationView2 implements ICodeTableService {

	private static final long serialVersionUID = ApplicationConst.APPLICATION_SERIAL_VERSION_UID;

	@Autowired
	CodetableService codetableService;

	@Autowired
	IdiomaBean idiomaBean;

	@Autowired
	private SendEmail emailService;

	private Map<String, String> services = new HashMap<String, String>();

	private String service = "AIRPORT";
	private int passengerCount;
	private Date now;
	private Date pickupDate;
	private String name;
	private String surname;
	private String email;
	private Long phoneNumber;
	private String note;
	private boolean guide;
	private String flightNumber;
	private boolean orderCompleted;

	@PostConstruct
	private void init() {
		regenerateValues();
	}

	public void onSubmit() {
		CLanguage cLanguage = codetableService.getLanguage(idiomaBean.getCurrentLanguage());
		CServiceTypeDTO serviceType = codetableService.getServiceType(cLanguage, service);
		OrdersDTO orderDto = new OrdersDTO((long) 0, serviceType, passengerCount, pickupDate, name, surname, email, phoneNumber, note, false);
		orderDto.setFlightNumber(flightNumber);
		if ("TRIP".equals(service)) {
			orderDto.setGuide(guide);
		}
		codetableService.saveOrder(orderDto);
		try {
			emailService.send(orderDto);
			setOrderCompleted(true);
			orderDto.setSend(Boolean.TRUE);
			codetableService.saveOrder(orderDto);
		} catch (EmailException e) {
			setOrderCompleted(false);
		}
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('dlg1').show();");
	}

	public void regenerateValues() {
		String lang = idiomaBean.getCurrentLanguage();
		CLanguage cLanguage = codetableService.getLanguage(lang);
		List<CServiceTypeDTO> serviceDTOs = codetableService.getServiceTypes(cLanguage);

		services.clear();
		for (CServiceTypeDTO serv : serviceDTOs) {
			services.put(serv.getDesc(), serv.getCode());
		}
	}

	public CodetableService getCodetableService() {
		return codetableService;
	}

	public void setCodetableService(CodetableService codetableService) {
		this.codetableService = codetableService;
	}

	public Map<String, String> getServices() {
		return services;
	}

	public void setServices(Map<String, String> services) {
		this.services = services;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
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

	public boolean getGuide() {
		return guide;
	}

	public void setGuide(boolean guide) {
		this.guide = guide;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public Date getNow() {
		return new Date();
	}

	public void setNow(Date now) {
		this.now = now;
	}

	public boolean isOrderCompleted() {
		return orderCompleted;
	}

	public void setOrderCompleted(boolean orderCompleted) {
		this.orderCompleted = orderCompleted;
	}

}