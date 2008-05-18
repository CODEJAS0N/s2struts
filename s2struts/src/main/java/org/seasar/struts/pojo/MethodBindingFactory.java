package org.seasar.struts.pojo;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.seasar.struts.pojo.util.IndexedUtil;
import org.seasar.struts.util.S2StrutsContextUtil;

/**
 * {@link MethodBinding}のファクトリです。
 * 
 * @author taedium
 */
public class MethodBindingFactory {

    private MethodBindingFactory() {
    }

    /**
     * {@link MethodBinding}を返します。
     * 
     * @param request
     * @param path
     * @return
     */
    public static MethodBinding getMethodBinding(HttpServletRequest request, String path) {
        for (Enumeration paramNames = request.getParameterNames(); paramNames.hasMoreElements();) {
            String key = (String) paramNames.nextElement();
            String value = request.getParameter(key);
            String expression = S2StrutsContextUtil.getMethodBindingExpression(path, key, value);
            if (expression != null) {
                return new MethodBinding(expression);
            }

            // image tag
            String imageKey = key.replaceFirst("(\\.x$)|(\\.y$)", "");
            expression = S2StrutsContextUtil.getMethodBindingExpression(path, imageKey, null);
            if (expression != null) {
                return new MethodBinding(expression);
            }

            // indexed
            if (IndexedUtil.isIndexedParameter(key)) {
                String indexedKey = IndexedUtil.getParameter(key);
                int index = IndexedUtil.getIndex(key);
                expression = S2StrutsContextUtil.getMethodBindingExpression(path, indexedKey, value);
                if (expression != null) {
                    return new MethodBinding(expression, index);
                }
            }
        }
        return null;
    }

}