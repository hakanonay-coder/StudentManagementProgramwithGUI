//Hakan ONAY 170504021
import java.util.Arrays;
import java.util.*; 
import java.lang.*;


public class Student extends Person {
	
	private int matrikelnum = 0;
	private double gpa = 0.00;
	private String vorname = "Svorname";
	private String nachname = "Snachname";
	public String[] angemeldet = { "" }; //declare without size
	private int geburtstag = 01;
	private String geburtsmonat = "Januar";
	private int geburtsjahr = 1950;
	private String studiumprogram = "Elektrotechnik";
	private int studiumjahr = 1;
	//Diese sind standartwerte
	
	Student(int matrikelnumuser){
	this.matrikelnum = matrikelnumuser;
	
	}
	Student(int matrikelnumuser, String vornameuser, String nachnameuser ){
		this.matrikelnum = matrikelnumuser;	
		this.vorname = vornameuser;
		this.nachname = nachnameuser;
	}
	@Override 
	
	public String toString(){
			
	        return  matrikelnum +" "+ vorname +" "+ nachname.toUpperCase();
	    }
	public void setMatrikel(int x) {
		matrikelnum = x;
		
	}
	public int getMatrikel() {
		return matrikelnum;
	}
	public void setVorname(String x) {
		vorname = x;
		
	}
	public String getVorname() {
		return vorname;
	}
	public void setNachname(String x) {
		nachname = x;
		
	}
	public String getNachname() {
		return nachname;
	}

    public String[] getAngemeldet() {
        return angemeldet;
    }

    public void setAngemeldet(String[] angemeldet) {
        this.angemeldet = angemeldet;
    }
        
	public void LVAanmelden(String LVAcode) {
		int n = angemeldet.length;
		int i;
		String newarr[] = new String[n+1];
		for(i = 0; i < n; i++) {
					newarr[i] = angemeldet[i];
					newarr[n] = LVAcode;
		}	
                angemeldet = newarr;
		
		System.out.println("Der Student wurde zur " + LVAcode + " angemeldet");
		
		
	}
	public void LVAabmelden(String LVAcode){
		int n = angemeldet.length;
		String[] newArr = null;
		  for(int i = 0; i < n; i++){
	             if(angemeldet[i] == LVAcode){
	                newArr = new String[n - 1];
	                for(int index = 0; index < i; index++){
	                    newArr[index] = angemeldet[index];
	                }
	                for(int j = i; j < n - 1; j++){
	                    newArr[j] = angemeldet[j+1];
	                }
	             }
	         }
                  angemeldet=newArr;
        System.out.println("Der Student von " + LVAcode + " abgemeldet" );
        
        
	}
	public void LVAlisten(){
		int n = angemeldet.length;
		int x;
		System.out.println("Dieser Student ist zur folgenden LVAs angemeldet :"); 
		for (x =0; x < n ; x++) {
			System.out.println(angemeldet[x]); 
		}		
	}
	
	
	
	
	
	

}
