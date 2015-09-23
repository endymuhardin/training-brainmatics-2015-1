drop table if exists s_user_role;
drop table if exists s_roles;
drop table if exists s_users;

create table s_users (
    id VARCHAR(36) PRIMARY KEY,
    username VARCHAR(30) NOT NULL,
    password VARCHAR(255) NOT NULL,
    active BOOLEAN
);

insert into s_users (id, username, password, active)
values('u001', 'endy', '123', true);

insert into s_users (id, username, password, active)
values('u002', 'adi', '123', true);

create table s_roles (
    id VARCHAR(36) PRIMARY KEY,
    nama VARCHAR(255) NOT NULL
);

insert into s_roles (id, nama)
values ('adm', 'ROLE_ADMIN');

insert into s_roles (id, nama)
values ('stf', 'ROLE_STAFF');


create table s_user_role (
    id_user VARCHAR(36) NOT NULL,
    id_role VARCHAR(36) NOT NULL
);

insert into s_user_role (id_user, id_role)
values ('u001', 'adm');

insert into s_user_role (id_user, id_role)
values ('u001', 'stf');

insert into s_user_role (id_user, id_role)
values ('u002', 'stf');

select username, password, active as enabled from s_users where username = 'endy';

select r.nama as authority 
from s_users u join s_user_role ur on u.id = ur.id_user
join s_roles r on ur.id_role = r.id
where u.username = 'endy';
