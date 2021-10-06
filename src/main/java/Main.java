import Controllers.AdminController;
import Controllers.ClientController;
import Controllers.MecanicController;
import Controllers.ProgramareController;
import Model.Admin;
import Model.Client;
import Model.Mecanic;
import Model.Programare;
import Repositories.AdminRepository;
import Repositories.ClientRepository;
import Repositories.ProgramareRepository;
import Views.ViewAdmin;
import Views.ViewClient;
import Views.ViewLogin;
import Views.ViewMecanic;

import java.sql.SQLException;

public class Main {


    public static void main(String[] args) throws Exception {

        ViewLogin viewLogin=new ViewLogin();
        viewLogin.play();
    }
}
