package kr.ac.kopo.bookshop.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import kr.ac.kopo.bookshop.model.Customer;

public interface CustomerDao extends Repository<Customer, Integer> {
	List<Customer> findAll();

	void save(Customer item);

	void deleteById(int custid);

	Customer findOneByCustid(int custid);
}
