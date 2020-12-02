package org.polytec.vermeg.controller;


import java.util.List;

import org.polytec.vermeg.model.Order;
import org.polytec.vermeg.model.OrderLine;
import org.polytec.vermeg.service.OrderLineService;
import org.polytec.vermeg.service.OrderLineServiceImp;
import org.polytec.vermeg.service.OrderServiceImp;
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
@RequestMapping("/api/line")

public class OrderLineController {
	
	@Autowired
	OrderLineService orderService;
	
	@Autowired
	BookController bookController ;
	@Autowired
	OrderController orderController ; 
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
    public String sayHello(){
        return "lll ";
    }
	 
	
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
	public List<OrderLine> getLineOrders() {
		
		List<OrderLine> listOfOrders = orderService.getOrders();
		
		return listOfOrders;
	}

	@RequestMapping(value = "/getLine/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public OrderLine getOrderById(@PathVariable int id) {
		return orderService.getOrderLine(id);
	}

	

	@RequestMapping(value = "/addLine/{idBook}", method = RequestMethod.POST, headers = "Accept=application/json")
	public OrderLine addOrder(@RequestBody OrderLine order,@PathVariable int idBook) {
		// get by the last last id Order ,,, 
		//so we must have already a current order in table Orders to add throw it the orderLines
		order.setOrders(orderController.getOrderById(orderController.getOrderNum()));
		
		// get by id Book
		order.setBook(bookController.getBookById(idBook));
		
		//Calculate total  OrderLine
		order.setTotal(orderService.calculate(bookController.getBookById(idBook).getPrice_unit(), order.getQuantity_line()));
		// Calculate total of  current Order
		order.getOrders().setTotal(order.getTotal()+order.getOrders().getTotal());
		
		//update total in  Order table 
		orderController.updateOrder(order.getOrders());
		order.setId_Line(0);
		
		//save data to orderLine table
		orderService.saveOrderLine(order );
		
		
		return order;
	}
	@RequestMapping(value = "/updateBook", method = RequestMethod.POST, headers = "Accept=application/json")
	public OrderLine  updateOrder(@RequestBody OrderLine order) {
		
		orderService.saveOrderLine(order);;
		
		return order;
		
	}
	


	@RequestMapping(value = "/deleteLine/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteOrder(@PathVariable("id") int id) {
		orderService.deleteOrderLine(id);
		 return "Delete Done";

	}	
}
