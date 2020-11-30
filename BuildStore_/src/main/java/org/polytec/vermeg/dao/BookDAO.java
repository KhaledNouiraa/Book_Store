package org.polytec.vermeg.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.polytec.vermeg.model.Book;
import org.polytec.vermeg.model.Customer;

@Repository
public class BookDAO {


		@Autowired
		private SessionFactory sessionFactory;

		public void setSessionFactory(SessionFactory sf) {
			this.sessionFactory = sf;
		}

		public List<Book> getBooks() {
			Session session = this.sessionFactory.getCurrentSession();
			List<Book> bookList = session.createQuery("from Book").list();
			
			for (Book c: bookList) {
				System.out.println("Book :"+c.getTitle());
			}
			
			return bookList;
		}

		public Book getBook(int id) {
			Session session = this.sessionFactory.getCurrentSession();
			Book b= (Book) session.get(Book.class, new Integer(id));
			return b;
		}

		public void saveBook(Book book) {

			
			Session currentSession = sessionFactory.getCurrentSession();
			
		
			currentSession.saveOrUpdate(book);
			
		}

		public void deleteBook(int id) {
			Session session = this.sessionFactory.getCurrentSession();
			Book b = (Book) session.load(Book.class, new Integer(id));
			if (null != b) {
				session.delete(b);
			}
			
		}

		public double getPriceBook(int id) {
			Session session = this.sessionFactory.getCurrentSession();
			Book b= (Book) session.get(Book.class, new Integer(id));
			return b.getPrice_unit();
		}	
	}


