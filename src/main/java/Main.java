import Controllers.AdminController;
import Controllers.ProgramareController;
import Model.Admin;
import Model.Client;
import Model.Programare;
import Repositories.AdminRepository;
import Repositories.ClientRepository;
import Repositories.ProgramareRepository;

import java.sql.SQLException;

public class Main {


    public static void main(String[] args) throws SQLException {

        ProgramareController programareController=new ProgramareController();
        Programare p1=new Programare(8,"11,08,2000,06,09","16,10,2006,06,09");
        System.out.println(programareController.programariContains("11,08,2000,06,09"));
        programareController.insertProgramare(p1);

    }
}
