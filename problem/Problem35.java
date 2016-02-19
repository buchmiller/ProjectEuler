package problem;

import common.Primes;
import java.util.HashSet;
import java.util.Set;

public class Problem35 implements Problem
{
	@Override
	public int solve()
	{
		Set<Integer> primesUnderMillion = Primes.getPrimesUnder(1_000_000);
		int numCircularPrimes = 0;
		
		for (Integer prime : primesUnderMillion)
		{
			boolean isCircular = true;
			for (Integer rotation : getDigitRotations(prime))
			{
				if (!primesUnderMillion.contains(rotation))
				{
					isCircular = false;
					break;
				}
			}
			if (isCircular)
				numCircularPrimes++;
		}
		
		return numCircularPrimes;
	}

	@Override
	public int getKnownAnswer()
	{
		return 55;
	}

	//excludes original number
	private Set<Integer> getDigitRotations(int num)
	{
		Set<Integer> rotations = new HashSet<>();
		int start = num;
		int numDigits = (int) Math.log10((double) num);
		int multiplier = (int) Math.pow(10.0, (double) numDigits);
		while (true)
		{
			int r = num % 10; //1234 -> 4
			num /= 10; //1234 -> 123
			num += multiplier * r; //123 + 4000 -> 4123
			if (num == start)
				break;
			rotations.add(num);
		}
		return rotations;
	}
}
