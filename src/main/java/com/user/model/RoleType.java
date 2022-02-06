package com.user.model;

public enum RoleType {
	
	ROLE_USER("ROLE_USER"),
    ROLE_MODERATOR("ROLE_ADMIN"),
    ROLE_ADMIN("ROLE_ADMIN");
 
    private String code;
	
    private RoleType(String code)
    {
		this.code = code;
    }
    
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public static RoleType getRoleType(String code) {
		
		for(RoleType roleType: RoleType.values())
		{
			if(roleType.getCode().equalsIgnoreCase(code))
			{
				return roleType;
			}
		}
		throw new IllegalArgumentException("code [" + code + "] not supported.");
	}
	
}

