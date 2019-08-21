package cuc.dawei.springsecuritydemo.entity;

/**
 * @ClassName MsgSecurity
 * @Description TODO
 * @Author Mike
 * @Date 2019/8/19 20:09
 * @Version 1.0
 */
public class MsgSecurity {
    private String title;
    private String content;
    private String etraInfo;

    public MsgSecurity(String title, String content, String etraInfo) {
        this.title = title;
        this.content = content;
        this.etraInfo = etraInfo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEtraInfo() {
        return etraInfo;
    }

    public void setEtraInfo(String etraInfo) {
        this.etraInfo = etraInfo;
    }
}
