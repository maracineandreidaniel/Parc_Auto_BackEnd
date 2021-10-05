package Controllers;

import Model.Admin;
import Repositories.AdminRepository;

public class AdminController {
    private AdminRepository admini;

    public AdminController(){
        this.admini=new AdminRepository();
    }

    public void insert(Admin admin){
        if(adminiContains(admin.getNume())==false)
         admini.insertAdmin(admin);
        else
            System.out.println("Adminul exista deja, nu poate fi adaugat!");

    }

    public void remove(String nume){
        if(adminIDByName(nume)==-1)
            System.out.println("Adminul nu a fost gasit!");
        else
            admini.removeAdmin(adminIDByName(nume));
    }

    public int adminIDByName(String name){
        for(Admin adm:admini.allAdmini())
            if(adm.getNume().equals(name))
                return adm.getId();
            return -1;
    }

    public boolean adminiContains(String name){
        for(Admin adm:admini.allAdmini())
            if(adm.getNume().equals(name)) {
                return true;
            }
            return false;
    }

    public void updateNume(String nume, String numeNou){
        if(adminIDByName(nume)==-1)
            System.out.println("Adminul nu a fost gasit!");
        else
            admini.updateNume(adminIDByName(nume),numeNou);
    }

    public void updateParola(String nume, String parolaNou){
        if(adminIDByName(nume)==-1)
            System.out.println("Adminul nu a fost gasit!");
        else
            admini.updateParola(adminIDByName(nume),parolaNou);
    }



}


