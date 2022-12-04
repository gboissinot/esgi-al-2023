package fr.esgi.al.account.step19.infrastructure;

import javax.persistence.Embeddable;

@Embeddable
public class EventEntity {

    private String classname;
    private String data;

    public EventEntity() {
    }

    public EventEntity(String classname, String data) {
        this.classname = classname;
        this.data = data;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
