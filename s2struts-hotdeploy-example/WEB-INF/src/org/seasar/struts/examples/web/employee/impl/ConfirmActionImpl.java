/*
 * Copyright 2004-2008 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.seasar.struts.examples.web.employee.impl;

import org.seasar.framework.beans.util.Beans;
import org.seasar.framework.container.annotation.tiger.Binding;
import org.seasar.framework.container.annotation.tiger.BindingType;
import org.seasar.struts.examples.entity.Employee;
import org.seasar.struts.examples.web.CrudType;
import org.seasar.struts.examples.web.employee.ConfirmAction;
import org.seasar.struts.examples.web.employee.EmployeeLogic;

/**
 * @author taedium
 * 
 */
public class ConfirmActionImpl implements ConfirmAction {

    private EmployeeLogic employeeLogic;

    private ConfirmForm confirmForm;

    @Binding(bindingType = BindingType.MUST)
    public void setEmployeeLogic(EmployeeLogic employeeLogic) {
        this.employeeLogic = employeeLogic;
    }

    public void setConfirmForm(ConfirmForm confirmForm) {
        this.confirmForm = confirmForm;
    }

    public String goPrevious() {
        char crudType = confirmForm.getCrudType().charAt(0);
        switch (crudType) {
        case CrudType.CREATE:
        case CrudType.UPDATE:
            return EDIT;
        default:
            return LIST;
        }
    }

    public String store() {
        Employee employee = new Employee();
        Beans.copy(confirmForm, employee).excludesWhitespace().excludesNull()
                .execute();
        char crudType = confirmForm.getCrudType().charAt(0);
        switch (crudType) {
        case CrudType.CREATE:
            employeeLogic.insert(employee);
            return SEARCH;
        case CrudType.UPDATE:
            employeeLogic.update(employee);
            return LIST;
        case CrudType.DELETE:
            employeeLogic.delete(employee);
            return LIST;
        default:
            return SEARCH;
        }
    }

}
