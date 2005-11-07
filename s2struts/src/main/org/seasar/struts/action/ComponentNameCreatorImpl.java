package org.seasar.struts.action;

import org.apache.struts.action.ActionMapping;
import org.seasar.framework.container.S2Container;

/**
 * @see org.seasar.struts.ComponentNameCreator
 * @author Satoshi Kimura
 */
public class ComponentNameCreatorImpl implements ComponentNameCreator {

    /**
     * ActionMapping����R���|�[�l���g�����A�쐬����B <br>
     * �R���|�[�l���g�����������鏇�Ԃ́A
     * <UL>
     * <LI>module��(prefix)+path</LI>
     * <LI>path</LI>
     * </UL>
     * �ƂȂ�B
     * 
     * @see org.seasar.struts.ComponentNameCreator#createComponentName(org.seasar.framework.container.S2Container,
     *      org.apache.struts.action.ActionMapping)
     */
    public String createComponentName(S2Container container, ActionMapping mapping) {
        String moduleName = mapping.getModuleConfig().getPrefix();
        String path = mapping.getPath();

        String componentName = moduleName + path;
        if (false == container.hasComponentDef(componentName)) {
            componentName = path;
        }
        return componentName;
    }
}