package team.xyh.mall.service;

import org.springframework.stereotype.Service;
import team.xyh.mall.dto.Result;

/**
 * @author ：代秦恒
 * @date ：Created in 2020/9/26 20:50
 * @description：展示商品的服务层
 * @modified By：
 * @version: $
 */
@Service
public interface DisplayService {
    Result displayGoods(Integer userId);

    Result allShoppingCarGood(Integer userId);

    Result getAllPoster();
}
