package com.mxr.demo;

import java.util.*;

public class Problem2115 {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, Set<String>> ins = new HashMap<>();
        Map<String, Set<String>> outs = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            Set<String> set = new HashSet<>();
            set.addAll(ingredients.get(i));
            ins.put(recipe, set);

            for (String ingredient: ingredients.get(i)) {
                if (!outs.containsKey(ingredient)) {
                    outs.put(ingredient, new HashSet<>());
                }
                outs.get(ingredient).add(recipe);
            }
        }
        Queue<String> currents = new LinkedList<>();
        currents.addAll(List.of(supplies));
        List<String> result = new LinkedList<>();
        Set<String> targets = new HashSet<>();
        targets.addAll(List.of(recipes));
        while (!currents.isEmpty()) {
            String ingredient = currents.poll();
            if (targets.contains(ingredient)) {
                result.add(ingredient);
            }
            if (!outs.containsKey(ingredient)) {
                continue;
            }
            for (String out: outs.get(ingredient)) {
                ins.get(out).remove(ingredient);
                if (ins.get(out).isEmpty()) {
                    currents.add(out);
                }
            }
        }

        return result;
    }
}
