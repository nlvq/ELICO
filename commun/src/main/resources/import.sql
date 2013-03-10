insert into Utilisateur(UTILISATEUR_LOGIN,UTILISATEUR_PASSWORD,UTILISATEUR_LASTNAME,UTILISATEUR_FIRSTNAME,UTILISATEUR_PHONENUMBER) values ('toto1','pwd','t1','oto','0123456789')
insert into Utilisateur(UTILISATEUR_LOGIN,UTILISATEUR_PASSWORD,UTILISATEUR_LASTNAME,UTILISATEUR_FIRSTNAME,UTILISATEUR_PHONENUMBER) values ('toto2','pwd','t2','oto','0123456789')
insert into Utilisateur(UTILISATEUR_LOGIN,UTILISATEUR_PASSWORD,UTILISATEUR_LASTNAME,UTILISATEUR_FIRSTNAME,UTILISATEUR_PHONENUMBER) values ('toto3','pwd','t3','oto','0123456789')
insert into Utilisateur(UTILISATEUR_LOGIN,UTILISATEUR_PASSWORD,UTILISATEUR_LASTNAME,UTILISATEUR_FIRSTNAME,UTILISATEUR_PHONENUMBER) values ('toto4','pwd','t4','oto','0123456789')

insert into Organisation(ORGANISATION_TITLE,ORGANISATION_TYPE) values ('org1','enterprise')
insert into Organisation(ORGANISATION_TITLE,ORGANISATION_TYPE) values ('org2','department')

insert into WorkSpace(WORKSPACE_TITLE,UTILISATEUR_ID,ORGANISATION_ID) values ('ws1',1,1)
insert into WorkSpace(WORKSPACE_TITLE,UTILISATEUR_ID,ORGANISATION_ID) values ('ws2',3,2)

insert into Droit(DROIT_TITLE) values (0)
insert into Droit(DROIT_TITLE) values (1)
insert into Droit(DROIT_TITLE) values (2)

insert into Role(ROLE_TITLE) values ('reader')
insert into Role(ROLE_TITLE) values ('engineer')

insert into SavoirFaire(SAVOIRFAIRE_TITLE) values ('reader')
insert into SavoirFaire(SAVOIRFAIRE_TITLE) values ('engineer')

insert into Version(VERSION_NUMBER) values ('1.0')
insert into Version(VERSION_NUMBER) values ('2.0')

insert into WorkPackage(WORKPACKAGE_TITLE,WORKPACKAGE_STARTDATE,WORKPACKAGE_ENDDATE,ORGANISATION_ID,VERSION_ID,WORKSPACE_ID) values ('wp1','2013-01-01 00:00:00','2013-01-11 00:00:00',1,1,1)
insert into WorkPackage(WORKPACKAGE_TITLE,WORKPACKAGE_STARTDATE,WORKPACKAGE_ENDDATE,ORGANISATION_ID,VERSION_ID,WORKSPACE_ID) values ('wp2','2013-01-02 00:00:00','2013-01-12 00:00:00',1,2,1)
insert into WorkPackage(WORKPACKAGE_TITLE,WORKPACKAGE_STARTDATE,WORKPACKAGE_ENDDATE,ORGANISATION_ID,VERSION_ID,WORKSPACE_ID) values ('wp3','2013-01-03 00:00:00','2013-01-13 00:00:00',2,1,2)

insert into Maturite(MATURITE_TITLE,MATURITE_COMMENTARY) values (0,'comm')
insert into Maturite(MATURITE_TITLE,MATURITE_COMMENTARY) values (1,'comm')

insert into Objet(OBJET_TYPE,OBJET_DESCRIPTION,OBJET_CONTENT,MATURITE_ID) values ('text','desc','aaaaa',1)
insert into Objet(OBJET_TYPE,OBJET_DESCRIPTION,OBJET_CONTENT,MATURITE_ID) values ('text','desc','bbbbbbbbb',2)
