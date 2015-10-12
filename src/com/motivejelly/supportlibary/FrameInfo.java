package com.motivejelly.supportlibary;

import java.io.Serializable;

public class FrameInfo implements Serializable, Comparable<FrameInfo> {

	private static final long serialVersionUID = 8160136002662963406L;
	String mac;
	String id;
	String adsListVersion;
	String ip;
	int status = 0;

	public FrameInfo(String mac, String id, String adsListVersion, String ip) {

		this.id = id;
		this.ip = ip;
		this.adsListVersion = adsListVersion;
		this.mac = mac;
	}

	public String getMac() {

		return mac;
	}

	public String getId() {

		return id;
	}

	public String getAdsListVersion() {

		return adsListVersion;
	}

	public String getIp() {

		return ip;
	}

	public int getStatus() {

		return status;
	}

	public void setId(String id) {

		this.id = id;
	}

	public void setAdsListVersion(String adsListVersion) {

		this.adsListVersion = adsListVersion;
	}

	public void setIp(String ip) {

		this.ip = ip;
	}

	public void setStatus(int status) {

		this.status = status;
	}

	@Override
	public boolean equals(Object another) {

		if (another instanceof FrameInfo) {
			return mac.equals(mac);
		} else {
			return false;
		}
	}

	@Override
	public int compareTo(FrameInfo another) {

		return this.id.compareTo(another.id);
	}
}