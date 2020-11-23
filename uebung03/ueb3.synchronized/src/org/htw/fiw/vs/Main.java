package org.htw.fiw.vs;

public class Main {

	public static void main(String[] args) {
		final Name name = new Name();
		Thread setter = new Thread(new Runnable() {
			@Override
			public void run() {
				name.set("Donald", "Trump");
				name.set("Biden", "Joe");
			}
		}); 
		
		Thread getter = new Thread(new Runnable() {
			@Override
			public void run() {
				int i = 0;
				while (i < 20) {
					//Thread.yield(); 
					System.out.println(name.get());
					i++; //während set() Methode 10 ms schläft wird Schleife weiter durchläuft und para und der Nachname  
					
					try {
						Thread.sleep(1);				//gerechter für Donald Trump	
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		setter.start();
		getter.start();
		
	}
}
