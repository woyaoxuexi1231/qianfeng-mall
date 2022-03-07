package team.xyh.mall.service;

import org.springframework.stereotype.Service;
import team.xyh.mall.dto.Images;
import team.xyh.mall.dto.Result;
import team.xyh.mall.pojo.Good;

import java.util.List;

@Service
public interface GoodService {

    Result<List<Good>> getAllGood(String name, Double minPrice, Double maxPrice, Integer page, Integer limit, String brand,String type);

    Result<Good> findGoodById(Integer id);

    Result<String> deleteGoodById(Integer id);

    Result<String> statusChange(Integer id, Integer status);

    Result<String> getAllBrand();

    Result<String> updateGood(Good good);

    Result<Integer> addGood(Good good);

    Result<String> uploadGoodImage(Integer goodId, String[] images);

    Result<String> getAllType();

    Result<List<Images>> getAllImages(Integer goodId);

    Result deleteImages(String imageUrl);
}
