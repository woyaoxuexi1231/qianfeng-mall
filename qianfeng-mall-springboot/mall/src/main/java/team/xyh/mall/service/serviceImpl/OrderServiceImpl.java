package team.xyh.mall.service.serviceImpl;

import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.xyh.mall.dao.OrderMapper;
import team.xyh.mall.dto.Result;
import team.xyh.mall.pojo.Good;
import team.xyh.mall.pojo.Order;
import team.xyh.mall.pojo.OrderItem;
import team.xyh.mall.service.GoodService;
import team.xyh.mall.service.OrderItemService;
import team.xyh.mall.service.OrderService;
import team.xyh.mall.service.ShoppingCarService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private GoodService goodService;
    @Autowired
    private OrderItemService orderItemService;

    @Override
    public Result getOrderById(Integer id) {
        Result result = new Result();
        result.setData(orderMapper.getOrderById(id));
        return result;
    }

    @Override
    public Result getOrderByPage(Integer page, Integer limit, String id, String receiver, String orderType, String sourceType) {
        if(page < 1){
            page = 1;
        }
        if(limit < 0){
            limit = 10;
        }
        Integer start = (page - 1) * limit;
        Result result = new Result();
        result.setData(orderMapper.getOrderByPage(start,limit,id,receiver,orderType,sourceType));
        result.setCount(orderMapper.getCount(id,receiver,orderType,sourceType));
        return result;
    }

    @Override
    public void closeOrderById(Integer id, String note) {
        orderMapper.closeOrderById(id, note);
    }

    @Override
    public void deliveryOrderById(Integer id) {
        orderMapper.deliveryOrderById(id);
    }

    @Override
    public void deleteOrderById(Integer id) {
        orderMapper.deleteOrderById(id);
    }

    @Override
    public void createOrder(Integer[] goodsIds, Integer[] count, Integer userId) {
        Order order = new Order();
        Date date = new Date();
        double payAmount = 0;
        List<OrderItem> orderItems = new ArrayList<>();
        for(int i = 0; i < goodsIds.length; i++){
            Good good = goodService.findGoodById(goodsIds[i]).getData();
            payAmount += good.getPrice()*count[i];
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(goodsIds[i]);
            orderItem.setProductPic(good.getImgUrl());
            orderItem.setProductName(good.getName());
            orderItem.setProductPrice(good.getPrice());
            orderItem.setProductCount(count[i]);
            orderItem.setPayAmount(good.getPrice()*count[i]);
            orderItems.add(orderItem);
        }
        order.setCreateTime(date);
        order.setUserId(userId);
        order.setPayAmount(payAmount);
        order.setPayType(0);
        order.setStatus(0);
        order.setSourceType(1);
        order.setReceiverName("胡适");
        order.setReceiverPhone("18958962478");
        order.setReceiverPostCode("400000");
        order.setReceiverProvince("重庆市");
        order.setReceiverCity("万州区");
        order.setReceiverRegion("五桥");
        order.setReceiverDetailAddress("85号");
        order.setNote("");
        orderMapper.createOrder(order);
        Integer id = order.getId();
        for(OrderItem orderItem: orderItems){
            orderItem.setOrderId(id);
            orderItemService.addOrderItem(orderItem);
        }
    }
}
