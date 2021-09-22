package org.pojo;

public class ConnectionVO {
    private String hostname;
    private String id;

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ConnectionVO{" +
                "id='" + id + '\'' +
                '}';
    }
}
