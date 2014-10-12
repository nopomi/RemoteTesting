/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbretriever;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import max.Appledore.container.SourceContainer;
import max.Appledore.domain.Source;

/**
 *
 * @author FunkyO
 */
public class SourceRetriever {

    Connection conn;
    private SourceContainer container;
    private String url;
    private String dbName;
    private String driver;
    private String username;
    private String password;

    public SourceRetriever() {

        this.container = new SourceContainer();
        url = "jdbc:mysql://localhost:3306/";
        dbName = "appledore";
        driver = "com.mysql.jdbc.Driver";
        username = "";
        password = "";

    }

    public void connect() {

        try {
            Class.forName(this.driver).newInstance();
            this.conn = DriverManager.getConnection(this.url + this.dbName, this.username, this.password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SourceContainer retrieveSources() {

        try {

            connect();

            Statement st = conn.createStatement();
            String sql = ("SELECT * FROM Sources");

            ResultSet rs1 = st.executeQuery(sql);

            while (rs1.next()) {

                // REMEMBER TO CHECK SOURCE URL BELOW!!
                int sourceid = rs1.getInt("SourceID");
                String sourceurl = rs1.getString("SourceURL");

                Source source = new Source(sourceurl, sourceid);

                this.container.addSource(source);

            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return this.container;

    }

}
