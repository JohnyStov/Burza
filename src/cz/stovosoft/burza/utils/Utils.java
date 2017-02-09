package cz.stovosoft.burza.utils;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;

public final class Utils {
	
	public static String getResourceBundleString(String resourceBundleKey) throws MissingResourceException {
		FacesContext ctx = FacesContext.getCurrentInstance();
		Locale locale = ctx.getViewRoot().getLocale();
		ResourceBundle rb = ResourceBundle.getBundle("cz.stovosoft.burza.i18n.messages", locale);
		return rb.getString(resourceBundleKey);
	}
}
