package problem;

import common.Permutations;
import java.util.HashSet;
import java.util.Set;

public class Problem32 implements Problem
{
	@Override
	public int solve()
	{
		Set<String> digitVariations = Permutations.permutate("123456789"); // size = 9! = 362880
		Set<Integer> pandigitalProducts = new HashSet<>(); // there are 7
		for (String digits : digitVariations)
		{
			for (int i = 1; i < 8; i++)
			{
				for (int j = i + 1; j < 9; j++)
				{
					int multiplicand = Integer.parseInt(digits.substring(0, i));
					int multiplier = Integer.parseInt(digits.substring(i, j));
					int product = Integer.parseInt(digits.substring(j, 9));
					if (multiplicand * multiplier == product)
						pandigitalProducts.add(product);
				}
			}
		}

		return pandigitalProducts.stream().reduce(Integer::sum).get();
	}

	@Override
	public int getKnownAnswer()
	{
		return 45228;
	}
}
