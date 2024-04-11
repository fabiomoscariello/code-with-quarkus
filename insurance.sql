SET client_encoding = 'UTF8';

CREATE TABLE TIPOVEICOLO(
    idTipo int PRIMARY KEY,
    tipologia text NOT NULL
);

CREATE TABLE VEICOLO (
    id text PRIMARY KEY,
    targa text UNIQUE,
    modello text,
    nome text,
    dataImmatricolazione text,
    tipoveicolo integer,
    CONSTRAINT fk_tipoVeicolo
      FOREIGN KEY(tipoveicolo) 
        REFERENCES TIPOVEICOLO(id)
);

CREATE TABLE INSURANCE (
    id text PRIMARY KEY,
    veicolo text UNIQUE,
    CONSTRAINT fk_Veicolo
      FOREIGN KEY(veicolo) 
        REFERENCES VEICOLO(id)
);

COPY TIPOVEICOLO (tipologia) FROM stdin;
Automobile
Motociclo