
public class Main {

	public static void main(String[] args) {
		final Player player1 = new Player("Tanaka", new FoolStrategy(1));
		final Player player2 = new Player("Yoshida", new SmartStrategy(2));
		
		for(int i = 0; i < 10 ; i++) {
			final Hand nextHand1 = player1.nextHand();
			final Hand nextHand2 = player2.nextHand();
			
			if(nextHand1.isStrongerThan(nextHand2)) {
				String.format("Winner:%s", player1);
				player1.win();
				player2.lose();
			}
			else if(nextHand2.isStrongerThan(nextHand1)) {
				String.format("Winner:%s", player2);
				player1.lose();
				player2.win();
			}
			else {
				player1.even();
				player2.even();
			}	
		}
		
		System.out.println("Total result:");
		System.out.println(player1);
		System.out.println(player2);
		

	}

}
