package com.example.simplon_clone_fb.Models;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "promotions", schema = "public", catalog = "simplon_clone")
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
    @OneToMany(mappedBy = "promotionsByPromoId")
    private Collection<ActeursModel> acteursById;
    @OneToMany(mappedBy = "promotionsByPromoId")
    private Collection<BriefsModel> briefsById;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PromotionsModel that = (PromotionsModel) o;

        if (id != that.id) return false;
        if (size != that.size) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + size;
        return result;
    }

    public Collection<ActeursModel> getActeursById() {
        return acteursById;
    }

    public void setActeursById(Collection<ActeursModel> acteursById) {
        this.acteursById = acteursById;
    }

    public Collection<BriefsModel> getBriefsById() {
        return briefsById;
    }

    public void setBriefsById(Collection<BriefsModel> briefsById) {
        this.briefsById = briefsById;
    }
}
