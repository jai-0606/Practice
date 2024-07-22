package FirstPack;

public class DemoAnimal {

	public static void main(String[] args) {
	
		
		Animal an,an1 ;
		
		an=new Animal();
		an1=new Animal();
		
		an.setName("cat");
		an.setType_animal("wild");
		an.setFood_habbit("veg");
		
		System.out.println(an.getName());
		System.out.println(an.getFood_habbit());
		System.out.println(an.getType_animal());

	}

}