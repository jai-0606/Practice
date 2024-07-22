package FirstPack;
import java.util.Arrays;

public class DemoVehicle {

	public static void main(String[] args) {
			
			vehicle vn, vn1 ;
			
			vn=new vehicle();
			vn1=new vehicle();
			
			vn.setCompany("LAMBORGINI");
			vn.setColour("WHITE");
			vn.setproduct("CREAM");
			
			System.out.println(vn.getCompany());
			System.out.println(vn.getColour());
			System.out.println(vn.getProduct());
		}
}