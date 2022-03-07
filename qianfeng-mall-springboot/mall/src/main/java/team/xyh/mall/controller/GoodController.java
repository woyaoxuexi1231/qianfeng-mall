package team.xyh.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team.xyh.mall.dto.Result;
import team.xyh.mall.pojo.Good;
import team.xyh.mall.service.GoodService;

import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodController {

    @Autowired
    private GoodService goodService;

    @RequestMapping("/getAllGood")
    public Result<List<Good>> getAllGood(String name, Double minPrice, Double maxPrice, Integer page, Integer limit, String brand,String type){
        return goodService.getAllGood(name,minPrice,maxPrice,page,limit,brand,type);
    }

    @RequestMapping("/findGoodById")
    public Result<Good> findGoodById(Integer id){
        return goodService.findGoodById(id);
    }

    @RequestMapping("/deleteGoodById")
    public Result<String> deleteGoodById(Integer id){
        return goodService.deleteGoodById(id);
    }

    @RequestMapping("/statusChange")
    public Result<String> statusChange(Integer id,Integer status){
        return goodService.statusChange(id,status);
    }

    @RequestMapping("/getAllBrand")
    public Result<String> getAllBrand(){
        return goodService.getAllBrand();
    }

    @RequestMapping("/getAllType")
    public Result<String> getAllType(){
        return goodService.getAllType();
    }

    @RequestMapping("/updateGood")
    public Result<String> updateGood(@RequestBody Good good){
        return goodService.updateGood(good);
    }

    @RequestMapping("/addGood")
    public Result<Integer> addGood(@RequestBody Good good){
        return goodService.addGood(good);
    }

    @RequestMapping("/uploadGoodImage")
    public Result<String> uploadGoodImage(Integer goodId,String[] images){
        return goodService.uploadGoodImage(goodId,images);
    }

    @RequestMapping("/getAllImages")
    public Result getAllImages(Integer goodId){
        return goodService.getAllImages(goodId);
    }

    @RequestMapping("/deleteImages")
    public Result deleteImages(String imageUrl){
        return goodService.deleteImages(imageUrl);
    }
}
