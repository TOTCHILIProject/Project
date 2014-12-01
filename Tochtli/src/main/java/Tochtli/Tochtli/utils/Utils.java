package Tochtli.Tochtli.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

	public static String datePrintFormat = "dd/MM/yyyy hh:mm";

	public static String formatDate(Date date) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat dt = new SimpleDateFormat();
		return dt.format(date);
	}
}
