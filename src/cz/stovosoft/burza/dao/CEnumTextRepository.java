package cz.stovosoft.burza.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cz.stovosoft.burza.entity.CEnumText;
import cz.stovosoft.burza.entity.CEnumTextId;

@Repository
public interface CEnumTextRepository extends CrudRepository<CEnumText, CEnumTextId> {

	CEnumText findByIdAndLanguageISOCode(long id, String languageISOCode);
}
