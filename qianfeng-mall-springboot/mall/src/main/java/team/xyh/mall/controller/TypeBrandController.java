package team.xyh.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.xyh.mall.dto.Result;
import team.xyh.mall.pojo.TypeBrand;
import team.xyh.mall.service.TypeBrandService;

import java.util.List;

@RestController
@RequestMapping("/type_brand")
public class TypeBrandController {

    @Autowired
    private TypeBrandService typeBrandService;

    @RequestMapping("/getAllType")
    public Result<List<String>> getAllType(){
        return typeBrandService.getAllType();
    }

    @RequestMapping("/getAllBrandByType")
    public Result<List<String>> getAllBrandByType(String type){
        return typeBrandService.getAllBrandByType(type);
    }
}
