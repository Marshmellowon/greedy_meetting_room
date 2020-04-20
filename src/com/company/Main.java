package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n; /*회의 개수*/
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); /*회의 수 입력 받기*/
        meet[] meeting = new meet[n]; //회의시간 조합 개수

        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int f = sc.nextInt();
            meeting[i] = new meet(s, f); /*시작시간 끝 시간 조합*/
        }

        int count = 1; /*기준 카운트 1*/
        int f = meeting[0].f;
        for (int i = 0; i < n; i++) {
            if (meeting[i].s >= f) { /*i번 회의의 start가 fin보다 크거나 같으면 +1카운트*/
                count++;
                f = meeting[i].f; /*fin이 i번 회의 fin과 같으면 +1*/
            }
        }
        System.out.println(count);
    }
}

class meet implements Comparable<meet> {
    int s; /*시작시간*/
    int f; /*끝나는 시간*/

    meet(int a, int b) {
        this.s = a;
        this.f = b;
    }

    @Override
    public int compareTo(meet o) {
        int re = this.f - o.f;
        if (re == 0) {
            re = this.s - o.s;
        }
        return re;
    }
}