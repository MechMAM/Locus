drop database if exists locus_db;
create database if not exists locus_db;
use locus_db;

drop table if exists Pais;
create table if not exists Pais (
	pas_id int primary key not null auto_increment,
	pas_nome varchar(50) not null,
	pas_status tinyint not null
);

drop table if exists Estado;
create table if not exists Estado (
	etd_id int primary key not null auto_increment,
	etd_nome varchar(50) not null,
	etd_status tinyint not null,
	Pais_pas_id int not null 
);

drop table if exists Cidade;
create table if not exists Cidade (
	cdd_id int primary key not null auto_increment,
	cdd_nome varchar(50) not null,
	cdd_status tinyint not null,
	Estado_etd_id int not null 
);

drop table if exists Endereco;
create table if not exists Endereco (
	end_id int primary key not null auto_increment,
	end_bairro varchar(50) not null,
	end_logradouro varchar(75) not null,
	end_numero varchar(20) not null,
	end_complemento varchar(50) not null,
	Cidade_cdd_id int not null,
	end_cep varchar(10) not null
);

drop table if exists Empresa;
create table if not exists Empresa (
	emp_id int primary key not null auto_increment,
	emp_nome varchar(50) not null,
	emp_razao_social varchar(50) not null,
	emp_cnpj varchar(18) not null,
	emp_email varchar(60) not null
);

drop table if exists Reserva;
create table if not exists Reserva (
	res_id int primary key not null auto_increment,
	res_horario_reserva datetime not null,
	res_data_inicio datetime not null,
	res_data_fim datetime not null,
	res_timezone varchar(50) not null,
	res_preco decimal(6,2) not null,
	Espaco_esp_id int not null,
	Usuario_usu_id int not null,
	Avaliacao_ava_id int unique not null
);

drop table if exists Avaliacao;
create table if not exists Avaliacao (
	ava_id int primary key not null auto_increment,
	ava_comentario text not null,
	ava_nota_qualidade ENUM('0', '1', '2', '3', '4', '5') not null
);

drop table if exists Titulo;
create table if not exists Titulo (
	ttl_id int primary key not null auto_increment,
	ttl_data_pagamento datetime not null,
	ttl_valor_pagamento decimal(6,2) not null,
	ttl_status_pagamento ENUM('PENDENTE', 'PROCESSANDO', 'PAGO', 'CANCELADO') not null,
	Reserva_res_id int not null
);

drop table if exists Metodo_Cobranca;
create table if not exists Metodo_Cobranca (
	mtc_id int primary key not null auto_increment,
	mtc_tipo_cobranca enum('PIX', 'CRÉDITO') not null,
	mtc_data_vencimento date not null,
	Titulo_ttl_id int not null
);

drop table if exists Usuario;
create table if not exists Usuario (
	usu_id int primary key not null auto_increment,
	usu_nome varchar(50) not null,
	usu_cpf varchar(15) not null,
	usu_email varchar(60) not null,
	usu_telefone varchar(20) not null,
	usu_data_nascimento date not null,
	usu_senha varchar(255) not null
);

drop table if exists Espaco;
create table if not exists Espaco (
	esp_id int primary key not null auto_increment,
	esp_nome varchar(50) not null,
	esp_descricao text not null,
	esp_descricao_arredores text not null,
	esp_capacidade int not null,
	esp_area float not null,
	esp_tempo_limpeza time not null,
	esp_taxa_limpeza decimal(4,2) not null,
	esp_preco_horario decimal(6,2) not null,
	Endereco_end_id int unique not null,
	Empresa_emp_id int not null,
	Regra_Desconto_rds_id int unique not null,
	Disponibilidade_dip_id int not null
);

drop table if exists Estacionamento;
create table if not exists Estacionamento (
	est_id int primary key not null auto_increment,
	est_quantidade_vagas int not null,
	est_valor_hora decimal(4,2) not null,
	est_valor_periodo decimal(4,2) not null,
	est_valor_diaria decimal(4,2) not null,
	est_gratuito tinyint not null,
	Endereco_end_id int unique not null,
	Espaco_esp_id int not null
);

drop table if exists Regra_Desconto;
create table if not exists Regra_Desconto (
	rds_id int primary key not null auto_increment,
	rds_porcentagem_desconto float not null,
	Disponibilidade_dip_id int not null
);

drop table if exists Disponibilidade;
create table if not exists Disponibilidade (
	dip_id int primary key not null auto_increment,
	dip_horario_entrada datetime not null,
	dip_horario_saida datetime not null
);

drop table if exists Dia_Semana;
create table if not exists Dia_Semana (
	dse_id int primary key not null auto_increment,
	dse_domingo tinyint not null,
	dse_segunda tinyint not null,
	dse_terca tinyint not null,
	dse_quarta tinyint not null,
	dse_quinta tinyint not null,
	dse_sexta tinyint not null,
	dse_sabado tinyint not null
);

drop table if exists Acessibilidade;
create table if not exists Acessibilidade (
	acs_id int primary key not null auto_increment,
	acs_nome varchar(50) not null,
	acs_descricao text not null,
	acs_data_inclusao datetime not null default current_timestamp,
	acs_data_modificacao datetime not null default current_timestamp on update current_timestamp,
	acs_status boolean not null default 1
);

drop table if exists Proposito;
create table if not exists Proposito (
	prp_id int primary key not null auto_increment,
	prp_nome varchar(50) not null,
	prp_descricao text not null,
	prp_data_inclusao datetime not null,
	prp_data_modificacao datetime not null,
	prp_status tinyint not null
);



drop table if exists Servico;
create table if not exists Servico (
	srv_id int primary key not null auto_increment,
	srv_nome varchar(50) not null,
	srv_descricao text not null,
	srv_valor decimal(4,2) not null,
	srv_data_inclusao datetime not null,
	srv_data_modificacao datetime not null,
	srv_status tinyint not null,
	srv_gratuito tinyint not null
);

drop table if exists Imagem;
create table if not exists Imagem (
	img_id int primary key not null auto_increment,
	img_nome varchar(50) not null,
	img_caminho varchar(255) not null,
	img_descricao text not null,
	img_data_inclusao datetime not null,
	img_data_modificacao datetime not null,
	Espaco_esp_id int not null
);

drop table if exists Tipo_Espaco;
create table if not exists Tipo_Espaco (
	tes_id int primary key not null auto_increment,
	tes_nome varchar(50) not null,
	tes_descricao text not null,
	tes_data_inclusao datetime not null,
	tes_data_modificacao datetime not null,
	tes_status tinyint not null
);

drop table if exists Diferencial;
create table if not exists Diferencial (
	dif_id int primary key not null auto_increment,
	dif_nome varchar(50) not null,
	dif_descricao text not null,
	dif_data_inclusao datetime not null,
	dif_data_modificacao datetime not null,
	dif_status boolean not null
);

drop table if exists Espaco_has_Proposito;
create table if not exists Espaco_has_Proposito (
	Espaco_esp_id int not null,
	Proposito_prp_id int not null
);

drop table if exists Espaco_has_Acessibilidade;
create table if not exists Espaco_has_Acessibilidade (
	Espaco_esp_id int not null,
	Acessibilidade_acs_id int not null
);

drop table if exists Espaco_has_Servico;
create table if not exists Espaco_has_Servico (
	Espaco_esp_id int not null,
	Servico_srv_id int not null
);

drop table if exists Espaco_has_Diferencial;
create table if not exists Espaco_has_Diferencial (
	Espaco_esp_id int not null,
	Diferencial_dif_id int not null
);

drop table if exists Disponibilidade_has_Dia_Semana;
create table if not exists Disponibilidade_has_Dia_Semana (
	Disponibilidade_dip_id int not null,
	Dia_Semana_dse_id int not null
);

drop table if exists Espaco_has_Tipo_Espaco;
create table if not exists Espaco_has_Tipo_Espaco (
	Espaco_esp_id int not null,
	Tipo_Espaco_tes_id int not null
);

drop table if exists Empresa_has_Usuario;
create table if not exists Empresa_has_Usuario (
	Empresa_emp_id int not null,
	Usuario_usu_id int not null
);

alter table Estado
add constraint fk_pais foreign key (Pais_pas_id) references Pais(pas_id);

alter table Cidade
add constraint fk_estado foreign key (Estado_etd_id) references Estado(etd_id);

alter table Endereco
add constraint fk_cidade foreign key (Cidade_cdd_id) references Cidade(cdd_id);

alter table Reserva
add constraint fk_espaco foreign key (Espaco_esp_id) references Espaco(esp_id),
add constraint fk_usuario foreign key (Usuario_usu_id) references Usuario(usu_id),
add constraint fk_avaliacao foreign key (Avaliacao_ava_id) references Avaliacao(ava_id);

alter table Metodo_Cobranca
add constraint fk_titulo foreign key (Titulo_ttl_id) references Titulo(ttl_id);

alter table Titulo
add constraint fk_reserva foreign key (Reserva_res_id) references Reserva(res_id);

alter table Espaco
add constraint fk_empresa foreign key (Empresa_emp_id) references Empresa(emp_id),
add constraint fk_disponibilidade foreign key (Disponibilidade_dip_id) references Disponibilidade(dip_id),
add constraint fk_endereco foreign key (Endereco_end_id) references Endereco(end_id),
add constraint fk_regra_desconto foreign key (Regra_Desconto_rds_id) references Regra_Desconto(rds_id);

alter table Estacionamento
add constraint fk_endereco1 foreign key (Endereco_end_id) references Endereco(end_id),
add constraint fk_espaco1 foreign key (Espaco_esp_id) references Espaco(esp_id);

alter table Regra_Desconto
add constraint fk_disponibilidade1 foreign key (Disponibilidade_dip_id) references Disponibilidade(dip_id);

alter table Imagem
add constraint fk_espaco2 foreign key (Espaco_esp_id) references Espaco(esp_id);

alter table Espaco_has_Proposito
add constraint fk_espaco3 foreign key (Espaco_esp_id) references Espaco(esp_id),
add constraint fk_proposito foreign key (Proposito_prp_id) references Proposito(prp_id);

alter table Espaco_has_Acessibilidade
add constraint fk_espaco4 foreign key (Espaco_esp_id) references Espaco(esp_id),
add constraint fk_acessibilidade foreign key (Acessibilidade_acs_id) references Acessibilidade(acs_id);

alter table Espaco_has_Servico
add constraint fk_espaco5 foreign key (Espaco_esp_id) references Espaco(esp_id),
add constraint fk_servico foreign key (Servico_srv_id) references Servico(srv_id);

alter table Espaco_has_Diferencial
add constraint fk_espaco6 foreign key (Espaco_esp_id) references Espaco(esp_id),
add constraint fk_diferencial foreign key (Diferencial_dif_id) references Diferencial(dif_id);

alter table Disponibilidade_has_Dia_Semana
add constraint fk_disponibilidade2 foreign key (Disponibilidade_dip_id) references Disponibilidade(dip_id),
add constraint fk_dia_semana foreign key (Dia_Semana_dse_id) references Dia_Semana(dse_id);

alter table Espaco_has_Tipo_Espaco
add constraint fk_espaco7 foreign key (Espaco_esp_id) references Espaco(esp_id),
add constraint fk_tipo_espaco foreign key (Tipo_Espaco_tes_id) references Tipo_Espaco(tes_id);

alter table Empresa_has_Usuario
add constraint fk_empresa1 foreign key (Empresa_emp_id) references Empresa(emp_id),
add constraint fk_usuario1 foreign key (Usuario_usu_id) references Usuario(usu_id);
