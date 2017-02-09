package cz.stovosoft.burza.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cz.stovosoft.burza.entity.CLanguage;

@Repository
public interface CLanguageRepository extends CrudRepository<CLanguage, Integer> {
	
	CLanguage findByCode(String code);

}
