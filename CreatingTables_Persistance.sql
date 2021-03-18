
use Precision;

create table Country(
	CountryCode varchar(5),
	Country varchar(20) not null
	primary key (CountryCode)
);

create table ZipcodeCity(
	ZipCode varchar(10),
	CountryCode varchar(5),
	City varchar(30) not null,
	primary key (CountryCode, ZipCode)
);

create table Supplier(
	Email varchar(50),
	Name varchar(50),
	Address varchar(80) not null,
	CountryCode varchar(5),
	PhoneNo varchar(12),
	Zipcode varchar(10),
	primary key (Email)
);

create table Customer(
	CustomerNo int,
	Fname varchar(20) not null,
	Lname varchar(20) not null,
	Address varchar(80) not null,
	CountryCode varchar(5) not null,
	PhoneNo varchar(12) not null,
	Zipcode varchar(10) not null,
	primary key (CustomerNo)
);

create table SaleOrder(
	OrderNo int,
	OrderDate date not null,
	Amount float not null,
	DeliveryStatus varchar(200),
	DeliveryDate date not null,
	CustomerNo int,
	primary key (OrderNo)
)

create table Invoice (
	InvoiceNo int,
	paymentDate DateTime,
	saleOrderNo int,
	primary key (InvoiceNo)
);

create table OrderLine (
	OrderNo int,
	ProductBarcode int not null,
	Amount int not null,
	OrderType varchar(50) not null,
	primary key(OrderNo, ProductBarcode)
);

create table Product (
	Barcode int,
	Name varchar(30) not null,
	PurchacePrice decimal(15,2) not null,
	SalesPrice decimal(15,2) not null,
	RentPrice decimal(15,2) not null,
	CountryOfOrigin varchar(30) not null,
	MinStock int not null,
	CurrenyStock int not null,
	ProductType varchar(30) not null,
	SupplierEmail varchar(50) not null,
	primary key(Barcode)
);

create table Clothing (
	Barcode int,
	Type varchar(30) not null,
	Size varchar(30) not null,
	colour varchar(30) not null,
	primary key(Barcode)
);

create table Equipment (
	Barcode int,
	Type varchar(30) not null,
	Description varchar(1200) not null,
	primary key(Barcode)
);

create table GunReplica (
	Barcode int,
	Calibre decimal(7,4) not null,
	Material varchar(200) not null,
	primary key(barcode)
);

alter table ZipcodeCity
add foreign key(CountryCode) references Country(CountryCode);

alter table Supplier
add foreign key (CountryCode, Zipcode) references ZipcodeCity(CountryCode, Zipcode);

alter table Customer
add foreign key(CountryCode, Zipcode) references ZipcodeCity(CountryCode, Zipcode);

alter table SaleOrder
add foreign key (CustomerNo) references Customer(CustomerNo);

alter table Invoice
add foreign key (saleOrderNo) references SaleOrder(OrderNo);

alter table OrderLine
add foreign key (OrderNo) references SaleOrder(OrderNo);

alter table OrderLine
add foreign key (ProductBarcode) references Product(Barcode);

alter table Product
add foreign key (SupplierEmail) references Supplier(Email);

alter table Clothing
add foreign key (Barcode) references Product(Barcode);

alter table Equipment
add foreign key (Barcode) references Product(Barcode);

alter table GunReplica
add foreign key (Barcode) references Product(Barcode);


select P.Barcode, P.Name as ProductName, S.Name as SupplierName, S.CountryCode as SupplierCountryCode, ZC.City, C.CountryCode as CustomerCountryCode
from Product as P
inner join Supplier as S
on (P.SupplierEmail = S.Email)
inner join ZipcodeCity as ZC
on (S.CountryCode = ZC.CountryCode and S.Zipcode = ZC.Zipcode)
inner join Country as C
on (ZC.CountryCode = C.CountryCode)
