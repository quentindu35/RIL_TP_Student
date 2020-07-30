public class Etudiant {
    private Integer id_etudiant;
    private String nom;
    private String prenom;
    private String mail;
    private Classe classe;

    public Etudiant(String nom, String prenom, String mail, Classe classe) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.classe = classe;
    }

    public Integer getId_etudiant() {
        return id_etudiant;
    }

    public void setId_etudiant(Integer id_etudiant) {
        this.id_etudiant = id_etudiant;
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

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }
}
