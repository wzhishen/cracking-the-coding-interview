// Implement a function void reverse(char* str) in C
// or C++ which reverses a null terminated string.
void reverse(char* str) {
    if (str == NULL) return;

    char* end = str;
    while (*end) {
        ++end;
    }
    --end;

    char tmp;
    while (str < end) {
        tmp = *str;
        *str = *end;
        *end = tmp;
        ++str;
        --end;
    }
}
