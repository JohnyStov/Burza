package cz.stovosoft.burza.beans;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cz.stovosoft.burza.constants.ApplicationConst;
import cz.stovosoft.burza.services.ICodeTableService;

@ManagedBean
@SessionScoped
@Component
public class IdiomaBean implements Serializable {

	private static final long serialVersionUID = ApplicationConst.APPLICATION_SERIAL_VERSION_UID;

	@Autowired
	List<ICodeTableService> codetableServices;

	private Locale locale;

	private String currentLanguage;

	private static Map<String, String> availableLanguages;

	static {
		availableLanguages = new LinkedHashMap<String, String>();
		availableLanguages.put("Čeština", "cs");
		availableLanguages.put("English", "en");
		availableLanguages.put("Italiano", "it");
	}

	@PostConstruct
	public void init() {
		setLanguage(getCurrentLanguage());
	}

	public Map<String, String> getAvailableLanguages() {
		return availableLanguages;
	}

	public Locale getLocale() {
		return locale;
	}

	public String getLanguage() {
		return locale.getLanguage();
	}

	public void setLanguage(String language) {
		setCurrentLanguage(language);
		locale = new Locale(language);
		for (ICodeTableService temp : codetableServices) {
			temp.regenerateValues();
		}
	}

	public String getCurrentLanguage() {
		if (currentLanguage == null || "".equals(currentLanguage)) {
			setCurrentLanguage("en");
		}
		return currentLanguage;
	}

	public void setCurrentLanguage(String currentLanguage) {
		this.currentLanguage = currentLanguage;
	}

}