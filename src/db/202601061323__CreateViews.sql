create or replace view order_vw as select * from order;
grant SELECT,INSERT on order_db.order_vw to 'order_user'@'%';

create or replace view order_item_vw as select * from order_item;
grant SELECT,INSERT on order_db.order_item_vw to 'order_user'@'%';

create or replace view order_extras_vw as select * from order_extras;
grant SELECT,INSERT on order_db.order_extras_vw to 'order_user'@'%';

create or replace view menu_vw as select * from menu;
grant SELECT,INSERT on order_db.menu_vw to 'order_user'@'%';

create or replace view menu_extras_vw as select * from menu_extras;
grant SELECT,INSERT on order_db.menu_extras_vw to 'order_user'@'%';
