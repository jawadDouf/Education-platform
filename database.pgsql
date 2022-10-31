CREATE TABLE promotions(
   id SERIAL primary key not null ,
   nom varchar(255) not null ,
   size int not null
);
CREATE Type status as enum('Adiministrateur','Formateur','Apprenant');
CREATE TABLE acteurs(
    id SERIAL not null primary key ,
    nom varchar(255) not null ,
    prenom varchar(255) not null,
    email varchar(255) not null,
    password varchar(255) not null,
    statu status,
    promo_id int default 0
);

ALTER TABLE acteurs ADD CONSTRAINT fk_promotion FOREIGN KEY (promo_id) REFERENCES promotions(id);

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