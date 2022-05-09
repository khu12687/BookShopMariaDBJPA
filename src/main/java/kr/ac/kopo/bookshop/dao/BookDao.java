package kr.ac.kopo.bookshop.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import kr.ac.kopo.bookshop.model.Book;

public interface BookDao extends Repository<Book, Integer> {

	List<Book> findAll();

	void save(Book item);

	Book findOneByBookid(int bookid);

	void deleteById(int bookid);

}
