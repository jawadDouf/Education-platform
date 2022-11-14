package com.example.simplon_clone_fb.Models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "briefs", schema = "public", catalog = "education_platform")
public class BriefsModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "titre")
    private String titre;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "languages")
    private String languages;
    @Basic
    @Column(name = "liverable")
    private String liverable;

    @Basic
    @Column(name = "liverable_date")
    private int liverableDate;
    @Basic
    @Column(name = "date_debut")
    private Date dateDebut;
    @Basic
    @Column(name = "date_fin")
    private Date dateFin;

    @Basic
    @Column(name = "status")
    private boolean status;

    @Basic
    @Column(name = "promo_id")
    private int promoId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getLiverable() {
        return liverable;
    }

    public void setLiverable(String liverable) {
        this.liverable = liverable;
    }

    public int getLiverableDate() {
        return liverableDate;
    }

    public void setLiverableDate(int liverableDate) {
        this.liverableDate = liverableDate;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getPromoId() {
        return promoId;
    }

    public void setPromoId(int promoId) {
        this.promoId = promoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BriefsModel that = (BriefsModel) o;

        if (id != that.id) return false;
        if (liverableDate != that.liverableDate) return false;
        if (promoId != that.promoId) return false;
        if (titre != null ? !titre.equals(that.titre) : that.titre != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (languages != null ? !languages.equals(that.languages) : that.languages != null) return false;
        if (liverable != null ? !liverable.equals(that.liverable) : that.liverable != null) return false;
        if (dateDebut != null ? !dateDebut.equals(that.dateDebut) : that.dateDebut != null) return false;
        if (dateFin != null ? !dateFin.equals(that.dateFin) : that.dateFin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (titre != null ? titre.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (languages != null ? languages.hashCode() : 0);
        result = 31 * result + (liverable != null ? liverable.hashCode() : 0);
        result = 31 * result + liverableDate;
        result = 31 * result + (dateDebut != null ? dateDebut.hashCode() : 0);
        result = 31 * result + (dateFin != null ? dateFin.hashCode() : 0);
        result = 31 * result + promoId;
        return result;
    }
}
