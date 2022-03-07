package team.xyh.mall.service;

import org.springframework.stereotype.Service;
import team.xyh.mall.dto.Result;

/**
 * @author ：许雄斌
 * @date ：Created in 2020/9/27 22:09
 * @description：
 * @modified By：
 * @version: $
 */
@Service
public interface ShowInformationServer {
    Result getGoodInformation(Integer goodId);

    Result getAllImage(Integer goodId);
}
