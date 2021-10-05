package Controllers;

import Model.Mecanic;
import Repositories.MecanicRepository;

public class MecanicController {
    private MecanicRepository mecanici;

    public MecanicController(){
        this.mecanici=new MecanicRepository();
    }

    public void insert(Mecanic mecanic){
        if(mecaniciContains(mecanic.getNume())==false)
            mecanici.insertMecanic(mecanic);
        else
            System.out.println("Mecanicul exista deja, nu poate fi adaugat!");

    }

    public void remove(String nume){
        if(mecanicIDByName(nume)==-1)
            System.out.println("Mecanicul nu a fost gasit!");
        else
            mecanici.removeMecanic(mecanicIDByName(nume));
    }

    public int mecanicIDByName(String name){
        for(Mecanic mec:mecanici.allMecanici())
            if(mec.getNume().equals(name))
                return mec.getId();
        return -1;
    }

    public boolean mecaniciContains(String name){
        for(Mecanic mec:mecanici.allMecanici())
            if(mec.getNume().equals(name)) {
                return true;
            }
        return false;
    }

    public void updateNume(String nume, String numeNou){
        if(mecanicIDByName(nume)==-1)
            System.out.println("Mecanicul nu a fost gasit!");
        else
            mecanici.updateNume(mecanicIDByName(nume),numeNou);
    }

    public void updateParola(String nume, String parolaNou){
        if(mecanicIDByName(nume)==-1)
            System.out.println("Mecanicul nu a fost gasit!");
        else
            mecanici.updateParola(mecanicIDByName(nume),parolaNou);
    }



}


