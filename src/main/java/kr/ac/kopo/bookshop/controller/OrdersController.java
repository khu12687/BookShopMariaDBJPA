package kr.ac.kopo.bookshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.kopo.bookshop.model.Book;
import kr.ac.kopo.bookshop.model.Customer;
import kr.ac.kopo.bookshop.model.Orders;
import kr.ac.kopo.bookshop.service.BookService;
import kr.ac.kopo.bookshop.service.CustomerService;
import kr.ac.kopo.bookshop.service.OrderService;

@Controller
@RequestMapping("/orders")
public class OrdersController {
	private final String path = "orders/";
	
	@Autowired
	OrderService service;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	BookService bookService;	
	
	@GetMapping("/view/{orderid}")
	public String view(@PathVariable int orderid, Model model) {
		Orders item = service.item(orderid);
		
		model.addAttribute("item", item);
		
		return path + "view";
	}
	
	
	@GetMapping("/list")
	public String list(Model model) {
		List<Orders> list = service.list();
		
		model.addAttribute("list", list);
		
		return path + "list";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		List<Customer> customers = customerService.list();
		model.addAttribute("customers", customers);
		
		List<Book> books = bookService.list();
		model.addAttribute("books", books);
		
		return path + "add";
	}
	
	@PostMapping("/add")
	public String add(@RequestParam("bookid") List<Integer> books, @RequestParam("amount") List<Integer> amounts, Orders item) {
		service.add(item, books, amounts);
		
		return "redirect:list";
	}
	
	@GetMapping("/update/{orderid}")
	public String update(@PathVariable int orderid, Model model) {
		Orders item = service.item(orderid);		
		model.addAttribute("item", item);
		
		List<Customer> customers = customerService.list();
		model.addAttribute("customers", customers);
		
		List<Book> books = bookService.list();
		model.addAttribute("books", books);
		
		return path + "update";
	}
	
	@PostMapping("/update/{orderid}")
	public String update(@PathVariable int orderid, @RequestParam("bookid") List<Integer> books, @RequestParam("amount") List<Integer> amounts, Orders item) {
		item.setOrderid(orderid);
		
		service.update(item, books, amounts);
		
		return "redirect:../list";
	}
	
	@GetMapping("/delete/{orderid}")
	public String delete(@PathVariable int orderid) {
		service.delete(orderid);
		
		return "redirect:../list";
	}
}
