package team.xyh.mall.dao;

import team.xyh.mall.dto.OrderDto;
import team.xyh.mall.dto.ShoppingCarView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ：许雄斌
 * @date ：Created in 2020/9/25 16:39
 * @description：购物车Dao层次
 * @modified By：
 * @version: $
 */
@Component
@Mapper
public interface ShoppingCarMapper {
    List<ShoppingCarView> viewShoppingCar(@Param("userId") Integer userId);

    void deleteThisGood(@Param("id")Integer id);

    void changeNumber(@Param("id")Integer id, @Param("number")Integer number);

    void addShoppingCar(@Param("userId") Integer userId,@Param("goodId") Integer goodId);

    List<Integer> allShoppingCarGood(@Param("userId") Integer userId);

    List<OrderDto>  getOrder(Integer userId);
}
