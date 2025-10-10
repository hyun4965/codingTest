import java.util.*;

class Solution {
    //t초동안 매초 x만큼 회복, t초 연속으로 붕대 -> y만큼 추가 
    //회복동안 공격당하면 0으로 초기화. 현재체력 < 0 -> 사망
    //bandage : 사전시간/ 초당 회복량 / 추가회복량
    //health : 최대체력
    //attacks : 공격시간 / 피해량
    public int solution(int[] bandage, int health, int[][] attacks) {
        int t = bandage[0]; // 연속 시전 시간
        int x = bandage[1]; // 초당 회복량
        int y = bandage[2]; // t초 성공 시 추가 회복
        int maxHP = health; // 최대 체력
        int hp = health;    // 현재 체력

        int lastTime = attacks[attacks.length - 1][0]; // 마지막 공격 시간
        int index = 0;
        int streak = 0; //연속성공

        for (int time = 1; time <= lastTime; time++) {
            if (index < attacks.length && attacks[index][0] == time) {
                hp -= attacks[index][1];
                if (hp <= 0) {
                    return -1;
                }
                streak = 0;
                index++;
            } else {
                hp += x;
                if (hp > maxHP) {
                    hp = maxHP;
                }

                streak++;

                if (streak == t) {
                    hp += y;
                    if (hp > maxHP) {
                        hp = maxHP;
                    }
                    streak = 0;
                }
            }
        }

        return hp;
    }
}