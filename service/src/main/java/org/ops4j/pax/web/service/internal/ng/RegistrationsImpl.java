package org.ops4j.pax.web.service.internal.ng;

import java.util.Dictionary;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import javax.servlet.Servlet;
import org.osgi.service.http.HttpContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class RegistrationsImpl implements Registrations
{

    private static final Log m_logger = LogFactory.getLog( RegistrationsImpl.class );

    private Map<String, HttpTarget> m_registrations;

    public RegistrationsImpl()
    {
        m_registrations = new HashMap<String, HttpTarget>();
    }
    
    public Collection<HttpTarget> get()
    {
        return m_registrations.values();
    }

    public HttpTarget registerServlet( String alias, Servlet servlet, Dictionary initParams, HttpContext context )
    {
        if( m_logger.isDebugEnabled() )
        {
            m_logger.debug( "Registering Servlet: [" + alias + "] -> " + servlet + " into repository " + this );
        }
        HttpTarget httpTarget = new HttpServlet( alias, servlet, initParams, context );
        m_registrations.put( httpTarget.getAlias(), httpTarget );
        return httpTarget;
    }

    public HttpTarget registerResources( String alias, String name, HttpContext context )
    {
        if( m_logger.isDebugEnabled() )
        {
            m_logger.debug( "Registering Resource: [" + alias + "] -> " + name + " into repository " + this );
        }
        HttpTarget httpTarget = new HttpResource( alias, name, context );
        m_registrations.put( httpTarget.getAlias(), httpTarget );
        return httpTarget;
    }

    public HttpTarget getByAlias( String alias )
    {
        return m_registrations.get( alias );
    }

    // TODO handle invalid params on registration (nulls, ...)
    // TODO do not allow duplicate alias registration  within the whole service
    // TODO do not allow duplicate servlet registration within the whole service
}
