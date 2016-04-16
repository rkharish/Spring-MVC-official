package com.mobile.app.controller.model.ui;

public class MessageResponse {
	private String message;
	private String status;
	private String description;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "MessageResponse [message=" + message + ", status=" + status + ", description=" + description + "]";
	}

}
