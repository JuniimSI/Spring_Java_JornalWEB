# Application Spring (JAVA)

Trabalho desenvolvido durante disciplina de desenvolvimento - UFC - Quixadá - Sistemas de Informação

## Tecs
- Java
- Spring Framework
- JSP

Dados para insert:

```bash
insert into PAPEL (PAPEL_NOME) values ('Editor');
insert into PAPEL (PAPEL_NOME) values ('Jornalista');
insert into PAPEL (PAPEL_NOME) values ('Leitor');

insert into USUARIO (USUARIO_NOME, USUARIO_EMAIL, USUARIO_LOGIN, USUARIO_SENHA) values ('Administrador do Sistema', 'admin@admin.sys', 'admin', '8C6976E5B5410415BDE908BD4DEE15DFB167A9C873FC4BB8A81F6F2AB448A918');

insert into USUARIO (USUARIO_NOME, USUARIO_EMAIL, USUARIO_LOGIN, USUARIO_SENHA) values ('Leitor do Sistema', 'leitor@leitor.sys', 'leitor', '8C6976E5B5410415BDE908BD4DEE15DFB167A9C873FC4BB8A81F6F2AB448A918');

insert into PAPEL_USUARIO(USUARIO_ID, PAPEL_ID) values(1,1);
insert into PAPEL_USUARIO(USUARIO_ID, PAPEL_ID) values(1,2);
insert into PAPEL_USUARIO(USUARIO_ID, PAPEL_ID) values(1,3);
insert into PAPEL_USUARIO(USUARIO_ID, PAPEL_ID) values(2,3);



insert into SECAO (SECAO_TITULO, SECAO_DESCRICAO) values ('Esporte', 'Tudo de esportes') , ('Ciencia','Tudo de ciencias');
insert into CLASSIFICADO (COMPRADOR, CLASSIFICADO_MELHOR_OFERTA, CLASSIFICADO_PRECO, CLASSIFICADO_TELEFONE, CLASSIFICADO_TEXTO, CLASSIFICADO_TITULO, USUARIO_ID) values ('Leitor do Sistema', 100.0, 100.0,'(88)993180888', 'Olha esse imovel', 'Casa boa', 1);

```
