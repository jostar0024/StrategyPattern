import java.util.Arrays;
import java.util.Random;

public class SmartStrategy implements Strategy{
	private Random m_random;
	private int m_prevHandValue = 0;
	private int m_currentHandValue = 0;
	private int[][] m_history = {
			{1,1,1, },
			{1,1,1, },
			{1,1,1, },
	};
	
	public SmartStrategy(final int seed) {
		m_random = new Random(seed);
	}
	
	private int getSum(final int handValue) {
		return Arrays.stream(m_history[handValue]).sum();
	}

	@Override
	public Hand nextHand() {
		final int bet = m_random.nextInt(getSum(m_currentHandValue));
		int handValue = 0;
		if(bet  < m_history[m_currentHandValue][0]) handValue = 0;
		else if (bet < m_history[m_currentHandValue][0] + m_history[m_currentHandValue][1]) handValue = 1;
		else handValue = 2;
		
		m_prevHandValue = m_currentHandValue;
		m_currentHandValue = handValue;
		return Hand.getHand(handValue);
	}

	@Override
	public void study(final boolean win) {
		if(win) m_history[m_prevHandValue][m_currentHandValue]++;
		else {
			if(win) m_history[m_prevHandValue][(m_currentHandValue + 1) % 3]++;
			if(win) m_history[m_prevHandValue][(m_currentHandValue + 2) % 3]++;
		}
	}
}
