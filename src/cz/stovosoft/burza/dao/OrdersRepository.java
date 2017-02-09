package cz.stovosoft.burza.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cz.stovosoft.burza.entity.Orders;

@Repository
public interface OrdersRepository extends CrudRepository<Orders,Integer>{}
