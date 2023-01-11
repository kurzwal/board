package com.yyr.board.service;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {
	
	// application.properties에 있는 환경변수 file.dir(파일 경로) 사용
	@Value("${file.dir}")
	private String dir;
	
	// 파일 업로드 서비스
	public String fileUpload(MultipartFile file) {
		// file이 있는지 검사
		if(file.isEmpty()) return null;
		// Original file name 가져옴
		String originalFileName = file.getOriginalFilename();
		// 확장자를 가져옴
		String extension = getExtension(originalFileName);
		// 저장할 때 이름으로 사용되는 UUID 생성
		String uuid = UUID.randomUUID().toString();
		// 실제로 저장되는 이름 생성
		String saveName = uuid + extension;
		// 파일이 저장되는 실제 경로
		String savePath = dir + saveName; 
		// 해당 파일을 실제로 해당 경로에 저장
		try {
			// transferTo : 저장하는 메소드
			file.transferTo(new File(savePath));
		} catch (Exception e) {return null;}
		return savePath;
	}
	// 파일 다운로드
	public Resource fileDownload(String fileName) {
		try {
			return new UrlResource("file:" + dir + fileName);
		} catch (Exception e) {return null;}
	}
	
	
	
	// 이미지 출력
	public Resource getImage(String imageName) {
		try {
			return new UrlResource("file:" + dir + imageName);
		} catch (Exception e) {return null;}
	}
	
	
	// 확장자를 가져오는 메소드
	private String getExtension(String fileName) {
		return fileName.substring(fileName.lastIndexOf("."));
	}
	
	
}
