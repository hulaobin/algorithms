package com.hubin.chapter02;

import java.util.*;

public class Alibaba {
    public static void main(String[] args) {
        Alibaba alibaba = new Alibaba();
        List<Treasure> treasures = alibaba.initTreasures();
        int maxWeight = 30;
        Map<String, Double> takeQuietly = alibaba.takeQuietly(treasures, maxWeight);
        for (String next : takeQuietly.keySet()) {
            Double weight = takeQuietly.get(next);
            System.out.println(next + ":" + weight);
        }
    }

    /**
     * @param maxWeight
     * @return Map<String, Double> 用来存储 标号和重量
     */
    private Map<String, Double> takeQuietly(List<Treasure> treasures, int maxWeight) {
        Map<String, Double> takenTreasuresMap = new HashMap<>();
        treasures.sort((o1, o2) -> (int) (o2.avg * 100) - (int) (o1.avg * 100));

        // 定义当前重量
        double nowWeight = 0;
        double nowValue = 0;
        for (Treasure treasure : treasures) {
            System.out.printf(treasure.no + "->");
            if (nowWeight - maxWeight >= 0) {
                break;
            }
            nowWeight += treasure.weight;
            if (nowWeight - maxWeight > 0) {
                // 要暴力破坏了
                double nowRemainingWeight = maxWeight + treasure.weight - nowWeight;
                takenTreasuresMap.put(treasure.no, nowRemainingWeight);
                nowValue += nowRemainingWeight * treasure.avg;
            } else {
                takenTreasuresMap.put(treasure.no, treasure.weight);
                nowValue += treasure.value;
            }
        }
        System.out.println("当前最大价值为" + nowValue);

        return takenTreasuresMap;
    }


    private List<Treasure> initTreasures() {
        List<Treasure> treasures = new ArrayList<>();
        treasures.add(new Treasure("1", 4, 3));
        treasures.add(new Treasure("2", 2, 8));
        treasures.add(new Treasure("3", 9, 18));
        treasures.add(new Treasure("4", 5, 6));
        treasures.add(new Treasure("5", 5, 8));
        treasures.add(new Treasure("6", 8, 20));
        treasures.add(new Treasure("7", 5, 5));
        treasures.add(new Treasure("8", 4, 6));
        treasures.add(new Treasure("9", 5, 7));
        treasures.add(new Treasure("10", 5, 15));

        return treasures;
    }

    class Treasure {
        private String no;
        private double weight;
        private double value;
        private double avg;

        public Treasure(String no, double weight, double value) {
            this.no = no;
            this.weight = weight;
            this.value = value;
            this.avg = this.value / this.weight;
        }

        public String getNo() {
            return no;
        }


        public double getWeight() {
            return weight;
        }

        public double getValue() {
            return value;
        }

        public double getAvg() {
            return avg;
        }
    }
}
