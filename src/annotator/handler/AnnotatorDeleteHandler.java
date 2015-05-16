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

package annotator.handler;
import annotator.constants.Database;
import annotator.constants.Params;
import annotator.exception.*;
import calliope.core.database.Connection;
import calliope.core.database.Connector;
import calliope.core.exception.DbException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Handle a DELETE request
 * @author desmond
 */
public class AnnotatorDeleteHandler extends AnnotatorHandler
{
     String id;
    private void getParameters( HttpServletRequest request )
    {
        Map params = request.getParameterMap();
        Set<String> keys = params.keySet();
        Iterator<String> iter = keys.iterator();
        while ( iter.hasNext() )
        {
            String key = iter.next();
            if ( key.equals(Params._ID) )
                this.id = getStringParameter(key,params);
        }
    }
    public void handle( HttpServletRequest request, 
        HttpServletResponse response, String urn ) throws AnnotatorException
    {
        try
        {
            getParameters(request);
            if ( id != null )
            {
                Connection conn = Connector.getConnection();
                conn.removeFromDbByField(Database.ANNOTATIONS, Params._ID, id );
            }
        }
        catch ( DbException dbe )
        {
            throw new AnnotatorException(dbe);
        }
    }
}
