package com.example.mycode.controller;

import com.example.mycode.security.UserPrincipal;
import com.example.mycode.service.CartService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {

    private CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/{productId}")
    public String saveItem(@RequestParam(value = "quantity") Long quantity,
                           @PathVariable(value = "productId") Long productId,
                           @AuthenticationPrincipal UserPrincipal userPrincipal) {
        return cartService.saveItem(quantity, productId, userPrincipal.getEmail());
    }

}
