package team.xyh.mall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
public interface FileDao {
	
	@Autowired(required=true)
	public void saveImage(String url);
}
