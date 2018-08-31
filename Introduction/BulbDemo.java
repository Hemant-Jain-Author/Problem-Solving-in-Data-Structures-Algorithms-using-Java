
public class BulbDemo {

	public static void main(String[] args) {
		Bulb b = new Bulb();
		b.size = Bulb.BulbSize.MEDIUM ;
		
		System .out.println("Bulb Size :" + b.size);
		
		System.out.println("bulb is on return : " + b.isOnFun());
		b.turnOn();
		System.out.println("bulb is on return : " + b.isOnFun());
		
		
	}

}
