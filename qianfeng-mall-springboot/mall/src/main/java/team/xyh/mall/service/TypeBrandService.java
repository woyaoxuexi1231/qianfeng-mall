package team.xyh.mall.service;

import org.springframework.stereotype.Service;
import team.xyh.mall.dto.Result;

import java.util.List;

@Service
public interface TypeBrandService {
    Result<List<String>> getAllType();

    Result<List<String>> getAllBrandByType(String type);
}
