// Solution for LeetCode problem #14, Longest Common Prefix
// Problem description found on:
// https://leetcode.com/problems/longest-common-prefix/

class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        
        // finds the length of the shortest word in strs
        var shortestLen: Int = 200 // 200 is maximum, given by problem
        strs.forEach{
            if (it.length < shortestLen) shortestLen = it.length
        }

        var output: String = "" // output string, starts empty

        // 1st loop, for every char
        for (charPosition in 0 until shortestLen){
            var auxChar: Char = strs[0][charPosition] // char for comparison, taken from 1st word
         
        // 2nd loop, for every word in strs
            for (word in strs){
                if (word[charPosition] != auxChar) return output
            }
            output += auxChar // if true adds char to the output
        }
        return output
    }
}
