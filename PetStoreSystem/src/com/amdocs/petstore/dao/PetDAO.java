package com.amdocs.petstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.amdocs.petstore.model.Pet;

public class PetDAO {
	
	DBConnection db = new DBConnection();
	Connection c = db.getConnection();
	
	public int addPetDetails(Pet p)
	{
		int count = 0;
		try {
			PreparedStatement pst = 
						c.prepareStatement("INSERT INTO pet VALUES(?,?,?,?,?,?,?,?)");
		pst.setInt(1, p.getPetId());
		pst.setString(2, p.getPetCategory());
		pst.setString(3, p.getPetType());
		pst.setString(4, p.getColor());
		pst.setInt(5,p.getAge());
		pst.setDouble(6, p.getPrice());
		pst.setInt(7, p.getIsVaccinated());
		pst.setString(8,p.getFoodHabits());

		count = pst.executeUpdate();
		
	}catch(Exception e)
	{
		System.out.println("Wrong Details");	
	}
	return count;
	
}

public int updatePetPriceAndVaccinationDetails(int petid,double price, int status)
{
	
	int count =0;
	try {
		PreparedStatement pst = c.prepareStatement("UPDATE pet SET price =? , isvaccinated = ? WHERE petid = ?" );
		pst.setDouble(1, price);
		pst.setInt(2, status);
		pst.setInt(3,petid);
		
		count = pst.executeUpdate();
		if (count==0)
		{
			System.out.println("No such record");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return count;
	
}

public int deletePetdetails(int pid)
{
	
	int count =0;
	
	try {
		
		String query = "DELETE FROM pet WHERE petid = ?";
		PreparedStatement pst = c.prepareStatement(query);
		pst.setInt(1,pid);	
		
		
		
		count = pst.executeUpdate();
		
		if (count==0)
		{
			System.out.println("No such record");
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return count;
}

public List<Pet> showAllPets()
{
	
	
	ArrayList<Pet> pets = new ArrayList<>();
	String query = "Select * from pet";
	
	try {
		PreparedStatement pst = c.prepareStatement(query);
		ResultSet rs = pst.executeQuery();
		
		
		while(rs.next())
		{
			int id = rs.getInt(1);
			String category = rs.getString(2);
			String type = rs.getString(3);
			String color = rs.getString(4);
			int age = rs.getInt(5);
			double price = rs.getDouble(6);
			int status = rs.getInt(7);
			String habits = rs.getString(8);
			
			//System.out.println(id+category);

			
			Pet p = new Pet(id,category,type,color,age,price,status,habits);
			pets.add(p);
		}
		
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return pets;
	
}

public int countPetsByCategory(String category)
{

	int count=0;
	String query = "select count(*) from pet where petcategory = ?";
	
	try {
		PreparedStatement pst = c.prepareStatement(query);
		pst.setString(1, category);
		ResultSet rs = pst.executeQuery();
		
		rs.next();
		count = rs.getInt(1);
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	return count;
}

public List<Pet> searchByPrice(double lowerPrice, double higherPrice)
{
	
	ArrayList<Pet> pets = new ArrayList<>();
	String query = "Select * from pet where price Between ? and ?";
	
	try {
		PreparedStatement pst = c.prepareStatement(query);
		pst.setDouble(1, lowerPrice);
		pst.setDouble(2, higherPrice);
		
		ResultSet rs = pst.executeQuery();
		
		if(rs.next()==false)
		{
			System.out.println("No such record");
		}
		
		while(rs.next())
		{
			int id = rs.getInt(1);
			String category = rs.getString(2);
			String type = rs.getString(3);
			String color = rs.getString(4);
			int age = rs.getInt(5);
			double price = rs.getDouble(6);
			int status = rs.getInt(7);
			String habits = rs.getString(8);
			
			System.out.println(id+category);

			
			Pet p = new Pet(id,category,type,color,age,price,status,habits);
			pets.add(p);
		}
		
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	return pets;
	
}

public int countByVaccinationStatusForPetType(String petType)
{
	List list = new ArrayList();
	String query = " select * from pet where pettype = ?";
	
	try {
		PreparedStatement  pst = c.prepareStatement(query);
		pst.setString(1, petType);
		
		ResultSet rs = pst.executeQuery();
		if(rs.next()==false)
		{
			System.out.println("No such record");
		}
		
		while(rs.next())
		{
			Pet p = new Pet(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getDouble(6),rs.getInt(7),rs.getString(8));
			
			if(p.getIsVaccinated()==1)
			{
				list.add(p);
			}
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list.size();
	}
	
	
}

