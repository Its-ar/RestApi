package nutech.restapi.Services;

import org.springframework.stereotype.Service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import nutech.restapi.Entities.Member;
import nutech.restapi.Model.RegisterMemberRequest;
import nutech.restapi.Repository.MemberRepository;
import nutech.restapi.exception.ApiException;
import nutech.restapi.security.BCrypt;


@Service
public class MemberService {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private Validator validator;
	
	@Transactional
	public void register(RegisterMemberRequest request) {
		Set<ConstraintViolation<RegisterMemberRequest>> constraintViolations = validator.validate(request);
		if(!(constraintViolations.size() != 0) ) {
			throw new ConstraintViolationException(constraintViolations);
		}
		if(memberRepository.existsById(request.getEmail())) {
			throw new ApiException("Paramter email tidak sesuai format");
		}
		Member member = new Member();
		member.setEmail(request.getEmail());
		member.setFirst_name(request.getFirst_name());
		member.setLast_name(request.getLast_name());
		member.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt())); //karna tidak menambahkan spring security terus kalau tambahkan jadi terlalu banyak jadi dicopy dri github
		
		memberRepository.save(member);
	
	}
}