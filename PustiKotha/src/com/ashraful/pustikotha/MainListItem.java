package com.ashraful.pustikotha;

import java.io.Serializable;

public class MainListItem implements Serializable{
	private static final long serialVersionUID = 1L;
	private int image;
	private String text;

	public MainListItem() {
		// TODO Auto-generated constructor stub
	}

	public int getImage() {
		return image;
	}

	public void setImage(int image) {
		this.image = image;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
