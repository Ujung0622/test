package p02001;



public class MainClass {
	
	public static void main(String[] args) {
	

	KoreaFood koreaFood = new KoreaFood();
	ChinaFood chinaFood = new ChinaFood();
	
	GlobalFood globalFood = new GlobalFood();
	
	
	globalFood.makeFood(koreaFood);
	globalFood.makeFood(chinaFood);
	
	
	}
	
}
