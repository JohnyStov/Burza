package cz.stovosoft.burza.beans;

import java.io.Serializable;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Component;

import cz.stovosoft.burza.constants.ApplicationConst;
import cz.stovosoft.burza.dto.OrdersDTO;

@Component
public class SendEmail implements Serializable {

	private static final long serialVersionUID = ApplicationConst.APPLICATION_SERIAL_VERSION_UID;

	private static final String FROM_EMAIL = "robot@burzaation.eu";
	private static final String FROM_NAME = "burzaation Web Site";

	private static final String authuser = "johny.stov@gmail.com";
	private static final String authpwd = "qvnzvmaxdwxeqbxt";

	private String formatOperatorText(OrdersDTO orderDto) {
		StringBuilder sb = new StringBuilder();
		sb.append("Objednávka č. " + orderDto.getId() + "\n");
		sb.append("Služba: " + orderDto.getService().getCode() + "(" + orderDto.getService().getDesc() + ")\n");
		sb.append("Zákazník: " + orderDto.getName() + " " + orderDto.getSurname() + "\n");
		sb.append("Kontakt: " + orderDto.getPhoneNumber() + " ; " + orderDto.getEmail() + "\n");
		sb.append("Datum: " + orderDto.getPickupDate() + "\n");
		sb.append("Počet pasažérů: " + orderDto.getPassengerCount() + "\n");
		if (orderDto.getGuide() != null) {
			sb.append("Průvodce: " + (orderDto.getGuide() ? "Ano" : "Ne") + "\n");
		}
		if (orderDto.getFlightNumber() != null) {
			sb.append("Číslo letu: " + orderDto.getFlightNumber() + "\n");
		}
		sb.append("Poznámka: " + orderDto.getNote() + "\n");
		return sb.toString();
	}

	private String formatCustomerText(OrdersDTO orderDto) {
		StringBuilder sb = new StringBuilder();
		sb.append("Dobrý den, \n");
		sb.append("děkujeme za rezervaci služeb. Následuje rekapitulace zadaných údajů. \n");
		sb.append("Objednávka č. " + orderDto.getId() + "\n");
		sb.append("Služba: " + orderDto.getService().getDesc() + "\n");
		sb.append("Zákazník: " + orderDto.getName() + " " + orderDto.getSurname() + "\n");
		sb.append("Kontakt: " + orderDto.getPhoneNumber() + " ; " + orderDto.getEmail() + "\n");
		sb.append("Datum: " + orderDto.getPickupDate() + "\n");
		sb.append("Počet pasažérů: " + orderDto.getPassengerCount() + "\n");
		if (orderDto.getGuide() != null) {
			sb.append("Průvodce: " + (orderDto.getGuide() ? "Ano" : "Ne") + "\n");
		}
		if (orderDto.getFlightNumber() != null) {
			sb.append("Číslo letu: " + orderDto.getFlightNumber() + "\n");
		}
		sb.append("Poznámka: " + orderDto.getNote() + "\n");

		sb.append("\nPokud je některý z údajů špatně nebo se změní, odpovězte na tento email. \n");
		sb.append("Zálohu 10€ prosíme poslat na 123457/0100, vs: " + orderDto.getId() + ". BIC (SWIFT):KOMBCZPP, IBAN: CZ70 0100 0000 0000 0012 3457.\n");
		sb.append("\nTěšíme se na Vás,\ns pozdravem\ntým burza, s r.o.");

		return sb.toString();
	}

	public void send(OrdersDTO orderDto) throws EmailException {
		prepareEmail("Rezervace č. " + orderDto.getId(), orderDto.getEmail(),  formatCustomerText(orderDto), FROM_EMAIL, FROM_NAME); // TODO: shall be true + lang location
		prepareEmail("Objednávka č. " + orderDto.getId(),FROM_EMAIL, formatOperatorText(orderDto),FROM_EMAIL, FROM_NAME);
	}
	
	private void prepareEmail(String subject, String email, String text, String fromEmail, String fromName) throws EmailException {
		Email emailEntity = new SimpleEmail();

		emailEntity.setSmtpPort(587);
		emailEntity.setAuthenticator(new DefaultAuthenticator(authuser, authpwd));
		emailEntity.setDebug(true);
		emailEntity.setHostName("smtp.gmail.com");
		emailEntity.getMailSession().getProperties().put("mail.smtps.auth", "true");
		emailEntity.getMailSession().getProperties().put("mail.debug", "true");
		emailEntity.getMailSession().getProperties().put("mail.smtps.port", "587");
		emailEntity.getMailSession().getProperties().put("mail.smtps.socketFactory.port", "587");
		emailEntity.getMailSession().getProperties().put("mail.smtps.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		emailEntity.getMailSession().getProperties().put("mail.smtps.socketFactory.fallback", "false");
		emailEntity.getMailSession().getProperties().put("mail.smtp.starttls.enable", "true");
		emailEntity.setFrom(fromEmail, fromName);
		emailEntity.setSubject(subject);
		emailEntity.setMsg(text);
		emailEntity.addTo(email, email);

		// email.setStartTLSRequired(false);
		emailEntity.send();
	}

	public void send(String email, String subject, String text) throws EmailException {
		prepareEmail("Dotaz - " + subject, FROM_EMAIL, text, email, email); // TODO: shall be true + lang location
	}
}