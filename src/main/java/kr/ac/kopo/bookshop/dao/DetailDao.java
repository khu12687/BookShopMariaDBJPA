package kr.ac.kopo.bookshop.dao;

import org.springframework.data.repository.Repository;

import kr.ac.kopo.bookshop.model.Detail;

public interface DetailDao extends Repository<Detail, Integer> {

	void save(Detail detail);

	Detail findByBookid(Integer integer);

}
