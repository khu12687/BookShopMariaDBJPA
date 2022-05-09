package kr.ac.kopo.bookshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Detail {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="detail_id")
	private int detailId;
	private int orderid;
	private int bookid;
	private int amount;
	
	@ManyToOne
	@JoinColumn(name = "orderid", insertable = false, updatable = false)
	private Orders order;
	
	@ManyToOne
	@JoinColumn(name = "bookid", insertable = false, updatable = false)
	private Book book;

	public int getDetailId() {
		return detailId;
	}

	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
}
