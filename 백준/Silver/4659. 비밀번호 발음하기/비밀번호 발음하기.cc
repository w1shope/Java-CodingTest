#include <bits/stdc++.h>

using namespace std;

bool isVowel(char c) {
    if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
        return true;
    return false;
}

bool isContainsVowel(string input) {
    for (int i = 0; i < input.length(); i++) {
        if (isVowel(input[i]))
            return true;
    }
    return false;
}

bool isContinuousThree(string input) {
    // 모음 먼저 확인
    int vowel_cnt = 0;
    for (int i = 0; i < input.length(); i++) {
        if (isVowel(input[i]))
            vowel_cnt += 1;
        else
            vowel_cnt = 0;
        if(vowel_cnt == 3)
            return true; // 모음이 연속 3번 오는 경우
    }

    // 자음 확인
    int consonant_cnt = 0;
    for(int i = 0; i < input.length(); i++) {
        if(!isVowel(input[i]))
            consonant_cnt += 1;
        else
            consonant_cnt = 0;
        if(consonant_cnt == 3)
            return true;
    }

    return false;
}

bool isContinuousTwo(string input) {
    char prev = input[0];
    int cnt = 1;
    for(int i = 1; i < input.length(); i++) {
        if(prev == input[i]) {
            cnt++;
        } else {
            prev = input[i];
            cnt = 1;
        }
        if(cnt == 2 && (input[i] != 'o' && input[i] != 'e'))
            return true;
    }
    return false;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    while (true) {
        string input;
        getline(cin, input);
        if (input == "end")
            break;

        if (!isContainsVowel(input) || isContinuousThree(input) || isContinuousTwo(input)) {
            cout << "<" << input << "> is not acceptable." << "\n";
            continue;
        }

        cout << "<" << input << "> is acceptable." << "\n";
    }
}