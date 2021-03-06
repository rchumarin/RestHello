Vagrant.configure(2) do |config|

  config.vm.box = "ubuntu/trusty64"
  config.vm.network "private_network", ip: "192.168.100.101"
  config.vm.provision 'shell', inline: $installPrograms
  config.vm.provision 'shell', inline: $installDatabase
  config.vm.provision 'shell', inline: $setupDatabase
end

$installPrograms = <<SCRIPT
  echo -e "\n--- Installing needed software... ---\n"
  sudo add-apt-repository -y ppa:webupd8team/java
  sudo apt-get update
  echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | sudo /usr/bin/debconf-set-selections
  sudo apt-get install -y oracle-java8-set-default
  sudo apt-get install -y maven
SCRIPT

$installDatabase = <<SCRIPT
    echo -e "\n--- Installing MySQL ---\n"
    debconf-set-selections <<< 'mysql-server mysql-server/root_password password root'
    debconf-set-selections <<< 'mysql-server mysql-server/root_password_again password root'
    apt-get update
    apt-get install -y mysql-server
SCRIPT

$setupDatabase = <<SCRIPT
 echo -e "\n--- Creating database... ---\n"
 sudo nano /etc/mysql/my.cnf
 change:
 bind-address            = 0.0.0.0

 mysql -u root -p

 use mysql
 GRANT ALL ON *.* to root@'localhost' IDENTIFIED BY 'root';
 FLUSH PRIVILEGES;
 exit

 sudo /etc/init.d/mysql restart

 mysql -uroot -proot -e "CREATE DATABASE contact_manger IF NOT EXISTS;"

SCRIPT
