package team.xyh.mall.service;

import team.xyh.mall.dto.Result;

public interface OrderService {

    Result getOrderById(Integer id);

    Result getOrderByPage(Integer page, Integer limit, String id, String receiver, String orderType, String sourceType);

    void closeOrderById(Integer id, String note);

    void deliveryOrderById(Integer id);

    void deleteOrderById(Integer id);

    void createOrder(Integer[] goodsIds, Integer[] count, Integer userId);
}
