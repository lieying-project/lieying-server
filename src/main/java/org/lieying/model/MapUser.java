package org.lieying.model;

import org.apache.ibatis.type.Alias;

@Alias("MapUser")
public class MapUser {
    private int u_id;
    private String u_name;

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public MapUser() {
    }
    public MapUser(int u_id, String u_name) {
        this.u_id = u_id;
        this.u_name = u_name;
    }
}
