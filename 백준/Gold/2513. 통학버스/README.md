# [Gold III] 통학버스 - 2513 

[문제 링크](https://www.acmicpc.net/problem/2513) 

### 성능 요약

메모리: 29240 KB, 시간: 408 ms

### 분류

그리디 알고리즘, 정렬

### 제출 일자

2025년 7월 12일 19:01:37

### 문제 설명

<p>주택난을 해결하기 위해서 직선 도로 하나를 따라 여러 아파트 단지들을 지었다. 또, 이 아파트 단지 주민을 위해 도로 위 한 지점에 학교 하나를 신설하였다. 아파트 단지들이 서로 멀리 떨어져 있기 때문에 반드시 통학버스를 이용해서만 다닐 수 있고, 통학버스는 한 대이다.</p>

<p>각각의 아파트 단지와 학교의 위치는 도로 위의 좌표로 주어지며, 또 각 아파트 단지마다 여기에 사는 학생들의 수도 주어진다. 통학버스는 아침에 학교를 출발하여 각 아파트 단지에 있는 학생들을 태우고 학교로 다시 돌아온다. 이 통학버스는 정원을 초과하여 학생을 태울 수 없고, 모든 학생을 등교시킬 때까지 이 과정을 반복한다. </p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/636f2f28-7c2e-45fc-8fdb-010db25c8a4d/-/preview/" style="width: 337px; height: 126px;"></p>

<p>위 규칙을 따라서 모든 학생들을 학교에 등교시키는 예를 보자. 아파트 단지 A, B, C가 각각 좌표 0, 2, 5에 있고 이 단지에 사는 학생은 각각 1, 2, 1명이라고 하자. 두 지점 간의 거리는 두 지점 좌표의 차이로 정의된다. 최대 4명이 탈 수 있는 통학버스가 좌표 4에 있는 학교에서 출발해서 모든 학생들을 등교시킬 때, 버스는 먼저 단지 B를 들러 2명을 태우고, 단지 A를 들러서 1명을 태우고 다시 학교로 돌아온다면 이동 거리는 2 + 2 + 4 = 8이다. 다시 학교에서 아파트 단지 C로 이동하여 1명을 태우고 돌아오면 이동 거리는 1 + 1 = 2가 되고, 총 이동거리는 8 + 2 = 10이 된다. </p>

<p>학교의 위치, 각각의 아파트 단지의 위치와 학생 수, 통학버스의 정원이 주어졌을 때, 모든 학생을 등교시키는데 필요한 통학버스의 총 이동 거리의 최솟값을 계산하는 프로그램을 작성하시오. </p>

### 입력 

 <p>첫째 줄에는 세 개의 양의 정수 N, K, S가 빈칸을 사이에 두고 순서대로 주어진다. 첫 번째 정수 N은 아파트 단지의 수이며 2 ≤ N ≤ 30,000이다. 두 번째 정수 K는 1 ≤ K ≤ 2,000이며, 통학버스의 정원이다. 세 번째 정수 S는 학교의 위치를 나타낸다. 둘째 줄부터 N+1번째 줄에는 각 아파트 단지의 위치를 나타내는 정수와 이 단지에 사는 학생 수를 나타내는 정수가 빈칸을 사이에 두고 주어진다. 학교와 아파트 단지의 좌표는 0 이상 100,000 이하이며, 이 좌표들은 모두 서로 다르다. 각 아파트 단지의 학생 수는 1 이상 2,000 이하이다. </p>

### 출력 

 <p>첫째 줄에 주어진 입력에서 통학버스의 최소 이동 거리를 출력한다. 최소 이동 거리가 1,000,000,000을 초과하는 경우는 없다.  </p>

