package leetcode.leetcode202302;

import java.util.*;

public class leetcode_1797 {
    class AuthenticationManager {

        int ttl;
        Map<String, Integer> tokenMap;

        public AuthenticationManager(int timeToLive) {
            ttl = timeToLive;
            tokenMap = new HashMap<>(16);
        }

        public void generate(String tokenId, int currentTime) {
            tokenMap.put(tokenId, currentTime);
        }

        public void renew(String tokenId, int currentTime) {
            if (tokenMap.getOrDefault(tokenId, -ttl) + ttl > currentTime) {
                tokenMap.put(tokenId, currentTime);
            }
        }

        public int countUnexpiredTokens(int currentTime) {
            int count = 0;
            for (Integer value : tokenMap.values()) {
                if (value + ttl > currentTime) {
                    count++;
                }
            }
            return count;
        }
    }
}
