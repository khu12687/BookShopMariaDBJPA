package kr.ac.kopo.bookshop.service;

import java.util.List;

import org.springframework.data.repository.Repository;

import kr.ac.kopo.bookshop.model.Orders;

public interface OrdersDao extends Repository<Orders, Integer> {

	List<Orders> findAll();

	void save(Orders item);

	Orders findOneByOrderid(int orderid);

	void deleteById(int orderid);

}
