package com.sunanda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunanda.entity.Product;
import com.sunanda.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService service;
	
	@PostMapping("/addProduct")
	public Product saveProduct(@RequestBody Product product) {
		return service.saveProduct(product);		
	}
	
	@PostMapping("/addProducts")
	public List<Product> saveProducts(@RequestBody List<Product> products) {
		return service.saveProducts(products);		
	}

	@GetMapping("/getProducts")
	public List<Product> findAllProducts(){
		return service.getProducts();
	}
	
	@GetMapping("/getProduct/{id}")
	public Product findProductById(@PathVariable int id) {
		return service.getProductById(id);
	}
	
	@GetMapping("/getProduct/{name}")
	public Product findProductByName(@PathVariable String name) {
		return service.getProductByName(name);
	}
	
	@PutMapping("/updateProduct")
	public Product updateProduct(@RequestBody Product product){
		return service.updateProduct(product);
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id) {
		return service.deleteProduct(id);
	}
	
	
	
	
}
