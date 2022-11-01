USE education_platform;

CREATE TABLE administrateurs(
    id SERIAL not null primary key ,
    nom varchar(255) not null ,
    prenom varchar(255) not null,
    email varchar(255) not null,
    password varchar(255) not null
);

CREATE TABLE formateurs(
    id SERIAL not null primary key ,
    nom varchar(255) not null ,
    prenom varchar(255) not null,
    email varchar(255) not null,
    password varchar(255) not null
);

CREATE TABLE apprenants(
    id SERIAL not null primary key ,
    nom varchar(255) not null ,
    prenom varchar(255) not null,
    email varchar(255) not null,
    password varchar(255) not null
);

CREATE TABLE promotions(
   id SERIAL primary key not null ,
   nom varchar(255) not null ,
   size int not null,
   formateur_id int not null
);

ALTER TABLE promotions ADD CONSTRAINT fk_formateur FOREIGN KEY (formateur_id) REFERENCES promotions(id);

CREATE TABLE promo_apprenant(
  id SERIAL not null primary key,
  apprenant_id int not null,
  promo_id int not null,
  year DATE
);

ALTER TABLE promo_apprenant ADD CONSTRAINT fk_apprenant FOREIGN KEY (apprenant_id) REFERENCES apprenants(id);

ALTER TABLE promo_apprenant ADD CONSTRAINT fk_promo  FOREIGN KEY (promo_id) REFERENCES promotions(id);

CREATE TABLE briefs (
    id SERIAL primary key ,
    titre varchar(255) not null ,
    description varchar(255) not null ,
    languages varchar(255) not null ,
    liverable varchar(255) not null ,
    liverable_date int not null ,
    date_debut DATE not null ,
    date_fin DATE not null,
    promo_id int not null
);

ALTER TABLE briefs ADD CONSTRAINT fk_promotion FOREIGN KEY (promo_id) REFERENCES promotions(id);