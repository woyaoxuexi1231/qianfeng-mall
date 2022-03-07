package team.xyh.mall.dto;

/**
 * @author ：许雄斌
 * @date ：Created in 2020/9/27 18:12
 * @description：宣传海报
 * @modified By：
 * @version: $
 */
public class Poster {
    Integer id;
    Integer good_id;
    String img_url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGood_id() {
        return good_id;
    }

    public void setGood_id(Integer good_id) {
        this.good_id = good_id;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public Poster() {
        this.id = id;
    }
}
