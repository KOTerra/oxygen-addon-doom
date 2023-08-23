package com.oxygenxml.addon.doom.workspace;

public class GameUrls {
	public static final String DOOM_URL = "https://dos.zone/player/?bundleUrl=https%3A%2F%2Fcdn.dos.zone%2Fcustom%2Fdos%2Fdoom.jsdos?anonymous=1";
	public static final String PRINCE_OF_PERSIA_URL = "https://dos.zone/player/?bundleUrl=https%3A%2F%2Fcdn.dos.zone%2Foriginal%2F2X%2F1%2F1179a7c9e05b1679333ed6db08e7884f6e86c155.jsdos?anonymous=1";
	public static final String MORTAL_KOMBAT_URL = "https://dos.zone/player/?bundleUrl=https%3A%2F%2Fcdn.dos.zone%2Foriginal%2F2X%2F8%2F872f3668c36085d0b1ace46872145285364ee628.jsdos?anonymous=1";
	public static final String GTA_URL = "https://dos.zone/player/?bundleUrl=https%3A%2F%2Fcdn.dos.zone%2Fcustom%2Fdos%2Fgta-mobile.jsdos?anonymous=1";
	public static final String SIM_CITY_URL = "https://dos.zone/player/?bundleUrl=https%3A%2F%2Fcdn.dos.zone%2Foriginal%2F2X%2F7%2F744842062905f72648a4d492ccc2526d039b3702.jsdos?anonymous=1";
	public static final String NEED_FOR_SPEED_URL = "https://dos.zone/player/?bundleUrl=https%3A%2F%2Fcdn.dos.zone%2Fcustom%2Fdos%2Fnfs.jsdos?anonymous=1";

	public static final String DOOM = "DOOM";
	public static final String PRINCE_OF_PERSIA = "Prince of Persia";
	public static final String MORTAL_KOMBAT = "Mortal Kombat";
	public static final String GTA = "GTA";
	public static final String SIM_CITY = "SIM CITY";
	public static final String NEED_FOR_SPEED = "Need for speed";

	public static String getFor(String name) {
		switch (name) {
		case DOOM:
			return DOOM_URL;
		case PRINCE_OF_PERSIA:
			return PRINCE_OF_PERSIA_URL;
		case MORTAL_KOMBAT:
			return MORTAL_KOMBAT_URL;
		case GTA:
			return GTA_URL;
		case SIM_CITY:
			return SIM_CITY_URL;
		case NEED_FOR_SPEED:
			return NEED_FOR_SPEED_URL;
		default:
			break;
		}
		return name;
	}
}
