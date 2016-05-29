-- Tworzenie tabeli
CREATE TABLE clients (
  id       INTEGER                NOT NULL,
  name     CHARACTER VARYING(255) NOT NULL,
  surename CHARACTER VARYING(255) NOT NULL
);
-- Przypisanie właściciela tabeli
ALTER TABLE clients
  OWNER TO postgres;

-- Tworzenie sekwencji w celu automatycznego inkrementowania wartości ID
-- Taka jest praktyka, dzięki temu nie bedziesz miał dwóch klientów z tym samym ID
CREATE SEQUENCE id_clients_seq
START WITH 1
INCREMENT BY 1
NO MINVALUE
NO MAXVALUE
CACHE 1;

ALTER TABLE id_clients_seq
  OWNER TO postgres;
ALTER SEQUENCE id_clients_seq OWNED BY clients.id;
-- Ustawiam politykę nowej wartości nexval() - czyli ustawiam, że jeśli nie ma podanej wartości id
-- to ma ustawić kolejną wartość ze sekwensji id_clients_seq
ALTER TABLE ONLY clients
  ALTER COLUMN id SET DEFAULT nextval(
    'id_clients_seq' :: REGCLASS);
-- Tworzenie KLUCZA GLÓWNEGO na kolumnie id w tabeli clients
ALTER TABLE ONLY clients
  ADD CONSTRAINT clients_pkey PRIMARY KEY (id);
-- Dodanie przykładowych wartości do bazy, aby coś jużtam było :)
INSERT INTO clients VALUES (1, 'Jan', 'Nowak');
INSERT INTO clients VALUES (2, 'Jan', 'Kowalski');
INSERT INTO clients VALUES (3, 'Żaneta', 'Darmodam');
INSERT INTO clients VALUES (4, 'Agata', 'LoveAndSex');
--Ustawiam wartość sekwencji, ponieważ sam dodałem 4 wartości i od tej 4 musi teraz dalej dodawać.
SELECT pg_catalog.setval('id_clients_seq', 4, TRUE);