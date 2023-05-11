insert into acessibilidade (acs_nome, acs_descricao) values ('entrada', 'Entrada sem degraus'),('portas_largas', 'Portas com mais de 81 cm'),('acesso_palco', 'Acesso ao palco sem degraus'),('banheiros', 'Banheiros Acessíveis'), ('vagas_pcd', 'Vagas de estacionamento para PcD'), ('cadeirante_plateia', 'Lugar para cadeirante na platéia');

select * from acessibilidade;

update acessibilidade set acs_nome = 'entrada' where acs_id = 1;