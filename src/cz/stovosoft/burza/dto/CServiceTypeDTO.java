package cz.stovosoft.burza.dto;

import java.io.Serializable;

import cz.stovosoft.burza.constants.ApplicationConst;
import cz.stovosoft.burza.entity.CServiceType;

/**
 * This entity is enumeration table of the credit proposal file supported languages.
 * 
 * @author Jan Stovicek
 */

public class CServiceTypeDTO implements Serializable {

	/** Default serial version id. */
	private static final long serialVersionUID = ApplicationConst.APPLICATION_SERIAL_VERSION_UID;

	/** primary key */
	private Long id;
	/** service type name */
	private String code;
	/** language dependent description - displayed on a front-end. */
	private String desc;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public CServiceType toEntity() {
		CServiceType result = new CServiceType();
		result.setCode(getCode());
		result.setId(getId());
		return result;
	}

}