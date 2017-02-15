import java.util.Date;

public class pizzadrv {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SmallPizza sm = new SmallPizza();
		sm.add_topping("Peppers");
		sm.add_topping("Mushrooms");
		System.out.println(sm.order_info());
	}

} // end of pizzadrv
class Pizza {
	protected double cost;
	protected String size;
	protected Date order_date;
	protected String toppings;
	
	// constructor
	public Pizza (String sz) {
		size = sz;
		order_date = new Date(); // current date and time
		toppings = "";		
	}
	
	public String order_info() {
		String order;
		if (toppings.isEmpty()) {
			order = String.format(
			"At %s a %s pizza was ordered. The total is %.2f",
			order_date, size, cost);
		}
		else
			order = String.format(
			"At %s a %s pizza with %s toppings was ordered. The total is %.2f",
			order_date, size, toppings, cost);
		return order;
	}
	
} // end of Pizza
class SmallPizza extends Pizza {
	public SmallPizza() {
		super("Small"); 
		cost = 8;
	}
	public void add_topping(String topping) {
		toppings = toppings + " " + topping;
		cost += .25;
	}
} // end of SmallPizza
class MediumPizza extends Pizza {
	public MediumPizza() {
		super("Medium"); 
		cost = 10;
	}
	public void add_topping(String topping) {
		toppings = toppings + " " + topping;
		cost += .5;
	}
} // end of MediumPizza
class LargePizza extends Pizza {
	public LargePizza() {
		super("Large"); 
		cost = 12;
	}
	public void add_topping(String topping) {
		toppings = toppings + " " + topping;
		cost += .75;
	}
} // end of LargePizza