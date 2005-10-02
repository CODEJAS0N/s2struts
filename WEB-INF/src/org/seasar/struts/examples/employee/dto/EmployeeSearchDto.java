package org.seasar.struts.examples.employee.dto;

import java.io.Serializable;

import org.seasar.struts.examples.util.DateUtil;
import org.seasar.struts.examples.util.StringUtil;


/**
 * @author Katsuhiko Nagashima
 * @org.seasar.struts.annotation.StrutsActionForm(name="employeeSearchForm")
 */
public class EmployeeSearchDto implements Serializable {

    private String empno = "";

    private String ename = "";

    private String job = "";

    private String mgr = "";

    private String fromHiredateDisplay = "";

    private String toHiredateDisplay = "";

    private String fromSal = "";

    private String toSal = "";

    private String deptno = "";

    public EmployeeSearchDto() {
    }

    public String getEmpno() {
        return this.empno;
    }

    /**
     * @org.seasar.struts.validator.annotation.Integer
     * @org.seasar.struts.validator.annotation.Args(keys="form.employee.no")
     */
    public void setEmpno(String empno) {
        this.empno = empno;
    }

    public java.lang.String getEname() {
        return this.ename;
    }

    public void setEname(java.lang.String ename) {
        this.ename = ename;
    }

    public java.lang.String getJob() {
        return this.job;
    }

    public void setJob(java.lang.String job) {
        this.job = job;
    }

    public String getMgr() {
        return this.mgr;
    }

    /**
     * @org.seasar.struts.validator.annotation.Integer
     * @org.seasar.struts.validator.annotation.Args(keys="form.employee.manager")
     */
    public void setMgr(String mgr) {
        this.mgr = mgr;
    }

    public java.util.Date getFromHiredate() {
        return DateUtil.toDate(fromHiredateDisplay);
    }

    public void setFromHiredate(java.util.Date fromHiredate) {
        this.fromHiredateDisplay = StringUtil.toString(fromHiredate);
    }

    public String getFromHiredateDisplay() {
        return fromHiredateDisplay;
    }

    /**
     * @org.seasar.struts.validator.annotation.Date
     * @org.seasar.struts.validator.annotation.Args(keys="form.employee.hiredate")
     */
    public void setFromHiredateDisplay(String formHiredateDisplay) {
        this.fromHiredateDisplay = formHiredateDisplay;
    }

    public java.util.Date getToHiredate() {
        return DateUtil.toDate(toHiredateDisplay);
    }

    public void setToHiredate(java.util.Date toHiredate) {
        this.toHiredateDisplay = StringUtil.toString(toHiredate);
    }

    public String getToHiredateDisplay() {
        return toHiredateDisplay;
    }

    /**
     * @org.seasar.struts.validator.annotation.Date
     * @org.seasar.struts.validator.annotation.Args(keys="form.employee.hiredate")
     */
    public void setToHiredateDisplay(String toHiredateDisplay) {
        this.toHiredateDisplay = toHiredateDisplay;
    }

    public String getFromSal() {
        return this.fromSal;
    }

    /**
     * @org.seasar.struts.validator.annotation.Integer
     * @org.seasar.struts.validator.annotation.Args(keys="form.employee.salary")
     */
    public void setFromSal(String fromSal) {
        this.fromSal = fromSal;
    }

    public String getToSal() {
        return this.toSal;
    }

    /**
     * @org.seasar.struts.validator.annotation.Integer
     * @org.seasar.struts.validator.annotation.Args(keys="form.employee.salary")
     */
    public void setToSal(String toSal) {
        this.toSal = toSal;
    }

    public String getDeptno() {
        return this.deptno;
    }

    public void setDeptno(String deptno) {
        this.deptno = deptno;
    }

    public String toString() {
        StringBuffer buf = new StringBuffer("[");
        buf.append(empno).append(", ");
        buf.append(ename).append(", ");
        buf.append(job).append(", ");
        buf.append(mgr).append(", ");
        buf.append(fromHiredateDisplay).append(", ");
        buf.append(toHiredateDisplay).append(", ");
        buf.append(fromSal).append(", ");
        buf.append(toSal).append(", ");
        buf.append(deptno).append("]");
        return buf.toString();
    }
}