package Views;

import Controllers.ClientController;
import Controllers.MecanicController;
import Controllers.ProgramareController;
import Model.Client;
import Model.Mecanic;
import Model.Programare;

import java.util.List;
import java.util.Scanner;

public class ViewMecanic {

    private Mecanic mecanic;
    private MecanicController mecanici;
    private ProgramareController programari;
    private ClientController clienti;
    private Scanner scanner;

    public ViewMecanic(Mecanic mec){
        mecanic=mec;
        mecanici=new MecanicController();
        programari=new ProgramareController();
        clienti=new ClientController();
        scanner=new Scanner(System.in);
    }

    private String meniu(){
        String text="";
        text+="Apasati 0 pentru a incheia.\n";
        text+="Apasati tasta 1 pentru a vizualiza toate programarile dumneavoastra.\n";
        text+="Apasati tasta 2 pentru a face o programare.\n";
        text+="Apasati tasta 3 pentru a anula o programare.\n";
        text+="Apasati tasta 4 pentru a edita inceputul unei programari.\n";
        text+="Apasati tasta 5 pentru a edita sfarsitul unei programari.\n";
        return text;
    }

    public void programariMecanic(){
        List<Programare> lista=programari.allProgramari();
        for(Programare p:lista)
            if(p.getMecanic().getNume().equals(mecanic.getNume()))
                System.out.println(p);
    }

    public void addProgramareClient() throws Exception {
        System.out.println("Introduceti data de inceput a programarii:");
        System.out.println("Format: D,M,YYYY,H,M");
        String di=scanner.next();
        System.out.println("Introduceti data de final a programarii:");
        System.out.println("Format: D,M,YYYY,H,M");
        String ds=scanner.next();
        System.out.println("Introduceti numele clientului la care doriti sa va faceti programare:");
        String cli=scanner.next();
        Client client=new Client(cli);
        Programare programare=new Programare(Programare.convertStringLocalDateTime(di),Programare.convertStringLocalDateTime(ds),mecanic,client);
        programari.insertProgramare(programare);
    }

    public void anulareRezervare(){
        System.out.println("Introduceti data de inceput a programarii:");
        System.out.println("Format: DD,MM,YYYY,HH,MM");
        String di=scanner.next();
        for(Programare p: programari.allProgramari())
            if(p.getMecanic().getNume().equals(mecanic.getNume()) && Programare.parameterStringConvert(Programare.convertLDTtoStringTFormat(p.getDataInceput())).equals(di))
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
            if(p.getMecanic().getNume().equals(mecanic.getNume()) && Programare.parameterStringConvert(Programare.convertLDTtoStringTFormat(p.getDataInceput())).equals(di))
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
            if(p.getMecanic().getNume().equals(mecanic.getNume()) && Programare.parameterStringConvert(Programare.convertLDTtoStringTFormat(p.getDataInceput())).equals(di))
                programari.updateDataSfarsit(Programare.parameterStringConvert(Programare.convertLDTtoStringTFormat(p.getDataInceput())),dsNou);
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
                    programariMecanic();
                    break;
                case 2:
                    addProgramareClient();
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
            }
        }
    }






}
