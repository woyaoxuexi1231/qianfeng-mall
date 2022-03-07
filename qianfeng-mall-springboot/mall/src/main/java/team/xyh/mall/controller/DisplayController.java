package team.xyh.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.xyh.mall.dto.Result;
import team.xyh.mall.service.DisplayService;

/**
 * @author ：代秦恒
 * @date ：Created in 2020/9/26 20:45
 * @description：展示商品界面
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping("/display")
public class DisplayController {
    @Autowired
    private DisplayService displayService;

    @RequestMapping("/displayGoods")
    public Result displayGoods(Integer userId){
        return displayService.displayGoods(userId);
    }

    @RequestMapping("/allShoppingCarGood")
    public Result allShoppingCarGood(Integer userId){
        return displayService.allShoppingCarGood(userId);
    }
    @RequestMapping("/getAllPoster")
    public Result getAllPoster(){
        return displayService.getAllPoster();
    }

}
