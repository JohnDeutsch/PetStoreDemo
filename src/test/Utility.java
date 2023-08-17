package test;

public class Utility {

	// the reason we use this function is to remedy the fact that there are a lot of extra white spaces
	// in the html code that we need to make string compares to
	public static boolean stringCompareRemoveAllWhiteSpaces(String cmp1, String cmp2) {
		cmp1.replaceAll("//s+", "");
		cmp2.replaceAll("//s+", "");
		return cmp1.compareToIgnoreCase(cmp2) == 0;
	}
}
