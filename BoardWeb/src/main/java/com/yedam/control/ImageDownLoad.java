package com.yedam.control;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yedam.common.Control;

public class ImageDownLoad implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// {"retCode" : "Success"}
		req.setCharacterEncoding("utf-8");
		ServletInputStream sis = req.getInputStream();
		ObjectMapper mapper = new ObjectMapper();
		// [{"imgSrc" : "url", "....."....] => 자바객체.
		List<Map<String, String>> list = mapper.readValue(sis, //
				new TypeReference<List<Map<String, String>>>() {
				});
		String dml = "";
		for (Map<String, String> map : list) {
			String imgSrc = map.get("imgSrc");
			String prdName = map.get("prdName");
			prdName = prdName.replace("&", "");
			prdName = prdName.replace("amp;", " ");
			String prodCode = map.get("prodCode");
			String prodPrice = map.get("prodPrice");
			prodPrice = prodPrice.replace(",", "");
			// fileCreate(imgSrc, prdName); 12,600 => 12600
			dml += dataCreate(prodCode, prdName, prodPrice);
			System.out.println(imgSrc + ", " + prdName);
		}
		PrintWriter out = resp.getWriter();
		out.print("{\"retCode\" : \"Success\"}");
		System.out.println(dml);
	}

	String dataCreate(String prodCode, String prodName, String prodPrice) {
		String sql = " insert into tbl_product (prod_code, prod_name, prod_price, prod_image) ";
		sql += " values('" + prodCode + "','" + prodName + "','" + prodPrice + "','" + prodName + ".jpg');";
		return sql;
	}

	void fileCreate(String imgSrc, String prdName) {
		String srcPath = imgSrc;
		String name = prdName.replaceAll("/", " ").replace("*", " ");
		try {
			URL url = new URL(srcPath);
			url.openStream();
			InputStream is = url.openStream();
			BufferedInputStream bis = new BufferedInputStream(is);

			// 출력스트림
			FileOutputStream fos = new FileOutputStream("c:/temp/" + name + ".jpg");
			BufferedOutputStream bos = new BufferedOutputStream(fos);

			while (true) {
				int read = bis.read();
				if (read == -1)
					break;
				bos.write(read);
			}
			bos.flush();
			bos.close();
			fos.flush();
			fos.close();
			bis.close();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Made it");
	}

}// class
