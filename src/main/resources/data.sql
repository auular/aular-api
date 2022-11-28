INSERT INTO pet_tutor ( name, email, password, document_id, phone_number,
                        pet_tutor_uuid, active, created_at,  updated_at) VALUES
('Arnaldo Pereira', 'arnaldopereira@gmail.com', 'arnaldinho', '91938502821', '(11)9917818751)', uuid(), true, now(), now()),
('Bernardo dos Santos', 'bernardosantos@gmail.com', 'bernardinho', '82938502892', '(11)9927818792', uuid(), true, now(), now()),
('Carlos Eduardo', 'cadu@gmail.com', 'caduzinho', '739385028923', '(11)9937818793', uuid(), true, now(), now()),
('Daniela Mattos', 'danimattos@gmail.com', 'danizinha', '649385028924', '(11)9947818794', uuid(), true, now(), now()),
('Elias Queiroga', 'eliasqueiroga@gmail.com', 'eliazinho', '55938502895', '(11)9957818795', uuid(), true, now(), now()),
('Fabiana Antunes', 'fabiantunes@gmail.com', 'fabizinha', '46938502896', '(11)9967818796', uuid(), true, now(), now()),
('Gisele Almeida', 'gialmeida@gmail.com', 'giselezinha', '37938502897', '(11)9977818797', uuid(), true, now(), now()),
('Henrique Toledo', 'henriquetoledo@gmail.com', 'henriquinho', '28938502898', '(11)9987818798', uuid(), true, now(), now());

--SQL Server
--INSERT INTO pet_tutor ( name, email, password, document_id, phone_number,
--                        pet_tutor_uuid, active, created_at,  updated_at) VALUES
--('Arnaldo Pereira', 'arnaldopereira@gmail.com', 'arnaldinho', '91938502821', '(11)9917818751)', NEWID(), 1, GETDATE(), GETDATE()),
--('Bernardo dos Santos', 'bernardosantos@gmail.com', 'bernardinho', '82938502892', '(11)9927818792', NEWID(), 1, GETDATE(), GETDATE()),
--('Carlos Eduardo', 'cadu@gmail.com', 'caduzinho', '739385028923', '(11)9937818793', NEWID(), 1, GETDATE(), GETDATE()),
--('Daniela Mattos', 'danimattos@gmail.com', 'danizinha', '649385028924', '(11)9947818794', NEWID(), 1, GETDATE(), GETDATE()),
--('Elias Queiroga', 'eliasqueiroga@gmail.com', 'eliazinho', '55938502895', '(11)9957818795', NEWID(), 1, GETDATE(), GETDATE()),
--('Fabiana Antunes', 'fabiantunes@gmail.com', 'fabizinha', '46938502896', '(11)9967818796', NEWID(), 1, GETDATE(), GETDATE()),
--('Gisele Almeida', 'gialmeida@gmail.com', 'giselezinha', '37938502897', '(11)9977818797', NEWID(), 1, GETDATE(), GETDATE()),
--('Henrique Toledo', 'henriquetoledo@gmail.com', 'henriquinho', '28938502898', '(11)9987818798', NEWID(), 1, GETDATE(), GETDATE());


INSERT INTO pet (   name, birthdate, specie, breed, health_description,
                    pet_uuid, created_at, updated_at, pet_tutor_pet_tutor_id) VALUES
('Apolo', '2011-01-01', 'Cachorro', 'Akita', 'Uma capsula de ezima pancreática por dia', uuid(), now(), now(), 1),
('Beethoven', '2012-02-02', 'Cachorro', 'Basset Hound', 'Um comprimido de antibiótico para otite por dia', uuid(), now(), now(), 2),
('Cuca', '2013-03-03', 'Cachorro', 'Chihuahua', '5 gotas de dexclorfeniramina uma vez por dia', uuid(), now(), now(), 3),
('Duque', '2014-04-04', 'Cachorro', 'Dalmata', '10 gotas de Homeopet Cist Control uma vez por dia', uuid(), now(), now(), 4),
('Eros', '2015-05-05', 'Cachorro', 'Doberman', null, uuid(), now(), now(), 5),
('Fox', '2016-06-06', 'Cachorro', 'Fila Brasileiro', 'Limpar bem as rugas do rosto', uuid(), now(), now(), 6),
('Glenda', '2017-07-07', 'Cachorro', 'Golden Retriever', 'Tyrox 200mcg a cada 12 horas', uuid(), now(), now(), 7),
('Haley', '2018-08-08', 'Gato', 'Himalaio', null, uuid(), now(), now(), 8);

--SQL Server
--INSERT INTO pet (   name, birthdate, specie, breed, health_description,
--                    pet_uuid, created_at, updated_at, pet_tutor_pet_tutor_id) VALUES
--('Apolo', '2011-01-01', 'Cachorro', 'Akita', 'Uma capsula de ezima pancreática por dia', NEWID(), GETDATE(), GETDATE(), 1),
--('Beethoven', '2012-02-02', 'Cachorro', 'Basset Hound', 'Um comprimido de antibiótico para otite por dia', NEWID(), GETDATE(), GETDATE(), 2),
--('Cuca', '2013-03-03', 'Cachorro', 'Chihuahua', '5 gotas de dexclorfeniramina uma vez por dia', NEWID(), GETDATE(), GETDATE(), 3),
--('Duque', '2014-04-04', 'Cachorro', 'Dalmata', '10 gotas de Homeopet Cist Control uma vez por dia', NEWID(), GETDATE(), GETDATE(), 4),
--('Eros', '2015-05-05', 'Cachorro', 'Doberman', null, NEWID(), GETDATE(), GETDATE(), 5),
--('Fox', '2016-06-06', 'Cachorro', 'Fila Brasileiro', 'Limpar bem as rugas do rosto', NEWID(), GETDATE(), GETDATE(), 6),
--('Glenda', '2017-07-07', 'Cachorro', 'Golden Retriever', 'Tyrox 200mcg a cada 12 horas', NEWID(), GETDATE(), GETDATE(), 7),
--('Haley', '2018-08-08', 'Gato', 'Himalaio', null, NEWID(), GETDATE(), GETDATE(), 8);

INSERT INTO hotel ( name, email, password, document_id, phone_number, description, rates,
                    hotel_uuid, active, fidelity, is_authenticated, created_at, updated_at) VALUES
('PetLand Jardins', 'contato@petland.com.br', 'petland', '11.837.734/0001-46', '(11)30615063', "Somos a PetLand Jardins, um hotel que entrega com excelência uma experiência rica com atividades, exercícios, alimentação, dormitórios e médicos prontos para cuidar da saúde do seu filho. Conte conosco para fornecer ao seu pet a mais incrível das experiências, aproveite e esqueça do pior, até por que seu pet merece o melhor.", 4.7, uuid(), true, true, false, now(), now()),
('Pet Cidade', 'contato@petcidade.com.br', 'petcidade', '20.867.423/0001-10', '(11)995306174', "Na Pet Cidade temos diversas atividades para o seu pet, aqui ele poderá brincar, nadar, comer e aprender a socializar com os outros pets através do adestramento, conte conosco para ajudar seu animalzinho a aproveitar o tempo longe de você da melhor forma possível. Na Pet Cidade contamos com diversos profissionais para proteger e cuidar do seu pet. Somente na Pet Cidade seu pet encontra a melhor experiência da cidade.", 3.8, uuid(), true, true, false, now(), now()),
('Mais Pets', 'contato@maispets.com.br', 'maispets', '43.239.777/0001-16', '(11)3061-5129', "Aqui na Mais Pets somos o hotel que aceita a maior variedade de pets na Cidade de São Paulo, aqui todos são bem vindos, temos cuidadores especializados em diversas espécies, temos locais próprios para cada espécie, alimentações naturais e saudáveis para seu animalzinho. Aproveite e nos visite para conhecer todos os serviços disponíveis. Mais Pets, do seu cachorrinho até o seu porquinho.", 4.2, uuid(), true, true, false, now(), now()),
('Alegra Pet', 'contato@alegrapet.com.br', 'alegrapet', '30.729.121/0001-30', '(11)3256-5553', "Alegra Pet está pronto para receber seu cachorrinho para se divertir e aproveitar enquanto você viaja. Nos estamos preparados para cuidar do seu doguinho com a maior excelência, aqui ele irá correr, brincar, tomar banho, passar por veterinários especializados em cães. No alegra pet, temos como objetivo tornar seu pet feliz enquanto estiver aqui. Confie em nós e deixe seu pet feliz aqui na Alegra Pet.", 4.6, uuid(), true, true, false, now(), now()),
('Casa Pet', 'contato@casapet.com.br', 'casapet', '33.472.866/0007-40', '(11)4304-8008', "A Casa Pet oferece ao seu bichinho um conforto que ele encontra na sua casa, com um ambiente higienizado, alimentação premium e dormitórios para diversos tamanhos e raças diferentes. Entregamos ao seu pet uma experiência única, para que ele aproveite enquanto você está longe. Conte com a casa pet para os momentos que precisar.", 4.1, uuid(), true, true, false, now(), now());

--SQL Server
--INSERT INTO hotel ( name, email, password, document_id, phone_number, description, rates,
--                    hotel_uuid, active, fidelity, is_authenticated, created_at, updated_at) VALUES
--('PetLand Jardins', 'contato@petland.com.br', 'petland', '11.837.734/0001-46', '(11)30615063', 'Somos a PetLand Jardins, um hotel que entrega com excelência uma experiência rica com atividades, exercícios, alimentação, dormitórios e médicos prontos para cuidar da saúde do seu filho. Conte conosco para fornecer ao seu pet a mais incrível das experiências, aproveite e esqueça do pior, até por que seu pet merece o melhor.', 4.7, NEWID(), 1, 1, 0, GETDATE(), GETDATE()),
--('Pet Cidade', 'contato@petcidade.com.br', 'petcidade', '20.867.423/0001-10', '(11)995306174', 'Na Pet Cidade temos diversas atividades para o seu pet, aqui ele poderá brincar, nadar, comer e aprender a socializar com os outros pets através do adestramento, conte conosco para ajudar seu animalzinho a aproveitar o tempo longe de você da melhor forma possível. Na Pet Cidade contamos com diversos profissionais para proteger e cuidar do seu pet. Somente na Pet Cidade seu pet encontra a melhor experiência da cidade.', 3.8, NEWID(), 1, 1, 0, GETDATE(), GETDATE()),
--('Mais Pets', 'contato@maispets.com.br', 'maispets', '43.239.777/0001-16', '(11)3061-5129', 'Aqui na Mais Pets somos o hotel que aceita a maior variedade de pets na Cidade de São Paulo, aqui todos são bem vindos, temos cuidadores especializados em diversas espécies, temos locais próprios para cada espécie, alimentações naturais e saudáveis para seu animalzinho. Aproveite e nos visite para conhecer todos os serviços disponíveis. Mais Pets, do seu cachorrinho até o seu porquinho.', 4.2, NEWID(), 1, 1, 0, GETDATE(), GETDATE()),
--('Alegra Pet', 'contato@alegrapet.com.br', 'alegrapet', '30.729.121/0001-30', '(11)3256-5553', 'Alegra Pet está pronto para receber seu cachorrinho para se divertir e aproveitar enquanto você viaja. Nos estamos preparados para cuidar do seu doguinho com a maior excelência, aqui ele irá correr, brincar, tomar banho, passar por veterinários especializados em cães. No alegra pet, temos como objetivo tornar seu pet feliz enquanto estiver aqui. Confie em nós e deixe seu pet feliz aqui na Alegra Pet.', 4.6, NEWID(), 1, 1, 0, GETDATE(), GETDATE()),
--('Casa Pet', 'contato@casapet.com.br', 'casapet', '33.472.866/0007-40', '(11)4304-8008', 'A Casa Pet oferece ao seu bichinho um conforto que ele encontra na sua casa, com um ambiente higienizado, alimentação premium e dormitórios para diversos tamanhos e raças diferentes. Entregamos ao seu pet uma experiência única, para que ele aproveite enquanto você está longe. Conte com a casa pet para os momentos que precisar.', 4.1, NEWID(), 1, 1, 0, GETDATE(), GETDATE());

INSERT INTO services_provided (
service_pool, service_playground, service_toys, service_bath, service_leathering, service_bedroom, service_food,
service_visitation, service_cam, service_exercises, service_training, service_dentist, service_vet, service_monitoring,
dogs_acepted, cats_acepted, others_acepted, average_price, guests_number, hotel_hotel_id) VALUES
(true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, "Até R$ 100,00", '28', 1),
(true, false, true, true, true, true, true, false, true, true, true, true, true, true, true, true, false, "Até R$ 200,00", '32', 2),
(true, true, false, false, true, true, true, true, true, true, true, false, true, true, true, true, true, "Até R$ 200,00", '23', 3),
(false, true, true, true, false, true, false, true, true, true, true, false, true, true, true, false, false, "Até R$ 100,00", '34', 4),
(true, false, false, true, true, false, false, true, true, false, true, true, true, true, true, true, true, "Até R$ 200,00", '25', 5);

--SQL Server
--INSERT INTO services_provided (
--service_pool, service_playground, service_toys, service_bath, service_leathering, service_bedroom, service_food,
--service_visitation, service_cam, service_exercises, service_training, service_dentist, service_vet, service_monitoring,
--dogs_acepted, cats_acepted, others_acepted, average_price, guests_number, hotel_hotel_id) VALUES
--(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 'Até R$ 100,00', 28, 1),
--(1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 'Até R$ 200,00', 32, 2),
--(1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 'Até R$ 200,00', 23, 3),
--(0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 'Até R$ 100,00', 34, 4),
--(1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 'Até R$ 200,00', 25, 5);

INSERT INTO partner (   name, email, password, document_id, phone_number, partner_uuid, active,
                        fidelity, is_authenticated, number_of_campaigns, created_at, updated_at) VALUES
('Cobasi', 'marketing@cobasi.com.br', 'cobasimkt', '53.153.938/0001-08', '(11)38318999',
    uuid(), true, true, false, 2, now(), now()),
('Pet Center', 'comercial@petz.com.br', 'petz123', '18.328.118/0040-15', '(11)21827380',
    uuid(), true, true, false, 1, now(), now()),
('Pet Love', 'comercial@petlove.com.br', 'petlove', '10.864.846/0001-23', '(11)30432113',
    uuid(), true, true, false, 1, now(), now());

--SQL Server
--INSERT INTO partner (   name, email, password, document_id, phone_number, partner_uuid, active,
--                        fidelity, is_authenticated, number_of_campaigns, created_at, updated_at) VALUES
--('Cobasi', 'marketing@cobasi.com.br', 'cobasimkt', '53.153.938/0001-08', '(11)38318999',
--    NEWID(), 1, 1, 0, 2, GETDATE(), GETDATE()),
--('Pet Center', 'comercial@petz.com.br', 'petz123', '18.328.118/0040-15', '(11)21827380',
--    NEWID(), 1, 1, 0, 1, GETDATE(), GETDATE()),
--('Pet Love', 'comercial@petlove.com.br', 'petlove', '10.864.846/0001-23', '(11)30432113',
--    NEWID(), 1, 1, 0, 1, GETDATE(), GETDATE());

INSERT INTO campaign (type, value, click, started_at, finished_at, partner_partner_id, hotel_hotel_id) VALUES
/*partner*/
('Silver', 4000.00, 10857, '2022-07-03', '2022-08-03', 1, null),
('Gold', 6000.00, 18974, '2022-08-04', '2022-09-04', 1, null),
('Gold', 6000.00, 21237, '2022-09-05', '2022-10-05', 1, null),
('Gold', 6000.00, 24974, '2022-10-06', '2022-11-06', 1, null),
('Gold', 4000.00, 18952, '2022-11-07', null, 1, null),
('Silver', 4000.00, 9238, '2022-09-20', '2022-10-20', 2, null),
('Gold', 6000.00, 16785, '2022-10-20', '2022-11-20', 2, null),
('Bronze', 2000.00, 4164, '2022-10-05', '2022-11-05', 3, null),
/*hotel*/
('Silver', 750.00, 1913, '2022-10-01', '2022-11-01', null, 1),
('Gold', 1000.00, 2626, '2022-10-02', '2022-11-02', null, 2),
('Silver', 750.00, 1828, '2022-10-03', '2022-11-03', null, 3),
('Bronze', 500.00, 1137, '2022-10-04', '2022-11-04', null, 4),
('Gold', 1000.00, 2734, '2022-10-05', '2022-11-05', null, 5);

INSERT INTO plan (plan_type, plan_value, hotel_hotel_id) VALUES
('Silver', 250.00, 1),
('Gold', 350.00, 2),
('Gold', 350.00, 3),
('Bronze', 150.00, 4),
('Gold', 350.00, 5);

--SQL Server
--INSERT INTO plano (plan_type, plan_value, hotel_hotel_id) VALUES
--('Silver', 250.00, 1),
--('Gold', 350.00, 2),
--('Gold', 350.00, 3),
--('Bronze', 150.00, 4),
--('Gold', 350.00, 5);

INSERT INTO address (
    address_code, address_street, address_number, address_complement, address_district,
    address_city, address_state, pet_tutor_pet_tutor_id, hotel_hotel_id, partner_partner_id) VALUES
/*pet tutor*/
('01411001', 'Rua Padre João Mauel', '607', 'Apto. 111', 'Cerqueira César', 'São Paulo', 'São Paulo', 1, null, null),
('01422000', 'Alameda  Franca', '850', 'Apto. 222', 'Cerqueira César', 'São Paulo', 'São Paulo', 2, null, null),
('01423003', 'Rua José Maria Lisboa', '973', 'Apto. 333', 'Jardim Paulista', 'São Paulo', 'São Paulo', 3, null, null),
('01415002', 'Rua Bela Cintra', '982', 'Apto. 444', 'Consolação', 'São Paulo', 'São Paulo', 4, null, null),
('01309010', 'Rua Antônio Carlos', '288', null, 'Consolação', 'São Paulo', 'São Paulo', 5, null, null),
('01241001', 'Rua Piauí', '537', 'Apto. 66', 'Higienópolis', 'São Paulo', 'São Paulo', 6, null, null),
('01230001', 'Rua Dr. Albuquerque Lins', '993', 'Apto. 777', 'Santa Cecíla', 'São Paulo', 'São Paulo', 7, null, null),
('01230001', 'Rua Santo Antônio', '955', 'Apto. 888', 'Bela Vista', 'São Paulo', 'São Paulo', 8, null, null),
/*hotel*/
('01415001', 'Rua Bela Cintra', '1559', null, 'Jardins', 'São Paulo', 'São Paulo', null, 1, null),
('01309000', 'Rua Luís Coelho', '206', null, 'Consolação', 'São Paulo', 'São Paulo', null, 2, null),
('01422001', 'Alameda Franca', '1546', null, 'Jardim Paulista', 'São Paulo', 'São Paulo', null, 3, null),
('01409001', 'Rua Itararé', '294', null, 'Bela Vista', 'São Paulo', 'São Paulo', null, 4, null),
('05409000', 'Rua Capote Valente', '185', null, 'Cerqueira César', 'São Paulo', 'São Paulo', null, 5, null),
/*partner*/
('05319010', 'Rua Manoel Velasco', '90', null, 'Vila Leopoldina', 'São Paulo', 'São Paulo', null, null, 1),
('05319010', 'Rua Guaratana', '555', '587 Sala 1', 'Pari', 'São Paulo', 'São Paulo', null, null, 2),
('04578910', 'Avenida das Nações Unidas', '12901', 'Conj 1201', 'Brooklin Paulista', 'São Paulo', 'São Paulo', null, null, 3);



