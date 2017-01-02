package controller;

import java.util.ConcurrentModificationException;

public class CacheThread implements Runnable {
	private int intervalInSeconden;
	private boolean enabled;
	
	public void disable() {
		enabled = false;
	}
	
	public void enable() {
		enabled = true;
	}
	
	public CacheThread(int interval) {
		this.intervalInSeconden = interval;
		enabled = true;
	}
	@Override
	public void run() {
		while (enabled) {
			try {
				CacheController.push();
				//System.out.println(Thread.currentThread().getName());
			} catch(ConcurrentModificationException e)  {
				//e.printStackTrace();
			} 
			try {
				Thread.sleep(intervalInSeconden*1000);
			} catch (InterruptedException e) {
				
			}
		}
		
	}
}
