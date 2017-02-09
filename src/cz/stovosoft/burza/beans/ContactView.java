package cz.stovosoft.burza.beans;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cz.stovosoft.burza.constants.ApplicationConst;
import cz.stovosoft.burza.dto.PropertiesDTO;

@ManagedBean
@SessionScoped
@Component
public class ContactView implements Serializable {

	private static final long serialVersionUID = ApplicationConst.APPLICATION_SERIAL_VERSION_UID;

	@Autowired
	private SendEmail emailService;

	private String email;
	private String subject;
	private String text;

	private List<PropertiesDTO> props;

	public ContactView() {
		props = new LinkedList<PropertiesDTO>();

		PropertiesDTO temp = new PropertiesDTO();
		temp.setId((long) (props.size()+1));
		temp.setName("name");
		temp.setTitle("reservation.name");
		temp.setValue(null);
		temp.setValueType("String");

		props.add(temp);

		temp = new PropertiesDTO();
		temp.setId((long) (props.size()+1));
		temp.setName("surname");
		temp.setTitle("reservation.surname");
		temp.setValue(null);
		temp.setValueType("String");

		props.add(temp);

		temp = new PropertiesDTO();
		temp.setId((long) (props.size()+1));
		temp.setName("pickupDate");
		temp.setTitle("reservation.pickupDate");
		temp.setValue(null);
		temp.setValueType("Date");

		props.add(temp);
	}

	public void onSubmit() {
		try {
			emailService.send(email, subject, text);
		} catch (EmailException e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error while sending email.", "Error while sending email."));
			return;
		}
		setSubject(null);
		setEmail(null);
		setText(null);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Request sent.", "Request sent."));
	}

	public void onSubmit2() {
		for (PropertiesDTO i : props) {
			System.out.println(i.toString());
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<PropertiesDTO> getProps() {
		return props;
	}

	public void setProps(List<PropertiesDTO> props) {
		this.props = props;
	}

}