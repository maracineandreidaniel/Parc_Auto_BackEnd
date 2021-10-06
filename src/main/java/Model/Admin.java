package Model;

public class Admin implements Comparable<Admin> {

    private int id;
    private String nume;
    private String parola;


    public Admin(int id, String nume,String parola){
        this.id=id;
        this.nume=nume;
        this.parola=parola;
    }

    public Admin(String nume,String parola){
        this.nume=nume;
        this.parola=parola;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    @Override
    public String toString() {
        return "Adminul "+ id+" are numele: "+ nume;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }


    @Override
    public boolean equals(Object o) {
        Admin admin=(Admin) o;
        return this.id==admin.getId();
    }

    @Override
    public int compareTo(Admin o) {
        if(this.id>o.getId())
            return 1;
        else if(this.id<o.getId())
            return -1;
        return 0;
    }

}
