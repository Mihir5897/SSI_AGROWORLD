package com.me.ssiagroworld.Model;

import android.content.Intent;

public class DataModelofLeads {
    private String companyname;
    private String profileurl;
    private String profileAltText;
    private int profileid;

    public String getProfileAltText() {
        return profileAltText;
    }

    public void setProfileAltText(String profileAltText) {
        this.profileAltText = profileAltText;
    }

    public int getProfileid() {
        return profileid;
    }

    public void setProfileid(int profileid) {
        this.profileid = profileid;
    }

    private String companyaddress;
    private String tag;

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getProfileurl() {
        return profileurl;
    }

    public void setProfileurl(String profileurl) {
        this.profileurl = profileurl;
    }

    public String getCompanyaddress() {
        return companyaddress;
    }

    public void setCompanyaddress(String companyaddress) {
        this.companyaddress = companyaddress;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
