package keyboard;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import combinatorics.Permutation;
import combinatorics.PermutationImpl_Shafiur;
// command + shift + O brings the unimported packages
import graphs.Graph;
import graphs.GraphImpl_Shafiur;
import graphs.GraphPermutedImpl_Shafiur;
 

public class AppleNumericMB110LLKeyboardMetricsImpl_Shafiur implements KeyboardMetrics {


//	private static KeyLayout KeyBoardLayout;
	private static Key homeKey;
	private Set<Key> keyset;
	private static int[][] adjacentMatrix;
	private static Map<Key, Set<Key>> neighborMap;
	private Map<Key, Integer> keyToIndexMap;
	
	// I made it here so that I can 
	private Graph graphOftheMap;
	
	
	public AppleNumericMB110LLKeyboardMetricsImpl_Shafiur(KeyLayout keyLayout) {

			Map<Key, Set<Key>> neighborMap1 = new HashMap<Key, Set<Key>>();
			//	KeyBoardLayout = KeyLayout.QWERTY;
			neighborMap1.put(Key.ZERO, new HashSet<Key>(Arrays.asList(Key.NINE, Key.O, Key.P, Key.MINUS)));
			neighborMap1.put(Key.ONE, new HashSet<Key>(Arrays.asList(Key.BACKTICK, Key.TAB, Key.Q, Key.TWO)));
			neighborMap1.put(Key.TWO, new HashSet<Key>(Arrays.asList(Key.ONE, Key.Q, Key.W, Key.THREE)));
			neighborMap1.put(Key.THREE, new HashSet<Key>(Arrays.asList(Key.TWO, Key.W, Key.E, Key.FOUR)));
			neighborMap1.put(Key.FOUR, new HashSet<Key>(Arrays.asList(Key.THREE, Key.E, Key.R, Key.FIVE)));
			neighborMap1.put(Key.FIVE, new HashSet<Key>(Arrays.asList(Key.FOUR, Key.R, Key.T, Key.SIX)));
			neighborMap1.put(Key.SIX, new HashSet<Key>(Arrays.asList(Key.FIVE, Key.T, Key.Y, Key.SEVEN)));
			neighborMap1.put(Key.SEVEN, new HashSet<Key>(Arrays.asList(Key.SIX, Key.Y, Key.U, Key.EIGHT)));
			neighborMap1.put(Key.EIGHT, new HashSet<Key>(Arrays.asList(Key.SEVEN, Key.U, Key.I, Key.NINE)));
			neighborMap1.put(Key.NINE, new HashSet<Key>(Arrays.asList(Key.EIGHT, Key.I, Key.O, Key.ZERO)));

			neighborMap1.put(Key.A, new HashSet<Key>(Arrays.asList(Key.Q, Key.W, Key.S, Key.Z, Key.SHIFT_1)));
			neighborMap1.put(Key.B, new HashSet<Key>(Arrays.asList(Key.V, Key.G, Key.H, Key.N, Key.SPACEBAR_3)));
			neighborMap1.put(Key.C, new HashSet<Key>(Arrays.asList(Key.X, Key.D, Key.F, Key.V, Key.SPACEBAR_1)));
			neighborMap1.put(Key.D, new HashSet<Key>(Arrays.asList(Key.E, Key.R, Key.F, Key.C, Key.X, Key.S)));
			neighborMap1.put(Key.E, new HashSet<Key>(Arrays.asList(Key.THREE, Key.FOUR, Key.R, Key.D, Key.S, Key.W)));
			neighborMap1.put(Key.F, new HashSet<Key>(Arrays.asList(Key.R, Key.T, Key.G, Key.V, Key.C, Key.D)));
			neighborMap1.put(Key.G, new HashSet<Key>(Arrays.asList(Key.T, Key.Y, Key.H, Key.B, Key.V, Key.F)));
			neighborMap1.put(Key.H, new HashSet<Key>(Arrays.asList(Key.Y, Key.U, Key.J, Key.N, Key.B, Key.G)));
			neighborMap1.put(Key.I, new HashSet<Key>(Arrays.asList(Key.EIGHT, Key.NINE, Key.O, Key.K, Key.J, Key.U)));
			neighborMap1.put(Key.J, new HashSet<Key>(Arrays.asList(Key.U, Key.I, Key.K, Key.M, Key.N, Key.H)));
			neighborMap1.put(Key.K, new HashSet<Key>(Arrays.asList(Key.I, Key.O, Key.L, Key.M, Key.J, Key.COMMA)));
			neighborMap1.put(Key.L, new HashSet<Key>(Arrays.asList(Key.O, Key.P, Key.K, Key.SEMICOLON, Key.PERIOD, Key.COMMA)));
			neighborMap1.put(Key.M, new HashSet<Key>(Arrays.asList(Key.N, Key.J, Key.K, Key.COMMA, Key.SPACEBAR_5)));
			neighborMap1.put(Key.N, new HashSet<Key>(Arrays.asList(Key.H, Key.J, Key.M, Key.B, Key.SPACEBAR_4)));
			neighborMap1.put(Key.O, new HashSet<Key>(Arrays.asList(Key.NINE, Key.ZERO, Key.P, Key.L, Key.K, Key.I)));
			neighborMap1.put(Key.P, new HashSet<Key>(Arrays.asList(Key.ZERO, Key.MINUS, Key.LEFT_BRACKET, Key.SEMICOLON, Key.L, Key.O)));
			neighborMap1.put(Key.Q, new HashSet<Key>(Arrays.asList(Key.TAB, Key.ONE, Key.TWO, Key.W, Key.A)));
			neighborMap1.put(Key.R, new HashSet<Key>(Arrays.asList(Key.FOUR, Key.FIVE, Key.T, Key.F, Key.D, Key.E)));
			neighborMap1.put(Key.S, new HashSet<Key>(Arrays.asList(Key.A, Key.W, Key.E, Key.D, Key.X, Key.Z)));
			neighborMap1.put(Key.T, new HashSet<Key>(Arrays.asList(Key.FIVE, Key.SIX, Key.Y, Key.G, Key.F, Key.R)));
			neighborMap1.put(Key.U, new HashSet<Key>(Arrays.asList(Key.SEVEN, Key.EIGHT, Key.I, Key.J, Key.H, Key.Y)));
			neighborMap1.put(Key.V, new HashSet<Key>(Arrays.asList(Key.C, Key.F, Key.G, Key.B, Key.SPACEBAR_2)));
			neighborMap1.put(Key.W, new HashSet<Key>(Arrays.asList(Key.TWO, Key.THREE, Key.E, Key.S, Key.A, Key.Q)));
			neighborMap1.put(Key.X, new HashSet<Key>(Arrays.asList(Key.Z, Key.S, Key.D, Key.C)));
			neighborMap1.put(Key.Y, new HashSet<Key>(Arrays.asList(Key.SIX, Key.SEVEN, Key.U, Key.H, Key.G, Key.T)));
			neighborMap1.put(Key.Z, new HashSet<Key>(Arrays.asList(Key.A, Key.S, Key.X, Key.SHIFT_1)));

			neighborMap1.put(Key.BACKTICK, new HashSet<Key>(Arrays.asList(Key.ONE, Key.TAB)));
			neighborMap1.put(Key.TAB, new HashSet<Key>(Arrays.asList(Key.BACKTICK, Key.ONE, Key.Q)));
			neighborMap1.put(Key.SHIFT_1, new HashSet<Key>(Arrays.asList(Key.A, Key.Z)));
			neighborMap1.put(Key.BACKSLASH, new HashSet<Key>(Arrays.asList(Key.RIGHT_BRACKET, Key.RETURN)));
			neighborMap1.put(Key.RETURN, new HashSet<Key>(Arrays.asList(Key.BACKSLASH, Key.RIGHT_BRACKET, Key.TICK, Key.SHIFT_2)));
			neighborMap1.put(Key.EQUALS, new HashSet<Key>(Arrays.asList(Key.LEFT_BRACKET, Key.MINUS, Key.RIGHT_BRACKET)));
			neighborMap1.put(Key.MINUS, new HashSet<Key>(Arrays.asList(Key.LEFT_BRACKET, Key.ZERO, Key.P, Key.EQUALS)));
			neighborMap1.put(Key.LEFT_BRACKET, new HashSet<Key>(Arrays.asList(Key.MINUS, Key.P, Key.SEMICOLON, Key.TICK, Key.RIGHT_BRACKET, Key.EQUALS)));
			neighborMap1.put(Key.TICK, new HashSet<Key>(Arrays.asList(Key.SEMICOLON, Key.LEFT_BRACKET,Key.RIGHT_BRACKET, Key.RETURN, Key.SHIFT_2, Key.FORESLASH)));
			neighborMap1.put(Key.SEMICOLON, new HashSet<Key>(Arrays.asList(Key.P, Key.L, Key.PERIOD, Key.FORESLASH, Key.TICK, Key.LEFT_BRACKET)));
			neighborMap1.put(Key.FORESLASH,new HashSet<Key>(Arrays.asList(Key.PERIOD, Key.SEMICOLON, Key.TICK, Key.SHIFT_2)));
			neighborMap1.put(Key.SHIFT_2, new HashSet<Key>(Arrays.asList(Key.FORESLASH, Key.TICK, Key.RETURN)));
			neighborMap1.put(Key.RIGHT_BRACKET,new HashSet<Key>(Arrays.asList(Key.TICK, Key.EQUALS, Key.LEFT_BRACKET, Key.RETURN, Key.BACKSLASH)));
			neighborMap1.put(Key.PERIOD,new HashSet<Key>(Arrays.asList(Key.COMMA, Key.L, Key.SEMICOLON, Key.FORESLASH)));
			neighborMap1.put(Key.COMMA, new HashSet<Key>(Arrays.asList(Key.M, Key.K, Key.L, Key.PERIOD)));

			neighborMap1.put(Key.SPACEBAR_1, new HashSet<Key>(Arrays.asList(Key.C)));
			neighborMap1.put(Key.SPACEBAR_2, new HashSet<Key>(Arrays.asList(Key.V)));
			neighborMap1.put(Key.SPACEBAR_3, new HashSet<Key>(Arrays.asList(Key.B)));
			neighborMap1.put(Key.SPACEBAR_4, new HashSet<Key>(Arrays.asList(Key.N)));
			neighborMap1.put(Key.SPACEBAR_5, new HashSet<Key>(Arrays.asList(Key.M)));
			
			neighborMap = neighborMap1;
			GraphImpl_Shafiur qwertyGraph = new GraphImpl_Shafiur(neighborMap);
			
			
			if (keyLayout == KeyLayout.QWERTY)
			{
				homeKey = Key.J;
				graphOftheMap = qwertyGraph;
			}	
		
			
			if (keyLayout == KeyLayout.DVORAK)
			{
				List<Key> keylist1 = Arrays.asList(Key.FORESLASH, Key.Z, Key.SEMICOLON, Key.S, Key.O,  
						Key.R, Key.P, Key.L, Key.N, Key.B, Key.X, Key.Q, Key.TICK, Key.MINUS, Key.LEFT_BRACKET);
				List<Key> keylist2 = Arrays.asList(Key.ONE);
				List<Key> keylist3 = Arrays.asList(Key.TWO);
				List<Key> keylist4 = Arrays.asList(Key.THREE);
				List<Key> keylist5 = Arrays.asList(Key.FOUR);
				List<Key> keylist6 = Arrays.asList(Key.FIVE);
				List<Key> keylist7 = Arrays.asList(Key.SIX);
				List<Key> keylist8 = Arrays.asList(Key.SEVEN);
				List<Key> keylist9 = Arrays.asList(Key.EIGHT);
				List<Key> keylist10 = Arrays.asList(Key.NINE);
				List<Key> keylist11 = Arrays.asList(Key.SPACEBAR_1);
				List<Key> keylist12 = Arrays.asList(Key.SPACEBAR_2);
				List<Key> keylist13 = Arrays.asList(Key.SPACEBAR_3);
				List<Key> keylist14 = Arrays.asList(Key.SPACEBAR_4);
				List<Key> keylist15 = Arrays.asList(Key.SPACEBAR_5);
				List<Key> keylist16 = Arrays.asList(Key.RETURN);
				List<Key> keylist17 = Arrays.asList(Key.BACKSLASH);
				List<Key> keylist18 = Arrays.asList(Key.BACKTICK);
				List<Key> keylist19 = Arrays.asList(Key.E, Key.PERIOD, Key.V, Key.K, Key.T, Key.Y, Key.F, Key.U, Key.G, Key.I, Key.C, Key.J, Key.H, Key.D);
				List<Key> keylist20 = Arrays.asList(Key.M);
				List<Key> keylist21 = Arrays.asList(Key.A);
				List<Key> keylist22 = Arrays.asList(Key.ZERO);
				List<Key> keylist23 = Arrays.asList(Key.SHIFT_1);
				List<Key> keylist24 = Arrays.asList(Key.SHIFT_2);
				List<Key> keylist25 = Arrays.asList(Key.EQUALS, Key.RIGHT_BRACKET);
				List<Key> keylist26 = Arrays.asList(Key.COMMA, Key.W);
				List<Key> keylist27 = Arrays.asList(Key.TAB);
				
				
				
				//				Set set3 = qwertyGraph.getVertexSet();				
				//				Map<Object, Set<Object>> y = new HashMap<>();
				//				for(Object x : set3)
				//				{
				//					Set<Object> set2 = new HashSet<>();	
				//					for(Object z: set3)
				//					{
				//						if(qwertyGraph.hasEdge(x, z))
				//						{
				//							set2.add(z);
				//						}
				//					}
				//					y.put(x, set2);
				//					System.out.println("Map of qwerty : "+y);
				//				}
				//				System.out.println("\n \n \n");
				//
				//				System.out.println();
				//				
				
				
				Permutation<Key> p = getPermutation(keylist1, keylist19, keylist25, keylist4, keylist5, keylist6, keylist7, keylist8, keylist9, keylist10, keylist11, keylist12,
						keylist13, keylist14, keylist15, keylist16, keylist17, keylist18, keylist2, keylist20, keylist21, keylist22, keylist23, keylist24, keylist3, keylist26, keylist27);
				
				homeKey = p.getImage(Key.J);
				
				
				graphOftheMap = getGraphPermuted(qwertyGraph, p);
				
				//				Map<Object, Set<Object>> MAP2 = new HashMap<>();
				//				for(Object x : set1)
				//				{
				//					Set<Object> set2 = new HashSet<>();	
				//					for(Object z: set1)
				//					{
				//						if(graphOftheMap.hasEdge(x, z))
				//						{
				//							set2.add(z);
				//						}
				//					}
				//					MAP2.put(x, set2);
				//					System.out.println("Map of dvorak : "+ MAP2);
				//				}
				//				System.out.println("\n \n \n");
				//
				//				System.out.println(); 
				
			}	
			
			
			if(keyLayout.equals(KeyLayout.COLEMAK))
			{
			List<Key> keylist1 = Arrays.asList(Key.L, Key.I, Key.U);
			List<Key> keylist2 = Arrays.asList(Key.BACKTICK);
			List<Key> keylist3 = Arrays.asList(Key.ONE);
			List<Key> keylist4 = Arrays.asList(Key.TWO);
			List<Key> keylist5 = Arrays.asList(Key.THREE);
			List<Key> keylist6 = Arrays.asList(Key.FOUR);
			List<Key> keylist7 = Arrays.asList(Key.FIVE);
			List<Key> keylist8 = Arrays.asList(Key.SIX);
			List<Key> keylist9 = Arrays.asList(Key.SEVEN);
			List<Key> keylist10 = Arrays.asList(Key.EIGHT);
			List<Key> keylist11 = Arrays.asList(Key.NINE);
			List<Key> keylist12 = Arrays.asList(Key.ZERO);
			List<Key> keylist13 = Arrays.asList(Key.MINUS);
			List<Key> keylist14 = Arrays.asList(Key.EQUALS);
			List<Key> keylist15 = Arrays.asList(Key.RETURN);
			List<Key> keylist16 = Arrays.asList(Key.SHIFT_1);
			List<Key> keylist17 = Arrays.asList(Key.SHIFT_2);
			List<Key> keylist18 = Arrays.asList(Key.BACKSLASH);
			List<Key> keylist19 = Arrays.asList(Key.TAB);
			List<Key> keylist20 = Arrays.asList(Key.M);
			List<Key> keylist21 = Arrays.asList(Key.A);
			List<Key> keylist22 = Arrays.asList(Key.Q);
			List<Key> keylist23 = Arrays.asList(Key.W);
			List<Key> keylist24 = Arrays.asList(Key.H);
			List<Key> keylist25 = Arrays.asList(Key.TICK);
			List<Key> keylist26 = Arrays.asList(Key.Z);
			List<Key> keylist27 = Arrays.asList(Key.X);
			List<Key> keylist28 = Arrays.asList(Key.C);
			List<Key> keylist29 = Arrays.asList(Key.V);
			List<Key> keylist30 = Arrays.asList(Key.B);
			List<Key> keylist31 = Arrays.asList(Key.P, Key.SEMICOLON, Key.O, Key.Y, Key.J, Key.N, Key.K, Key.E, Key.F, Key.T, Key.G, Key.D, Key.S, Key.R);
			List<Key> keylist32 = Arrays.asList(Key.COMMA);
			List<Key> keylist33 = Arrays.asList(Key.PERIOD);
			List<Key> keylist34 = Arrays.asList(Key.FORESLASH);
			List<Key> keylist35 = Arrays.asList(Key.LEFT_BRACKET);
			List<Key> keylist36 = Arrays.asList(Key.RIGHT_BRACKET);
			List<Key> keylist37 = Arrays.asList(Key.SPACEBAR_1);
			List<Key> keylist38 = Arrays.asList(Key.SPACEBAR_2);
			List<Key> keylist39 = Arrays.asList(Key.SPACEBAR_3);
			List<Key> keylist40 = Arrays.asList(Key.SPACEBAR_4);
			List<Key> keylist41 = Arrays.asList(Key.SPACEBAR_5);
			
			
			Permutation<Key> permutationCOLEMAK = getPermutation(keylist1, keylist19, keylist25, keylist4, keylist5, keylist6, keylist7, keylist8, keylist9, keylist10, keylist11, keylist12,
					keylist13, keylist14, keylist15, keylist16, keylist17, keylist18, keylist2, keylist20, keylist21, keylist22, keylist23, keylist24, keylist3, keylist26, keylist27, keylist28, 
					keylist29, keylist30, keylist31, keylist32, keylist33, keylist34, keylist35, keylist36, keylist37, keylist38, keylist39,
					keylist40, keylist41);
			
			Graph<Key> colemarkGraph = getGraphPermuted(qwertyGraph, permutationCOLEMAK);
			homeKey = permutationCOLEMAK.getImage(Key.J);
			graphOftheMap = getGraphPermuted(qwertyGraph, permutationCOLEMAK);	
		}
			
		if (keyLayout.equals(KeyLayout.ROTATION_13))
		{	
			List<Key> keylist1 = Arrays.asList(Key.A, Key.N);
			List<Key> keylist2 = Arrays.asList(Key.B, Key.O);
			List<Key> keylist3 = Arrays.asList(Key.C, Key.P);
			List<Key> keylist4 = Arrays.asList(Key.D, Key.Q);
			List<Key> keylist5 = Arrays.asList(Key.E, Key.R);
			List<Key> keylist6 = Arrays.asList(Key.F, Key.S);
			List<Key> keylist7 = Arrays.asList(Key.G, Key.T);
			List<Key> keylist8 = Arrays.asList(Key.H, Key.U);
			List<Key> keylist9 = Arrays.asList(Key.I, Key.V);
			List<Key> keylist10 = Arrays.asList(Key.J, Key.W);
			List<Key> keylist11 = Arrays.asList(Key.K, Key.X);
			List<Key> keylist12 = Arrays.asList(Key.L, Key.Y);
			List<Key> keylist13 = Arrays.asList(Key.M, Key.Z);
			List<Key> keylist14 = Arrays.asList(Key.SPACEBAR_1);
			List<Key> keylist15 = Arrays.asList(Key.SPACEBAR_2);
			List<Key> keylist16 = Arrays.asList(Key.SPACEBAR_3);
			List<Key> keylist17 = Arrays.asList(Key.SPACEBAR_4);
			List<Key> keylist18 = Arrays.asList(Key.SPACEBAR_5);
			List<Key> keylist19 = Arrays.asList(Key.BACKTICK);
			List<Key> keylist20 = Arrays.asList(Key.ONE);
			List<Key> keylist21 = Arrays.asList(Key.TWO);
			List<Key> keylist22 = Arrays.asList(Key.THREE);
			List<Key> keylist23 = Arrays.asList(Key.FOUR);
			List<Key> keylist24 = Arrays.asList(Key.FIVE);
			List<Key> keylist25 = Arrays.asList(Key.SIX);
			List<Key> keylist26 = Arrays.asList(Key.SEVEN);
			List<Key> keylist27 = Arrays.asList(Key.EIGHT);
			List<Key> keylist28 = Arrays.asList(Key.NINE);
			List<Key> keylist29 = Arrays.asList(Key.ZERO);
			List<Key> keylist30 = Arrays.asList(Key.MINUS);
			List<Key> keylist31 = Arrays.asList(Key.EQUALS);
			List<Key> keylist32 = Arrays.asList(Key.RETURN);
			List<Key> keylist33 = Arrays.asList(Key.SHIFT_1);
			List<Key> keylist34 = Arrays.asList(Key.SHIFT_2);
			List<Key> keylist35 = Arrays.asList(Key.BACKSLASH);
			List<Key> keylist36 = Arrays.asList(Key.TAB);
			List<Key> keylist37 = Arrays.asList(Key.COMMA);
			List<Key> keylist38 = Arrays.asList(Key.PERIOD);
			List<Key> keylist39 = Arrays.asList(Key.FORESLASH);
			List<Key> keylist40 = Arrays.asList(Key.LEFT_BRACKET);
			List<Key> keylist41 = Arrays.asList(Key.RIGHT_BRACKET);
			List<Key> keylist42 = Arrays.asList(Key.TICK);
			List<Key> keylist43 = Arrays.asList(Key.SEMICOLON);
			

			Permutation<Key> permutation13ROTATION = getPermutation(keylist1, keylist19, keylist25, keylist4, keylist5, keylist6, keylist7, keylist8, keylist9, keylist10, keylist11, keylist12,
					keylist13, keylist14, keylist15, keylist16, keylist17, keylist18, keylist2, keylist20, keylist21, keylist22, keylist23, keylist24, keylist3, keylist26, keylist27, keylist28, 
					keylist29, keylist30, keylist31, keylist32, keylist33, keylist34, keylist35, keylist36, keylist37, keylist38, keylist39,
					keylist40, keylist41, keylist42, keylist43);
		
			Graph<Key> colemarkGraph = getGraphPermuted(qwertyGraph, permutation13ROTATION);
			homeKey = permutation13ROTATION.getImage(Key.J);
			graphOftheMap = getGraphPermuted(qwertyGraph, permutation13ROTATION);	
		}

			// getting the keyset from the previous graph problem we solved
			// making the set of all the keys together from the graph
			HashSet<Key> keys = new HashSet<Key>(qwertyGraph.getVertexSet());
			keyset = keys;
			keyToIndexMap = keyToIndex(keyset);
			adjacentMatrix = AdjacencyMatrix(keyset, keyToIndexMap);

	}
	
	
	
	
	
	private <Key> Graph<Key> getGraphPermuted(Graph<Key> qwertyGraph,Permutation permutationFromQWERTYToNewKeyboard)
    {
        return new GraphPermutedImpl_Shafiur<Key>(qwertyGraph, permutationFromQWERTYToNewKeyboard);
    }
	
	
	private <Key> Permutation<Key> getPermutation(List<Key>... cycles)
    {
        return new PermutationImpl_Shafiur<Key>(cycles);
    }
	
	
	
	
	
	
	
	
	// we need the keyToIndex set because 
	private static Map<Key, Integer> keyToIndex(Set<Key> keySet){
		
		// this is tricky because it's storing the index positions of a key from a a set
		Map<Key, Integer> keyToIndex = new HashMap<>();
		int index = 0;
		
		// this is way to traverse set
		for (Key key : keySet) 
		{
		    keyToIndex.put(key, index);
		    index++;
		}	
		return keyToIndex;
	}
	
	
	

	// making a 2D adjacency matrix of the whole 56 elements
	private int[][] AdjacencyMatrix(Set keyset, Map<Key, Integer> keyToIndexMap)
	{

		int count = 0;
		int[][] intAdjacencyMatrix = new int[keyToIndexMap.size()][keyToIndexMap.size()];
		for(Object x: keyset)
		{
			for(Object y: keyset)
			{
				if(graphOftheMap.hasEdge(x, y))
				{
					count += 1;
					intAdjacencyMatrix[keyToIndexMap.get(x)][keyToIndexMap.get(y)] = 1;
				}
				else
				{
					intAdjacencyMatrix[keyToIndexMap.get(x)][keyToIndexMap.get(y)] = 0;
				}
			}
		}
		
		return intAdjacencyMatrix;
	}

	

	private static int[][] multiply(int[][] A, int[][] B) {
		int rowCount_A = A.length;
		assert rowCount_A > 0 : "rowCount_A = 0!";
		int columnCount_A = A[0].length;
		int rowCount_B = B.length;
		assert rowCount_B > 0 : "rowCount_B = 0!";
		int columnCount_B = B[0].length;
		assert columnCount_A == rowCount_B
				: "columnCount_A = " + columnCount_A + " <> " + rowCount_B + " = rowCount_B!";
		int[][] C = new int[rowCount_A][columnCount_B];
		for (int i = 0; i < rowCount_A; i++)
			for (int j = 0; j < columnCount_B; j++)
				for (int k = 0; k < columnCount_A; k++)
					C[i][j] += A[i][k] * B[k][j];
		return C;
	}
		
	
	
	// We're doing matrix multiplication here to get the new matrix and check if the coordinate
	public int getMatatricesPowerForKeys(int key1RowIndex, int key2ColumnIndex)
	{
		//		System.out.println(adjacentMatrix);
		int[][] temporaryMatrices =  adjacentMatrix;
		int count = 1;
		//		System.out.println("Hello: "+temporaryMatrices[key1RowIndex][key2ColumnIndex]);
		while(temporaryMatrices[key1RowIndex][key2ColumnIndex] == 0) 
		{
			count +=1;
			temporaryMatrices = multiply(temporaryMatrices, adjacentMatrix);
		}
		return count;
		
	}
	
	

	@Override
	public double getDistance(Key key1, Key key2) {
		
		if(key1.equals(key2))
		{
			return 0;
		}
		
		// there are 264 edges in the first graph where the distance is one
		// finding the distance between two keys of the keyboard,
//		System.out.println(keyToIndexMap);
		int key1index = keyToIndexMap.get(key1);
		int key2index =  keyToIndexMap.get(key2);


		
		int distanceBetweenTheKeys = getMatatricesPowerForKeys(key1index, key2index);

//		 print the adjacency matrix with row and column headers

		double distance = (double)distanceBetweenTheKeys;
		return distance;
		
	}
	
	

	//
	private Set<Key> getKeySet(char ch) {
		Set<Key> keySet1 = new HashSet<Key>();
		
		for(Key k: keyset)
		{
			if(k== Key.SHIFT_1 || k== Key.SHIFT_2)
				{
					continue;
				}
			
			if((k.getNormalCharacter() == ch || k.getShiftModifiedCharacter() == ch))
				{
					keySet1.add(k);
				}
		}
		return keySet1;
	}
	
	@Override
	public double getDistance(String str) {
		Key startingKey = homeKey;
		
		double distance = 0;
		
		// initial character of the string
		char initialCharacter = str.charAt(0);
		Set<Key> setOfKeysOfInitialCharacter = getKeySet(initialCharacter);
		ArrayList<Key> x = new ArrayList<Key>(setOfKeysOfInitialCharacter); 
		
		// I'm not considering space or shift now that's why I'm just taking the first value from the array of key set of the character
		// this is the initial key of the string
		Key initialStringKey = x.get(0);
		distance += getDistance(startingKey, initialStringKey);

		
		int i = 1;
		while(i < str.length())
		{
			Set<Key> setOfKeysOfCharacter = getKeySet(str.charAt(i));
			ArrayList<Key> y = new ArrayList<Key>(setOfKeysOfCharacter);

			if(y.size()>1)
			{
				Key nextKey = null;
				double lowestDistance = 248;
				for(Key arrayKey: y)
				{
					double minumumDistance = getDistance(initialStringKey, arrayKey);
					if (minumumDistance<lowestDistance)
					{
						lowestDistance = minumumDistance;
						nextKey = arrayKey;
					}
				}

				distance += lowestDistance;	
				initialStringKey = nextKey;

			}
			
			else
			{
				Key nextKey = y.get(0);
				distance += getDistance(initialStringKey, nextKey);
				initialStringKey = nextKey;
			}
			i++;
		}	
		return distance;	
	}
	
	
	
	public String toString(int[][] adjacentMatrix)
	{
		String str = "";
		System.out.print(String.format("%-13s", ""));
		for (Key key : keyset) {
		    System.out.print(String.format("%-13s", key));
		}
		System.out.println();
		for (int i = 0; i < keyset.size(); i++) {
		    System.out.print(String.format("%-13s", keyset.toArray()[i]));
		    for (int j = 0; j < keyset.size(); j++) {
		        System.out.print(String.format("%-13d", adjacentMatrix[i][j]));
		    }
		    System.out.println();
		}
		return str;
	}

	
//
//
//	public static void main(String[] args) {
//		AppleNumericMB110LLKeyboardMetricsImpl_Bhauyan keycheck = new AppleNumericMB110LLKeyboardMetricsImpl_Bhauyan(KeyLayout.QWERTY);
//	
//		System.out.println(keycheck.getDistance(Key.A, Key.D));
//		System.out.println(keycheck.getDistance(Key.A, Key.G));
//		System.out.println(keycheck.getDistance(Key.ONE, Key.SPACEBAR_2));
//		String s = "v v f";
//		System.out.println("Distance: "+keycheck.getDistance(s));
//		String pi_approximation = "3.141592653589793238462643383279502884197169399375105820974944";
//	
//		System.out.println("Distance: "+keycheck.getDistance(pi_approximation));
//
//		KeyboardMetrics keyboardMetrics = new AppleNumericMB110LLKeyboardMetricsImpl_Bhauyan(KeyLayout.DVORAK);
//		System.out.println(keyboardMetrics.getDistance(H, A) + "\n");
//
//		
//		KeyboardMetrics keyboardMetrics2 = new AppleNumericMB110LLKeyboardMetricsImpl_Bhauyan(KeyLayout.COLEMAK);
//		System.out.println(keyboardMetrics2.getDistance(H,A));
//		System.out.println(keyboardMetrics2.getDistance(U,P));
//		System.out.println("pv: "+keyboardMetrics2.getDistance(P,V));
//        System.out.println(keyboardMetrics2.getDistance(V,Z));
//        System.out.println(keyboardMetrics2.getDistance(Z,T));
//        System.out.println(keyboardMetrics.getDistance("abcde"));
//	
//}	
//	
	

}

