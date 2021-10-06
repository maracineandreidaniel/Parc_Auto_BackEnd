package Views;

import Controllers.AdminController;
import Controllers.ClientController;
import Controllers.MecanicController;
import Controllers.ProgramareController;
import Model.Admin;
import Model.Client;
import Model.Mecanic;
import Model.Programare;
import Repositories.ClientRepository;

import java.util.Scanner;

public class ViewAdmin {

    private Admin admin;
    private Scanner scanner;
    private ProgramareController programari;
    private ClientController clienti;
    private MecanicController mecanici;
    private AdminController admini;


    public ViewAdmin(Admin admin){
        this.admin=admin;
        scanner=new Scanner(System.in);
        programari=new ProgramareController();
        clienti=new ClientController();
        admini=new AdminController();
    }

    private String meniu(){
        String text="";
        text+="Apasati 0 pentru a incheia.\n";
        text+="Apasati 1 pentru a vizualiza toate programarile.\n";
        text+="Apasati 2 pentru a face o programare.\n";
        text+="Apasati 3 pentru a anula o programare.\n";
        text+="Apasati 4 pentru a edita inceputul unei programari.\n";
        text+="Apasati 5 pentru a edita sfarsitul unei programari.\n";
        text+="Apasati 6 pentru a edita numele unui client.\n";
        text+="Apasati 7 pentru a edita parola unui client.\n";
        text+="Apasati 8 pentru a edita numele unui mecanic.\n";
        text+="Apasati 9 pentru a edita parola unui mecanic.\n";
        text+="Apasati 10 pentru a edita numele unui admin.\n";
        text+="Apasati 11 pentru a edita parola unui admin.\n";
        text+="Apasati 12 pentru a insera un client.\n";
        text+="Apasati 13 pentru a insera un mecanic.\n";
        text+="Apasati 14 pentru a insera un admin.\n";
        text+="Apasati 15 pentru a sterge un client.\n";
        text+="Apasati 16 pentru a sterge un mecanic.\n";
        text+="Apasati 17 pentru a sterge un admin.\n";
        return text;
    }

    public void addProgramareAdmin() throws Exception {
        System.out.println("Introduceti data de inceput a programarii:");
        System.out.println("Format: D,M,YYYY,H,M");
        String di=scanner.next();
        System.out.println("Introduceti data de final a programarii:");
        System.out.println("Format: D,M,YYYY,H,M");
        String ds=scanner.next();
        System.out.println("Introduceti numele clientului la care doriti sa faceti programare:");
        String cli=scanner.next();
        Client client=new Client(cli);
        System.out.println("Introduceti numele mecanicului la care doriti sa faceti programare:");
        String mec=scanner.next();
        Mecanic mecanic=new Mecanic(mec);
        Programare programare=new Programare(Programare.convertStringLocalDateTime(di),Programare.convertStringLocalDateTime(ds),mecanic,client);
        programari.insertProgramare(programare);
    }

    public void anulareRezervare(){
        System.out.println("Introduceti data de inceput a programarii:");
        System.out.println("Format: DD,MM,YYYY,HH,MM");
        String di=scanner.next();
        for(Programare p: programari.allProgramari())
            if(Programare.parameterStringConvert(Programare.convertLDTtoStringTFormat(p.getDataInceput())).equals(di))
                programari.removeProgramare(Programare.parameterStringConvert(Programare.convertLDTtoStringTFormat(p.getDataInceput())));
    }


    public void editareDataInceput(){
        System.out.println("Introduceti data de inceput a programarii:");
        System.out.println("Format: DD,MM,YYYY,HH,MM");
        String di=scanner.next();
        System.out.println("Introduceti noua data de inceput a programarii:");
        System.out.println("Format: DD,MM,YYYY,HH,MM");
        String diNou=scanner.next();
        for(Programare p: programari.allProgramari())
            if(Programare.parameterStringConvert(Programare.convertLDTtoStringTFormat(p.getDataInceput())).equals(di))
                programari.updateDataInceput(Programare.parameterStringConvert(Programare.convertLDTtoStringTFormat(p.getDataInceput())),diNou);
    }


    public void editareDataSfarsit(){
        System.out.println("Introduceti data de inceput a programarii:");
        System.out.println("Format: DD,MM,YYYY,HH,MM");
        String di=scanner.next();
        System.out.println("Introduceti noua data de sfarsit a programarii:");
        System.out.println("Format: DD,MM,YYYY,HH,MM");
        String dsNou=scanner.next();
        for(Programare p: programari.allProgramari())
            if(Programare.parameterStringConvert(Programare.convertLDTtoStringTFormat(p.getDataInceput())).equals(di))
                programari.updateDataSfarsit(Programare.parameterStringConvert(Programare.convertLDTtoStringTFormat(p.getDataInceput())),dsNou);
    }

    public void editNumeClient(){
        System.out.println("Introduceti numele clientului:");
        String nV=scanner.next();
        System.out.println("Introduceti noul nume al clientului:");
        String nN=scanner.next();
        clienti.updateNume(nV,nN);
    }

    public void editParolaClient(){
        System.out.println("Introduceti numele clientului:");
        String n=scanner.next();
        System.out.println("Introduceti noua parola a clientului:");
        String p=scanner.next();
        clienti.updateParola(n,p);
    }

    public void editNumeMecanic(){
        System.out.println("Introduceti numele mecanicului:");
        String nV=scanner.next();
        System.out.println("Introduceti noul nume al mecanicului:");
        String nN=scanner.next();
        mecanici.updateNume(nV,nN);
    }

    public void editParolaMecanic(){
        System.out.println("Introduceti numele mecanicului:");
        String n=scanner.next();
        System.out.println("Introduceti noua parola a mecanicului:");
        String p=scanner.next();
        mecanici.updateParola(n,p);
    }

    public void editNumeAdmin(){
        System.out.println("Introduceti numele adminului:");
        String nV=scanner.next();
        System.out.println("Introduceti noul nume al adminului:");
        String nN=scanner.next();
        admini.updateNume(nV,nN);
    }

    public void editParolaAdmin(){
        System.out.println("Introduceti numele adminului:");
        String n=scanner.next();
        System.out.println("Introduceti noua parola a adminului:");
        String p=scanner.next();
        admini.updateParola(n,p);
    }

    public void insertClient(){
        System.out.println("Introduceti numele clientului:");
        String n=scanner.next();
        System.out.println("Introduceti parola clientului:");
        String p=scanner.next();
        Client client=new Client(n,p);
        clienti.insert(client);
    }

    public void insertMecanic(){
        System.out.println("Introduceti numele mecanicului:");
        String n=scanner.next();
        System.out.println("Introduceti parola mecanicului:");
        String p=scanner.next();
        Mecanic mecanic=new Mecanic(n,p);
        mecanici.insert(mecanic);
    }

    public void insertAdmin(){
        System.out.println("Introduceti numele adminului:");
        String n=scanner.next();
        System.out.println("Introduceti parola adminului:");
        String p=scanner.next();
        Admin admin=new Admin(n,p);
        admini.insert(admin);
    }

    public void removeClient(){
        System.out.println("Introduceti numele clientului:");
        String n=scanner.next();
        clienti.remove(n);
    }

    public void removeMecanic(){
        System.out.println("Introduceti numele mecanicului:");
        String n=scanner.next();
       mecanici.remove(n);
    }

    public void removeAdmin(){
        System.out.println("Introduceti numele adminului:");
        String n=scanner.next();
        admini.remove(n);
    }

    public void afisareProgramari(){
        for(Programare p:programari.allProgramari())
            System.out.println(p);
    }


    public void play() throws Exception {
        System.out.println(meniu());
        boolean run=true;
        while(run){
            int alegere=scanner.nextInt();
            switch (alegere){
                case 0:
                    run=false;
                    break;
                case 1:
                    afisareProgramari();
                    break;
                case 2:
                  addProgramareAdmin();
                    break;
                case 3:
                   anulareRezervare();
                    break;
                case 4:
                    editareDataInceput();
                    break;
                case 5:
                    editareDataSfarsit();
                    break;
                case 6:
                   editNumeClient();
                    break;
                case 7:
                    editParolaClient();
                    break;
                case 8:
                   editNumeMecanic();
                    break;
                case 9:
                   editParolaMecanic();
                    break;
                case 10:
                   editNumeAdmin();
                    break;
                case 11:
                    editParolaAdmin();
                    break;
                case 12:
                    insertClient();
                    break;
                case 13:
                    insertMecanic();
                    break;
                case 14:
                    insertAdmin();
                    break;
                case 15:
                    removeClient();
                    break;
                case 16:
                   removeMecanic();
                    break;
                case 17:
                   removeAdmin();
                    break;

            }
        }
    }








}
