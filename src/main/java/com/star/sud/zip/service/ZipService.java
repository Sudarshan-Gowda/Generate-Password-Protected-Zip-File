package com.star.sud.zip.service;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.star.sud.zip.dto.UserDetail;
import com.star.sud.zip.dto.UserMapUtil;
import com.star.sud.zip.util.ZipUtil;

@Service("zipService")
public class ZipService {

	private static final Logger log = Logger.getLogger(ZipService.class);

	@Autowired
	protected HttpServletResponse response;

	public void generateZipFile() {
		log.debug("generateZipFile");
		try {
			LinkedHashMap<String, UserDetail> userMapDet = UserMapUtil.getMapDetails();

			File temp = File.createTempFile(String.valueOf(System.nanoTime()), ".txt");
			String absolutePath = temp.getAbsolutePath();
			String fileName = temp.getName();
			String fileFolder = temp.getParent();

			List<String> lines = new ArrayList<String>();
			for (String key : userMapDet.keySet()) {
				UserDetail userDet = userMapDet.get(key);
				lines.add(userDet.getUserName() + " - " + userDet.getPassword());
			}

			Path file = Paths.get(absolutePath);
			Files.write(file, lines, StandardCharsets.UTF_8);

			ZipUtil.generateZipFile(response, fileFolder, fileName);

			temp.deleteOnExit();
		} catch (Exception e) {
			log.error("generateZipFile", e);
		}

	}

	public void saveData(UserDetail userDetail) {
		log.debug("saveData");
		try {
			UserMapUtil.setMapDetails(userDetail);

			LinkedHashMap<String, UserDetail> userMapDet = UserMapUtil.getMapDetails();

			File temp = File.createTempFile(String.valueOf(System.nanoTime()), ".txt");
			String absolutePath = temp.getAbsolutePath();
			String fileName = temp.getName();
			String fileFolder = temp.getParent();

			List<String> lines = new ArrayList<String>();
			for (String key : userMapDet.keySet()) {
				UserDetail userDet = userMapDet.get(key);
				lines.add(userDet.getUserName() + " - " + userDet.getPassword());
			}

			Path file = Paths.get(absolutePath);
			Files.write(file, lines, StandardCharsets.UTF_8);

			ZipUtil.generateZipFile(response, fileFolder, fileName);

			temp.deleteOnExit();

		} catch (Exception e) {
			log.error("saveData", e);
		}

	}

}
