package cz.stovosoft.burza.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cz.stovosoft.burza.entity.CServiceType;

@Repository
public interface CServiceTypeRepository extends CrudRepository<CServiceType,Integer>{}
