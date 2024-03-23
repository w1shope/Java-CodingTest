#include <iostream>

using namespace std;

int white[100][100];

void paintBlack(int x, int y) {
    for (int i = y; i < y + 10; i++) {
        for (int j = x; j < x + 10; j++) {
            white[i][j] = 1;
        }
    }
}

int main() {
    int n;
    scanf("%d", &n);

    for (int i = 0; i < n; i++) {
        int x, y;
        cin >> x >> y;
        paintBlack(x, y);
    }

    int area = 0;
    for (int i = 0; i < 100; i++) {
        for (int j = 0; j < 100; j++) {
            if(white[i][j] == 1) {
                area += 1;
            }
        }
    }

    cout << area;
}