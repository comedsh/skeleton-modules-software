package com.calabar.cke.app.directory.web;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.calabar.cke.app.common.util.Constants;
import com.calabar.cke.app.common.util.ScaleImg;
import com.calabar.cke.app.common.web.AppBaseController;
import com.calabar.cke.app.directory.model.Directorytree;
import com.calabar.cke.app.directory.model.DirectorytreeCriteria;
import com.calabar.cke.app.directory.model.DirectorytreeCriteria.Criteria;
import com.calabar.cke.app.directory.model.ThemeInformation;
import com.calabar.cke.app.directory.service.DirectorytreeService;
import com.calabar.cke.app.directory.service.ThemeInformationService;
import com.calabar.cke.app.directory.service.ThemeLabelService;
import com.github.pagehelper.PageInfo;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value="theme")
public class ThemeInformationController extends AppBaseController{

	@Autowired
	private ThemeInformationService themeinformationservice;
	@Autowired
	private DirectorytreeService directorytreeservice;
	@Autowired
	private ThemeLabelService themelabelservice;
	
	//添加主题
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody void addTheme(ThemeInformation theme,@RequestParam(value="sectionId",required=false)String sectionId,@RequestParam(value="labelId",required=false)String labelId,@RequestParam(value="classificationId",required=false)String classificationId){
		theme.setStatus(Constants.ABLE);
		theme.setApproalStatus(Constants.APPROVAL_SUCCESS);
		themeinformationservice.addtheme(theme, sectionId, labelId, classificationId);
	}
	//修改主题
	@RequestMapping(method=RequestMethod.POST, value="update")
	public @ResponseBody void saveTheme(ThemeInformation theme,@RequestParam(value="sectionId",required=false)String sectionId,@RequestParam(value="labelId",required=false)String labelId,@RequestParam(value="classificationId",required=false)String classificationId){
		themeinformationservice.updateTheme(theme, sectionId, labelId, classificationId);
	}
	
	//处理图片上传
	@RequestMapping(value = "upload")
	public @ResponseBody void upload(@RequestParam(value = "themePicture") MultipartFile picture,
			HttpServletResponse response,
			HttpServletRequest request){
		response.setContentType("text/html");
		JSONObject json = new JSONObject();

		if(!picture.isEmpty()) {
			
			String pictureName = picture.getOriginalFilename();
			
			//验证上传文件是否为图片
			String reg = ".+(.JPEG|.jpeg|.JPG|.jpg|.GIF|.gif|.BMP|.bmp|.PNG|.png)$";
	        Pattern pattern = Pattern.compile(reg);
	        Matcher matcher = pattern.matcher(pictureName);
	        //验证通过
	        if(matcher.find()){
	        	StringBuffer logoRealPathDir = new StringBuffer();
	        	logoRealPathDir.append(request.getSession().getServletContext()
						.getRealPath(File.separator));
	        	//判断目录是否以 \结尾
	        	if(!logoRealPathDir.substring(logoRealPathDir.length()-1, logoRealPathDir.length()).equals(File.separator)){
	        		logoRealPathDir.append(File.separator);
	        	}
	        	logoRealPathDir.append("common"+File.separator+"images"+File.separator+"bgpicture");
				// 验证文件夹是否存在
				File logoSaveFile = new File(logoRealPathDir.toString());
				if (!logoSaveFile.exists())
					logoSaveFile.mkdirs(); // 不存在，新建文件夹
	
				UUID uuid = UUID.randomUUID();
				//图片重命名
				String fileName = logoRealPathDir + File.separator + uuid + pictureName.substring(pictureName.lastIndexOf("."),pictureName.length());
				String name = File.separator+"common"+File.separator+"images"+File.separator+"bgpicture"+File.separator + uuid + pictureName.substring(pictureName.lastIndexOf("."),pictureName.length());
				// 保存上传图片路径
				json.put("filePath", name);
				@SuppressWarnings("unused")
				File file = new File(fileName);
	
				/*try {
					FileUtils.writeByteArrayToFile(file, picture.getBytes());
					 picture.transferTo(file); 
				} catch (IOException e) {
					e.printStackTrace();
				}*/
				//缩放图片
				BufferedImage srcBufferImage = null;
				try {
					srcBufferImage = ImageIO.read(picture.getInputStream());
				} catch (IOException e1) {
					e1.printStackTrace();
				}  
		        BufferedImage scaledImage;  
		        ScaleImg scaleImage = ScaleImg.getInstance();  
		        int yw = srcBufferImage.getWidth();  
		        int yh = srcBufferImage.getHeight();  
		        int w = 100, h = 100;  
		        // 如果上传图片 宽高 比 压缩的要小 则不压缩  
		        if (w > yw && h > yh)  
		        {  
		            FileOutputStream fos = null;
					try {
						fos = new FileOutputStream(fileName);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}  
		  
					ByteArrayInputStream fis = null;
					try {
						//fis = (FileInputStream) picture.getInputStream().getClass();
						fis =  (ByteArrayInputStream) picture.getInputStream();
					} catch (IOException e) {
						e.printStackTrace();
					}  
		            byte[] buffer = new byte[1024];  
		            int len = 0;  
		            try {
						while ((len = fis.read(buffer)) > 0)  
						{  
						    try {
								fos.write(buffer, 0, len);
							} catch (IOException e) {
								e.printStackTrace();
							}  
						}
					} catch (IOException e) {
						e.printStackTrace();
					}finally{
						try {
							fis.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
						try {
							fos.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
		           
		        }  
		        else  
		        {  
		            scaledImage = scaleImage.imageZoomOut(srcBufferImage, w, h);  
		            FileOutputStream out = null;
					try {
						out = new FileOutputStream(fileName);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}  
		            try {
						ImageIO.write(scaledImage, "jpeg", out);
					} catch (IOException e) {
						e.printStackTrace();
					}  
		            finally{
		            	try {
							out.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
		            }
		        }  
			}
	        //验证失败
	        else{
	        	json.put("filePath", "");
			}
		}
		else{
			json.put("filePath", "");
		}
		try {
			response.getWriter().write(json.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				response.getWriter().close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	//查询所有主题
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody List<ThemeInformation> getAlltheme(){
		return themeinformationservice.selectByExample(null);
	}
	//根据ID获得主题
	@RequestMapping(method=RequestMethod.GET,value = "/{id}")
	public @ResponseBody ThemeInformation getThemeById(@PathVariable(value="id") Long id){
		return themeinformationservice.getThemeById(id);
	}
	/**
	 * 获得板块下的通过审批所有主题和主题下的知识总数
	 * @param id 板块ID
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET,value="/bySectionID/{id}")
	public String getThemeBySectionId(@PathVariable(value="id") Long id,HttpServletResponse response, HttpServletRequest request,ModelMap map){
		DirectorytreeCriteria directorytreeCriteria = new DirectorytreeCriteria();
		directorytreeCriteria.setOrderByClause("NODE_ID");
		Criteria d_criteria = directorytreeCriteria.createCriteria();
		d_criteria.andFatherNodeIdEqualTo(id);
		d_criteria.andTypeEqualTo(Constants.TYPE_ONE);
		d_criteria.andNodeIdNotEqualTo(1l);//去掉未分类知识主题
		List<Directorytree> directorytree = directorytreeservice.getDirectorytreeByDirectorytreeCriteriaWithRowbounds(directorytreeCriteria,getRowBounds(request));
		logger.info("查询结果总数为"+directorytree.size());
		if(directorytree.size() > 0){
			List<ThemeInformation> result = new ArrayList<ThemeInformation>();
			//JSONArray themeAndKnowledgeSum = new JSONArray();
			for(Directorytree dt : directorytree){
				ThemeInformation theme = themeinformationservice.selectByPrimaryKey(dt.getNodeId());
				//JSONArray themeArray = new JSONArray();
				//JSONObject jsonobj = new JSONObject();
				//JSONObject jsonobj1 = new JSONObject();
				if(theme.getApproalStatus().equals(Constants.APPROVAL_SUCCESS)){//判断是否为审批通过主题
					//themeArray.add(theme);
					Long sum = directorytreeservice.getCountByThemeId(theme.getId());
					theme.setKnoledgeSum(sum);
					result.add(theme);
					logger.info(theme.getCreateTime());
					//jsonobj.put("sum", sum);
					//themeArray.add(jsonobj);
					//jsonobj1.put("result", themeArray);
					//themeAndKnowledgeSum.add(jsonobj1);
				}
			}
			PageInfo<Directorytree> page = new PageInfo<Directorytree>(directorytree);
			map.put("page", page);
			map.put("theme", result);
		}
		return "/app/field/sectionDetail/themeList.jsp";
	}
	/**
	 * 得到板块下的主题总数
	 * @param id 板块ID
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET,value="/count/{id}")
	public @ResponseBody int getCountBySectionId(@PathVariable(value="id") Long id){
		DirectorytreeCriteria directorytreeCriteria = new DirectorytreeCriteria();
		Criteria d_criteria = directorytreeCriteria.createCriteria();
		d_criteria.andFatherNodeIdEqualTo(id);
		d_criteria.andTypeEqualTo(Constants.TYPE_ONE);
		d_criteria.andNodeIdNotEqualTo(1l);
		int count = directorytreeservice.getDirectorytreeAmount(directorytreeCriteria);
		logger.info(id + "下的主题总条数为："+ count);
		return  count;
	}
	/**
	 * 模糊查询主题
	 * @param name
	 * @param map
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET,value="search")
	public String getThemeByName(@RequestParam(value="name")String name,ModelMap map){
		//限定查询前10条
		List<ThemeInformation> re = themeinformationservice.getThemeByName(name,new RowBounds(0,10));
		map.put("themes", re);
		return "/app/directory/dTheme/theme_list.jsp";
	}
	@RequestMapping(value="page")
	public String returnJSp(){
		return "/app/directory/themeinformation/createTheme.jsp";
	}
}
