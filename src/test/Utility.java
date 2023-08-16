package test;

public class Utility {

	public static boolean stringCompareRemoveAllWhiteSpaces(String cmp1, String cmp2) {
		cmp1.replaceAll("//s+", "");
		cmp2.replaceAll("//s+", "");
		return cmp1.compareToIgnoreCase(cmp2) == 0;
	}
}
