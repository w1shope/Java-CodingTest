#include <iostream>
#include <string>
#include <algorithm>
#include <climits>

using namespace std;

int wb_cnt(string *input, string *wb, int curX, int curY) {
    int cnt = 0;
    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            if (wb[i][j] != input[curX + i][curY + j])
                cnt++;
        }
    }
    return cnt;
}

int bw_cnt(string *input, string *bw, int curX, int curY) {
    int cnt = 0;
    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            if (bw[i][j] != input[curX + i][curY + j])
                cnt++;
        }
    }
    return cnt;
}

int main() {
    string wb[8] = {
            "WBWBWBWB",
            "BWBWBWBW",
            "WBWBWBWB",
            "BWBWBWBW",
            "WBWBWBWB",
            "BWBWBWBW",
            "WBWBWBWB",
            "BWBWBWBW"
    };
    string bw[8] = {
            "BWBWBWBW",
            "WBWBWBWB",
            "BWBWBWBW",
            "WBWBWBWB",
            "BWBWBWBW",
            "WBWBWBWB",
            "BWBWBWBW",
            "WBWBWBWB"
    };

    int n, m;
    (cin >> n >> m).ignore();

    string input[n];
    for (int i = 0; i < n; i++) {
        getline(cin, input[i]);
    }

    int min_cnt = INT_MAX;
    for (int i = 0; i + 8 <= n; i++) {
        for (int j = 0; j + 8 <= m; j++) {
            min_cnt = min(min_cnt, min(wb_cnt(input, wb, i, j), bw_cnt(input, bw, i, j)));
        }
    }

    if (min_cnt == INT_MAX)
        cout << 0;
    else
        cout << min_cnt;

}