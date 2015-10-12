package com.motivejelly.supportlibary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Support {

	public static AdsList getAdsListFromJson(final String josnPath) {

		final StringBuilder stringBuilder = new StringBuilder();
		try {
			final FileInputStream is = new FileInputStream(new File(josnPath));
			final BufferedReader bf = new BufferedReader(new InputStreamReader(
					is));
			String line;
			while ((line = bf.readLine()) != null) {
				stringBuilder.append(line);
			}
			bf.close();
		} catch (final IOException e) {
			e.printStackTrace();
		}
		final Gson gson = new Gson();
		final AdsList list = gson.fromJson(stringBuilder.toString(),
				new TypeToken<AdsList>() {
				}.getType());

		return list;
	}

	public static List<String> checkFiles(final String packagePath,
			final String jsonName) {

		final AdsList list = getAdsListFromJson(packagePath + jsonName);
		final ArrayList<String> missingFiles = new ArrayList<String>();
		final int j = list.size();
		for (int i = 0; i < j; i++) {
			final Advertisement ad = list.get(i);
			final File fad = new File(packagePath + "ads/" + ad.getSn());
			final File fqr = new File(packagePath + "qr/" + ad.getQrsn());
			if (!fad.exists()) {
				missingFiles.add(ad.getSn());
			}
			if (ad.getQrsn().length() != 0 && !fqr.exists()) {
				missingFiles.add(ad.getQrsn());
			}
		}

		return missingFiles;
	}
}