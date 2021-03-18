use Precision;


insert into Country values('+48', 'Poland');
insert into Country values('+421', 'Slovakia');
insert into Country values('+420', 'Czech Republic');
insert into Country values('+45', 'Denmark');
insert into Country values('+1', 'US');

insert into ZipcodeCity values('9000', '+45', 'Aalborg');
insert into ZipcodeCity values('9100', '+45', 'Aalborg');
insert into ZipcodeCity values('9220', '+45', 'Aalborg Ost');
insert into ZipcodeCity values('9210', '+45', 'Aalborg So');
insert into ZipcodeCity values('9200', '+45', 'Aalborg Sv');
insert into ZipcodeCity values('01002', '+421', 'Zilina');
insert into ZipcodeCity values('10001', '+1', 'NewYork City');
insert into ZipcodeCity values('10002', '+1', 'NewYork City');
insert into ZipcodeCity values('10003', '+1', 'NewYork City');


insert into Supplier values('custom@jamesboot.com', 'James Boot', 'Manhattan 3', '+1', '9105568', '10001');
insert into Supplier values('custom@macys.com', 'Macy''s', 'Manhattan 4', '+1', '9105543', '10001');
insert into Supplier values('custom@nomadicworldapparel.com', 'Nomadic World Apparel', '5th Ave', '+1', '9105542', '10003');
insert into Supplier values('custom@neelamfashions.com', 'Neelam Fashions', '134 W 29th St', '+1', '9104568', '10002');

insert into Customer values(101, 'John', 'Smith', 'Poul Paghs Gade 1', '+45', '50506578', '9000');
insert into Customer values(102, 'John', 'Smith', 'Poul Paghs Gade 1', '+45', '50506578', '9000');
insert into Customer values(103, 'Same', 'Dude', 'Carit Etlars Gade 5', '+45', '50504357', '9000');
insert into Customer values(104, 'Marry', 'Lone', 'Carit Etlars Gade 2', '+45', '50354357', '9000');
insert into Customer values(105, 'Rikke', 'Alt', 'Carit Etlars Gade 10', '+45', '50503245', '9000');
insert into Customer values(106, 'Same', 'Broad', 'Sofiendalsvej', '+45', '50504357', '9000');

insert into SaleOrder values(1001, '2021-3-18', 4000, 'Not delivered', '2021-3-21', 101);
insert into SaleOrder values(1002, '2021-3-17', 1000, 'Not delivered', '2021-3-20', 101);
insert into SaleOrder values(1003, '2021-3-14', 200, 'Delivered', '2021-3-17', 101);
insert into SaleOrder values(1004, '2021-3-10', 2200, 'Delivered', '2021-3-14', 104);
insert into SaleOrder values(1005, '2021-3-14', 6200, 'Delivered', '2021-3-17', 106);


insert into Invoice values(1001, '2021-3-18', 1001);
insert into Invoice values(1002, '2021-3-17', 1002);
insert into Invoice values(1003, '2021-3-14', 1003);
insert into Invoice values(1004, '2021-3-10', 1004);
insert into Invoice values(1005, '2021-3-14', 1005);

insert into Product values(100200, 'Cowboy Hat', 200, 500, 50, 'US', 0, 10, 'Clothing', 'custom@jamesboot.com');
insert into Product values(100201, 'Cowboy Jeans', 200, 500, 50, 'US', 0, 10, 'Clothing', 'custom@nomadicworldapparel.com');
insert into Product values(100202, 'Colt Magnum', 200, 500, 50, 'US', 0, 10, 'Gun Replica', 'custom@macys.com');
insert into Product values(100203, 'Carabina Puma', 200, 500, 50, 'US', 0, 10, 'Gun Replica', 'custom@macys.com');
insert into Product values(100204, 'Cone', 200, 500, 50, 'US', 0, 10, 'Equipment', 'custom@neelamfashions.com');
insert into Product values(100205, 'Hay Ball', 200, 500, 50, 'US', 0, 10, 'Equipment', 'custom@neelamfashions.com');


insert into Clothing values(100200, 'Hats', 'All sizes', 'Black');
insert into Clothing values(100201, 'Jeans', 'S', 'Brown');

insert into Equipment values(100204, 'Environment', 'It''s literally a cone!');
insert into Equipment values(100205, 'Environment', 'It''s a Hay Ball lol!');

insert into GunReplica values(100202, 44, 'Wood, Steel');
insert into GunReplica values(100203, 38, 'Wood, Steel');



select * from Country;
select * from ZipcodeCity;
select * from Supplier;
select * from Customer;
select * from SaleOrder;
select * from Invoice;
select * from Product
left join Clothing
on (Product.Barcode = Clothing.Barcode)
left join Equipment
on (Product.Barcode = Equipment.Barcode)
left join GunReplica
on (Product.Barcode = GunReplica.Barcode);