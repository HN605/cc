package com.example.file;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BigfileReaderTest {

    public static void main(String[] args) {
        BigFileReader.Builder builder = new BigFileReader.Builder("C:/Users/chuang/Desktop/test.txt", line -> {

			int p = line.indexOf("{");
			int p2 = line.indexOf("}");
			String name = line.substring(0, p);
			String data = line.substring(p + 1, p2);

			String[] strs = data.split(",");
			if (strs.length <= 0) {
				return;
			}

			List<String> list = Arrays.asList(strs);

			List<String> resultList = new ArrayList<>();
			for (String str : list) {
				String[] parts = str.split(":");

				if (parts[0].equals("发型")) {
					resultList.add("hair=" + parts[1]);
				}

				if (parts[0].equals("头饰")) {
					resultList.add("cap=" + parts[1]);
				}
				if (parts[0].equals("面部")) {
					resultList.add("face=" + parts[1]);
				}
				if (parts[0].equals("胸部")) {
					resultList.add("neck=" + parts[1]);
				}
				if (parts[0].equals("上衣")) {
					resultList.add("coat=" + parts[1]);
				}
				if (parts[0].equals("下装")) {
					resultList.add("pants=" + parts[1]);
				}

				if (parts[0].equals("腰带")) {
					resultList.add("belt=" + parts[1]);
				}

				if (parts[0].equals("鞋子")) {
					resultList.add("shoes=" + parts[1]);
				}

				if (parts[0].equals("皮肤")) {
					resultList.add("skin=" + parts[1]);
				}

			}

			name = name + ":swordman?";

			for (String s: resultList) {
				name = name + "&" +s;
			}

			System.out.println(name);

			Writer writer = null;
			try {

				writer = new FileWriter(new File("C:/Users/chuang/Desktop/test2.txt"), true);
				writer.write(name);
				writer.write("\n");
				writer.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (writer != null) {
						writer.close();
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});

		BigFileReader bigFileReader = builder
				.withTreahdSize(1)
                .withCharset("utf-8")
                .withBufferSize(1024 * 1024)
				.build();

        bigFileReader.start();
    }

}
