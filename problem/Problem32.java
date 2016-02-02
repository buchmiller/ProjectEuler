package problem;

import java.util.HashSet;
import java.util.Set;

public class Problem32 implements Problem
{
	@Override
	public int solve()
	{
		Set<String> digitVariations = permutate("123456789"); // size = 9! = 362880
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

	private Set<String> permutate(String str)
	{
		return permutate("", str);
	}

	private Set<String> permutate(String prefix, String str)
	{
		Set<String> permutations = new HashSet<>();
		int n = str.length();
		if (n == 0)
			permutations.add(prefix);
		else
		{
			for (int i = 0; i < str.length(); i++)
			{
				permutations.addAll(permutate(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n)));
			}
		}

		return permutations;
	}
}
