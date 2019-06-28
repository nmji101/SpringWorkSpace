package kh.spring.file;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Controller
public class HomeController {

	@Autowired
	private HttpSession session;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}

	@RequestMapping("/upload.cos")//cos.jar로 이용할때
	public String uploadProc(HttpServletRequest request) {
		String realPath = session.getServletContext().getRealPath("/");
		System.out.println("RealPath -> " + realPath); //spring web server가 동작하는 root
		String resourcePath = realPath + "resources"; //resources폴더에 저장할것임.
		System.out.println("파일저장할 위치 -> " + resourcePath);
		//실제로 저장하려면 1.계정별로 폴더만들기 / 게시판에 관련된 이미지라면 2.날짜별로 폴더만들기 
		//하나의 폴더에는 65000정도의 파일만 저장가능하기때문에 폴더를 종류별로 나누어놓아야한다.

		//commons-io 라이브러리 추가하기(maven 사이트에서)

		//1.저장경로  -> resourcePath
		//2.사이즈 제한
		int maxSize = 10 * 1024 * 1024 ; //10메가

		try {
			MultipartRequest multi = 
					new MultipartRequest(/*업그레이드할 리퀘스트*/request,
							/*저장할경로*/resourcePath,
							/*파일사이즈*/maxSize,
							"utf-8"
							,new DefaultFileRenamePolicy()); 

			//			String name = multi.getParameter("name");
			//			System.out.println("이름입력값  -> " +name);
			File oriFile = multi.getFile("image");
			System.out.println("저장된 이름:" +oriFile.getName());

			//profile_img 
			String fileName = "_id_profile.png"; //변경하고싶은이름

			//파일이름을 "_id_profile.png" 로 계속 업로드 하고싶을경우
			//방법1. commons-io 라이브러리 추가하기(maven 사이트에서)
			//FileUtils.moveFile(oriFile, new File(resourcePath+"/"/*+System.currentTimeMillis()*/+fileName));
			//-> file이름변경을 자동으로 해주는 method ****근데 확실하지않음 덮어쓰기안됨!! 확인해보기!!

			//방법2. 
			//			boolean renameResult = oriFile.renameTo(new File(resourcePath+"/"+fileName));
			//			System.out.println("이름변경 : "+renameResult + ", 변경된이름  : "+oriFile.getName());
			//			
			//			if(!renameResult) {//만약에 이름변경이 되지않는다면
			//				DataInputStream dis = new DataInputStream(new FileInputStream(oriFile));
			//				byte[] fileContents = new byte[(int)oriFile.length()];
			//				dis.readFully(fileContents);
			//				
			//				DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File(resourcePath+"/"+fileName)));
			//				dos.write(fileContents);
			//				dos.flush();
			//				dis.close();
			//				dos.close();
			//			}
			//			boolean delResult = oriFile.delete();
			//			System.out.println(delResult);

		} catch (IOException e) {
			e.printStackTrace();
		}
		//cos.jar : 정책에 관련된 클래스를 가지고있음 -> DefaultFileRenamePolicy 
		//만약이름이 같은 파일이 생긴다면 자동으로 _1 _2 .... 를 붙여준다.
		return "home";
	}

	@RequestMapping("/upload.commons")
	public String uploadProcBycommons(String name, MultipartFile image) {
		String resourcePath = 
				session.getServletContext().getRealPath("/resources");
		System.out.println(resourcePath);
		//		commons-fileupload : 두 번째 방법
		try {
			FileUtils.writeByteArrayToFile(
					new File(resourcePath+"/"+System.currentTimeMillis()+"_file.png"), 
					image.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		//      commons-fileupload : 세 번째 방법
		//try {
		//image.transferTo(
		//	new File(resourcePath+"/"+System.currentTimeMillis()+"_file.png"));
		//} catch (Exception e) {
		//e.printStackTrace();
		//}
		return "home";
	}

}
