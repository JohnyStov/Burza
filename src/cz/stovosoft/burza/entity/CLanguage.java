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
@Table(name = "C_LANGUAGE")
public class CLanguage implements Serializable {

	/** Default serial version id. */
	private static final long serialVersionUID = ApplicationConst.APPLICATION_SERIAL_VERSION_UID;

	/** primary key */
	private Long id;
	/** Language name - displayed on a front-end. */
	private String name;
	/** Language code - displayed on a front-end. */
	private String code;
	/** ISO code of the language. */
	private String langISOCode;

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

	/**
	 * @return the langName
	 */
	@Column(name = "LANG_NAME", length = 50)
	public String getName() {
		return name;
	}

	/**
	 * @param langName
	 *            the langName to set
	 */
	public void setName(String langName) {
		this.name = langName;
	}

	/**
	 * @return the langCode
	 */
	@Column(name = "LANG_CODE", unique = true, length = 10)
	public String getCode() {
		return code;
	}

	/**
	 * @param langCode
	 *            the langCode to set
	 */
	public void setCode(String langCode) {
		this.code = langCode;
	}

	/**
	 * @return the langISOCode
	 */
	@Column(name = "LANG_ISO_CODE", length = 10)
	public String getLangISOCode() {
		return langISOCode;
	}

	/**
	 * @param langISOCode
	 *            the langISOCode to set
	 */
	public void setLangISOCode(String langISOCode) {
		this.langISOCode = langISOCode;
	}
}