create table if not exists users(
    id serial primary key,
    name text,
    phone text unique,
    email text unique,
    password text
);

create table if not exists mark(
    id serial primary key,
    name text
);

create table if not exists model(
    id serial primary key,
    name text
);

create table if not exists typeBody(
    id serial primary key,
    name text
);

create table if not exists photo(
    id serial primary key,
    title text
);

create table if not exists item(
    id serial primary key,
    mark_id int not null references mark(id),
    model_id int not null references model(id),
    transmission text,
    drive text,
    typeBody_id int not null references typeBody(id),
    photo_id int not null references photo(id),
    description text,
    users_id int not null references users(id),
    sold boolean default false
);

