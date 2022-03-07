package team.xyh.mall.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.xyh.mall.dao.TypeBrandMapper;
import team.xyh.mall.dto.Result;
import team.xyh.mall.service.TypeBrandService;

import java.util.List;

@Service
public class typeBrandServiceImpl implements TypeBrandService {

    @Autowired
    private TypeBrandMapper typeBrandMapper;

    @Override
    public Result<List<String>> getAllType() {
        Result result = new Result();
        List<String> types = typeBrandMapper.getAllType();
        result.setData(types);
        return result;
    }

    @Override
    public Result<List<String>> getAllBrandByType(String type) {
        System.out.println(type);
        Result result = new Result();
        List<String> brands = typeBrandMapper.getAllBrandByType(type);
        result.setData(brands);
        return result;
    }


}
