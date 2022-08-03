package com.mxr.demo;

import java.util.*;

public class Twitter {


    private Map<Integer, Set<Integer>> subs = new HashMap<>();
    private Map<Integer, List<Integer>> feeds = new HashMap<>();
    public Twitter() {

    }

    public void postTweet(int userId, int tweetId) {
        if (!subs.containsKey(userId)) {
            subs.put(userId, new HashSet<>());
        }
        subs.get(userId)
                .forEach(follower -> {
                    if (!feeds.containsKey(follower)) {
                        feeds.put(follower, new ArrayList<>());
                    }
                    feeds.get(follower).add(tweetId);
                });
    }

    public List<Integer> getNewsFeed(int userId) {
        if (!feeds.containsKey(userId)) {
            feeds.put(userId, new ArrayList<>());
        }
        List<Integer> toFeed = feeds.get(userId)
                .stream()
                .limit(10)
                .toList();
        feeds.get(userId).removeAll(toFeed);
        return toFeed;
    }

    public void follow(int followerId, int followeeId) {
        if (!subs.containsKey(followeeId)) {
            subs.put(followeeId, new HashSet<>());
        }
        subs.get(followeeId).add(followerId);
    }

    public void unfollow(int followerId, int followeeId) {
        subs.get(followeeId).remove(followerId);
    }
}
