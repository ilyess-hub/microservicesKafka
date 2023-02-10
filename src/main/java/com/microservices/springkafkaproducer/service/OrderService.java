package com.microservices.springkafkaproducer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservices.springkafkaproducer.bean.Order;
import com.microservices.springkafkaproducer.repo.OrderCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderCRUD orderCRUD;

    @Value("${order.topic.name}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    ObjectMapper om=new ObjectMapper();

    public Order createOrder(Order order) {
        order =orderCRUD.save(order);
        order.setStatus("CREATED");
        // after saving order lets release msg for payment service
        String message= null;
        try {
            message = om.writeValueAsString(order);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        kafkaTemplate.send(topicName,message);
        return order;
    }



    public List<Order> getAllOrders() {
        List<Order> orders= (List<Order>) orderCRUD.findAll();
        return orders;
    }


}


