package study.java.dao.impl;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import study.java.dao.TranDao;
import study.java.helper.HttpHelper;
import study.java.helper.JsonHelper;
import study.java.model.Tran;

public class TranDaoImpl implements TranDao {

	@Override
	public List<Tran> getTranList(String keyword) {
		List<Tran> list = null;
		
		//검색어 
        String search = null;
        
        /** 한글일 경우 URLEncoding 처리가 되어야 한다. */
        try {
			search = URLEncoder.encode(keyword, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        // Kakao OpenAPI 주소
        String url = "https://kapi.kakao.com/v1/translation/translate?src_lang=kr&target_lang=en&query=" + search;
        
        // 발급받은 REST API 키를 "KakaoAK REST_API_키" 형식으로 정의한다. (공백주의)
        Map<String, String> header = new HashMap<String, String>();
        header.put("Authorization", "KakaoAK f20ff27440f95f74db73c5446db1130c");
        
        // JSON 파일을 읽어서 객체로 변환
        // --> URL과 HTTP Header 데이터를 함께 전달한다.
        InputStream is = HttpHelper.getInstance().getWebData(url, "utf-8", header);
        
        // 통신 결과가 없다면 처리 중단
        if ( is == null ) {
        	System.out.println("데이터 다운로드 실패!");
        	return null;
        }
        // 통신에 성공하였으므로, 리턴할 List 할당
        list = new ArrayList<Tran>();
        
        // 통신 결과를 JSON으로 변환
        JSONObject json = JsonHelper.getInstance().getJSONObject(is, "utf-8");
        
        JSONArray tran_text = json.getJSONArray("translated_text");
        
        String item = String.valueOf(tran_text);
           
        // 원하는 데이터에 접근하기
      
        
   
   
   
        // 배열의 항목 수 만큼 반복
        	// 배열의 각 요소 추출
        	// 값 추출
   
        	// 추출한 값을 객체화 하여 List에 추가
        	list.add(new Tran(item));
		
		return list;
	}

}
