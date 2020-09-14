package p04001;

public class GlobalFood {
	
	public GlobalFood() {
		System.out.println(" --- GolbalFood() Construct ---");
	}
	
	public void makeFood(IFood food) {
		System.out.println(" --- makeFood() START ---");
		food.makeFood();
		
	}


}
