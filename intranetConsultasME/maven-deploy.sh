git pull
cd ../ConsultasME/
mvn deploy -DrepositoryId=nexus-releases -Djavax.net.ssl.trustStore=/home/invoke/Documents/tesoreria/git/contenerizacion/redhat-tgr/deployments/mavenKeystore -Djavax.net.ssl.trustStorePassword=asdqwe123
cd ../PkgCMonExEJB/
mvn deploy -DrepositoryId=nexus-releases -Djavax.net.ssl.trustStore=/home/invoke/Documents/tesoreria/git/contenerizacion/redhat-tgr/deployments/mavenKeystore -Djavax.net.ssl.trustStorePassword=asdqwe123
cd ../PkgConsultasMonExEJB/
mvn deploy -DrepositoryId=nexus-releases -Djavax.net.ssl.trustStore=/home/invoke/Documents/tesoreria/git/contenerizacion/redhat-tgr/deployments/mavenKeystore -Djavax.net.ssl.trustStorePassword=asdqwe123
cd ../UtilesCMonEx/
mvn deploy -DrepositoryId=nexus-releases -Djavax.net.ssl.trustStore=/home/invoke/Documents/tesoreria/git/contenerizacion/redhat-tgr/deployments/mavenKeystore -Djavax.net.ssl.trustStorePassword=asdqwe123
cd ../intranetConsultasME/
mvn deploy -DrepositoryId=nexus-releases -Djavax.net.ssl.trustStore=/home/invoke/Documents/tesoreria/git/contenerizacion/redhat-tgr/deployments/mavenKeystore -Djavax.net.ssl.trustStorePassword=asdqwe123
