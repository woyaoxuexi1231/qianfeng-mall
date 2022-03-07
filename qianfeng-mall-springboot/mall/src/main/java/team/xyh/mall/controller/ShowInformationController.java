package team.xyh.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.xyh.mall.dto.Result;
import team.xyh.mall.service.ShowInformationServer;

/**
 * @author ：许雄斌
 * @date ：Created in 2020/9/27 22:04
 * @description：展示商品的控制层
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping("/ShowInformation")
public class ShowInformationController {
    @Autowired
    private ShowInformationServer showInformationServer;

    @RequestMapping("/getGoodInformation")
    public Result getGoodInformation(Integer goodId){
        return showInformationServer.getGoodInformation(goodId);
    }
    @RequestMapping("/getAllImage")
    public Result getAllImage(Integer goodId){
        return showInformationServer.getAllImage(goodId);
    }
}
