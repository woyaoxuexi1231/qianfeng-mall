package team.xyh.mall.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.xyh.mall.dao.ShowInformationMapper;
import team.xyh.mall.dto.Good;
import team.xyh.mall.dto.Result;
import team.xyh.mall.service.ShowInformationServer;

import java.util.List;

/**
 * @author ：许雄斌
 * @date ：Created in 2020/9/27 22:08
 * @description：
 * @modified By：
 * @version: $
 */
@Service
public class ShowInformationServerImpl implements ShowInformationServer {
    @Autowired
    private ShowInformationMapper showInformationMapper;

    @Override
    public Result getGoodInformation(Integer goodId) {
        Result <Good>result=new Result();
        if(goodId!=null){
            Good good=showInformationMapper.getGoodInformation(goodId);
            result.setData(good);
        }
        return result;
    }

    @Override
    public Result getAllImage(Integer goodId) {
        Result <List<String>>result=new Result();
        if(goodId!=null){
            List <String>list=showInformationMapper.getAllImage(goodId);
            result.setData(list);
        }
        return result;
    }
}
