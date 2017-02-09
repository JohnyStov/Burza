package cz.stovosoft.burza.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cz.stovosoft.burza.constants.ApplicationConst;

/**
 * This entity is enumeration table of the credit proposal file supported languages.
 * 
 * @author Jan Stovicek
 */
@Entity
@Table(name = "C_SERVICE_TYPE")
public class CServiceType implements Serializable {

	/** Default serial version id. */
	private static final long serialVersionUID = ApplicationConst.APPLICATION_SERIAL_VERSION_UID;

	/** primary key */
	private Long id;
	/** Language name - displayed on a front-end. */
	private String code;
	/** Language code - displayed on a front-end. */
	private Long idCEnumCode;

	/**
	 * @return the id
	 */
	@Id
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

	@Column(name = "CODE", unique = true, length = 10)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "ID_C_ENUM_TEXT", nullable = false, precision = 15, scale = 0)
	public Long getIdCEnumCode() {
		return idCEnumCode;
	}

	public void setIdCEnumCode(Long idCEnumCode) {
		this.idCEnumCode = idCEnumCode;
	}
}