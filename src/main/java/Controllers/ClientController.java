package Controllers;

import Model.Client;
import Model.Mecanic;
import Repositories.ClientRepository;

public class ClientController {
    private ClientRepository clienti;

    public ClientController(){
        this.clienti=new ClientRepository();
    }

    public void insert(Client client){
        if(clientiContains(client.getNume())==false)
            clienti.insertClient(client);
        else
            System.out.println("Clientul exista deja, nu poate fi adaugat!");

    }

    public void remove(String nume){
        if(clientIDByName(nume)==-1)
            System.out.println("Clientul nu a fost gasit!");
        else
            clienti.removeClient(clientIDByName(nume));
    }

    public int clientIDByName(String name){
        for(Client cli:clienti.allClienti())
            if(cli.getNume().equals(name))
                return cli.getId();
        return -1;
    }

    public boolean clientiContains(String name){
        for(Client cli:clienti.allClienti())
            if(cli.getNume().equals(name)) {
                return true;
            }
        return false;
    }

    public void updateNume(String nume, String numeNou){
        if(clientIDByName(nume)==-1)
            System.out.println("Clientul nu a fost gasit!");
        else
            clienti.updateNume(clientIDByName(nume),numeNou);
    }

    public void updateParola(String nume, String parolaNou){
        if(clientIDByName(nume)==-1)
            System.out.println("Clientul nu a fost gasit!");
        else
            clienti.updateParola(clientIDByName(nume),parolaNou);
    }

    public Client findClient(String name, String parola){
        for(Client c:clienti.allClienti())
            if(c.getNume().equals(name) && c.getParola().equals(parola))
                return c;
        System.out.println("Clientul nu a fost gasit in baza de date!");
        return null;

    }



}


