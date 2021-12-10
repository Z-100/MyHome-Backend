# Manual on how to use MariaDB for this project

## How to install
1. Open [this link](https://mariadb.com/downloads/) and press download
   1. MariaDB Community -> Community Server
   2. Version: 10.6.5-GA
   3. Your OS
2. Install
   1. Important: Port 3306

## How to open
1. [PATH_TO_INSTALL_DIRECTORY]\MariaDB\bin\mariadb.exe -uroot -proot
2. Search for "mariadb"

## How to import database
[PATH_TO_INSTALL_DIRECTORY]\MariaDB\bin\mariadb.exe -uroot -proot myhome < "[PATH_TO_DOWNLOAD_DIRECTORY]\myhomeDBschema.sql" // IMPORTS THE DATABASE SCHEMA TO A DATABASE
