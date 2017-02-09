package cz.stovosoft.burza.entity;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import cz.stovosoft.burza.constants.ApplicationConst;


/**
 * CEnumText entity. Holds localized texts of the localized enumeration tables.
 * 
 * @author Jan Stovicek
 */
@Entity
@Table(name = "C_ENUM_TEXT")
@NamedQueries({
	@NamedQuery(
			name = CEnumText.FIND_BY_ID_AND_LANGUAGE_ISO_CODE, 
			query = "SELECT c FROM CEnumText c where c.id.id= ?1 and c.language.langISOCode= ?2")
})
public class CEnumText implements Serializable {
	/** Default serial version ID . */
	private static final long serialVersionUID = ApplicationConst.APPLICATION_SERIAL_VERSION_UID;

	/** Identification of the finder which returns all localized texts for the given language code. */
	public static final String FIND_BY_ID_AND_LANGUAGE_ISO_CODE = "CEnumText.findByIdAndLanguageISOCode";

	/** New Id generator native query. */
	public static final String GENERATE_NEW_ID = "SELECT seq_text.NEXTVAL FROM dual";

	/** ID of the localized enumeration text. */
	private CEnumTextId id;

	/** Language of the localized enumeration text. */
	private CLanguage language;

	/** Localized text itself. */
	private String value;

	/**
	 * @return the id
	 */
	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "ID", nullable = false, precision = 15, scale = 0)),
			@AttributeOverride(name = "idCLanguage", column = @Column(name = "ID_C_LANGUAGE", nullable = false, precision = 15, scale = 0)) })
	public CEnumTextId getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(CEnumTextId id) {
		this.id = id;
	}

	/**
	 * @return the language
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_C_LANGUAGE", nullable = false, insertable = false, updatable = false)
	public CLanguage getLanguage() {
		return language;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(CLanguage language) {
		this.language = language;
	}

	/**
	 * @return the value
	 */
	@Column(name = "VALUE", nullable = false)
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

}
