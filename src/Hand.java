
public enum Hand {
	//ジャンケンの手を表すenum
	ROCK("グー",0),
	SCISSORS("チョキ",1),
	PAPER("パー",2);
	
	//enumがもつフィールド
	private final String m_name;
	private final int m_handValue;
	
	private static Hand[] hands = {
			ROCK,SCISSORS,PAPER
	};
	
	//コンストラクラ
	private Hand(final String name, final int handValue) {
		m_name = name;
		m_handValue = handValue;
	}
	
	//手の値からenum定数を得る
	public static Hand getHand(final int handValue) {
		return hands[handValue];
	}
	
	public boolean isStrongerThan(final Hand hand) {
		return fight(hand) == 1;
	}
	
	public boolean isWeekerThan(final Hand hand) {
		return fight(hand) == -1;
	}
	
	private int fight(final Hand hand) {
		if(this == hand) return 0;
		else if((m_handValue + 1) % 3 == hand.m_handValue) return 1;
		else return -1;
	}
	
	@Override
	public String toString() {
		return m_name;
	}
}
