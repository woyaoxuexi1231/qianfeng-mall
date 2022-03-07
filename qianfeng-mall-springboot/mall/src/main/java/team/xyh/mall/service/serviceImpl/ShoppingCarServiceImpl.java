package team.xyh.mall.service.serviceImpl;

import org.omg.PortableInterceptor.INACTIVE;
import team.xyh.mall.dao.ShoppingCarMapper;
import team.xyh.mall.dto.Good;
import team.xyh.mall.dto.OrderDto;
import team.xyh.mall.dto.Result;
import team.xyh.mall.dto.ShoppingCarView;
import team.xyh.mall.pojo.Order;
import team.xyh.mall.service.OrderService;
import team.xyh.mall.service.ShoppingCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：许雄斌
 * @date ：Created in 2020/9/25 16:06
 * @description：服务层实现类
 * @modified By：
 * @version: $
 */
@Service
public class ShoppingCarServiceImpl implements ShoppingCarService {

    @Autowired
    private ShoppingCarMapper shoppingCarMapper;

    @Autowired
    private OrderService orderService;
    @Override
    public Result<List<ShoppingCarView>> viewShoppingCar(Integer userId) {
        System.out.println(111);
        Result<List<ShoppingCarView>> result=new Result<>();
        if(null==userId||userId.equals("")){
            result.setCode(500);
            result.setMessage("ID错误");
            return result;
        }
        else {
            List <ShoppingCarView>list=shoppingCarMapper.viewShoppingCar(userId);
            result.setData(list);
        }
        return result;
    }

    @Override
    public Result deleteThisGood(Integer id,Integer userId) {
        shoppingCarMapper.deleteThisGood(id);
        return viewShoppingCar(userId);
    }

    @Override
    public Result changeNumber(Integer id, Integer number) {
        shoppingCarMapper.changeNumber(id,number);
        return null;
    }

    @Override
    public Result settlement(Integer[] ids) {
        Result<List<ShoppingCarView>> result=new Result();
        Integer good_id[]=new Integer[(ids.length-1)/3];
        int flag=0;
        Integer userId=ids[0];
        Integer[] count = new Integer[(ids.length-1)/3];
        /*for (int j = 0; j < count.length; j++) {
            count[j]=1;
        }*/
        for (int i = 1; i < ids.length-1; i+=3) {
            deleteThisGood(ids[i],ids[0]);
            good_id[flag]=ids[i+1];
            count[flag]=ids[i+2];
            flag++;
            /*if(i/2==1) {
                good_id[flag]=ids[i];
                flag++;
            }
            else deleteThisGood(ids[i],ids[0]);*/
        }
        orderService.createOrder(good_id,count,userId);
        List <ShoppingCarView>list=shoppingCarMapper.viewShoppingCar(userId);
        result.setData(list);
        return result;
    }

    @Override
    public Result addShoppingCar(Integer userId, Integer goodId) {
        Result <List<Integer>>result=new Result();

        if(null==userId||null==goodId){
            result.setMessage("加入购物车失败");
            result.setCode(500);
        }else {
            shoppingCarMapper.addShoppingCar(userId,goodId);
            List<Integer> list=shoppingCarMapper.allShoppingCarGood(userId);
            result.setData(list);
        }
        return result;
    }

    @Override
    public Result getOrder(Integer userId) {
        Result <List<OrderDto>>result=new Result();
        if(userId!=null){
            List <OrderDto>list=shoppingCarMapper.getOrder(userId);
            result.setData(list);
        }
        return result;
    }
}
