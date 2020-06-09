#!/bin/bash

cp ../intranetConsultasME/target/intranetConsultasME-2.0.0.0.ear .

docker build -t intranet-consultas-me:T.2.0.0.0 .

docker tag intranet-consultas-me:T.2.0.0.0 604753321405.dkr.ecr.us-east-1.amazonaws.com/monex-consultas-me:T.2.0.0.0

#docker push 604753321405.dkr.ecr.us-east-1.amazonaws.com/RentaMonedaExtranjera:T.2.0.0.0

