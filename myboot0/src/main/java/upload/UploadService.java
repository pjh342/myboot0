package upload;

import java.util.List;

//컨트롤러 - 서비스 - dao - sql 실행 - db
public interface UploadService  {
	public void insertFiles(UploadVO vo);
	public List<UploadVO> myfilelist(String name);
}
