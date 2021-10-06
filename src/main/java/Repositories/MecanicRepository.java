package Repositories;

import Model.Client;
import Model.Mecanic;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MecanicRepository {

    private String jdbcurl = "jdbc:mysql://localhost:3306/parc_auto_db?autoreconnect=true&useSSL=false";
    private String user = "root";
    private String password = "root";
    private Connection connection = null;
    private Statement statement = null;

    public MecanicRepository() {
        try {
            this.connection = DriverManager.getConnection(this.jdbcurl, this.user, this.password);
            this.statement = this.connection.createStatement();
        } catch (SQLException var2) {
            System.out.println("eroare de conectare baza de date");
        }

    }

    public void executeStatement(String execute) {
        try {
            this.statement.execute(execute);
        } catch (SQLException var3) {
            System.out.println("Nu am reusit " + execute);
        }
    }

    public void insertMecanic(Mecanic mecanic) {
        String insertTo = " ";
        insertTo = insertTo + "insert into mecanici (nume,parola) values (";
        insertTo = insertTo + String.format("'%s','%s'",mecanic.getNume(),mecanic.getParola());
        insertTo = insertTo + ");";
        this.executeStatement(insertTo);
    }


    public void removeMecanic(int id){
        String removeTo="";
        removeTo+=String.format("%s", "delete from mecanici where id='"+id+"';");
        executeStatement(removeTo);

    }

    public void updateNume(int id , String numeNou){
        String update="";
        update+=String.format("update mecanici set nume='%s'", numeNou);
        update+=String.format(" where id=%d", id);
        executeStatement(update);
    }

    public void updateParola(int id , String parolaNoua){
        String update="";
        update+=String.format("update clienti set parola='%s'", parolaNoua);
        update+=String.format(" where id=%d", id);
        executeStatement(update);
    }

    private ResultSet lista(){
        executeStatement("select * from mecanici");
        try {
            return statement.getResultSet();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    public List<Mecanic> allMecanici(){
        ResultSet set=lista();
        List<Mecanic> mecanici = new ArrayList<>();
        try {
            while (set.next()){
                mecanici.add(new Mecanic(set.getInt(1),set.getString(2),set.getString(3)));
            }
        }catch (Exception e){
//            System.out.println("Nu s-a creat lista");
            e.printStackTrace();
            return null;
        }
        return mecanici;
    }

    public static boolean containsMecanic(String nume){
        int flg=0;
        for(Mecanic mecanic:new MecanicRepository().allMecanici())
            if(mecanic.getNume().equals(nume))
                flg=1;
        if(flg==1)
            return true;
        return false;
    }




}
