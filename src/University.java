//Hakan ONAY 170504021
import java.util.Scanner;

import java.util.Vector;
public class University {
		private Vector <Student> List = new Vector<>();
		public Vector<Dozent> dozentList = new Vector<>();
		private Vector<LVA> lvaList = new Vector<>();
		// Unsere Speicher-System als Vector ausgesucht wegen einfache Methoden.
		
		 void addStudent(int id, String name, String nachname) {
			 Student toAdd = new Student(id, name, nachname);
		        // toAdd ist eine temporare student, representiert die kommenden Studente Daten
			 for (int i = 0; i <List.size(); i++){
		            if ((List.get(i)).equals(toAdd)) {
		                System.out.println("Diese Student ist schon gespeichert.");
		                return;
		                //Wenn toadd ist schon da ist, geben wir den information.
		                
		            }
		            }
			  System.out.println("Den Student wurde zur System addiert.");     
		      getList().add(toAdd); //wenn nicht, addieren durch standart Vector methode.
		     
		}
		 
		public boolean control (Student a){
	        return this.List.contains(a);
	        // um "contains" funktion von List zu erreichen
	    }
                public boolean control (Dozent a){
	        return this.dozentList.contains(a);
	        // um "contains" funktion von List zu erreichen
	    }
                public boolean control (LVA a){
	        return this.lvaList.contains(a);
	        // um "contains" funktion von List zu erreichen
	    }
		
		void listStudent() {
				for (int i = 0; i < getList().size(); i++) {
        	    System.out.println((i + 1) + "-" + ((getList().get(i)).toString()));
          }
				//Geben wir aus die gespeicherte Studente
		}
		
		public Vector<Student> getList() {
	        return List;
	    }
	
		
		 public void deleteStudent(int input) {
			 	for (Student x : List) {
		            if (x.getMatrikel() == input) {
		                this.List.remove(x);
		                System.out.println("Diese Student wurde von der System gel�scht.");
		                return;
		            }		 
			 }
			
		 }
		 
		 	public void addDozent(String name, String nachname, long tc) {
		        Dozent toAdd = new Dozent(name,nachname,tc);
		 		for(int i = 0; i <dozentList.size(); i++) {
		 			if((dozentList.get(i)).equals(toAdd)) {
		 				System.out.println("Dieser Dozent ist schon gespeichert.");
		 				return;
		 			}
		 		}
		 			Vector<Dozent> x = new Vector();
		 			x = getDozentList();
		 		 	System.out.println("Den Dozent wurde zur System addiert.");     
		 		 	x.add(toAdd); //wenn nicht, addieren durch standart Vector methode.
		 		 	
		    }
		 
		 	 void listDozent() {
				for (int i = 0; i < dozentList.size(); i++) {
					System.out.println((i + 1) + "-" + ((getDozentList().get(i)).toString()));
				}
				
		 }
		 
		public Vector<Dozent> getDozentList() {
			        return dozentList;
		}
				
		public void printDozentInfo(String name, String nachname) {
	        for (Dozent gesucht : dozentList) {

	            if (gesucht.name.equals(name) && gesucht.nachname.equals(nachname)) {
	                System.out.println(gesucht.toString());
	                return; // F�r Jede Objekt in dozentList ; if 
	                		// gesucht Objekt equals gegebenen Objekt, tut es.
	            }
	        }
	        System.out.println("Dozent konnte nicht gefunden werden.");
	    }		
		 
		public void deleteDozent(String name, String nachname) {
		        for (Dozent gesucht : dozentList) {
		            if (gesucht.name.equals(name) && gesucht.nachname.equals(nachname)) {
		                this.dozentList.remove(gesucht);
		                return;// F�r Jede Objekt in dozentList ; if 
                				// gesucht Objekt equals gegebenen Objekt, loesche es.
		            }
		        }
		        System.out.println("Dozent konnte nicht gefunden werden.");
		    } 
		public void addLVA(String lvaname, int lvanummer) {
	        LVA neu = new LVA(lvaname,lvanummer);
	        if (this.lvaList.contains(neu) == false) {
	            lvaList.add(neu);
	            System.out.println("LVA wurder zur System addiert.");
	            return;
	        } else {
	            System.out.println("Dieses LVA ist schon im System gespeichert.");
	        }

	    }
		
		 public void ListLVA() {
		        for (int k = 0; k < this.lvaList.size(); k++) {
		            System.out.println((k + 1) + "." + ((getLVAList().get(k)).toString()) );
		        }

		    }
		public Vector<LVA> getLVAList() {
		        return lvaList;
		   }
			
		  public void printLVAInfo(String inputcode) {
		        for (LVA gesucht : lvaList) {

		            if (gesucht.lvacode.equals(inputcode)) {
		                System.out.println(gesucht.toString());
		                return; // 
		            }
		        }
		        System.out.println("LVA konnte nicht gefunden werden.");
		    }
		  public LVA searchLVA(String inputcode) {
			  for (LVA gesucht : lvaList) {

		            if (gesucht.lvacode.equals(inputcode)) {
		                
		            	
		                return gesucht; // 
		            }
		        }
		        System.out.println("LVA konnte nicht gefunden werden.");
		        return null;
		    }
		  
		  
		  
		  
		  
		  
		  public Student searchStudent(int matrikel) {
		  for (Student gesucht : List) {
			  	int matrikelspeichert = gesucht.getMatrikel();
	            if (matrikelspeichert == (matrikel)) {
	            
	                return gesucht; // 
	            }
	        }
	        System.out.println("Student konnte nicht gefunden werden.");
	        return null;
	    }
		  public Dozent searchDozent(long tc) {
			  for (Dozent gesucht : dozentList) {
				  	long tcspeichert = gesucht.getTc();
		            if (tcspeichert == (tc)) {
		            
		                return gesucht; // 
		            }
		        }
		        System.out.println("Dozent konnte nicht gefunden werden.");
		        return null;
		        
		    }
			  
			  
			  
		  
		  public void deleteLVA(String inputcode) {
		        for (LVA gesucht: lvaList) {
		            if (gesucht.lvacode.equals(inputcode)) {
		                this.lvaList.remove(gesucht);
		                return;
		            }
		        } 
		  }
		  
		  
		 
		 
}


