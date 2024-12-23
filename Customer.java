package dec23.java_multithreading_bakery_simulation;

public class Customer implements Runnable{

	private final Bakery bakery;
	private final String customerName;
	
	public Customer(Bakery bakery, String customerName) {
		super();
		this.bakery = bakery;
		this.customerName = customerName;
	}

	@Override
	public void run() {

		while (!bakery.isProductionFinished()) {
			try {
				bakery.buyGoods(customerName);
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(customerName + " is done shopping for the day.");
		
		}
	}
	
	
	
}
