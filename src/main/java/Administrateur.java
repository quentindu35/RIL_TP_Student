public class Administrateur {
    private Integer id_administrateur;
    private String nom;
    private String prenom;
    private String mail;
    private String mdp;

    public Administrateur() {
    }

    public Administrateur(Integer id_administrateur, String nom, String prenom, String mail, String mdp) {
        this.id_administrateur = id_administrateur;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.mdp = mdp;
    }

    public Administrateur(String nom, String prenom, String mail, String mdp) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.mdp = mdp;
    }

    public Integer getId_administrateur() {
        return id_administrateur;
    }

    public void setId_administrateur(Integer id_administrateur) {
        this.id_administrateur = id_administrateur;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}
