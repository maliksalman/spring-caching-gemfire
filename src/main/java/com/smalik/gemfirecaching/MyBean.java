package com.smalik.gemfirecaching;

import java.util.Date;

public class MyBean {

    private Date date;
    private String message;

    public MyBean() { }
    public MyBean(Date date, String message) {
        this.date = date;
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
