package com.example.oasis.vo;

import java.util.ArrayList;
import java.util.List;

public class AuthorDomainPaper {
    private  String domain;
    private List<AuthorPaper> aps=new ArrayList<>();
public  void add(AuthorPaper ap){
    this.aps.add(ap);
}

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public List<AuthorPaper> getAps() {
        return aps;
    }

    public void setAps(List<AuthorPaper> aps) {
        this.aps = aps;
    }
}
