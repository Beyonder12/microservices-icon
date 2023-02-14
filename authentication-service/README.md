# Link
https://www.danvega.dev/blog/2022/09/06/spring-security-jwt/

# create rsa key pair
openssl genrsa -out keypair.pem 2048

# extract public key
openssl rsa -in keypair.pem -pubout -out public.pem

# create private key in PKCS#8 format
openssl pkcs8 -topk8 -inform PEM -outform PEM -nocrypt -in keypair.pem -out private.pem


## Create the database in postgresql database

### Command login to postgresql

psql postgres 

### Command login to postgresql

psql postgres 

### Command list of databases

\l

### Command drop a database

create database user_service;

### Command create a database

create database user_service;







