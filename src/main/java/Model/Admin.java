package Model;

public class Admin implements Comparable<Admin> {

    private int id;
    private String nume;


    public Admin(int id, String nume){
        this.id=id;
        this.nume=nume;
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
