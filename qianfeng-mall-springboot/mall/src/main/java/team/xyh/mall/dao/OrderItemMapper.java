package team.xyh.mall.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import team.xyh.mall.pojo.OrderItem;

import java.util.List;

@Mapper
@Component
public interface OrderItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    OrderItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);

    List<OrderItem> getOrderItem(Integer id);
}