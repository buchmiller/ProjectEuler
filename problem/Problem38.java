package problem;

import common.Combinations;
import java.util.List;

public class Problem38 implements Problem
{
	@Override
	public int solve()
	{
//		List<Object> set = new ArrayList<>(Arrays.asList(1, 2, 3));
//		Combinations.getAllSubsets(set);
		List<String> digitVariations = Combinations.combine("123456789", 4);
		
//		Set<String> digitVariations = Permutations.permutate("123456789"); // size = 9! = 362880
//		Set<Integer> pandigitalProducts = new HashSet<>(); // there are 7
//		for (String digits : digitVariations)
//		{
//			for (int i = 1; i < 8; i++)
//			{
//				for (int j = i + 1; j < 9; j++)
//				{
//					int multiplicand = Integer.parseInt(digits.substring(0, i));
//					int multiplier = Integer.parseInt(digits.substring(i, j));
//					int product = Integer.parseInt(digits.substring(j, 9));
//
//					if (multiplicand * multiplier == product)
//						pandigitalProducts.add(product);
//				}
//			}
//		}
		return 0;
	}

	@Override
	public int getKnownAnswer()
	{
		throw new UnsupportedOperationException("Not supported yet.");
	}
}
