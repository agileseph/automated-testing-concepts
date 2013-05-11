/*
 * Copyleft 2013
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.organization.automation.project.spice.mix.testng.extension.logging;

import java.util.Calendar;
import java.util.TimeZone;
import java.util.Locale;
import java.text.SimpleDateFormat;

public final class DateUtils {
	public static final String DATE_FORMAT_NOW        = "[dd MMMMM yyyy aaa hh:mm:ss.SSS z]";
	public static final String CUSTOM_REPORT_NOW      = "dd MMMMM yyyy aaa hh:mm:ss z";
	public static final String DATE_MEDIUM_FORMAT_NOW = "dd-MMMMM-yyyy_HH-mm-ss";

	public static final Locale DATE_LOCALE = Locale.UK;

	public static final String TIME_ZONE_REGION = "Europe";
	public static final String TIME_ZONE_CITY = "Moscow";

	public static final String TIME_ZONE_BELARUS = "GMT+3:00";
	public static final String TIME_ZONE_USA = "GMT-5:00";

	/**
	 * Protect constructor since it is a static only class.
	 */
	private DateUtils() {
	}

	public static synchronized String now() {
		return new SimpleDateFormat(DATE_FORMAT_NOW, DATE_LOCALE)
				.format(Calendar.getInstance().getTime());
	}

	public static synchronized String now_2TimeZones() {
		setBelarusTimeZone();
		String result = new SimpleDateFormat(DATE_FORMAT_NOW, DATE_LOCALE).
															format(Calendar.getInstance().getTime());

		setUSATimeZone();
		result += new SimpleDateFormat(DATE_FORMAT_NOW, DATE_LOCALE)
				.format(Calendar.getInstance().getTime());

		setBelarusTimeZone();

		return result;
	}

	public static synchronized String now_TimeZone_BY() {
		setBelarusTimeZone();
		String result = new SimpleDateFormat(DATE_FORMAT_NOW, DATE_LOCALE).
															format(Calendar.getInstance().getTime());

		return result;
	}

	public static synchronized String now_TimeZone_NY() {
		setUSATimeZone();
		String result = new SimpleDateFormat(DATE_FORMAT_NOW, DATE_LOCALE).
															format(Calendar.getInstance().getTime());

		setBelarusTimeZone();

		return result;
	}

	public static synchronized String getMediumFormatNow() {
		return new SimpleDateFormat(DATE_MEDIUM_FORMAT_NOW, DATE_LOCALE).
															format(Calendar.getInstance().getTime());
	}

	public static void setBelarusTimeZone() {
		TimeZone.setDefault(TimeZone.getTimeZone(TIME_ZONE_BELARUS));
	}

	public static void setUSATimeZone() {
		TimeZone.setDefault(TimeZone.getTimeZone(TIME_ZONE_USA));
	}

	public static synchronized long now_TC() {
		return Calendar.getInstance().getTimeInMillis();
	}
}
