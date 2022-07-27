import java.util.Random;

public class FoolStrategy implements Strategy {
	private Random m_random;
	private boolean m_won = false;
	
	public FoolStrategy(final int seed) {
		m_random = new Random(seed);
	}

	@Override
	public Hand nextHand() {
		if(m_won) return Hand.getHand(0);
		return Hand.getHand(m_random.nextInt(3));
	}

	@Override
	public void study(final boolean win) {
		m_won = win;
	}

}
