package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entites.Department;
import model.entites.Seller;

public class Program {

	public static void main(String[] args) {
		SellerDao sd = DaoFactory.createSellerDao();
		Scanner sc = new Scanner(System.in);
		
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
		
		//System.out.println("\n===Teste número 4 Seller insert===");
		//Seller newSeller = new Seller(null,"João Gabriel", "joao@gmail.com", new Date(), 4000.0, dep);
		//sd.insert(newSeller);
		//System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println("\n===Teste número 5 Seller update===");
		seller = sd.findById(1);
		seller.setName("Martha Waine");
		sd.update(seller);
		System.out.println("Update completed!");
		
		System.out.println("\n===Teste número 6 Seller delete===");
		System.out.print("Enter id for delete: ");
		int id = sc.nextInt();
		sd.deleteById(id);
		System.out.println("Delete completed!");
		
		sc.close();
	}

}
