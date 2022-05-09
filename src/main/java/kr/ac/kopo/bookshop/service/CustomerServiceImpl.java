package kr.ac.kopo.bookshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.bookshop.dao.CustomerDao;
import kr.ac.kopo.bookshop.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerDao dao;

	@Override
	public List<Customer> list() {
		return dao.findAll();
	}

	@Override
	public void add(Customer item) {
		dao.save(item);
	}

	@Override
	public Customer item(int custid) {
		return dao.findOneByCustid(custid);
	}

	@Override
	public void update(Customer item) {
		dao.save(item);
	}

	@Override
	public void delete(int custid) {
		dao.deleteById(custid);
	}

}
