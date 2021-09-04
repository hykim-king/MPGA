package com.pcwk.ehr;

//업그레이드 순서를 담고 있도록 수정
public enum Level {
	//BASIC(1),SILVER(2),GOLD(3)
	GOLD(3,null),SILVER(2,GOLD),BASIC(1,SILVER);
	
	private final int value ;
	private final Level next;//다음 단계의 레벨 정보
	
	Level(int value,Level next){
		this.value = value;
		this.next  = next;
	}
	
	public Level nextLevel() {
		return this.next;
	}
	

	//값을 가져오는 메서드:
	public int getValue() {
		return value;
	}
	
	//값으로 부터 level가져오기 
	public static Level valueOf(int value) {
		switch(value) {
			case 1 : return BASIC;
			case 2 : return SILVER;
			case 3 : return GOLD;
			default:
				throw new AssertionError("Unknown value:"+value);
		
		}
	}
}
