#include<stdio.h>

//to reverse a string

int main() {
	char s[100];
	int len = 0, i,j;
	gets(s);
	for(i = 0; s[i] != '\0'; i++) {
		len++;
	}
	for(i = 0,j = len - 1; (i <= len/2) && (j > len/2); i++, j--) {
		char temp = s[i];
		s[i] = s[j];
		s[j] = temp;
	}
	printf("%s", s);
}
