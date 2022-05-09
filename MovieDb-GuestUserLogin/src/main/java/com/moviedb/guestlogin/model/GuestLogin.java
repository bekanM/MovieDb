package com.moviedb.guestlogin.model;

public class GuestLogin {

	private boolean success;
	private String session_id;
	private String expires_at;
	
	public GuestLogin(boolean success, String session_id, String expires_at) {
		this.success = success;
		this.session_id = session_id;
		this.expires_at = expires_at;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getSession_id() {
		return session_id;
	}

	public void setSession_id(String session_id) {
		this.session_id = session_id;
	}

	public String getExpires_at() {
		return expires_at;
	}

	public void setExpires_at(String expires_at) {
		this.expires_at = expires_at;
	}
	
	
	
}
