package com.gmg.gatewayjwt.filter;

public class PermissionException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public PermissionException(String msg) {
        super(msg);
    }
}
