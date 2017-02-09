package cz.stovosoft.burza.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cz.stovosoft.burza.constants.ApplicationConst;
import cz.stovosoft.burza.dao.CEnumTextRepository;
import cz.stovosoft.burza.dao.CLanguageRepository;
import cz.stovosoft.burza.dao.CServiceTypeRepository;
import cz.stovosoft.burza.dao.OrdersRepository;
import cz.stovosoft.burza.dto.CServiceTypeDTO;
import cz.stovosoft.burza.dto.OrdersDTO;
import cz.stovosoft.burza.entity.CEnumText;
import cz.stovosoft.burza.entity.CLanguage;
import cz.stovosoft.burza.entity.CServiceType;
import cz.stovosoft.burza.entity.Orders;

@Component
public class CodetableService implements Serializable {

	private static final long serialVersionUID = ApplicationConst.APPLICATION_SERIAL_VERSION_UID;

	private List<CLanguage> languages = new ArrayList<CLanguage>();
	private List<CServiceTypeDTO> serviceTypeDTOs = null;

	@Autowired
	private CLanguageRepository langService;

	@Autowired
	private CServiceTypeRepository serviceTypeDao;

	@Autowired
	private CEnumTextRepository enumTextDao;

	@Autowired
	private OrdersRepository ordersDao;

	public List<CLanguage> getLanguages() {
		this.languages = new ArrayList<CLanguage>();
		for (CLanguage i : this.langService.findAll()) {
			this.languages.add(i);
		}
		return languages;
	}

	public CLanguage getLanguage(String code) {
		return this.langService.findByCode(code);
	}

	public List<CServiceTypeDTO> getServiceTypes(CLanguage language) {
		this.serviceTypeDTOs = new ArrayList<CServiceTypeDTO>();
		for (CServiceType i : this.serviceTypeDao.findAll()) {
			CServiceTypeDTO dto = new CServiceTypeDTO();
			dto.setCode(i.getCode());
			dto.setId(i.getId());
			CEnumText enumText = this.enumTextDao.findByIdAndLanguageISOCode(i.getIdCEnumCode(), language.getLangISOCode());
			dto.setDesc(enumText.getValue());
			this.serviceTypeDTOs.add(dto);
		}
		return this.serviceTypeDTOs;
	}

	public CServiceTypeDTO getServiceType(CLanguage language, String code) {
		if (code == null || code.length() == 0) {
			return null;
		}
		if (this.serviceTypeDTOs == null || this.serviceTypeDTOs.size() == 0) {
			getServiceTypes(language);
		}

		for (CServiceTypeDTO i : this.serviceTypeDTOs) {
			if (code.equals(i.getCode())) {
				return i;
			}
		}
		return null;
	}

	public void setEmployees(List<CLanguage> languages) {
		this.languages = languages;
	}

	public Long saveOrder(OrdersDTO orderDto) {
		Orders order = orderDto.toEntity();
		order = ordersDao.save(order);
		if (order != null) {
			orderDto.setId(order.getId());
			return order.getId();
		} else {
			return null;
		}
	}
}
