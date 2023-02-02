package com.microservices.springkafkaproducer.repo;

import com.microservices.springkafkaproducer.bean.User;
import org.springframework.data.repository.CrudRepository;

public interface UserCRUD extends CrudRepository<User,Integer> {
}
