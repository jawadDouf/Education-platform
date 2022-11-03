package Models;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "promotions", schema = "public", catalog = "education_platform")
public class PromotionsModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "nom")
    private String nom;
    @Basic
    @Column(name = "size")
    private int size;
    @Basic
    @Column(name = "formateur_id")
    private int formateurId;
    @OneToMany(mappedBy = "promotionsByPromoId")
    private Collection<PromoApprenantModel> promoApprenantsById;
    @ManyToOne
    @JoinColumn(name = "formateur_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private PromotionsModel promotionsByFormateurId;
    @OneToMany(mappedBy = "promotionsByFormateurId")
    private Collection<PromotionsModel> promotionsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getFormateurId() {
        return formateurId;
    }

    public void setFormateurId(int formateurId) {
        this.formateurId = formateurId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PromotionsModel that = (PromotionsModel) o;

        if (id != that.id) return false;
        if (size != that.size) return false;
        if (formateurId != that.formateurId) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + size;
        result = 31 * result + formateurId;
        return result;
    }

    public Collection<PromoApprenantModel> getPromoApprenantsById() {
        return promoApprenantsById;
    }

    public void setPromoApprenantsById(Collection<PromoApprenantModel> promoApprenantsById) {
        this.promoApprenantsById = promoApprenantsById;
    }

    public PromotionsModel getPromotionsByFormateurId() {
        return promotionsByFormateurId;
    }

    public void setPromotionsByFormateurId(PromotionsModel promotionsByFormateurId) {
        this.promotionsByFormateurId = promotionsByFormateurId;
    }

    public Collection<PromotionsModel> getPromotionsById() {
        return promotionsById;
    }

    public void setPromotionsById(Collection<PromotionsModel> promotionsById) {
        this.promotionsById = promotionsById;
    }
}
