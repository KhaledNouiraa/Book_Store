package org.polytec.vermeg.service;

import java.util.List;

import org.polytec.vermeg.dao.BookDAO;
import org.polytec.vermeg.dao.OrderDAO;
import org.polytec.vermeg.dao.OrderLineDAO;
import org.polytec.vermeg.model.Order;
import org.polytec.vermeg.model.OrderLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("orderLineService")
public class OrderLineService {

	@Autowired
	OrderLineDAO lineDao;
	;
	@Transactional
	public List<OrderLine> getOrders() {
		return lineDao.getOrderLine();
	}

	@Transactional
	public OrderLine getOrderLine(int id) {
		return lineDao.getLine(id);
	}


	@Transactional
	public double calculate (double price ,int qtq) {
		
		return price*qtq; 
	}
	@Transactional
	public void saveOrderLine(OrderLine order) {

		lineDao.saveOrderLine(order);
	}
	

	

	@Transactional
	public void deleteOrderLine(int theId) {
		
		lineDao.deleteLine(theId);
	}
}
