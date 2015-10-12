package com.motivejelly.supportlibary;

import java.util.List;

public class AdsList {
	
	String version;
	List<Advertisement> ads;

	public String getVersion() {
		
		return new String(version);
	}

	public Advertisement get(int i) {
		
		return ads.get(i);
	}
	public int size(){
		
		return ads.size();
	}
}