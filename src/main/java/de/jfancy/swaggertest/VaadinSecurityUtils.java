/* © Copyright JFancy 2022 www.jfancy.de */
package de.jfancy.swaggertest;

import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;

import com.vaadin.flow.server.HandlerHelper.RequestType;
import com.vaadin.flow.shared.ApplicationConstants;

/**
 * TODO Marcus Beschreibung der Klasse
 *
 * @author Marcus
 * @author JFancy
 */
public final class VaadinSecurityUtils {

    private VaadinSecurityUtils() {
        // Util methods only
    }

    static boolean isFrameworkInternalRequest(HttpServletRequest request) {
        final String parameterValue = request.getParameter(ApplicationConstants.REQUEST_TYPE_PARAMETER);
        return parameterValue != null
                && Stream.of(RequestType.values()).anyMatch(r -> r.getIdentifier().equals(parameterValue));
    }
}