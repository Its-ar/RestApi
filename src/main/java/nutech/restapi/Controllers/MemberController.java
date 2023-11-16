package nutech.restapi.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import nutech.restapi.Model.RegisterMemberRequest;
import nutech.restapi.Model.WebResponse;
import nutech.restapi.Services.MemberService;

@RestController
@RequestMapping
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@PostMapping(
			path = "/api/members",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public WebResponse<String> register(@RequestBody RegisterMemberRequest request){
		memberService.register(request);
		return WebResponse.<String>builder().data("email sdfasdf").build();
	}
}
