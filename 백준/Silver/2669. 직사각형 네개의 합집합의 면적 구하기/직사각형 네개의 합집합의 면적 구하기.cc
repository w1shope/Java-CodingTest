#include <iostream>

using namespace std;

int graph[101][101];

void update(int x1, int x2, int y1, int y2) {
    for (int y = y1; y < y2; y++) {
        for (int x = x1; x < x2; x++) {
            graph[y][x] = 1;
        }
    }
}

int main() {
    for (int i = 0; i < 4; i++) {
        int x1, y1, x2, y2;
        cin >> x1 >> y1 >> x2 >> y2;
        update(x1, x2, y1, y2);
    }

    int sum = 0;
    for (int i = 1; i <= 100; i++) {
        for (int j = 1; j <= 100; j++) {
            if (graph[i][j] != 0) {
                sum += 1;
            }
        }
    }

    cout << sum;
}