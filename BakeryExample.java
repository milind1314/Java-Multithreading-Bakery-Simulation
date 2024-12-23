package dec23.java_multithreading_bakery_simulation;

public class BakeryExample {

	public static void main(String[] args) {
		Bakery bake = new Bakery();
		
		Baker baker = new Baker(bake);
		Thread tr = new Thread(baker);
		tr.start();
		 Customer customer1 = new Customer(bake, "Milind");
	        Customer customer2 = new Customer(bake, "Anand");
	        Customer customer3 = new Customer(bake, "Mahesh");
		
		Thread t1 = new Thread(customer1);
		t1.start();
		
		Thread t2 = new Thread(customer2);
		t2.start();
		
		Thread t3 = new Thread(customer3);
		t3.start();
		
		try {
            tr.join();
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Bakery operation has finished for the day.");
    
	}
}
