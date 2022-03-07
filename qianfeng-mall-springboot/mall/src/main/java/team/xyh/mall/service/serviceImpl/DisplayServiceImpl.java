package team.xyh.mall.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.xyh.mall.dao.DisplayMapper;
import team.xyh.mall.dto.Good;
import team.xyh.mall.dto.Poster;
import team.xyh.mall.dto.Result;
import team.xyh.mall.service.DisplayService;

import java.util.List;

/**
 * @author ：许雄斌
 * @date ：Created in 2020/9/26 20:51
 * @description：展示商品的实现层
 * @modified By：
 * @version: $
 */
@Service
public class DisplayServiceImpl implements DisplayService {

    @Autowired
    private DisplayMapper displayMapper;

    @Override
    public Result displayGoods(Integer userId) {
        Result <List<Good>>result=new Result();

        if(null==userId||userId.equals("")){
            result.setCode(500);
            result.setMessage("ID错误");
            return result;
        }
        else {
            List <Good>list=displayMapper.displayGoods(userId);
            result.setData(list);
        }
        return result;
    }

    @Override
    public Result allShoppingCarGood(Integer userId) {
        Result <List>result=new Result();
        if(null==userId||userId.equals("")){
            result.setCode(500);
            result.setMessage("ID错误");
            return result;
        }
        else {
            List <Integer>list=displayMapper.allShoppingCarGood(userId);
            result.setData(list);
        }
        return result;
    }

    @Override
    public Result getAllPoster() {
        Result <List<Poster>>result=new Result();
        List <Poster>list=displayMapper.getAllPoster();
        result.setData(list);
        return result;
    }
}
