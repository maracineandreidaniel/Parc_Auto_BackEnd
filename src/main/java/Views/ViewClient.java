package Views;

import Controllers.ClientController;
import Controllers.ProgramareController;
import Model.Client;
import Model.Mecanic;
import Model.Programare;
import Repositories.MecanicRepository;

import java.util.List;
import java.util.Scanner;

public class ViewClient {

    private Scanner scanner;
    private Client client;
    private ClientController clienti;
    private ProgramareController programari;
    private MecanicRepository mecanici;

    public ViewClient(Client client){
        this.client=client;
        scanner=new Scanner(System.in);
        clienti=new ClientController();
        programari=new ProgramareController();
        mecanici=new MecanicRepository();
    }

    private String meniu(){
        String text="";
        text+="Apasati 0 pentru a incheia.\n";
        text+="Apasati tasta 1 pentru a vizualiza toate programarile dumneavoastra.\n";
        text+="Apasati tasta 2 pentru a face o programare.\n";
        text+="Apasati tasta 3 pentru a anula o programare.\n";
        return text;
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
                    programariClient(client.getNume());
                    break;
                case 2:
                    addProgramareClient();
                    break;
                case 3:
                    anulareRezervare();
                    break;
            }
        }
    }

    public void programariClient(String nume){
        List<Programare> lista=programari.allProgramari();
        for(Programare p:lista)
            if(p.getClient().getNume().equals(nume))
                System.out.println(p);
    }

    public void addProgramareClient() throws Exception {
        System.out.println("Introduceti data de inceput a programarii:");
        System.out.println("Format: D,M,YYYY,H,M");
        String di=scanner.next();
        System.out.println("Introduceti data de final a programarii:");
        System.out.println("Format: D,M,YYYY,H,M");
        String ds=scanner.next();
        System.out.println("Introduceti numele mecanicului la care doriti sa va faceti programare:");
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
            if(p.getClient().getNume().equals(client.getNume()) && Programare.parameterStringConvert(Programare.convertLDTtoStringTFormat(p.getDataInceput())).equals(di))
                programari.removeProgramare(Programare.parameterStringConvert(Programare.convertLDTtoStringTFormat(p.getDataInceput())));
    }






}
