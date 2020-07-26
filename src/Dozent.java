//Hakan ONAY 170504021
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class Dozent extends Person {

    public long tc;
    public String[] assigned = {""};

    Dozent(String name, String nachname, long inputTc) {
        this.name = name;
        this.nachname = nachname;
        this.tc = inputTc;

    }

    Dozent(long inputTc) {
        this.tc = inputTc;
    }

    static long controlTc(long a) {

        int tclen = String.valueOf(a).length();
        // Hier wurde gucken wir testid als String un length finden
        if ((tclen == 11) && (a != 0)) {

            return a;

        } else {

            return 0;

        }

    }

    @Override
    public String toString() {

        return name + " " + nachname.toUpperCase() + " " + tc;
    }

    public void setTc(long input) {

        this.tc = input;

    }

    public long getTc() {

        return tc;
    }

    public void setVorName(String input) {

        this.name = input;

    }

    public String getVorName() {

        return name;
    }

    public void setNachName(String input) {

        this.nachname = input;

    }

    public String getNachName() {

        return nachname;
    }
    
    public void LVAassign(String LVAcode) {
        int n = assigned.length;
        int i;
        String newarr[] = new String[n+1];
        for (i = 0; i < n; i++) {
            newarr[i] = assigned[i];
            newarr[n] = LVAcode;  
        }
        assigned = newarr;
        System.out.println("Der Dozent zur" + LVAcode + "zugewiesen");

    }

    public void LVAunassign(String LVAcode) {
        int n = assigned.length;
        String[] newArr = null;
        newArr = new String[n - 1];
        for (int i = 0; i < n; i++) {
            if (assigned[i].equals(LVAcode)) {
                
                for (int index = 0; index < i; index++) {
                    newArr[index] = assigned[index];
                }
                for (int j = i; j < n - 1; j++) {
                    newArr[j] = assigned[j + 1];
                    
                }
            }
            
        }
        assigned=newArr;

        System.out.println("Der Dozent von " + LVAcode + "abgewiesen");

    }

    public String[] getAssigned() {
        return assigned;
    }

    public void setAssigned(String[] assigned) {
        this.assigned = assigned;
    }

    public void assignedLVAs() {
        int n = assigned.length;
        int x;
        for (x = 0; x < n; x++) {
            System.out.println(assigned[x]);

        }
    }

}
