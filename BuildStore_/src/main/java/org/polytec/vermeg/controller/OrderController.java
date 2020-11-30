package org.polytec.vermeg.controller;


import java.util.List;

import org.polytec.vermeg.model.Order;
import org.polytec.vermeg.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/api/order")

public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	CustomerController customerController;
	 
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
    public String sayHello(){
        return "lll ";
    }
	
	
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
	public List<Order> getOrders() {
		
		List<Order> listOfOrders = orderService.getOrders();
		
		return listOfOrders;
	}

	@RequestMapping(value = "/getOrder/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Order getOrderById(@PathVariable int id) {
		return orderService.getOrder(id);
	}
	
	@RequestMapping(value = "/getOrderLAstID/", method = RequestMethod.GET, headers = "Accept=application/json")
	public int getOrderNum() {
		return orderService.getCount();
	}

	

	@RequestMapping(value = "/addOrder/{idCust}", method = RequestMethod.POST, headers = "Accept=application/json")
	public Order addOrder(@RequestBody Order order ,@PathVariable int idCust) {

	
		
		order.setId_orders(0);
		
		orderService.saveOrder(order);
		
		return order;
	}
	@RequestMapping(value = "/updateOrder", method = RequestMethod.POST, headers = "Accept=application/json")
	public Order  updateOrder(@RequestBody Order order) {
		
		orderService.saveOrder(order);
		
		return order;
		
	}
	


	@RequestMapping(value = "/deleteOrder/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteOrder(@PathVariable("id") int id) {
		orderService.deleteOrder(id);
		 return "Delete Done";

	}	
}
