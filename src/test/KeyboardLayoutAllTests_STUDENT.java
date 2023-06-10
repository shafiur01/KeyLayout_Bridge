package test;

import static keyboard.Key.*;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import keyboard.AppleNumericMB110LLKeyboardMetricsImpl_Shafiur; //apple numeric keyboard that takes in a keyboard layout 
import keyboard.Key;//Enum of every key character Modified and Unmodified
import keyboard.KeyLayout; //Enum what holds the qwerty keylayout
import keyboard.KeyboardMetrics; //How fast someone can type so we can have one constructor with two keyboard layouts

import org.junit.Test;

public class KeyboardLayoutAllTests_STUDENT 
{
	private static KeyboardMetrics getKeyboardMetrics(KeyLayout keyLayout)//returns a keyboardMetrics object
	{
		return new AppleNumericMB110LLKeyboardMetricsImpl_Shafiur(keyLayout);
	}
	
	@Test
	public void simpleTestQwerty()
	{
		KeyboardMetrics keyboardMetrics = getKeyboardMetrics(KeyLayout.QWERTY);
		assertEquals(0.0, keyboardMetrics.getDistance("jjjjjjjjjjjjjjjjjj"), 0.0);
	}
	
	//jJuU7&6^5%4$3#2@1! -> the distance is 8 cause we basically go from key.J to Key.One
	@Test
	public void shiftTestQwerty()
	{
		KeyboardMetrics keyboardMetrics = getKeyboardMetrics(KeyLayout.QWERTY);
		//distance should be 8
		//[Key.J, Key.U, Key.Seven, Key.Six, Key.Five, Key.four, Key.Three, Key.Two, Key.One]
		String normalAndShiftModifiedCharacters = "jJuU7&6^5%4$3#2@1!";//get the keys and multiple each two keys
		System.out.println(normalAndShiftModifiedCharacters.length()/2-1);
		assertEquals(normalAndShiftModifiedCharacters.length()/2-1, keyboardMetrics.getDistance(normalAndShiftModifiedCharacters), 0.0);
		//getDistance() has to be 8
	}
	
	@Test
	public void newlineTestQwerty()
	{
		KeyboardMetrics keyboardMetrics = getKeyboardMetrics(KeyLayout.QWERTY);
		String testString = "jkl;\'\n]\n";
//		System.out.println(testString);
//		System.out.println(testString.length() - 1);
		assertEquals(testString.length() - 1, keyboardMetrics.getDistance(testString), 0.0);
	}
	
	@Test
	public void numberTest()
	{
		KeyboardMetrics keyboardMetrics = getKeyboardMetrics(KeyLayout.QWERTY);
		
		Map<Integer, Key> integerToKeyMap = new HashMap<Integer, Key>();
		integerToKeyMap.put(0, ZERO);
		integerToKeyMap.put(1, ONE);
		integerToKeyMap.put(2, TWO);
		integerToKeyMap.put(3, THREE);
		integerToKeyMap.put(4, FOUR);
		integerToKeyMap.put(5, FIVE);
		integerToKeyMap.put(6, SIX);
		integerToKeyMap.put(7, SEVEN);
		integerToKeyMap.put(8, EIGHT);
		integerToKeyMap.put(9, NINE);
		
		String pi_approximation = "3.141592653589793238462643383279502884197169399375105820974944";
		assertEquals(6, keyboardMetrics.getDistance(J, THREE), 0.0);//length 6
		assertEquals(9, keyboardMetrics.getDistance(THREE, PERIOD), 0.0);//length 9
		assertEquals(11, keyboardMetrics.getDistance(PERIOD, ONE), 0.0);//length 11
		double distance = 6 + 9 + 11;
		char currentChar = '1';
		for(int i = 3; i < pi_approximation.length(); i++)
		{
			int lastDigitTyped = Integer.parseInt("" + currentChar);
			Key lastKeyTyped = integerToKeyMap.get(lastDigitTyped);
			char digitCharacter = pi_approximation.charAt(i);
			int nextDigitToType = Integer.parseInt("" + digitCharacter);
			Key nextKeyToType = integerToKeyMap.get(nextDigitToType);
			double lastKeyToNextKeyDistance = keyboardMetrics.getDistance(lastKeyTyped, nextKeyToType);//getDistance(Key.ONE, Key.FOUR)
			int digitDistance = Math.abs((nextDigitToType == 0 ? 10 : nextDigitToType) - (lastDigitTyped == 0 ? 10 : lastDigitTyped));
			assertEquals(digitDistance, lastKeyToNextKeyDistance, 0.0);
			distance = distance + digitDistance;
			assertEquals(distance, keyboardMetrics.getDistance(pi_approximation.substring(0, i + 1)), 0.0);//string getDistance
			currentChar = digitCharacter;
		}
	}
	
	@Test
	public void simpleTest2Qwerty()
	{
		KeyboardMetrics keyboardMetrics = getKeyboardMetrics(KeyLayout.QWERTY);
		assertEquals(2.0, keyboardMetrics.getDistance("8*"), 0.0);//start at key j then go to key EIGHT
	}
	
	@Test
	public void neighborToNeighborTestQwerty()
	{
		KeyboardMetrics keyboardMetrics = getKeyboardMetrics(KeyLayout.QWERTY);
		String pathOfAdjacentKeysStartingAtHomeKey = "jhgfdsasdfghjkl;\']\\][poiuyhgtrfvgt567uyhnjm mnbhn nbhgv vfc cvfdxzsaqw23ewqwerty";//80 - 1 =  79
		System.out.println("pathOfAdjacentKeysStartingAtHomeKey: " + pathOfAdjacentKeysStartingAtHomeKey.length());
		assertEquals(pathOfAdjacentKeysStartingAtHomeKey.length() - 1, keyboardMetrics.getDistance(pathOfAdjacentKeysStartingAtHomeKey), 0.0);
	}
	
	@Test
	public void skipNeighborTestQwerty()
	{
		KeyboardMetrics keyboardMetrics = getKeyboardMetrics(KeyLayout.QWERTY);
		String pathOfDistanceTwoJumps = "jl9&tdzq3r6hi0=;]piyrw\tadgj";
//		System.out.println(2*(pathOfDistanceTwoJumps.length() - 1));
		assertEquals(2*(pathOfDistanceTwoJumps.length() - 1), keyboardMetrics.getDistance(pathOfDistanceTwoJumps), 0.0);
	}

	@Test
	public void simpleDistancesQwerty()
	{
		KeyboardMetrics keyboardMetrics = getKeyboardMetrics(KeyLayout.QWERTY);
		
		assertEquals(6.0, keyboardMetrics.getDistance(J, A), 0.0);
		assertEquals(5.0, keyboardMetrics.getDistance(A, B), 0.0);
		assertEquals(2.0, keyboardMetrics.getDistance(B, C), 0.0);
		assertEquals(1.0, keyboardMetrics.getDistance(C, D), 0.0);
		assertEquals(1.0, keyboardMetrics.getDistance(D, E), 0.0);
		assertEquals(2.0, keyboardMetrics.getDistance(E, F), 0.0);
		assertEquals(1.0, keyboardMetrics.getDistance(F, G), 0.0);
		assertEquals(1.0, keyboardMetrics.getDistance(G, H), 0.0);
		assertEquals(2.0, keyboardMetrics.getDistance(H, I), 0.0);
		assertEquals(1.0, keyboardMetrics.getDistance(I, J), 0.0);
		assertEquals(1.0, keyboardMetrics.getDistance(J, K), 0.0);
		assertEquals(1.0, keyboardMetrics.getDistance(K, L), 0.0);
		assertEquals(2.0, keyboardMetrics.getDistance(L, M), 0.0);
		assertEquals(1.0, keyboardMetrics.getDistance(M, N), 0.0);
		assertEquals(3.0, keyboardMetrics.getDistance(N, O), 0.0);
		assertEquals(1.0, keyboardMetrics.getDistance(O, P), 0.0);
		assertEquals(9.0, keyboardMetrics.getDistance(P, Q), 0.0);
		assertEquals(3.0, keyboardMetrics.getDistance(Q, R), 0.0);
		assertEquals(2.0, keyboardMetrics.getDistance(R, S), 0.0);
		assertEquals(3.0, keyboardMetrics.getDistance(S, T), 0.0);
		assertEquals(2.0, keyboardMetrics.getDistance(T, U), 0.0);
		assertEquals(3.0, keyboardMetrics.getDistance(U, V), 0.0);
		assertEquals(4.0, keyboardMetrics.getDistance(V, W), 0.0);
		assertEquals(2.0, keyboardMetrics.getDistance(W, X), 0.0);
		assertEquals(4.0, keyboardMetrics.getDistance(X, Y), 0.0);
		assertEquals(5.0, keyboardMetrics.getDistance(Y, Z), 0.0);
		assertEquals(3.0, keyboardMetrics.getDistance(Z, ONE), 0.0);
		assertEquals(71.0, keyboardMetrics.getDistance("abcdefghijklmnopqrstuvwxyz!"), 0.0);
		assertEquals(71.0, keyboardMetrics.getDistance("AbCdEfGhIjKlMnOpQrStUvWxYz!"), 0.0);
		assertEquals(66.0, keyboardMetrics.getDistance("mnopqrstuvwxyz!abcdefghijkl"), 0.0);
	}	
	
	@Test
	public void simpleDistancesDvorak()
	{
		KeyboardMetrics keyboardMetrics = getKeyboardMetrics(KeyLayout.DVORAK);
		
		assertEquals(6.0, keyboardMetrics.getDistance(H, A), 0.0);
		assertEquals(5.0, keyboardMetrics.getDistance(A, X), 0.0);
		assertEquals(2.0, keyboardMetrics.getDistance(X, J), 0.0);
		assertEquals(1.0, keyboardMetrics.getDistance(J, E), 0.0);
		assertEquals(1.0, keyboardMetrics.getDistance(E, PERIOD), 0.0);
		assertEquals(2.0, keyboardMetrics.getDistance(PERIOD, U), 0.0);
		assertEquals(1.0, keyboardMetrics.getDistance(U, I), 0.0);
		assertEquals(1.0, keyboardMetrics.getDistance(I, D), 0.0);
		assertEquals(2.0, keyboardMetrics.getDistance(D, C), 0.0);
		assertEquals(1.0, keyboardMetrics.getDistance(C, H), 0.0);
		assertEquals(1.0, keyboardMetrics.getDistance(H, T), 0.0);
		assertEquals(1.0, keyboardMetrics.getDistance(T, N), 0.0);
		assertEquals(2.0, keyboardMetrics.getDistance(N, M), 0.0);
		assertEquals(1.0, keyboardMetrics.getDistance(M, B), 0.0);
		assertEquals(3.0, keyboardMetrics.getDistance(B, R), 0.0);
		assertEquals(1.0, keyboardMetrics.getDistance(R, L), 0.0);
		assertEquals(9.0, keyboardMetrics.getDistance(L, TICK), 0.0);
		assertEquals(3.0, keyboardMetrics.getDistance(TICK, P), 0.0);
		assertEquals(2.0, keyboardMetrics.getDistance(P, O), 0.0);
		assertEquals(3.0, keyboardMetrics.getDistance(O, Y), 0.0);
		assertEquals(2.0, keyboardMetrics.getDistance(Y, G), 0.0);
		assertEquals(3.0, keyboardMetrics.getDistance(G, K), 0.0);
		assertEquals(4.0, keyboardMetrics.getDistance(K, COMMA), 0.0);
		assertEquals(2.0, keyboardMetrics.getDistance(COMMA, Q), 0.0);
		assertEquals(4.0, keyboardMetrics.getDistance(Q, F), 0.0);
		assertEquals(5.0, keyboardMetrics.getDistance(F, SEMICOLON), 0.0);
		assertEquals(3.0, keyboardMetrics.getDistance(SEMICOLON, ONE), 0.0);
		assertEquals(71.0, keyboardMetrics.getDistance("axje.uidchtnmbrl'poygk,qf;!"), 0.0);
		assertEquals(71.0, keyboardMetrics.getDistance("AxJe.UiDcHtNmBrL'PoYgK,Qf:!"), 0.0);
		assertEquals(66.0, keyboardMetrics.getDistance("mbrl'poygk,qf;!axje.uidchtn"), 0.0);
		
	}
	
	@Test
	public void simpleDistancesCOLEMAK()
    {
        KeyboardMetrics keyboardMetrics = getKeyboardMetrics(KeyLayout.COLEMAK);

        assertEquals(8.0, keyboardMetrics.getDistance(Q, Y), 0.0);
        assertEquals(2.0, keyboardMetrics.getDistance(Y, M), 0.0);
        assertEquals(6.0, keyboardMetrics.getDistance(M,F), 0.0);
        assertEquals(6.0, keyboardMetrics.getDistance(F,Y), 0.0);
        assertEquals(1.0, keyboardMetrics.getDistance(Y,U), 0.0);
        assertEquals(4.0, keyboardMetrics.getDistance(U,P), 0.0);
        assertEquals(2.0, keyboardMetrics.getDistance(P,V), 0.0);
        assertEquals(3.0, keyboardMetrics.getDistance(V,Z), 0.0);
        assertEquals(3.0, keyboardMetrics.getDistance(Z,T), 0.0);
        assertEquals(3.0, keyboardMetrics.getDistance(T,SEVEN), 0.0);
        assertEquals(5.0, keyboardMetrics.getDistance(SEVEN,X), 0.0);

        assertEquals(17.0, keyboardMetrics.getDistance("nqym"), 0.0);


    }
	
//    @Test
    public void simpleDistancesROT_13()
    {
        KeyboardMetrics keyboardMetrics = getKeyboardMetrics(KeyLayout.ROTATION_13);

        assertEquals(6.0, keyboardMetrics.getDistance(A,N), 0.0);
        assertEquals(7.0, keyboardMetrics.getDistance(C,P), 0.0);
        assertEquals(3.0, keyboardMetrics.getDistance(D,Q), 0.0);
        assertEquals(1.0, keyboardMetrics.getDistance(E,R), 0.0);
        assertEquals(3.0, keyboardMetrics.getDistance(Y,U), 0.0);
        assertEquals(1.0, keyboardMetrics.getDistance(T,G), 0.0);
        assertEquals(2.0, keyboardMetrics.getDistance(F,TWO), 0.0);
        assertEquals(2.0, keyboardMetrics.getDistance(TWO,F), 0.0);
        assertEquals(16.0, keyboardMetrics.getDistance("anc"), 0.0);
    }
	
}
