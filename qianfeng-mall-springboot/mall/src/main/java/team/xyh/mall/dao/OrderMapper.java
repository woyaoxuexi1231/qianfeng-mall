package team.xyh.mall.dao;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import team.xyh.mall.dto.Result;
import team.xyh.mall.pojo.Order;

import java.util.List;

@Mapper
@Component
public interface OrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Object> getOrderByPage(@Param("start") Integer start, @Param("limit") Integer limit, @Param("orderId") String id, @Param("receiver") String receiver, @Param("orderType") String orderType, @Param("sourceType") String sourceType);

    Object getOrderById(Integer id);

    void closeOrderById(@Param("id") Integer id, @Param("note") String note);

    Integer getCount(@Param("orderId") String id, @Param("receiver") String receiver, @Param("orderType") String orderType, @Param("sourceType") String sourceType);

    void deliveryOrderById(Integer id);

    void deleteOrderById(Integer id);

    void createOrder(Order order);
}