package com.star.sud.zip.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.file.Files;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import net.lingala.zip4j.io.ZipOutputStream;
import net.lingala.zip4j.model.ZipParameters;

public class ZipUtil {

	private static final Logger log = Logger.getLogger(ZipUtil.class);

	private static String generateRandomPassword(int passwordLenght) {

		String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String Small_chars = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		String symbols = "!@#$%^&*_=+-/.?<>)";

		String values = Capital_chars + numbers + Small_chars + symbols;

		Random rndm_method = new Random();

		StringBuilder returnValue = new StringBuilder(passwordLenght);
		for (int i = 0; i < passwordLenght; i++) {
			returnValue.append(values.charAt(rndm_method.nextInt(values.length())));
		}
		return new String(returnValue);

	}

	public static void generateZipFile(HttpServletResponse response) throws Exception {

		ZipParameters parameters = null;

		String zipFileName = "Credentails.zip";
		response.setHeader("Content-Disposition", "attachment; filename=\"" + zipFileName + "\"");
		response.setContentType("application/zip");

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ZipOutputStream zos = new ZipOutputStream(baos);

		try {

			String password = generateRandomPassword(6);
			System.out.println(password);
			parameters = getZipParameters(password);

			String fileName = "demo.txt";
			String fileLocation = "D://test";
			File file = new File(fileLocation);
			String filePath = fileLocation + "/" + fileName;

			// if (null != file && file.isFile()) {
			if (new File(filePath).exists()) {
				byte[] imgByArry = Files.readAllBytes(new File(filePath).toPath());
				parameters.setFileNameInZip(fileName);
				zos.putNextEntry(file, parameters);
				zos.write(imgByArry);
				zos.closeEntry();
			}

			zos.finish();
			zos.close();
			response.getOutputStream().write(baos.toByteArray());
			response.flushBuffer();
			baos.close();

		} catch (Exception e) {
			log.error("generateZipFile", e);
		}

	}

	private static ZipParameters getZipParameters(String password) {

		// Initiate Zip Parameters which define various properties
		ZipParameters parameters = new ZipParameters();
		parameters.setCompressionLevel(9);
		parameters.setEncryptFiles(true);
		parameters.setEncryptionMethod(99);
		parameters.setAesKeyStrength(0x03);
		parameters.setPassword(password);
		parameters.setSourceExternalStream(true);
		return parameters;
	}

	public static void generateZipFile(HttpServletResponse response, String fileLocation, String fileName) {

		ZipParameters parameters = null;

		String zipFileName = "Credentails.zip";
		response.setHeader("Content-Disposition", "attachment; filename=\"" + zipFileName + "\"");
		response.setContentType("application/zip");

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ZipOutputStream zos = new ZipOutputStream(baos);

		try {

			// String password = generateRandomPassword(6);
			String password = "Pass12345";
			parameters = getZipParameters(password);

			File file = new File(fileLocation);
			String filePath = fileLocation + "/" + fileName;

			// if (null != file && file.isFile()) {
			if (new File(filePath).exists()) {
				byte[] imgByArry = Files.readAllBytes(new File(filePath).toPath());
				parameters.setFileNameInZip(fileName);
				zos.putNextEntry(file, parameters);
				zos.write(imgByArry);
				zos.closeEntry();
			}

			zos.finish();
			zos.close();
			response.getOutputStream().write(baos.toByteArray());
			response.flushBuffer();
			baos.close();

		} catch (Exception e) {
			log.error("generateZipFile", e);
		}

	}

}
