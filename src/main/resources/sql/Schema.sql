create tablespace devops_tabspace
datafile 'devops_tabspace.dat'
size 10M autoextend on;


select tablespace_name from dba_tablespaces;

create user devops
 identified by devops
 default tablespace devops_tabspace;

select username from dba_users;

grant all privileges  to devops;
