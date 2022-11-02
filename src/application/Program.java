package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entites.Seller;

public class Program {

	public static void main(String[] args) {
		SellerDao sd = DaoFactory.createSellerDao();
		
		Seller seller = sd.findById(3);
		
		System.out.println(seller);
	}

}
