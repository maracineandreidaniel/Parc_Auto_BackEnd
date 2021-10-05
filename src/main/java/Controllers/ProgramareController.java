package Controllers;

import Model.Programare;
import Repositories.ProgramareRepository;

public class ProgramareController {

    private ProgramareRepository programari;

    public ProgramareController(){
        this.programari=new ProgramareRepository();
    }

    public void insertProgramare(Programare programare){
        if(programariContains(Programare.parameterStringConvert(Programare.convertLDTtoStringTFormat(programare.getDataInceput())))==false)
            programari.insertProgramare(programare);
        else
            System.out.println("Programarea exista deja!");
    }

    public Programare programareByDI(String dataInceput){
        for(Programare prog:programari.allProgramari())
            if(Programare.parameterStringConvert(Programare.convertLDTtoStringTFormat(prog.getDataInceput())).equals(dataInceput))
                return prog;
            return null;
    }

    public boolean programariContains(String prg){
        for(Programare programare:programari.allProgramari())
            if(Programare.parameterStringConvert(Programare.convertLDTtoStringTFormat(programare.getDataInceput())).equals(prg))
                return true;
            return false;
    }

    public void removeProgramare(String di){
        if(programariContains(Programare.parameterStringConvert(Programare.convertLDTtoStringTFormat(programareByDI(di).getDataInceput())))==true)
            programari.removeProgramare(programareByDI(di).getProgramare_id());
        else
            System.out.println("Programarea nu exista!");
    }



    public void updateDataInceput(String di, String nouDI){
        if(programariContains(Programare.parameterStringConvert(Programare.convertLDTtoStringTFormat(programareByDI(di).getDataInceput())))==true)
            programari.updateDataInceput(programareByDI(di).getProgramare_id(),nouDI);
        else
            System.out.println("Programarea nu exista!");
    }

    public void updateDataSfarsit(String di, String nouDS){
        if(programariContains(Programare.parameterStringConvert(Programare.convertLDTtoStringTFormat(programareByDI(di).getDataInceput())))==true)
            programari.updateDataSfarsit(programareByDI(di).getProgramare_id(),nouDS);
        else
            System.out.println("Programarea nu exista!");
    }









}
