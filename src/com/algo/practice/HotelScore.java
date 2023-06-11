package com.algo.practice;

import javafx.scene.layout.Priority;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class HotelScore {

    public static class Pair{
        int hotel;
        int score;

        public Pair(int hotel, int score) {
            this.hotel = hotel;
            this.score = score;
        }
    }

    public static void main(String args[]){
        Set<String> wantedWords =  new HashSet<>(Arrays.asList("breakfast","beac","citycenter","location","metro", "view", "staff", "price"));
        List<String> list = new ArrayList<>(
                Arrays.asList(
                        "1",
                        "This hotel has a nice view of the citycenter. The location is perfect",
                        "2",
                        "The breakfast is ok. Regarding location, it is quite far from citycenter but price is cheap so it is worth.",
                        "1",
                        "Location is excellent, 5 minutes from citycenter. There is also a metro station very close to the hotel.",
                        "1",
                        "They said I couldn't take my dog and there were other guests with dogs! That is not fair.",
                        "2",
                        "Very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter."
        ));

        HashMap<Integer, List<String>> reviews = new HashMap<>();
        PriorityQueue<Pair> score = new PriorityQueue<>((a,b)-> {
            if (b.score-a.score !=0 )
                return b.score-a.score;
            else
                return a.hotel-b.hotel;
        });

        for(int i = 0;i< list.size();i=i+2){
            int hotelId = Integer.parseInt(list.get(i));
            String review = list.get(i+1);
            if(reviews.containsKey(hotelId)){
                reviews.get(hotelId).add(review);
            }
            else{
                reviews.put(hotelId, new ArrayList<>(Collections.singletonList(review)));
            }
        }
        for(Map.Entry<Integer, List<String>> entry: reviews.entrySet()){
            int hotelId = entry.getKey();
            int count = 0;
            for(int i=0;i<entry.getValue().size();i++){
                String r = entry.getValue().get(i);

                r = r.replace(",","");
                r = r.replace(".","");
                String [] words = r.split(" ");
                for(int j =0;j<words.length;j++){
                    if(wantedWords.contains(words[j].toLowerCase())){
                        count++;
                    }
                }
            }
            score.add(new Pair(hotelId, count));
        }

        score.forEach(e-> System.out.println(e.hotel));
    }
}
