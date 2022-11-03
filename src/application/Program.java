package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entites.Department;
import model.entites.Seller;

public class Program {

	public static void main(String[] args) {
		SellerDao sd = DaoFactory.createSellerDao();
		
		Seller seller = sd.findById(3);
		System.out.println("===Teste número 1 findById===");
		System.out.println(seller);
		
		System.out.println("\n===Teste número 2 findByDepartment===");
		Department dep = new Department(2, null);
		List<Seller> list = sd.findByDepartment(dep);
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n===Teste número 3 findAll===");
		list = sd.findAll();
		for(Seller obj : list) {
			System.out.println(obj);
		}
	}

}
