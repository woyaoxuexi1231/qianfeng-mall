package team.xyh.mall.service;

import org.springframework.beans.factory.annotation.Autowired;



public interface FileService {
	@Autowired(required=true)
	public void saveImage(String url);
	
}

