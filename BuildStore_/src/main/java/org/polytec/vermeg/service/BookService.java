package org.polytec.vermeg.service;

import java.util.List;

import org.polytec.vermeg.dao.BookDAO;
import org.polytec.vermeg.model.Book;
import org.polytec.vermeg.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("bookService")
public class BookService {

	@Autowired
	BookDAO bookDao ;
	
	@Transactional
	public List<Book> getAllBooks() {
		return bookDao.getBooks();
	}

	@Transactional
	public Book getBook(int id) {
		return bookDao.getBook(id);
	}
	
	@Transactional
	public void saveBook(Book book) {

		bookDao.saveBook(book);
	}

	@Transactional
	public double getPriceBook(int id) {
		return bookDao.getPriceBook(id);
	}

	@Transactional
	public void deleteBook(int id) {
		bookDao.deleteBook(id);
	}
}
