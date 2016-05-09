# RestHello

## 1. Start using Tomcat
### 1.1 Create database using files

database/mysql/initDB.sql
database/mysql/populateDB.sql

### 1.2 Run RestHello Application

mvn tomcat7:run
Visit URL:

http://127.0.0.1:8080/hello/contacts?nameFilter=^B.*$
or
http://127.0.0.1:8080/hello/contacts?nameFilter=^.*[il].*$

## 2. Start using Vagrant

vagrant up
vagrant ssh

cd /vagrant/

mvn tomcat7:run

Visit URL:
http://192.168.100.101:8080/hello/contacts?nameFilter=^.*[ABC].*$