package Model;

import Repositories.ClientRepository;

public class Client implements Comparable<Client> {

    private int id;
    private String nume;
    private String parola;


    public Client(int id, String nume,String parola){
        this.id=id;
        this.nume=nume;
        this.parola=parola;
    }

    public Client(String nume,String parola){
        this.nume=nume;
        this.parola=parola;
    }

    public Client(String nume) throws Exception {
//        if(ClientRepository.containsClient(nume))
            this.nume=nume;
//        else
//           throw new Exception("Nu exista clientul in baza de date.");
//            System.out.println("client nu");
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

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
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
