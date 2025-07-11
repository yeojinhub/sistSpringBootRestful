package kr.co.sist.vue;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VueController {

	@GetMapping("/appVue")
	public String vueIndex() {
		return "redirect:/index.html";
	} //String
	
	@GetMapping("/frontVue")
	public String vueFront() {
		return "frontVue";
	} //vueFront
	
	@GetMapping("/dataBinding")
	public String dataBinding() {
		return "dataBinding";
	} //dataBinding
	
	@GetMapping("/vIf")
	public String vIf() {
		return "vIf";
	} //vIf
	
	@GetMapping("/clickEvt")
	public String clickEvt() {
		return "clickEvt";
	} //clickEvt
	
	@GetMapping("/function")
	public String function() {
		return "function";
	} //function
	
	@GetMapping("/vFor")
	public String vFor() {
		return "vFor";
	} //vFor
	
	@GetMapping("/objCopy")
	public String objCopy() {
		return "objCopy";
	} //objCopy
	
	@GetMapping("/useAxios")
	public String useAxios() {
		return "useAxios";
	} //useAxios
	
} //class
