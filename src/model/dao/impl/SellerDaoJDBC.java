package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entites.Department;
import model.entites.Seller;

public class SellerDaoJDBC implements SellerDao {

	private Connection conn;
	
	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement st = null;
		ResultSet res = null;
		try {
			st = conn.prepareStatement(
					"SELECT seller.*,department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+"ON seller.DepartmentId = department.Id "
					+"WHERE seller.Id = ?");
			
			st.setInt(1, id);
			res = st.executeQuery();
			if(res.next()) {
				Department dep = instantiateDepartment(res);
				Seller obj = instantiateSeller(res, dep);
				return obj;
			}
			return null;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(res);
		}
	}

	private Seller instantiateSeller(ResultSet res, Department dep) throws SQLException {
		Seller obj = new Seller();
		obj.setId(res.getInt("id"));
		obj.setName(res.getString("Name"));
		obj.setEmail(res.getString("Email"));
		obj.setBaseSalary(res.getDouble("BaseSalary"));
		obj.setBirthDate(res.getDate("BirthDate"));
		obj.setDepartment(dep);
		return obj;
	}
	private Department instantiateDepartment(ResultSet res) throws SQLException {
		Department dep = new Department();
		dep.setId(res.getInt("DepartmentId"));
		dep.setName(res.getString("DepName"));
		return dep;
	}
	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
