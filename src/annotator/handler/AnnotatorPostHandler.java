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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import annotator.exception.AnnotatorException;
import annotator.constants.Params;
import calliope.core.database.Connector;
import calliope.core.database.Connection;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

/**
 * Add new annotations.
 * @author desmond
 */
public class AnnotatorPostHandler extends AnnotatorHandler 
{
    Annotation annotation;
    private void getParameters( HttpServletRequest request )
    {
        Map params = request.getParameterMap();
        Set<String> keys = params.keySet();
        Iterator<String> iter = keys.iterator();
        annotation = new Annotation();
        while ( iter.hasNext() )
        {
            String key = iter.next();
            if ( key.equals(Params.BODY) )
                annotation.body = getStringParameter(Params.BODY,params);
            else if ( key.equals(Params.DOCID) )
                annotation.docid = getStringParameter(Params.DOCID,params);
            else if ( key.equals(Params.VERSION1) )
                annotation.version1 = getStringParameter(Params.VERSION1,params);
            else if ( key.equals(Params.OFFSET) )
                annotation.offset = getIntParameter(Params.OFFSET,params);
            else if ( key.equals(Params.LENGTH) )
                annotation.length = getIntParameter(Params.LENGTH,params);
        }
    }
    /**
     * Handle a POST request
     * @param request the raw request
     * @param response the response we will write to
     * @param urn the rest of the URL after stripping off the context
     * @throws MMLException 
     */
    public void handle( HttpServletRequest request, 
        HttpServletResponse response, String urn ) throws AnnotatorException
    {
        try
        {
            Connection conn = Connector.getConnection();
            getParameters(request);
            conn.putToDb( Database.ANNOTATIONS, annotation.docid, 
                annotation.toJSONString() );
            response.getWriter().write(annotation.toString());
        }
        catch ( Exception e )
        {
            throw new AnnotatorException(e);
        }
    }
}
