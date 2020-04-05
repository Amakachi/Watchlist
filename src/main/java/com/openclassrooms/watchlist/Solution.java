package com.openclassrooms.watchlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        int[] sequence = {1, 2, 3, 4, 3, 6};
        List<Integer> newSequence = Arrays.stream(sequence).boxed().collect(Collectors.toList());
        newSequence = newSequence.stream().distinct().collect(Collectors.toList());
        System.out.println(newSequence);


    }
    boolean almostIncreasingSequence(int[] sequence) {

        List<Integer> newSequence = Arrays.stream(sequence).boxed().collect(Collectors.toList());
        newSequence = newSequence.stream().distinct().collect(Collectors.toList());


        int i = 0, count = 0;
        while (i < newSequence.size() - 1) {
            if (newSequence.get(i) >= newSequence.get(i + 1) && i == newSequence.size() - 2) {
                if (count == 0) {
                    newSequence.remove(i + 1);
                    count++;
                    break;
                }
            }
            if (newSequence.get(i) >= newSequence.get(i + 1)) {
                if (count == 0) {
                    newSequence.remove(i);
                    count++;
                } else {
                    return false;
                }
            }
            i++;
        }

        return checkIfIncreasing(newSequence);
    }

         boolean checkIfIncreasing(List<Integer> newSequence){
            for(int i = 0; i < newSequence.size() - 1; i++){
                if(newSequence.get(i) >= newSequence.get(i + 1)){
                    return false;
                }
            }
            return true;
        }
}