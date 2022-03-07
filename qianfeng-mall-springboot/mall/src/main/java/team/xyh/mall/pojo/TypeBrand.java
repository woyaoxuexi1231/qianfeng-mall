package team.xyh.mall.pojo;

import java.io.Serializable;

public class TypeBrand implements Serializable {
    private String type;

    private String brand;

    private static final long serialVersionUID = 1L;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public TypeBrand() {
    }
}