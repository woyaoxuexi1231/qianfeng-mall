package team.xyh.mall.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import team.xyh.mall.dto.Good;

import java.util.List;

/**
 * @author ：许雄斌
 * @date ：Created in 2020/9/27 22:10
 * @description：
 * @modified By：
 * @version: $
 */
@Component
@Mapper
public interface ShowInformationMapper {

    Good getGoodInformation(@Param("goodId") Integer goodId);

    List<String> getAllImage(@Param("goodId") Integer goodId);
}
