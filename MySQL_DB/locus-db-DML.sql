insert into acessibilidade (acs_nome, acs_descricao) values 
('entrada', 'Entrada sem degraus'),
('portas_largas', 'Portas com mais de 81 cm'),
('acesso_palco', 'Acesso ao palco sem degraus'),
('banheiros', 'Banheiros Acessíveis'),
('vagas_pcd', 'Vagas de estacionamento para PcD'),
('cadeirante_plateia', 'Lugar para cadeirante na platéia');

select * from acessibilidade;

update acessibilidade set acs_nome = 'entrada' where acs_id = 1;

insert into proposito (prp_nome, prp_descricao) values 
('Palestras','Local semelhante a um auditório'),
('Seminários','Local com bons projetores e recursos audiovisuais'),
('Peças Teatrais','Local com equipamentos de palco e boa acústica para apresentações'),
('Convenções','Local com boa área para mostra e circulação de pessoas'),
('Recitais','Local com boa acústica e equipamentos para apresentações'),
('Eventos empresariais','Local adequado para apresentações empresariais'),
('Colações de grau','Local para muitas pessoas e com recursos de audiovisuais');

select * from proposito;

/*teste*/
