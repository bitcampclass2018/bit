package com.bit.eunseon.texttospeech;

public class test {

	public static void main(String[] args) throws Exception {
		QuickstartSample api = new QuickstartSample();
		
		api.makeMp3(419, "처음부터 끝까지 수십차례 꼼꼼히 컴토를 해보았지만 내 삶에서는 별다른 오류가 발견되지 않았다.", "영이");
		
	}

}
