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

import calliope.core.Utils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import annotator.exception.AnnotatorException;

/**
 * Post methods for annotator.
 * @author desmond
 */
public class AnnotatorPostHandler extends AnnotatorHandler 
{
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
            String service = Utils.first(urn);
            urn = Utils.pop(urn);
            response.getWriter().write("POST");
        }
        catch ( Exception e )
        {
            throw new AnnotatorException(e);
        }
    }
}
