package com.motivejelly.supportlibary;

import java.io.Serializable;

public class Advertisement implements Serializable {

	private static final long serialVersionUID = 505640282345976617L;
	public static final int ANIMATION1 = 1;
	public static final int ANIMATION2 = 2;
	public static final int ANIMATION3 = 3;

	private String sn;
	private String qrsn;
	private String crc;
	private String adurl;
	private String qrurl;
	private int animation;
	private int qrposx;
	private int qrposy;
	private int duration;
	private int count;

	public Advertisement(String sn, int duration, int count) {

		this.sn = sn;
		this.duration = duration;
		this.count = count;
	}

	public Advertisement(final Builder builder) {

		this.sn = new String(builder.sn);
		this.qrsn = new String(builder.qrsn);
		this.crc = new String(builder.crc);
		this.adurl = new String(builder.adUrl);
		this.qrurl = new String(builder.qrUrl);
		this.animation = builder.animation;
		this.qrposx = builder.qrposx;
		this.qrposy = builder.qrposy;
		this.duration = builder.duration;
		count = 0;
	}

	public void display() {

		count++;
	}

	public int getDuration() {

		return duration;
	}

	public int getAnimation() {

		return animation;
	}

	public String getQrsn() {

		return qrsn;
	}

	public String getCrc() {

		return crc;
	}

	public String getAdUrl() {

		return adurl;
	}

	public String getQrUrl() {

		return qrurl;
	}

	public String getSn() {

		return sn;
	}

	public int getQrposx() {

		return qrposx;
	}

	public int getQrposy() {

		return qrposy;
	}

	public int getCount() {

		return count;
	}

	public void sumCount(final Advertisement another) {

		count = count + another.count;
	}

	@Override
	public boolean equals(Object another) {

		if ((another instanceof Advertisement)
				&& sn.equals(((Advertisement) another).sn)
				&& duration == ((Advertisement) another).duration) {
			return true;
		} else {
			return false;
		}
	}

	public static class Builder {

		private final String sn;
		private String qrsn;
		private String crc;
		private String adUrl;
		private String qrUrl;
		private int animation;
		private int qrposx;
		private int qrposy;
		private int duration;

		public Builder(final String sn) {

			this.sn = sn;
		}

		public Builder qrsn(final String qrsn) {

			this.qrsn = qrsn;
			return this;
		}

		public Builder crc(final String crc) {

			this.crc = crc;
			return this;
		}

		public Builder adUrl(final String adUrl) {

			this.adUrl = adUrl;
			return this;
		}

		public Builder qrUrl(final String qrUrl) {

			this.qrUrl = qrUrl;
			return this;
		}

		public Builder animation(final int animation) {

			this.animation = animation;
			return this;
		}

		public Builder qrposx(final int qrposx) {

			this.qrposx = qrposx;
			return this;
		}

		public Builder qrposy(final int qrposy) {

			this.qrposy = qrposy;
			return this;
		}

		public Builder duration(final int duration) {

			this.duration = duration;
			return this;
		}

		public Advertisement build() {

			return new Advertisement(this);
		}
	}
}