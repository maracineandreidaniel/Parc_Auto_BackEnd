package Model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Programare implements Comparable<Programare> {
    private int programare_id;
    private LocalDateTime dataInceput;
    private LocalDateTime dataSfarsit;

    //dd,mm,yyyy,hh,mm

    public static LocalDateTime convertStringLocalDateTime(String data){
        int ddi = Integer.parseInt(data.split(",")[0]);
        int mmi = Integer.parseInt(data.split(",")[1]);
        int yyi = Integer.parseInt(data.split(",")[2]);
        int hhi = Integer.parseInt(data.split(",")[3]);
        int mini = Integer.parseInt(data.split(",")[4]);
        return LocalDateTime.of(yyi, mmi, ddi, hhi, mini);
    }



    public Programare(int id,LocalDateTime ldi, LocalDateTime lds){
        dataInceput=ldi;
        dataSfarsit=lds;
        programare_id=id;
    }

    public int getProgramare_id() {
        return programare_id;
    }

    public void setProgramare_id(int programare_id) {
        this.programare_id = programare_id;
    }

    public Programare(int id, String ldi, String lds){
        dataInceput=convertStringLocalDateTime(ldi);
        dataSfarsit=convertStringLocalDateTime(lds);
        programare_id=id;
    }




    public LocalDateTime getDataInceput(){
        return this.dataInceput;
    }

    public LocalDateTime getDataSfarsit(){
        return this.dataSfarsit;
    }

    public Duration getDurata(){
        return  Duration.between(dataInceput,dataSfarsit);
    }

    public void setDataInceput(LocalDateTime di){
        this.dataInceput=di;
    }

    public void setDataSfarsit(LocalDateTime ds){
        this.dataSfarsit=ds;
    }

    public void setDataInceputString(String di){
        this.dataInceput=convertStringLocalDateTime(di);
    }

    public void setDataSfarsitString(String ds){
        this.dataSfarsit=convertStringLocalDateTime(ds);
    }



    @Override
    public String toString(){
        String text="";
       DateTimeFormatter format=DateTimeFormatter.ofPattern("EEEE, MMM dd, yyyy HH:mm:ss a");
        text+="Programarea "+ programare_id+ " incepe la "+dataInceput.format(format);
        text+=" si se sfarseste la "+dataSfarsit.format(format);
        text+=" si dureaza "+this.getDurata().toHours()+" ore";
        return text;
    }

    public static String convertLDTtoStringTFormat(LocalDateTime ldt){
        return String.format("%s",ldt);
    }

    public static String parameterStringConvert(String data){
        String dataF="";
        String[] p1=data.split("T");
        String[] p2=p1[0].split("-");
        String[] p3=p1[1].split(":");
        dataF+=p2[2]+","+p2[1]+","+p2[0]+","+p3[0]+","+p3[1];
        return dataF;
    }

    @Override//se suprapun
    public boolean equals(Object obj) {

        // cazurile in care nu se suprapun
        Programare p2=(Programare)obj;
        boolean c1=this.dataInceput.isAfter(p2.getDataInceput())&&this.dataInceput.isAfter(p2.getDataSfarsit());
        boolean c2=this.dataSfarsit.isAfter(p2.getDataInceput())&&this.dataSfarsit.isAfter(p2.getDataSfarsit());
        boolean c3=this.dataInceput.isBefore(p2.getDataInceput())&&this.dataInceput.isBefore(p2.dataSfarsit);
        boolean c4=this.dataSfarsit.isBefore(p2.getDataInceput())&&this.dataSfarsit.isBefore(p2.dataSfarsit);
        return   !((c1&&c2)||(c3&&c4));

    }


    @Override
    public int compareTo(Programare obj){

        if(this.equals(obj)==true){
            return 0;
        }else return this.dataInceput.compareTo(obj.dataInceput);
    }


    public String toStringPauza(){

        String text="";
        DateTimeFormatter format=DateTimeFormatter.ofPattern("EEEE, MMM dd, yyyy HH:mm:ss a");
        text+="Pauza incepe la "+dataInceput.format(format);
        text+=" si se sfarseste la "+dataSfarsit.format(format);
        text+=" si dureaza "+this.getDurata().toHours()+" ore";
        return text;
    }
}



