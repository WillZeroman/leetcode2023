package io.github.willzeroman;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationManager {

    private int timeToLive;

    private Map<String, Integer> map = new HashMap<>();

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, currentTime);
    }

    public void renew(String tokenId, int currentTime) {
        Integer oldTime = map.get(tokenId);
        if (oldTime != null && oldTime + timeToLive > currentTime) {
            map.put(tokenId, currentTime);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        for (String tokenId : map.keySet()) {
            int oldTime = map.get(tokenId);
            if (oldTime + timeToLive > currentTime) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        AuthenticationManager authenticationManager = new AuthenticationManager(5); // 构造
        // AuthenticationManager ，设置 timeToLive = 5 秒。
        authenticationManager.renew("aaa", 1); // 时刻 1 时，没有验证码的 tokenId 为 "aaa" ，没有验证码被更新。
        authenticationManager.generate("aaa", 2); // 时刻 2 时，生成一个 tokenId 为 "aaa" 的新验证码。
        int res = authenticationManager.countUnexpiredTokens(6); // 时刻 6 时，只有 tokenId 为 "aaa"
        // 的验证码未过期，所以返回 1 。
        System.out.println(res);
        authenticationManager.generate("bbb", 7); // 时刻 7 时，生成一个 tokenId 为 "bbb" 的新验证码。
        authenticationManager.renew("aaa", 8); // tokenId 为 "aaa" 的验证码在时刻 7 过期，且 8 >= 7 ，所以时刻 8
        // 的renew 操作被忽略，没有验证码被更新。
        authenticationManager.renew("bbb", 10); // tokenId 为 "bbb" 的验证码在时刻 10 没有过期，所以 renew
        // 操作会执行，该 token 将在时刻 15 过期。
        res = authenticationManager.countUnexpiredTokens(15); // tokenId 为 "bbb" 的验证码在时刻 15
        // 过期，tokenId 为 "aaa" 的验证码在时刻 7 过期，所有验证码均已过期，所以返回 0 。
        System.out.println(res);
    }
}
