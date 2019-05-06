#include<stdio.h>
#include <stdbool.h>

//to replace multiple spaces with single spaces

int main() {
	int i;
	char ch;
	bool flag = false;
	for(i = 0; i < (ch=getchar()) != '\0'; i++) {
		if(ch == ' '){
			if (!flag) {
				flag = true;
				printf("%c",ch);
			}
		} else{
			flag = false;
			printf("%c", ch);
		}
	}
	
}
