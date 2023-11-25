package tp06.entities;

public class Client {
    private long ID_client;
    private String nom;
    private String prenom;
    private String email;
    private String adresse;

    public Client(String nom, String prenom, String email, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adresse = adresse;
    }

    public Client(long ID_client, String nom, String prenom, String email, String adresse) {
        this(nom, prenom, email, adresse);
        this.ID_client = ID_client;
    }

    public long getID_client() {
        return ID_client;
    }

    public void setID_client(long ID_client) {
        this.ID_client = ID_client;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return ID_client +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", adresse='" + adresse + '\'';
    }
}
