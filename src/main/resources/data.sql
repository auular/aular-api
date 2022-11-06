INSERT INTO pet_tutor (name, email, password, document_id, phone_number, pet_tutor_uuid, active, created_at,  updated_at) VALUES
('Arnaldo Pereira', 'arnaldopereira@gmail.com', 'arnaldinho', '91938502821', '(11)9917818751)', uuid(), true, now(), now()),
('Bernardo dos Santos', 'bernardosantos@gmail.com', 'bernardinho', '82938502892', '(11)9927818792', uuid(), true, now(), now()),
('Carlos Eduardo', 'cadu@gmail.com', 'caduzinho', '739385028923', '(11)9937818793', uuid(), true, now(), now()),
('Daniela Mattos', 'danimattos@gmail.com', 'danizinha', '649385028924', '(11)9947818794', uuid(), true, now(), now()),
('Elias Queiroga', 'eliasqueiroga@gmail.com', 'eliazinho', '55938502895', '(11)9957818795', uuid(), true, now(), now()),
('Fabiana Antunes', 'fabiantunes@gmail.com', 'fabizinha', '46938502896', '(11)9967818796', uuid(), true, now(), now()),
('Gisele Almeida', 'gialmeida@gmail.com', 'giselezinha', '37938502897', '(11)9977818797', uuid(), true, now(), now()),
('Henrique Toledo', 'henriquetoledo@gmail.com', 'henriquinho', '28938502898', '(11)9987818798', uuid(), true, now(), now());

INSERT INTO pet (name, birthdate, specie, breed, health_description, pet_uuid, created_at, updated_at, pet_tutor_pet_tutor_id) VALUES
('Apolo', '2011-01-01', 'Cachorro', 'Akita', 'Uma capsula de ezima pancreática por dia', uuid(), now(), now(), 1),
('Beethoven', '2012-02-02', 'Cachorro', 'Basset Hound', 'Um comprimido de antibiótico para otite por dia', uuid(), now(), now(), 2),
('Cuca', '2013-03-03', 'Cachorro', 'Chihuahua', '5 gotas de dexclorfeniramina uma vez por dia', uuid(), now(), now(), 3),
('Duque', '2014-04-04', 'Cachorro', 'Dalmata', '10 gotas de Homeopet Cist Control uma vez por dia', uuid(), now(), now(), 4),
('Eros', '2015-05-05', 'Cachorro', 'Doberman', null, uuid(), now(), now(), 5),
('Fox', '2016-06-06', 'Cachorro', 'Fila Brasileiro', 'Limpar bem as rugas do rosto', uuid(), now(), now(), 6),
('Glenda', '2017-07-07', 'Cachorro', 'Golden Retriever', 'Tyrox 200mcg a cada 12 horas', uuid(), now(), now(), 7),
('Haley', '2018-08-08', 'Gato', 'Himalaio', null, uuid(), now(), now(), 8);

INSERT INTO partner (
    name, email, password, document_id, phone_number, partner_uuid, active,
    fidelity, is_authenticated, number_of_campaigns, created_at, updated_at) VALUES
('Cobasi Comercio de Prod. Basicos e Industr. SA', 'marketing@cobasi.com.br', 'cobasimkt', '53.153.938/0001-08', '(11)38318999',
    uuid(), true, true, false, 2, now(), now()),
('Pet Center Comercio e  Participacoes SA', 'comercial@petz.com.br', 'petz123', '18.328.118/0040-15', '(11)21827380',
    uuid(), true, true, false, 1, now(), now()),
('Petsupermarket Comércio de Produtos para Animais S.A.', 'comercial@petlove.com.br', 'petlove', '10.864.846/0001-23', '(11)30432113',
    uuid(), true, true, false, 1, now(), now());




