package com.microservices.springkafkaproducer.repo;

import com.microservices.springkafkaproducer.bean.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

public interface OrderCRUD extends MongoRepository<Order,Integer> {
}
