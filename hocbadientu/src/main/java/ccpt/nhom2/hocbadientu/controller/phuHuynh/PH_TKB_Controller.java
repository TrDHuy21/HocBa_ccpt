package ccpt.nhom2.hocbadientu.controller.phuHuynh;

import java.util.ArrayList;
import java.util.List;

import ccpt.nhom2.hocbadientu.dao.HS_TKB_Dao;
import ccpt.nhom2.hocbadientu.dao.HocSinhDao;
import ccpt.nhom2.hocbadientu.dao.PhuHuynhDao;
import ccpt.nhom2.hocbadientu.object.HS_TKB_Object;
import ccpt.nhom2.hocbadientu.object.HocSinhObject;
import ccpt.nhom2.hocbadientu.object.PhuHuynhObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.servlet.http.HttpSession;

@Controller
public class PH_TKB_Controller {
	private final HS_TKB_Dao hs_TKB_Dao;
	private final PhuHuynhDao phuHuynhDao;
	private final HocSinhDao hocSinhDao;
	
	public PH_TKB_Controller(HS_TKB_Dao hs_TKB_Dao, HocSinhDao hocSinhDao, PhuHuynhDao phuHuynhDao) {
		this.hs_TKB_Dao = hs_TKB_Dao;
		this.hocSinhDao = hocSinhDao;
		this.phuHuynhDao = phuHuynhDao;
	}
	
	@GetMapping("/phuhuynh/thoikhoabieu")
	public String showPH_TKBPage(HttpSession session, Model model) {
	    String username = (String) session.getAttribute("current_username");
	    if (username != null) {	    		        
	        PhuHuynhObject phuhuynh = phuHuynhDao.getPhuHuynhByTDN(username);
	        session.setAttribute("phuhuynh", phuhuynh);
	        model.addAttribute("phuhuynh", phuhuynh);
	        List<HocSinhObject> list_hocsinh = hocSinhDao.getListHocSinhByPhuHuynhId(phuhuynh.getPhuhuynh_id());
	        model.addAttribute("list_hocsinh", list_hocsinh);
	        
	        return "phuhuynh_thoikhoabieu";
	    } else {
	        return "redirect:/login";
	    }
	}
	
	
	@GetMapping("/phuhuynh/thoikhoabieu/{hocsinh_id}")
	public String showPH_TKBPageWithHS(HttpSession session, Model model, @PathVariable int hocsinh_id) {
		String username = (String) session.getAttribute("current_username");
	    if (username != null) {
	    	model.addAttribute("selected_hsid", hocsinh_id);
	        PhuHuynhObject phuhuynh = phuHuynhDao.getPhuHuynhByTDN(username);
	        session.setAttribute("phuhuynh", phuhuynh);
	        model.addAttribute("phuhuynh", phuhuynh);
	        List<HocSinhObject> list_hocsinh = hocSinhDao.getListHocSinhByPhuHuynhId(phuhuynh.getPhuhuynh_id());
	        model.addAttribute("list_hocsinh", list_hocsinh);
	        
	        List<HS_TKB_Object> list_tkb = hs_TKB_Dao.getTKBbyhocsinhId(hocsinh_id);
	        List<HS_TKB_Object> tkb_thu2 = new ArrayList<>();
	        List<HS_TKB_Object> tkb_thu3 = new ArrayList<>();
	        List<HS_TKB_Object> tkb_thu4 = new ArrayList<>();
	        List<HS_TKB_Object> tkb_thu5 = new ArrayList<>();
	        List<HS_TKB_Object> tkb_thu6 = new ArrayList<>();
	        List<HS_TKB_Object> tkb_thu7 = new ArrayList<>();

	        for (HS_TKB_Object tkb : list_tkb) {
				if(tkb.getThoigian() == 2) {
					tkb_thu2.add(tkb);
				}
				if(tkb.getThoigian() == 3) {
					tkb_thu3.add(tkb);
				}
				if(tkb.getThoigian() == 4) {
					tkb_thu4.add(tkb);
				}
				if(tkb.getThoigian() == 5) {
					tkb_thu5.add(tkb);
				}
				if(tkb.getThoigian() == 6) {
					tkb_thu6.add(tkb);
				}
				if(tkb.getThoigian() == 7) {
					tkb_thu7.add(tkb);
				}
			}
	        XulyData("tkb_thu2", tkb_thu2, model);
	        XulyData("tkb_thu3", tkb_thu3, model);
	        XulyData("tkb_thu4", tkb_thu4, model);
	        XulyData("tkb_thu5", tkb_thu5, model);
	        XulyData("tkb_thu6", tkb_thu6, model);
	        XulyData("tkb_thu7", tkb_thu7, model);
	        return "phuhuynh_thoikhoabieu";
	    } else {
	        return "redirect:/login";
	    }
	}
    private void XulyData(String tkb, List<HS_TKB_Object> tkb_thu, Model model) {
		for(int i=0;i<7;i++) {
        	if(i < tkb_thu.size()) {
	        	if(tkb_thu.get(i).getTiethoc() > i+1) {
	        		HS_TKB_Object x = new HS_TKB_Object("X");
	        		tkb_thu.add(i, x);
	        	}
        	}
        	else {
        		HS_TKB_Object x = new HS_TKB_Object("X");
        		tkb_thu.add(i, x);
			}	        	
        }
        
        HS_TKB_Object x = new HS_TKB_Object("***********************");
		tkb_thu.add(4, x);
		
        model.addAttribute(tkb, tkb_thu);
    }
}
