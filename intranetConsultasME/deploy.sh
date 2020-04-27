git pull
cd ../ConsultasME/
mvn clean install -DrepositoryId=nexus-releases -Djavax.net.ssl.trustStore=/home/invoke/Documents/tesoreria/git/contenerizacion/redhat-tgr/deployments/mavenKeystore -Djavax.net.ssl.trustStorePassword=asdqwe123
cd ../PkgConsultasMonExEJB/
mvn clean install -DrepositoryId=nexus-releases -Djavax.net.ssl.trustStore=/home/invoke/Documents/tesoreria/git/contenerizacion/redhat-tgr/deployments/mavenKeystore -Djavax.net.ssl.trustStorePassword=asdqwe123
cd ../PkgCMonExEJB/
mvn clean install -DrepositoryId=nexus-releases -Djavax.net.ssl.trustStore=/home/invoke/Documents/tesoreria/git/contenerizacion/redhat-tgr/deployments/mavenKeystore -Djavax.net.ssl.trustStorePassword=asdqwe123
cd ../UtilesCMonEx/
mvn clean install -DrepositoryId=nexus-releases -Djavax.net.ssl.trustStore=/home/invoke/Documents/tesoreria/git/contenerizacion/redhat-tgr/deployments/mavenKeystore -Djavax.net.ssl.trustStorePassword=asdqwe123
cd ../intranetConsultasME/
mvn clean install -DrepositoryId=nexus-releases -Djavax.net.ssl.trustStore=/home/invoke/Documents/tesoreria/git/contenerizacion/redhat-tgr/deployments/mavenKeystore -Djavax.net.ssl.trustStorePassword=asdqwe123
cp target/*.ear /home/invoke/EAP-7.2/standalone/deployments/
