package cz.stovosoft.burza.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Component;

import cz.stovosoft.burza.constants.ApplicationConst;

@ManagedBean
@SessionScoped
@Component
public class ConfigurationService implements Serializable {

	private static final long serialVersionUID = ApplicationConst.APPLICATION_SERIAL_VERSION_UID;

	private int maxPassengerCount = 50;

	public int getMaxPassengerCount() {
		return maxPassengerCount;
	}

	public void setMaxPassengerCount(int maxPassengerCount) {
		this.maxPassengerCount = maxPassengerCount;
	}
}