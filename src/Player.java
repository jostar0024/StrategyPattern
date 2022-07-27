
public class Player {
	private String m_name;
	private Strategy m_strategy;
	private int m_winCount;
	private int m_loseCount;
	private int m_gameCount;
	
	public Player(final String name , final Strategy strategy) {
		m_name = name;
		m_strategy = strategy;
	}
	
	public Hand nextHand() {
		return m_strategy.nextHand();
	}
	
	public void win() {
		m_strategy.study(true);
		m_winCount++;
		m_gameCount++;
	}
	
	public void lose() {
		m_strategy.study(false);
		m_loseCount++;
		m_gameCount++;
	}
	
	public void even() {
		m_gameCount++;
	}
	
	@Override
	public String toString() {
		return "{" 
				+ m_name + ":"
				+ m_gameCount + "games, "
				+ m_winCount + "win "
				+ m_loseCount + "lose"
				+ "]";
	}
	
}
