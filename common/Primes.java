package common;

import java.util.HashSet;
import java.util.Set;

public class Primes
{
	private Primes()
	{
	}

	/**
	 * Returns a set of all the prime numbers less than topNum.
	 * Algorithm used: https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
	 * 
	 * @param topNum compute all primes less than this number
	 * @return set of all prime numbers less than topNum
	 */
	public static Set<Integer> getPrimesUnder(int topNum)
	{
		topNum++;
		boolean[] A = new boolean[topNum];
		for (int i = 2; i < topNum; i++)
			A[i] = true;

		for (int i = 2; i < Math.sqrt(topNum); i++)
		{
			if (A[i])
			{
				for (int j = i * i; j < topNum; j += i)
					A[j] = false;
			}
		}

		Set<Integer> primes = new HashSet<>();
		for (int i = 2; i < topNum; i++)
		{
			if (A[i])
				primes.add(i);
		}
		return primes;
	}
}
