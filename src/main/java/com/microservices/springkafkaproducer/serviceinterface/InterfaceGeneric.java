package com.microservices.springkafkaproducer.serviceinterface;

import com.microservices.springkafkaproducer.bean.Order;

import java.util.List;

public interface InterfaceGeneric<T> {

    T create(T data);
    List<T> getAll();
    T findById(Integer id);
    T updateYourEntity(T data);
    boolean delete(Integer id);

}
