package resources;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilities {
	DecimalFormat df = new DecimalFormat("#.0");

	//generates random date in the range [today's date, 1 year from today's date]
	public String randomDateGenerator() {

		LocalDate startDate = LocalDate.now();

		int year = startDate.getYear();
		int month = startDate.getMonthValue();
		int day = startDate.getDayOfMonth();

		LocalDate endDate = LocalDate.of(year + 1, month, day);

		long randomDate = randBetween(startDate.toEpochDay(), endDate.toEpochDay());
		return LocalDate.ofEpochDay(randomDate).toString();

	}

	//generates random number between start and end of type int
	public int randBetween(int start, int end) {
		return start + (int) Math.round(Math.random() * (end - start));
	}

//	generates random number between start and end of type long
	public long randBetween(long l, long m) {
		return l + (long) Math.round(Math.random() * (m - l));
	}

	//converting string to double and rounding it upto one decimal places using df.format
	public String DoubleRoundCeil(String str) {
		return df.format( Math.round(Math.ceil(Double.parseDouble(str))));
	}

	//splitting string to get currency values and converting it to decimal with one decimal places
	public String SplitCurrencyValueString(String str) {
		
		String temp = null;
		Pattern pattern;

		if (str.contains(",") && str.contains(".")) {
			pattern = Pattern.compile("(\\d{0,9},)?\\d{0,9}\\.\\d{0,9}");
			Matcher m = pattern.matcher(str);
			while (m.find()) {
				if (!m.group().isEmpty())
					temp = m.group().replaceAll(",", "");
			}
		} else if (str.contains(",")) {
			pattern = Pattern.compile("(\\d{0,9},)?\\d{0,9}");
			Matcher m = pattern.matcher(str);
			while (m.find()) {
				if (m.group() != null)
					temp = m.group().replaceAll(",", "");
			}
		} else if (str.contains(".")) {
			pattern = Pattern.compile("(\\d+(?:\\.\\d+)?)");
			Matcher m = pattern.matcher(str);
			while (m.find()) {
				if (m.group() != null)
					temp = m.group();
			}
		} else {
			pattern = Pattern.compile("(\\d+)");
			Matcher m = pattern.matcher(str);
			while (m.find()) {
				if (m.group() != null)
					temp = m.group();
			}
		}
		System.out.println(temp);
		return df.format(Double.parseDouble(temp));

	}
	
}
