package kr.ac.kopo.bookshop.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.bookshop.dao.DetailDao;
import kr.ac.kopo.bookshop.model.Detail;
import kr.ac.kopo.bookshop.model.Orders;

@Service
public class OrdersServiceImpl implements OrderService {
	
	@Autowired
	OrdersDao dao;
	
	@Autowired
	DetailDao detailDao;

	@Override
	public List<Orders> list() {
		return dao.findAll();
	}

	@Override
	public void add(Orders item, List<Integer> books, List<Integer> amounts) {
		dao.save(item);
		
		for(int i=0; i < books.size(); i++) {
			Detail detail = new Detail();
			
			detail.setOrderid(item.getOrderid());
			detail.setBookid(books.get(i));
			detail.setAmount(amounts.get(i));
			
			detailDao.save(detail);
		}
	}

	@Override
	public Orders item(int orderid) {
		return dao.findOneByOrderid(orderid);
	}

	@Override
	public void update(Orders item, List<Integer> books, List<Integer> amounts) {
		for(int i=0; i < books.size(); i++) {	
			Detail detail = detailDao.findByBookid(books.get(i));
			
			if(detail == null) {
				System.out.println("1");
				
				detail = new Detail();
				
				detail.setOrderid(item.getOrderid());
				detail.setBookid(books.get(i));				
			} else
				System.out.println("2");
			
			detail.setAmount(amounts.get(i));
			
			detailDao.save(detail);			
		}
		
		dao.save(item);
	}

	@Override
	public void delete(int orderid) {
		dao.deleteById(orderid);
	}

}
