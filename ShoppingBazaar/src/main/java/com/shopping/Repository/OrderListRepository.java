package com.shopping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping.model.OrderList;


@Repository
public interface OrderListRepository extends JpaRepository<OrderList, Integer>{

}
