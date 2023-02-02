package com.microservices.springkafkaproducer.repo;

import com.microservices.springkafkaproducer.bean.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderCRUD extends CrudRepository<Order,Integer> {
}
