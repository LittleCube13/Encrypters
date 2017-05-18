import java.io.*;
import java.util.*;

public class AffineDecrypter {

public static void main(String args[]) {
	if (args.length < 3) {
		System.err.println("Error: Not enough arguments. Please specify file to encrypt, and file to output.");
		System.exit(1);
	} else {
		try {
			File f = new File(args[1]);
			FileInputStream fr = new FileInputStream(f);
			FileOutputStream fw = new FileOutputStream(new File(args[2]));
			byte[] fbytes = new byte[(int) f.length()];
			fr.read(fbytes, 0, fbytes.length);
			for (int i = 0; i < fbytes.length; i += 1) {
				fbytes[i] = (byte) (fbytes[i] - Integer.parseInt(args[0].substring(args[0].indexOf("x") + 1, args[0].length())));
				byte b = fbytes[i];
				for (int ii = 0; ii < Integer.parseInt(args[0].substring(0, args[0].indexOf("x"))); ii++) {
					fbytes[i] -= b;
				}
			}
			fw.write(fbytes);
			fw.close();
		} catch (Exception e) { System.err.println("Somethin's screwy: " + e.toString()); }
	}
}
}