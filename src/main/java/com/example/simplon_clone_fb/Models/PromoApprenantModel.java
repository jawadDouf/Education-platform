package com.example.simplon_clone_fb.Models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "promo_apprenant", schema = "public", catalog = "education_platform")
public class PromoApprenantModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "apprenant_id")
    private int apprenantId;
    @Basic
    @Column(name = "promo_id")
    private int promoId;
    @Basic
    @Column(name = "year")
    private Date year;
    @ManyToOne
    @JoinColumn(name = "apprenant_id", referencedColumnName = "id", nullable = false)
    private ApprenantsModel apprenantsByApprenantId;
    @ManyToOne
    @JoinColumn(name = "promo_id", referencedColumnName = "id", nullable = false)
    private PromotionsModel promotionsByPromoId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApprenantId() {
        return apprenantId;
    }

    public void setApprenantId(int apprenantId) {
        this.apprenantId = apprenantId;
    }

    public int getPromoId() {
        return promoId;
    }

    public void setPromoId(int promoId) {
        this.promoId = promoId;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PromoApprenantModel that = (PromoApprenantModel) o;

        if (id != that.id) return false;
        if (apprenantId != that.apprenantId) return false;
        if (promoId != that.promoId) return false;
        if (year != null ? !year.equals(that.year) : that.year != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + apprenantId;
        result = 31 * result + promoId;
        result = 31 * result + (year != null ? year.hashCode() : 0);
        return result;
    }

    public ApprenantsModel getApprenantsByApprenantId() {
        return apprenantsByApprenantId;
    }

    public void setApprenantsByApprenantId(ApprenantsModel apprenantsByApprenantId) {
        this.apprenantsByApprenantId = apprenantsByApprenantId;
    }

    public PromotionsModel getPromotionsByPromoId() {
        return promotionsByPromoId;
    }

    public void setPromotionsByPromoId(PromotionsModel promotionsByPromoId) {
        this.promotionsByPromoId = promotionsByPromoId;
    }
}
