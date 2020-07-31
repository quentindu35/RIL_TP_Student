import java.util.List;

public class Classe {

    private Integer id_classe;
    private String nom;
    private List<Etudiant> listEtudiant;

    public Classe(String nom, List<Etudiant> listEtudiant) {
        this.nom = nom;
        this.listEtudiant = listEtudiant;
    }

    public Integer getId_classe() {
        return id_classe;
    }

    public void setId_classe(Integer id_classe) {
        this.id_classe = id_classe;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Etudiant> getListEtudiant() {
        return listEtudiant;
    }

    public void setListEtudiant(List<Etudiant> listEtudiant) {
        this.listEtudiant = listEtudiant;
    }

    @Override
    public String toString() {
        return "Classe{" +
                "id_classe=" + id_classe +
                ", nom='" + nom + '\'' +
                ", listEtudiant=" + listEtudiant +
                '}';
    }
}
