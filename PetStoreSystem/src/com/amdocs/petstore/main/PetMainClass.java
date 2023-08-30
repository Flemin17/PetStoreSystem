 package com.amdocs.petstore.main;

import java.util.Iterator;
import java.util.Scanner;

import com.amdocs.petstore.dao.PetDAO;
import com.amdocs.petstore.model.Pet;

public class PetMainClass {
	
	
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		boolean f=true;
		PetDAO pd = new PetDAO();
		
		while (f) 
		{
			
		System.out.println("Pet Store Management");
		System.out.println("Menu");
		System.out.println("1. Add new pet details");
		System.out.println("2. Update pet price and Vaccination Status");
		System.out.println("3. Delete pet details");
		System.out.println("4. View all pet");
		System.out.println("5. Count pets by category");
		System.out.println("6. Find by Price");
		System.out.println("7. Find by vaccination status for pet type");
		System.out.println("8. Exit");
		
		System.out.println("Enter your choice - ");
		int choice = sc.nextInt();
		
		switch(choice)
		{
		case 1: 
			System.out.println("Enter petID - ");
			int petId = sc.nextInt();
			System.out.println("Enter Pet category - ");
			String petCategory = sc.next();
			System.out.println("Enter pet type - ");
			String petType = sc.next();
			System.out.println("Enter Color - ");
			String color = sc.next();
			System.out.println("Enter age - ");
			int age = sc.nextInt();
			System.out.println("Enter price - ");
			double price = sc.nextDouble();
			System.out.println("Enter vaccination status(1/0) - ");
			int isVaccinated = sc.nextInt();
			System.out.println("Enter food habits - ");
			String foodHabits = sc.next();

			Pet p1 = new Pet(petId,petCategory,petType,color,age,price,isVaccinated,foodHabits);
			
			
			System.out.println(pd.addPetDetails(p1)+" rows inserted");

			break;
		
		case 2:
			System.out.println("Enter id - ");
			int petid=sc.nextInt();
			System.out.println("Enter price - ");
			double p=sc.nextDouble();
			System.out.println("Enter vaccination status");
			int status = sc.nextInt();
			
			
			System.out.println(pd.updatePetPriceAndVaccinationDetails(petid,p,status)+" Rows updated");
			
			break;
		
		case 3: 
			System.out.println("Enter id to delete - ");
			int pid = sc.nextInt();
			
			System.out.println(pd.deletePetdetails(pid) + " rows deleted");
						
			break;
		
		case 4: 
			
			Iterator<Pet> i = pd.showAllPets().iterator();
			while(i.hasNext())
			{
				Pet p11 = i.next();
				System.out.println(p11.getPetId()+" "+p11.getPetCategory()+" "+p11.getPetType()+" "+p11.getColor()+" "+p11.getAge()+" "+p11.getPrice()+" "+p11.getIsVaccinated()+" "+p11.getFoodHabits());
			}
			
			break;
		
		case 5: 
			System.out.println("Enter Category - ");
			String petcategory = sc.next();
			
			System.out.println(pd.countPetsByCategory(petcategory));
			
			break;
		
		case 6: 
			System.out.println("Enter lower margin - ");
			double lowerPrice = sc.nextDouble();
			
			System.out.println("Enter higher margin - ");
			double higherPrice = sc.nextDouble();
			
			
			Iterator<Pet> i1 = pd.searchByPrice(lowerPrice,higherPrice).iterator();
			while(i1.hasNext())
			{
				Pet p11 = i1.next();
				System.out.println(p11.getPetId()+" "+p11.getPetCategory()+" "+p11.getPetType()+" "+p11.getColor()+" "+p11.getAge()+" "+p11.getPrice()+" "+p11.getIsVaccinated()+" "+p11.getFoodHabits());
			}
		
			break;
		
		case 7: 
			System.out.println("Enter the Pettype - ");
			String petType1 = sc.next();
			System.out.println(pd.countByVaccinationStatusForPetType(petType1));
			break;
			
		case 8:
			System.out.println("Exiting the Program....");
			System.exit(0);
			break;
			

		default: 
			System.out.println("Invalid Choice!! Try again...");

			}
		}
	}
}
		
		

		
		
		

