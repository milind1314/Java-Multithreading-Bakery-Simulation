package dec23.java_multithreading_bakery_simulation;

public class Baker implements Runnable{

	public Bakery bakery;
	
	

	public Baker(Bakery bakery) {
		super();
		this.bakery = bakery;
	}



	@Override
	public void run() {

		while (!bakery.isProductionFinished()) {
			try {
				bakery.bakeGoods();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			 System.out.println("Baker has finished baking for the day.");
		}
	}

}
