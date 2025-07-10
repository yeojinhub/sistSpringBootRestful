package kr.co.sist.rest;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberRestController {
	
	// 아이디를 키로 MemberDTO를 저장
	private final Map<String, MemberDTO> memberMap = new HashMap<String, MemberDTO>();

	@PostMapping("/member")
	public MessageDTO addMember(@RequestBody MemberDTO mDTO) {
		
		String msg = "추가실패 - 아이디가 존재합니다.";
		String id = mDTO.getId();
		
		if( !memberMap.containsKey(id) ) {
			memberMap.put(id, mDTO);
			msg = "추가성공";
		} //end if
		
		System.out.println(mDTO);
		
		MessageDTO msgDTO = new MessageDTO(msg);
		System.out.println("MemberRestController : addMember MessageDTO 값 :"+msgDTO);
		return msgDTO;
	} //addMember
	
	//RestController는 return 객체(Map, List, Set, DTO)를 JSON문자열로 변환하여 응답
	@GetMapping("/members")
	public Collection<MemberDTO> searchAllMember(){
		Collection<MemberDTO> collection = memberMap.values();
		
		System.out.println("MemberRestController : searchAllMember collection 값 :"+collection );
		
		return memberMap.values();
	} //searchAllMember
	
	@GetMapping("/members/{id}")
	public MemberDTO searchOneMember(@PathVariable String id){
		System.out.println( "MemberRestController : searchOneMember id 값 :"+id );
		MemberDTO mDTO = memberMap.get(id);
		
		System.out.println( "MemberRestController : searchOneMember DTO 값 : "+mDTO );
		
		return mDTO;
	} //searchOneMember
	
	@PutMapping("/members/{id}")
	public MessageDTO modifyMember(@PathVariable String id,
			@RequestBody MemberDTO mDTO){
		MessageDTO msgDTO = new MessageDTO("아이디가 존재하지 않습니다.");
		System.out.println( "MemberRestController : modifyMember id 값 :"+id );
		System.out.println( "MemberRestController : modifyMember DTO 값 : "+mDTO );
		
		if( memberMap.containsKey(id) ) {
			msgDTO.setMessage(id+"님의 회원 정보를 변경하였습니다.");
			memberMap.put(id, mDTO);
		} //end if
		
		return msgDTO;
	} //modifyMember
	
	@DeleteMapping("/members/{id}")
	public MessageDTO deleteMember(@PathVariable String id){
		MessageDTO msgDTO = new MessageDTO("아이디가 존재하지 않습니다.", false);
		System.out.println( "MemberRestController : deleteMember id 값 :"+id );
		
		if( memberMap.containsKey(id) ) {
			msgDTO.setMessage(id+"님의 회원 정보를 삭제하였습니다.");
			msgDTO.setFlag(true);
			memberMap.remove(id);
		} //end if
		
		return msgDTO;
	} //deleteMember
} //class
