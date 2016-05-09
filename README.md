# RestHello

Database will be created automatically.

## 1. Start using Tomcat

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

## CI

SEE https://travis-ci.org/proselytear/Greeting/ ![My image](https://travis-ci.org/proselytear/RestHello.svg?branch=master)
