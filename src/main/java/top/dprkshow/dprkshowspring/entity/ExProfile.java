package top.dprkshow.dprkshowspring.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class ExProfile implements Serializable {
    private Integer eid;
    private String username;
    private String company;
    private String email;
    private String password;
}
