package com.example.mycode.repository;

import com.example.mycode.model.CartItem;
import org.springframework.data.repository.CrudRepository;

public interface CartItemRepository extends CrudRepository<CartItem, Long> {
}
