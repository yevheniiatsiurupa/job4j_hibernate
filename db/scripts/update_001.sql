create table if not exists item(
             id serial primary key,
             description varchar(200),
             created timestamp,
             done boolean

);