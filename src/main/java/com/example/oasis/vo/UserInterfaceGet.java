package com.example.oasis.vo;

import java.util.ArrayList;
import java.util.List;

public class UserInterfaceGet {
private String author;
private String IEEE;
private List<String> domain=new ArrayList<>();
private List<Double> domainHot=new ArrayList<>();

    public void addDomain(String d){
        this.domain.add(d);
    }
    public void adddomainHot(double f){
        this.domainHot.add(f);
    }

    public List<Double> getDomainHot() {
        return domainHot;
    }

    public void setDomainHot(List<Double> domainHot) {
        this.domainHot = domainHot;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIEEE() {
        return IEEE;
    }

    public void setIEEE(String IEEE) {
        this.IEEE = IEEE;
    }

    public List<String> getDomain() {
        return domain;
    }

    public void setDomain(List<String> domain) {
        this.domain = domain;
    }






}
