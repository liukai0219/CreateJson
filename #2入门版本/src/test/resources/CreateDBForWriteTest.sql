DELETE FROM Customer;
DELETE FROM Acount;
DELETE FROM Tags;
INSERT INTO customer(id, _index, guid, active, acount_id, picture, age, eyecolor, lastName, firstName, company, email, phone, address, about, favoriteFruit) VALUES ('999999999999988','0','05f531f2-ab5a-470f-b77d-9be077909412',0,'148998','http://placehold.it/32x32',31,'blue','Chavez','Christi','ZEROLOGY','christi.chavez@zerology.ca','+1(928)536-3512','889 Stryker Court, Glenbrook, Michigan, 2079','Aliquip eiusmod commodo id aliquip exercitation ut.','apple');
INSERT INTO acount values('148998','$12,123',sysdate(),'root',sysdate(),'root');
INSERT INTO tags values('123456789','999999999999988','tag1',sysdate(),'root',sysdate(),'root');
INSERT INTO tags values('123456788','999999999999988','tag2',sysdate(),'root',sysdate(),'root');