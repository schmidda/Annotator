/*
 * This file is part of Annotator.
 *
 *  Annotator is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  Annotator is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with Annotator.  If not, see <http://www.gnu.org/licenses/>.
 *  (c) copyright Desmond Schmidt 2015
 */

package annotator;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.Connector;
/**
 * This launches an instance of the Jetty service
 * @author desmond
 */
public class JettyServerThread extends Thread 
{
    /**
     * Run the server
     */
    public void run()
    {
        try
        {
            Server server = new Server(JettyServer.wsPort);
            Connector[] connectors = server.getConnectors();
            connectors[0].setHost(JettyServer.host);
            server.setHandler(new JettyServer());
            System.out.println("starting...");
            server.start();
            server.join();
        }
        catch ( Exception e )
        {
            e.printStackTrace( System.out );
        }
    }
}
