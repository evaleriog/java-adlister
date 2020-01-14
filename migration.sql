CREATE DATABASE IF NOT EXISTS adlister_db;

USE adlister_db;

CREATE TABLE IF NOT EXISTS users(
    id int unsigned NOT NULL AUTO_INCREMENT,
    username varchar(50) DEFAULT NULL,
    email varchar(50) DEFAULT NULL,
    password varchar(30) DEFAULT NULL,
    PRIMARY KEY (id)
);

insert into users (username, email, password) values ('wsteptowe0', 'jdelwater0@ustream.tv', 'c2lwQY5s');
insert into users (username, email, password) values ('qheath1', 'nbonder1@pcworld.com', 'OTxBvm');
insert into users (username, email, password) values ('umuddimer2', 'amercer2@jugem.jp', 'hc4W7hicls87');
insert into users (username, email, password) values ('dcockton3', 'fbalint3@jiathis.com', 'emS2z445V7');
insert into users (username, email, password) values ('tballinger4', 'bphilott4@constantcontact.com', 'vAJpcK');
insert into users (username, email, password) values ('claudham5', 'jberryman5@baidu.com', 'L2s7wk');
insert into users (username, email, password) values ('dcouvert6', 'apeter6@loc.gov', 'xa2wTR');
insert into users (username, email, password) values ('hsergeant7', 'jabramovic7@prlog.org', 'T4ih5b07Sh');
insert into users (username, email, password) values ('bleaver8', 'blinden8@google.co.uk', 'icHLCV3y');
insert into users (username, email, password) values ('vtinsey9', 'kpape9@scribd.com', 'pCLZvUGvEEU5');

CREATE TABLE IF NOT EXISTS ads (
    id int unsigned NOT NULL AUTO_INCREMENT,
    user_id int unsigned NOT NULL,
    title varchar(50) DEFAULT NULL,
    description varchar(500) DEFAULT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

insert into ads (user_id, title, description) values (6, 'instruction set', 'Multi-channelled holistic project');
insert into ads (user_id, title, description) values (3, 'incremental', 'User-centric 6th generation methodology');
insert into ads (user_id, title, description) values (4, 'focus group', 'Total foreground circuit');
insert into ads (user_id, title, description) values (2, 'client-driven', 'Virtual bottom-line benchmark');
insert into ads (user_id, title, description) values (10, 'Automated', 'Object-based intangible matrices');
insert into ads (user_id, title, description) values (5, 'matrices', 'Quality-focused system-worthy toolset');
insert into ads (user_id, title, description) values (8, 'initiative', 'Open-source client-server matrices');
insert into ads (user_id, title, description) values (2, 'Function-based', 'Customer-focused methodical framework');
insert into ads (user_id, title, description) values (4, 'local area network', 'Up-sized bandwidth-monitored forecast');
insert into ads (user_id, title, description) values (3, 'zero tolerance', 'Business-focused high-level parallelism');
insert into ads (user_id, title, description) values (2, 'systematic', 'Business-focused full-range frame');
insert into ads (user_id, title, description) values (7, 'Pre-emptive', 'Right-sized impactful support');
insert into ads (user_id, title, description) values (3, 'solution-oriented', 'Cloned 24/7 analyzer');
insert into ads (user_id, title, description) values (10, 'implementation', 'Innovative regional emulation');
insert into ads (user_id, title, description) values (4, 'adapter', 'Mandatory incremental projection');
insert into ads (user_id, title, description) values (1, 'Devolved', 'Streamlined intermediate implementation');
insert into ads (user_id, title, description) values (1, 'Cloned', 'Self-enabling systematic benchmark');
insert into ads (user_id, title, description) values (10, 'Multi-channelled', 'Open-source disintermediate installation');
insert into ads (user_id, title, description) values (1, 'zero administration', 'Organic fault-tolerant hardware');
insert into ads (user_id, title, description) values (8, 'Vision-oriented', 'Reverse-engineered tangible process improvement');
