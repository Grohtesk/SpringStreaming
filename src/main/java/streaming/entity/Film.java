/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author ETY01
 */
@Entity
public class Film implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String titre;
    
    private String synopsis;
    
    private Integer annee;
    
    private Integer duree;
    
    @OneToMany(mappedBy = "film",cascade = CascadeType.REMOVE)
    private List<Lien> liens = new ArrayList<Lien>();
    
    @ManyToMany
    @JoinTable(name="real_film")
    private List<Personne> realisateurs = new ArrayList<Personne>();
    
    @ManyToMany
    @JoinTable(name="acteur_film")
    private List<Personne> acteurs = new ArrayList<Personne>();

    @ManyToMany
    @JoinTable(name="pays_film")
    private List<Pays> pays = new ArrayList<Pays>();

    public Film() {
    }
    
    public Film(Long id, String titre, String synopsis, Integer annee, Integer duree) {
        this.id = id;
        this.titre = titre;
        this.synopsis = synopsis;
        this.annee = annee;
        this.duree = duree;
    }

    public List<Pays> getPays() {
        return pays;
    }

    public void setPays(List<Pays> pays) {
        this.pays = pays;
    }
    
    public void addPays(Pays pays) {
        this.pays.add(pays);
    }

    public Long getId() {
        return id;
    }
//coucou, alors tu as bien mangé ? la brioche dorée ou dupont fût un régal pour 
    // toi ^^ passe une bonne digestion et un bon après-midi. Bisous. Damien te 
    // fait aussi des poutoupoutous partout :-)
    // Vincent <3
    
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Film)) {
            return false;
        }
        Film other = (Film) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "streaming.entity.Film[ id=" + id + " ]";
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Integer getAnnee() {
        return annee;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
    }

    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    public List<Lien> getLiens() {
        return liens;
    }

    public void setLiens(List<Lien> liens) {
        this.liens = liens;
    }

    public List<Personne> getRealisateurs() {
        return realisateurs;
    }

    public void setRealisateurs(List<Personne> realisateurs) {
        this.realisateurs = realisateurs;
    }

    public List<Personne> getActeurs() {
        return acteurs;
    }

    public void setActeurs(List<Personne> acteurs) {
        this.acteurs = acteurs;
    }
}
