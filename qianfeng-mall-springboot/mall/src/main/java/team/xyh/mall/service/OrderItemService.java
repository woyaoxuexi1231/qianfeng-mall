package team.xyh.mall.service;

import team.xyh.mall.dto.Result;
import team.xyh.mall.pojo.OrderItem;

public interface OrderItemService {
    void addOrderItem(OrderItem orderItem);

    Result getOrderItem(Integer id);
}
