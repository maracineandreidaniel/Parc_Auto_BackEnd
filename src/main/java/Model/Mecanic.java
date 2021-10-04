package Model;

import java.util.Objects;

public class Mecanic implements Comparable<Mecanic> {

    private int id;
    private String nume;

    public Mecanic(int id, String nume){
        this.id=id;
        this.nume=nume;
    }

    @Override
    public String toString() {
        return "Mecanicul "+ id+" are numele: "+ nume;
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
       Mecanic mecanic=(Mecanic) o;
       return this.id==mecanic.getId();
    }


    @Override
    public int compareTo(Mecanic o) {
        if(this.id>o.getId())
            return 1;
        else if(this.id<o.getId())
            return -1;
        return 0;
    }
}
