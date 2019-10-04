# gdi-dev-env

```
scp -v bjsvwzie@geoapp.verw.rootso.org:/opt/workspace/dbdump/soconfig_geodb.rootso.org.dmp .

vagrant up

vagrant ssh

cd /vagrant

sudo su  postgres

pg_restore --no-owner --no-privileges --role=ddluser --exit-on-error -C -d postgres soconfig_geodb.rootso.org.dmp

exit 

exit

groovy db2qml.groovy
```