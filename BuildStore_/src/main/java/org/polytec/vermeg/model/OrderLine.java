package org.polytec.vermeg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="orderLine")
public class OrderLine {

	@Id
	@Column(name="id_line")
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	int id_Line ;
	int quantity_line ;
	 @ManyToOne(fetch =FetchType.LAZY)
	    @JoinColumn(name="id_Book")
	    private Book book;
	 @ManyToOne(fetch =FetchType.LAZY)
	    @JoinColumn(name="id_Order" )
	    private Order orders;
	
	 @Column(name="Total")
	 double total ;
	
	
	 



	public OrderLine( int quantity_line, Book book, Order orders, double total) {
		
		this.quantity_line = quantity_line;
		 book.getId();
		orders.getId_orders();
		this.total = total;
	}

	public OrderLine() {
	
	}

	public int getId_Line() {
		
		return id_Line;
	}
	
	public void setId_Line(int id_Line) {
		this.id_Line = id_Line;
	}
	public int getQuantity_line() {
		return quantity_line;
	}
	public void setQuantity_line(int quantity_line) {
		this.quantity_line = quantity_line;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Order getOrders() {
		return orders;
	}

	public void setOrders(Order orders) {
		this.orders = orders;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	

	
}
