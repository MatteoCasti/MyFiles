package main;

import java.util.Scanner;

public abstract class ConsoleApp {
	// In una console app abbiam bisogno di uno scanner
			private Scanner kbd;
			
			public ConsoleApp() {
				kbd = new Scanner(System.in);
			}
			
			/**
			 * Shortcut per stampare qualsiasi cosa sui console 
			 * @param obj
			 */
			public void print(Object obj) {
				System.out.println(obj.toString());
			}
			
			public String nextLine(String msg) {
				// con un unico comando posso stampare a console una richiesta 
				// e recuperare l'input dell'utente
				print(msg);
				return kbd.nextLine();
			}
			
			public int nextInt(String msg, String errorMsg) {
				// Inizialmente valid è false
				boolean valid = false;
				
				int ris = 0;
				
				do {
					// Chiedo all'utente di inserire il valore e mi registro la risposta
					String value = nextLine(msg);
					
					try {
						// provo a parsarla ad int
						// Questo può andare bene come può andare male 
						ris = Integer.parseInt(value);
						
						// Se non scaturisce l'eccezione valid diventa true
						// e mi permette di uscire dal ciclo
						valid = true;
					} catch (NumberFormatException e) {
						// se l'input dell'utente non va bene stampa l'errore
						print(errorMsg);
					}
				} while (!valid);
				
				return ris;
			}
			
			public double nextDouble(String msg, String errorMsg) {
				// Inizialmente valid è false
				boolean valid = false;
				
				double ris = 0;
				
				do {
					// Chiedo all'utente di inserire il valore e mi registro la risposta
					String value = nextLine(msg);
					
					try {
						// provo a parsarla ad int
						// Questo può andare bene come può andare male 
						ris = Double.parseDouble(value);
						
						// Se non scaturisce l'eccezione valid diventa true
						// e mi permette di uscire dal ciclo
						valid = true;
					} catch (NumberFormatException e) {
						// se l'input dell'utente non va bene stampa l'errore
						print(errorMsg);
					}
				} while (!valid);
				
				return ris;
			}
			
			/**
			 * Questo metodo contiene tutta la logica di interazione con l'utente
			 */
			public abstract void run();
}
