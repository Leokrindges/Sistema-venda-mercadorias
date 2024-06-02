create table compra (
	id serial primary key,
	data varchar(45) not null,
	fornecedor_id int not null
);

create table fornecedor (
	id serial primary key,
	nome varchar(150) not null,
	email varchar(45) not null,
	telefone varchar(45) not null,
	cnpj varchar(45) not null
);

create table item_compra (
	id serial primary key,
	compra_id int not null,
	produto_id int not null,
	qtde int not null,
	valor decimal(10,2) not null
);

create table produto (
	id serial primary key,
	descricao varchar(150) not null,
	valor_unitario decimal(10,2) not null,
	qtde_estoque varchar(45) not null
);

create table item_pedido (
	id serial primary key,
	produto_id int not null,
	pedido_id int not null,
	qtde int not null,
	valor_item decimal(10,2) not null
);

create table pedido (
	id serial primary key,
	data date not null,
	endereco_entrega varchar(45) not null,
	observacao varchar(500) not null,
	cliente_id int not null	
);

create table cliente (
	id serial primary key,
	nome varchar(150) not null,
	email varchar(45) not null,
	cpf varchar(45) not null,
	telefone varchar(45) not null
);

create table cliente_endereco (
	id serial primary key,
	cliente_id int not null,
	endereco_id int not null
);

create table endereco (
	id serial primary key,
	descricao varchar(45) not null,
	cep varchar(10) not null
);

alter table compra add foreign key ("fornecedor_id") references fornecedor("id");
alter table item_compra add foreign key ("compra_id") references compra("id");
alter table item_compra add foreign key ("produto_id") references produto("id");
alter table item_pedido add foreign key ("produto_id") references produto ("id");
alter table item_pedido add foreign key ("pedido_id") references pedido ("id");
alter table pedido add foreign key ("cliente_id") references cliente("id");
alter table cliente_endereco add foreign key ("cliente_id") references cliente ("id");
alter table cliente_endereco add foreign key ("endereco_id") references endereco ("id");


