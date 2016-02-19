package common;

import java.util.HashSet;
import java.util.Set;

public class Permutations
{
	private Permutations()
	{
	}

	/**
	 * Calculates all the permutations of the characters in the provided string.
	 * 
	 * @param str letters to permutate through
	 * @return set of all permutations of the characters in str
	 */
	public static Set<String> permutate(String str)
	{
		return permutate("", str);
	}

	private static Set<String> permutate(String prefix, String str)
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
