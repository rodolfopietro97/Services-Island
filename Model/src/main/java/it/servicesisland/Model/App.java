package it.servicesisland.Model;

import it.servicesisland.Connection.handlers.ConnectionInfo;
import it.servicesisland.Persistence.DataSource;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ConnectionInfo c = new ConnectionInfo("DBInfo.json");
    	DataSource prova = new DataSource(c.getDBUrl(), c.getDBUser(), c.getDBPassword());
        if(prova.getConnection()!=null) System.out.println("IPPOLITO e PUPO");
    	System.out.println( "Hello World!" );
    }
}
