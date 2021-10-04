package Model;

public class Client implements Comparable<Client> {

    private int id;
    private String nume;


    public Client(int id, String nume){
        this.id=id;
        this.nume=nume;
    }

    @Override
    public String toString() {
        return "Clientul "+ id+" are numele: "+ nume;
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
        Client client=(Client) o;
        return this.id==client.getId();
    }

    @Override
    public int compareTo(Client o) {
        if(this.id>o.getId())
            return 1;
        else if(this.id<o.getId())
            return -1;
        return 0;
    }
}
