package Controllers;

import Model.Programare;
import Repositories.ClientRepository;
import Repositories.MecanicRepository;
import Repositories.ProgramareRepository;

import java.util.List;

public class ProgramareController {

    private ProgramareRepository programari;

    public ProgramareController(){
        this.programari=new ProgramareRepository();
    }

    public void insertProgramare(Programare programare) throws Exception {
        if(ClientRepository.containsClient(programare.getClient().getNume())==false)
            throw new Exception("CLientul nu se regaseste in baza de date!");
        else if(MecanicRepository.containsMecanic(programare.getMecanic().getNume())==false)
            throw new Exception("Mecanicul nu se regaseste in baza de date!");
        else {
            int flag = 0;
            for (Programare prog : programari.allProgramari())
                if (prog.equals(programare))
                    flag = 1;
            if (programariContains(Programare.parameterStringConvert(Programare.convertLDTtoStringTFormat(programare.getDataInceput()))) == true)
                System.out.println("Programarea exista deja!");
            else if (flag == 1)
                System.out.println("Programarea se suprapune!");
            else if (programariContains(Programare.parameterStringConvert(Programare.convertLDTtoStringTFormat(programare.getDataInceput()))) == false)
                programari.insertProgramare(programare);
        }
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

    public List<Programare> allProgramari(){
        return programari.allProgramari();
    }









}
