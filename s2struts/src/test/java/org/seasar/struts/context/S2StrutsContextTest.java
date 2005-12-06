package org.seasar.struts.context;

import org.seasar.extension.unit.S2TestCase;
import org.seasar.framework.util.Base64Util;
import org.seasar.struts.Constants;

/**
 * 
 * @author Katsuhiko Nagashima
 *
 */
public class S2StrutsContextTest extends S2TestCase {
    
    private S2StrutsContext context = new S2StrutsContextImpl();
    
    public void testGetCurrentInputPathFromRequest() {
        getRequest().setParameter(Constants.PAGE_NAME_ELEMENT_VALUE, Base64Util.encode("/request.jsp".getBytes()));
        context.setPath("/prev.jsp");
        context.setPath("/current.jsp");
        
        String path = context.getCurrentInputPath();
        assertEquals("/request.jsp", path);
    }
    
    public void testGetCurrentInputPathFromField() {
        context.setPath("/prev.jsp");
        context.setPath("/current.jsp");
        
        String path = context.getCurrentInputPath();
        assertEquals("/current.jsp", path);
    }
    
    public void testGetPreviousInputPathFromRequest() {
        getRequest().setParameter(Constants.PAGE_NAME_ELEMENT_VALUE, Base64Util.encode("/request.jsp".getBytes()));
        context.setPath("/prev.jsp");
        context.setPath("/current.jsp");
        
        String path = context.getPreviousInputPath();
        assertEquals("/request.jsp", path);
    }
    
    public void testGetPreviousInputPathFromField() {
        context.setPath("/prev.jsp");
        context.setPath("/current.jsp");
        
        String path = context.getPreviousInputPath();
        assertEquals("/prev.jsp", path);
    }
    
    public void testGetPreviousInputPathRetry() {
        context.setPath("/prev.jsp");
        context.setPath("/current.jsp");
        context.setPath("/current.jsp");
        context.setPath("/current.jsp");
        
        String path = context.getPreviousInputPath();
        assertEquals("/prev.jsp", path);
    }
    
    public void testGetMethodBindingExpression() {
        getRequest().setParameter("1234567890", "TEST");
        context.setMethodBindingExpression("1234567890", "TEST", "#{action.execute}");
        
        String expression = context.getMethodBindingExpression();
        assertEquals("#{action.execute}", expression);
    }
    
    public void testExistMethodBindingExpression() {
        getRequest().setParameter("1234567890", "TEST");
        context.setMethodBindingExpression("1234567890", "TEST", "#{action.execute}");
        
        assertTrue(context.existMethodBindingExpression());
    }
    
    public void testNotExistMethodBindingExpression() {
        getRequest().setParameter("9999999999", "TEST");
        context.setMethodBindingExpression("1234567890", "TEST", "#{action.execute}");
        
        assertFalse(context.existMethodBindingExpression());
    }

}
