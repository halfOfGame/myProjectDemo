package com.example.mydemo.domain;

public class WeatherInfo {
    private Integer id;

    private String dn;

    private String dm;

    private String dx;

    private String sn;

    private String sm;

    private String sx;

    private String ta;

    private String ua;

    private String pa;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDn() {
        return dn;
    }

    public void setDn(String dn) {
        this.dn = dn == null ? null : dn.trim();
    }

    public String getDm() {
        return dm;
    }

    public void setDm(String dm) {
        this.dm = dm == null ? null : dm.trim();
    }

    public String getDx() {
        return dx;
    }

    public void setDx(String dx) {
        this.dx = dx == null ? null : dx.trim();
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    public String getSm() {
        return sm;
    }

    public void setSm(String sm) {
        this.sm = sm == null ? null : sm.trim();
    }

    public String getSx() {
        return sx;
    }

    public void setSx(String sx) {
        this.sx = sx == null ? null : sx.trim();
    }

    public String getTa() {
        return ta;
    }

    public void setTa(String ta) {
        this.ta = ta == null ? null : ta.trim();
    }

    public String getUa() {
        return ua;
    }

    public void setUa(String ua) {
        this.ua = ua == null ? null : ua.trim();
    }

    public String getPa() {
        return pa;
    }

    public void setPa(String pa) {
        this.pa = pa == null ? null : pa.trim();
    }
}