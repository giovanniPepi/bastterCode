// Solution for the Leet Code problem 2423, Remove Letter To Equalize Frequency
// The problem descrition is found on the following link:
// https://leetcode.com/problems/remove-letter-to-equalize-frequency/description/

class Solution {
    fun equalFrequency(word: String): Boolean {

        // map for associating a char with its frequency
        var charCounter = mutableMapOf<Char,Int>()
        // loop to count chars and store in charCounter
        for (char in word){
            // if map contains the letter as key, adds 1 to its own value
            if (charCounter.containsKey(char)){
                charCounter[char] = charCounter[char]!! + 1
            // if map does not contain the letter, must
            // include it in the map with value 1 (first occurence)
            } else charCounter[char] = 1
        }

        //listOfValues stores a list of the map values
        var listOfValues = mutableListOf<Int>()
        charCounter.forEach {entry ->
            listOfValues.add(entry.value)
        }

        // a copy is created to play with listOfValues while
        // listOfValues is never changed
        var copy = mutableListOf<Int>()

        // for every item in the list
        for (i in listOfValues.indices){
            // copy is reset to original listOfValues list
            copy = listOfValues.toMutableList()
            // one single item in list is reduced in 1
            copy[i] = copy[i] - 1
            // if that item became zero, it's removed from list
            if (copy[i] == 0) copy.remove(0) 
            // if max and min are equal, all items in list are equal, so return true
            if (copy.max() == copy.min()) return true 
        }
        // if never true, it's false
        return false
    }
}
