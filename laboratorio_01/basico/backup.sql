-- H2 2.3.232; 
;              
CREATE USER IF NOT EXISTS "SA" SALT '2a9df2b835c2e67e' HASH '694001a0b5f3de5047a9370e57c080d9f41bd66d265cada596ae7d59bed37476' ADMIN;          


CREATE CACHED TABLE "PUBLIC"."OFERTAS"(
    "ID" CHARACTER VARYING(255) NOT NULL,
    "TAG" CHARACTER VARYING(255),
    "AVISO" CHARACTER VARYING(255),
    "PRECO" DECIMAL,
    "CNPJNOME" CHARACTER VARYING(255),
    "LOCALGPS" INTEGER,
    "PENDING" BOOLEAN
);           
ALTER TABLE "PUBLIC"."OFERTAS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_C" PRIMARY KEY("ID");       
-- 15 +/- SELECT COUNT(*) FROM PUBLIC.OFERTAS; 
INSERT INTO "PUBLIC"."OFERTAS" VALUES
('1', 'Arroz', '1Kgrs de Arroz Bello Rizzo', 6, 'Mercearia Itabaiana', 2, FALSE),
('2', 'Wafer', 'Wafer Vitarella 80 gramas', 2, 'Mercearia Itabaiana', 2, FALSE),
('3', 'Halls', 'Balas Halls', 1, 'Gbarbosa Eduardo Gomes', 1, FALSE),
('4', 'Halls', 'Caixa de 21 baas (unidade R$ 1.192)', 25, 'Casa das Embalagens', 3, FALSE),
('5', U&'P\00e3o', U&'3 p\00e3es por 1 real', 0, 'Camila Panificacao e Mercearia', 4, FALSE),
('6', U&'P\00e3o', '', 0, NULL, NULL, TRUE),
('7', 'Leite', U&' litro de leite Bet\00e2nia ', 6, 'Gbarbosa', 1, FALSE),
('8', U&'Almo\00e7o', ' Prato Feito', 16, 'Restaurante PONTO BOM UNIVERSITARIO', 5, FALSE),
('9', 'Pimenta', U&'MOLHO DE PIMENTA GOTA MARAT\00c1 150ML', 2, U&'Panificadora P\00e3o Delicia', 6, FALSE),
('11', 'Arroz', '1Kgrs de Arroz CooperFlores', 5, 'Gbarbosa', 1, FALSE),
('12', U&'caf\00e9', U&' Marat\00e1 250 gr .', 11, 'Mercado Eduardo Gomes', 7, FALSE),
('13', 'Pitu', 'Garrafa 965 ml', 11, 'Mercado Magnata', 8, FALSE),
('14', 'Arroz', '1Kgrs de Arroz POP', 4, 'Gbarbosa', 1, FALSE),
('15', 'leite', 'Leite Sabe 1 lito', 4, 'Gbarbosa', 1, TRUE),
('10', 'Goiabada', 'Goiabada Stella dOro 500g', 4, U&'Panificadora P\00e3o Delicia', 6, FALSE);     
CREATE CACHED TABLE "PUBLIC"."LOCAIS"(
    "ID" CHARACTER VARYING(255) NOT NULL,
    "NOME" CHARACTER VARYING(255),
    "ENDERECO" CHARACTER VARYING(255),
    "LATITUDE" DOUBLE PRECISION,
    "LONGITUDE" DOUBLE PRECISION,
    "LOCALGPS" CHARACTER VARYING(1024)
);        
ALTER TABLE "PUBLIC"."LOCAIS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_8" PRIMARY KEY("ID");        
-- 10 +/- SELECT COUNT(*) FROM PUBLIC.LOCAIS;  
INSERT INTO "PUBLIC"."LOCAIS" VALUES
('1', 'Gbarbosa Eduardo Gomes', '', -10.9277759, -37.1181791, 'https://www.google.com/maps/place/Gbarbosa/@-10.927776,-37.1184866,20z/data=!4m10!1m2!2m1!1sGbarbosa+Eduardo+Gomes!3m6!1s0x71ab39dc308137b:0x17869114e481459!8m2!3d-10.9277759!4d-37.1181791!15sChZHYmFyYm9zYSBFZHVhcmRvIEdvbWVzIgOIAQGSAQ1ncm9jZXJ5X3N0b3Jl4AEA!16s%2Fg%2F11rfrb3f24?entry=ttu&g_ep=EgoyMDI0MTIxMS4wIKXMDSoASAFQAw%3D%3D'),
('2', 'Mercearia Itabaiana', '', -10.9277759, -37.1181791, 'https://www.google.com/maps/place/Mercearia+Itabaiana/@-10.9307585,-37.1139155,20z/data=!4m10!1m2!2m1!1sMercearia+Itabaiana!3m6!1s0x71ab212c5ab0fbf:0xff375e41e77d1ae5!8m2!3d-10.9308697!4d-37.113307!15sChNNZXJjZWFyaWEgSXRhYmFpYW5hkgEGbWFya2V04AEA!16s%2Fg%2F11kn6vdb2r?entry=ttu&g_ep=EgoyMDI0MTIxMS4wIKXMDSoASAFQAw%3D%3D'),
('3', 'Casa das Embalagens', '', -10.9277759, -37.1181791, 'https://www.google.com/maps/place/Casa+das+Embalagens/@-10.9286137,-37.1199643,19z/data=!4m6!3m5!1s0x71ab27341a70a03:0x521b6203356019ca!8m2!3d-10.928216!4d-37.119342!16s%2Fg%2F11ckky9q3j?entry=ttu&g_ep=EgoyMDI0MTIxMS4wIKXMDSoASAFQAw%3D%3D'),
('4', 'Camila Panificacao e Mercearia', '', -10.9277759, -37.1181791, 'https://www.google.com/maps/place/Camila+Panificacao+e+Mercearia/@-10.9365199,-37.1194343,20.03z/data=!4m6!3m5!1s0x71ab20ee2f83aef:0x2957cf950d029569!8m2!3d-10.9362962!4d-37.1192262!16s%2Fg%2F11jx4rnrlw?entry=ttu&g_ep=EgoyMDI1MDEwNi4xIKXMDSoASAFQAw%3D%3D'),
('5', 'Restaurante PONTO BOM UNIVERSITARIO', '', -10.9277759, -37.1181791, 'https://www.google.com/maps/place/RESTAURANTE+PONTO+BOM+UNIVERSITARIO/@-10.9232981,-37.1054019,21z/data=!4m6!3m5!1s0x71ab2683c82071d:0x1bcd896b5f8ef987!8m2!3d-10.9233299!4d-37.1052277!16s%2Fg%2F11tk1_tbx_?entry=ttu&g_ep=EgoyMDI0MTIxMS4wIKXMDSoASAFQAw%3D%3D'),
('6', U&'Panificadora P\00e3o Delicia', '', -10.9277759, -37.1181791, 'https://www.google.com/maps/search/Gbarbosa+Eduardo+Gomes+%C2%B4panificaora+pao+delicia/@-10.9258054,-37.1219963,20z?entry=ttu&g_ep=EgoyMDI1MDEwNi4xIKXMDSoASAFQAw%3D%3D'),
('7', 'Mercado Eduardo Gomes  ', '', -10.9277759, -37.1181791, 'https://www.google.com/maps/place/Evaristo/@-10.934794,-37.1220593,21z/data=!4m14!1m7!3m6!1s0x71ab2096ae69103:0x7a184eb1f50206bf!2sPar%C3%B3quia+Nossa+Senhora+do+Loreto!8m2!3d-10.9347108!4d-37.1215824!16s%2Fg%2F1tdywkll!3m5!1s0x71ab3f5a60d7aeb:0x57e3d9d9e87f4120!8m2!3d-10.9348047!4d-37.1218727!16s%2Fg%2F11ghs5ftjm?entry=ttu&g_ep=EgoyMDI0MTIxMS4wIKXMDSoASAFQAw%3D%3D'),
('8', 'Mercado Magnata', '', -10.9277759, -37.1181791, 'https://www.google.com/maps/place/R.+Sid%C3%B4nio+Mess%C3%ADas+-+Rosa+Maria,+S%C3%A3o+Crist%C3%B3v%C3%A3o+-+SE,+49107-050/@-10.927187,-37.1155219,20.33z/data=!4m6!3m5!1s0x71ab272128b1779:0x758f22ef9c03d17b!8m2!3d-10.9258829!4d-37.1159091!16s%2Fg%2F1ymtvr233?entry=ttu&g_ep=EgoyMDI0MTIxMS4wIKXMDSoASAFQAw%3D%3D'),
('9', U&'Atacad\00e3o', '', NULL, NULL, 'https://www.google.com/maps/search/Atacad%C3%A3o+aracaju/@-10.9093984,-37.0991327,17.42z?entry=ttu&g_ep=EgoyMDI1MDEwNi4xIKXMDSoASAFQAw%3D%3D'),
('10', U&'Atacad\00e3o Centro', '', NULL, NULL, 'https://www.google.com/maps/place/Atacad%C3%A3o+-+Aracaju+Gon%C3%A7alo+Prado/@-10.9203019,-37.056082,19.51z/data=!4m6!3m5!1s0x71ab3274625ae0d:0xfd198edd6cba342c!8m2!3d-10.9202633!4d-37.0557381!16s%2Fg%2F11txmbsl_7?entry=ttu&g_ep=EgoyMDI1MDEwNi4xIKXMDSoASAFQAw%3D%3D');            
