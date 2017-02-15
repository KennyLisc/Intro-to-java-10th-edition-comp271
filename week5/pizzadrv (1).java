import java.util.Date;

public class pizzadrv {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pizza many_pizzas[] = new Pizza[5];
		System.out.println("Delivery charge is " + Pizza.delivery_charge);
		SmallPizza sm = new SmallPizza();
		sm.add_topping("Peppers");
		sm.add_topping("Mushrooms");
		System.out.println(sm.order_info());
		MediumPizza med = new MediumPizza();
		System.out.println("is Medium the same as small " +
				med.compareTo(sm));
	//	Pizza xlarge = new Pizza("XLarge");
	}

} // end of pizzadrv
abstract class Pizza implements Comparable<Pizza> {
	protected double cost;
	protected String size;
	protected Date order_date;
	protected String toppings;
	public static final double delivery_charge = 5;
	
abstract public void add_topping(String topping);
public int compareTo(Pizza sp){
	if (size.equalsIgnoreCase(sp.size) ){
		if (cost < sp.cost)
			return -1;
		else if (cost > sp.cost)
			return 1;
		else
			return 0;
	}
	return -1;
}
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