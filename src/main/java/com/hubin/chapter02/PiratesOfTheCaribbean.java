package com.hubin.chapter02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PiratesOfTheCaribbean {
    public static void main(String[] args) {
        PiratesOfTheCaribbean piratesOfTheCaribbean = new PiratesOfTheCaribbean();
        List<Antique> antiques = piratesOfTheCaribbean.initAntiques();

        int maxWeight = 6000;
        if (args.length > 0) {
            String arg0 = args[0];
            maxWeight = Integer.parseInt(arg0);
        }

        System.out.println(piratesOfTheCaribbean.loot(antiques, maxWeight));
    }

    /**
     * 开始抢了哈
     *
     * @param allAntiques
     * @param maxWeight 最大重量
     */
    private int loot(List<Antique> allAntiques, Integer maxWeight) {
        int maxCount = 0;
        // 按重量小->大排序
        allAntiques.sort(Comparator.comparingDouble(o -> o.weight));
        Integer nowWeight = 0;
        for (Antique antique : allAntiques) {
            nowWeight += antique.weight;
            // 如果超过了最大重量 就不能装船了
            if (maxWeight <= nowWeight) {
                break;
            }
            System.out.println(antique.toString());
            maxCount++;
        }
        return maxCount;
    }


    /**
     * 船上的古董
     *
     * @return
     */
    private List<Antique> initAntiques() {
        List<Antique> antiques = new ArrayList<>();
        antiques.add(new Antique(1000, "金丝八宝攒珠髻"));
        antiques.add(new Antique(800, "双虎头玉璜"));
        antiques.add(new Antique(300, "斗彩团花碗"));
        antiques.add(new Antique(200, "玛瑙鼻烟壶"));
        antiques.add(new Antique(2400, "白玉转心莲子瓶"));
        antiques.add(new Antique(800, "沉香木笔筒"));
        antiques.add(new Antique(1800, "珐琅瓷"));
        antiques.add(new Antique(2800, "刻诗龙纹玉瓶"));

        return antiques;
    }

    class Antique {
        /**
         * 重量 克
         */
        private Integer weight;
        /**
         * 名称
         */
        private String name;


        public Antique(Integer weight, String name) {
            this.weight = weight;
            this.name = name;
        }

        public Integer getWeight() {
            return weight;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return this.name + ":" + this.weight;
        }
    }
}
