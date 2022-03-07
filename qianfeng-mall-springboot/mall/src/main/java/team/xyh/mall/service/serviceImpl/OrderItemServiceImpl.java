package team.xyh.mall.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.xyh.mall.dao.OrderItemMapper;
import team.xyh.mall.dto.Result;
import team.xyh.mall.pojo.OrderItem;
import team.xyh.mall.service.OrderItemService;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    public void addOrderItem(OrderItem orderItem) {
        orderItemMapper.insert(orderItem);
    }

    @Override
    public Result getOrderItem(Integer id) {
        Result result = new Result();
        List<OrderItem> orderItems = orderItemMapper.getOrderItem(id);
        result.setData(orderItems);
        return result;
    }
}
