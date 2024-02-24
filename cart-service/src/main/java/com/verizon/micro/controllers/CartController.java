package com.verizon.micro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.micro.entities.Cart;
import com.verizon.micro.services.CartService;


@RestController
@RequestMapping("api/v1/cart")
public class CartController {

	@Autowired
	    private CartService cartService;

	    @PostMapping("/id/{productId}/quantity/{quantity}")
	    public Cart addToCart(@PathVariable int productId,
	                              @PathVariable int quantity){
	        return cartService.addItemToCart(productId,quantity);
	    }

	    @GetMapping
	    public List<Cart> getAllCart(){
	        return cartService.getAllCart();
	    }
	
}
