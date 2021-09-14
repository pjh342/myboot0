package upload;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//<context>cpn... base=p..="upload"
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController {
	@Autowired
	@Qualifier("uploadservice")
	UploadService service;
	
	@RequestMapping(value="/fileupload", method=RequestMethod.GET)
	public String uploadForm() {
		return "/upload/uploadform";
	}
	
	@RequestMapping(value="/fileupload", method=RequestMethod.POST)
	public String uploadResult(@ModelAttribute("vo") UploadVO vo) throws IOException{
		//전송 파일 2개 객체 생성
		MultipartFile multi1 = vo.getFile1();
		MultipartFile multi2 = vo.getFile2();
		//파일명 추출
		String filename1 = multi1.getOriginalFilename();
		String filename2 = multi2.getOriginalFilename();
		
		//서버 c:/kdigital2/upload 폴더 저장
		String savePath = "c:/kdigital2/upload/";
		
		
		//확장자
		String ext1 = filename1.substring(filename1.lastIndexOf("."));
		String ext2 = filename2.substring(filename2.lastIndexOf("."));
		
		filename1 = getUuid()+ext1;
		filename2 = getUuid()+ext2;
		
		
		File file1 = new File(savePath + filename1);
		File file2 = new File(savePath + filename2);	
		
		//저장
		multi1.transferTo(file1);
		multi2.transferTo(file2);
		
		//db 저장할 파일명(서버 저장 파일명) ==> name, description
		vo.setFilename1(filename1);
		vo.setFilename2(filename2);
		
		System.out.println("컨트롤러에서 " + vo.getName());
		System.out.println(vo.getDescription());
		System.out.println(vo.getFilename1());
		System.out.println(vo.getFilename2());
		
		//서비스 insertFiles(vo)
		service.insertFiles(vo);
		
		return "/upload/uploadresult";//${vo.file1}
	}//uploadResult end

	public static String getUuid() {
		return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 10);
	}
	
	
	@RequestMapping(value="/myfilelist", method=RequestMethod.GET)
	public String showForm() {
		return "/upload/myfilelistform";
	}
	
	@RequestMapping(value="/myfilelist", method=RequestMethod.POST)
	public ModelAndView showMyFileList(String name) {
		ModelAndView mv = new ModelAndView();
		List<UploadVO> list = service.myfilelist(name);
		mv.addObject("filelist", list);
		mv.setViewName("/upload/myfilelist");
		return mv;
	}
	
	
	
	
	
	
	
	
}