@GrabConfig(systemClassLoader=true)
@Grab(group='org.postgresql', module='postgresql', version='42.2.2')

import groovy.sql.*

def dbUrl = "jdbc:postgresql://192.168.50.8/soconfig"
def dbUser = "ddluser"
def dbPassword = "ddluser"
def dbDriver = "org.postgresql.Driver"

def sql = Sql.newInstance(dbUrl, dbUser, dbPassword, dbDriver)


def stmt = """
SELECT
  "name" AS aname, description, qgs_style
FROM
  gdi_knoten.data_set_view AS data_set_view
  LEFT JOIN gdi_knoten.ows_layer_data AS ows_layer_data
  ON ows_layer_data.gdi_oid_data_set_view = data_set_view.gdi_oid
ORDER BY
  "name"
;
"""
sql.eachRow(stmt) { row ->
    println row["aname"]
    def qmlFile = new File(row["aname"] + ".qml")
    qmlFile << row["qgs_style"]
}
sql.close()
