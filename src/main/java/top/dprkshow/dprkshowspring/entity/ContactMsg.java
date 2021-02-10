package top.dprkshow.dprkshowspring.entity;

public class ContactMsg {
    private Integer mid;
    private String sender;
    private String tel;
    private String email;
    private String  message;

    @Override
    public String toString() {
        return "ContactMsg{" +
                "mid=" + mid +
                ", sender='" + sender + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
