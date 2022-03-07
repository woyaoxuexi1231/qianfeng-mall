package team.xyh.mall.dto;

/**
 * @author ：许雄斌
 * @date ：Created in 2020/9/28 17:02
 * @description：
 * @modified By：
 * @version: $
 */
public class Images {
    private Integer name;
    private String url;

    public Integer getName(){
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
