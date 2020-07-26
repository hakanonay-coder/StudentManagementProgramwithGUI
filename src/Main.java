//Hakan ONAY 170504021
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        University uni = new University();
        // Temporary university object to reach the objects

        int operation = 0;
        while (operation != 24) {
            System.out.println("Which operation you want to do?");
            System.out.println("1- Add Student");
            System.out.println("2- List Students");
            System.out.println("3- Search Student");
            System.out.println("4- Student-Info Edit");
            System.out.println("5- Delete Student");
            System.out.println("6- Assign Student to Lesson ");
            System.out.println("7- Unassign Student from Lesson");
            System.out.println("8- List all Lessons of a Student");

            System.out.println("9- Add Dozent"); // Dozent == Do�ent
            System.out.println("10- List all Dozents");
            System.out.println("11- Search Dozent");
            System.out.println("12- Edit Dozent Info");
            System.out.println("13- Delete Dozent");
            System.out.println("14- Assign Dozent to a Lesson");
            System.out.println("15- Unassign Dozent from a Lesson");
            System.out.println("16- List all Lessons of a Dozent");
            System.out.println("17- Add Lesson");
            System.out.println("18- List Lesson");
            System.out.println("19- Search for A lesson");
            System.out.println("20- Edit Lesson Information");
            System.out.println("21- Delete Lesson");
            System.out.println("22- Show all students of a Lesson");
            System.out.println("23- Show all responsible Dozents of a lesson");
            System.out.println("24- End Program");

            Scanner input = new Scanner(System.in);
            operation = input.nextInt();

            switch (operation) {
                case 1:
                    int testid;
                    int id = 0;
                    String vorname = "";
                    String nachname = "";
                    //vorname == name
                    //nachname == surname

                    System.out.println("Student number : ");
                    testid = input.nextInt();
                    int testidlength = String.valueOf(testid).length();
                    //It must have a length of 7 so we are testing it
                    if ((testidlength == 7) && (testid != 0)) {

                        id = testid;

                    } else {

                        System.out.println("False input for Student Number");
                        break;
                    }

                    System.out.println("If you know name and surname press 1, when you dont 2.");
                    int x = input.nextInt();
                    // Program can add Students only with Studentnumber
                    //Name and Surname are additional.
                    if (x == 1) {
                        System.out.println("Name :");
                        vorname = input.next();
                        System.out.println("Surname :");
                        nachname = input.next();

                        Student mainstud = new Student(id, vorname, nachname);
                        // eine Erreich-Mittel als Student

                        if (uni.control(mainstud) == false) {
                            uni.addStudent(id, vorname, nachname);
                            //Add it to Student vector, where all students are being saved

                        } else {
                            System.out.println("This student is already in the system");

                        }

                    } else {
                        Student mainstud = new Student(id);
                        if (uni.control(mainstud) == false) {

                            uni.addStudent(id, vorname, nachname);

                        } else {
                            System.out.println("This student is already in the system");

                        }

                    }

                    break;

                case 2:

                    uni.listStudent();
                    break;

                case 3:
                    System.out.println("Student number of the Searched student :");
                    int gesuchte = input.nextInt();
                    Student y = new Student(gesuchte);
                    y = uni.searchStudent(gesuchte);
                    if (y == null) {

                        break;

                    }

                    String info = y.toString();
                    System.out.println(info);
                    break;

                case 4:
                    //edit student info
                    int option = 0;

                    System.out.println("Which information do you want to edit");
                    System.out.println("1- Student Number");
                    System.out.println("2- Name");
                    System.out.println("3- Surname");
                    Scanner t = new Scanner(System.in);
                    option = t.nextInt();

                    if (option == 1) {
                        System.out.println("Student Number of the Student you want to edit :");
                        int smatrikel = input.nextInt();
                        System.out.println("New Student number : ");
                        int newmatrikel = input.nextInt();
                        Student s = new Student(0);
                        s = uni.searchStudent(smatrikel);
                        if (s == null) {
                            break;
                        }
                        s.setMatrikel(newmatrikel);
                        break;

                    } else if (option == 2) {
                        System.out.println("Student Number of the Student you want to edit :");
                        int smatrikel = input.nextInt();
                        System.out.println("New Name :");
                        String nvorname = input.next();
                        Student s = new Student(0);
                        s = uni.searchStudent(smatrikel);
                        if (s == null) {
                            break;
                        }
                        s.setVorname(nvorname);
                        break;
                    } else if (option == 3) {
                        System.out.println("Student Number of the Student you want to edit :");
                        int smatrikel = input.nextInt();
                        System.out.println("New Surname");
                        String neuNachName = input.next();
                        Student s = new Student(0);
                        s = uni.searchStudent(smatrikel);
                        if (s == null) {
                            break;
                        }
                        s.setNachname(neuNachName);
                        break;
                    } else {
                        System.out.println("False Input. Please select one of these options.");
                        break;
                    }

                case 5:
                    System.out.println("Studentnumber to delete:  ");
                    id = input.nextInt();
                    uni.deleteStudent(id);
                    break;

                case 9:
                    System.out.println("TC Number of Dozent :");
                    long testtc = input.nextLong();
                    long maintc = Dozent.controlTc(testtc);
                    //Controlling whether the TC Number is 11 digits.
                    System.out.println("Name :");
                    String dozentname = input.next();
                    System.out.println("Surname :");
                    String dozentnachname = input.next();

                    if (maintc == testtc) {
                        uni.addDozent(dozentname, dozentnachname, maintc);

                    } else {
                        System.out.println("False input for TC Nummer");

                    }
                    break;

                case 10:

                    uni.listDozent();
                    break;

                case 11:
                    //search dozent
                    System.out.println("Searched Dozent Name :");
                    vorname = input.nextLine();
                    System.out.println("Searched Dozent Surname :");
                    nachname = input.nextLine();

                    uni.printDozentInfo(vorname, nachname);
                    break;

                case 12: //dozent info bearbeiten
                    System.out.println("Which information you want to edit?");
                    System.out.println("1- TC");
                    System.out.println("2- Name");
                    System.out.println("3- Surname");
                    t = new Scanner(System.in);
                    option = t.nextInt();

                    if (option == 1) {
                        System.out.println("Type the Saved TC Number :");
                        long stc = input.nextLong();
                        System.out.println("Type the New TC Number:");
                        long ntc = input.nextLong();
                        Dozent s = new Dozent(0);
                        s = uni.searchDozent(stc);
                        if (s == null) {
                            break;
                        }
                        s.setTc(ntc);
                        break;

                    } else if (option == 2) {
                        System.out.println("Type the selected Dozents TC Number :");
                        long stc = input.nextLong();
                        System.out.println("New Name :");
                        String nVorName = input.next();
                        Dozent s = new Dozent(0);
                        s = uni.searchDozent(stc);
                        if (s == null) {
                            break;
                        }
                        s.setVorName(nVorName);
                        break;
                    } else if (option == 3) {
                        System.out.println("Type the selected Dozents TC Number :");
                        long stc = input.nextLong();
                        System.out.println("New Surname:");
                        String nNachName = input.next();
                        Dozent s = new Dozent(0);
                        s = uni.searchDozent(stc);
                        if (s == null) {
                            break;
                        }
                        s.setNachName(nNachName);
                        break;
                    } else {
                        System.out.println("False input for TC Nummer");
                        break;
                    }

                case 13:

                    System.out.println("Dozent name :");
                    vorname = input.nextLine();
                    System.out.println("Dozent surname:");
                    nachname = input.nextLine();
                    uni.deleteDozent(vorname, nachname);
                    break;

                case 17:
                    //LVA == Lesson
                    System.out.println("Lesson Name : ");
                    String mainLVAname = input.next();

                    System.out.println("Lesson Surname :");
                    int mainLVAnummer = input.nextInt();

                    String LVAcode = LVA.controlLVA(mainLVAname, mainLVAnummer);
                    //Controlling the Lesson name, it must be given as : INF101 Or MAT204 etc
                    if (LVAcode == "null") {

                        System.out.println("False Input for Lesson");
                        break;
                    } else {
                        uni.addLVA(mainLVAname, mainLVAnummer);
                        break;
                    }

                case 18:
                    uni.ListLVA();
                    break;

                case 19:
                    System.out.println("Code of the searched Lesson: (Bsp : INF202");
                    String gesuchtcode = input.next();

                    uni.printLVAInfo(gesuchtcode);
                    break;

                case 20:
                    // LVA Info Bearbeiten
                    System.out.println("Which information of the Lesson You want to edit?");
                    System.out.println("1- Name (BSP: ETE)");
                    System.out.println("2- Nummer (BSP: 202");

                    t = new Scanner(System.in);
                    option = t.nextInt();

                    if (option == 1) {
                        System.out.println("Please type name of the Lesson you want to edit.");
                        String snam = input.next();
                        System.out.println("Please type the number of the Lesson you want to edit.");
                        int snum = input.nextInt();
                        System.out.println("New Lesson Name:");
                        String nLvaName = input.next();
                        LVA s = new LVA(snam, snum);
                        s = uni.searchLVA(s.getLVACode());
                        if (s == null) {
                            break;
                        }
                        s.setLVAName(nLvaName);
                        break;

                    } else if (option == 2) {
                        System.out.println("Please type name of the Lesson you want to edit.");
                        String snam = input.next();
                        System.out.println("Please type the number of the Lesson you want to edit.");
                        int snum = input.nextInt();
                        System.out.println("New Lesson Number:");
                        int nLvaNummer = input.nextInt();
                        LVA s = new LVA(snam, snum);
                        s = uni.searchLVA(s.getLVACode());
                        if (s == null) {
                            break;
                        }
                        s.setLVANummer(nLvaNummer);
                        break;
                    } else {
                        System.out.println("False Input. Please select one of the options.");
                        break;
                    }
                case 21:
                    System.out.println("Code of the selected Lesson: (Bsp : INF202)");
                    String deletecode = input.next();

                    uni.deleteLVA(deletecode);
                    break;
                case 6://Student zur LVA
                    System.out.println("Selected Student number :");
                    int matrikelnummer = input.nextInt();
                    Student a = new Student(0);
                    a = uni.searchStudent(matrikelnummer);
                    if (a == null) {

                        break;

                    }
                    int matrikelA = a.getMatrikel();

                    System.out.println("Name of the Lesson : (z.b. INF)");
                    String lvaName = input.next();
                    System.out.println("Number of the Lesson : (z.b. 202)");
                    int lvaNummer = input.nextInt();
                    LVA lva = new LVA(lvaName, lvaNummer);
                    String lvaCode = lva.lvacode;
                    lva = uni.searchLVA(lvaCode);
                    if (lva == null) {

                        break;

                    }
                    String b = lva.lvacode;

                    a.LVAanmelden(b);
                    lva.addStudentMatrikel(matrikelA);
                    break;

                case 7: // Abmelden von LVA
                    System.out.println("Selected Student number :");
                    matrikelnummer = input.nextInt();
                    a = new Student(matrikelnummer);
                    a = uni.searchStudent(matrikelnummer);
                    if (a == null) {

                        break;

                    }
                    matrikelA = a.getMatrikel();

                    System.out.println("Name of the Lesson : (z.b. INF)");
                    lvaName = input.next();
                    System.out.println("Number of the Lesson : (z.b. 202)");
                    lvaNummer = input.nextInt();
                    lva = new LVA(lvaName, lvaNummer);
                    lvaCode = lva.lvacode;
                    lva = uni.searchLVA(lvaCode);
                    if (lva == null) {

                        break;

                    }
                    b = lva.lvacode;

                    a.LVAabmelden(b);
                    lva.matrikelRemove(matrikelA);
                    break;

                case 8: // list lvas
                    System.out.println("Student number of the Selected Student :");
                    matrikelnummer = input.nextInt();
                    a = new Student(matrikelnummer);
                    a = uni.searchStudent(matrikelnummer);
                    if (a == null) {

                        break;

                    }
                    a.LVAlisten();
                    break;

                case 14: //dozent zur lva
                    System.out.println("TC number of selected Dozent :");
                    long tcinput = input.nextLong();
                    Dozent dz = new Dozent(tcinput);
                    dz = uni.searchDozent(tcinput);
                    if (dz == null) {
                        break;
                    }
                    long tcToAdd = dz.getTc();
                    System.out.println("Name of the Lesson : (z.b. INF)");
                    lvaName = input.next();
                    System.out.println("Number of the Lesson : (z.b. 202)");
                    lvaNummer = input.nextInt();
                    LVA dzLva = new LVA(lvaName, lvaNummer);
                    lvaCode = dzLva.lvacode;
                    dzLva = uni.searchLVA(lvaCode);
                    if (dzLva == null) {
                        break;
                    }
                    String lvaCode1 = dzLva.lvacode;
                    dz.LVAassign(lvaCode1);
                    dzLva.addDozentTC(tcToAdd);
                    break;

                case 15: //delete dozent von lva
                    System.out.println("TC number of selected Dozent :");
                    tcinput = input.nextLong();
                    dz = new Dozent(tcinput);
                    dz = uni.searchDozent(tcinput);
                    if (dz == null) {
                        break;
                    }
                    long tcToDelete = dz.getTc();
                    System.out.println("Name of the Lesson : (z.b. INF)");
                    lvaName = input.next();
                    System.out.println("Number of the Lesson : (z.b. 202)");
                    lvaNummer = input.nextInt();
                    dzLva = new LVA(lvaName, lvaNummer);
                    lvaCode = dzLva.lvacode;
                    dzLva = uni.searchLVA(lvaCode);
                    if (dzLva == null) {
                        break;
                    }
                    lvaCode1 = dzLva.lvacode;
                    dz.LVAassign(lvaCode1);
                    dzLva.tcRemove(tcToDelete);
                    break;

                case 16: // list lvas von dozent
                    System.out.println("TC number of selected Dozent :");
                    long tcToList = input.nextLong();
                    Dozent listDozent = new Dozent(0);
                    listDozent = uni.searchDozent(tcToList);
                    if (listDozent == null) {

                        break;

                    }
                    listDozent.assignedLVAs();
                    break;

                case 22:
                    // matrikel listen von LVA
                    System.out.println("Name of the Lesson : (z.b. INF)");
                    lvaName = input.next();
                    System.out.println("Number of the Lesson : (z.b. 202)");
                    lvaNummer = input.nextInt();
                    LVA lva1 = new LVA(lvaName, lvaNummer);
                    String code = lva1.lvacode;
                    lva1 = uni.searchLVA(code);
                    if (lva1 == null) {
                        System.out.println("Lesson couldn't be found.");
                        break;
                    }
                    lva1.matrikelListen();
                    break;

                case 23: //tcs listen
                    System.out.println("Name of the Lesson : (z.b. INF)");
                    lvaName = input.next();
                    System.out.println("Number of the Lesson : (z.b. 202)");
                    lvaNummer = input.nextInt();
                    lva1 = new LVA(lvaName, lvaNummer);
                    code = lva1.lvacode;
                    lva1 = uni.searchLVA(code);
                    if (lva1 == null) {
                        System.out.println("Lesson couldn't be found.");
                        break;
                    }
                    lva1.tcListen();
                    break;
                case 24:
                    System.out.println("Program has been ended.");
                    break;

            }
        }

    }
}
