package com.verizon.micro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.verizon.micro.entities.Cart;
import com.verizon.micro.entities.Product;
import com.verizon.micro.repositories.CartRepository;

@Service
public class CartService {
	
	@Autowired
	public RestTemplate restTemplate;
	
	@Autowired
	CartRepository cartRepository;
	
	public Cart addItemToCart(int productId, int quantity) {

        Optional<Cart> availableItem = cartRepository.findById(productId);
        if(availableItem.isPresent()){
            Cart item = availableItem.get();
            int oldQuantity = item.getQuantity();
            int newQuantity = oldQuantity+quantity;
            float oldPrice = item.getPrice()/oldQuantity;
            item.setQuantity(newQuantity);
            item.setPrice(newQuantity*oldPrice);
            return cartRepository.save(item);
        }

        Product product = getProductDetails(productId);
        float total = product.getPrice() * quantity;
        Cart item = new Cart();
        item.setPrice(total);
        item.setProductId(productId);
        item.setQuantity(quantity);
        return cartRepository.save(item);
    }
	
	public List<Cart> getAllCart() {
		return cartRepository.findAll();
	}
	
	private Product getProductDetails(Integer productId) {
		Product product = restTemplate.getForObject("http://PRODUCT-SERVICE/api/v1/products/"+productId,Product.class);
		return product;
	}

}
