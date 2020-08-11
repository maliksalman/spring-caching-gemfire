package com.smalik.gemfirecaching;

import java.io.Serializable;
import java.util.Date;

public class MyBean implements Serializable {

    private Date date;
    private String message;
    private String id;

    public MyBean() { }
    public MyBean(Date date, String message, String id) {
        this.date = date;
        this.message = message;
        this.id = id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
