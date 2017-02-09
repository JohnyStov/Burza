package cz.stovosoft.burza.dto;

import java.io.Serializable;

import cz.stovosoft.burza.constants.ApplicationConst;

/**
 * This entity is enumeration table of the credit proposal file supported languages.
 * 
 * @author Jan Stovicek
 */
public class PropertiesDTO implements Serializable {

	/** Default serial version id. */
	private static final long serialVersionUID = ApplicationConst.APPLICATION_SERIAL_VERSION_UID;

	private Long id;
	private String name;
	private String title;
	private String valueType;
	private Object value;
	
	@Override
	public String toString() {
		StringBuffer temp = new StringBuffer("PropertiesDTO[");
		temp.append(id).append(", ");
		temp.append(name).append(", ");
		temp.append(title).append(", ");
		temp.append(valueType).append(", ");
		temp.append(value).append("]");
		return temp.toString();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getValueType() {
		return valueType;
	}
	public void setValueType(String valueType) {
		this.valueType = valueType;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}


}