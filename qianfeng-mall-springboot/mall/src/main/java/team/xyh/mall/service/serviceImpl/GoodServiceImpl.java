package team.xyh.mall.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.xyh.mall.dao.GoodMapper;
import team.xyh.mall.dto.Images;
import team.xyh.mall.dto.Result;
import team.xyh.mall.pojo.Good;
import team.xyh.mall.service.GoodService;
import java.util.List;

@Service
public class GoodServiceImpl implements GoodService {

    @Autowired
    private GoodMapper goodMapper;

    @Override
    public Result<List<Good>> getAllGood(String name, Double minPrice, Double maxPrice, Integer page, Integer limit,String brand,String type) {
        Result result = new Result();
//        System.out.println(type);
        Integer start = (page-1)*limit;
        List<Good> goods = goodMapper.selectAll(name,minPrice,maxPrice,start,limit,brand,type);
        if(goods.size()==0){
            result.setCount(0);
            result.setCode(500);
            result.setMessage("未能查询到你查找的商品");
            return result;
        }else {
            result.setCount(goodMapper.count(name,minPrice,maxPrice,brand,type));
            result.setData(goods);
            result.setMessage("查询成功，已为你展示商品");
            return result;
        }
    }

    @Override
    public Result<Good> findGoodById(Integer id) {
        Result result = new Result();
        Good good = goodMapper.selectByPrimaryKey(id);
        result.setData(good);
        return result;
    }

    @Override
    public Result<String> deleteGoodById(Integer id) {
        Result result = new Result();
        goodMapper.deleteByPrimaryKey(id);
        result.setData("删除成功");
        return result;
    }

    @Override
    public Result<String> statusChange(Integer id, Integer status) {
        Result result = new Result();
        if(goodMapper.selectByPrimaryKey(id)!=null){
            goodMapper.statusChange(id,status);
            if(status.equals(1)){
                result.setData("状态已修改成上架状态");
            }else if(status.equals(2)){
                result.setData("状态已修改成下架状态");
            }else if(status.equals(3)){
                result.setData("状态已修改成删除状态");
            }
        }else {
            result.setCode(500);
            result.setData("未查询到有此商品，修改失败");
        }
        result.setCount(goodMapper.count("",0.0,0.0, "",""));
        return result;
    }

    @Override
    public Result<String> getAllBrand() {
        Result result = new Result();
        List<String> brands = goodMapper.getAllBrand();
        result.setData(brands);
        return result;
    }

    public Result<String> getAllType() {
        Result result = new Result();
        List<String> types = goodMapper.getAllType();
        result.setData(types);
        return result;
    }

    @Override
    public Result<List<Images>> getAllImages(Integer goodId) {
        Result result = new Result();
        List<Images> images = goodMapper.getAllImages(goodId);
        result.setData(images);
        return result;
    }

    @Override
    public Result<String> deleteImages(String imageUrl) {
        Result result = new Result();
        goodMapper.deleteImages(imageUrl);
        result.setMessage("成功删除");
        return result;
    }

    @Override
    public Result<String> updateGood(Good good) {
        Result result = new Result();
        if(goodMapper.selectByPrimaryKey(good.getId())==null){
            result.setCount(0);
            result.setCode(500);
            result.setMessage("失败");
            result.setData("修改失败,未能查询到你需要修改的商品");
            return result;
        }else {
            goodMapper.updateGood(good);
            result.setMessage("成功");
            result.setData("修改成功");
            return result;
        }
    }

    @Override
    public Result<Integer> addGood(Good good) {
        Result result = new Result();
        System.out.println(good.getId()+good.getName()+good.getPrice()+good.getBrand()+good.getImgUrl()+good.getProceeds()+good.getStatus()+good.getStock());
        goodMapper.insert(good);
        result.setData(good.getId());
        result.setMessage("添加成功！");
        return result;
    }

    @Override
    public Result<String> uploadGoodImage(Integer goodId, String[] images) {
        Result result = new Result();
        for (String image:images) {
            goodMapper.uploadGoodImage(goodId,image);
        }
        result.setData("上传成功");
        return result;
    }


}
