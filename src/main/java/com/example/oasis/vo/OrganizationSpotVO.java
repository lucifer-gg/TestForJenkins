package com.example.oasis.vo;

import com.example.oasis.po.OrganizationSpot;

public class OrganizationSpotVO {

    Integer spotnum;

    String organization;

    public OrganizationSpotVO(OrganizationSpot organizationSpot){
        this.spotnum=organizationSpot.getSpotnum();
        this.organization=organizationSpot.getOrganization();
    }

    public Integer getSpotnum() {
        return spotnum;
    }

    public void setSpotnum(Integer spotnum) {
        this.spotnum = spotnum;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @Override
    public String toString() {
        return "OrganizationSpotVO{" +
                "spotnum=" + spotnum +
                ", organization='" + organization + '\'' +
                '}';
    }
}
