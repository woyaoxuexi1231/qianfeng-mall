package team.xyh.mall.controller;

import team.xyh.mall.dto.Result;
import team.xyh.mall.service.ShoppingCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：许雄斌
 * @date ：Created in 2020/9/25 16:22
 * @description：购物车controller层
 * @modified By：
 * @version: $
 */
@RequestMapping("/ShoppingCar")
@RestController
public class ShoppingCarController {

    @Autowired(required=false)
    private ShoppingCarService shoppingCarService;

    @RequestMapping("/viewShoppingCar")
    public Result viewShoppingCar(Integer userId){
        return shoppingCarService.viewShoppingCar(userId);
    }

    @RequestMapping("/deleteThisGood")
    public Result deleteThisGood(Integer id,Integer userId){
        return shoppingCarService.deleteThisGood(id,userId);
    }

    @RequestMapping("/changeNumber")
    public Result changeNumber(Integer id,Integer number){
        return shoppingCarService.changeNumber(id,number);
    }
    @RequestMapping("/settlement")
    public Result settlement(Integer[] ids){
        return shoppingCarService.settlement(ids);
    }
    @RequestMapping("/addShoppingCar")
    public Result addShoppingCar(Integer userId,Integer goodId){
        return shoppingCarService.addShoppingCar(userId,goodId);
    }
    @RequestMapping("/getOrder")
    public Result getOrder(Integer userId){
        return shoppingCarService.getOrder(userId);
    }
}
