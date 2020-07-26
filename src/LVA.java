//Hakan ONAY 170504021
import java.util.Arrays;
import java.util.List;

public class LVA {

    String lvacode;
    String lvaname = "INF";
    int lvanummer = 000;
    int matrikel[] = {};
    long tcnums[] = {};

    LVA(String lvaname, int lvanummer) {
        this.lvaname = lvaname;
        this.lvanummer = lvanummer;
        this.lvacode = lvaname + lvanummer;

    }

    static String controlLVA(String lvaname, int lvanummer) {

        int lvalength = lvaname.length();
        int lvanummerlen = String.valueOf(lvanummer).length();

        if (lvaname.equals(lvaname.toUpperCase()) && lvalength == 3 && lvanummerlen == 3) {
            String lvaall1 = lvaname + lvanummer;
            return lvaall1;

            // input is all upper case
        } else {

            return "null";

            // input is falsch
        }
    }

    @Override
    public String toString() {
        return lvacode;
    }

    public int[] addStudentMatrikel(int matrikelnum) {
        int n = matrikel.length;
        int i;
        int newarr[] = new int[n + 1];
        for (i = 0; i < n; i++) {
            newarr[i] = matrikel[i];
            newarr[n] = matrikelnum;
            matrikel = newarr;

        }
        return matrikel;

    }

    public void addDozentTC(long tc) {
        int n = tcnums.length;
        int i;
        long newarr[] = new long[n + 1];
        for (i = 0; i < n; i++) {
            newarr[i] = tcnums[i];
            newarr[n] = tc;
            tcnums = newarr;

        }

    }

    public void matrikelRemove(int inputmatrikel) {
        int n = matrikel.length;
        int[] newArr = null;
        for (int i = 0; i < n; i++) {
            if (matrikel[i] == inputmatrikel) {
                newArr = new int[n - 1];
                for (int index = 0; index < i; index++) {
                    newArr[index] = matrikel[index];
                }
                for (int j = i; j < n - 1; j++) {
                    newArr[j] = matrikel[j + 1];
                }
                break;
            }
        }
    }

    public void tcRemove(long inputtc) {
        int x;
        List a1 = Arrays.asList(tcnums);
        a1.remove(inputtc);
        for (x = 0; x < a1.size(); x++) {
            tcnums[x] = Long.parseLong(a1.get(x).toString());
        }
    }

    public void matrikelListen() {
        int n = matrikel.length;
        int x;
        for (x = 0; x < n; x++) {
            System.out.println(matrikel[x]);

        }
    }

    public void tcListen() {
        int n = tcnums.length;
        int x;
        for (x = 0; x < n; x++) {
            System.out.println(tcnums[x]);

        }
    }

    public String getLVAName() {
        return this.lvaname;
    }

    public int getLVANummer() {
        return this.lvanummer;
    }

    public String getLVACode() {
        return this.lvacode;
    }

    public void setLVAName(String x) {
        this.lvaname = x;
    }

    public void setLVANummer(int x) {
        this.lvanummer = x;
    }

    public void setLvacode(String lvacode) {
        this.lvacode = lvacode;
    }
    

}
