package cz.stovosoft.burza.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import cz.stovosoft.burza.constants.ApplicationConst;

/**
 * CEnumText entity ID. Identification of the localized texts of the localized
 * enumeration tables.
 * 
 * @author Jan Stovicek
 */
@Embeddable
public class CEnumTextId implements Serializable {

	/** Default serial version ID. */
	private static final long serialVersionUID = ApplicationConst.APPLICATION_SERIAL_VERSION_UID;

	/** Id of the text. */
	private long id;

	/** ID of the language */
	private long idCLanguage;

	/**
	 * @return the id
	 */
	@Column(name = "ID", nullable = false, precision = 15, scale = 0)
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the idCLanguage
	 */
	@Column(name = "ID_C_LANGUAGE", nullable = false, precision = 15, scale = 0)
	public long getIdCLanguage() {
		return idCLanguage;
	}

	/**
	 * @param idCLanguage
	 *            the idCLanguage to set
	 */
	public void setIdCLanguage(long idCLanguage) {
		this.idCLanguage = idCLanguage;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
}