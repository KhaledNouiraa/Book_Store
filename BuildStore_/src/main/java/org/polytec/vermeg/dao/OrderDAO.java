package org.polytec.vermeg.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.polytec.vermeg.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class OrderDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public List<Order> getAllOrders() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Order> orderList = session.createQuery("from Order").list();
		
		for (Order c:orderList) {
			System.out.println("##### Count "+c.getId_orders()+ "Date "+c.getTotal()+" Total "+c.getTotal());
		}
		
		return orderList;
	}

	public int getOrderNum() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Order> orderList = session.createQuery("from Order").list();
		int count =0;
		for (Order c:orderList) {
			count =c.getId_orders();
		}
		
		return count ;
	}
	
	public Order getOrder(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Order order = (Order) session.get(Order.class, new Integer(id));
		return order;
	}


	public void saveOrder(Order order) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		
		currentSession.saveOrUpdate(order);
		
	}
	
	public void deleteOrder(int theId) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		
		Query theQuery = 
				currentSession.createQuery("delete from Order where id=:orderId");
		theQuery.setParameter("orderId", theId);
		
		theQuery.executeUpdate();		
		
	}
	}
