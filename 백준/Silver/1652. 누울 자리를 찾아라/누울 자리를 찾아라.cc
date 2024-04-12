#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int n;
    (cin >> n).ignore();

    char room[n][n];
    for(int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++)
            cin >> room[i][j];
    }

    int garo = 0;
    for(int i = 0; i < n; i++) {
        int cnt = 0;
        bool flag = false;
        for(int j =0; j < n; j++) {
            if(room[i][j] == '.')
                cnt++;
            else if(room[i][j] == 'X'){
                cnt = 0;
                flag = false;
            }
            if(cnt == 2 && !flag) {
                garo++;
                cnt = 0;
                flag = true;
            }
        }
    }

    int sero = 0;
    for(int j = 0; j < n; j++) {
        int cnt = 0;
        bool flag = false;
        for(int i = 0; i < n; i++) {
            if(room[i][j] == '.')
                cnt++;
            else if(room[i][j] == 'X') {
                cnt = 0;
                flag = false;
            }
            if(cnt == 2 && !flag) {
                sero++;
                cnt = 0;
                flag = true;
            }
        }
    }

    cout << garo << " " << sero;
}