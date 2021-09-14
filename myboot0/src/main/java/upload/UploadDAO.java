package upload;



import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UploadDAO {
	public void insertFiles(UploadVO vo);
	public List<UploadVO> selectFiles(String name);
	

}
