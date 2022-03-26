alter session set "_ORACLE_SCRIPT"=true; 
CREATE USER starzplay IDENTIFIED BY secret;
grant all privileges to starzplay;
GRANT CONNECT TO starzplay;
GRANT UNLIMITED TABLESPACE TO starzplay;
COMMIT;
