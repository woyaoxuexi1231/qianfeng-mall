package team.xyh.mall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import team.xyh.mall.dto.Images;
import team.xyh.mall.pojo.Good;

@Mapper
@Component
public interface GoodMapper {
    void deleteByPrimaryKey(Integer id);

    void insert(Good record);

    Good selectByPrimaryKey(Integer id);

    List<Good> selectAll(@Param("name") String name, @Param("minPrice") Double minPrice, @Param("maxPrice") Double maxPrice, @Param("start") Integer start, @Param("limit") Integer limit, @Param("brand") String brand,@Param("type") String type);

    int updateByPrimaryKey(Good record);

    void statusChange(@Param("id") Integer id, @Param("status") Integer status);

    Integer count(@Param("name") String name, @Param("minPrice") Double minPrice, @Param("maxPrice") Double maxPrice, @Param("brand") String brand,@Param("type") String type);

    List<String> getAllBrand();

    void updateGood(Good good);

    void uploadGoodImage(@Param("goodId") Integer goodId, @Param("image") String image);

    List<String> getAllType();

    List<Images> getAllImages(Integer goodId);

    void deleteImages(String imageUrl);
}