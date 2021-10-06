package Views;

import Controllers.AdminController;
import Controllers.ClientController;
import Controllers.MecanicController;
import Controllers.ProgramareController;
import Model.Admin;
import Model.Client;
import Model.Mecanic;

import java.util.Scanner;

public class ViewLogin {

    private Scanner scanner;
    private AdminController admini;
    private MecanicController mecanici;
    private ClientController clienti;

    public ViewLogin(){
        this.scanner=new Scanner(System.in);
        this.admini=new AdminController();
        this.clienti=new ClientController();
        this.mecanici=new MecanicController();
    }

    private String meniu(){
        String text="";
        text+="Apasati tasta 0 pentru a incheia\n";
        text+="Apasati tasta 1 pentru a va loga\n";
        return text;
    }

    private void login() throws Exception {

        System.out.println("Introduceti statusul dvs(ex:admin,client,mecanic)");
        String status=scanner.nextLine();
        if(status.equals("admin")==false && status.equals("client")==false && status.equals("mecanic")==false){
            System.out.println("Nu ati introdus un status valid.");
        }else {
            System.out.println("Introduceti numele dvs:");
            String nume = scanner.nextLine();
            System.out.println("Introduceti parola dvs:");
            String parola = scanner.nextLine();

            if (status.equals("admin")) {
                if (admini.adminiContains(nume)==false || admini.findAdmin(nume,parola).getParola().equals(parola)==false){
                    System.out.println("nume sau parola incorecta!");
                } else {
                    Admin a = admini.findAdmin(nume,parola);
                    ViewAdmin viewAdmin=new ViewAdmin(a);
                    viewAdmin.play();

                }
            } else if (status.equals("client")) {
                if (clienti.clientiContains(nume)==false || clienti.findClient(nume,parola).getParola().equals(parola)==false){
                    System.out.println("nume sau parola incorecte!");
                } else {
                    Client c = clienti.findClient(nume,parola);
                    ViewClient client = new ViewClient(c);
                    client.play();

                }
            }

         else if (status.equals("mecanic")) {
            if (mecanici.mecaniciContains(nume)==false || mecanici.findMecanic(nume,parola).getParola().equals(parola)==false) {
                System.out.println("nume sau parola incorecte!");
            } else {
                Mecanic mecanic= mecanici.findMecanic(nume,parola);
                ViewMecanic viewMecanic = new ViewMecanic(mecanic);
                viewMecanic.play();

            }
        }
        }

    }

    public void play() throws Exception {
        System.out.println(meniu());
        boolean run=true;
        while(run){
            int alegere=Integer.parseInt(scanner.nextLine());
            switch (alegere){
                case 0:
                    run=false;
                    break;
                case 1:
                    login();
                    break;
                default:
                    System.out.println(meniu());
            }
        }
    }










}
