package team.xyh.mall.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import team.xyh.mall.dto.Good;
import team.xyh.mall.dto.Poster;

import java.util.List;

/**
 * @author ：许雄斌
 * @date ：Created in 2020/9/26 20:54
 * @description：展示功能dao层
 * @modified By：
 * @version: $
 */
@Component
@Mapper
public interface DisplayMapper {

    List<Good> displayGoods(@Param("userId") Integer userId);

    List<Integer> allShoppingCarGood(@Param("userId")Integer userId);

    List<Poster> getAllPoster();
}
