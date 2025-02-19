\c votacao;

CREATE TABLE candidato (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    numero INT NOT NULL UNIQUE
);

CREATE TABLE eleitor (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE
);

CREATE TABLE voto (
    id SERIAL PRIMARY KEY,
    eleitor_id INT NOT NULL,
    candidato_id INT NOT NULL,
    CONSTRAINT fk_eleitor FOREIGN KEY (eleitor_id) REFERENCES eleitor (id),
    CONSTRAINT fk_candidato FOREIGN KEY (candidato_id) REFERENCES candidato (id),
    UNIQUE (eleitor_id)
);
