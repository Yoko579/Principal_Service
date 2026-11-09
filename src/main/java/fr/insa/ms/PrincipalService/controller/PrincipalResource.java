package fr.insa.ms.PrincipalService.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import fr.insa.ms.PrincipalService.model.*;

@RestController
@RequestMapping("/principal")
public class PrincipalResource {
	
	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/test")
	public void test() {
		System.out.println("Test Principal!");
	}
	
	@GetMapping("/getOrder/{id}")
	public Order getOrder(@PathVariable("id") int id) {
	    return restTemplate.getForObject("http://OrderService/order/getOrder/" + id, Order.class);
	}
	
	@PostMapping(value = "/addOrder", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addOrder(@RequestBody Order order) {
        Inventory inventory = restTemplate.getForObject(
        		"http://InventoryService/inventory/getInventory/" + order.getArticleId(), Inventory.class);
        if (inventory != null && inventory.getStock() > 0) {
            restTemplate.put("http://InventoryService/inventory/updateDownInventory/" + order.getArticleId(), null);
            restTemplate.postForObject("http://OrderService/order/addOrder", order, Void.class);
            System.out.println("Order added.");
        } else {
            System.out.println("Order refused: item out of stock.");
        }
	}
	
	@PutMapping(value = "/updateOrder", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateOrder(@RequestBody Order order) {
	    restTemplate.put("http://OrderService/order/updateOrder", order);
	    System.out.println("Order updated.");
	}

	@DeleteMapping("/deleteOrder/{id}")
	public void deleteOrder(@PathVariable("id") int id) {
	    restTemplate.delete("http://OrderService/order/deleteOrder/" + id);
	    System.out.println("Order removed.");
	}
}
