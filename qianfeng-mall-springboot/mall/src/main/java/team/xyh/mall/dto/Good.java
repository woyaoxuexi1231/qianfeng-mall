package team.xyh.mall.dto;

/**
 * @author ：许雄斌
 * @date ：Created in 2020/9/26 20:56
 * @description：展示商品的信息
 * @modified By：
 * @version: $
 */
public class Good {
    Integer id;
    Integer stock;
    Double price;
    String img_url;
    String name;
    String description;
    String type;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Good() {

    }
}
