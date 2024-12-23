package dec23.java_multithreading_bakery_simulation;

public class Bakery {

	private int goodsAvailable;
	private final int MAX_GOODS_PER_DAY = 100;
	private int goodsProducedToday;
		

	public int getGoodsAvailable() {
		return goodsAvailable;
	}



	public void setGoodsAvailable(int goodsAvailable) {
		this.goodsAvailable = goodsAvailable;
	}



	public int getGoodsProducedToday() {
		return goodsProducedToday;
	}



	public void setGoodsProducedToday(int goodsProducedToday) {
		this.goodsProducedToday = goodsProducedToday;
	}



	public int getMAX_GOODS_PER_DAY() {
		return MAX_GOODS_PER_DAY;
	}



	public synchronized void bakeGoods() throws InterruptedException {
		while(goodsAvailable > 0) {
			wait();
		}
		if(goodsProducedToday < MAX_GOODS_PER_DAY) {
			goodsAvailable = 10;
			goodsProducedToday += goodsAvailable;
			System.out.println("Baker baked 10 goods, Total goods available are : "+goodsAvailable);
			notifyAll();
		}
	}
	
	public synchronized void buyGoods(String customerName) throws InterruptedException {
		while (goodsAvailable == 0 && !isProductionFinished()) {
			wait();
		}
		
		if (goodsAvailable > 0) {
			goodsAvailable--;
			System.out.println(customerName+" bought 1 good. Goods left : "+goodsAvailable);
			if (goodsAvailable == 0 && goodsProducedToday < MAX_GOODS_PER_DAY) {
				notifyAll();
			}
		}
	}
	
	public boolean isProductionFinished() {
		return goodsProducedToday >= MAX_GOODS_PER_DAY && goodsAvailable == 0;
		
	}
}
