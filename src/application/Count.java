package application;

import config.Project;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Count {

	public static void main(String[] args) {

		try {
            long t1 = System.currentTimeMillis();

			HashMap<String,Integer> hm = new HashMap<String,Integer>();
			LineNumberReader lnr = new LineNumberReader(new InputStreamReader(new FileInputStream(Project.PATH+"data/"+args[0])));
			while (true) {
				String l = lnr.readLine();
				if (l == null) break;
				StringTokenizer st = new StringTokenizer(l);
				while (st.hasMoreTokens()) {
					String tok = st.nextToken();
					if (hm.containsKey(tok)) hm.put(tok, hm.get(tok).intValue()+1);
					else hm.put(tok, 1);
				}
			}
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("count-res")));
			for (String k : hm.keySet()) {
				writer.write(k+"<->"+hm.get(k).toString());
				writer.newLine();
			}
			writer.close();
			lnr.close();
            long t2 = System.currentTimeMillis();
            System.out.println("time in ms ="+(t2-t1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
