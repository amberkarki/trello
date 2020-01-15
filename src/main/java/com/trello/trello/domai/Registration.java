package com.trello.trello.domai;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Registration {
@NotEmpty
@Size(min=4, max=8)
private String username= "";

@NotEmpty
@Size(min=4, max=8)
private String password = "";

@NotEmpty
@Size(min=4, max=8)
private String repassword = "";


@NotEmpty

private String email = "";

@NotEmpty
private String role ="USER";

public String getEmail() {
	return email;
}

public String getRepassword() {
	return repassword;
}

public void setRepassword(String repassword) {
	this.repassword = repassword;
}

public void setEmail(String email) {
	this.email = email;
}

public String getUsername() {
	return username;
}

public void setUserName(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}


}
