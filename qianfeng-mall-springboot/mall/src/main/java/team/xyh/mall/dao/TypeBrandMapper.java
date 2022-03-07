package team.xyh.mall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import team.xyh.mall.pojo.TypeBrand;

@Mapper
@Component
public interface TypeBrandMapper {

    int insert(TypeBrand record);

    List<String> selectAll();

    List<String> getAllType();

    List<String> getAllBrandByType(String type);
}