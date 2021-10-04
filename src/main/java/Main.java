import Model.Admin;
import Model.Client;
import Model.Programare;
import Repositories.AdminRepository;
import Repositories.ClientRepository;
import Repositories.ProgramareRepository;

import java.sql.SQLException;

public class Main {


    public static void main(String[] args) throws SQLException {

        ClientRepository clientRepository=new ClientRepository();
        clientRepository.insertClient(new Client(1,"client1"));
        clientRepository.insertClient(new Client(2,"client2"));
        clientRepository.insertClient(new Client(3,"client3"));
        clientRepository.removeClient(2);
        System.out.println(clientRepository.allClienti());

    }
}
