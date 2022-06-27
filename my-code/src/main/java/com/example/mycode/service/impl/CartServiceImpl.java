package com.example.mycode.service.impl;

import com.example.mycode.model.Cart;
import com.example.mycode.model.CartItem;
import com.example.mycode.model.Product;
import com.example.mycode.model.User;
import com.example.mycode.repository.CartItemRepository;
import com.example.mycode.service.CartService;
import com.example.mycode.service.ProductService;
import com.example.mycode.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    private UserService userService;
    private ProductService productService;
    private CartItemRepository cartItemRepository;

    public CartServiceImpl(UserService userService, ProductService productService, CartItemRepository cartItemRepository) {
        this.userService = userService;
        this.productService = productService;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public String saveItem(Long quantity, Long productId, String email) {
        User user = userService.findByEmail(email);
        Cart cart = user.getCart();
        Product product = productService.findById(productId);
        List<CartItem> cartItems = cart.getCartItems();

        String result = "Product was successfully added to cart";
        for (CartItem cartItem: cartItems) {
            if (cartItem.getProduct().getId().equals(product.getId())) {
                cartItem.setQuantity(cartItem.getQuantity() + quantity);
                cartItem.setTotalPrice(product.getPrice() * cartItem.getQuantity());

                cartItemRepository.save(cartItem);
                return result;
            }
        }

        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);
        cartItem.setTotalPrice(product.getPrice() * quantity);
        cartItem.setCart(cart);
        cartItemRepository.save(cartItem);

        return result;
    }
}
