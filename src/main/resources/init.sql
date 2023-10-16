create database if not exists test;
use test;
    drop table if exists Track;
    drop table if exists Artist;

    create table Artist(
        Id int primary key auto_increment,
        name nvarchar(100)
    );
    create table Track(
        Id int primary key auto_increment,
        name nvarchar(100),
        artist_id int not null,
        foreign key (artist_id) references Artist(Id)
    );
