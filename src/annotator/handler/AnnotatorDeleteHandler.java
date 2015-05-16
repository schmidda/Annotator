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
import annotator.exception.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Handle a DELETE request
 * @author desmond
 */
public class AnnotatorDeleteHandler extends AnnotatorHandler
{
    public void handle( HttpServletRequest request, 
        HttpServletResponse response, String urn ) throws AnnotatorException
    {
        System.out.println("DELETE");
    }
}
