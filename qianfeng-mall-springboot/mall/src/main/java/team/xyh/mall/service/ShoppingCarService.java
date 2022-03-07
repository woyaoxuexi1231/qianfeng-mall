package team.xyh.mall.service;

import team.xyh.mall.dto.Result;
import team.xyh.mall.dto.ShoppingCarView;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：许雄斌
 * @date ：Created in 2020/9/25 16:03
 * @description：购物车服务层
 * @modified By：
 * @version: $
 */
@Service
public interface ShoppingCarService {

    Result<List<ShoppingCarView>> viewShoppingCar(Integer userId);

    Result deleteThisGood(Integer id,Integer userId);

    Result changeNumber(Integer id, Integer number);

    Result settlement(Integer[] ids);

    Result addShoppingCar(Integer userId, Integer goodId);

    Result getOrder(Integer userId);
}
