package jdbc;

import java.util.Iterator;
import java.util.Scanner;

import com.amdocs.petstore.dao.PetDAO;

public class MainClass {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		PetDAO pd = new PetDAO();
		
		
		/*System.out.println("Enter petID - ");
		int petId = sc.nextInt();
		System.out.println("Enter Pet category - ");
		String petCategory = sc.next();
		System.out.println("Enter pet type - ");
		String petType = sc.next();
		System.out.println("Enter Color - ");/*
		String color = sc.next();
		System.out.println("Enter age - ");
		int age = sc.nextInt();
		System.out.println("Enter price - ");
		double price = sc.nextDouble();
		System.out.println("Enter vaccination status(1/0) - ");
		int isVaccinated = sc.nextInt();
		System.out.println("Enter food habits - ");
		String foodHabits = sc.next();

		Pet p1 = new Pet(petId,petCategory,petType,color,age,price,isVaccinated,/*foodHabits);
		PetDAO pd = new PetDAO();
		
		System.out.println(pd.addPetDetails(p1)+" rows inserted");*/
		
		
		
		/*System.out.println("Enter id - ");
		int petid=sc.nextInt();
		System.out.println("Enter price - ");
		double price=sc.nextDouble();
		System.out.println("Enter vaccination status");
		int status = sc.nextInt();
		
		
		System.out.println(pd.updatePetPriceAndVaccinationDetails(petid,price,status)+" Rows updated");
		
		/*
		System.out.println("Enter id to delete - ");
		int pid = sc.nextInt();
		
		System.out.println(pd.deletePetdetails(pid) + " rows deleted");
		
		*/
		
		
		
//		System.out.println("Enter Category - ");
//		String petcategory = sc.next();
//		
//		System.out.println(pd.countPetsByCategory(petcategory));
		

		
//		Iterator<Pet> i = pd.showAllPets().iterator();
//		while(i.hasNext())
//		{
//			Pet p = i.next();
//			System.out.println(p.getPetId()+" "+p.getPetCategory()+" "+p.getPetType()+" "+p.getColor()+" "+p.getAge()+" "+p.getPrice()+" "+p.getIsVaccinated()+" "+p.getFoodHabits());
//		}
		
//		System.out.println("Enter lower margin - ");
//		double lowerPrice = sc.nextDouble();
//		
//		System.out.println("Enter higher margin - ");
//		double higherPrice = sc.nextDouble();
//		
//		
//		Iterator<Pet> i = pd.searchByPrice(lowerPrice,higherPrice).iterator();
//		while(i.hasNext())
//		{
//			Pet p = i.next();
//			System.out.println(p.getPetId()+" "+p.getPetCategory()+" "+p.getPetType()+" "+p.getColor()+" "+p.getAge()+" "+p.getPrice()+" "+p.getIsVaccinated()+" "+p.getFoodHabits());
//		}
//	
		
		System.out.println("Enter the Pettype - ");
		String petType = sc.next();
		System.out.println(pd.countByVaccinationStatusForPetType(petType));
		
		
	}
}