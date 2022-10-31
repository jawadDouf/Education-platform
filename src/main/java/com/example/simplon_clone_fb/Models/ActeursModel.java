package com.example.simplon_clone_fb.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "acteurs", schema = "public", catalog = "simplon_clone")
public class ActeursModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "nom")
    private String nom;
    @Basic
    @Column(name = "prenom")
    private String prenom;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "statu")
    private Object statu;
    @Basic
    @Column(name = "promo_id")
    private Integer promoId;
    @ManyToOne
    @JoinColumn(name = "promo_id", referencedColumnName = "id")
    private PromotionsModel promotionsByPromoId;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Object getStatu() {
        return statu;
    }

    public void setStatu(Object statu) {
        this.statu = statu;
    }

    public Integer getPromoId() {
        return promoId;
    }

    public void setPromoId(Integer promoId) {
        this.promoId = promoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActeursModel that = (ActeursModel) o;

        if (id != that.id) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (prenom != null ? !prenom.equals(that.prenom) : that.prenom != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (statu != null ? !statu.equals(that.statu) : that.statu != null) return false;
        if (promoId != null ? !promoId.equals(that.promoId) : that.promoId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (statu != null ? statu.hashCode() : 0);
        result = 31 * result + (promoId != null ? promoId.hashCode() : 0);
        return result;
    }

    public PromotionsModel getPromotionsByPromoId() {
        return promotionsByPromoId;
    }

    public void setPromotionsByPromoId(PromotionsModel promotionsByPromoId) {
        this.promotionsByPromoId = promotionsByPromoId;
    }
}
