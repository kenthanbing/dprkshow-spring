package top.dprkshow.dprkshowspring.entity;

public class ExhibitorPwd {
    private Integer eid;
    private String pwd;
    private String new_pwd;
    private String new_pwd2;

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getNew_pwd() {
        return new_pwd;
    }

    public void setNew_pwd(String new_pwd) {
        this.new_pwd = new_pwd;
    }

    public String getNew_pwd2() {
        return new_pwd2;
    }

    public void setNew_pwd2(String new_pwd2) {
        this.new_pwd2 = new_pwd2;
    }
}
