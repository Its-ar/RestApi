package nutech.restapi.Model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterMemberRequest {

	@NotBlank //validasi
	@Size(max = 100)
	@Email(message = "Invalid email format")
	private String email;
	
	@NotBlank(message = "First name ngk boleh kosong")
	@Size(max = 100)
	private String first_name;
	
	@NotBlank(message = "Last name ngk boleh kosong")
	@Size(max = 100)
	private String last_name;
	
	@NotBlank
	@Size(min = 8, message = "Password must be at least 8 characters long")
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RegisterMemberRequest(@NotBlank @Size(max = 100) @Email(message = "Invalid email format") String email) {
		super();
		this.email = email;
	}
	
	
}
