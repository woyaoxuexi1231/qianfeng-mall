package team.xyh.mall.service.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import team.xyh.mall.dao.FileDao;


public class FileServiceImpl {
	
	@Autowired
	private FileDao fileDao;
	

	public void saveImage(String url) {
		this.fileDao.saveImage(url);
	}
}

