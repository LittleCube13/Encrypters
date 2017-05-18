import java.io.*;
import java.util.*;

public class SimpleDecrypter {

public static void main(String args[]) {
	if (args.length < 2) {
		System.err.println("Error: Not enough arguments. Please specify file to decrypt, and file to output.");
		System.exit(1);
	} else {
		try {
			File f = new File(args[0]);
			FileInputStream fr = new FileInputStream(f);
			FileOutputStream fw = new FileOutputStream(new File(args[1]));
			byte[] fbytes = new byte[(int) f.length()];
			fr.read(fbytes, 0, fbytes.length);
			for (int i = 0; i < fbytes.length; i += 1) {
				fbytes[i] -= (short) 10;
			}
			fw.write(fbytes);
			fw.close();
		} catch (Exception e) { System.err.println("Somethin's screwy: " + e.toString()); }
	}
}
}