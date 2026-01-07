create table lgc_order (
    id bigint auto_increment primary key,
    user nvarchar(255) not null,
    created_at datetime default current_timestamp
);

create table order_item (
    id bigint auto_increment ,
    order_id bigint not null,
    item nvarchar(255) not null,
    primary key (id, order_id)
);

create table order_extras (
    id bigint auto_increment  ,
    order_item_id bigint not null,
    extra nvarchar(255) not null,
    type nvarchar(100) not null,
    primary key (id, order_item_id)
);

create table menu (
    id bigint auto_increment primary key,
    item nvarchar(255) not null
);

create table menu_extras (
    id bigint auto_increment ,
    menu_id bigint not null,
    extra nvarchar(255) not null,
    primary key (id, menu_id)
);
