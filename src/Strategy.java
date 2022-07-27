
public interface Strategy {
	public abstract Hand nextHand();
	public abstract void study(final boolean win);
}
