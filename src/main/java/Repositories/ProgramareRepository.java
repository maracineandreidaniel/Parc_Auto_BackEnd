package Repositories;

import Model.Programare;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProgramareRepository {

    private String jdbcurl = "jdbc:mysql://localhost:3306/parc_auto_db?autoreconnect=true&useSSL=false";
    private String user = "root";
    private String password = "root";
    private Connection connection = null;
    private Statement statement = null;

    public ProgramareRepository() {
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


        public void insertProgramare(Programare programare) {
        String insertTo = " ";
        insertTo = insertTo + "insert into programari (id,dataInceput,dataSfarsit) values (";
        insertTo = insertTo + String.format("%d,'%s','%s'",programare.getProgramare_id(),programare.getDataInceput(), programare.getDataSfarsit());
        insertTo = insertTo + ");";
        this.executeStatement(insertTo);
    }


    public void removeProgramare(int id){
        String removeTo="";
        removeTo+=String.format("%s", "delete from programari where id='"+id+"';");
        executeStatement(removeTo);

    }


    public void updateDataInceput(int id , String dataInceput){
        String update="";
        update+=String.format("update programari set dataInceput='%s'", Programare.convertStringLocalDateTime(dataInceput));
        update+=String.format(" where id=%d", id);
        executeStatement(update);
    }

    public void updateDataSfarsit(int id , String dataSfarsit){
        String update="";
        update+=String.format("update programari set dataSfarsit='%s'", Programare.convertStringLocalDateTime(dataSfarsit));
        update+=String.format(" where id=%d", id);
        executeStatement(update);
    }

    private ResultSet lista(){

        executeStatement("select * from programari");

        try {
            return statement.getResultSet();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }


    }


    public List<Programare> allProgramari(){

        ResultSet set=lista();

        List<Programare> programari = new ArrayList<>();


        try {
            while (set.next()){
               programari.add(new Programare(set.getInt(1),Programare.parameterStringConvert(set.getString(2)),
                        Programare.parameterStringConvert(set.getString(3))));
            }
        }catch (Exception e){
//            System.out.println("Nu s-a creat lista");
            e.printStackTrace();
            return null;
        }
        return programari;

    }




}
