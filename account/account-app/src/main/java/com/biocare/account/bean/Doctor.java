package com.biocare.account.bean;

import com.alibaba.fastjson.JSON;

/**
 *  医生实体类
 *
 * @author mariston
 * @version 1.0
 * @since 2017/11/7 15:05
 */
public class Doctor {

    /**
     * 主键
     */
    private String doctorId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 工作单位
     */
    private String workspace;

    /**
     * 工作地址
     */
    private String workAddress;

    /**
     * 科室
     */
    private String department;

    /**
     * 专业
     */
    private String specialty;

    /**
     * 职称
     */
    private String title;

    /**
     * 行政职务
     */
    private String duty;

    /**
     * 学校
     */
    private String school;

    /**
     * 入学时间
     */
    private String enrolmentTime;

    /**
     * 最高学历
     */
    private String highestDegree;

    /**
     * 个人说明
     */
    private String introduction;

    /**
     * 证明材料
     */
    private String material;

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getWorkspace() {
        return workspace;
    }

    public void setWorkspace(String workspace) {
        this.workspace = workspace;
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getEnrolmentTime() {
        return enrolmentTime;
    }

    public void setEnrolmentTime(String enrolmentTime) {
        this.enrolmentTime = enrolmentTime;
    }

    public String getHighestDegree() {
        return highestDegree;
    }

    public void setHighestDegree(String highestDegree) {
        this.highestDegree = highestDegree;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
