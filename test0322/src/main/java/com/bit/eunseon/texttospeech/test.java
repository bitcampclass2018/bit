package com.bit.eunseon.texttospeech;

public class test {

	public static void main(String[] args) throws Exception {
		QuickstartSample api = new QuickstartSample();


		api.makeMp3(25, "당신의 고통과 나의 고통이 다른 것 처럼, 열 시간의 고통과 십분의 고통이 다른 것처럼, 백 문장의 진실과 한문장의 진실은 다르다.", "영이", 72,"female");
	}

}
