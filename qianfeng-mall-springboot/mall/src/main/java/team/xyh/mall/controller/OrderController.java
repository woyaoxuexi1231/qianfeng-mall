package team.xyh.mall.controller;

import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.xyh.mall.dto.Result;
import team.xyh.mall.service.OrderItemService;
import team.xyh.mall.service.OrderService;

@RestController
@CrossOrigin
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;
    @Autowired
    OrderItemService orderItemService;

    @RequestMapping("/list")
    public Result getOrderByPage(Integer page, Integer limit, String orderId, String receiver, String orderType, String sourceType){
        return orderService.getOrderByPage(page, limit, orderId, receiver, orderType, sourceType);
    }

    @RequestMapping("/order")
    public Result getOrderById(Integer id){
        return orderService.getOrderById(id);
    }

    @RequestMapping("/order/creation")
    public Result createOrder(Integer[] goodsIds, Integer[] count, Integer userId){
        orderService.createOrder(goodsIds, count, userId);
        Result result = new Result();
        return result;
    }

    @RequestMapping("/order/delivery")
    public Result deliveryOrderById(Integer[] ids){
        for (Integer id : ids) {
            orderService.deliveryOrderById(id);
        }
        Result result = new Result();
        return result;
    }

    @RequestMapping("/order/close")
    public void closeOrderById(Integer[] ids, String note){ ;
        for (Integer id : ids) {
            orderService.closeOrderById(id, note);
        }
    }

    @RequestMapping("/order/delete")
    public void deleteOrderById(Integer[] ids){
        for(Integer id : ids){
            orderService.deleteOrderById(id);
        }
    }

    @RequestMapping("/order/item")
    public Result getOrderItem(Integer id){
        return orderItemService.getOrderItem(id);
    }
}
