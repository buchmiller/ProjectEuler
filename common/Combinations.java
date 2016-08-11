package common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations
{
	private Combinations()
	{
	}

	/**
	 * Generates the powerset of the passed in set. Each character of the passed in string is an element of the set.
	 * 
	 * @see http://stackoverflow.com/a/5023543/3033899
	 * 
	 * @param set A string of characters in a set
	 * @return The powerset (all subsets) of the original set.
	 */
	public static List<String> getAllSubsetsOfString(String set)
	{
		List<String> subsets = new ArrayList<>();
		
		for (int i = 1; i < set.length(); i++)
		{
			subsets.add(set.substring(i - 1, i));
			
			List<String> newSubsets = new ArrayList<>();
			
			for (int j = 0; j < subsets.size(); j++)
			{
				String newSubset = subsets.get(j) + set.substring(i, i + 1);
				newSubsets.add(newSubset);
			}
			
			subsets.addAll(newSubsets);
		}
		
		subsets.add(set.substring(set.length() - 1));
		subsets.add(""); //the empty set
		
		return subsets;
	}

	/**
	 * Generates the powerset of the passed in set.
	 * 
	 * @see http://stackoverflow.com/a/5023543/3033899
	 * 
	 * @param set A list of elements in a set
	 * @return The powerset (all subsets) of the original set.
	 */
	public static List<List<Object>> getAllSubsets(List<Object> set)
	{
		List<List<Object>> subsets = new ArrayList<>();
		
		for (int i = 1; i < set.size(); i++)
		{
			subsets.add(Arrays.asList(set.get(i - 1)));
			
			List<List<Object>> newSubsets = new ArrayList<>();
			
			for (int j = 0; j < subsets.size(); j++)
			{
				List<Object> newSubset = new ArrayList<>();
				newSubset.addAll(subsets.get(j));
				newSubset.addAll(Arrays.asList(set.get(i)));
				
				newSubsets.add(newSubset);
			}
			
			subsets.addAll(newSubsets);
		}
		
		subsets.add(Arrays.asList(set.get(set.size() - 1)));
		subsets.add(new ArrayList<>()); //the empty set
		
		return subsets;
	}

	/**
	 * An n choose k method.
	 * @see http://stackoverflow.com/a/8495629/3033899
	 * 
	 * @param data a string where each character is a value of n
	 * @param length the k value
	 * @return list of all possible combinations of the characters in data that are size length.
	 */
	public static List<String> combine(String data, int length)
	{
		return combinations(data, length, new StringBuffer(), 0);
	}

	private static List<String> combinations(String data, int k, StringBuffer result, int startIndex)
	{
		List<String> results = new ArrayList<>();
		
		if (result.length() == k)
			results.add(result.toString());
		else
			for (int i = startIndex; i < data.length(); i++)
			{
				result.append(data.charAt(i));
				results.addAll(combinations(data, k, result, i + 1));
				result.setLength(result.length() - 1);
			}
		return results;
	}
}
