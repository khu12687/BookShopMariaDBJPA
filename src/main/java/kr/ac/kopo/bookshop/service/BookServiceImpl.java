package kr.ac.kopo.bookshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.bookshop.dao.BookDao;
import kr.ac.kopo.bookshop.model.Book;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookDao dao;

	@Override
	public List<Book> list() {
		return dao.findAll();
	}

	@Override
	public void add(Book item) {
		dao.save(item);
	}

	@Override
	public Book item(int bookid) {
		return dao.findOneByBookid(bookid);
	}

	@Override
	public void update(Book item) {
		dao.save(item);
	}

	@Override
	public void delete(int bookid) {
		dao.deleteById(bookid);
	}

	@Override
	public void dummy() {
		for(int i=0; i < 100; i++) {
			Book item = new Book();
			
			item.setBookname("도서명 " + i);
			item.setPublisher("출판사 " + i);
			item.setPrice( (i + 1) * 1000);
			
			dao.save(item);
		}
	}

	@Override
	public void init() {
		List<Book> list = dao.findAll();
		
		for(Book item : list)
			dao.deleteById(item.getBookid());
	}

}
